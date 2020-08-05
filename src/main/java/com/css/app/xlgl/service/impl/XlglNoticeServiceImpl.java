package com.css.app.xlgl.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.css.app.xlgl.dao.XlglNoticeDao;
import com.css.app.xlgl.entity.XlglNotice;
import com.css.app.xlgl.service.XlglNoticeService;




@Service("xlglNoticeService")
public class XlglNoticeServiceImpl implements XlglNoticeService {
	@Autowired
	private XlglNoticeDao xlglNoticeDao;
	
	@Override
	public XlglNotice queryObject(String id){
		return xlglNoticeDao.queryObject(id);
	}
	
	@Override
	public List<XlglNotice> queryList(Map<String, Object> map){
		return xlglNoticeDao.queryList(map);
	}
	
	@Override
	public void save(XlglNotice xlglNotice){
		xlglNoticeDao.save(xlglNotice);
	}
	
	@Override
	public void update(XlglNotice xlglNotice){
		xlglNoticeDao.update(xlglNotice);
	}
	
	@Override
	public void delete(String id){
		xlglNoticeDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		xlglNoticeDao.deleteBatch(ids);
	}
	
}
