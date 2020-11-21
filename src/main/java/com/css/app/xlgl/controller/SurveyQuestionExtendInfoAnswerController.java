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
import com.css.app.xlgl.entity.SurveyQuestionExtendInfoAnswer;
import com.css.app.xlgl.service.SurveyQuestionExtendInfoAnswerService;


/**
 * 调查问卷扩展表问答表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-11-21 14:59:21
 */
@Controller
@RequestMapping("/surveyquestionextendinfoanswer")
public class SurveyQuestionExtendInfoAnswerController {
	@Autowired
	private SurveyQuestionExtendInfoAnswerService surveyQuestionExtendInfoAnswerService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("surveyquestionextendinfoanswer:list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<SurveyQuestionExtendInfoAnswer> surveyQuestionExtendInfoAnswerList = surveyQuestionExtendInfoAnswerService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(surveyQuestionExtendInfoAnswerList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	@RequiresPermissions("surveyquestionextendinfoanswer:info")
	public void info(@PathVariable("id") String id){
		SurveyQuestionExtendInfoAnswer surveyQuestionExtendInfoAnswer = surveyQuestionExtendInfoAnswerService.queryObject(id);
		Response.json("surveyQuestionExtendInfoAnswer", surveyQuestionExtendInfoAnswer);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	@RequiresPermissions("surveyquestionextendinfoanswer:save")
	public void save(@RequestBody SurveyQuestionExtendInfoAnswer surveyQuestionExtendInfoAnswer){
		surveyQuestionExtendInfoAnswer.setId(UUIDUtils.random());
		surveyQuestionExtendInfoAnswerService.save(surveyQuestionExtendInfoAnswer);
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("surveyquestionextendinfoanswer:update")
	public void update(@RequestBody SurveyQuestionExtendInfoAnswer surveyQuestionExtendInfoAnswer){
		surveyQuestionExtendInfoAnswerService.update(surveyQuestionExtendInfoAnswer);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("surveyquestionextendinfoanswer:delete")
	public void delete(@RequestBody String[] ids){
		surveyQuestionExtendInfoAnswerService.deleteBatch(ids);
		
		Response.ok();
	}
	
}
