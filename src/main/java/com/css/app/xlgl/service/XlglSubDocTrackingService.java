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


	XlglSubDocTracking queryInfomation(String id,String userId);

	XlglSubDocTracking querybaoming(String infoId,String subId,String userId);

	XlglSubDocTracking queryStatusByInfoIdAndUserId(String infoId,String userId);

	XlglSubDocTracking querySortByInfoIdAndUserId(String infoId,String userId);

	List<Map<String,Object>> queryBmInfo(String infoId,String deptId);

	List<XlglSubDocTracking> queryListForPerson(Map<String,Object> map);

	List<XlglSubDocTracking> queryListForPerson1(Map<String,Object> map);

	List<XlglSubDocTracking> queryAllInfos(Map<String,Object> map1);

	List<XlglSubDocTracking> queryAllYear(Map<String,Object> map1);

	int queryCount(String fileId);

	int queryAllCount(String userId,String year);

	int quereyWcCount(String userId,String year);

	int queryCurrentYear(Map<String,Object> map);

	int queryCxCount(Map<String,Object> map);

	int queryBkCount(Map<String,Object> map);

	int queryBmCount(Map<String,Object> map);

	int queryAllYx(String year);

	int queryAllCx(String fileId);

	int queryAllYh(String fileId);

	int queryAllCxByInfoId(String fileId,String orgId);

	int queryAllBkByInfoId(String fileId,String orgId);

	int queryCxAllCount(Map<String,Object> map);

	List<XlglSubDocTracking> queryBySort(Map<String,Object> map);

	void deleteByInfoIdAndUserId(String infoId,String userId);

	void deleteByInfoId(String id);

	void deleteByInfoIdAndOrgId(String orgId,String id);

	XlglSubDocTracking queryDjtInfo(String infoId,String userId);

}
