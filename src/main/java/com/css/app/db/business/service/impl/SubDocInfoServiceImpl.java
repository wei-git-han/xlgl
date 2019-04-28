package com.css.app.db.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.css.app.db.business.dao.SubDocInfoDao;
import com.css.app.db.business.entity.SubDocInfo;
import com.css.app.db.business.service.SubDocInfoService;



@Service("subDocInfoService")
public class SubDocInfoServiceImpl implements SubDocInfoService {
	@Autowired
	private SubDocInfoDao subDocInfoDao;
	
	@Override
	public SubDocInfo queryObject(String id){
		return subDocInfoDao.queryObject(id);
	}
	
	@Override
	public List<SubDocInfo> queryList(Map<String, Object> map){
		return subDocInfoDao.queryList(map);
	}
	
	@Override
	public void save(SubDocInfo dbSubDocInfo){
		subDocInfoDao.save(dbSubDocInfo);
	}
	
	@Override
	public void update(SubDocInfo dbSubDocInfo){
		subDocInfoDao.update(dbSubDocInfo);
	}
	
	@Override
	public void delete(String id){
		subDocInfoDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		subDocInfoDao.deleteBatch(ids);
	}

	@Override
	public List<SubDocInfo> queryPersonList(Map<String, Object> map) {
		return subDocInfoDao.queryPersonList(map);
	}

	@Override
	public int updateDocStatus(Integer status,Date updateTime,String infoId) {
		return subDocInfoDao.updateDocStatus(status, updateTime,infoId);
	}

	@Override
	public int queryMinDocStatus(String infoId,String subDeptId) {
		return subDocInfoDao.queryMinDocStatus(infoId,subDeptId);
	}
	
}
