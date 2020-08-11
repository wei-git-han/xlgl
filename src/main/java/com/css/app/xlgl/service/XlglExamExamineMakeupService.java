package com.css.app.xlgl.service;

import com.css.app.xlgl.entity.XlglExamExamineMakeup;

import java.util.List;
import java.util.Map;

/**
 * 补考表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-11 10:53:14
 */
public interface XlglExamExamineMakeupService {
	
	XlglExamExamineMakeup queryObject(String id);
	
	List<XlglExamExamineMakeup> queryList(Map<String, Object> map);
	
	void save(XlglExamExamineMakeup xlglExamExamineMakeup);
	
	void update(XlglExamExamineMakeup xlglExamExamineMakeup);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
}
