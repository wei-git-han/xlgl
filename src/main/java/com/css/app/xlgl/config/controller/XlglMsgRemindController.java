package com.css.app.xlgl.config.controller;

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
import com.css.app.xlgl.config.entity.XlglMsgRemind;
import com.css.app.xlgl.config.service.XlglMsgRemindService;


/**
 * 消息提醒开关表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-10-15 16:14:46
 */
@Controller
@RequestMapping("/xlglmsgremind")
public class XlglMsgRemindController {
	@Autowired
	private XlglMsgRemindService xlglMsgRemindService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("xlglmsgremind:list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<XlglMsgRemind> xlglMsgRemindList = xlglMsgRemindService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(xlglMsgRemindList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	@RequiresPermissions("xlglmsgremind:info")
	public void info(@PathVariable("id") String id){
		XlglMsgRemind xlglMsgRemind = xlglMsgRemindService.queryObject(id);
		Response.json("xlglMsgRemind", xlglMsgRemind);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	@RequiresPermissions("xlglmsgremind:save")
	public void save(@RequestBody XlglMsgRemind xlglMsgRemind){
		xlglMsgRemind.setId(UUIDUtils.random());
		xlglMsgRemindService.save(xlglMsgRemind);
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("xlglmsgremind:update")
	public void update(@RequestBody XlglMsgRemind xlglMsgRemind){
		xlglMsgRemindService.update(xlglMsgRemind);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("xlglmsgremind:delete")
	public void delete(@RequestBody String[] ids){
		xlglMsgRemindService.deleteBatch(ids);
		
		Response.ok();
	}
	
}
