package com.css.app.xlgl.service;

import com.css.app.xlgl.entity.XlglWarCommonWeapon;

import java.util.List;
import java.util.Map;

/**
 * 军事训练-共同训练-轻武器操作
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-19 10:14:38
 */
public interface XlglWarCommonWeaponService {
	
	XlglWarCommonWeapon queryObject(String id);
	
	List<XlglWarCommonWeapon> queryList(Map<String, Object> map);
	
	void save(XlglWarCommonWeapon xlglWarCommonWeapon);
	
	void update(XlglWarCommonWeapon xlglWarCommonWeapon);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
}
