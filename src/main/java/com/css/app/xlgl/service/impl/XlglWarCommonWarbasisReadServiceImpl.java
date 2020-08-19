package com.css.app.xlgl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.css.app.xlgl.dao.XlglWarCommonWarbasisReadDao;
import com.css.app.xlgl.entity.XlglWarCommonWarbasisRead;
import com.css.app.xlgl.service.XlglWarCommonWarbasisReadService;



@Service("xlglWarCommonWarbasisReadService")
public class XlglWarCommonWarbasisReadServiceImpl implements XlglWarCommonWarbasisReadService {
	@Autowired
	private XlglWarCommonWarbasisReadDao xlglWarCommonWarbasisReadDao;
	
	@Override
	public XlglWarCommonWarbasisRead queryObject(String id){
		return xlglWarCommonWarbasisReadDao.queryObject(id);
	}
	
	@Override
	public List<XlglWarCommonWarbasisRead> queryList(Map<String, Object> map){
		return xlglWarCommonWarbasisReadDao.queryList(map);
	}
	
	@Override
	public void save(XlglWarCommonWarbasisRead xlglWarCommonWarbasisRead){
		xlglWarCommonWarbasisReadDao.save(xlglWarCommonWarbasisRead);
	}
	
	@Override
	public void update(XlglWarCommonWarbasisRead xlglWarCommonWarbasisRead){
		xlglWarCommonWarbasisReadDao.update(xlglWarCommonWarbasisRead);
	}
	
	@Override
	public void delete(String id){
		xlglWarCommonWarbasisReadDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		xlglWarCommonWarbasisReadDao.deleteBatch(ids);
	}
	
}
