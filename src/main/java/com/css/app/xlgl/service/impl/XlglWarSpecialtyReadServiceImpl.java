package com.css.app.xlgl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.css.app.xlgl.dao.XlglWarSpecialtyReadDao;
import com.css.app.xlgl.entity.XlglWarSpecialtyRead;
import com.css.app.xlgl.service.XlglWarSpecialtyReadService;



@Service("xlglWarSpecialtyReadService")
public class XlglWarSpecialtyReadServiceImpl implements XlglWarSpecialtyReadService {
	@Autowired
	private XlglWarSpecialtyReadDao xlglWarSpecialtyReadDao;
	
	@Override
	public XlglWarSpecialtyRead queryObject(String id){
		return xlglWarSpecialtyReadDao.queryObject(id);
	}
	
	@Override
	public List<XlglWarSpecialtyRead> queryList(Map<String, Object> map){
		return xlglWarSpecialtyReadDao.queryList(map);
	}
	
	@Override
	public void save(XlglWarSpecialtyRead xlglWarSpecialtyRead){
		xlglWarSpecialtyReadDao.save(xlglWarSpecialtyRead);
	}
	
	@Override
	public void update(XlglWarSpecialtyRead xlglWarSpecialtyRead){
		xlglWarSpecialtyReadDao.update(xlglWarSpecialtyRead);
	}
	
	@Override
	public void delete(String id){
		xlglWarSpecialtyReadDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		xlglWarSpecialtyReadDao.deleteBatch(ids);
	}
	
}
