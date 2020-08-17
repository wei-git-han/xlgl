package com.css.app.xlgl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.css.app.xlgl.dao.XlglWarTacticReadDao;
import com.css.app.xlgl.entity.XlglWarTacticRead;
import com.css.app.xlgl.service.XlglWarTacticReadService;



@Service("xlglWarTacticReadService")
public class XlglWarTacticReadServiceImpl implements XlglWarTacticReadService {
	@Autowired
	private XlglWarTacticReadDao xlglWarTacticReadDao;
	
	@Override
	public XlglWarTacticRead queryObject(String id){
		return xlglWarTacticReadDao.queryObject(id);
	}
	
	@Override
	public List<XlglWarTacticRead> queryList(Map<String, Object> map){
		return xlglWarTacticReadDao.queryList(map);
	}
	
	@Override
	public void save(XlglWarTacticRead xlglWarTacticRead){
		xlglWarTacticReadDao.save(xlglWarTacticRead);
	}
	
	@Override
	public void update(XlglWarTacticRead xlglWarTacticRead){
		xlglWarTacticReadDao.update(xlglWarTacticRead);
	}
	
	@Override
	public void delete(String id){
		xlglWarTacticReadDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		xlglWarTacticReadDao.deleteBatch(ids);
	}
	
}
