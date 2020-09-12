package com.css.app.xlgl.service;


import java.util.List;
import java.util.Map;

import com.css.app.xlgl.entity.XlglAdminSet;

/**
 * 管理员设置表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-19 10:22:04
 */
public interface XlglAdminSetService {
	
	XlglAdminSet queryObject(String id);
	
	List<XlglAdminSet> queryList(Map<String, Object> map);
	
	void save(XlglAdminSet dbAdminSet);
	
	void update(XlglAdminSet dbAdminSet);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
	
	List<XlglAdminSet> queryJuAdminList(String userId);
	
	List<XlglAdminSet> queryChuAdminList(String userId);
	
	List<String> queryUserIdByOrgId(String orgId);
	//获取某人的管理员类型（0:超级管理员 ;1：部管理员；2：局管理员；3：即是部管理员又是局管理员;4:处管理员）
	String getAdminTypeByUserId(String userId);
	
	String getAgentLeagerId(String userId);

	XlglAdminSet queryByUserId(String userId);
}
