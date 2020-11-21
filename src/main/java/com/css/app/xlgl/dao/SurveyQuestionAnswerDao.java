package com.css.app.xlgl.dao;

import com.css.app.xlgl.entity.SurveyQuestionAnswer;

import java.util.List;

import com.css.app.xlgl.entity.SurveyQuestionTopic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.css.base.dao.BaseDao;

import java.util.Map;

/**
 * 调查问卷问答表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-11-20 19:22:47
 */
@Mapper
public interface SurveyQuestionAnswerDao extends BaseDao<SurveyQuestionAnswer> {

	@Select("select * from SURVEY_QUESTION_ANSWER where SURVER_QUESTION_ID = #{0} and CREATE_USER_ID = #{1} ")
	List<SurveyQuestionAnswer> isSave(String surverQuestionId, String userId);

    List<SurveyQuestionAnswer> queryCountAnswerList(Map<String, Object> map);
    List<SurveyQuestionTopic> queryCountOptionList(String id);
}
