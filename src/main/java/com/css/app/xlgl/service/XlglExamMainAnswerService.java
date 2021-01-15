package com.css.app.xlgl.service;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.css.app.xlgl.dto.ExamMainAnswerAnalyseDto;
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
	
	Map<String,Object>  queryUserCount(HashMap<String, Object> mapAll);
	
	void saveBatch(List<XlglExamMainAnswer> list);
	int queryTotal(Map<String,Object> map);
	
	List<XlglExamMainAnswer> findListBySubjectId(Map<String, Object> map);


	List<XlglExamMainAnswer> queryExamByUserIdAndExamId(Map<String, Object> map);


	List<XlglExamMainAnswer> findListAllExam(Map<String, Object> map);
	
	Map<String,Object> findExamByOrganId(Map<String, Object> map);
	
	InputStream createExcelInfoFlie(List<XlglExamMainAnswer> list,String[] title,String fileName,JSONObject json,String totalName,String listName) throws Exception;
	List<XlglExamMainAnswer> getListing(String examineId,String makeupStatus,String level,String replyUserName
			,String organId,String isNotExam,String status,String deptId);
	
	InputStream	createExcelNotExam(List<XlglExamMainAnswer> list,String[] title,String fileName,JSONObject json,String totalName,String listName)throws Exception;

	Map<String,XlglExamMainAnswer> queryExamineIdAndReplyUserId(Map<String, Object> map);
}
