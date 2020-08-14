package com.css.app.xlgl.service;


import com.css.app.xlgl.entity.XlglUrgentNotice;

import java.util.List;
import java.util.Map;

/**
 * 紧急通知公告
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-13 14:35:46
 */
public interface XlglUrgentNoticeService {
	
	XlglUrgentNotice queryObject(String id);
	
	List<XlglUrgentNotice> queryList(Map<String, Object> map);
	
	void save(XlglUrgentNotice xlglUrgentNotice);
	
	void update(XlglUrgentNotice xlglUrgentNotice);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);

	XlglUrgentNotice queryNotice();
}
