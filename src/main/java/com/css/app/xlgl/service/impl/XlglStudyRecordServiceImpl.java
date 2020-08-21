package com.css.app.xlgl.service.impl;

import com.css.app.xlgl.dao.XlglStudyRecordDao;
import com.css.app.xlgl.entity.XlglStudyRecord;
import com.css.app.xlgl.service.XlglStudyRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service("xlglStudyRecordService")
public class XlglStudyRecordServiceImpl implements XlglStudyRecordService {
	@Autowired
	private XlglStudyRecordDao xlglStudyRecordDao;
	
	@Override
	public XlglStudyRecord queryObject(String id){
		return xlglStudyRecordDao.queryObject(id);
	}
	
	@Override
	public List<XlglStudyRecord> queryList(Map<String, Object> map){
		return xlglStudyRecordDao.queryList(map);
	}
	
	@Override
	public void save(XlglStudyRecord xlglStudyRecord){
		xlglStudyRecordDao.save(xlglStudyRecord);
	}
	
	@Override
	public void update(XlglStudyRecord xlglStudyRecord){
		xlglStudyRecordDao.update(xlglStudyRecord);
	}
	
	@Override
	public void delete(String id){
		xlglStudyRecordDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		xlglStudyRecordDao.deleteBatch(ids);
	}
	
}
