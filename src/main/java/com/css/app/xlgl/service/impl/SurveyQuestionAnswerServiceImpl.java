package com.css.app.xlgl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.css.app.xlgl.dao.SurveyQuestionAnswerDao;
import com.css.app.xlgl.entity.SurveyQuestionAnswer;
import com.css.app.xlgl.service.SurveyQuestionAnswerService;



@Service("surveyQuestionAnswerService")
public class SurveyQuestionAnswerServiceImpl implements SurveyQuestionAnswerService {
	@Autowired
	private SurveyQuestionAnswerDao surveyQuestionAnswerDao;
	
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
	
}
