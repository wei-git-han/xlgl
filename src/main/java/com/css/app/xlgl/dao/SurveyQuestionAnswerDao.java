package com.css.app.xlgl.dao;

import com.css.app.xlgl.entity.SurveyQuestionAnswer;

import org.apache.ibatis.annotations.Mapper;

import com.css.base.dao.BaseDao;

import java.util.List;
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
    List<SurveyQuestionAnswer> queryCountAnswerList(Map<String, Object> map);
    List<SurveyQuestionAnswer> queryCountOptionList(Map<String, Object> map);
}
