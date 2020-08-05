package com.css.app.xlgl.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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


/**
 * 
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-05 13:46:02
 */
@Controller
@RequestMapping("/taskmenu")
public class TaskMenuController {
	@Autowired
	private TaskMenuService taskMenuService;
	@Autowired
	private DocumentMenuPermissionService documentMenuPermissionService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("taskmenu:list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<TaskMenu> taskMenuList = taskMenuService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(taskMenuList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{menuId}")
	@RequiresPermissions("taskmenu:info")
	public void info(@PathVariable("menuId") String menuId){
		TaskMenu taskMenu = taskMenuService.queryObject(menuId);
		Response.json("taskMenu", taskMenu);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	@RequiresPermissions("taskmenu:save")
	public void save(@RequestBody TaskMenu taskMenu){
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
	public void update(@RequestBody TaskMenu taskMenu){
		taskMenuService.update(taskMenu);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("taskmenu:delete")
	public void delete(@RequestBody String[] menuIds){
		taskMenuService.deleteBatch(menuIds);
		
		Response.ok();
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/permissionsave")
	public void permissionsave(String uid,String param){
		if(uid != null && !"".equals(uid)){
			documentMenuPermissionService.deleteByUserId(uid);
		}
		if(param != null && !"".equals(param)){
			String ids[] = param.split(",");
			DocumentMenuPermission vo = new DocumentMenuPermission();
			for(String id :ids){
				vo.setId(UUIDUtils.random());
				vo.setUserId(uid);
				vo.setMenuId(id.replace("&"+uid+"&", ""));
				vo.setCreator(CurrentUser.getUserId());
				vo.setCreatedTime(new Date());
				documentMenuPermissionService.save(vo);
			}
		}
		Response.json("result","success");
	}
	
	/**
	 * 配置里所有的菜单选项
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/menutree4role")
	@ResponseBody
	public Object getMenuTree(HttpServletRequest request) {
		JSONArray list=  getOrganTree("root");
		return list;
	}
	
	public JSONArray getOrganTree(String id){
		JSONArray jsons = new JSONArray();
		List<TaskMenu> menus = taskMenuService.findByParentId(id);
		for (TaskMenu menu:menus) {
			JSONObject json = new JSONObject();
			json.put("id", menu.getMenuId());
			json.put("text", menu.getDisplayName());
			JSONArray children=getOrganTree(menu.getMenuId());
			if (children.size() > 0) {
				json.put("children", children);
			}
		    jsons.add(json);
		}
		return jsons;
	}
	
	/**
	 * 初始化时查出要显示的菜单
	 */
	@RequestMapping(value = "/auth")
	@ResponseBody
	public void authMenu() {
		List<TaskMenu> menus = taskMenuService.queryAuthList(null);
		JSONArray jsons = getMenuChildren(menus, "root");
		Response.json(jsons);

	}
	
public JSONArray getMenuChildren(List<TaskMenu> menus,String parentId){
		
		JSONArray jsons = new JSONArray();
		for (TaskMenu menu:menus) {
			if (StringUtils.equals(parentId, menu.getParentId())) {
				JSONObject json = new JSONObject();
				json.put("id", menu.getMenuId());
				json.put("text",menu.getDisplayName());
				json.put("href",menu.getDefaultPage());
				JSONArray children = getMenuChildren(menus,menu.getMenuId());
				if (children.size()>0) {
					json.put("children", children);
				}
				jsons.add(json);
			}
		}
		return jsons;
	}
	
}
