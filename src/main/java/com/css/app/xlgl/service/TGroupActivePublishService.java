package com.css.app.xlgl.service;

import com.css.app.xlgl.entity.TGroupActivePublish;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-07-30 18:21:45
 */
public interface TGroupActivePublishService {
	
	TGroupActivePublish queryObject(String actId);
	
	List<TGroupActivePublish> queryList(Map<String, Object> map);
	
	void save(TGroupActivePublish tGroupActivePublish);
	
	void update(TGroupActivePublish tGroupActivePublish);
	
	void delete(String actId);
	
	void deleteBatch(String[] actIds);
}
