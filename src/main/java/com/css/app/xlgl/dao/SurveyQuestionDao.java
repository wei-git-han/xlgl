package com.css.app.xlgl.dao;

import com.css.app.xlgl.entity.SurveyQuestion;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.css.base.dao.BaseDao;

import java.util.List;
import java.util.Map;

/**
 * 调查问卷表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-11-20 18:45:19
 */
@Mapper
public interface SurveyQuestionDao extends BaseDao<SurveyQuestion> {

    List<SurveyQuestion> surveyQuestionList(Map<String, Object> map);

    @Select("select * from SURVEY_QUESTION ")
	List<SurveyQuestion> findAll();

}
