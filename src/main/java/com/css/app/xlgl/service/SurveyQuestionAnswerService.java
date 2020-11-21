package com.css.app.xlgl.service;

import com.css.app.xlgl.entity.SurveyQuestionAnswer;

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
	
	void save(SurveyQuestionAnswer surveyQuestionAnswer);
	
	void update(SurveyQuestionAnswer surveyQuestionAnswer);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
}
