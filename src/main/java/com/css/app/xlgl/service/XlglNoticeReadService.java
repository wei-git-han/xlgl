package com.css.app.xlgl.service;

import com.css.app.xlgl.entity.XlglNoticeRead;

import java.util.List;
import java.util.Map;

/**
 * 通知公告已阅人员表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-12 17:14:57
 */
public interface XlglNoticeReadService {
	
	XlglNoticeRead queryObject(String id);
	
	List<XlglNoticeRead> queryList(Map<String, Object> map);
	
	void save(XlglNoticeRead xlglNoticeRead);
	
	void update(XlglNoticeRead xlglNoticeRead);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
	XlglNoticeRead queryIsRead(String noticeId,String userId);
}
