package com.css.app.xlgl.service;

import com.css.app.xlgl.entity.XlglHomepageSportsPerson;

import java.util.List;
import java.util.Map;

/**
 * 首页-体育活动-人员报名表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-10-16 10:45:44
 */
public interface XlglHomepageSportsPersonService {
	
	XlglHomepageSportsPerson queryObject(String id);
	
	List<XlglHomepageSportsPerson> queryList(Map<String, Object> map);
	
	void save(XlglHomepageSportsPerson xlglHomepageSportsPerson);
	
	void update(XlglHomepageSportsPerson xlglHomepageSportsPerson);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);

	void deleteBySportIdAndUserId(String sportId,String userId);

	XlglHomepageSportsPerson queryByUserAndSportId(String sportId,String userId);


}
