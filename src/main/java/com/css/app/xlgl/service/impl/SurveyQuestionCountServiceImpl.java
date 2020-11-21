package com.css.app.xlgl.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.css.addbase.apporgan.dao.BaseAppUserDao;
import com.css.app.xlgl.dao.SurveyQuestionCountDao;
import com.css.app.xlgl.dao.SurveyQuestionDao;
import com.css.app.xlgl.entity.*;
import com.css.app.xlgl.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("SurveyQuestionCountService")
public class SurveyQuestionCountServiceImpl implements SurveyQuestionCountService {
	@Autowired
	private SurveyQuestionCountDao surveyQuestionCountDao;
	@Autowired
	private SurveyQuestionDao surveyQuestionDao;
	@Autowired
	private SurveyQuestionTopicService surveyQuestionTopicService;
	@Autowired
	private SurveyQuestionTopicOptionService surveyQuestionTopicOptionService;
	@Autowired
	private SurveyQuestionExtendInfoService surveyQuestionExtendInfoService;
	@Autowired
	private BaseAppUserDao baseAppUserDao;
	@Override
	public List<SurveyCountQuestion> queryTopList(){
		return surveyQuestionCountDao.queryTopList();
	}
	@Override
	public JSONObject querySurveyQuestionCountList(String serveyQuestionId,String ids){
		Map<String, Object> map = new HashMap<>();
		//top
		List<SurveyCountQuestion> surveyCountQuestion = surveyQuestionCountDao.queryTopList();
		int total = baseAppUserDao.queryTotal(map);
		SurveyQuestion surveyQuestion = surveyQuestionDao.queryObject(serveyQuestionId);
		JSONObject questionObject = new JSONObject();
		questionObject.put("surveyName", surveyQuestion.getSurveyName());
		questionObject.put("remork", surveyQuestion.getRemark());
		List<SurveyQuestionExtendInfo> surveyQuestionExtendInfos = surveyQuestionExtendInfoService.queryList(null);
		questionObject.put("userArray", surveyQuestionExtendInfos);
		int shouji = Integer.valueOf(surveyCountQuestion.get(0).getCount());
		questionObject.put("shouji", shouji);
		questionObject.put("weixie", total - shouji);
		questionObject.put("startTime", surveyCountQuestion.get(0).getStartTime());
		questionObject.put("endTime", surveyCountQuestion.get(0).getEndTime());
		JSONArray questionArray = new JSONArray();
		List<SurveyQuestionTopic> topicsList = surveyQuestionTopicService.queryTopicListByQuestionId(surveyQuestion.getId());
		topicsList.forEach(
				e -> {
					JSONObject topicObject = new JSONObject();
					topicObject.put("topicId",e.getId());
					topicObject.put("questionContent",e.getQuestionContent());
					topicObject.put("questionTopicTypeId",e.getQuestionTopicTypeId());
					topicObject.put("questionTopicTypeName",e.getQuestionTopicTypeName());
					List<SurveyQuestionTopicOption> optionsList = surveyQuestionTopicOptionService.queryCountOptionList(e.getId());
					for(SurveyQuestionTopicOption opt : optionsList){
						BigDecimal piao = new BigDecimal(opt.getPiao());
						BigDecimal zong = new BigDecimal(total);
						BigDecimal lv = piao.divide(zong,0, RoundingMode.HALF_UP).multiply(new BigDecimal(100));
						String lvs = String.valueOf(lv);
						opt.setBili(lvs);
					}
					topicObject.put("optionsList",optionsList);
					questionArray.add(topicObject);
				}
		);
		questionObject.put("questionArray", questionArray);
		return questionObject;
	}
}
