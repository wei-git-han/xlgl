package com.css.app.xlgl.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.css.app.xlgl.entity.XlglMineStudy;
import com.css.app.xlgl.service.XlglMineStudyService;
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
 * 训练管理自学表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-21 14:37:00
 */
@Controller
@RequestMapping("/xlglminestudy")
public class XlglMineStudyController {
	@Autowired
	private XlglMineStudyService xlglMineStudyService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("xlglminestudy:list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<XlglMineStudy> xlglMineStudyList = xlglMineStudyService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(xlglMineStudyList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	@RequiresPermissions("xlglminestudy:info")
	public void info(@PathVariable("id") String id){
		XlglMineStudy xlglMineStudy = xlglMineStudyService.queryObject(id);
		Response.json("xlglMineStudy", xlglMineStudy);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	@RequiresPermissions("xlglminestudy:save")
	public void save(@RequestBody XlglMineStudy xlglMineStudy){
		xlglMineStudy.setId(UUIDUtils.random());
		xlglMineStudyService.save(xlglMineStudy);
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("xlglminestudy:update")
	public void update(@RequestBody XlglMineStudy xlglMineStudy){
		xlglMineStudyService.update(xlglMineStudy);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("xlglminestudy:delete")
	public void delete(@RequestBody String[] ids){
		xlglMineStudyService.deleteBatch(ids);
		
		Response.ok();
	}
	
}
