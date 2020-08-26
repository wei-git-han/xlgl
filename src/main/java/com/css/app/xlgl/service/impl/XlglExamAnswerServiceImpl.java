package com.css.app.xlgl.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.css.app.xlgl.dao.XlglExamAnswerDao;
import com.css.app.xlgl.entity.XlglExamAnswer;
import com.css.app.xlgl.service.XlglExamAnswerService;




@Service("xlglExamAnswerService")
public class XlglExamAnswerServiceImpl implements XlglExamAnswerService {
	@Autowired
	private XlglExamAnswerDao xlglExamAnswerDao;
	
	@Override
	public XlglExamAnswer queryObject(String id){
		return xlglExamAnswerDao.queryObject(id);
	}
	
	@Override
	public List<XlglExamAnswer> queryList(Map<String, Object> map){
		return xlglExamAnswerDao.queryList(map);
	}
	
	@Override
	public void save(XlglExamAnswer xlglExamAnswer){
		xlglExamAnswerDao.save(xlglExamAnswer);
	}
	
	@Override
	public void update(XlglExamAnswer xlglExamAnswer){
		xlglExamAnswerDao.update(xlglExamAnswer);
	}
	
	@Override
	public void delete(String id){
		xlglExamAnswerDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		xlglExamAnswerDao.deleteBatch(ids);
	}

	@Override
	public void saveBatch(List<XlglExamAnswer> list) {
		xlglExamAnswerDao.saveBatch(list);
		
	}

	@Override
	public int queryCorrectStatus(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return xlglExamAnswerDao.queryCorrectStatus(map);
	}
	
}
