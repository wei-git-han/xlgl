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
import com.css.app.xlgl.entity.SurveyQuestionAnswer;
import com.css.app.xlgl.service.SurveyQuestionAnswerService;


/**
 * 调查问卷问答表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-11-20 19:22:47
 */
@Controller
@RequestMapping("/surveyquestionanswer")
public class SurveyQuestionAnswerController {
	@Autowired
	private SurveyQuestionAnswerService surveyQuestionAnswerService;
	
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
	 */
	@ResponseBody
	@RequestMapping("/save")
	@RequiresPermissions("surveyquestionanswer:save")
	public void save(@RequestBody SurveyQuestionAnswer surveyQuestionAnswer){
		surveyQuestionAnswer.setId(UUIDUtils.random());
		surveyQuestionAnswerService.save(surveyQuestionAnswer);
		
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
	
}
