package com.css.app.xlgl.service;


import com.css.app.xlgl.entity.XlglSubDocTracking;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-11 15:53:31
 */
public interface XlglSubDocTrackingService {
	
	XlglSubDocTracking queryObject(String id);
	
	List<XlglSubDocTracking> queryList(Map<String, Object> map);
	
	void save(XlglSubDocTracking xlglSubDocTracking);
	
	void update(XlglSubDocTracking xlglSubDocTracking);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);

	XlglSubDocTracking queryInfo(String id,String userId);

	XlglSubDocTracking querybaoming(String infoId,String subId,String userId);
}
