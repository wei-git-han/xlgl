package com.css.app.xlgl.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.css.app.xlgl.entity.XlglSubDocTracking;
import com.css.app.xlgl.service.XlglSubDocTrackingService;
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
 * 
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-11 15:53:31
 */
@Controller
@RequestMapping("/xlglsubdoctracking")
public class XlglSubDocTrackingController {
	@Autowired
	private XlglSubDocTrackingService xlglSubDocTrackingService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("xlglsubdoctracking:list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<XlglSubDocTracking> xlglSubDocTrackingList = xlglSubDocTrackingService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(xlglSubDocTrackingList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	@RequiresPermissions("xlglsubdoctracking:info")
	public void info(@PathVariable("id") String id){
		XlglSubDocTracking xlglSubDocTracking = xlglSubDocTrackingService.queryObject(id);
		Response.json("xlglSubDocTracking", xlglSubDocTracking);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	@RequiresPermissions("xlglsubdoctracking:save")
	public void save(@RequestBody XlglSubDocTracking xlglSubDocTracking){
		xlglSubDocTracking.setId(UUIDUtils.random());
		xlglSubDocTrackingService.save(xlglSubDocTracking);
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("xlglsubdoctracking:update")
	public void update(@RequestBody XlglSubDocTracking xlglSubDocTracking){
		xlglSubDocTrackingService.update(xlglSubDocTracking);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("xlglsubdoctracking:delete")
	public void delete(@RequestBody String[] ids){
		xlglSubDocTrackingService.deleteBatch(ids);
		
		Response.ok();
	}
	
}
