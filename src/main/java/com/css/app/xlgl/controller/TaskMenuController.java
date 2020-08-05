package com.css.app.xlgl.controller;

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

import com.css.app.xlgl.entity.TaskMenu;
import com.css.app.xlgl.service.TaskMenuService;
import com.css.base.utils.PageUtils;
import com.css.base.utils.UUIDUtils;
import com.github.pagehelper.PageHelper;
import com.css.base.utils.Response;


/**
 * 
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-05 13:46:02
 */
@Controller
@RequestMapping("/taskmenu")
public class TaskMenuController {
	@Autowired
	private TaskMenuService taskMenuService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("taskmenu:list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<TaskMenu> taskMenuList = taskMenuService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(taskMenuList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{menuId}")
	@RequiresPermissions("taskmenu:info")
	public void info(@PathVariable("menuId") String menuId){
		TaskMenu taskMenu = taskMenuService.queryObject(menuId);
		Response.json("taskMenu", taskMenu);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	@RequiresPermissions("taskmenu:save")
	public void save(@RequestBody TaskMenu taskMenu){
		taskMenu.setMenuId(UUIDUtils.random());
		taskMenuService.save(taskMenu);
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("taskmenu:update")
	public void update(@RequestBody TaskMenu taskMenu){
		taskMenuService.update(taskMenu);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("taskmenu:delete")
	public void delete(@RequestBody String[] menuIds){
		taskMenuService.deleteBatch(menuIds);
		
		Response.ok();
	}
	
}
