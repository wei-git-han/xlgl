package com.css.app.xlgl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.css.app.xlgl.dao.DocumentMenuDao;
import com.css.app.xlgl.entity.DocumentMenu;
import com.css.app.xlgl.service.DocumentMenuService;

import java.util.List;
import java.util.Map;




@Service("documentMenuService")
public class DocumentMenuServiceImpl implements DocumentMenuService {
	@Autowired
	private DocumentMenuDao documentMenuDao;
	
	@Override
	public DocumentMenu queryObject(String id){
		return documentMenuDao.queryObject(id);
	}
	
	@Override
	public List<DocumentMenu> queryList(Map<String, Object> map){
		return documentMenuDao.queryList(map);
	}
	
	@Override
	public void save(DocumentMenu documentMenu){
		documentMenuDao.save(documentMenu);
	}
	
	@Override
	public void update(DocumentMenu documentMenu){
		documentMenuDao.update(documentMenu);
	}
	
	@Override
	public void delete(String id){
		documentMenuDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		documentMenuDao.deleteBatch(ids);
	}
	
}
