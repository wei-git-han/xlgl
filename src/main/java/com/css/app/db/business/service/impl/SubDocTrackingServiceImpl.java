package com.css.app.db.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.css.app.db.business.dao.SubDocTrackingDao;
import com.css.app.db.business.entity.SubDocTracking;
import com.css.app.db.business.service.SubDocTrackingService;



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
	public void save(SubDocTracking dbSubDocTracking){
		subDocTrackingDao.save(dbSubDocTracking);
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
	
}
