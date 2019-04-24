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
import com.css.app.db.config.entity.AdminSet;
import com.css.app.db.config.service.AdminSetService;
import com.css.base.utils.GwPageUtils;
import com.css.base.utils.Response;
import com.css.base.utils.UUIDUtils;
import com.github.pagehelper.PageHelper;


/**
 * 管理员设置表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-19 10:22:04
 */
@Controller
@RequestMapping("/app/db/adminset")
public class AdminSetController {
	@Autowired
	private AdminSetService adminSetService;
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
		List<AdminSet> adminSetList = adminSetService.queryList(null);
		GwPageUtils pageUtil = new GwPageUtils(adminSetList);
		Response.json(pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info")
	public void info(String id){
		AdminSet adminSet = adminSetService.queryObject(id);
		Response.json(adminSet);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/saveOrUpdate")
	public void save(AdminSet adminSet){
		String orgId="";
		String orgName="";
		String userId = adminSet.getUserId();
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
		if(StringUtils.isNotBlank(adminSet.getId())) {
			adminSet.setDeptId(orgId);
			adminSet.setDeptName(orgName);
			adminSetService.update(adminSet);
		}else {
			adminSetService.deleteByUserId(userId);
			adminSet.setId(UUIDUtils.random());
			adminSet.setDeptId(orgId);
			adminSet.setDeptName(orgName);
			adminSetService.save(adminSet);
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
		adminSetService.deleteBatch(idArry);
		Response.json("result","success");
	}
	
}
