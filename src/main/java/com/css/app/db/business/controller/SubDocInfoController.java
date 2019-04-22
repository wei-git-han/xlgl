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
import com.css.app.db.business.entity.SubDocInfo;
import com.css.app.db.business.service.SubDocInfoService;


/**
 * 各子分支主记录表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-18 16:40:43
 */
@Controller
@RequestMapping("/subdocinfo")
public class SubDocInfoController {
	@Autowired
	private SubDocInfoService subDocInfoService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("dbsubdocinfo:list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<SubDocInfo> dbSubDocInfoList = subDocInfoService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(dbSubDocInfoList);
		Response.json("page",pageUtil);
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
