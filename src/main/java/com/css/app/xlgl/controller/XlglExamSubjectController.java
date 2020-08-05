package com.css.app.xlgl.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.css.app.xlgl.entity.XlglExamSubject;
import com.css.app.xlgl.service.XlglExamSubjectService;
import com.css.base.utils.PageUtils;
import com.css.base.utils.Response;
import com.css.base.utils.UUIDUtils;
import com.github.pagehelper.PageHelper;


/**
 * 训练管理-考核-题目维护-科目表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-07-28 16:17:20
 */
@Controller
@RequestMapping("/xlglexamsubject")
public class XlglExamSubjectController {
	@Autowired
	private XlglExamSubjectService xlglExamSubjectService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<XlglExamSubject> xlglExamSubjectList = xlglExamSubjectService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(xlglExamSubjectList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	public void info(@PathVariable("id") String id){
		XlglExamSubject xlglExamSubject = xlglExamSubjectService.queryObject(id);
		Response.json("xlglExamSubject", xlglExamSubject);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	public void save(@RequestBody XlglExamSubject xlglExamSubject){
		xlglExamSubject.setId(UUIDUtils.random());
		xlglExamSubjectService.save(xlglExamSubject);
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public void update(@RequestBody XlglExamSubject xlglExamSubject){
		xlglExamSubjectService.update(xlglExamSubject);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public void delete(@RequestBody String[] ids){
		xlglExamSubjectService.deleteBatch(ids);
		
		Response.ok();
	}
	/**
	 * 题库列表
	 * */
	@ResponseBody
	@RequestMapping("/subject")
	public void subjectList() {
		List<XlglExamSubject> findList = xlglExamSubjectService.findList();
		List<XlglExamSubject> subjectList = new ArrayList<XlglExamSubject>();
		for (XlglExamSubject xlglExamSubject : findList) {
			if(xlglExamSubject.getSubjectType() !=null && xlglExamSubject.getSubjectType().contains(",")) {
				String[] split = xlglExamSubject.getSubjectType().split(",");
				xlglExamSubject.setSubjectTypeAll(split);
			}else if(xlglExamSubject.getSubjectType() !=null) {
				String[] split = new String[1];
				split[0]=xlglExamSubject.getSubjectType();
				xlglExamSubject.setSubjectTypeAll(split);
			}
			subjectList.add(xlglExamSubject);
		}
		Response.json("subjectList", subjectList);
	}
	/**
	 * 考试科目选择 下拉框
	 * */
	@ResponseBody
	@RequestMapping("/subjectListAll")
	public void subjectListAll(){
		List<XlglExamSubject> findList = xlglExamSubjectService.findList();
		Response.json("findList", findList);
	}
}
