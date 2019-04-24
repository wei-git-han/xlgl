package com.css.app.db.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.css.app.db.business.dao.DocumentInfoDao;
import com.css.app.db.business.entity.DocumentInfo;
import com.css.app.db.business.service.DocumentInfoService;



@Service("documentInfoService")
public class DocumentInfoServiceImpl implements DocumentInfoService {
	@Autowired
	private DocumentInfoDao documentInfoDao;
	
	@Override
	public DocumentInfo queryObject(String id){
		return documentInfoDao.queryObject(id);
	}
	
	@Override
	public List<DocumentInfo> queryList(Map<String, Object> map){
		return documentInfoDao.queryList(map);
	}
	
	@Override
	public void save(DocumentInfo dbDocumentInfo){
		documentInfoDao.save(dbDocumentInfo);
	}
	
	@Override
	public void update(DocumentInfo dbDocumentInfo){
		documentInfoDao.update(dbDocumentInfo);
	}
	
	@Override
	public void delete(String id){
		documentInfoDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		documentInfoDao.deleteBatch(ids);
	}

	@Override
	public List<Map<String, Object>> queryListByYear(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return documentInfoDao.queryListByYear(map);
	}

	@Override
	public List<Map<String, Object>> queryListByOrgYear(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return documentInfoDao.queryListByOrgYear(map);
	}

	@Override
	public List<Map<String, Object>> queryListByDicType(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return documentInfoDao.queryListByDicType(map);
	}

	@Override
	public List<Map<String, Object>> queryListByDicStu(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return documentInfoDao.queryListByDicStu(map);
	}
	
}
