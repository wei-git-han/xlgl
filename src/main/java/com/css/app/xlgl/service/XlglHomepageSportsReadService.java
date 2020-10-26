package com.css.app.xlgl.service;


import com.css.app.xlgl.entity.XlglHomepageSportsRead;

import java.util.List;
import java.util.Map;

/**
 * 训练管理-体育活动-已读未读表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-10-26 13:22:50
 */
public interface XlglHomepageSportsReadService {
	
	XlglHomepageSportsRead queryObject(String id);
	
	List<XlglHomepageSportsRead> queryList(Map<String, Object> map);
	
	void save(XlglHomepageSportsRead xlglHomepageSportsRead);
	
	void update(XlglHomepageSportsRead xlglHomepageSportsRead);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);

	XlglHomepageSportsRead queryBySportAndUserId(String sportId,String userId);

	void deleteBySportId(String sportId);
}
