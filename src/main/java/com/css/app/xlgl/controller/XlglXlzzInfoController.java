package com.css.app.xlgl.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.css.app.xlgl.entity.XlglSubDocTracking;
import com.css.app.xlgl.entity.XlglXlzzInfo;
import com.css.app.xlgl.service.XlglSubDocTrackingService;
import com.css.app.xlgl.service.XlglXlzzInfoService;
import com.css.base.utils.CurrentUser;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

import com.css.base.utils.PageUtils;
import com.css.base.utils.UUIDUtils;
import com.github.pagehelper.PageHelper;
import com.css.base.utils.Response;


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
	
}
