package com.css.app.db.config.service;

import com.css.app.db.config.entity.RoleSet;

import java.util.List;
import java.util.Map;

/**
 * 角色设置表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-19 10:22:36
 */
public interface RoleSetService {
	
	RoleSet queryObject(String id);
	
	List<RoleSet> queryList(Map<String, Object> map);
	
	void save(RoleSet dbRoleSet);
	
	void update(RoleSet dbRoleSet);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
	
	int deleteByUserId(String userId);
	//获取某人角色标识（1：首长；2：首长秘书；3：局长；4：局秘书；5：处长；6：参谋;）
	String getRoleTypeByUserId(String userId);
}
