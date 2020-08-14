package com.css.app.xlgl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.css.app.xlgl.dao.XlglWarTacticDao;
import com.css.app.xlgl.entity.XlglWarTactic;
import com.css.app.xlgl.service.XlglWarTacticService;



@Service("xlglWarTacticService")
public class XlglWarTacticServiceImpl implements XlglWarTacticService {
	@Autowired
	private XlglWarTacticDao xlglWarTacticDao;
	
	@Override
	public XlglWarTactic queryObject(String id){
		return xlglWarTacticDao.queryObject(id);
	}
	
	@Override
	public List<XlglWarTactic> queryList(Map<String, Object> map){
		return xlglWarTacticDao.queryList(map);
	}
	
	@Override
	public void save(XlglWarTactic xlglWarTactic){
		xlglWarTacticDao.save(xlglWarTactic);
	}
	
	@Override
	public void update(XlglWarTactic xlglWarTactic){
		xlglWarTacticDao.update(xlglWarTactic);
	}
	
	@Override
	public void delete(String id){
		xlglWarTacticDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		xlglWarTacticDao.deleteBatch(ids);
	}
	
}
