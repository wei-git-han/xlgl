package com.css.app.xlgl.service;


import com.css.app.xlgl.entity.XlglXlzzInfo;

import java.util.List;
import java.util.Map;

/**
 * 训练组织基本信息表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-11 10:12:29
 */
public interface XlglXlzzInfoService {
	
	XlglXlzzInfo queryObject(String id);
	
	List<XlglXlzzInfo> queryList(Map<String, Object> map);
	
	void save(XlglXlzzInfo xlglXlzzInfo);
	
	void update(XlglXlzzInfo xlglXlzzInfo);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
}
