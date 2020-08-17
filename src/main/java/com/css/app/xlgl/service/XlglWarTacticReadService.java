package com.css.app.xlgl.service;

import com.css.app.xlgl.entity.XlglWarTacticRead;

import java.util.List;
import java.util.Map;

/**
 * 军事训练-战略训练已读人员表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-17 10:26:33
 */
public interface XlglWarTacticReadService {
	
	XlglWarTacticRead queryObject(String id);
	
	List<XlglWarTacticRead> queryList(Map<String, Object> map);
	
	void save(XlglWarTacticRead xlglWarTacticRead);
	
	void update(XlglWarTacticRead xlglWarTacticRead);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
}
