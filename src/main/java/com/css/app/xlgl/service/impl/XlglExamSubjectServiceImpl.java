package com.css.app.xlgl.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.css.app.xlgl.dao.XlglExamSubjectDao;
import com.css.app.xlgl.entity.XlglExamSubject;
import com.css.app.xlgl.service.XlglExamSubjectService;




@Service("xlglExamSubjectService")
public class XlglExamSubjectServiceImpl implements XlglExamSubjectService {
	@Autowired
	private XlglExamSubjectDao xlglExamSubjectDao;
	
	@Override
	public XlglExamSubject queryObject(String id){
		return xlglExamSubjectDao.queryObject(id);
	}
	
	@Override
	public List<XlglExamSubject> queryList(Map<String, Object> map){
		return xlglExamSubjectDao.queryList(map);
	}
	
	@Override
	public void save(XlglExamSubject xlglExamSubject){
		xlglExamSubjectDao.save(xlglExamSubject);
	}
	
	@Override
	public void update(XlglExamSubject xlglExamSubject){
		xlglExamSubjectDao.update(xlglExamSubject);
	}
	
	@Override
	public void delete(String id){
		xlglExamSubjectDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		xlglExamSubjectDao.deleteBatch(ids);
	}

	@Override
	public List<XlglExamSubject> findList() {
		
		return xlglExamSubjectDao.findList();
	}
	
}
