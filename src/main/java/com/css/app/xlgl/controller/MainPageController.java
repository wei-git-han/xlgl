package com.css.app.xlgl.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.css.addbase.AppConfig;
import com.css.addbase.appconfig.service.BaseAppConfigService;
import com.css.app.xlgl.entity.XlglZbgl;
import com.css.base.utils.Response;


/**
 * 训练管理装备管理
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-17 19:34:44
 */
@Controller
@RequestMapping("/app/xlgl/mainPage")
public class MainPageController {
	@Autowired
	private BaseAppConfigService configService;
	@Autowired
	private AppConfig appConfig;
	
	/**
	 * 列表
	 */
	private static final String QXJ ="qxjurl";
	private static final String YJFK ="yjfkurl";
	@ResponseBody
	@RequestMapping("/getUrl")
	public void list(Integer page, Integer limit){
		
		String pageStr=configService.getValue("mainPage");
		Object ja=JSONObject.parse(pageStr);
		Response.json("mainPage",ja);
	}
	
	
/*	*//**
	 * 信息
	 *//*
	@ResponseBody
	@RequestMapping("/info/{id}")
	@RequiresPermissions("xlglzbgl:info")
	public void info(@PathVariable("id") String id){
		XlglZbgl xlglZbgl = xlglZbglService.queryObject(id);
		Response.json("xlglZbgl", xlglZbgl);
	}*/
	
	
	
}
