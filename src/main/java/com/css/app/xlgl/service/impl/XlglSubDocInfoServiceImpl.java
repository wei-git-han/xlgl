package com.css.app.xlgl.service.impl;

import com.css.app.xlgl.dao.XlglSubDocInfoDao;
import com.css.app.xlgl.entity.XlglSubDocInfo;
import com.css.app.xlgl.entity.XlglSubDocTracking;
import com.css.app.xlgl.service.XlglSubDocInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;




@Service("xlglSubDocInfoService")
public class XlglSubDocInfoServiceImpl implements XlglSubDocInfoService {
	@Autowired
	private XlglSubDocInfoDao xlglSubDocInfoDao;
	
	@Override
	public XlglSubDocInfo queryObject(String id){
		return xlglSubDocInfoDao.queryObject(id);
	}
	
	@Override
	public List<XlglSubDocInfo> queryList(Map<String, Object> map){
		return xlglSubDocInfoDao.queryList(map);
	}
	
	@Override
	public void save(XlglSubDocInfo xlglSubDocInfo){
		xlglSubDocInfoDao.save(xlglSubDocInfo);
	}
	
	@Override
	public void update(XlglSubDocInfo xlglSubDocInfo){
		xlglSubDocInfoDao.update(xlglSubDocInfo);
	}
	
	@Override
	public void delete(String id){
		xlglSubDocInfoDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		xlglSubDocInfoDao.deleteBatch(ids);
	}

	@Override
	public List<String> queryAllSubDeptIds(String fileId){
		return xlglSubDocInfoDao.queryAllSubDeptIds(fileId);
	}

	@Override
	public List<XlglSubDocInfo> queryAllClass(String orgId,String year){
		return xlglSubDocInfoDao.queryAllClass(orgId,year);
	}


	@Override
	public List<XlglSubDocInfo> queryListForJu(Map<String,Object> map){
		return xlglSubDocInfoDao.queryListForJu(map);
	}

	@Override
	public List<XlglSubDocInfo> queryListForPerson(Map<String,Object> map){
		return xlglSubDocInfoDao.queryListForPerson(map);
	}

	@Override
	public void deleteSub(String orgId,String fileId){
		xlglSubDocInfoDao.deleteSub(orgId,fileId);
	}

	@Override
	public List<XlglSubDocTracking> queryByInfoIdAndUserId(String infoId,String userId){
		return xlglSubDocInfoDao.queryByInfoIdAndUserId(infoId,userId);
	}

}
