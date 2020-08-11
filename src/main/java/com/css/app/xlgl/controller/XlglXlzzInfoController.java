package com.css.app.xlgl.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.css.app.xlgl.entity.XlglXlzzInfo;
import com.css.app.xlgl.service.XlglXlzzInfoService;
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
@RequestMapping("/xlglxlzzinfo")
public class XlglXlzzInfoController {
	@Autowired
	private XlglXlzzInfoService xlglXlzzInfoService;
	
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
	@RequestMapping("/info/{id}")
	@RequiresPermissions("xlglxlzzinfo:info")
	public void info(@PathVariable("id") String id){
		XlglXlzzInfo xlglXlzzInfo = xlglXlzzInfoService.queryObject(id);
		Response.json("xlglXlzzInfo", xlglXlzzInfo);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	@RequiresPermissions("xlglxlzzinfo:save")
	public void save(@RequestBody XlglXlzzInfo xlglXlzzInfo){
		xlglXlzzInfo.setId(UUIDUtils.random());
		xlglXlzzInfoService.save(xlglXlzzInfo);
		
		Response.ok();
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
