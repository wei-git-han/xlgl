package com.css.app.xlgl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.css.app.xlgl.dao.XlglWarCommonSportsFileDao;
import com.css.app.xlgl.entity.XlglWarCommonSportsFile;
import com.css.app.xlgl.service.XlglWarCommonSportsFileService;



@Service("xlglWarCommonSportsFileService")
public class XlglWarCommonSportsFileServiceImpl implements XlglWarCommonSportsFileService {
	@Autowired
	private XlglWarCommonSportsFileDao xlglWarCommonSportsFileDao;
	
	@Override
	public XlglWarCommonSportsFile queryObject(String id){
		return xlglWarCommonSportsFileDao.queryObject(id);
	}
	
	@Override
	public List<XlglWarCommonSportsFile> queryList(Map<String, Object> map){
		return xlglWarCommonSportsFileDao.queryList(map);
	}
	
	@Override
	public void save(XlglWarCommonSportsFile xlglWarCommonSportsFile){
		xlglWarCommonSportsFileDao.save(xlglWarCommonSportsFile);
	}
	
	@Override
	public void update(XlglWarCommonSportsFile xlglWarCommonSportsFile){
		xlglWarCommonSportsFileDao.update(xlglWarCommonSportsFile);
	}
	
	@Override
	public void delete(String id){
		xlglWarCommonSportsFileDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		xlglWarCommonSportsFileDao.deleteBatch(ids);
	}
	
}
