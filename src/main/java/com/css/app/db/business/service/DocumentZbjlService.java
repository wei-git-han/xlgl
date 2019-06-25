package com.css.app.db.business.service;

import com.css.app.db.business.entity.DocumentZbjl;

import java.util.List;
import java.util.Map;

/**
 * 转办记录表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-18 16:39:37
 */
public interface DocumentZbjlService {
	
	DocumentZbjl queryObject(String id);
	
	List<DocumentZbjl> queryList(Map<String, Object> map);
	
	void save(DocumentZbjl dbDocumentZbjl);
	
	void update(DocumentZbjl dbDocumentZbjl);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
	void deleteByInfoId(String infoId);

	void deleteBySubIdAndInfoId(String subId, String infoId);

	DocumentZbjl queryBySubIdAndInfoId(String subId, String infoId);
}
