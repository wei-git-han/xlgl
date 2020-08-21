package com.css.app.xlgl.service;


import com.css.app.xlgl.entity.XlglStudyRecord;

import java.util.List;
import java.util.Map;

/**
 * 自学上传记录
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-21 14:42:54
 */
public interface XlglStudyRecordService {
	
	XlglStudyRecord queryObject(String id);
	
	List<XlglStudyRecord> queryList(Map<String, Object> map);
	
	void save(XlglStudyRecord xlglStudyRecord);
	
	void update(XlglStudyRecord xlglStudyRecord);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);


}
