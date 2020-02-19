package com.css.app.db.config.service;

import com.css.app.db.config.entity.RemindAdministration;

import java.util.List;
import java.util.Map;

/**
 * 提醒管理表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-02-18 14:45:49
 */
public interface RemindAdministrationService {
	
	RemindAdministration queryObject(String id);
	
	List<RemindAdministration> queryList(Map<String, Object> map);
	
	void save(RemindAdministration remindAdministration);
	
	void update(RemindAdministration remindAdministration);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
}
