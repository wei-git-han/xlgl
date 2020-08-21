package com.css.app.xlgl.service;


import com.css.app.xlgl.entity.XlglPhysicalRecord;

import java.util.List;
import java.util.Map;

/**
 * 军事体育上传记录
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-21 14:13:24
 */
public interface XlglPhysicalRecordService {
	
	XlglPhysicalRecord queryObject(String id);
	
	List<XlglPhysicalRecord> queryList(Map<String, Object> map);
	
	void save(XlglPhysicalRecord xlglPhysicalRecord);
	
	void update(XlglPhysicalRecord xlglPhysicalRecord);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
}
