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

import com.css.base.utils.CurrentUser;
import com.css.base.utils.PageUtils;
import com.github.pagehelper.PageHelper;
import com.css.base.utils.Response;
import com.alibaba.fastjson.JSON;
import com.css.app.xlgl.entity.SurveyQuestion;
import com.css.app.xlgl.entity.SurveyQuestionAnswer;
import com.css.app.xlgl.service.SurveyQuestionAnswerService;
import com.css.app.xlgl.service.SurveyQuestionService;


/**
 * 调查问卷问答表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-11-20 19:22:47
 */
@Controller
@RequestMapping("app/xlgl/surveyquestionanswer")
public class SurveyQuestionAnswerController {
	@Autowired
	private SurveyQuestionAnswerService surveyQuestionAnswerService;
	@Autowired
	private SurveyQuestionService surveyQuestionService;
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("surveyquestionanswer:list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<SurveyQuestionAnswer> surveyQuestionAnswerList = surveyQuestionAnswerService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(surveyQuestionAnswerList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	@RequiresPermissions("surveyquestionanswer:info")
	public void info(@PathVariable("id") String id){
		SurveyQuestionAnswer surveyQuestionAnswer = surveyQuestionAnswerService.queryObject(id);
		Response.json("surveyQuestionAnswer", surveyQuestionAnswer);
	}
	
	/**
	 * 保存
	 * surveyQuestionAnswer 问卷答案id
	 * extendInfoId 问卷人性别、年龄、营区信息
	 * 
	 */
	@ResponseBody
	@RequestMapping("/save")
	@RequiresPermissions("surveyquestionanswer:save")
	public void save(String surverQuestionId,String surveyQuestionAnswer,String extendInfoId,String userName){
		System.out.println(surveyQuestionAnswer);
		Map<String, Object> map = new HashMap<String, Object>();
		
		boolean isSave = surveyQuestionAnswerService.isSave(surverQuestionId,CurrentUser.getUserId());
		if(isSave) {
			map.put("code", 1);
			map.put("msg", "保存失败，问卷调查已填写");
			Response.json(map);
			return ;
		}
		boolean issucess = surveyQuestionAnswerService.saveAnswer(surverQuestionId,surveyQuestionAnswer,extendInfoId);
		if(!issucess) {
			map.put("code", 1);
			map.put("msg", "保存失败");
			Response.json(map);
			return;
		}
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("surveyquestionanswer:update")
	public void update(@RequestBody SurveyQuestionAnswer surveyQuestionAnswer){
		surveyQuestionAnswerService.update(surveyQuestionAnswer);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("surveyquestionanswer:delete")
	public void delete(@RequestBody String[] ids){
		surveyQuestionAnswerService.deleteBatch(ids);
		
		Response.ok();
	}
	@ResponseBody
	@RequestMapping("/isSave")
	public void isSave(){
		Map<String, Object> map = new HashMap<String, Object>();
		List<SurveyQuestion> question = surveyQuestionService.findAll();
		if(question.size()==0) {
			map.put("code", "1");
		}
		for (SurveyQuestion surveyQuestion : question) {
			boolean isSave = surveyQuestionAnswerService.isSave(surveyQuestion.getId(),CurrentUser.getUserId());
			if(!isSave) {
				map.put("code", surveyQuestion.getId());
				map.put("msg", "您有未填写的调查问卷表");
				break;
			}else {
				map.put("code", "1");
			}
		}
		Response.json(map);
	}
	
	
	
}
