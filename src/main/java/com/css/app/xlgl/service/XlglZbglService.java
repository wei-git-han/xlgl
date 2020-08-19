package com.css.app.xlgl.service;


import com.css.app.xlgl.entity.XlglZbgl;

import java.util.List;
import java.util.Map;

/**
 * 训练管理装备管理
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-17 19:34:44
 */
public interface XlglZbglService {
	
	XlglZbgl queryObject(String id);
	
	List<XlglZbgl> queryList(Map<String, Object> map);
	
	void save(XlglZbgl xlglZbgl);
	
	void update(XlglZbgl xlglZbgl);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
}
