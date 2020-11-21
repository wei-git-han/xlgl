package com.css.app.xlgl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.css.app.xlgl.dao.SurveyQuestionDao;
import com.css.app.xlgl.entity.SurveyQuestion;
import com.css.app.xlgl.service.SurveyQuestionService;



@Service("surveyQuestionService")
public class SurveyQuestionServiceImpl implements SurveyQuestionService {
	@Autowired
	private SurveyQuestionDao surveyQuestionDao;
	
	@Override
	public SurveyQuestion queryObject(String id){
		return surveyQuestionDao.queryObject(id);
	}
	
	@Override
	public List<SurveyQuestion> queryList(Map<String, Object> map){
		return surveyQuestionDao.queryList(map);
	}
	
	@Override
	public void save(SurveyQuestion surveyQuestion){
		surveyQuestionDao.save(surveyQuestion);
	}
	
	@Override
	public void update(SurveyQuestion surveyQuestion){
		surveyQuestionDao.update(surveyQuestion);
	}
	
	@Override
	public void delete(String id){
		surveyQuestionDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		surveyQuestionDao.deleteBatch(ids);
	}
	
}
