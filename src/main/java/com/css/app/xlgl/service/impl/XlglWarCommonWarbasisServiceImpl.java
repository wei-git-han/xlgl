package com.css.app.xlgl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.css.app.xlgl.dao.XlglWarCommonWarbasisDao;
import com.css.app.xlgl.entity.XlglWarCommonWarbasis;
import com.css.app.xlgl.service.XlglWarCommonWarbasisService;



@Service("xlglWarCommonWarbasisService")
public class XlglWarCommonWarbasisServiceImpl implements XlglWarCommonWarbasisService {
	@Autowired
	private XlglWarCommonWarbasisDao xlglWarCommonWarbasisDao;
	
	@Override
	public XlglWarCommonWarbasis queryObject(String id){
		return xlglWarCommonWarbasisDao.queryObject(id);
	}
	
	@Override
	public List<XlglWarCommonWarbasis> queryList(Map<String, Object> map){
		return xlglWarCommonWarbasisDao.queryList(map);
	}
	
	@Override
	public void save(XlglWarCommonWarbasis xlglWarCommonWarbasis){
		xlglWarCommonWarbasisDao.save(xlglWarCommonWarbasis);
	}
	
	@Override
	public void update(XlglWarCommonWarbasis xlglWarCommonWarbasis){
		xlglWarCommonWarbasisDao.update(xlglWarCommonWarbasis);
	}
	
	@Override
	public void delete(String id){
		xlglWarCommonWarbasisDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		xlglWarCommonWarbasisDao.deleteBatch(ids);
	}
	
}
