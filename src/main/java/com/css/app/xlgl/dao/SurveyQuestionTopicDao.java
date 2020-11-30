package com.css.app.xlgl.dao;

import com.css.app.xlgl.entity.SurveyQuestionTopic;

import org.apache.ibatis.annotations.Mapper;

import com.css.base.dao.BaseDao;

import java.util.List;

/**
 * 调查问卷题干表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-11-20 18:51:46
 */
@Mapper
public interface SurveyQuestionTopicDao extends BaseDao<SurveyQuestionTopic> {

    List<SurveyQuestionTopic> queryTopicListByQuestionId(String surveyQuestionId);

	
}
