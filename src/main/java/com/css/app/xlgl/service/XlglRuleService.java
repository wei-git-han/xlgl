package com.css.app.xlgl.service;


import com.css.app.xlgl.entity.XlglRule;

import java.util.List;
import java.util.Map;

/**
 * 训练管理法规资料
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-20 20:18:42
 */
public interface XlglRuleService {
	
	XlglRule queryObject(String id);
	
	List<XlglRule> queryList(Map<String, Object> map);
	
	void save(XlglRule xlglRule);
	
	void update(XlglRule xlglRule);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
}
