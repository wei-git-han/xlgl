package com.css.app.xlgl.service;

import com.css.app.xlgl.entity.XlglExamFile;

import java.util.List;
import java.util.Map;

/**
 * 考试模块模板文件id
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-11 15:17:38
 */
public interface XlglExamFileService {
	
	XlglExamFile queryObject(String id);
	
	List<XlglExamFile> queryList(Map<String, Object> map);
	
	void save(XlglExamFile xlglExamFile);
	
	void update(XlglExamFile xlglExamFile);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
}
