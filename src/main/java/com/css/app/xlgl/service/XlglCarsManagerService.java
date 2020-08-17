package com.css.app.xlgl.service;


import com.css.app.xlgl.entity.XlglCarsManager;

import java.util.List;
import java.util.Map;

/**
 * 训练管理车辆管理表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-17 14:15:57
 */
public interface XlglCarsManagerService {
	
	XlglCarsManager queryObject(String id);
	
	List<XlglCarsManager> queryList(Map<String, Object> map);
	
	void save(XlglCarsManager xlglCarsManager);
	
	void update(XlglCarsManager xlglCarsManager);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
}
