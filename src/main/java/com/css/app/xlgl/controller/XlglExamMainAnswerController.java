package com.css.app.xlgl.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.css.app.xlgl.entity.XlglExamMainAnswer;
import com.css.app.xlgl.service.XlglExamMainAnswerService;
import com.css.base.utils.PageUtils;
import com.css.base.utils.Response;
import com.css.base.utils.UUIDUtils;
import com.github.pagehelper.PageHelper;


/**
 * 训练考核-考核清单-主表用户答题表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-03 11:36:19
 */
@Controller
@RequestMapping("/xlglexammainanswer")
public class XlglExamMainAnswerController {
	@Autowired
	private XlglExamMainAnswerService xlglExamMainAnswerService;
	
	/**
	 *考核清单-参考人员/未考人员清单 列表
	 *@param examineId 试卷基本信息表id
	 *@param makeupStatus 是否补考过 0没有，1补过
	 *@param level 查询等级参数
	 *@param replyUserName 查询答题人名称
	 *@param organName 查询答题人的部门名称
	 */
	@ResponseBody
	@RequestMapping("/list")
	public void list(Integer page, Integer limit,String examineId,String makeupStatus,String level,String replyUserName
			,String organName){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		map.put("examineId", examineId);
		map.put("level", level);
		map.put("makeupStatus", makeupStatus);
		map.put("replyUserName", replyUserName);
		map.put("organName", organName);
		//查询列表数据
		List<XlglExamMainAnswer> xlglExamMainAnswerList = xlglExamMainAnswerService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(xlglExamMainAnswerList);
		Response.json("page",pageUtil);
	}
	
	/**
	 *考核清单-当前用户练习的成绩 列表
	 *@param examineId 试卷基本信息表id
	 */
	@ResponseBody
	@RequestMapping("/exerciseList")
	public void exerciseList(Integer page, Integer limit,String examineId){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		map.put("examineId", examineId);
		map.put("makeupStatus", "1");
		//查询列表数据
		List<XlglExamMainAnswer> xlglExamMainAnswerList = xlglExamMainAnswerService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(xlglExamMainAnswerList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	public void info(@PathVariable("id") String id){
		XlglExamMainAnswer xlglExamMainAnswer = xlglExamMainAnswerService.queryObject(id);
		Response.json("xlglExamMainAnswer", xlglExamMainAnswer);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	public void save(@RequestBody XlglExamMainAnswer xlglExamMainAnswer){
		xlglExamMainAnswer.setId(UUIDUtils.random());
		xlglExamMainAnswerService.save(xlglExamMainAnswer);
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public void update(@RequestBody XlglExamMainAnswer xlglExamMainAnswer){
		xlglExamMainAnswerService.update(xlglExamMainAnswer);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public void delete(@RequestBody String[] ids){
		xlglExamMainAnswerService.deleteBatch(ids);
		
		Response.ok();
	}
	
}
