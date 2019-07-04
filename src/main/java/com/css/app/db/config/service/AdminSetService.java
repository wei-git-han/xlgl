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
	
	List<AdminSet> queryJuAdminList(String userId);
	
	List<String> queryUserIdByOrgId(String orgId);
	//获取某人的管理员类型（0:超级管理员 ;1：部管理员；2：局管理员；3：即是部管理员又是局管理员）
	String getAdminTypeByUserId(String userId);
	
	String getAgentLeagerId(String userId);
}
