package com.css.app.xlgl.service;

import com.css.app.xlgl.entity.XlglWarTactic;

import java.util.List;
import java.util.Map;

/**
 * 军事训练-战略训练
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-14 16:50:25
 */
public interface XlglWarTacticService {
	
	XlglWarTactic queryObject(String id);
	
	List<XlglWarTactic> queryList(Map<String, Object> map);
	
	void save(XlglWarTactic xlglWarTactic);
	
	void update(XlglWarTactic xlglWarTactic);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
}
