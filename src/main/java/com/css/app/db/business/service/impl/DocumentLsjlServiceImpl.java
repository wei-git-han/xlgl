package com.css.app.db.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.css.app.db.business.dao.DocumentLsjlDao;
import com.css.app.db.business.entity.DocumentLsjl;
import com.css.app.db.business.service.DocumentLsjlService;



@Service("documentLsjlService")
public class DocumentLsjlServiceImpl implements DocumentLsjlService {
	@Autowired
	private DocumentLsjlDao documentLsjlDao;
	
	@Override
	public DocumentLsjl queryObject(String id){
		return documentLsjlDao.queryObject(id);
	}
	
	@Override
	public List<DocumentLsjl> queryList(Map<String, Object> map){
		return documentLsjlDao.queryList(map);
	}
	
	@Override
	public void save(DocumentLsjl dbDocumentLsjl){
		documentLsjlDao.save(dbDocumentLsjl);
	}
	
	@Override
	public void update(DocumentLsjl dbDocumentLsjl){
		documentLsjlDao.update(dbDocumentLsjl);
	}
	
	@Override
	public void delete(String id){
		documentLsjlDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		documentLsjlDao.deleteBatch(ids);
	}
	
}
