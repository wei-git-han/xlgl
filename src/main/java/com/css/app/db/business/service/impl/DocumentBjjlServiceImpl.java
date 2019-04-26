package com.css.app.db.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.css.app.db.business.dao.DocumentBjjlDao;
import com.css.app.db.business.entity.DocumentBjjl;
import com.css.app.db.business.service.DocumentBjjlService;



@Service("documentBjjlService")
public class DocumentBjjlServiceImpl implements DocumentBjjlService {
	@Autowired
	private DocumentBjjlDao documentBjjlDao;
	
	@Override
	public DocumentBjjl queryObject(String id){
		return documentBjjlDao.queryObject(id);
	}
	
	@Override
	public List<DocumentBjjl> queryList(Map<String, Object> map){
		return documentBjjlDao.queryList(map);
	}
	
	@Override
	public void save(DocumentBjjl dbDocumentBjjl){
		documentBjjlDao.save(dbDocumentBjjl);
	}
	
	@Override
	public void update(DocumentBjjl dbDocumentBjjl){
		documentBjjlDao.update(dbDocumentBjjl);
	}
	
	@Override
	public void delete(String id){
		documentBjjlDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		documentBjjlDao.deleteBatch(ids);
	}
	
}
