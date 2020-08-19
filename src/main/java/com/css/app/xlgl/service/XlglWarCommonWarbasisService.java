package com.css.app.xlgl.service;

import com.css.app.xlgl.entity.XlglWarCommonWarbasis;

import java.util.List;
import java.util.Map;

/**
 * 军事训练-共同训练-战备基础
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-19 10:14:39
 */
public interface XlglWarCommonWarbasisService {
	
	XlglWarCommonWarbasis queryObject(String id);
	
	List<XlglWarCommonWarbasis> queryList(Map<String, Object> map);
	
	void save(XlglWarCommonWarbasis xlglWarCommonWarbasis);
	
	void update(XlglWarCommonWarbasis xlglWarCommonWarbasis);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
}
