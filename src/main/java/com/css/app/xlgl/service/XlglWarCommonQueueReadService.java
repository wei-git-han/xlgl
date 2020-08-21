package com.css.app.xlgl.service;

import com.css.app.xlgl.entity.XlglWarCommonQueueRead;

import java.util.List;
import java.util.Map;

/**
 * 军事训练-共同训练-队列训练已读人员表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-17 10:26:33
 */
public interface XlglWarCommonQueueReadService {
	
	XlglWarCommonQueueRead queryObject(String id);
	
	List<XlglWarCommonQueueRead> queryList(Map<String, Object> map);
	
	void save(XlglWarCommonQueueRead xlglWarCommonQueueRead);
	
	void update(XlglWarCommonQueueRead xlglWarCommonQueueRead);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
}
