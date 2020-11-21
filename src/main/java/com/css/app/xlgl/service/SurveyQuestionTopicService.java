package com.css.app.xlgl.service;

import com.css.app.xlgl.entity.SurveyQuestionTopic;

import java.util.List;
import java.util.Map;

/**
 * 调查问卷题干表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-11-20 18:51:46
 */
public interface SurveyQuestionTopicService {
	
	SurveyQuestionTopic queryObject(String id);
	
	List<SurveyQuestionTopic> queryList(Map<String, Object> map);
	
	void save(SurveyQuestionTopic surveyQuestionTopic);
	
	void update(SurveyQuestionTopic surveyQuestionTopic);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
}
