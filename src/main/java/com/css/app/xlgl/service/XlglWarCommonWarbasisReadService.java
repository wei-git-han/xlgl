package com.css.app.xlgl.service;

import com.css.app.xlgl.entity.XlglWarCommonWarbasisRead;

import java.util.List;
import java.util.Map;

/**
 * 军事训练-共同训练-战备基础已读人员表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-19 10:14:38
 */
public interface XlglWarCommonWarbasisReadService {
	
	XlglWarCommonWarbasisRead queryObject(String id);
	
	List<XlglWarCommonWarbasisRead> queryList(Map<String, Object> map);
	
	void save(XlglWarCommonWarbasisRead xlglWarCommonWarbasisRead);
	
	void update(XlglWarCommonWarbasisRead xlglWarCommonWarbasisRead);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
}
