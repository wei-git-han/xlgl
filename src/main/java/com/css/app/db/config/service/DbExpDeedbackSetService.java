package com.css.app.db.config.service;

import com.css.app.db.config.entity.DbExpDeedbackSet;

import java.util.List;
import java.util.Map;

/**
 * 督办-反馈范例配置表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-05-24 15:06:41
 */
public interface DbExpDeedbackSetService {
	
	DbExpDeedbackSet queryObject(String id);
	
	List<DbExpDeedbackSet> queryList(Map<String, Object> map);
	
	void save(DbExpDeedbackSet dbExpDeedbackSet);
	
	void update(DbExpDeedbackSet dbExpDeedbackSet);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
}
