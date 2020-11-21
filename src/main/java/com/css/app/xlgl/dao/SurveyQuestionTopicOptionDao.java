package com.css.app.xlgl.dao;

import com.css.app.xlgl.entity.SurveyQuestionTopic;
import com.css.app.xlgl.entity.SurveyQuestionTopicOption;

import org.apache.ibatis.annotations.Mapper;

import com.css.base.dao.BaseDao;

import java.util.List;

/**
 * 调查问卷题干的选项表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-11-20 18:52:05
 */
@Mapper
public interface SurveyQuestionTopicOptionDao extends BaseDao<SurveyQuestionTopicOption> {

    List<SurveyQuestionTopicOption> queryOptionListByTopicId(String questionTopicId);



}
