package com.css.app.xlgl.service;


import com.css.app.xlgl.entity.XlglPhysical;

import java.util.List;
import java.util.Map;

/**
 * 军事体育训练
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-20 19:38:37
 */
public interface XlglPhysicalService {
	
	XlglPhysical queryObject(String id);
	
	List<XlglPhysical> queryList(Map<String, Object> map);
	
	void save(XlglPhysical xlglPhysical);
	
	void update(XlglPhysical xlglPhysical);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
}
