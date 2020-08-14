package com.css.app.xlgl.service;


import com.css.app.xlgl.entity.XlglDocumentZbjl;

import java.util.List;
import java.util.Map;

/**
 * 转办记录表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-11 11:11:27
 */
public interface XlglDocumentZbjlService {
	
	XlglDocumentZbjl queryObject(String id);
	
	List<XlglDocumentZbjl> queryList(Map<String, Object> map);
	
	void save(XlglDocumentZbjl xlglDocumentZbjl);
	
	void update(XlglDocumentZbjl xlglDocumentZbjl);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
}
