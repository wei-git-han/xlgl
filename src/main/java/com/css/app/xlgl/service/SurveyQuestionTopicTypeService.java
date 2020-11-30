package com.css.app.xlgl.service;

import com.css.app.xlgl.entity.SurveyQuestionTopicType;

import java.util.List;
import java.util.Map;

/**
 * 调查问卷题干类型表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-11-20 18:52:12
 */
public interface SurveyQuestionTopicTypeService {
	
	SurveyQuestionTopicType queryObject(String id);
	
	List<SurveyQuestionTopicType> queryList(Map<String, Object> map);
	
	void save(SurveyQuestionTopicType surveyQuestionTopicType);
	
	void update(SurveyQuestionTopicType surveyQuestionTopicType);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
}
