package com.css.app.xlgl.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.css.app.xlgl.entity.XlglExamMainAnswer;
import com.css.base.dao.BaseDao;

/**
 * 训练考核-考核清单-主表用户答题表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-03 11:36:19
 */
@Mapper
public interface XlglExamMainAnswerDao extends BaseDao<XlglExamMainAnswer> {
	
	String queryUserCount(HashMap<String, Object> mapAll);
	void saveBatch(List<XlglExamMainAnswer> list);
	
	List<XlglExamMainAnswer> findListBySubjectId(Map<String, Object> map);


	List<XlglExamMainAnswer> findListAllExam(Map<String, Object> map);


	List<XlglExamMainAnswer> queryExamByUserIdAndExamId(Map<String, Object> map);

}
