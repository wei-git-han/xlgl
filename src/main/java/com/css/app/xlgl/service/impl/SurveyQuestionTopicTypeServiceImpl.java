package com.css.app.xlgl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.css.app.xlgl.dao.SurveyQuestionTopicTypeDao;
import com.css.app.xlgl.entity.SurveyQuestionTopicType;
import com.css.app.xlgl.service.SurveyQuestionTopicTypeService;



@Service("surveyQuestionTopicTypeService")
public class SurveyQuestionTopicTypeServiceImpl implements SurveyQuestionTopicTypeService {
	@Autowired
	private SurveyQuestionTopicTypeDao surveyQuestionTopicTypeDao;
	
	@Override
	public SurveyQuestionTopicType queryObject(String id){
		return surveyQuestionTopicTypeDao.queryObject(id);
	}
	
	@Override
	public List<SurveyQuestionTopicType> queryList(Map<String, Object> map){
		return surveyQuestionTopicTypeDao.queryList(map);
	}
	
	@Override
	public void save(SurveyQuestionTopicType surveyQuestionTopicType){
		surveyQuestionTopicTypeDao.save(surveyQuestionTopicType);
	}
	
	@Override
	public void update(SurveyQuestionTopicType surveyQuestionTopicType){
		surveyQuestionTopicTypeDao.update(surveyQuestionTopicType);
	}
	
	@Override
	public void delete(String id){
		surveyQuestionTopicTypeDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		surveyQuestionTopicTypeDao.deleteBatch(ids);
	}
	
}
