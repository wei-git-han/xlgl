package com.css.app.xlgl.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.css.app.xlgl.dto.PersonalFileDto;
import com.css.app.xlgl.entity.PersonalFile;
import com.css.app.xlgl.entity.XlglExamSubject;
import com.css.app.xlgl.service.PersonalFileService;
import com.css.app.xlgl.service.XlglExamMainAnswerService;
import com.css.app.xlgl.service.XlglExamSubjectService;
import com.css.base.entity.SSOUser;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.Response;
/**
 * 
 * 训练档案-个人训练档案
 * */
@Controller
@RequestMapping("app/xlgl/personalfile")
public class PersonalFileController {
	@Autowired
	private XlglExamMainAnswerService xlglExamMainAnswerService;
	@Autowired
	private PersonalFileService personalFileService;
	@Autowired
	private XlglExamSubjectService xlglExamSubjectService;
	/**
	 * 训练档案-个人训练档案 列表
	 * 
	 * */
	@ResponseBody
	@RequestMapping("/list")
	public void list() {
		SSOUser ssoUser = CurrentUser.getSSOUser();
		JSONObject jsonObject = new JSONObject();
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("replyUserId", ssoUser.getUserId());
		List<XlglExamSubject> subjectList = xlglExamSubjectService.queryList(null);
		
		List<PersonalFile> queryList = personalFileService.queryList(map);
		
		List<PersonalFileDto> list =new ArrayList<PersonalFileDto>();
		for (XlglExamSubject xlglExamSubject : subjectList) {
			List<PersonalFile> PersonalFilelist =new ArrayList<PersonalFile>();
			for (PersonalFile personalFile : queryList) {
				if(xlglExamSubject.getSubjectName().equals(personalFile.getExamineSubjectName())) {
					PersonalFilelist.add(personalFile);
				}
			}
			if(PersonalFilelist.size()>0) {
				PersonalFileDto personalFileDto = new PersonalFileDto();
				personalFileDto.setExamineSubjectName(xlglExamSubject.getSubjectName());
				personalFileDto.setList(PersonalFilelist);
				list.add(personalFileDto);
			}	
		}
		jsonObject.put("personalFileList", list);
		jsonObject.put("currentUserName", ssoUser.getFullname());
		jsonObject.put("orgName", ssoUser.getOrgName());
		Response.json(jsonObject);
	}
	/**
	 * 训练档案-个人训练档案用户详情按钮训练考核
	 * */
	@ResponseBody
	@RequestMapping("/count")
	public void count() {
		JSONObject jsonObject = new JSONObject();
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("replyUserId", CurrentUser.getUserId());
		int total = personalFileService.queryTotal(map);
		map.put("level", "1");
		int levelTotal = personalFileService.queryTotal(map);
		Integer levelrate = (levelTotal/total)*100;
		String level ="";
		if(levelrate >= 85) {
			level = "优秀";
		}else if(70 <= levelrate && levelrate < 85){
			level = "优良";
		}else if(60 <= levelrate && levelrate < 70) {
			level = "及格";
		}else {
			level = "不及格";
		}
		jsonObject.put("level", level);//优秀等级
		jsonObject.put("total", total);//已考科目总数
		jsonObject.put("levelrate", levelrate);//优秀比率
		Response.json(jsonObject);
	}
	
	/**
	 * 训练档案-个人训练档案 详情按钮 训练考核统计数据，点击出现折叠框 考试列表
	 * */
	@ResponseBody
	@RequestMapping("/subjectList")
	public void subjectList(String subjectId) {
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("replyUserId", CurrentUser.getUserId());
		map.put("subjectId", subjectId);
		List<PersonalFile> list = personalFileService.queryListBySubjectId(map);
		Response.json("subjectList",list);
	}
	
	
	/**
	 * 训练档案-个人训练档案 详情按钮 训练考核统计数据，科目标题
	 * */
	@ResponseBody
	@RequestMapping("/subjectTitle")
	public void subjectTitle() {
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("replyUserId", CurrentUser.getUserId());
		List<PersonalFile> titleList = personalFileService.getTitleList(map);
		Response.json("titleList",titleList);
	}
	
	/**
	 * 训练档案-个人训练档案 详情按钮 用户成绩与排名
	 * */
	@ResponseBody
	@RequestMapping("/userPerformance")
	public void userPerformance() {
		JSONObject jsonObject = new JSONObject();
		List<PersonalFile> queryRanking = personalFileService.queryRanking();
		SSOUser ssoUser = CurrentUser.getSSOUser();
		String userId = ssoUser.getUserId();
		for (PersonalFile personalFile : queryRanking) {
			if(personalFile.getReplyUserId().equals(userId)) {
				jsonObject.put("totalFraction", personalFile);
				break;
			}
		}
		jsonObject.put("userId", userId);
		jsonObject.put("userName", ssoUser.getFullname());
		jsonObject.put("orgName", ssoUser.getOrgName());
		Response.json(jsonObject);
	}
}
