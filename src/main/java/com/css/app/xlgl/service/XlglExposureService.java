package com.css.app.xlgl.service;

import com.css.app.xlgl.entity.XlglExposure;

import java.util.List;
import java.util.Map;

/**
 * 首页-曝光台表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-09-08 10:41:01
 */
public interface XlglExposureService {
	
	XlglExposure queryObject(String id);
	
	List<XlglExposure> queryList(Map<String, Object> map);
	
	void save(XlglExposure xlglExposure);
	
	void update(XlglExposure xlglExposure);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
	
	List<XlglExposure> queryListInfo(Map<String, Object> map);
}
