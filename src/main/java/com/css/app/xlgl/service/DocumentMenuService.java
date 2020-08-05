package com.css.app.xlgl.service;


import java.util.List;
import java.util.Map;

import com.css.app.xlgl.entity.DocumentMenu;

/**
 * 
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-04 15:18:03
 */
public interface DocumentMenuService {
	
	DocumentMenu queryObject(String id);
	
	List<DocumentMenu> queryList(Map<String, Object> map);
	
	void save(DocumentMenu documentMenu);
	
	void update(DocumentMenu documentMenu);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
}
