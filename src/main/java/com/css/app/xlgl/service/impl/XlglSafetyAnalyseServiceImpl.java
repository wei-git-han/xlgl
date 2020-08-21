package com.css.app.xlgl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.css.app.xlgl.dao.XlglSafetyAnalyseDao;
import com.css.app.xlgl.entity.XlglSafetyAnalyse;
import com.css.app.xlgl.service.XlglSafetyAnalyseService;



@Service("xlglSafetyAnalyseService")
public class XlglSafetyAnalyseServiceImpl implements XlglSafetyAnalyseService {
	@Autowired
	private XlglSafetyAnalyseDao xlglSafetyAnalyseDao;
	
	@Override
	public XlglSafetyAnalyse queryObject(String id){
		return xlglSafetyAnalyseDao.queryObject(id);
	}
	
	@Override
	public List<XlglSafetyAnalyse> queryList(Map<String, Object> map){
		return xlglSafetyAnalyseDao.queryList(map);
	}
	
	@Override
	public void save(XlglSafetyAnalyse xlglSafetyAnalyse){
		xlglSafetyAnalyseDao.save(xlglSafetyAnalyse);
	}
	
	@Override
	public void update(XlglSafetyAnalyse xlglSafetyAnalyse){
		xlglSafetyAnalyseDao.update(xlglSafetyAnalyse);
	}
	
	@Override
	public void delete(String id){
		xlglSafetyAnalyseDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		xlglSafetyAnalyseDao.deleteBatch(ids);
	}
	
}
