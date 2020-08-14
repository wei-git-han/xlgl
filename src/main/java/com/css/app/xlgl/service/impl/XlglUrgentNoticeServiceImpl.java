package com.css.app.xlgl.service.impl;

import com.css.app.xlgl.dao.XlglUrgentNoticeDao;
import com.css.app.xlgl.entity.XlglUrgentNotice;
import com.css.app.xlgl.service.XlglUrgentNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;




@Service("xlglUrgentNoticeService")
public class XlglUrgentNoticeServiceImpl implements XlglUrgentNoticeService {
	@Autowired
	private XlglUrgentNoticeDao xlglUrgentNoticeDao;
	
	@Override
	public XlglUrgentNotice queryObject(String id){
		return xlglUrgentNoticeDao.queryObject(id);
	}
	
	@Override
	public List<XlglUrgentNotice> queryList(Map<String, Object> map){
		return xlglUrgentNoticeDao.queryList(map);
	}
	
	@Override
	public void save(XlglUrgentNotice xlglUrgentNotice){
		xlglUrgentNoticeDao.save(xlglUrgentNotice);
	}
	
	@Override
	public void update(XlglUrgentNotice xlglUrgentNotice){
		xlglUrgentNoticeDao.update(xlglUrgentNotice);
	}
	
	@Override
	public void delete(String id){
		xlglUrgentNoticeDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		xlglUrgentNoticeDao.deleteBatch(ids);
	}

	@Override
	public XlglUrgentNotice queryNotice(){
		return xlglUrgentNoticeDao.queryNotice();
	}
	
}
