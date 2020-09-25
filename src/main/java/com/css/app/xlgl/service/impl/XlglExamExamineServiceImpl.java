package com.css.app.xlgl.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.css.app.xlgl.dao.XlglExamExamineDao;
import com.css.app.xlgl.entity.XlglExamExamine;
import com.css.app.xlgl.service.XlglExamExamineService;




@Service("xlglExamExamineService")
public class XlglExamExamineServiceImpl implements XlglExamExamineService {
	@Autowired
	private XlglExamExamineDao xlglExamExamineDao;
	
	@Override
	public XlglExamExamine queryObject(String id){
		return xlglExamExamineDao.queryObject(id);
	}
	
	@Override
	public List<XlglExamExamine> queryList(Map<String, Object> map){
		return xlglExamExamineDao.queryList(map);
	}
	
	@Override
	public void save(XlglExamExamine xlglExamExamine){
		xlglExamExamineDao.save(xlglExamExamine);
	}
	
	@Override
	public void update(XlglExamExamine xlglExamExamine){
		xlglExamExamineDao.update(xlglExamExamine);
	}
	
	@Override
	public void delete(String id){
		xlglExamExamineDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		xlglExamExamineDao.deleteBatch(ids);
	}

	@Override
	public int findCount() {
		return xlglExamExamineDao.findCount();
	}

	@Override
	public List<XlglExamExamine> queryVerifyList(Map<String, Object> map) {
		return xlglExamExamineDao.queryVerifyList(map);
	}
	
}
