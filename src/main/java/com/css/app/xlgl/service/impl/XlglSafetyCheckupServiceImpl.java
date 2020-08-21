package com.css.app.xlgl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.css.app.xlgl.dao.XlglSafetyCheckupDao;
import com.css.app.xlgl.entity.XlglSafetyCheckup;
import com.css.app.xlgl.service.XlglSafetyCheckupService;



@Service("xlglSafetyCheckupService")
public class XlglSafetyCheckupServiceImpl implements XlglSafetyCheckupService {
	@Autowired
	private XlglSafetyCheckupDao xlglSafetyCheckupDao;
	
	@Override
	public XlglSafetyCheckup queryObject(String id){
		return xlglSafetyCheckupDao.queryObject(id);
	}
	
	@Override
	public List<XlglSafetyCheckup> queryList(Map<String, Object> map){
		return xlglSafetyCheckupDao.queryList(map);
	}
	
	@Override
	public void save(XlglSafetyCheckup xlglSafetyCheckup){
		xlglSafetyCheckupDao.save(xlglSafetyCheckup);
	}
	
	@Override
	public void update(XlglSafetyCheckup xlglSafetyCheckup){
		xlglSafetyCheckupDao.update(xlglSafetyCheckup);
	}
	
	@Override
	public void delete(String id){
		xlglSafetyCheckupDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		xlglSafetyCheckupDao.deleteBatch(ids);
	}
	
}
