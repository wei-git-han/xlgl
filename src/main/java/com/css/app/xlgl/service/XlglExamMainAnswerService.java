package com.css.app.xlgl.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.css.app.xlgl.entity.XlglExamMainAnswer;


/**
 * 训练考核-考核清单-主表用户答题表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-03 11:36:19
 */
public interface XlglExamMainAnswerService {
	
	XlglExamMainAnswer queryObject(String id);
	
	List<XlglExamMainAnswer> queryList(Map<String, Object> map);
	
	void save(XlglExamMainAnswer xlglExamMainAnswer);
	
	void update(XlglExamMainAnswer xlglExamMainAnswer);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
	
	String  queryUserCount(HashMap<String, Object> mapAll);
	
	void saveBatch(List<XlglExamMainAnswer> list);
	int queryTotal(Map<String,Object> map);
}
