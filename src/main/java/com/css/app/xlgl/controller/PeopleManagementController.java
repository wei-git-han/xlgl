package com.css.app.xlgl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.css.addbase.apporgmapped.service.BaseAppOrgMappedService;
import com.css.addbase.constant.AppConstant;
import com.css.addbase.constant.AppInterfaceConstant;
import com.css.base.utils.CrossDomainUtil;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.Response;

@Controller
@RequestMapping("app/xlgl/peopleManagement")
public class PeopleManagementController {
	@Autowired
	private BaseAppOrgMappedService baseAppOrgMappedService;
	
	
	/**
	 * 单位人员情况当前用户的
	 * */
	@ResponseBody
	@RequestMapping("/qxjUserInto")
	public void list() {
	     String userName = CurrentUser.getUsername();
		LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<String,Object>();
		// 获取办件开放的接口
		String elecPath = baseAppOrgMappedService.getWebUrl(AppConstant.APP_QXJGL, AppInterfaceConstant.WEB_INTERFACE_QXJ_USER_INFO_QJDAYS);
		JSONObject jsonData = CrossDomainUtil.getJsonData(elecPath,map);
		Integer totalDays = Integer.parseInt(jsonData.get("totalDays").toString());//年度应休假期
		Integer xiuJiaDays = Integer.parseInt(jsonData.get("xiuJiaDays").toString());//现在已休假期
		double rate =(xiuJiaDays/ totalDays)*100;
		jsonData.put("userName", userName);
		jsonData.put("rate", rate);
		Response.json(jsonData);
	}
	
	/**
	 * 单位人员个人请销假列表
	 * */
	@ResponseBody
	@RequestMapping("/qxjUserInfoList")
	public void qxjUserInfoList(Integer page, Integer limit,String organId) {
		LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<String,Object>();
		map.add("page", page);
		map.add("limit", limit);
		map.add("limit", organId);
		// 获取办件开放的接口
		String elecPath = baseAppOrgMappedService.getWebUrl(AppConstant.APP_QXJGL, AppInterfaceConstant.WEB_INTERFACE_QXJ_USER_INFO_LIST);
		JSONObject jsonData = CrossDomainUtil.getJsonData(elecPath,map);
	
		Response.json(jsonData);
	}
	
	
}
