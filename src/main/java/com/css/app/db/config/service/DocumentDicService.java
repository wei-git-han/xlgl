package com.css.app.db.config.service;

import com.css.app.db.config.entity.DocumentDic;

import java.util.List;
import java.util.Map;

/**
 * 字典配置表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-19 15:23:36
 */
public interface DocumentDicService {
	
	DocumentDic queryObject(String id);
	
	List<DocumentDic> queryList(Map<String, Object> map);
	
	void save(DocumentDic dbDocumentDic);
	
	void update(DocumentDic dbDocumentDic);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
	
	List<DocumentDic> queryDicByType(String dicType);

	DocumentDic queryIdAndDicType(String id, String docType);
}
