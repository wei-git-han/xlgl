package com.css.app.xlgl.service;

import com.css.app.xlgl.entity.XlglWarCommonSportsRead;

import java.util.List;
import java.util.Map;

/**
 * 军事训练-共同训练-军事体育已读人员表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-17 10:26:33
 */
public interface XlglWarCommonSportsReadService {
	
	XlglWarCommonSportsRead queryObject(String id);
	
	List<XlglWarCommonSportsRead> queryList(Map<String, Object> map);
	
	void save(XlglWarCommonSportsRead xlglWarCommonSportsRead);
	
	void update(XlglWarCommonSportsRead xlglWarCommonSportsRead);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
}
