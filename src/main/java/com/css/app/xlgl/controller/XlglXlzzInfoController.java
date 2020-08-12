package com.css.app.xlgl.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.css.addbase.appconfig.service.BaseAppConfigService;
import com.css.addbase.apporgan.entity.BaseAppOrgan;
import com.css.addbase.apporgan.entity.BaseAppUser;
import com.css.addbase.apporgan.service.BaseAppOrganService;
import com.css.addbase.apporgan.service.BaseAppUserService;
import com.css.addbase.apporgan.util.OrgUtil;
import com.css.addbase.apporgmapped.service.BaseAppOrgMappedService;
import com.css.addbase.orgservice.OrgService;
import com.css.app.xlgl.entity.XlglSubDocTracking;
import com.css.app.xlgl.entity.XlglXlzzInfo;
import com.css.app.xlgl.service.XlglSubDocTrackingService;
import com.css.app.xlgl.service.XlglXlzzInfoService;
import com.css.base.utils.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

import com.github.pagehelper.PageHelper;


/**
 * 训练组织基本信息表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-11 10:12:29
 */
@Controller
@RequestMapping("/app/xlgl/xlglxlzzinfo")
public class XlglXlzzInfoController {
	@Autowired
	private XlglXlzzInfoService xlglXlzzInfoService;
	@Autowired
	private XlglSubDocTrackingService xlglSubDocTrackingService;
	@Autowired
	private BaseAppOrganService baseAppOrganService;

	@Autowired
	private BaseAppUserService baseAppUserService;

	@Autowired
	private BaseAppOrgMappedService baseAppOrgMappedService;

	@Autowired
	private OrgService orgService;
	@Autowired
	private BaseAppConfigService baseAppConfigService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("xlglxlzzinfo:list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<XlglXlzzInfo> xlglXlzzInfoList = xlglXlzzInfoService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(xlglXlzzInfoList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info")
	public void info(String id){
		String loginUser = CurrentUser.getUserId();
		XlglXlzzInfo xlglXlzzInfo = xlglXlzzInfoService.queryObject(id);
		//打开的同时，更新打开人的状态为已读
		XlglSubDocTracking xlglSubDocTracking = xlglSubDocTrackingService.queryInfo(id,loginUser);
		xlglSubDocTracking.setStatus("1");
		xlglSubDocTrackingService.update(xlglSubDocTracking);
		xlglXlzzInfo.setStatus("1");//1为已读
		xlglXlzzInfo.setBaoming(xlglSubDocTracking.getBaoming());
		Response.json("xlglXlzzInfo", xlglXlzzInfo);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	public void save(XlglXlzzInfo xlglXlzzInfo){
		xlglXlzzInfo.setId(UUIDUtils.random());
		xlglXlzzInfoService.save(xlglXlzzInfo);
		Response.json("result","success");
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("xlglxlzzinfo:update")
	public void update(@RequestBody XlglXlzzInfo xlglXlzzInfo){
		xlglXlzzInfoService.update(xlglXlzzInfo);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("xlglxlzzinfo:delete")
	public void delete(@RequestBody String[] ids){
		xlglXlzzInfoService.deleteBatch(ids);
		
		Response.ok();
	}


	/**
	 * 获取当前登录人所在部门的训练跟踪情况
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getDateForDept")
	public void getDateForDept(String infoId) {
		Map<String, Object> map = new HashMap<String, Object>();
		String orgId = baseAppUserService.getBareauByUserId(CurrentUser.getUserId());
		map.put("orgId", orgId);
		//获取了该局所有的部门id
		List<BaseAppOrgan> list = baseAppOrganService.queryAllDeptId(orgId);
		List listAllUser = new ArrayList();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				List<BaseAppUser> listUser = null;
				JSONObject jsonObject = new JSONObject();
				String deptId = list.get(i).getId();
				String deptName = list.get(i).getName();
				if (i == 0) {
					listUser = baseAppUserService.queryAllJuUserByDeptId(deptId,infoId);
				} else {
					listUser = baseAppUserService.queryAllUserByDeptId(deptId,infoId);
				}
				jsonObject.put("listUser",listUser);
				jsonObject.put("deptName",deptName);
				listAllUser.add(jsonObject);
			}

		}
		Response.json("listAllUser",listAllUser);
	}

	
}
