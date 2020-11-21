package com.css.app.xlgl.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.css.addbase.apporgan.dao.BaseAppUserDao;
import com.css.app.xlgl.dao.SurveyQuestionAnswerDao;
import com.css.app.xlgl.dao.SurveyQuestionCountDao;
import com.css.app.xlgl.dao.SurveyQuestionDao;
import com.css.app.xlgl.entity.*;
import com.css.app.xlgl.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;


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
	@Autowired
	private SurveyQuestionAnswerDao surveyQuestionAnswerDao;
	@Override
	public List<SurveyCountQuestion> queryTopList(){
		return surveyQuestionCountDao.queryTopList();
	}
	@Override
	public JSONObject querySurveyQuestionCountList(String serveyQuestionId,String sex,String olds,String area){

		//top
		List<SurveyCountQuestion> surveyCountQuestion = surveyQuestionCountDao.queryTopList();
		int total = baseAppUserDao.queryTotal(null);
		SurveyQuestion surveyQuestion = surveyQuestionDao.queryObject(serveyQuestionId);
		JSONObject questionObject = new JSONObject();
		questionObject.put("surveyName", surveyQuestion.getSurveyName());
		questionObject.put("remork", surveyQuestion.getRemark());
		int shouji = Integer.valueOf(surveyCountQuestion.get(0).getCount());
		questionObject.put("shouji", shouji);
		questionObject.put("weixie", total - shouji);
		questionObject.put("startTime", surveyCountQuestion.get(0).getStartTime());
		questionObject.put("endTime", surveyCountQuestion.get(0).getEndTime());
		Date data = new Date();
		String isBj = "0";
		if(data.after(surveyCountQuestion.get(0).getEndTime())){
			isBj = "1";
		}
		questionObject.put("isBj", isBj);
		JSONArray questionArray = new JSONArray();
//		List<SurveyQuestionTopic> topicsList = surveyQuestionTopicService.queryTopicListByQuestionId(surveyQuestion.getId());
		List<SurveyQuestionTopic> topicsList = surveyQuestionAnswerDao.queryCountAnswerList(surveyQuestion.getId());

		topicsList.forEach(
				e -> {
					JSONObject topicObject = new JSONObject();
					topicObject.put("topicId",e.getId());
					topicObject.put("questionContent",e.getQuestionContent());

					topicObject.put("questionTopicTypeId",e.getQuestionTopicTypeId());
					topicObject.put("questionTopicTypeName",e.getQuestionTopicTypeName());
					Map<String, Object> map = new HashMap<>();
					map.put("sex",sex);
					map.put("olds",olds);
					map.put("area",area);
					map.put("questionTopicId",e.getId());
					List<SurveyQuestionTopicOption> optionsList = surveyQuestionTopicOptionService.queryCountOptionList(map);
					for(SurveyQuestionTopicOption opt : optionsList){
						SurveyCountQuestionExport countQuestionExport = new SurveyCountQuestionExport();
						countQuestionExport.setQuestionContent(e.getQuestionContent());
						BigDecimal piao = new BigDecimal(opt.getPiao());
						BigDecimal zong = new BigDecimal(e.getZong());
						BigDecimal lv = piao.divide(zong,2, RoundingMode.HALF_UP).multiply(new BigDecimal(100));
						String wcls = String.valueOf(lv).substring(0,String.valueOf(lv).length()-3);
						String lvs = String.valueOf(wcls);
						opt.setBili(lvs);
					}
					topicObject.put("optionsList",optionsList);
					questionArray.add(topicObject);
				}
		);
		questionObject.put("questionArray", questionArray);
		return questionObject;
	}

	@Override
	public List<SurveyCountQuestionExport> querySurveyExportList(String serveyQuestionId,String sex,String olds,String area){
		List<SurveyQuestionTopic> topicsList = surveyQuestionAnswerDao.queryCountAnswerList(serveyQuestionId);
		List<SurveyCountQuestionExport> surveyCountQuestionExportList = new ArrayList<SurveyCountQuestionExport>();
		topicsList.forEach(
				e -> {
					Map<String, Object> map = new HashMap<>();
					map.put("sex",sex);
					map.put("olds",olds);
					map.put("area",area);
					map.put("questionTopicId",e.getId());
					List<SurveyQuestionTopicOption> optionsList = surveyQuestionTopicOptionService.queryCountOptionList(map);
					for(SurveyQuestionTopicOption opt : optionsList){
						SurveyCountQuestionExport countQuestionExport = new SurveyCountQuestionExport();
						countQuestionExport.setQuestionContent(e.getQuestionContent());
						countQuestionExport.setQuestionContentId(e.getId());
						countQuestionExport.setOptionContent(opt.getOptionContent());
						countQuestionExport.setCountNum(opt.getPiao());

						//计算比率
						BigDecimal piao = new BigDecimal(opt.getPiao());
						BigDecimal zong = new BigDecimal(e.getZong());
						BigDecimal lv = piao.divide(zong,2, RoundingMode.HALF_UP).multiply(new BigDecimal(100));
						String wcls = String.valueOf(lv).substring(0,String.valueOf(lv).length()-3);
						String lvs = String.valueOf(wcls);
						opt.setBili(lvs);
						countQuestionExport.setCountPercentage(lvs);
						surveyCountQuestionExportList.add(countQuestionExport);
					}
				}
		);
		return surveyCountQuestionExportList;
	}
}
