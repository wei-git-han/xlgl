package com.css.app.db.business.service;

import com.css.app.db.business.entity.DocumentInfo;
import com.css.app.db.config.entity.DocumentDic;

import java.util.List;
import java.util.Map;

/**
 * 督办基本信息表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-18 16:34:38
 */
public interface DocumentInfoService {
	
	DocumentInfo queryObject(String id);
	
	List<DocumentInfo> queryList(Map<String, Object> map);
	
	void save(DocumentInfo dbDocumentInfo);
	
	void update(DocumentInfo dbDocumentInfo);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);

	List<Map<String, Object>> queryListByYear(Map<String, Object> map);

	List<Map<String, Object>> queryListByOrgYear(Map<String, Object> map);

	List<Map<String, Object>> queryListByDicType(Map<String, Object> map);

	List<Map<String, Object>> queryListByDicStu(Map<String, Object> map);
	
	List<DocumentInfo> queryPersonList(Map<String, Object> map);
	List<Map<String, Object>> queryListByDicStutas(Map<String, Object> map);
	void deleteByCheHui(String id);
	List<DocumentDic> queryDicByType(Map<String, Object> map);

	List<Map<String, Object>> getMaxSecurity(String[] stringIds);
}
