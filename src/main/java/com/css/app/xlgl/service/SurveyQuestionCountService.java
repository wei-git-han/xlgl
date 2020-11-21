package com.css.app.xlgl.service;

import com.alibaba.fastjson.JSONObject;
import com.css.app.xlgl.entity.SurveyCountQuestion;
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
public interface SurveyQuestionCountService {
	List<SurveyCountQuestion> queryTopList();
	JSONObject querySurveyQuestionCountList(String serveyQuestionId,String ids);
}
