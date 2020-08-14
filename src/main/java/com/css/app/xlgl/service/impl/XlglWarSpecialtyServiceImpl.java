package com.css.app.xlgl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.css.app.xlgl.dao.XlglWarSpecialtyDao;
import com.css.app.xlgl.entity.XlglWarSpecialty;
import com.css.app.xlgl.service.XlglWarSpecialtyService;



@Service("xlglWarSpecialtyService")
public class XlglWarSpecialtyServiceImpl implements XlglWarSpecialtyService {
	@Autowired
	private XlglWarSpecialtyDao xlglWarSpecialtyDao;
	
	@Override
	public XlglWarSpecialty queryObject(String id){
		return xlglWarSpecialtyDao.queryObject(id);
	}
	
	@Override
	public List<XlglWarSpecialty> queryList(Map<String, Object> map){
		return xlglWarSpecialtyDao.queryList(map);
	}
	
	@Override
	public void save(XlglWarSpecialty xlglWarSpecialty){
		xlglWarSpecialtyDao.save(xlglWarSpecialty);
	}
	
	@Override
	public void update(XlglWarSpecialty xlglWarSpecialty){
		xlglWarSpecialtyDao.update(xlglWarSpecialty);
	}
	
	@Override
	public void delete(String id){
		xlglWarSpecialtyDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		xlglWarSpecialtyDao.deleteBatch(ids);
	}
	
}
