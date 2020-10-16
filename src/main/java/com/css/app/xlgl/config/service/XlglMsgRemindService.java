package com.css.app.xlgl.config.service;

import com.css.app.xlgl.config.entity.XlglMsgRemind;

import java.util.List;
import java.util.Map;

/**
 * 消息提醒开关表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-10-15 16:14:46
 */
public interface XlglMsgRemindService {
	
	XlglMsgRemind queryObject(String id);
	
	List<XlglMsgRemind> queryList(Map<String, Object> map);
	
	void save(XlglMsgRemind xlglMsgRemind);
	
	void update(XlglMsgRemind xlglMsgRemind);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
}
