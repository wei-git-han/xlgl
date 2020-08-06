package com.css.app.xlgl.service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.css.app.xlgl.entity.XlglExamTopic;


/**
 * 训练管理-考核-题目表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-07-28 16:17:20
 */
public interface XlglExamTopicService {
	
	XlglExamTopic queryObject(String id);
	
	List<XlglExamTopic> queryList(Map<String, Object> map);
	
	void save(XlglExamTopic xlglExamTopic);
	
	void update(XlglExamTopic xlglExamTopic);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
	List<XlglExamTopic> readExcelLists(InputStream is,String subjectId) throws Exception;
	void saveList(@Param("list")List<XlglExamTopic> list);
	List<XlglExamTopic> queryListByIds(Object[] id);
	void deleteByType(Map<String, Object> map);
}
