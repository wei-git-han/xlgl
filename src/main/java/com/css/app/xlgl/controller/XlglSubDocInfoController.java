package com.css.app.xlgl.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.css.app.xlgl.entity.XlglSubDocInfo;
import com.css.app.xlgl.service.XlglSubDocInfoService;
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
 * 各子分支主记录表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-11 11:04:56
 */
@Controller
@RequestMapping("/xlglsubdocinfo")
public class XlglSubDocInfoController {
	@Autowired
	private XlglSubDocInfoService xlglSubDocInfoService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("xlglsubdocinfo:list")
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
	@RequiresPermissions("xlglsubdocinfo:info")
	public void info(@PathVariable("id") String id){
		XlglSubDocInfo xlglSubDocInfo = xlglSubDocInfoService.queryObject(id);
		Response.json("xlglSubDocInfo", xlglSubDocInfo);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	@RequiresPermissions("xlglsubdocinfo:save")
	public void save(@RequestBody XlglSubDocInfo xlglSubDocInfo){
		xlglSubDocInfo.setId(UUIDUtils.random());
		xlglSubDocInfoService.save(xlglSubDocInfo);
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("xlglsubdocinfo:update")
	public void update(@RequestBody XlglSubDocInfo xlglSubDocInfo){
		xlglSubDocInfoService.update(xlglSubDocInfo);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("xlglsubdocinfo:delete")
	public void delete(@RequestBody String[] ids){
		xlglSubDocInfoService.deleteBatch(ids);
		
		Response.ok();
	}
	
}
