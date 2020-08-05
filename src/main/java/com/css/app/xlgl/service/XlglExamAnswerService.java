package com.css.app.xlgl.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.css.app.xlgl.entity.XlglExamAnswer;


/**
 * 训练考核-考核清单-用户答题表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-03 11:35:28
 */
public interface XlglExamAnswerService {
	
	XlglExamAnswer queryObject(String id);
	
	List<XlglExamAnswer> queryList(Map<String, Object> map);
	
	void save(XlglExamAnswer xlglExamAnswer);
	
	void update(XlglExamAnswer xlglExamAnswer);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
	
	void saveBatch(@Param("list")List<XlglExamAnswer> list);
}
