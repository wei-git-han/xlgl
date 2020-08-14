package com.css.app.xlgl.service;

import com.css.app.xlgl.entity.XlglWarSpecialty;

import java.util.List;
import java.util.Map;

/**
 * 军事训练-专业训练
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-14 16:50:25
 */
public interface XlglWarSpecialtyService {
	
	XlglWarSpecialty queryObject(String id);
	
	List<XlglWarSpecialty> queryList(Map<String, Object> map);
	
	void save(XlglWarSpecialty xlglWarSpecialty);
	
	void update(XlglWarSpecialty xlglWarSpecialty);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
}
