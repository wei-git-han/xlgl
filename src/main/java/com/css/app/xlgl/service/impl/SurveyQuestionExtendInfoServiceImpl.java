package com.css.app.xlgl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.css.app.xlgl.dao.SurveyQuestionExtendInfoDao;
import com.css.app.xlgl.entity.SurveyQuestionExtendInfo;
import com.css.app.xlgl.service.SurveyQuestionExtendInfoService;



@Service("surveyQuestionExtendInfoService")
public class SurveyQuestionExtendInfoServiceImpl implements SurveyQuestionExtendInfoService {
	@Autowired
	private SurveyQuestionExtendInfoDao surveyQuestionExtendInfoDao;
	
	@Override
	public SurveyQuestionExtendInfo queryObject(String id){
		return surveyQuestionExtendInfoDao.queryObject(id);
	}
	
	@Override
	public List<SurveyQuestionExtendInfo> queryList(Map<String, Object> map){
		return surveyQuestionExtendInfoDao.queryList(map);
	}
	
	@Override
	public void save(SurveyQuestionExtendInfo surveyQuestionExtendInfo){
		surveyQuestionExtendInfoDao.save(surveyQuestionExtendInfo);
	}
	
	@Override
	public void update(SurveyQuestionExtendInfo surveyQuestionExtendInfo){
		surveyQuestionExtendInfoDao.update(surveyQuestionExtendInfo);
	}
	
	@Override
	public void delete(String id){
		surveyQuestionExtendInfoDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		surveyQuestionExtendInfoDao.deleteBatch(ids);
	}

	@Override
	public List<SurveyQuestionExtendInfo> findByFilter(String surveyQuestionId) {
		List<SurveyQuestionExtendInfo> list = surveyQuestionExtendInfoDao.findByFilter(surveyQuestionId);
		return list;
	}
	
}
