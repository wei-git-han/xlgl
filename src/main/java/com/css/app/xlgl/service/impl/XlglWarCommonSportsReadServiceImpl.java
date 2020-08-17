package com.css.app.xlgl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.css.app.xlgl.dao.XlglWarCommonSportsReadDao;
import com.css.app.xlgl.entity.XlglWarCommonSportsRead;
import com.css.app.xlgl.service.XlglWarCommonSportsReadService;



@Service("xlglWarCommonSportsReadService")
public class XlglWarCommonSportsReadServiceImpl implements XlglWarCommonSportsReadService {
	@Autowired
	private XlglWarCommonSportsReadDao xlglWarCommonSportsReadDao;
	
	@Override
	public XlglWarCommonSportsRead queryObject(String id){
		return xlglWarCommonSportsReadDao.queryObject(id);
	}
	
	@Override
	public List<XlglWarCommonSportsRead> queryList(Map<String, Object> map){
		return xlglWarCommonSportsReadDao.queryList(map);
	}
	
	@Override
	public void save(XlglWarCommonSportsRead xlglWarCommonSportsRead){
		xlglWarCommonSportsReadDao.save(xlglWarCommonSportsRead);
	}
	
	@Override
	public void update(XlglWarCommonSportsRead xlglWarCommonSportsRead){
		xlglWarCommonSportsReadDao.update(xlglWarCommonSportsRead);
	}
	
	@Override
	public void delete(String id){
		xlglWarCommonSportsReadDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		xlglWarCommonSportsReadDao.deleteBatch(ids);
	}
	
}
