package com.css.app.xlgl.service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.css.app.xlgl.dto.ExamMainAnswerAnalyseDto;
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
	int findCount(Map<String, Object> map);
	
	List<XlglExamExamine> queryVerifyList(Map<String, Object> map);
	
	InputStream createExcelInfoFlie(List<ExamMainAnswerAnalyseDto> list,String[] title,String fileName,JSONObject json,String totalName,String listName) throws Exception;
	
	int queryTotal(Map<String,Object> map);

	List<XlglExamExamine> queryListAndTotal(Map<String, Object> map);
}
