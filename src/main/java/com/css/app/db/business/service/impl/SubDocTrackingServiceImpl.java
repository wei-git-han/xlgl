package com.css.app.db.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.css.app.db.business.dao.SubDocTrackingDao;
import com.css.app.db.business.entity.SubDocTracking;
import com.css.app.db.business.service.SubDocTrackingService;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.UUIDUtils;



@Service("subDocTrackingService")
public class SubDocTrackingServiceImpl implements SubDocTrackingService {
	@Autowired
	private SubDocTrackingDao subDocTrackingDao;
	
	@Override
	public SubDocTracking queryObject(String id){
		return subDocTrackingDao.queryObject(id);
	}
	
	@Override
	public List<SubDocTracking> queryList(Map<String, Object> map){
		return subDocTrackingDao.queryList(map);
	}
	
	@Override
	public void save(SubDocTracking tracking){
		String loginUserId=CurrentUser.getUserId();
		String loginUserName=CurrentUser.getUsername();
		String loginUserDeptId=CurrentUser.getDepartmentId();
		String loginUserDeptName=CurrentUser.getOrgName();
		tracking.setId(UUIDUtils.random());
		tracking.setSenderId(loginUserId);
		tracking.setSenderName(loginUserName);
		tracking.setSenDeptId(loginUserDeptId);
		tracking.setSenDeptName(loginUserDeptName);
		tracking.setCreatedTime(new Date());
		subDocTrackingDao.save(tracking);
	}
	
	@Override
	public void update(SubDocTracking dbSubDocTracking){
		subDocTrackingDao.update(dbSubDocTracking);
	}
	
	@Override
	public void delete(String id){
		subDocTrackingDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		subDocTrackingDao.deleteBatch(ids);
	}

	@Override
	public SubDocTracking queryLatestRecord(String subId) {
		return subDocTrackingDao.queryLatestRecord(subId);
	}

	@Override
	public void deleteBySubId(String subId) {
		subDocTrackingDao.deleteBySubId(subId);
	}
	
}
