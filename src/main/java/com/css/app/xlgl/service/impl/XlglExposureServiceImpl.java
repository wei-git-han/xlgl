package com.css.app.xlgl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.css.app.xlgl.dao.XlglExposureDao;
import com.css.app.xlgl.entity.XlglExposure;
import com.css.app.xlgl.service.XlglExposureService;



@Service("xlglExposureService")
public class XlglExposureServiceImpl implements XlglExposureService {
	@Autowired
	private XlglExposureDao xlglExposureDao;
	
	@Override
	public XlglExposure queryObject(String id){
		return xlglExposureDao.queryObject(id);
	}
	
	@Override
	public List<XlglExposure> queryList(Map<String, Object> map){
		return xlglExposureDao.queryList(map);
	}
	
	@Override
	public void save(XlglExposure xlglExposure){
		xlglExposureDao.save(xlglExposure);
	}
	
	@Override
	public void update(XlglExposure xlglExposure){
		xlglExposureDao.update(xlglExposure);
	}
	
	@Override
	public void delete(String id){
		xlglExposureDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		xlglExposureDao.deleteBatch(ids);
	}

	@Override
	public List<XlglExposure> queryListInfo(Map<String, Object> map) {
		return xlglExposureDao.queryListInfo(map);
	}
	
}
