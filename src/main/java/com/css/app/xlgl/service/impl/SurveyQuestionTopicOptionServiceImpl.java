package com.css.app.xlgl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.css.app.xlgl.dao.SurveyQuestionTopicOptionDao;
import com.css.app.xlgl.entity.SurveyQuestionTopicOption;
import com.css.app.xlgl.service.SurveyQuestionTopicOptionService;



@Service("surveyQuestionTopicOptionService")
public class SurveyQuestionTopicOptionServiceImpl implements SurveyQuestionTopicOptionService {
	@Autowired
	private SurveyQuestionTopicOptionDao surveyQuestionTopicOptionDao;
	
	@Override
	public SurveyQuestionTopicOption queryObject(String id){
		return surveyQuestionTopicOptionDao.queryObject(id);
	}
	
	@Override
	public List<SurveyQuestionTopicOption> queryList(Map<String, Object> map){
		return surveyQuestionTopicOptionDao.queryList(map);
	}

	@Override
	public List<SurveyQuestionTopicOption> queryOptionListByTopicId(String questionTopicId){
		return surveyQuestionTopicOptionDao.queryOptionListByTopicId(questionTopicId);
	}
	@Override
	public List<SurveyQuestionTopicOption> queryCountOptionList(Map<String, Object> map){
		return surveyQuestionTopicOptionDao.queryCountOptionList(map);
	}

	@Override
	public SurveyQuestionTopicOption queryCountOptionObject(Map<String, Object> map){
		return surveyQuestionTopicOptionDao.queryCountOptionObject(map);
	}

	@Override
	public void save(SurveyQuestionTopicOption surveyQuestionTopicOption){
		surveyQuestionTopicOptionDao.save(surveyQuestionTopicOption);
	}
	
	@Override
	public void update(SurveyQuestionTopicOption surveyQuestionTopicOption){
		surveyQuestionTopicOptionDao.update(surveyQuestionTopicOption);
	}
	
	@Override
	public void delete(String id){
		surveyQuestionTopicOptionDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		surveyQuestionTopicOptionDao.deleteBatch(ids);
	}
	
}
