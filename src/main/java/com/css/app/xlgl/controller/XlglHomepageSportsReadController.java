package com.css.app.xlgl.controller;

import java.util.*;

import com.css.app.xlgl.entity.XlglHomepageSportsRead;
import com.css.app.xlgl.service.XlglHomepageSportsReadService;
import com.css.base.utils.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

import com.github.pagehelper.PageHelper;


/**
 * 训练管理-体育活动-已读未读表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-10-26 13:22:50
 */
@Controller
@RequestMapping("/app/xlgl/xlglhomepagesportsread")
public class XlglHomepageSportsReadController {
	@Autowired
	private XlglHomepageSportsReadService xlglHomepageSportsReadService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("xlglhomepagesportsread:list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<XlglHomepageSportsRead> xlglHomepageSportsReadList = xlglHomepageSportsReadService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(xlglHomepageSportsReadList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	@RequiresPermissions("xlglhomepagesportsread:info")
	public void info(@PathVariable("id") String id){
		XlglHomepageSportsRead xlglHomepageSportsRead = xlglHomepageSportsReadService.queryObject(id);
		Response.json("xlglHomepageSportsRead", xlglHomepageSportsRead);
	}
	
	/**
	 * 当点开详情即保存一条记录
	 */
	@ResponseBody
	@RequestMapping("/save")
	public void save(XlglHomepageSportsRead xlglHomepageSportsRead){
		String sportId = xlglHomepageSportsRead.getSportId();
		XlglHomepageSportsRead xlglHomepageSportsRead1 = xlglHomepageSportsReadService.queryBySportAndUserId(sportId,CurrentUser.getUserId());
		if(xlglHomepageSportsRead1 == null) {
			xlglHomepageSportsRead.setId(UUIDUtils.random());
			xlglHomepageSportsRead.setCreateTime(new Date());
			xlglHomepageSportsRead.setUserId(CurrentUser.getUserId());
			xlglHomepageSportsRead.setUserName(CurrentUser.getUsername());
			xlglHomepageSportsReadService.save(xlglHomepageSportsRead);
		}
		Response.json("result","success");
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("xlglhomepagesportsread:update")
	public void update(@RequestBody XlglHomepageSportsRead xlglHomepageSportsRead){
		xlglHomepageSportsReadService.update(xlglHomepageSportsRead);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("xlglhomepagesportsread:delete")
	public void delete(@RequestBody String[] ids){
		xlglHomepageSportsReadService.deleteBatch(ids);
		
		Response.ok();
	}
	
}
