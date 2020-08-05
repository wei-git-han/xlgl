package com.css.app.xlgl.service;

import java.util.List;
import java.util.Map;

import com.css.app.xlgl.entity.XlglExamSubject;


/**
 * 训练管理-考核-题目维护-科目表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-07-28 16:17:20
 */
public interface XlglExamSubjectService {
	
	XlglExamSubject queryObject(String id);
	
	List<XlglExamSubject> queryList(Map<String, Object> map);
	
	void save(XlglExamSubject xlglExamSubject);
	
	void update(XlglExamSubject xlglExamSubject);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
	
	List<XlglExamSubject> findList();
}
