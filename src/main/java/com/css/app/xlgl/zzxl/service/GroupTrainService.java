package com.css.app.xlgl.zzxl.service;

import javax.servlet.http.HttpServletRequest;

import com.css.app.xlgl.zzxl.entity.GroupTrain;
import com.css.base.utils.ZxPageUtils;

/**
 *
 *
 */
public interface GroupTrainService {

	ZxPageUtils getByPage(HttpServletRequest request);
	
	GroupTrain queryObject(String id);
	
	void save(GroupTrain tGroupTrain);
	
	void update(GroupTrain tGroupTrain);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);

	String fabu(HttpServletRequest request);
}
