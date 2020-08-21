package com.css.app.xlgl.service;

import com.css.app.xlgl.entity.XlglWarCommonSports;

import java.util.List;
import java.util.Map;

/**
 * 军事训练-共同训练-军事体育
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-17 09:53:19
 */
public interface XlglWarCommonSportsService {
	
	XlglWarCommonSports queryObject(String id);
	
	List<XlglWarCommonSports> queryList(Map<String, Object> map);
	
	void save(XlglWarCommonSports xlglWarCommonSports);
	
	void update(XlglWarCommonSports xlglWarCommonSports);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
}
