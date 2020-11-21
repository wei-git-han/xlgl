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
import com.css.app.xlgl.entity.SurveyQuestionExtendInfo;
import com.css.app.xlgl.service.SurveyQuestionExtendInfoService;


/**
 * 调查问卷扩展表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-11-21 14:46:59
 */
@Controller
@RequestMapping("/surveyquestionextendinfo")
public class SurveyQuestionExtendInfoController {
	@Autowired
	private SurveyQuestionExtendInfoService surveyQuestionExtendInfoService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("surveyquestionextendinfo:list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<SurveyQuestionExtendInfo> surveyQuestionExtendInfoList = surveyQuestionExtendInfoService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(surveyQuestionExtendInfoList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	@RequiresPermissions("surveyquestionextendinfo:info")
	public void info(@PathVariable("id") String id){
		SurveyQuestionExtendInfo surveyQuestionExtendInfo = surveyQuestionExtendInfoService.queryObject(id);
		Response.json("surveyQuestionExtendInfo", surveyQuestionExtendInfo);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	@RequiresPermissions("surveyquestionextendinfo:save")
	public void save(@RequestBody SurveyQuestionExtendInfo surveyQuestionExtendInfo){
		surveyQuestionExtendInfo.setId(UUIDUtils.random());
		surveyQuestionExtendInfoService.save(surveyQuestionExtendInfo);
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("surveyquestionextendinfo:update")
	public void update(@RequestBody SurveyQuestionExtendInfo surveyQuestionExtendInfo){
		surveyQuestionExtendInfoService.update(surveyQuestionExtendInfo);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("surveyquestionextendinfo:delete")
	public void delete(@RequestBody String[] ids){
		surveyQuestionExtendInfoService.deleteBatch(ids);
		
		Response.ok();
	}
	
}
