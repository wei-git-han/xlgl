package com.css.app.db.business.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.css.addbase.apporgan.service.BaseAppUserService;
import com.css.app.db.business.entity.SubDocInfo;
import com.css.app.db.business.service.SubDocInfoService;
import com.css.app.db.config.service.AdminSetService;
import com.css.app.db.config.service.RoleSetService;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.GwPageUtils;
import com.css.base.utils.Response;
import com.css.base.utils.StringUtils;
import com.css.base.utils.UUIDUtils;
import com.github.pagehelper.PageHelper;


/**
 * 各子分支主记录表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-18 16:40:43
 */
@Controller
@RequestMapping("/app/db/subdocinfo")
public class SubDocInfoController {
	@Autowired
	private SubDocInfoService subDocInfoService;
	@Autowired
	private BaseAppUserService baseAppUserService;
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	public void list(Integer page, Integer pagesize,String search, String docStatus){
		Map<String, Object> map = new HashMap<>();
		String loginUserId=CurrentUser.getUserId();
		String orgId = baseAppUserService.getBareauByUserId(loginUserId);
		if(StringUtils.isNotBlank(orgId)) {
			map.put("orgId", orgId);
		}
		if(StringUtils.isNotBlank(search)) {
			map.put("search", search);
		}
		if(StringUtils.isNotBlank(docStatus)) {
			map.put("docStatus", docStatus);
		}
		//查询列表数据
		PageHelper.startPage(page, pagesize);
		List<SubDocInfo> subDocInfoList = subDocInfoService.queryList(map);
		GwPageUtils pageUtil = new GwPageUtils(subDocInfoList);
		Response.json(pageUtil);
	}
	
	@ResponseBody
	@RequestMapping("/personList")
	public void personList(Integer page, Integer pagesize,String search, String docStatus){
		Map<String, Object> map = new HashMap<>();
		String loginUserId=CurrentUser.getUserId();
		if(StringUtils.isNotBlank(loginUserId)) {
			map.put("loginUserId", loginUserId);
		}
		if(StringUtils.isNotBlank(search)) {
			map.put("search", search);
		}
		if(StringUtils.isNotBlank(docStatus)) {
			map.put("docStatus", docStatus);
		}
		//查询列表数据
		PageHelper.startPage(page, pagesize);
		List<SubDocInfo> subDocInfoList = subDocInfoService.queryPersonList(map);
		GwPageUtils pageUtil = new GwPageUtils(subDocInfoList);
		Response.json(pageUtil);
	}
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	@RequiresPermissions("dbsubdocinfo:info")
	public void info(@PathVariable("id") String id){
		SubDocInfo dbSubDocInfo = subDocInfoService.queryObject(id);
		Response.json("dbSubDocInfo", dbSubDocInfo);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	@RequiresPermissions("dbsubdocinfo:save")
	public void save(@RequestBody SubDocInfo dbSubDocInfo){
		dbSubDocInfo.setId(UUIDUtils.random());
		subDocInfoService.save(dbSubDocInfo);
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("dbsubdocinfo:update")
	public void update(@RequestBody SubDocInfo dbSubDocInfo){
		subDocInfoService.update(dbSubDocInfo);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("dbsubdocinfo:delete")
	public void delete(@RequestBody String[] ids){
		subDocInfoService.deleteBatch(ids);
		
		Response.ok();
	}
	
}
