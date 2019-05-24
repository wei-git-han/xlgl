package com.css.app.db.config.controller;

import java.util.Date;
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

import com.css.base.entity.SSOUser;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.GwPageUtils;
import com.css.base.utils.PageUtils;
import com.css.base.utils.UUIDUtils;
import com.github.pagehelper.PageHelper;
import com.css.base.utils.Response;
import com.css.base.utils.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.css.app.db.config.entity.DbExpDeedbackSet;
import com.css.app.db.config.service.DbExpDeedbackSetService;


/**
 * 督办-反馈范例配置表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-05-24 15:06:41
 */
@Controller
@RequestMapping("/app/db/dbexpdeedbackset")
public class DbExpDeedbackSetController {
	@Autowired
	private DbExpDeedbackSetService dbExpDeedbackSetService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	public void list(Integer page, Integer pagesize){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, pagesize);
		//查询列表数据
		List<DbExpDeedbackSet> dbExpDeedbackSetList = dbExpDeedbackSetService.queryList(map);
		
		GwPageUtils pageUtil = new GwPageUtils(dbExpDeedbackSetList);
		Response.json(pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info")
	public void info(String id){
		DbExpDeedbackSet dbExpDeedbackSet = null;
		if(!StringUtils.equals("", id)) {
			dbExpDeedbackSet = dbExpDeedbackSetService.queryObject(id);
		}
		JSONObject json = new JSONObject();
		json.put("expName", dbExpDeedbackSet.getExpName());// securityClassification
		json.put("expContent", dbExpDeedbackSet.getExpContent());
		json.put("flId", dbExpDeedbackSet.getId());
		Response.json(json);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	public void save(DbExpDeedbackSet dbExpDeedbackSet,String expId){
		String userName = CurrentUser.getUsername();
		String userId = CurrentUser.getUserId();
		if(StringUtils.equals("", expId)) {
			dbExpDeedbackSet.setId(UUIDUtils.random());
			dbExpDeedbackSet.setCreatedUser(userName);
			dbExpDeedbackSet.setCreatedUserId(userId);
			dbExpDeedbackSet.setCreatedTime(new Date());
			dbExpDeedbackSetService.save(dbExpDeedbackSet);
		}else {
			dbExpDeedbackSet.setModifiedUser(userName);
			dbExpDeedbackSet.setModifiedUserId(userId);
			dbExpDeedbackSet.setModifiedTime(new Date());
			dbExpDeedbackSetService.update(dbExpDeedbackSet);
		}
		Response.json("result","success");
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("dbexpdeedbackset:update")
	public void update(@RequestBody DbExpDeedbackSet dbExpDeedbackSet){
		dbExpDeedbackSetService.update(dbExpDeedbackSet);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public void delete(String[] ids){
		dbExpDeedbackSetService.deleteBatch(ids);
		Response.json("result","success");
	}
	
}
