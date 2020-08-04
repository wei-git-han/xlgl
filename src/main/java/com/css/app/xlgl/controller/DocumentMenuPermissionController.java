package com.css.app.xlgl.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

import com.css.addbase.apporgan.entity.BaseAppUser;
import com.css.addbase.apporgan.service.BaseAppOrganService;
import com.css.addbase.apporgan.service.BaseAppUserService;
import com.css.addbase.apporgmapped.service.BaseAppOrgMappedService;
import com.css.app.xlgl.entity.DocumentMenu;
import com.css.app.xlgl.entity.DocumentMenuPermission;
import com.css.app.xlgl.service.DocumentMenuPermissionService;
import com.css.app.xlgl.service.DocumentMenuService;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.GwPageUtils;
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
 * @date 2020-08-04 16:13:34
 */
@Controller
@RequestMapping("/documentmenupermission")
public class DocumentMenuPermissionController {
	@Autowired
	private DocumentMenuPermissionService documentMenuPermissionService;
	@Autowired
	private BaseAppOrganService baseAppOrganService;
	@Autowired
	private BaseAppUserService baseAppUserService;
	@Autowired
	private BaseAppOrgMappedService baseAppOrgMappedService;
	@Autowired
	private DocumentMenuService documentMenuService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("documentmenupermission:list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<DocumentMenuPermission> documentMenuPermissionList = documentMenuPermissionService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(documentMenuPermissionList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	@RequiresPermissions("documentmenupermission:info")
	public void info(@PathVariable("id") String id){
		DocumentMenuPermission documentMenuPermission = documentMenuPermissionService.queryObject(id);
		Response.json("documentMenuPermission", documentMenuPermission);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	@RequiresPermissions("documentmenupermission:save")
	public void save(@RequestBody DocumentMenuPermission documentMenuPermission){
		documentMenuPermission.setId(UUIDUtils.random());
		documentMenuPermissionService.save(documentMenuPermission);
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("documentmenupermission:update")
	public void update(@RequestBody DocumentMenuPermission documentMenuPermission){
		documentMenuPermissionService.update(documentMenuPermission);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("documentmenupermission:delete")
	public void delete(@RequestBody String[] ids){
		documentMenuPermissionService.deleteBatch(ids);
		
		Response.ok();
	}
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/usermenulist")
	public void usermenulist(Integer page, Integer pagesize,String deptid){
		List<Map<String, Object>> retList = new ArrayList<Map<String, Object>>();
		if (StringUtils.isEmpty(deptid)) {
			deptid = baseAppOrgMappedService.getBareauByUserId(CurrentUser.getUserId());
		}
		List<BaseAppUser> users = baseAppUserService.findByOrganid(deptid);
		//List<Menu> menuList = menuService.queryList(new HashMap<String, Object>());
		Map<String, Object> map = new HashMap<String, Object>();
		for (BaseAppUser user:users) {
			map.put("userId", user.getId());
			List<DocumentMenuPermission> list = documentMenuPermissionService.queryList(map);
			List<DocumentMenu> menuList = documentMenuService.queryList(new HashMap<String, Object>());
			Map<String, Object> tep = new HashMap<String, Object>();
			tep.put("id", user.getId());
			tep.put("truename", user.getTruename());
			tep.put("work", "");
			tep.put("departmentName",baseAppOrganService.queryObject(user.getOrganid()).getName());
			tep.put("menuList", menuList);
			tep.put("children", list);
			retList.add(tep);
		}
		GwPageUtils pageUtil = new GwPageUtils(retList);
		Response.json(pageUtil);
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
				documentMenuPermissionService.save(vo);
			}
		}
		
		
		Response.json("result","success");
	}
	
}
