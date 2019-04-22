package com.css.app.db.config.service;

import com.css.app.db.config.entity.Menu;

import java.util.List;
import java.util.Map;

/**
 * 菜单表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-19 10:22:36
 */
public interface MenuService {
	
	Menu queryObject(String id);
	
	List<Menu> queryList(Map<String, Object> map);
	
	void save(Menu dbMenu);
	
	void update(Menu dbMenu);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
}
