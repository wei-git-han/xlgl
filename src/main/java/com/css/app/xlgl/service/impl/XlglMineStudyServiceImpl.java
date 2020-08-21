package com.css.app.xlgl.service.impl;

import com.css.app.xlgl.dao.XlglMineStudyDao;
import com.css.app.xlgl.entity.XlglMineStudy;
import com.css.app.xlgl.service.XlglMineStudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service("xlglMineStudyService")
public class XlglMineStudyServiceImpl implements XlglMineStudyService {
	@Autowired
	private XlglMineStudyDao xlglMineStudyDao;
	
	@Override
	public XlglMineStudy queryObject(String id){
		return xlglMineStudyDao.queryObject(id);
	}
	
	@Override
	public List<XlglMineStudy> queryList(Map<String, Object> map){
		return xlglMineStudyDao.queryList(map);
	}
	
	@Override
	public void save(XlglMineStudy xlglMineStudy){
		xlglMineStudyDao.save(xlglMineStudy);
	}
	
	@Override
	public void update(XlglMineStudy xlglMineStudy){
		xlglMineStudyDao.update(xlglMineStudy);
	}
	
	@Override
	public void delete(String id){
		xlglMineStudyDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		xlglMineStudyDao.deleteBatch(ids);
	}
	
}
