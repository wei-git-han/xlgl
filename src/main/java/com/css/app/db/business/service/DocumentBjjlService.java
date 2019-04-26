package com.css.app.db.business.service;

import com.css.app.db.business.entity.DocumentBjjl;

import java.util.List;
import java.util.Map;

/**
 * 办结记录表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-25 19:46:10
 */
public interface DocumentBjjlService {
	
	DocumentBjjl queryObject(String id);
	
	List<DocumentBjjl> queryList(Map<String, Object> map);
	
	void save(DocumentBjjl dbDocumentBjjl);
	
	void update(DocumentBjjl dbDocumentBjjl);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
}
