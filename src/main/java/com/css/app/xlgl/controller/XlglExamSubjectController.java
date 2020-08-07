package com.css.app.xlgl.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.css.app.xlgl.entity.XlglExamSubject;
import com.css.app.xlgl.service.XlglExamSubjectService;
import com.css.app.xlgl.service.XlglExamTopicService;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.PageUtils;
import com.css.base.utils.Response;
import com.css.base.utils.StringUtils;
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
@RequestMapping("app/xlgl/xlglexamsubject")
public class XlglExamSubjectController {
	@Autowired
	private XlglExamSubjectService xlglExamSubjectService;
	@Autowired
	private XlglExamTopicService xlglExamTopicService;
	
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
	public void save(XlglExamSubject xlglExamSubject){
		xlglExamSubject.setId(UUIDUtils.random());
		String userId = CurrentUser.getUserId();
		Date date = new Date();
		xlglExamSubject.setCreateDate(date);
		xlglExamSubject.setUpdateDate(date);
		xlglExamSubject.setCreateUser(userId);
		xlglExamSubject.setUpdateUser(userId);
		xlglExamSubjectService.save(xlglExamSubject);
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public void update(XlglExamSubject xlglExamSubject,String delType){
		Date date = new Date();
		xlglExamSubject.setUpdateDate(date);
		xlglExamSubject.setCreateUser(CurrentUser.getUserId());
		xlglExamSubjectService.update(xlglExamSubject);
		if(StringUtils.isNotBlank(delType)) {
			Map<String, Object> map = new HashMap<>();
			map.put("subjectId", xlglExamSubject.getId());
			map.put("topicType", delType);
			xlglExamTopicService.deleteByType(map);
		}
	
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public void delete(String[] ids){
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
		JSONArray jsons = new JSONArray();
		for (XlglExamSubject xlglExamSubject : findList) {
			JSONObject json = new JSONObject();
			json.put("id",xlglExamSubject.getId());
			json.put("label", xlglExamSubject.getSubjectName());
			String[] split =new String[xlglExamSubject.getSubjectType().length()];
			if(xlglExamSubject.getSubjectType() !=null && xlglExamSubject.getSubjectType().contains(",")) {
				split = xlglExamSubject.getSubjectType().split(",");	
			}else if(StringUtils.isNotBlank(xlglExamSubject.getSubjectType())) {
				split[0]=xlglExamSubject.getSubjectType();
				xlglExamSubject.setSubjectTypeAll(split);
			}
			if(split.length>0) {
				JSONArray jsonTypeArray = new JSONArray();
				for (String string : split) {
					JSONObject jsontype = new JSONObject();
					jsontype.put("id",string);
					jsontype.put("type",string);
					switch (string) {
					case "1":
						jsontype.put("label", "单选题");
						break;
					case "2":
						jsontype.put("label", "多选题");
						break;
					case "3":
						jsontype.put("label", "判断题");
						break;
					case "4":
						jsontype.put("label", "填空题");
						break;

					case "5":
						jsontype.put("label", "简答题");
						break;
					default:
						break;
					}
					jsonTypeArray.add(jsontype);
					json.put("children", jsonTypeArray);
				}
				jsons.add(json);
			}
		}
		Response.json(jsons);
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
	
	/**
	 * 选择科目返回题目类型
	 * */
	@ResponseBody
	@RequestMapping("/findTopicBySubId")
	public void findTopicBySubId(String subjectId){
		XlglExamSubject queryObject = xlglExamSubjectService.queryObject(subjectId);
		Map<String ,Object> map =new HashMap<String ,Object>();
		if(queryObject.getSubjectType()!=null && queryObject.getSubjectType().contains(",")) {
			String[] split = queryObject.getSubjectType().split(",");
			map.put("type", split);
		}else if(queryObject.getSubjectType()!=null) {
			String[] split = new String[queryObject.getSubjectType().length()];
			split[0]=queryObject.getSubjectType();
			map.put("type", split);
		}
		
		Response.json("findList", map);
	}
}
