package com.css.app.xlgl.service;


import java.util.List;
import java.util.Map;

import com.css.app.xlgl.entity.DocumentMenuPermission;

/**
 * 
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-04 16:13:34
 */
public interface DocumentMenuPermissionService {
	
	DocumentMenuPermission queryObject(String id);
	
	List<DocumentMenuPermission> queryList(Map<String, Object> map);
	
	void save(DocumentMenuPermission documentMenuPermission);
	
	void update(DocumentMenuPermission documentMenuPermission);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
	
	void deleteByUserId(String uid);
}
