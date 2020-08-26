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

	@Override
	public XlglSubDocTracking queryInfo(String id,String userId){
		return xlglSubDocTrackingDao.queryInfo(id,userId);
	}

	@Override
	public XlglSubDocTracking querybaoming(String infoId,String subId,String userId){
		return xlglSubDocTrackingDao.querybaoming(infoId,subId,userId);
	}

	@Override
	public XlglSubDocTracking queryStatusByInfoIdAndUserId(String infoId,String userId){
		return xlglSubDocTrackingDao.queryStatusByInfoIdAndUserId(infoId,userId);
	}

	@Override
	public List<Map<String,Object>> queryBmInfo(String infoId,String deptId){
		return xlglSubDocTrackingDao.queryBmInfo(infoId,deptId);
	}

	@Override
	public List<XlglSubDocTracking> queryListForPerson(Map<String,Object> map){
		return xlglSubDocTrackingDao.queryListForPerson(map);
	}

	@Override
	public List<XlglSubDocTracking> queryListForPerson1(Map<String,Object> map){
		return xlglSubDocTrackingDao.queryListForPerson1(map);
	}

	@Override
	public List<XlglSubDocTracking> queryAllInfos(Map<String,Object> map1){
		return xlglSubDocTrackingDao.queryAllInfos(map1);
	}

	@Override
	public List<XlglSubDocTracking> queryAllYear(Map<String,Object> map1){
		return xlglSubDocTrackingDao.queryAllYear(map1);
	}

	@Override
	public int queryCount(String fileId){
		return xlglSubDocTrackingDao.queryCount(fileId);
	}
	@Override
	public int queryAllCount(String userId,String year){
		return xlglSubDocTrackingDao.queryAllCount(userId,year);
	}
	@Override
	public int quereyWcCount(String userId,String year){
		return xlglSubDocTrackingDao.quereyWcCount(userId,year);
	}

	@Override
	public int queryCurrentYear(Map<String,Object> map){
		return xlglSubDocTrackingDao.queryCurrentYear(map);
	}
	@Override
	public int queryCxCount(Map<String,Object> map){
		return xlglSubDocTrackingDao.queryCxCount(map);
	}
	@Override
	public int queryBmCount(Map<String,Object> map){
		return xlglSubDocTrackingDao.queryBmCount(map);
	}


}
