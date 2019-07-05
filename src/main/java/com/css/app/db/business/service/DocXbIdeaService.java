package com.css.app.db.business.service;

import com.css.app.db.business.entity.DocXbIdea;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-07-05 14:56:19
 */
public interface DocXbIdeaService {
	
	DocXbIdea queryObject(String id);
	
	List<DocXbIdea> queryList(Map<String, Object> map);
	
	void save(DocXbIdea dbDocXbIdea);
	
	void update(DocXbIdea dbDocXbIdea);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);

	DocXbIdea queryLastNewData(String subId, String infoId);
}
