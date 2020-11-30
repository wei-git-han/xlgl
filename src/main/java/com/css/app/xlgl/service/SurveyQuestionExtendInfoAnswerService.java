package com.css.app.xlgl.service;

import com.css.app.xlgl.entity.SurveyQuestionExtendInfoAnswer;

import java.util.List;
import java.util.Map;

/**
 * 调查问卷扩展表问答表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-11-21 14:59:21
 */
public interface SurveyQuestionExtendInfoAnswerService {
	
	SurveyQuestionExtendInfoAnswer queryObject(String id);
	
	List<SurveyQuestionExtendInfoAnswer> queryList(Map<String, Object> map);
	
	void save(SurveyQuestionExtendInfoAnswer surveyQuestionExtendInfoAnswer);
	
	void update(SurveyQuestionExtendInfoAnswer surveyQuestionExtendInfoAnswer);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
}
