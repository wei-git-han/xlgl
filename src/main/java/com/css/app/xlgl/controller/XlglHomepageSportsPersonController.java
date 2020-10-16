package com.css.app.xlgl.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
 * 首页-体育活动-人员报名表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-10-16 10:45:44
 */
@Controller
@RequestMapping("/app/xlgl/xlglhomepagesportsperson")
public class XlglHomepageSportsPersonController {
	@Autowired
	private XlglHomepageSportsPersonService xlglHomepageSportsPersonService;
	@Autowired
	private XlglHomepageSportsService xlglHomepageSportsService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<XlglHomepageSportsPerson> xlglHomepageSportsPersonList = xlglHomepageSportsPersonService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(xlglHomepageSportsPersonList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	public void info(String id){
		XlglHomepageSportsPerson xlglHomepageSportsPerson = xlglHomepageSportsPersonService.queryObject(id);
		Response.json("xlglHomepageSportsPerson", xlglHomepageSportsPerson);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	public void save(XlglHomepageSportsPerson xlglHomepageSportsPerson){
		SSOUser ssoUser = CurrentUser.getSSOUser();
		Date date = new Date();
		xlglHomepageSportsPerson.setId(UUIDUtils.random());
		xlglHomepageSportsPerson.setUserId(ssoUser.getUserId());
		xlglHomepageSportsPerson.setUserName(ssoUser.getFullname());
		xlglHomepageSportsPerson.setOrganId(ssoUser.getOrganId());
		xlglHomepageSportsPerson.setOrganName(ssoUser.getOrgName());
		xlglHomepageSportsPerson.setCreateDate(date);
		xlglHomepageSportsPerson.setCreateUser(ssoUser.getUserId());
		xlglHomepageSportsPersonService.save(xlglHomepageSportsPerson);
		XlglHomepageSports queryObject = xlglHomepageSportsService.queryObject(xlglHomepageSportsPerson.getSportsId());
		Map<String, Object> map = new HashMap<>();
		map.put("sportsId",queryObject.getId());
		//查询列表数据
		List<XlglHomepageSportsPerson> xlglHomepageSportsPersonList = xlglHomepageSportsPersonService.queryList(map);
		Integer number = 0;
		if(xlglHomepageSportsPersonList.size() >0) {
			number = xlglHomepageSportsPersonList.size();
		}
		queryObject.setHaveNumber(number);
		xlglHomepageSportsService.update(queryObject);
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public void update(XlglHomepageSportsPerson xlglHomepageSportsPerson){
		xlglHomepageSportsPersonService.update(xlglHomepageSportsPerson);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public void delete(String[] ids){
		xlglHomepageSportsPersonService.deleteBatch(ids);	
		Response.ok();
	}
	
}
