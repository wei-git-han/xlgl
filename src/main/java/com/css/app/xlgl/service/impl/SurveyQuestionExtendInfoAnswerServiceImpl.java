package com.css.app.xlgl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.css.app.xlgl.dao.SurveyQuestionExtendInfoAnswerDao;
import com.css.app.xlgl.entity.SurveyQuestionExtendInfoAnswer;
import com.css.app.xlgl.service.SurveyQuestionExtendInfoAnswerService;



@Service("surveyQuestionExtendInfoAnswerService")
public class SurveyQuestionExtendInfoAnswerServiceImpl implements SurveyQuestionExtendInfoAnswerService {
	@Autowired
	private SurveyQuestionExtendInfoAnswerDao surveyQuestionExtendInfoAnswerDao;
	
	@Override
	public SurveyQuestionExtendInfoAnswer queryObject(String id){
		return surveyQuestionExtendInfoAnswerDao.queryObject(id);
	}
	
	@Override
	public List<SurveyQuestionExtendInfoAnswer> queryList(Map<String, Object> map){
		return surveyQuestionExtendInfoAnswerDao.queryList(map);
	}
	
	@Override
	public void save(SurveyQuestionExtendInfoAnswer surveyQuestionExtendInfoAnswer){
		surveyQuestionExtendInfoAnswerDao.save(surveyQuestionExtendInfoAnswer);
	}
	
	@Override
	public void update(SurveyQuestionExtendInfoAnswer surveyQuestionExtendInfoAnswer){
		surveyQuestionExtendInfoAnswerDao.update(surveyQuestionExtendInfoAnswer);
	}
	
	@Override
	public void delete(String id){
		surveyQuestionExtendInfoAnswerDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		surveyQuestionExtendInfoAnswerDao.deleteBatch(ids);
	}
	
}
