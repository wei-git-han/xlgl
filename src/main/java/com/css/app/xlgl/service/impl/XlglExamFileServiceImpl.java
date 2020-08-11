package com.css.app.xlgl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.css.app.xlgl.dao.XlglExamFileDao;
import com.css.app.xlgl.entity.XlglExamFile;
import com.css.app.xlgl.service.XlglExamFileService;



@Service("xlglExamFileService")
public class XlglExamFileServiceImpl implements XlglExamFileService {
	@Autowired
	private XlglExamFileDao xlglExamFileDao;
	
	@Override
	public XlglExamFile queryObject(String id){
		return xlglExamFileDao.queryObject(id);
	}
	
	@Override
	public List<XlglExamFile> queryList(Map<String, Object> map){
		return xlglExamFileDao.queryList(map);
	}
	
	@Override
	public void save(XlglExamFile xlglExamFile){
		xlglExamFileDao.save(xlglExamFile);
	}
	
	@Override
	public void update(XlglExamFile xlglExamFile){
		xlglExamFileDao.update(xlglExamFile);
	}
	
	@Override
	public void delete(String id){
		xlglExamFileDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		xlglExamFileDao.deleteBatch(ids);
	}
	
}
