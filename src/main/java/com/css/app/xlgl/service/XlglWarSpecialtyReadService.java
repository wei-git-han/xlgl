package com.css.app.xlgl.service;

import com.css.app.xlgl.entity.XlglWarSpecialtyRead;

import java.util.List;
import java.util.Map;

/**
 * 军事训练-专业训练已读人员表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-17 10:26:33
 */
public interface XlglWarSpecialtyReadService {
	
	XlglWarSpecialtyRead queryObject(String id);
	
	List<XlglWarSpecialtyRead> queryList(Map<String, Object> map);
	
	void save(XlglWarSpecialtyRead xlglWarSpecialtyRead);
	
	void update(XlglWarSpecialtyRead xlglWarSpecialtyRead);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
}
