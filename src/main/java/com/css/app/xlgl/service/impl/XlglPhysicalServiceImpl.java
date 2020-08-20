package com.css.app.xlgl.service.impl;

import com.css.app.xlgl.dao.XlglPhysicalDao;
import com.css.app.xlgl.entity.XlglPhysical;
import com.css.app.xlgl.service.XlglPhysicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;




@Service("xlglPhysicalService")
public class XlglPhysicalServiceImpl implements XlglPhysicalService {
	@Autowired
	private XlglPhysicalDao xlglPhysicalDao;
	
	@Override
	public XlglPhysical queryObject(String id){
		return xlglPhysicalDao.queryObject(id);
	}
	
	@Override
	public List<XlglPhysical> queryList(Map<String, Object> map){
		return xlglPhysicalDao.queryList(map);
	}
	
	@Override
	public void save(XlglPhysical xlglPhysical){
		xlglPhysicalDao.save(xlglPhysical);
	}
	
	@Override
	public void update(XlglPhysical xlglPhysical){
		xlglPhysicalDao.update(xlglPhysical);
	}
	
	@Override
	public void delete(String id){
		xlglPhysicalDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		xlglPhysicalDao.deleteBatch(ids);
	}
	
}
