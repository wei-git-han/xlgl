package com.css.app.xlgl.service;

import com.css.app.xlgl.entity.XlglSafetyCheckup;

import java.util.List;
import java.util.Map;

/**
 * 日常管理-安全管理-安全检查
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-21 15:52:37
 */
public interface XlglSafetyCheckupService {
	
	XlglSafetyCheckup queryObject(String id);
	
	List<XlglSafetyCheckup> queryList(Map<String, Object> map);
	
	void save(XlglSafetyCheckup xlglSafetyCheckup);
	
	void update(XlglSafetyCheckup xlglSafetyCheckup);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
}
