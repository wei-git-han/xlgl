package com.css.app.xlgl.service;

import com.css.app.xlgl.entity.SurveyQuestionAnswer;
import com.css.app.xlgl.entity.SurveyQuestionTopic;

import java.util.List;
import java.util.Map;

/**
 * 调查问卷问答表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-11-20 19:22:47
 */
public interface SurveyQuestionAnswerService {
	
	SurveyQuestionAnswer queryObject(String id);
	
	List<SurveyQuestionAnswer> queryList(Map<String, Object> map);

	List<SurveyQuestionAnswer> queryCountAnswerList(Map<String, Object> map);

	List<SurveyQuestionTopic> queryCountOptionList(String id);
	
	void save(SurveyQuestionAnswer surveyQuestionAnswer);
	
	void update(SurveyQuestionAnswer surveyQuestionAnswer);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);

	boolean isSave(String surverQuestionId, String userId);

	boolean saveAnswer(String surverQuestionId, String surveyQuestionAnswer, String extendInfoId);
}
