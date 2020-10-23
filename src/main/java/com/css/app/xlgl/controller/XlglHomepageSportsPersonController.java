package com.css.app.xlgl.controller;

import java.util.*;

import com.alibaba.fastjson.JSONObject;
import com.css.base.utils.*;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.css.app.xlgl.entity.XlglHomepageSports;
import com.css.app.xlgl.entity.XlglHomepageSportsPerson;
import com.css.app.xlgl.service.XlglHomepageSportsPersonService;
import com.css.app.xlgl.service.XlglHomepageSportsService;
import com.css.base.entity.SSOUser;
import com.github.pagehelper.PageHelper;
import org.springframework.web.context.request.NativeWebRequest;


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
	 * type:0:全部，1.报名中；2.已报名；3.组局成功
	 */
	@ResponseBody
	@RequestMapping("/list")
	public void list(Integer page, Integer limit,String type){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<XlglHomepageSportsPerson> xlglHomepageSportsPersonList = xlglHomepageSportsPersonService.queryList(map);
		if("3".equals(type)){
			if(xlglHomepageSportsPersonList != null && xlglHomepageSportsPersonList.size() > 0){
				for(int i=0;i<xlglHomepageSportsPersonList.size();i++){
					String sportId = xlglHomepageSportsPersonList.get(i).getSportsId();
					XlglHomepageSports xlglHomepageSports = xlglHomepageSportsService.queryObject(sportId);
					if(xlglHomepageSports != null){
						String status = xlglHomepageSports.getStatus();
						if("0".equals(status)){
							xlglHomepageSportsPersonList.remove(i);
						}
					}
				}
			}
		}

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
	
	/**报名接口
	 *
	 */
	@ResponseBody
	@RequestMapping("/save")
	public void save(XlglHomepageSportsPerson xlglHomepageSportsPerson){
		JSONObject jsonObject = new JSONObject();
		String name = "";
		//保存接口
		SSOUser ssoUser = CurrentUser.getSSOUser();
		Date date = new Date();
		xlglHomepageSportsPerson.setId(UUIDUtils.random());
		xlglHomepageSportsPerson.setUserId(ssoUser.getUserId());
		xlglHomepageSportsPerson.setUserName(ssoUser.getFullname());
		xlglHomepageSportsPerson.setOrganId(ssoUser.getOrganId());
		xlglHomepageSportsPerson.setOrganName(ssoUser.getOrgName());
		xlglHomepageSportsPerson.setCreateDate(date);
		xlglHomepageSportsPerson.setCreateUser(ssoUser.getUserId());
		xlglHomepageSportsPerson.setSportsId(xlglHomepageSportsPerson.getId());
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
		if(queryObject.getNeedNumber().equals(number)){
			queryObject.setStatus("1");
		}else {
			queryObject.setStatus("0");
		}
		name = queryObject.getPeoples()+","+CurrentUser.getUsername();
		List list = new ArrayList();
		if(StringUtils.isNotBlank(name)){
			String[] names = name.split(",");
			if(names != null && names.length > 0){
				for(int i=0;i<names.length;i++){
					list.add(names[i]);
				}
			}
		}

		queryObject.setPeoples(list);
		xlglHomepageSportsService.update(queryObject);
		jsonObject.put("result","success");
		jsonObject.put("number",number);
		Response.json(jsonObject);
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
	 * 取消报名接口
	 * 修改新建活动的表，更新人数
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public void delete(String sportId){
		JSONObject jsonObject = new JSONObject();
		String userId = CurrentUser.getUserId();
		xlglHomepageSportsPersonService.deleteBySportIdAndUserId(sportId,userId);
//		XlglHomepageSports queryObject = xlglHomepageSportsService.queryObject(sportId);
//		Map<String, Object> map = new HashMap<>();
//		map.put("sportsId",queryObject.getId());
//		//查询列表数据
//		List<XlglHomepageSportsPerson> xlglHomepageSportsPersonList = xlglHomepageSportsPersonService.queryList(map);
//		Integer number = 0;
//		if(xlglHomepageSportsPersonList.size() >0) {
//			number = xlglHomepageSportsPersonList.size();
//		}
//		queryObject.setHaveNumber(number);
//		xlglHomepageSportsService.update(queryObject);
		jsonObject.put("result","success");
		//jsonObject.put("number",number);
		Response.json(jsonObject);
	}
	
}
