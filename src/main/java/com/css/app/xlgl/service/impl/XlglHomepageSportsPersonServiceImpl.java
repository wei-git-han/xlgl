package com.css.app.xlgl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.css.app.xlgl.dao.XlglHomepageSportsPersonDao;
import com.css.app.xlgl.entity.XlglHomepageSportsPerson;
import com.css.app.xlgl.service.XlglHomepageSportsPersonService;



@Service("xlglHomepageSportsPersonService")
public class XlglHomepageSportsPersonServiceImpl implements XlglHomepageSportsPersonService {
	@Autowired
	private XlglHomepageSportsPersonDao xlglHomepageSportsPersonDao;
	
	@Override
	public XlglHomepageSportsPerson queryObject(String id){
		return xlglHomepageSportsPersonDao.queryObject(id);
	}
	
	@Override
	public List<XlglHomepageSportsPerson> queryList(Map<String, Object> map){
		return xlglHomepageSportsPersonDao.queryList(map);
	}
	
	@Override
	public void save(XlglHomepageSportsPerson xlglHomepageSportsPerson){
		xlglHomepageSportsPersonDao.save(xlglHomepageSportsPerson);
	}
	
	@Override
	public void update(XlglHomepageSportsPerson xlglHomepageSportsPerson){
		xlglHomepageSportsPersonDao.update(xlglHomepageSportsPerson);
	}
	
	@Override
	public void delete(String id){
		xlglHomepageSportsPersonDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		xlglHomepageSportsPersonDao.deleteBatch(ids);
	}
	
}
