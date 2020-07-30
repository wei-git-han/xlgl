package com.css.app.xlgl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.css.app.xlgl.dao.XlglDocumentFileDao;
import com.css.app.xlgl.entity.XlglDocumentFile;
import com.css.app.xlgl.service.XlglDocumentFileService;

import java.util.List;
import java.util.Map;




@Service("xlglDocumentFileService")
public class XlglDocumentFileServiceImpl implements XlglDocumentFileService {
	@Autowired
	private XlglDocumentFileDao xlglDocumentFileDao;
	
	@Override
	public XlglDocumentFile queryObject(String id){
		return xlglDocumentFileDao.queryObject(id);
	}
	
	@Override
	public List<XlglDocumentFile> queryList(Map<String, Object> map){
		return xlglDocumentFileDao.queryList(map);
	}
	
	@Override
	public void save(XlglDocumentFile xlglDocumentFile){
		xlglDocumentFileDao.save(xlglDocumentFile);
	}
	
	@Override
	public void update(XlglDocumentFile xlglDocumentFile){
		xlglDocumentFileDao.update(xlglDocumentFile);
	}
	
	@Override
	public void delete(String id){
		xlglDocumentFileDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		xlglDocumentFileDao.deleteBatch(ids);
	}
	
	@Override
	public int queryMinSort(String docInfoId) {
		return xlglDocumentFileDao.queryMinSort(docInfoId);
	}
	
}
