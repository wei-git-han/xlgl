package com.css.app.xlgl.service;


import com.css.app.xlgl.entity.XlglKtap;

import java.util.List;
import java.util.Map;

/**
 * 训练管理课题安排
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-18 18:32:15
 */
public interface XlglKtapService {
	
	XlglKtap queryObject(String id);
	
	List<XlglKtap> queryList(Map<String, Object> map);
	
	void save(XlglKtap xlglKtap);
	
	void update(XlglKtap xlglKtap);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);

	void deleteAll();
}
