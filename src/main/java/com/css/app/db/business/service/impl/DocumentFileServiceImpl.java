package com.css.app.db.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.css.app.db.business.dao.DocumentFileDao;
import com.css.app.db.business.entity.DocumentFile;
import com.css.app.db.business.service.DocumentFileService;



@Service("documentFileService")
public class DocumentFileServiceImpl implements DocumentFileService {
	@Autowired
	private DocumentFileDao documentFileDao;
	
	@Override
	public DocumentFile queryObject(String id){
		return documentFileDao.queryObject(id);
	}
	
	@Override
	public List<DocumentFile> queryList(Map<String, Object> map){
		return documentFileDao.queryList(map);
	}
	
	@Override
	public void save(DocumentFile dbDocumentFile){
		documentFileDao.save(dbDocumentFile);
	}
	
	@Override
	public void update(DocumentFile dbDocumentFile){
		documentFileDao.update(dbDocumentFile);
	}
	
	@Override
	public void delete(String id){
		documentFileDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		documentFileDao.deleteBatch(ids);
	}

	@Override
	public int queryMinSort(String docInfoId) {
		return documentFileDao.queryMinSort(docInfoId);
	}

	@Override
	public void deleteByInfoId(String infoId) {
		documentFileDao.deleteByInfoId(infoId);
		
	}
	
}
