package com.css.app.xlgl.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.css.app.xlgl.dao.XlglExamMainAnswerDao;
import com.css.app.xlgl.entity.XlglExamMainAnswer;
import com.css.app.xlgl.service.XlglExamMainAnswerService;




@Service("xlglExamMainAnswerService")
public class XlglExamMainAnswerServiceImpl implements XlglExamMainAnswerService {
	@Autowired
	private XlglExamMainAnswerDao xlglExamMainAnswerDao;
	
	@Override
	public XlglExamMainAnswer queryObject(String id){
		return xlglExamMainAnswerDao.queryObject(id);
	}
	
	@Override
	public List<XlglExamMainAnswer> queryList(Map<String, Object> map){
		return xlglExamMainAnswerDao.queryList(map);
	}
	
	@Override
	public void save(XlglExamMainAnswer xlglExamMainAnswer){
		xlglExamMainAnswerDao.save(xlglExamMainAnswer);
	}
	
	@Override
	public void update(XlglExamMainAnswer xlglExamMainAnswer){
		xlglExamMainAnswerDao.update(xlglExamMainAnswer);
	}
	
	@Override
	public void delete(String id){
		xlglExamMainAnswerDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		xlglExamMainAnswerDao.deleteBatch(ids);
	}

	@Override
	public void saveBatch(List<XlglExamMainAnswer> list) {
		xlglExamMainAnswerDao.saveBatch(list);
		
	}

	@Override
	public String queryUserCount(HashMap<String, Object> mapAll) {
		// TODO Auto-generated method stub
		return xlglExamMainAnswerDao.queryUserCount(mapAll);
	}

	@Override
	public int queryTotal(Map<String, Object> map) {	
		return xlglExamMainAnswerDao.queryTotal(map);
	}
	
}
