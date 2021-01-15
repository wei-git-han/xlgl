package com.css.app.xlgl.service.impl;

import com.css.app.xlgl.dao.XlglSubDocTrackingDao;
import com.css.app.xlgl.entity.XlglSubDocTracking;
import com.css.app.xlgl.service.XlglSubDocTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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
	public XlglSubDocTracking queryInfomation(String id,String userId){
		return xlglSubDocTrackingDao.queryInfomation(id,userId);
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
	public XlglSubDocTracking querySortByInfoIdAndUserId(String infoId,String userId){
		return xlglSubDocTrackingDao.querySortByInfoIdAndUserId(infoId,userId);
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
	public List<XlglSubDocTracking> queryAllInfoHistory(Map<String,Object> map1){
		return xlglSubDocTrackingDao.queryAllInfoHistory(map1);
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
	public List<XlglSubDocTracking> queryByUserIdAndYear(String userId,String year){
		return xlglSubDocTrackingDao.queryByUserIdAndYear(userId,year);
	}
	@Override
	public int quereyWcCount(String userId,String year){
		return xlglSubDocTrackingDao.quereyWcCount(userId,year);
	}

	@Override
	public int queryYhCount(String userId,String year){
		return xlglSubDocTrackingDao.queryYhCount(userId,year);
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
	public int queryBkCount(Map<String,Object> map){
		return xlglSubDocTrackingDao.queryBkCount(map);
	}
	@Override
	public int queryBmCount(Map<String,Object> map){
		return xlglSubDocTrackingDao.queryBmCount(map);
	}

	@Override
	public int queryAllYx(String year){
		return xlglSubDocTrackingDao.queryAllYx(year);
	}

	@Override
	public int queryAllCx(String fileId){
		return xlglSubDocTrackingDao.queryAllCx(fileId);
	}

	@Override
	public int queryAllBkCount(String fileId){
		return xlglSubDocTrackingDao.queryAllBkCount(fileId);
	}

	@Override
	public int queryAllYh(String fileId){
		return xlglSubDocTrackingDao.queryAllYh(fileId);
	}

	@Override
	public int queryAllCxByInfoId(String fileId,String orgId){
		return xlglSubDocTrackingDao.queryAllCxByInfoId(fileId,orgId);
	}

	@Override
	public int queryAllBkByInfoId(String fileId,String orgId){
		return xlglSubDocTrackingDao.queryAllBkByInfoId(fileId,orgId);
	}

	@Override
	public int queryCxAllCount(Map<String,Object> map){
		return xlglSubDocTrackingDao.queryCxAllCount(map);
	}

	@Override
	public List<XlglSubDocTracking> queryBySort(Map<String,Object> map){
		return xlglSubDocTrackingDao.queryBySort(map);
	}

	@Override
	public void deleteByInfoIdAndUserId(String infoId,String userId){
		xlglSubDocTrackingDao.deleteByInfoIdAndUserId(infoId,userId);

	}

	@Override
	public void deleteByInfoId(String id){
		xlglSubDocTrackingDao.deleteByInfoId(id);
	}

	@Override
	public void deleteByInfoIdAndOrgId(String orgId,String id){
		xlglSubDocTrackingDao.deleteByInfoIdAndOrgId(orgId,id);
	}

	@Override
	public XlglSubDocTracking queryDjtInfo(String infoId,String userId){
		return xlglSubDocTrackingDao.queryDjtInfo(infoId,userId);
	}

	@Override
	public List<XlglSubDocTracking> queryMsgRemind() {
		return xlglSubDocTrackingDao.queryMsgRemind();
	}

	@Override
	public int queryAllWcByInfoIdAndOrgId(String infoId,String orgId,String year){
		return xlglSubDocTrackingDao.queryAllWcByInfoIdAndOrgId(infoId,orgId,year);
	}

	@Override
	public Map<String, Object> queryAllCountList(String year) {
		Map<String,Object> map = new HashMap<String,Object>();
		List<Map<String,Object>> queryAllCountList = xlglSubDocTrackingDao.queryAllCountList(year);
		for (Map<String, Object> map2 : queryAllCountList) {
			if(map2.get("sum") !=null) {
				map.put((String) map2.get("userId"),map2.get("sum"));
			}
		}
		return map;
	}

	@Override
	public Map<String, Object> quereyWcCountList(String year) {
		Map<String,Object> map = new HashMap<String,Object>();
		List<Map<String,Object>> queryAllCountList = xlglSubDocTrackingDao.queryAllCountList(year);
		for (Map<String, Object> map2 : queryAllCountList) {
			if(map2.get("sum") !=null) {
				map.put((String) map2.get("userId"),map2.get("sum"));
			}
		
		}
		return map;
	}


}
