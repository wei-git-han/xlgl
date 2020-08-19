package com.css.app.xlgl.service.impl;

import com.css.app.xlgl.dao.XlglCarsManagerDao;
import com.css.app.xlgl.entity.XlglCarsManager;
import com.css.app.xlgl.service.XlglCarsManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;




@Service("xlglCarsManagerService")
public class XlglCarsManagerServiceImpl implements XlglCarsManagerService {
	@Autowired
	private XlglCarsManagerDao xlglCarsManagerDao;
	
	@Override
	public XlglCarsManager queryObject(String id){
		return xlglCarsManagerDao.queryObject(id);
	}
	
	@Override
	public List<XlglCarsManager> queryList(Map<String, Object> map){
		return xlglCarsManagerDao.queryList(map);
	}
	
	@Override
	public void save(XlglCarsManager xlglCarsManager){
		xlglCarsManagerDao.save(xlglCarsManager);
	}
	
	@Override
	public void update(XlglCarsManager xlglCarsManager){
		xlglCarsManagerDao.update(xlglCarsManager);
	}
	
	@Override
	public void delete(String id){
		xlglCarsManagerDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		xlglCarsManagerDao.deleteBatch(ids);
	}
	
}
