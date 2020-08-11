package com.css.app.xlgl.service;


import com.css.app.xlgl.entity.XlglSubDocInfo;

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
}
