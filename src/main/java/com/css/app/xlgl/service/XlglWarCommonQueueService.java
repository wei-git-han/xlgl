package com.css.app.xlgl.service;

import com.css.app.xlgl.entity.XlglWarCommonQueue;

import java.util.List;
import java.util.Map;

/**
 * 军事训练-共同训练-队列训练
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-14 16:52:03
 */
public interface XlglWarCommonQueueService {
	
	XlglWarCommonQueue queryObject(String id);
	
	List<XlglWarCommonQueue> queryList(Map<String, Object> map);
	
	void save(XlglWarCommonQueue xlglWarCommonQueue);
	
	void update(XlglWarCommonQueue xlglWarCommonQueue);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
}
