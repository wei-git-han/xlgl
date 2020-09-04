package com.css.app.xlgl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.css.app.xlgl.dao.DocumentMenuPermissionDao;
import com.css.app.xlgl.entity.DocumentMenuPermission;
import com.css.app.xlgl.service.DocumentMenuPermissionService;

import java.util.List;
import java.util.Map;




@Service("documentMenuPermissionService")
public class DocumentMenuPermissionServiceImpl implements DocumentMenuPermissionService {
	@Autowired
	private DocumentMenuPermissionDao documentMenuPermissionDao;
	
	@Override
	public DocumentMenuPermission queryObject(String id){
		return documentMenuPermissionDao.queryObject(id);
	}
	
	@Override
	public List<DocumentMenuPermission> queryList(Map<String, Object> map){
		return documentMenuPermissionDao.queryList(map);
	}
	
	@Override
	public void save(DocumentMenuPermission documentMenuPermission){
		documentMenuPermissionDao.save(documentMenuPermission);
	}
	
	@Override
	public void update(DocumentMenuPermission documentMenuPermission){
		documentMenuPermissionDao.update(documentMenuPermission);
	}
	
	@Override
	public void delete(String id){
		documentMenuPermissionDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		documentMenuPermissionDao.deleteBatch(ids);
	}
	
	@Override
	public void deleteByUserId(String uid){
		documentMenuPermissionDao.deleteByUserId(uid);
	}

	@Override
	public List<String> queryAllList(String userId){
		return documentMenuPermissionDao.queryAllList(userId);
	}
	
}
