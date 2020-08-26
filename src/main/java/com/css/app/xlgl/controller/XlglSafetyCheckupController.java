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

import com.css.base.utils.PageUtils;
import com.css.base.utils.UUIDUtils;
import com.github.pagehelper.PageHelper;
import com.css.base.utils.Response;
import com.css.app.xlgl.entity.XlglSafetyCheckup;
import com.css.app.xlgl.service.XlglSafetyCheckupService;


/**
 * 日常管理-安全管理-安全检查
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-21 15:52:37
 */
@Controller
@RequestMapping("/app/xlgl/xlglsafetycheckup")
public class XlglSafetyCheckupController {
	@Autowired
	private XlglSafetyCheckupService xlglSafetyCheckupService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<XlglSafetyCheckup> xlglSafetyCheckupList = xlglSafetyCheckupService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(xlglSafetyCheckupList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	public void info(@PathVariable("id") String id){
		XlglSafetyCheckup xlglSafetyCheckup = xlglSafetyCheckupService.queryObject(id);
		Response.json("xlglSafetyCheckup", xlglSafetyCheckup);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	public void save(@RequestBody XlglSafetyCheckup xlglSafetyCheckup){
		xlglSafetyCheckup.setId(UUIDUtils.random());
		xlglSafetyCheckupService.save(xlglSafetyCheckup);
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public void update(@RequestBody XlglSafetyCheckup xlglSafetyCheckup){
		xlglSafetyCheckupService.update(xlglSafetyCheckup);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public void delete(String[] ids){
		xlglSafetyCheckupService.deleteBatch(ids);
		
		Response.ok();
	}
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/infoByOrganId")
	public void infoByOrganId(String organId){
		Map<String, Object> map = new HashMap<>();
		map.put("orgId", organId);
		List<XlglSafetyCheckup> queryList = xlglSafetyCheckupService.queryList(map);
		Response.json("xlglSafetyCheckup", queryList.get(0));
	}
	
}
