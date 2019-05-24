package com.css.app.db.business.service;

import com.css.app.db.business.entity.SubDocInfo;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 各子分支主记录表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-18 16:40:43
 */
public interface SubDocInfoService {
	
	SubDocInfo queryObject(String id);
	
	List<SubDocInfo> queryList(Map<String, Object> map);
	
	void save(SubDocInfo dbSubDocInfo);
	
	void update(SubDocInfo dbSubDocInfo);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
	
	List<SubDocInfo> queryPersonList(Map<String, Object> map);
	
	void updateDocStatus(Integer status,Date updateTime,String infoId);
	
	int queryMinDocStatus(String infoId,String subDeptId);
	
	int queryMaxDocStatus(String infoId,String subDeptId);
	
	List<String> queryAllSubDeptIds(String infoId);
	
	List<SubDocInfo> queryLastEndSubInfo(String infoId);
	
	List<SubDocInfo> queryAllSubByInfoId(String infoId);
	
	List<SubDocInfo> queryAllSubInfo(Map<String, Object> map);
}
