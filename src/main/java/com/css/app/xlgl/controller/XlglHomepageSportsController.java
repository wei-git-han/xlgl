package com.css.app.xlgl.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.css.app.xlgl.entity.XlglHomepageSports;
import com.css.app.xlgl.entity.XlglHomepageSportsPerson;
import com.css.app.xlgl.service.XlglHomepageSportsPersonService;
import com.css.app.xlgl.service.XlglHomepageSportsService;
import com.css.base.entity.SSOUser;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.PageUtils;
import com.css.base.utils.Response;
import com.css.base.utils.UUIDUtils;
import com.github.pagehelper.PageHelper;


/**
 * 首页-体育活动
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-10-16 10:45:44
 */
@Controller
@RequestMapping("/app/xlgl/xlglhomepagesports")
public class XlglHomepageSportsController {
	@Autowired
	private XlglHomepageSportsService xlglHomepageSportsService;
	@Autowired
	private XlglHomepageSportsPersonService xlglHomepageSportsPersonService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<XlglHomepageSports> xlglHomepageSportsList = xlglHomepageSportsService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(xlglHomepageSportsList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	public void info(String id){
		JSONObject jsonObject = new JSONObject();
		XlglHomepageSports xlglHomepageSports = xlglHomepageSportsService.queryObject(id);
		Map<String, Object> map = new HashMap<>();
		map.put("sportsId",id);
		//查询列表数据
		List<XlglHomepageSportsPerson> xlglHomepageSportsPersonList = xlglHomepageSportsPersonService.queryList(map);
		jsonObject.put("xlglHomepageSports", xlglHomepageSports);
		jsonObject.put("sportPersonList", xlglHomepageSportsPersonList);
		Response.json(jsonObject);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	public void save(XlglHomepageSports xlglHomepageSports){
		SSOUser ssoUser = CurrentUser.getSSOUser();
		Date date = new Date();
		xlglHomepageSports.setId(UUIDUtils.random());
		xlglHomepageSports.setCreateUser(ssoUser.getUserId());
		xlglHomepageSports.setCreateDate(date);
		xlglHomepageSports.setUpdateUser(ssoUser.getUserId());
		xlglHomepageSports.setUpdateDate(date);
		xlglHomepageSportsService.save(xlglHomepageSports);
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public void update(XlglHomepageSports xlglHomepageSports){
		xlglHomepageSportsService.update(xlglHomepageSports);
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public void delete(String[] ids){
		xlglHomepageSportsService.deleteBatch(ids);	
		Response.ok();
	}
	
	/**
	 * 判断需要的人员是否已满
	 * */
	@ResponseBody
	@RequestMapping("/getNeedPerson")
	public void getNeedPerson(String id) {
		String status = "0";//人员已经满
		XlglHomepageSports xlglHomepageSports = xlglHomepageSportsService.queryObject(id);
		Map<String, Object> map = new HashMap<>();
		map.put("sportsId",id);
		//查询列表数据
		List<XlglHomepageSportsPerson> xlglHomepageSportsPersonList = xlglHomepageSportsPersonService.queryList(map);
		Integer number = 0;
		if(xlglHomepageSportsPersonList.size() >0) {
			number = xlglHomepageSportsPersonList.size();
		}
		if(xlglHomepageSports.getNeedNumber() >number) {
			status = "1";//人员未满
		}
		Response.json("status");
	}
	
}
