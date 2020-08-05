package com.css.app.xlgl.service;


import java.util.List;
import java.util.Map;

import com.css.app.xlgl.entity.XlglNoticeFile;

/**
 * 训练管理-通知公告附件表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-04 13:45:11
 */
public interface XlglNoticeFileService {
	
	XlglNoticeFile queryObject(String id);
	
	List<XlglNoticeFile> queryList(Map<String, Object> map);
	
	void save(XlglNoticeFile xlglNoticeFile);
	
	void update(XlglNoticeFile xlglNoticeFile);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
}
