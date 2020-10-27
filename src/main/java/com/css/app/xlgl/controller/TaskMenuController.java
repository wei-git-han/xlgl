package com.css.app.xlgl.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.css.app.xlgl.service.XlglAdminSetService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.css.app.xlgl.entity.DocumentMenuPermission;
import com.css.app.xlgl.entity.TaskMenu;
import com.css.app.xlgl.service.DocumentMenuPermissionService;
import com.css.app.xlgl.service.TaskMenuService;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.PageUtils;
import com.css.base.utils.UUIDUtils;
import com.github.pagehelper.PageHelper;
import com.css.base.utils.Response;
import com.css.base.utils.StringUtils;
import org.unbescape.css.CssIdentifierEscapeLevel;


/**
 * @author 中软信息系统工程有限公司
 * @email
 * @date 2020-08-05 13:46:02
 */
@Controller
@RequestMapping("/app/xlgl/taskmenu")
public class TaskMenuController {
    @Autowired
    private TaskMenuService taskMenuService;
    @Autowired
    private DocumentMenuPermissionService documentMenuPermissionService;
    @Autowired
    private XlglAdminSetService adminSetService;

    /**
     * 列表
     */
    @ResponseBody
    @RequestMapping("/list")
    @RequiresPermissions("taskmenu:list")
    public void list(Integer page, Integer limit) {
        Map<String, Object> map = new HashMap<>();
        PageHelper.startPage(page, limit);

        //查询列表数据
        List<TaskMenu> taskMenuList = taskMenuService.queryList(map);

        PageUtils pageUtil = new PageUtils(taskMenuList);
        Response.json("page", pageUtil);
    }


    /**
     * 信息
     */
    @ResponseBody
    @RequestMapping("/info/{menuId}")
    @RequiresPermissions("taskmenu:info")
    public void info(@PathVariable("menuId") String menuId) {
        TaskMenu taskMenu = taskMenuService.queryObject(menuId);
        Response.json("taskMenu", taskMenu);
    }

