package com.css.app.db.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.css.app.db.business.dao.DocumentReadDao;
import com.css.app.db.business.entity.DocumentRead;
import com.css.app.db.business.service.DocumentReadService;



@Service("documentReadService")
public class DocumentReadServiceImpl implements DocumentReadService {
	@Autowired
	private DocumentReadDao documentReadDao;
	
	@Override
	public DocumentRead queryObject(String id){
		return documentReadDao.queryObject(id);
	}
	
	@Override
	public List<DocumentRead> queryList(Map<String, Object> map){
		return documentReadDao.queryList(map);
	}
	
	@Override
	public void save(DocumentRead dbDocumentRead){
		documentReadDao.save(dbDocumentRead);
	}
	
	@Override
	public void update(DocumentRead dbDocumentRead){
		documentReadDao.update(dbDocumentRead);
	}
	
	@Override
	public void delete(String id){
		documentReadDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		documentReadDao.deleteBatch(ids);
	}
	
}
