package com.css.app.xlgl.service;

import com.css.app.xlgl.entity.XlglWarCommonSportsFile;

import java.util.List;
import java.util.Map;

/**
 * 军事训练-共同训练-军事体育-文件表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-09-12 11:05:50
 */
public interface XlglWarCommonSportsFileService {
	
	XlglWarCommonSportsFile queryObject(String id);
	
	List<XlglWarCommonSportsFile> queryList(Map<String, Object> map);
	
	void save(XlglWarCommonSportsFile xlglWarCommonSportsFile);
	
	void update(XlglWarCommonSportsFile xlglWarCommonSportsFile);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
}
