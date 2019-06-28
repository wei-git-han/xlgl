package com.css.app.db.config.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.css.addbase.apporgan.entity.BaseAppOrgan;
import com.css.addbase.apporgan.entity.BaseAppUser;
import com.css.addbase.apporgan.service.BaseAppOrganService;
import com.css.addbase.apporgan.service.BaseAppUserService;
import com.css.app.db.business.service.DocumentSzpsService;
import com.css.app.db.config.entity.RoleSet;
import com.css.app.db.config.service.RoleSetService;
import com.css.app.db.util.DbDefined;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.GwPageUtils;
import com.css.base.utils.Response;
import com.css.base.utils.UUIDUtils;
import com.github.pagehelper.PageHelper;


/**
 * 角色设置表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-19 10:22:36
 */
@Controller
@RequestMapping("/app/db/roleset")
public class RoleSetController {
	@Autowired
	private RoleSetService roleSetService;
	@Autowired
	private BaseAppOrganService baseAppOrganService;
	
	@Autowired
	private BaseAppUserService baseAppUserService;
	
	@Autowired
	private DocumentSzpsService documentSzpsService;
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	public void list(Integer page, Integer pagesize){
		String deptId = baseAppUserService.getBareauByUserId(CurrentUser.getUserId());
		Map<String, Object> map = new HashMap<>();
		map.put("roleParam", "roleParam");
		if(StringUtils.isNotBlank(deptId)) {
			map.put("deptId", deptId);
		}
		PageHelper.startPage(page, pagesize);
		List<RoleSet> roleSetList = roleSetService.queryList(map);
		GwPageUtils pageUtil = new GwPageUtils(roleSetList);
		Response.json(pageUtil);
	}
	/**
	 * 登记录入获取首长
	 */
	@ResponseBody
	@RequestMapping("/querySzList")
	public void querySzList(){
		Map<String, Object> map = new HashMap<>();
		map.put("roleFlag", DbDefined.ROLE_1);
		List<RoleSet> roleSetList = roleSetService.queryList(map);
		Response.json(roleSetList);
	}
	
	/**
	 * @description:办理反馈高级筛选首长选择树
	 * @author:zhangyw
	 * @date:2019年6月20日
	 * @Version v1.0
	 */
	@ResponseBody
	@RequestMapping("/queryLeaderTree")
	public void queryLeaderTree(){
		JSONArray array=new JSONArray();
		Map<String, Object> map = new HashMap<>();
		map.put("roleFlag", DbDefined.ROLE_1);
		List<RoleSet> roleSetList = roleSetService.queryList(map);
		for (RoleSet roleSet : roleSetList) {
			JSONObject json=new JSONObject();
			json.put("id", roleSet.getUserId());
			json.put("text", roleSet.getUserName());
			json.put("type", 1);
			array.add(json);
		}
		Response.json(array);
	}
	
	/**
	 * 业务配置获取首长
	 */
	@ResponseBody
	@RequestMapping("/queryLeaderList")
	public void queryLeaderList(Integer page, Integer pagesize){
		Map<String, Object> map = new HashMap<>();
		map.put("roleFlag", DbDefined.ROLE_1);
		PageHelper.startPage(page, pagesize);
		List<RoleSet> roleSetList = roleSetService.queryList(map);
		GwPageUtils pageUtil = new GwPageUtils(roleSetList);
		Response.json(pageUtil);
	}
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info")
	public void info(String id){
		RoleSet roleSet = roleSetService.queryObject(id);
		Response.json(roleSet);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/saveOrUpdate")
	public void save(RoleSet dbRoleSet){
		String orgId="";
		String orgName="";
		String userId = dbRoleSet.getUserId();
		if(StringUtils.isNotBlank(userId)) {
			List<BaseAppUser> users = baseAppUserService.findByUserId(userId);
			if(users != null && users.size()>0) {
				orgId = users.get(0).getOrganid();
				BaseAppOrgan organ = baseAppOrganService.queryObject(orgId);
				if(organ != null) {
					orgName=organ.getName();
				}
			}
		}
		if(StringUtils.equals("1", dbRoleSet.getRoleFlag())) {//首长的新增要做排序校验
			Map<String, Object> resultMap = new HashMap<>();
			Map<String, Object> map = new HashMap<>();
			map.put("roleFlag", dbRoleSet.getRoleFlag());
			map.put("sort", dbRoleSet.getSort());
			List<RoleSet> roleSetList = roleSetService.queryList(map);
			map.put("sort", dbRoleSet.getSort());
			
			if(StringUtils.isNotBlank(dbRoleSet.getId())) {
				if((roleSetList != null && roleSetList.size()==1 && dbRoleSet.getId().equals(roleSetList.get(0).getId())) || roleSetList == null || roleSetList.size()==0) {			
					roleSetService.update(dbRoleSet);
					documentSzpsService.updateUserNameByUserId(dbRoleSet.getUserName(), dbRoleSet.getUserId());
					resultMap.put("code", "0");
					resultMap.put("result", "保存成功");
					Response.json(resultMap);
				}else {
					resultMap.put("code", "1");
					resultMap.put("result", "排序序号重复！");
					Response.json(resultMap);
				}
			}else {
				if(roleSetList != null && roleSetList.size()>0) {
					resultMap.put("code", "1");
					resultMap.put("result", "排序序号重复！");
					Response.json(resultMap);
				}else {
					dbRoleSet.setId(UUIDUtils.random());
					dbRoleSet.setUserId(UUIDUtils.random());
					roleSetService.save(dbRoleSet);
					resultMap.put("code", "0");
					resultMap.put("result", "保存成功");
					Response.json(resultMap);
				}
			}
		}else {
			if(StringUtils.isNotBlank(dbRoleSet.getId())) {
				if(!StringUtils.equals( DbDefined.ROLE_1, dbRoleSet.getRoleFlag())) {
					dbRoleSet.setDeptId(orgId);		
					dbRoleSet.setDeptName(orgName);
				}
				roleSetService.update(dbRoleSet);
			}else {
				roleSetService.deleteByUserId(userId);
				dbRoleSet.setId(UUIDUtils.random());
				if(!StringUtils.equals( DbDefined.ROLE_1, dbRoleSet.getRoleFlag())) {
					dbRoleSet.setDeptId(orgId);		
					dbRoleSet.setDeptName(orgName);
				}
				roleSetService.save(dbRoleSet);
			}
			Response.json("result", "success");
		}
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public void delete(String ids){
		String[] idArry = ids.split(",");
		roleSetService.deleteBatch(idArry);
		Response.json("result","success");
	}
	
}
