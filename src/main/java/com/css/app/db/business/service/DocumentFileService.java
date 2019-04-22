package com.css.app.db.business.service;

import com.css.app.db.business.entity.DocumentFile;

import java.util.List;
import java.util.Map;

/**
 * 基本信息表携带文件的关系表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-18 16:39:11
 */
public interface DocumentFileService {
	
	DocumentFile queryObject(String id);
	
	List<DocumentFile> queryList(Map<String, Object> map);
	
	void save(DocumentFile dbDocumentFile);
	
	void update(DocumentFile dbDocumentFile);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
	//获取可编最小号
	int queryMinSort(String docInfoId);
}
