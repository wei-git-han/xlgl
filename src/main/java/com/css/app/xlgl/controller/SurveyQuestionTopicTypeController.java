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
import com.css.app.xlgl.entity.SurveyQuestionTopicType;
import com.css.app.xlgl.service.SurveyQuestionTopicTypeService;


/**
 * 调查问卷题干类型表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-11-20 18:52:12
 */
@Controller
@RequestMapping("/surveyquestiontopictype")
public class SurveyQuestionTopicTypeController {
	@Autowired
	private SurveyQuestionTopicTypeService surveyQuestionTopicTypeService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("surveyquestiontopictype:list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<SurveyQuestionTopicType> surveyQuestionTopicTypeList = surveyQuestionTopicTypeService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(surveyQuestionTopicTypeList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	@RequiresPermissions("surveyquestiontopictype:info")
	public void info(@PathVariable("id") String id){
		SurveyQuestionTopicType surveyQuestionTopicType = surveyQuestionTopicTypeService.queryObject(id);
		Response.json("surveyQuestionTopicType", surveyQuestionTopicType);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	@RequiresPermissions("surveyquestiontopictype:save")
	public void save(@RequestBody SurveyQuestionTopicType surveyQuestionTopicType){
		surveyQuestionTopicType.setId(UUIDUtils.random());
		surveyQuestionTopicTypeService.save(surveyQuestionTopicType);
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("surveyquestiontopictype:update")
	public void update(@RequestBody SurveyQuestionTopicType surveyQuestionTopicType){
		surveyQuestionTopicTypeService.update(surveyQuestionTopicType);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("surveyquestiontopictype:delete")
	public void delete(@RequestBody String[] ids){
		surveyQuestionTopicTypeService.deleteBatch(ids);
		
		Response.ok();
	}
	
}
