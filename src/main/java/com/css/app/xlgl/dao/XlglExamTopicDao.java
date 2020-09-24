package com.css.app.xlgl.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.css.app.xlgl.entity.XlglExamTopic;
import com.css.base.dao.BaseDao;

/**
 * 训练管理-考核-题目表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-07-28 16:17:20
 */
@Mapper
public interface XlglExamTopicDao extends BaseDao<XlglExamTopic> {
	
	
	void saveList(@Param("list")List<XlglExamTopic> list);
	
	List<XlglExamTopic> queryListByIds(Object[] id);
	
	void deleteByType(Map<String, Object> map);
	
	
	
}
