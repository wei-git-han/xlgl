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
import com.css.app.xlgl.entity.SurveyQuestionTopic;
import com.css.app.xlgl.service.SurveyQuestionTopicService;


/**
 * 调查问卷题干表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-11-20 18:51:46
 */
@Controller
@RequestMapping("/surveyquestiontopic")
public class SurveyQuestionTopicController {
	@Autowired
	private SurveyQuestionTopicService surveyQuestionTopicService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("surveyquestiontopic:list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<SurveyQuestionTopic> surveyQuestionTopicList = surveyQuestionTopicService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(surveyQuestionTopicList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	@RequiresPermissions("surveyquestiontopic:info")
	public void info(@PathVariable("id") String id){
		SurveyQuestionTopic surveyQuestionTopic = surveyQuestionTopicService.queryObject(id);
		Response.json("surveyQuestionTopic", surveyQuestionTopic);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	@RequiresPermissions("surveyquestiontopic:save")
	public void save(@RequestBody SurveyQuestionTopic surveyQuestionTopic){
		surveyQuestionTopic.setId(UUIDUtils.random());
		surveyQuestionTopicService.save(surveyQuestionTopic);
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("surveyquestiontopic:update")
	public void update(@RequestBody SurveyQuestionTopic surveyQuestionTopic){
		surveyQuestionTopicService.update(surveyQuestionTopic);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("surveyquestiontopic:delete")
	public void delete(@RequestBody String[] ids){
		surveyQuestionTopicService.deleteBatch(ids);
		
		Response.ok();
	}
	
}
