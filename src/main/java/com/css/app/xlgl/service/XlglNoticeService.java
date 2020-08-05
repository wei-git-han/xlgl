package com.css.app.xlgl.service;


import java.util.List;
import java.util.Map;

import com.css.app.xlgl.entity.XlglNotice;

/**
 * 训练管理-通知公告表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-04 13:44:55
 */
public interface XlglNoticeService {
	
	XlglNotice queryObject(String id);
	
	List<XlglNotice> queryList(Map<String, Object> map);
	
	void save(XlglNotice xlglNotice);
	
	void update(XlglNotice xlglNotice);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
}
