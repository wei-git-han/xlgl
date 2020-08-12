package com.css.app.xlgl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.css.app.xlgl.dao.XlglNoticeReadDao;
import com.css.app.xlgl.entity.XlglNoticeRead;
import com.css.app.xlgl.service.XlglNoticeReadService;



@Service("xlglNoticeReadService")
public class XlglNoticeReadServiceImpl implements XlglNoticeReadService {
	@Autowired
	private XlglNoticeReadDao xlglNoticeReadDao;
	
	@Override
	public XlglNoticeRead queryObject(String id){
		return xlglNoticeReadDao.queryObject(id);
	}
	
	@Override
	public List<XlglNoticeRead> queryList(Map<String, Object> map){
		return xlglNoticeReadDao.queryList(map);
	}
	
	@Override
	public void save(XlglNoticeRead xlglNoticeRead){
		xlglNoticeReadDao.save(xlglNoticeRead);
	}
	
	@Override
	public void update(XlglNoticeRead xlglNoticeRead){
		xlglNoticeReadDao.update(xlglNoticeRead);
	}
	
	@Override
	public void delete(String id){
		xlglNoticeReadDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		xlglNoticeReadDao.deleteBatch(ids);
	}
	
}
