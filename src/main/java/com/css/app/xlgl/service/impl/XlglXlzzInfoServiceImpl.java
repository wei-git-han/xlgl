package com.css.app.xlgl.service.impl;

import com.css.app.xlgl.dao.XlglXlzzInfoDao;
import com.css.app.xlgl.entity.XlglXlzzInfo;
import com.css.app.xlgl.service.XlglXlzzInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;




@Service("xlglXlzzInfoService")
public class XlglXlzzInfoServiceImpl implements XlglXlzzInfoService {
	@Autowired
	private XlglXlzzInfoDao xlglXlzzInfoDao;
	
	@Override
	public XlglXlzzInfo queryObject(String id){
		return xlglXlzzInfoDao.queryObject(id);
	}
	
	@Override
	public List<XlglXlzzInfo> queryList(Map<String, Object> map){
		return xlglXlzzInfoDao.queryList(map);
	}
	
	@Override
	public void save(XlglXlzzInfo xlglXlzzInfo){
		xlglXlzzInfoDao.save(xlglXlzzInfo);
	}
	
	@Override
	public void update(XlglXlzzInfo xlglXlzzInfo){
		xlglXlzzInfoDao.update(xlglXlzzInfo);
	}
	
	@Override
	public void delete(String id){
		xlglXlzzInfoDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		xlglXlzzInfoDao.deleteBatch(ids);
	}
	
}
