package com.css.app.db.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.css.app.db.business.dao.DocXbInfoDao;
import com.css.app.db.business.entity.DocXbInfo;
import com.css.app.db.business.service.DocXbInfoService;



@Service("DocXbInfoService")
public class DocXbInfoServiceImpl implements DocXbInfoService {
	@Autowired
	private DocXbInfoDao DocXbInfoDao;
	
	@Override
	public DocXbInfo queryObject(String id){
		return DocXbInfoDao.queryObject(id);
	}
	
	@Override
	public List<DocXbInfo> queryList(Map<String, Object> map){
		return DocXbInfoDao.queryList(map);
	}
	
	@Override
	public void save(DocXbInfo DocXbInfo){
		DocXbInfoDao.save(DocXbInfo);
	}
	
	@Override
	public void update(DocXbInfo DocXbInfo){
		DocXbInfoDao.update(DocXbInfo);
	}
	
	@Override
	public void delete(String id){
		DocXbInfoDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		DocXbInfoDao.deleteBatch(ids);
	}

	@Override
	public List<DocXbInfo> queryXbRecord(String infoId) {
		// TODO Auto-generated method stub
		return DocXbInfoDao.queryXbRecord(infoId);
	}

	@Override
	public void deleteBySubIdAndReceiverId(String subId, String userId) {
		DocXbInfoDao.deleteBySubIdAndReceiverId(subId, userId);
		
	}
	
}
