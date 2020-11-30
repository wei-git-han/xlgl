package com.css.app.xlgl.dao;

import com.css.addbase.apporgan.entity.BaseAppUser;
import com.css.app.xlgl.entity.SurveyCountQuestion;
import com.css.app.xlgl.entity.SurveyQuestion;
import com.css.base.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

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
public interface SurveyQuestionCountDao extends BaseDao<SurveyQuestion> {
    List<SurveyCountQuestion> queryTopList();
    List<BaseAppUser> queryUnSjUserList();
}
