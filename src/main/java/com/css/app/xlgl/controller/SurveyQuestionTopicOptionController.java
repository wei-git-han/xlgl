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
import com.css.app.xlgl.entity.SurveyQuestionTopicOption;
import com.css.app.xlgl.service.SurveyQuestionTopicOptionService;


/**
 * 调查问卷题干的选项表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-11-20 18:52:05
 */
@Controller
@RequestMapping("/surveyquestiontopicoption")
public class SurveyQuestionTopicOptionController {
	@Autowired
	private SurveyQuestionTopicOptionService surveyQuestionTopicOptionService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("surveyquestiontopicoption:list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<SurveyQuestionTopicOption> surveyQuestionTopicOptionList = surveyQuestionTopicOptionService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(surveyQuestionTopicOptionList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	@RequiresPermissions("surveyquestiontopicoption:info")
	public void info(@PathVariable("id") String id){
		SurveyQuestionTopicOption surveyQuestionTopicOption = surveyQuestionTopicOptionService.queryObject(id);
		Response.json("surveyQuestionTopicOption", surveyQuestionTopicOption);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	@RequiresPermissions("surveyquestiontopicoption:save")
	public void save(@RequestBody SurveyQuestionTopicOption surveyQuestionTopicOption){
		surveyQuestionTopicOption.setId(UUIDUtils.random());
		surveyQuestionTopicOptionService.save(surveyQuestionTopicOption);
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("surveyquestiontopicoption:update")
	public void update(@RequestBody SurveyQuestionTopicOption surveyQuestionTopicOption){
		surveyQuestionTopicOptionService.update(surveyQuestionTopicOption);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("surveyquestiontopicoption:delete")
	public void delete(@RequestBody String[] ids){
		surveyQuestionTopicOptionService.deleteBatch(ids);
		
		Response.ok();
	}
	
}
