package com.css.app.xlgl.service.impl;

import com.css.app.xlgl.dao.XlglZbglDao;
import com.css.app.xlgl.entity.XlglZbgl;
import com.css.app.xlgl.service.XlglZbglService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;




@Service("xlglZbglService")
public class XlglZbglServiceImpl implements XlglZbglService {
	@Autowired
	private XlglZbglDao xlglZbglDao;
	
	@Override
	public XlglZbgl queryObject(String id){
		return xlglZbglDao.queryObject(id);
	}
	
	@Override
	public List<XlglZbgl> queryList(Map<String, Object> map){
		return xlglZbglDao.queryList(map);
	}
	
	@Override
	public void save(XlglZbgl xlglZbgl){
		xlglZbglDao.save(xlglZbgl);
	}
	
	@Override
	public void update(XlglZbgl xlglZbgl){
		xlglZbglDao.update(xlglZbgl);
	}
	
	@Override
	public void delete(String id){
		xlglZbglDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		xlglZbglDao.deleteBatch(ids);
	}
	
}
