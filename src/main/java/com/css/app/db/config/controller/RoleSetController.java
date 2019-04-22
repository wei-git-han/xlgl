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
import com.css.app.db.config.entity.RoleSet;
import com.css.app.db.config.service.RoleSetService;


/**
 * 角色设置表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-19 10:22:36
 */
@Controller
@RequestMapping("/roleset")
public class RoleSetController {
	@Autowired
	private RoleSetService roleSetService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("dbroleset:list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<RoleSet> dbRoleSetList = roleSetService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(dbRoleSetList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	@RequiresPermissions("dbroleset:info")
	public void info(@PathVariable("id") String id){
		RoleSet dbRoleSet = roleSetService.queryObject(id);
		Response.json("dbRoleSet", dbRoleSet);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	@RequiresPermissions("dbroleset:save")
	public void save(@RequestBody RoleSet dbRoleSet){
		dbRoleSet.setId(UUIDUtils.random());
		roleSetService.save(dbRoleSet);
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("dbroleset:update")
	public void update(@RequestBody RoleSet dbRoleSet){
		roleSetService.update(dbRoleSet);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("dbroleset:delete")
	public void delete(@RequestBody String[] ids){
		roleSetService.deleteBatch(ids);
		
		Response.ok();
	}
	
}
