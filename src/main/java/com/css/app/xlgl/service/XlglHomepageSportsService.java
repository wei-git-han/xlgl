package com.css.app.xlgl.service;

import com.css.app.xlgl.entity.XlglHomepageSports;

import java.util.List;
import java.util.Map;

/**
 * 首页-体育活动
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-10-16 10:45:44
 */
public interface XlglHomepageSportsService {
	
	XlglHomepageSports queryObject(String id);
	
	List<XlglHomepageSports> queryList(Map<String, Object> map);
	
	void save(XlglHomepageSports xlglHomepageSports);
	
	void update(XlglHomepageSports xlglHomepageSports);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);

	void cacle(String id);
}
