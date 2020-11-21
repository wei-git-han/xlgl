package com.css.app.xlgl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.css.app.xlgl.dao.SurveyQuestionTopicDao;
import com.css.app.xlgl.entity.SurveyQuestionTopic;
import com.css.app.xlgl.service.SurveyQuestionTopicService;



@Service("surveyQuestionTopicService")
public class SurveyQuestionTopicServiceImpl implements SurveyQuestionTopicService {
	@Autowired
	private SurveyQuestionTopicDao surveyQuestionTopicDao;
	
	@Override
	public SurveyQuestionTopic queryObject(String id){
		return surveyQuestionTopicDao.queryObject(id);
	}
	
	@Override
	public List<SurveyQuestionTopic> queryList(Map<String, Object> map){
		return surveyQuestionTopicDao.queryList(map);
	}
	
	@Override
	public void save(SurveyQuestionTopic surveyQuestionTopic){
		surveyQuestionTopicDao.save(surveyQuestionTopic);
	}
	
	@Override
	public void update(SurveyQuestionTopic surveyQuestionTopic){
		surveyQuestionTopicDao.update(surveyQuestionTopic);
	}
	
	@Override
	public void delete(String id){
		surveyQuestionTopicDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		surveyQuestionTopicDao.deleteBatch(ids);
	}
	
}
