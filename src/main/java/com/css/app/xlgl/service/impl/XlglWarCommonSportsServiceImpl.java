package com.css.app.xlgl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.css.app.xlgl.dao.XlglWarCommonSportsDao;
import com.css.app.xlgl.entity.XlglWarCommonSports;
import com.css.app.xlgl.service.XlglWarCommonSportsService;



@Service("xlglWarCommonSportsService")
public class XlglWarCommonSportsServiceImpl implements XlglWarCommonSportsService {
	@Autowired
	private XlglWarCommonSportsDao xlglWarCommonSportsDao;
	
	@Override
	public XlglWarCommonSports queryObject(String id){
		return xlglWarCommonSportsDao.queryObject(id);
	}
	
	@Override
	public List<XlglWarCommonSports> queryList(Map<String, Object> map){
		return xlglWarCommonSportsDao.queryList(map);
	}
	
	@Override
	public void save(XlglWarCommonSports xlglWarCommonSports){
		xlglWarCommonSportsDao.save(xlglWarCommonSports);
	}
	
	@Override
	public void update(XlglWarCommonSports xlglWarCommonSports){
		xlglWarCommonSportsDao.update(xlglWarCommonSports);
	}
	
	@Override
	public void delete(String id){
		xlglWarCommonSportsDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		xlglWarCommonSportsDao.deleteBatch(ids);
	}
	
}
