package com.css.app.db.config.controller;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.css.addbase.apporgan.entity.BaseAppOrgan;
import com.css.addbase.apporgan.entity.BaseAppUser;
import com.css.addbase.apporgan.service.BaseAppOrganService;
import com.css.addbase.apporgan.service.BaseAppUserService;
import com.css.app.db.config.entity.RoleSet;
import com.css.app.db.config.service.RoleSetService;
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
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	public void list(Integer page, Integer pagesize){
		PageHelper.startPage(page, pagesize);
		List<RoleSet> roleSetList = roleSetService.queryList(null);
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
			if(users != null) {
				orgId = users.get(0).getOrganid();
				BaseAppOrgan organ = baseAppOrganService.queryObject(orgId);
				if(organ != null) {
					orgName=organ.getName();
				}
			}
		}
		if(StringUtils.isNotBlank(dbRoleSet.getId())) {
			dbRoleSet.setDeptId(orgId);
			dbRoleSet.setDeptName(orgName);
			roleSetService.update(dbRoleSet);
		}else {
			dbRoleSet.setId(UUIDUtils.random());
			dbRoleSet.setDeptId(orgId);
			dbRoleSet.setDeptName(orgName);
			roleSetService.save(dbRoleSet);
		}
		Response.json("result", "success");
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
