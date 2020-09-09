package com.css.app.xlgl.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import com.css.addbase.apporgan.service.BaseAppUserService;
import com.css.app.xlgl.entity.XlglSubDocInfo;
import com.css.app.xlgl.entity.XlglSubDocTracking;
import com.css.app.xlgl.entity.XlglXlzzInfo;
import com.css.app.xlgl.service.XlglSubDocInfoService;
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
 * 各子分支主记录表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-11 11:04:56
 */
@Controller
@RequestMapping("/app/xlgl/xlglsubdocinfo")
public class XlglSubDocInfoController {
	@Autowired
	private XlglSubDocInfoService xlglSubDocInfoService;
	@Autowired
	private BaseAppUserService baseAppUserService;
	@Autowired
	private XlglXlzzInfoService xlglXlzzInfoService;
	@Autowired
	private XlglSubDocTrackingService xlglSubDocTrackingService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<XlglSubDocInfo> xlglSubDocInfoList = xlglSubDocInfoService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(xlglSubDocInfoList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	public void info(String id){
		XlglSubDocInfo xlglSubDocInfo = xlglSubDocInfoService.queryObject(id);
		Response.json("xlglSubDocInfo", xlglSubDocInfo);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	public void save(XlglSubDocInfo xlglSubDocInfo){
		xlglSubDocInfo.setId(UUIDUtils.random());
		xlglSubDocInfoService.save(xlglSubDocInfo);
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public void update(XlglSubDocInfo xlglSubDocInfo){
		xlglSubDocInfoService.update(xlglSubDocInfo);
		
		Response.ok();
	}
	
	/**
	 * 删除，局管理员的删除
	 * 局分发的也都删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public void delete(String id) {
//		Map<String,Object> map = new HashMap<>();
//		String orgId = null;
//		if (StringUtils.isNotBlank(id)) {
//			orgId = baseAppUserService.getBareauByUserId(CurrentUser.getUserId());
//			map.put("INFO_ID",id);
//			List<XlglSubDocTracking> list = xlglSubDocTrackingService.queryList(map);
//			if(list != null && list.size() > 0){
//				Response.json("result","false");
//			}
//			xlglSubDocInfoService.deleteSub(orgId, id);
//		}
//		Response.json("result", "success");
		String orgId = null;
		Map<String,Object> map = new HashMap<>();
		map.put("id",id);
		SimpleDateFormat format  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		map.put("time",format.format(new Date()));
		XlglXlzzInfo xlglXlzzInfo = xlglXlzzInfoService.queryDelete(map);
		if(xlglXlzzInfo != null) {//不为空，说明开始时间大于当前时间，才能删除
			orgId = baseAppUserService.getBareauByUserId(CurrentUser.getUserId());
			xlglSubDocInfoService.deleteSub(orgId, id);
			xlglSubDocTrackingService.deleteByInfoIdAndOrgId(orgId,id);
			Response.json("result", "success");
		}else {
			Response.json("result", "false");
		}
	}

	/**
	 * 主文件删除的话，所有的分支都删除
	 * @param id
	 */
	@ResponseBody
	@RequestMapping("/deleteZhu")
	public void deleteZhu(String id){
		Map<String,Object> map = new HashMap<>();
		map.put("id",id);
		SimpleDateFormat format  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		map.put("time",format.format(new Date()));
		XlglXlzzInfo xlglXlzzInfo = xlglXlzzInfoService.queryDelete(map);
		if(xlglXlzzInfo != null){//不为空，说明开始时间大于当前时间，才能删除
			xlglXlzzInfoService.deleteById(id);
			xlglSubDocInfoService.deleteByInfoId(id);
			xlglSubDocTrackingService.deleteByInfoId(id);
			Response.json("result","success");
		}else {
			Response.json("result","false");
		}

	}
	
}
