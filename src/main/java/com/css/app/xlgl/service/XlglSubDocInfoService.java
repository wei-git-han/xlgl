package com.css.app.xlgl.service;


import com.css.app.xlgl.entity.XlglSubDocInfo;
import com.css.app.xlgl.entity.XlglSubDocTracking;

import java.util.List;
import java.util.Map;

/**
 * 各子分支主记录表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-11 11:04:56
 */
public interface XlglSubDocInfoService {
	
	XlglSubDocInfo queryObject(String id);
	
	List<XlglSubDocInfo> queryList(Map<String, Object> map);
	
	void save(XlglSubDocInfo xlglSubDocInfo);
	
	void update(XlglSubDocInfo xlglSubDocInfo);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);

	List<String> queryAllSubDeptIds(String fileId);

	List<XlglSubDocInfo> queryAllClass(String orgId,String year);

	List<XlglSubDocInfo> queryListForJu(Map<String,Object> map);

	List<XlglSubDocInfo> queryListForPerson(Map<String,Object> map);

	void deleteSub(String orgId,String fileId);

	List<XlglSubDocTracking> queryByInfoIdAndUserId(String infoId,String userId);

	XlglSubDocInfo querySortByInfoIdAndDeptId(String infoId,String userId);

	List<XlglSubDocInfo> queryBySort(Map<String,Object> map);

	void deleteByInfoId(String id);
}
