package com.css.app.db.config.service;

import com.css.app.db.config.entity.AdminSet;

import java.util.List;
import java.util.Map;

/**
 * 管理员设置表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-19 10:22:04
 */
public interface AdminSetService {
	
	AdminSet queryObject(String id);
	
	List<AdminSet> queryList(Map<String, Object> map);
	
	void save(AdminSet dbAdminSet);
	
	void update(AdminSet dbAdminSet);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
}
