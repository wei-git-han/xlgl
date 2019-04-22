package com.css.app.db.business.service;

import com.css.app.db.business.entity.DocumentRead;

import java.util.List;
import java.util.Map;

/**
 * 确认已读表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-18 16:39:53
 */
public interface DocumentReadService {
	
	DocumentRead queryObject(String id);
	
	List<DocumentRead> queryList(Map<String, Object> map);
	
	void save(DocumentRead dbDocumentRead);
	
	void update(DocumentRead dbDocumentRead);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
}
