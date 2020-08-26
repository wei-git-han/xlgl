package com.css.app.xlgl.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.css.app.xlgl.entity.XlglExamAnswer;
import com.css.base.dao.BaseDao;

/**
 * 训练考核-考核清单-用户答题表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-03 11:35:28
 */
@Mapper
public interface XlglExamAnswerDao extends BaseDao<XlglExamAnswer> {
	void saveBatch(@Param("list")List<XlglExamAnswer> list);
	
	int queryCorrectStatus(Map<String, Object> map);
}
