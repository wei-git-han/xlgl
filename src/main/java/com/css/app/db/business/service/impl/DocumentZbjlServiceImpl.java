package com.css.app.db.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.css.app.db.business.dao.DocumentZbjlDao;
import com.css.app.db.business.entity.DocumentZbjl;
import com.css.app.db.business.service.DocumentZbjlService;



@Service("documentZbjlService")
public class DocumentZbjlServiceImpl implements DocumentZbjlService {
	@Autowired
	private DocumentZbjlDao documentZbjlDao;
	
	@Override
	public DocumentZbjl queryObject(String id){
		return documentZbjlDao.queryObject(id);
	}
	
	@Override
	public List<DocumentZbjl> queryList(Map<String, Object> map){
		return documentZbjlDao.queryList(map);
	}
	
	@Override
	public void save(DocumentZbjl dbDocumentZbjl){
		documentZbjlDao.save(dbDocumentZbjl);
	}
	
	@Override
	public void update(DocumentZbjl dbDocumentZbjl){
		documentZbjlDao.update(dbDocumentZbjl);
	}
	
	@Override
	public void delete(String id){
		documentZbjlDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		documentZbjlDao.deleteBatch(ids);
	}
	
}
