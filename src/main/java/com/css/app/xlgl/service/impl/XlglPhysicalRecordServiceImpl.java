package com.css.app.xlgl.service.impl;

import com.css.app.xlgl.dao.XlglPhysicalRecordDao;
import com.css.app.xlgl.entity.XlglPhysicalRecord;
import com.css.app.xlgl.service.XlglPhysicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("xlglPhysicalRecordService")
public class XlglPhysicalRecordServiceImpl implements XlglPhysicalRecordService {
	@Autowired
	private XlglPhysicalRecordDao xlglPhysicalRecordDao;
	
	@Override
	public XlglPhysicalRecord queryObject(String id){
		return xlglPhysicalRecordDao.queryObject(id);
	}
	
	@Override
	public List<XlglPhysicalRecord> queryList(Map<String, Object> map){
		return xlglPhysicalRecordDao.queryList(map);
	}
	
	@Override
	public void save(XlglPhysicalRecord xlglPhysicalRecord){
		xlglPhysicalRecordDao.save(xlglPhysicalRecord);
	}
	
	@Override
	public void update(XlglPhysicalRecord xlglPhysicalRecord){
		xlglPhysicalRecordDao.update(xlglPhysicalRecord);
	}
	
	@Override
	public void delete(String id){
		xlglPhysicalRecordDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		xlglPhysicalRecordDao.deleteBatch(ids);
	}
	
}
