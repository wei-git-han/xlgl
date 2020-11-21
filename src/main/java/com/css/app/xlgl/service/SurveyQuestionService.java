package com.css.app.xlgl.service;

import com.alibaba.fastjson.JSONObject;
import com.css.app.xlgl.entity.SurveyQuestion;

import java.util.List;
import java.util.Map;

/**
 * 调查问卷表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-11-20 18:45:19
 */
public interface SurveyQuestionService {
	
	SurveyQuestion queryObject(String id);
	
	List<SurveyQuestion> queryList(Map<String, Object> map);

    JSONObject querySurveyQuestionList(String serveyQuestionId);

	List<SurveyQuestion> surveyQuestionList(Map<String, Object> map);

	void save(SurveyQuestion surveyQuestion);
	
	void update(SurveyQuestion surveyQuestion);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
}
