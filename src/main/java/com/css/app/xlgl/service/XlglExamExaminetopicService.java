package com.css.app.xlgl.service;

import java.util.List;
import java.util.Map;

import com.css.app.xlgl.dto.XlglExamExaminetopicDto;
import com.css.app.xlgl.entity.XlglExamExaminetopic;


/**
 * 训练考核-考核组织-考试副表题目表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-07-30 10:56:43
 */
public interface XlglExamExaminetopicService {
	
	XlglExamExaminetopic queryObject(String id);
	
	List<XlglExamExaminetopic> queryList(Map<String, Object> map);
	
	void save(XlglExamExaminetopic xlglExamExaminetopic);
	
	void update(XlglExamExaminetopic xlglExamExaminetopic);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
	void saveBatch(List<XlglExamExaminetopic> list);
	List<XlglExamExaminetopicDto> findCountBySubjectId(Map<String,Object> map);
	List<XlglExamExaminetopic> findListBySubjectId(Map<String,Object> map);
	/**
	 * 返回随机抽中的题目
	 * */
	List<XlglExamExaminetopic> randomExtract(Map<String,Object> map,String examineId);
	void deleteByExamineId(String examineId);
	
}
