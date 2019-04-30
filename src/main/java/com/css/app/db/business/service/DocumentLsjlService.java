package com.css.app.db.business.service;

import com.css.app.db.business.entity.DocumentLsjl;

import java.util.List;
import java.util.Map;

/**
 * 落实记录表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-28 19:32:01
 */
public interface DocumentLsjlService {
	
	DocumentLsjl queryObject(String id);
	
	List<DocumentLsjl> queryList(Map<String, Object> map);
	
	void save(DocumentLsjl dbDocumentLsjl);
	
	void update(DocumentLsjl dbDocumentLsjl);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
	
	DocumentLsjl queryLatestLsjl(String infoId);
}
