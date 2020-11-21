package com.css.app.xlgl.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
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
import com.css.app.xlgl.entity.SurveyQuestion;
import com.css.app.xlgl.service.SurveyQuestionService;

import javax.servlet.http.HttpServletRequest;


/**
 * 调查问卷表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-11-20 18:45:19
 */
@Controller
@RequestMapping("app/surveyquestion")
public class SurveyQuestionController {
	@Autowired
	private SurveyQuestionService surveyQuestionService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("surveyquestion:list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);

		//查询列表数据
		List<SurveyQuestion> surveyQuestionList = surveyQuestionService.queryList(map);

		PageUtils pageUtil = new PageUtils(surveyQuestionList);
		Response.json("page",pageUtil);
	}

	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/querySurveyQuestionList")
	public void querySurveyQuestionList(String serveyQuestionId){
		//查询列表数据
		JSONObject surveyQuestionList = surveyQuestionService.querySurveyQuestionList(serveyQuestionId);
		Response.json("surveyQuestionList",surveyQuestionList);
	}

	/**
	 * 调查列表
	 */
	@ResponseBody
	@RequestMapping("/surveyQuestionList")
	public void surveyQuestionList(Integer page, Integer limit, String title) {
		Map<String, Object> map = new HashMap<>();
		map.put("title", title);
		PageHelper.startPage(page, limit);
		// 查询列表数据
		List<SurveyQuestion> xlglWarTacticList = surveyQuestionService.surveyQuestionList(map);;
		PageUtils pageUtil = new PageUtils(xlglWarTacticList);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("rows", xlglWarTacticList);
		result.put("page", pageUtil.getCurrPage());
		result.put("total", pageUtil.getTotalCount());
		Response.json(result);
	}

	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	@RequiresPermissions("surveyquestion:info")
	public void info(@PathVariable("id") String id){
		SurveyQuestion surveyQuestion = surveyQuestionService.queryObject(id);
		Response.json("surveyQuestion", surveyQuestion);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	@RequiresPermissions("surveyquestion:save")
	public void save(@RequestBody SurveyQuestion surveyQuestion){
		surveyQuestion.setId(UUIDUtils.random());
		surveyQuestionService.save(surveyQuestion);
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("surveyquestion:update")
	public void update(@RequestBody SurveyQuestion surveyQuestion){
		surveyQuestionService.update(surveyQuestion);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("surveyquestion:delete")
	public void delete(@RequestBody String[] ids){
		surveyQuestionService.deleteBatch(ids);
		
		Response.ok();
	}
	
}
