package com.css.app.db.business.controller;

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

import com.css.base.utils.PageUtils;
import com.css.base.utils.UUIDUtils;
import com.github.pagehelper.PageHelper;
import com.css.base.utils.Response;
import com.css.app.db.business.entity.SubDocTracking;
import com.css.app.db.business.service.SubDocTrackingService;


/**
 * 局内流转记录表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-24 13:40:54
 */
@Controller
@RequestMapping("/subdoctracking")
public class SubDocTrackingController {
	@Autowired
	private SubDocTrackingService subDocTrackingService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("dbsubdoctracking:list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<SubDocTracking> dbSubDocTrackingList = subDocTrackingService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(dbSubDocTrackingList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	@RequiresPermissions("dbsubdoctracking:info")
	public void info(@PathVariable("id") String id){
		SubDocTracking dbSubDocTracking = subDocTrackingService.queryObject(id);
		Response.json("dbSubDocTracking", dbSubDocTracking);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	@RequiresPermissions("dbsubdoctracking:save")
	public void save(@RequestBody SubDocTracking dbSubDocTracking){
		dbSubDocTracking.setId(UUIDUtils.random());
		subDocTrackingService.save(dbSubDocTracking);
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("dbsubdoctracking:update")
	public void update(@RequestBody SubDocTracking dbSubDocTracking){
		subDocTrackingService.update(dbSubDocTracking);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("dbsubdoctracking:delete")
	public void delete(@RequestBody String[] ids){
		subDocTrackingService.deleteBatch(ids);
		
		Response.ok();
	}
	
}
