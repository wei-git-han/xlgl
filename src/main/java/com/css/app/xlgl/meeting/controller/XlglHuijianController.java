package com.css.app.xlgl.meeting.controller;

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
import com.css.app.xlgl.meeting.entity.XlglHuijian;
import com.css.app.xlgl.meeting.service.XlglHuijianService;


/**
 * 保存会见返回的会议号id
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-09-14 14:41:44
 */
@Controller
@RequestMapping("/xlglhuijian")
public class XlglHuijianController {
	@Autowired
	private XlglHuijianService xlglHuijianService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<XlglHuijian> xlglHuijianList = xlglHuijianService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(xlglHuijianList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	public void info(String id){
		XlglHuijian xlglHuijian = xlglHuijianService.queryObject(id);
		Response.json("xlglHuijian", xlglHuijian);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	public void save(XlglHuijian xlglHuijian){
		xlglHuijian.setId(UUIDUtils.random());
		xlglHuijianService.save(xlglHuijian);
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public void update(XlglHuijian xlglHuijian){
		xlglHuijianService.update(xlglHuijian);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public void delete(String[] ids){
		xlglHuijianService.deleteBatch(ids);
		
		Response.ok();
	}
	
}
