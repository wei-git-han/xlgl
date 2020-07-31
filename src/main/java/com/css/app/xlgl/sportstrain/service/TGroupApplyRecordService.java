package com.css.app.xlgl.sportstrain.service;

import com.css.app.xlgl.sportstrain.entity.TGroupApplyRecord;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-07-30 18:21:45
 */
public interface TGroupApplyRecordService {
	
	TGroupApplyRecord queryObject(String id);
	
	List<TGroupApplyRecord> queryList(Map<String, Object> map);
	
	void save(TGroupApplyRecord tGroupApplyRecord);
	
	void update(TGroupApplyRecord tGroupApplyRecord);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
}
