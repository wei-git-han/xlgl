package com.css.app.xlgl.service.impl;

import com.css.app.xlgl.dao.XlglHomepageSportsReadDao;
import com.css.app.xlgl.entity.XlglHomepageSportsRead;
import com.css.app.xlgl.service.XlglHomepageSportsReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import java.util.List;
import java.util.Map;

@Service("xlglHomepageSportsReadService")
public class XlglHomepageSportsReadServiceImpl implements XlglHomepageSportsReadService {
	@Autowired
	private XlglHomepageSportsReadDao xlglHomepageSportsReadDao;
	
	@Override
	public XlglHomepageSportsRead queryObject(String id){
		return xlglHomepageSportsReadDao.queryObject(id);
	}
	
	@Override
	public List<XlglHomepageSportsRead> queryList(Map<String, Object> map){
		return xlglHomepageSportsReadDao.queryList(map);
	}
	
	@Override
	public void save(XlglHomepageSportsRead xlglHomepageSportsRead){
		xlglHomepageSportsReadDao.save(xlglHomepageSportsRead);
	}
	
	@Override
	public void update(XlglHomepageSportsRead xlglHomepageSportsRead){
		xlglHomepageSportsReadDao.update(xlglHomepageSportsRead);
	}
	
	@Override
	public void delete(String id){
		xlglHomepageSportsReadDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		xlglHomepageSportsReadDao.deleteBatch(ids);
	}

	@Override
	public XlglHomepageSportsRead queryBySportAndUserId(String sportId, String userId){
		return xlglHomepageSportsReadDao.queryBySportAndUserId(sportId,userId);
	}

	@Override
	public void deleteBySportId(String sportId){
		xlglHomepageSportsReadDao.deleteBySportId(sportId);
	}


	
}
