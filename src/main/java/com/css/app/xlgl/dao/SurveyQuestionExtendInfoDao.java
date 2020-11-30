package com.css.app.xlgl.dao;

import com.css.app.xlgl.entity.SurveyQuestionExtendInfo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.css.base.dao.BaseDao;

/**
 * 调查问卷扩展表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-11-21 14:46:59
 */
@Mapper
public interface SurveyQuestionExtendInfoDao extends BaseDao<SurveyQuestionExtendInfo> {

	@Select("select * from SURVEY_QUESTION_EXTEND_INFO where SURVEY_QUESTION_ID = #{0} ")
	List<SurveyQuestionExtendInfo> findByFilter(String surveyQuestionId);
	
}
