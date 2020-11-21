package com.css.app.xlgl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.css.app.xlgl.dao.SurveyQuestionAnswerDao;
import com.css.app.xlgl.entity.SurveyQuestionAnswer;
import com.css.app.xlgl.entity.SurveyQuestionExtendInfoAnswer;
import com.css.app.xlgl.service.SurveyQuestionAnswerService;
import com.css.app.xlgl.service.SurveyQuestionExtendInfoAnswerService;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.UUIDUtils;



@Service("surveyQuestionAnswerService")
public class SurveyQuestionAnswerServiceImpl implements SurveyQuestionAnswerService {
	@Autowired
	private SurveyQuestionAnswerDao surveyQuestionAnswerDao;
	@Autowired
	private SurveyQuestionExtendInfoAnswerService surveyQuestionExtendInfoAnswerService;
	
	@Override
	public SurveyQuestionAnswer queryObject(String id){
		return surveyQuestionAnswerDao.queryObject(id);
	}
	
	@Override
	public List<SurveyQuestionAnswer> queryList(Map<String, Object> map){
		return surveyQuestionAnswerDao.queryList(map);
	}
	
	@Override
	public void save(SurveyQuestionAnswer surveyQuestionAnswer){
		surveyQuestionAnswerDao.save(surveyQuestionAnswer);
	}
	
	@Override
	public void update(SurveyQuestionAnswer surveyQuestionAnswer){
		surveyQuestionAnswerDao.update(surveyQuestionAnswer);
	}
	
	@Override
	public void delete(String id){
		surveyQuestionAnswerDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		surveyQuestionAnswerDao.deleteBatch(ids);
	}

	@Override
	public boolean isSave(String surverQuestionId, String userId) {
		List<SurveyQuestionAnswer> isSave = surveyQuestionAnswerDao.isSave(surverQuestionId,userId);
		if(isSave.size()>0) {
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public boolean saveAnswer(String surverQuestionId, String surveyQuestionAnswer, String extendInfoId) {
		String userId = CurrentUser.getUserId();
		List<SurveyQuestionAnswer> optionList = JSONArray.parseArray(surveyQuestionAnswer, SurveyQuestionAnswer.class);
		String[] extendInfoIds = extendInfoId.split(",");
		Date nowDate = new Date();
		try {
			for (String id : extendInfoIds) {
				SurveyQuestionExtendInfoAnswer userInfo = new SurveyQuestionExtendInfoAnswer();
				userInfo.setId(UUIDUtils.random());
				userInfo.setCreateTime(nowDate);
				userInfo.setCurrentUserId(userId);
				userInfo.setExtendInfoId(id);
				surveyQuestionExtendInfoAnswerService.save(userInfo);
			}
			for (SurveyQuestionAnswer option : optionList) {
				SurveyQuestionAnswer answer = new SurveyQuestionAnswer();
				answer.setId(UUIDUtils.random());
				answer.setCreateTime(nowDate);
				answer.setCreateUserId(userId);
				answer.setCreateUserName(CurrentUser.getUsername());
				answer.setSurverQuestionId(surverQuestionId);
				answer.setQuestionTopicId(option.getQuestionTopicId());
				answer.setQuestionTopicOptionId(option.getQuestionTopicOptionId());
				surveyQuestionAnswerDao.save(answer);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
}
