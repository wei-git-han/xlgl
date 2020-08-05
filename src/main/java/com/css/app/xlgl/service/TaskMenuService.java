package com.css.app.xlgl.service;


import java.util.List;
import java.util.Map;

import com.css.app.xlgl.entity.TaskMenu;

/**
 * 
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-05 13:46:02
 */
public interface TaskMenuService {
	
	TaskMenu queryObject(String menuId);
	
	List<TaskMenu> queryList(Map<String, Object> map);
	
	void save(TaskMenu taskMenu);
	
	void update(TaskMenu taskMenu);
	
	void delete(String menuId);
	
	void deleteBatch(String[] menuIds);
	
	List<TaskMenu> findByParentId(String id);
	
	List<TaskMenu> queryAuthList(String userId);
}
