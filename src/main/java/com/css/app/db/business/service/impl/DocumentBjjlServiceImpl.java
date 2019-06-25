package com.css.app.db.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.css.app.db.business.dao.DocumentBjjlDao;
import com.css.app.db.business.entity.DocumentBjjl;
import com.css.app.db.business.service.DocumentBjjlService;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.UUIDUtils;



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
	public void save(DocumentBjjl bjjl){
		String loginUserDeptId=CurrentUser.getDepartmentId();
		String loginUserId=CurrentUser.getUserId();
		String loginUserName=CurrentUser.getUsername();
		String loginUserDeptName=CurrentUser.getOrgName();
		bjjl.setId(UUIDUtils.random());
		bjjl.setUserId(loginUserId);
		bjjl.setUserName(loginUserName);
		bjjl.setDeptId(loginUserDeptId);
		bjjl.setDeptName(loginUserDeptName);
		bjjl.setCreatedTime(new Date());
		documentBjjlDao.save(bjjl);
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

	@Override
	public DocumentBjjl queryLatestBjjl(String infoId) {
		return documentBjjlDao.queryLatestBjjl(infoId);
	}

	@Override
	public void deleteByInfoId(String infoId) {
		documentBjjlDao.deleteByInfoId(infoId);
		
	}

	@Override
	public DocumentBjjl queryBjjlBySubId(String id) {
		return documentBjjlDao.queryBjjlBySubId(id);
	}
	
}