    /**
     * 保存
     */
    @ResponseBody
    @RequestMapping("/save")
    @RequiresPermissions("taskmenu:save")
    public void save(@RequestBody TaskMenu taskMenu) {
        taskMenu.setMenuId(UUIDUtils.random());
        taskMenuService.save(taskMenu);

        Response.ok();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("taskmenu:update")
    public void update(@RequestBody TaskMenu taskMenu) {
        taskMenuService.update(taskMenu);

        Response.ok();
    }

    /**
     * 删除
     */
    @ResponseBody
    @RequestMapping("/delete")
    @RequiresPermissions("taskmenu:delete")
    public void delete(@RequestBody String[] menuIds) {
        taskMenuService.deleteBatch(menuIds);

        Response.ok();
    }

    /**
     * 保存
     */
    @ResponseBody
    @RequestMapping("/permissionsave")
    public void permissionsave(String uid, String param) {
        if (uid != null && !"".equals(uid)) {
            documentMenuPermissionService.deleteByUserId(uid);
        }
        if (param != null && !"".equals(param)) {
            String ids[] = param.split(",");
            DocumentMenuPermission vo = new DocumentMenuPermission();
            for (String id : ids) {
                vo.setId(UUIDUtils.random());
                vo.setUserId(uid);
                vo.setMenuId(id.replace("&" + uid + "&", ""));
                vo.setCreator(CurrentUser.getUserId());
                vo.setCreatedTime(new Date());
                documentMenuPermissionService.save(vo);
            }
        }
        Response.json("result", "success");
    }

    /**
     * 配置里所有的菜单选项
     *
     * @return
     */
    @RequestMapping(value = "/menutree4role")
    @ResponseBody
    public Object getMenuTree() {
        JSONArray list = getOrganTree("root");
        return list;
    }

    public JSONArray getOrganTree(String id) {
        JSONArray jsons = new JSONArray();
        List<TaskMenu> menus = taskMenuService.findByParentId(id);
        for (TaskMenu menu : menus) {
            JSONObject json = new JSONObject();
            json.put("id", menu.getMenuId());
            json.put("text", menu.getDisplayName());
            JSONArray children = getOrganTree(menu.getMenuId());
            if (children.size() > 0) {
                json.put("children", children);
            }
            jsons.add(json);
        }
        return jsons;
    }

    /**
     * 登录人所能显示的菜单
     */
    @RequestMapping(value = "/auth")
    @ResponseBody
    public void authMenu() {
        List<TaskMenu> menus = taskMenuService.queryAuthList(CurrentUser.getUserId());
        JSONArray jsons = getMenuChildren(menus, "root");
        /////////////////////////////////////////////////
        //获取当前人的管理员类型（0:超级管理员 ;1：部管理员；2：局管理员；3：即是部管理员又是局管理员;4:处管理员）
        String adminFlag = adminSetService.getAdminTypeByUserId(CurrentUser.getUserId());
        if("4".equals(adminFlag)){//处管理员只显示处管理员配置菜单
            JSONObject jsonObject = jsons.getJSONObject(4);
            JSONArray jsonArray = (JSONArray) jsonObject.get("children");
            jsonArray.remove(0);
            jsonArray.remove(0);
            jsonArray.remove(1);
            jsonArray.remove(1);
            //jsonArray.remove(1);
            System.out.println(jsonArray);
        }else if("2".equals(adminFlag) && !"1".equals(adminFlag)){//局管理员显示局管理员配置和处管理员配置菜单
            JSONObject jsonObject = jsons.getJSONObject(4);
            JSONArray jsonArray = (JSONArray) jsonObject.get("children");
            jsonArray.remove(0);//这么写的原因是，每次删除一个，集合长度就变了，得按新的集合来删
            jsonArray.remove(2);
            jsonArray.remove(2);
            //jsonArray.remove(2);
            //jsonArray.remove(1);
            System.out.println(jsonArray);
        }else if("1".equals(adminFlag) || "".equals(adminFlag)){//部管理员显示所有
            jsons = jsons;
        }
        if(!"".equals(adminFlag)) {
            if (!"1".equals(adminFlag)) {//非部管理员不显示体育成绩导入和自学成绩导入菜单
                JSONArray jsonArray = (JSONArray) jsons.getJSONObject(0).get("children");
                JSONArray jsonArray1 = (JSONArray) jsonArray.getJSONObject(7).get("children");
                jsonArray1.remove(0);
                jsonArray1.remove(0);

                if("2".equals(adminFlag)){
                    JSONArray jsonArray2 = (JSONArray) jsons.getJSONObject(4).get("children");
                    jsonArray2.remove(3);
                }

            }
            if (!"1".equals(adminFlag)) {//非部管理员，只显示考核清单菜单
                JSONArray jsonArray = (JSONArray) jsons.getJSONObject(0).get("children");
                JSONArray jsonArray1 = (JSONArray) jsonArray.getJSONObject(6).get("children");
                jsonArray1.remove(1);
                jsonArray1.remove(1);
            }
        }else {
            //非部管理员不显示体育成绩导入和自学成绩导入菜单
            JSONArray jsonArray = (JSONArray) jsons.getJSONObject(0).get("children");
            JSONArray jsonArray1 = (JSONArray) jsonArray.getJSONObject(7).get("children");
            jsonArray1.remove(1);
            jsonArray1.remove(1);
            //非部管理员，只显示考核清单菜单
            JSONArray jsonArraySix = (JSONArray) jsons.getJSONObject(0).get("children");
            JSONArray jsonArray6 = (JSONArray) jsonArray.getJSONObject(6).get("children");
            jsonArray6.remove(1);
            jsonArray6.remove(1);

            jsons.remove(4);
        }



        /////////////////////////////
        Response.json(jsons);

    }
//////
    public JSONArray getMenuChildren(List<TaskMenu> menus, String parentId) {

        JSONArray jsons = new JSONArray();
        for (TaskMenu menu : menus) {
            if (StringUtils.equals(parentId, menu.getParentId())) {
                JSONObject json = new JSONObject();
                json.put("id", menu.getMenuId());
                json.put("text", menu.getDisplayName());
                json.put("component", menu.getDefaultPage());
                json.put("icon",menu.getIcon());
                json.put("path",menu.getPath());
                JSONArray children = getMenuChildren(menus, menu.getMenuId());
                if (children.size() > 0) {
                    json.put("children", children);
                }
                jsons.add(json);
            }
        }
        return jsons;
    }

    /**
     * 判断登录人是否有权限
     */
    @ResponseBody
    @RequestMapping("/getIsHavePerssion")
    public void getIsHavePerssion(){
        Map<String,Object> map = new HashMap<>();
        String userId = CurrentUser.getUserId();
        map.put("userId",userId);
        List<DocumentMenuPermission> list = documentMenuPermissionService.queryList(map);
        if(list != null && list.size() > 0){
            Response.json("result","success");
        }else {
            Response.json("result","fail");
        }

    }

    /**
     * 获取某人的菜单权限
     * @param userId
     */
    @ResponseBody
    @RequestMapping("/getPeoplePermissionList")
    public void getPeoplePermissionList(String userId){
        List<String> list = documentMenuPermissionService.queryAllList(userId);
        if(list != null && list.size() > 0){
            Response.json("result",list);
        }else{
            Response.json("result","no");
        }
    }

}
