package com.css.app.db.config.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.css.app.db.config.dao.DocumentDicDao;
import com.css.app.db.config.entity.DocumentDic;
import com.css.app.db.config.service.DocumentDicService;



@Service("documentDicService")
public class DocumentDicServiceImpl implements DocumentDicService {
	@Autowired
	private DocumentDicDao documentDicDao;
	
	@Override
	public DocumentDic queryObject(String id){
		return documentDicDao.queryObject(id);
	}
	
	@Override
	public List<DocumentDic> queryList(Map<String, Object> map){
		return documentDicDao.queryList(map);
	}
	
	@Override
	public void save(DocumentDic dbDocumentDic){
		documentDicDao.save(dbDocumentDic);
	}
	
	@Override
	public void update(DocumentDic dbDocumentDic){
		documentDicDao.update(dbDocumentDic);
	}
	
	@Override
	public void delete(String id){
		documentDicDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		documentDicDao.deleteBatch(ids);
	}

	@Override
	public List<DocumentDic> queryDicByType(String dicType) {
		return documentDicDao.queryDicByType(dicType);
	}
	
}
