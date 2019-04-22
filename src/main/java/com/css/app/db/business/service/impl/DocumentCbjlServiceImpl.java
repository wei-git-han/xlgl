package com.css.app.db.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.css.app.db.business.dao.DocumentCbjlDao;
import com.css.app.db.business.entity.DocumentCbjl;
import com.css.app.db.business.service.DocumentCbjlService;



@Service("documentCbjlService")
public class DocumentCbjlServiceImpl implements DocumentCbjlService {
	@Autowired
	private DocumentCbjlDao documentCbjlDao;
	
	@Override
	public DocumentCbjl queryObject(String id){
		return documentCbjlDao.queryObject(id);
	}
	
	@Override
	public List<DocumentCbjl> queryList(Map<String, Object> map){
		return documentCbjlDao.queryList(map);
	}
	
	@Override
	public void save(DocumentCbjl dbDocumentCbjl){
		documentCbjlDao.save(dbDocumentCbjl);
	}
	
	@Override
	public void update(DocumentCbjl dbDocumentCbjl){
		documentCbjlDao.update(dbDocumentCbjl);
	}
	
	@Override
	public void delete(String id){
		documentCbjlDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		documentCbjlDao.deleteBatch(ids);
	}
	
}
