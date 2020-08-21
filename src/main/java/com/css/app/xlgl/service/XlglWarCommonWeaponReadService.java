package com.css.app.xlgl.service;

import com.css.app.xlgl.entity.XlglWarCommonWeaponRead;

import java.util.List;
import java.util.Map;

/**
 * 军事训练-共同训练-轻武器操作已读人员表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-19 10:14:38
 */
public interface XlglWarCommonWeaponReadService {
	
	XlglWarCommonWeaponRead queryObject(String id);
	
	List<XlglWarCommonWeaponRead> queryList(Map<String, Object> map);
	
	void save(XlglWarCommonWeaponRead xlglWarCommonWeaponRead);
	
	void update(XlglWarCommonWeaponRead xlglWarCommonWeaponRead);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
}
