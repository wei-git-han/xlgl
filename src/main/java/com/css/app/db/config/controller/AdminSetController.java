package com.css.app.db.config.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.css.addbase.apporgan.entity.BaseAppOrgan;
import com.css.addbase.apporgan.entity.BaseAppUser;
import com.css.addbase.apporgan.service.BaseAppOrganService;
import com.css.addbase.apporgan.service.BaseAppUserService;
import com.css.app.db.config.entity.AdminSet;
import com.css.app.db.config.service.AdminSetService;
import com.css.base.utils.CurrentUser;
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
	@Value("${csse.dccb.appId}")
	private  String appId;	
	@Value("${csse.dccb.appSecret}")
	private  String clientSecret;
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	public void list(Integer page, Integer pagesize ,String adminType){
		PageHelper.startPage(page, pagesize);
		Map<String, Object > map = new HashMap<>();
		map.put("adminType", adminType);
		List<AdminSet> adminSetList = adminSetService.queryList(map);
		GwPageUtils pageUtil = new GwPageUtils(adminSetList);
		Response.json(pageUtil);
	}
	
	@ResponseBody
	@RequestMapping("/getAuthor")
	public void getAuthor(){
		boolean adminFlag = false;//管理员类型（1：部管理员；2：局管理员）
		boolean admin = CurrentUser.getIsManager(appId, clientSecret);
		if(admin) {
			adminFlag=true;
		}
		//当前登录人的管理员类型
		Map<String, Object> adminMap = new HashMap<>();
		adminMap.put("userId", CurrentUser.getUserId());
		List<AdminSet> adminList = adminSetService.queryList(adminMap);
		if(adminList != null && adminList.size()>0) {
			String adminType = adminList.get(0).getAdminType();
			if(StringUtils.equals("1", adminType)) {
				adminFlag=true;
			}			
		}
		Response.json(adminFlag);
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
