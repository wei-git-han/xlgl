package com.css.app.xlgl.service;

import java.util.List;
import java.util.Map;

import com.css.app.xlgl.entity.XlglExamExamine;


/**
 * 训练考核-考试组织-考试基本信息表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-07-30 10:56:43
 */
public interface XlglExamExamineService {
	
	XlglExamExamine queryObject(String id);
	
	List<XlglExamExamine> queryList(Map<String, Object> map);
	
	void save(XlglExamExamine xlglExamExamine);
	
	void update(XlglExamExamine xlglExamExamine);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
	int findCount();
}
