package com.css.app.xlgl.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.css.app.xlgl.entity.SurveyQuestionExtendInfo;
import com.css.app.xlgl.entity.SurveyQuestionTopic;
import com.css.app.xlgl.entity.SurveyQuestionTopicOption;
import com.css.app.xlgl.service.SurveyQuestionExtendInfoService;
import com.css.app.xlgl.service.SurveyQuestionTopicOptionService;
import com.css.app.xlgl.service.SurveyQuestionTopicService;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.css.app.xlgl.dao.SurveyQuestionDao;
import com.css.app.xlgl.entity.SurveyQuestion;
import com.css.app.xlgl.service.SurveyQuestionService;



@Service("surveyQuestionService")
public class SurveyQuestionServiceImpl implements SurveyQuestionService {
	@Autowired
	private SurveyQuestionDao surveyQuestionDao;
	@Autowired
	private SurveyQuestionTopicService surveyQuestionTopicService;
	@Autowired
	private SurveyQuestionTopicOptionService surveyQuestionTopicOptionService;
	@Autowired
	private SurveyQuestionExtendInfoService surveyQuestionExtendInfoService;

	@Override
	public SurveyQuestion queryObject(String id){
		return surveyQuestionDao.queryObject(id);
	}
	
	@Override
	public List<SurveyQuestion> queryList(Map<String, Object> map){
		return surveyQuestionDao.queryList(map);
	}

	@Override
	public JSONObject querySurveyQuestionList(String serveyQuestionId){
        SurveyQuestion surveyQuestion = surveyQuestionDao.queryObject(serveyQuestionId);
        JSONObject questionObject = new JSONObject();
        questionObject.put("surveyName", surveyQuestion.getSurveyName());
        questionObject.put("remork", surveyQuestion.getRemark());
        List<SurveyQuestionExtendInfo> surveyQuestionExtendInfos = surveyQuestionExtendInfoService.queryList(null);
        questionObject.put("userArray", surveyQuestionExtendInfos);
        JSONArray questionArray = new JSONArray();
        List<SurveyQuestionTopic> topicsList = surveyQuestionTopicService.queryTopicListByQuestionId(surveyQuestion.getId());
        topicsList.forEach(
                e -> {
                    JSONObject topicObject = new JSONObject();
                    topicObject.put("topicId",e.getId());
                    topicObject.put("questionContent",e.getQuestionContent());
                    topicObject.put("questionTopicTypeId",e.getQuestionTopicTypeId());
                    topicObject.put("questionTopicTypeName",e.getQuestionTopicTypeName());
                    List<SurveyQuestionTopicOption> optionsList = surveyQuestionTopicOptionService.queryOptionListByTopicId(e.getId());
                    topicObject.put("optionsList",optionsList);
                    questionArray.add(topicObject);
                }
        );
        questionObject.put("questionArray", questionArray);
        return questionObject;
	}

	@Override
	public List<SurveyQuestion> surveyQuestionList(Map<String, Object> map){
        List<SurveyQuestion> surveyQuestions = surveyQuestionDao.surveyQuestionList(map);
        return surveyQuestions;
	}

	@Override
	public void save(SurveyQuestion surveyQuestion){
		surveyQuestionDao.save(surveyQuestion);
	}
	
	@Override
	public void update(SurveyQuestion surveyQuestion){
		surveyQuestionDao.update(surveyQuestion);
	}
	
	@Override
	public void delete(String id){
		surveyQuestionDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		surveyQuestionDao.deleteBatch(ids);
	}

	@Override
	public List<SurveyQuestion> findAll() {
		List<SurveyQuestion> list =surveyQuestionDao.findAll();
		return list;
	}
	
}
