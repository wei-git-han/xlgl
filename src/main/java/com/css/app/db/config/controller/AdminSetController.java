package com.css.app.db.config.controller;

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
import com.css.app.db.config.entity.AdminSet;
import com.css.app.db.config.service.AdminSetService;


/**
 * 管理员设置表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-19 10:22:04
 */
@Controller
@RequestMapping("/adminset")
public class AdminSetController {
	@Autowired
	private AdminSetService adminSetService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("dbadminset:list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<AdminSet> dbAdminSetList = adminSetService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(dbAdminSetList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	@RequiresPermissions("dbadminset:info")
	public void info(@PathVariable("id") String id){
		AdminSet dbAdminSet = adminSetService.queryObject(id);
		Response.json("dbAdminSet", dbAdminSet);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	@RequiresPermissions("dbadminset:save")
	public void save(@RequestBody AdminSet dbAdminSet){
		dbAdminSet.setId(UUIDUtils.random());
		adminSetService.save(dbAdminSet);
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("dbadminset:update")
	public void update(@RequestBody AdminSet dbAdminSet){
		adminSetService.update(dbAdminSet);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("dbadminset:delete")
	public void delete(@RequestBody String[] ids){
		adminSetService.deleteBatch(ids);
		
		Response.ok();
	}
	
}
