package com.css.app.xlgl.service;

import com.css.app.xlgl.entity.SurveyQuestionTopicOption;

import java.util.List;
import java.util.Map;

/**
 * 调查问卷题干的选项表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-11-20 18:52:05
 */
public interface SurveyQuestionTopicOptionService {
	
	SurveyQuestionTopicOption queryObject(String id);
	
	List<SurveyQuestionTopicOption> queryList(Map<String, Object> map);

	List<SurveyQuestionTopicOption> queryOptionListByTopicId(String questionTopicId);
	List<SurveyQuestionTopicOption> queryCountOptionList(Map<String, Object> map);
	SurveyQuestionTopicOption queryCountOptionObject(Map<String, Object> map);

	void save(SurveyQuestionTopicOption surveyQuestionTopicOption);
	
	void update(SurveyQuestionTopicOption surveyQuestionTopicOption);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
}
