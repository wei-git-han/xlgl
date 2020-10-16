package com.css.app.xlgl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.css.app.xlgl.dao.XlglHomepageSportsDao;
import com.css.app.xlgl.entity.XlglHomepageSports;
import com.css.app.xlgl.service.XlglHomepageSportsService;



@Service("xlglHomepageSportsService")
public class XlglHomepageSportsServiceImpl implements XlglHomepageSportsService {
	@Autowired
	private XlglHomepageSportsDao xlglHomepageSportsDao;
	
	@Override
	public XlglHomepageSports queryObject(String id){
		return xlglHomepageSportsDao.queryObject(id);
	}
	
	@Override
	public List<XlglHomepageSports> queryList(Map<String, Object> map){
		return xlglHomepageSportsDao.queryList(map);
	}
	
	@Override
	public void save(XlglHomepageSports xlglHomepageSports){
		xlglHomepageSportsDao.save(xlglHomepageSports);
	}
	
	@Override
	public void update(XlglHomepageSports xlglHomepageSports){
		xlglHomepageSportsDao.update(xlglHomepageSports);
	}
	
	@Override
	public void delete(String id){
		xlglHomepageSportsDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		xlglHomepageSportsDao.deleteBatch(ids);
	}
	
}
