package com.css.app.xlgl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.css.app.xlgl.dao.XlglExamExamineMakeupDao;
import com.css.app.xlgl.entity.XlglExamExamineMakeup;
import com.css.app.xlgl.service.XlglExamExamineMakeupService;



@Service("xlglExamExamineMakeupService")
public class XlglExamExamineMakeupServiceImpl implements XlglExamExamineMakeupService {
	@Autowired
	private XlglExamExamineMakeupDao xlglExamExamineMakeupDao;
	
	@Override
	public XlglExamExamineMakeup queryObject(String id){
		return xlglExamExamineMakeupDao.queryObject(id);
	}
	
	@Override
	public List<XlglExamExamineMakeup> queryList(Map<String, Object> map){
		return xlglExamExamineMakeupDao.queryList(map);
	}
	
	@Override
	public void save(XlglExamExamineMakeup xlglExamExamineMakeup){
		xlglExamExamineMakeupDao.save(xlglExamExamineMakeup);
	}
	
	@Override
	public void update(XlglExamExamineMakeup xlglExamExamineMakeup){
		xlglExamExamineMakeupDao.update(xlglExamExamineMakeup);
	}
	
	@Override
	public void delete(String id){
		xlglExamExamineMakeupDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		xlglExamExamineMakeupDao.deleteBatch(ids);
	}
	
}
