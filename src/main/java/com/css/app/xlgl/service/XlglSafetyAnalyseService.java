package com.css.app.xlgl.service;

import com.css.app.xlgl.entity.XlglSafetyAnalyse;

import java.util.List;
import java.util.Map;

/**
 * 安全管理-安全分析与预案表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-20 16:39:37
 */
public interface XlglSafetyAnalyseService {
	
	XlglSafetyAnalyse queryObject(String id);
	
	List<XlglSafetyAnalyse> queryList(Map<String, Object> map);
	
	void save(XlglSafetyAnalyse xlglSafetyAnalyse);
	
	void update(XlglSafetyAnalyse xlglSafetyAnalyse);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
}
