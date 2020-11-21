package com.css.app.xlgl.service;

import com.css.app.xlgl.entity.SurveyQuestionExtendInfo;

import java.util.List;
import java.util.Map;

/**
 * 调查问卷扩展表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-11-21 14:46:59
 */
public interface SurveyQuestionExtendInfoService {
	
	SurveyQuestionExtendInfo queryObject(String id);
	
	List<SurveyQuestionExtendInfo> queryList(Map<String, Object> map);
	
	void save(SurveyQuestionExtendInfo surveyQuestionExtendInfo);
	
	void update(SurveyQuestionExtendInfo surveyQuestionExtendInfo);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
}
