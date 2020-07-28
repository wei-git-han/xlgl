package com.css.xlgl.service;


import java.util.List;
import java.util.Map;

import com.css.xlgl.entity.XlglDocumentFile;

/**
 * 基本信息表携带文件的关系表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-07-28 13:15:37
 */
public interface XlglDocumentFileService {
	
	XlglDocumentFile queryObject(String id);
	
	List<XlglDocumentFile> queryList(Map<String, Object> map);
	
	void save(XlglDocumentFile xlglDocumentFile);
	
	void update(XlglDocumentFile xlglDocumentFile);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
	
	//获取可编最小号
	int queryMinSort(String docInfoId);
}
