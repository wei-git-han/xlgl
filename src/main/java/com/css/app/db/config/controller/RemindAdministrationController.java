package com.css.app.db.config.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.css.app.db.config.entity.RemindAdministration;
import com.css.app.db.config.service.RemindAdministrationService;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.Response;
import com.css.base.utils.UUIDUtils;


/**
 * 提醒管理表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-02-18 14:45:49
 */
@Controller
@RequestMapping("/remindadministration")
public class RemindAdministrationController {
	@Autowired
	private RemindAdministrationService remindAdministrationService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	public void list(String type){
		JSONObject result = new JSONObject(true);
		JSONArray ja = new JSONArray();
		Map<String, Object> map = new HashMap<>();
		//查询列表数据
		List<RemindAdministration> remindAdministrationList = remindAdministrationService.queryList(map);
		for (RemindAdministration remindAdministration : remindAdministrationList) {
			if(remindAdministration.getType() !=null &&remindAdministration.getType().equals(type) ) {
				ja.add(remindAdministration);
			}
		}
		result.put("rows", ja);
		
		Response.json(result);
	}
	
	
	/**
	 * 详情信息
	 */
	@ResponseBody
	@RequestMapping("/info")
	public void info(String id){
		RemindAdministration remindAdministration = remindAdministrationService.queryObject(id);
		Response.json("remindAdministration", remindAdministration);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	public void save(RemindAdministration remindAdministration){
		String userId = CurrentUser.getUserId();
		String username = CurrentUser.getUsername();
		remindAdministration.setId(UUIDUtils.random());
		remindAdministration.setCreatorId(userId);
		remindAdministration.setCreator(username);
		remindAdministration.setCreatedTime(new Date());
		remindAdministrationService.save(remindAdministration);
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public void update(RemindAdministration remindAdministration){
		remindAdministrationService.update(remindAdministration);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public void delete(String[] ids){
		remindAdministrationService.deleteBatch(ids);
		
		Response.ok();
	}

}
