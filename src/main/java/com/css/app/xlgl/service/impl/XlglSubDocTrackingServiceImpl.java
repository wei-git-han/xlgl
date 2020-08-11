package com.css.app.xlgl.service.impl;

import com.css.app.xlgl.dao.XlglSubDocTrackingDao;
import com.css.app.xlgl.entity.XlglSubDocTracking;
import com.css.app.xlgl.service.XlglSubDocTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;




@Service("xlglSubDocTrackingService")
public class XlglSubDocTrackingServiceImpl implements XlglSubDocTrackingService {
	@Autowired
	private XlglSubDocTrackingDao xlglSubDocTrackingDao;
	
	@Override
	public XlglSubDocTracking queryObject(String id){
		return xlglSubDocTrackingDao.queryObject(id);
	}
	
	@Override
	public List<XlglSubDocTracking> queryList(Map<String, Object> map){
		return xlglSubDocTrackingDao.queryList(map);
	}
	
	@Override
	public void save(XlglSubDocTracking xlglSubDocTracking){
		xlglSubDocTrackingDao.save(xlglSubDocTracking);
	}
	
	@Override
	public void update(XlglSubDocTracking xlglSubDocTracking){
		xlglSubDocTrackingDao.update(xlglSubDocTracking);
	}
	
	@Override
	public void delete(String id){
		xlglSubDocTrackingDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		xlglSubDocTrackingDao.deleteBatch(ids);
	}
	
}
