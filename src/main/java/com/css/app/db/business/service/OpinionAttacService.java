package com.css.app.db.business.service;

import com.css.app.db.business.entity.OpinionAttac;

import java.util.List;
import java.util.Map;

/**
 * 意见反馈附件表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-25 15:10:36
 */
public interface OpinionAttacService {
	
	OpinionAttac queryObject(String id);
	
	List<OpinionAttac> queryList(Map<String, Object> map);
	
	void save(OpinionAttac dbOpinionAttac);
	
	void update(OpinionAttac dbOpinionAttac);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
}
