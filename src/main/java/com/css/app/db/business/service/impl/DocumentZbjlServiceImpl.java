package com.css.app.db.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.css.app.db.business.dao.DocumentZbjlDao;
import com.css.app.db.business.entity.DocumentZbjl;
import com.css.app.db.business.service.DocumentZbjlService;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.UUIDUtils;



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
	public void save(DocumentZbjl zbjl){
		String loginUserId=CurrentUser.getUserId();
		String loginUserName=CurrentUser.getUsername();
		String loginUserDeptId=CurrentUser.getDepartmentId();
		String loginUserDeptName=CurrentUser.getOrgName();
		zbjl.setId(UUIDUtils.random());
		zbjl.setUserId(loginUserId);
		zbjl.setUserName(loginUserName);
		zbjl.setDeptId(loginUserDeptId);
		zbjl.setDeptName(loginUserDeptName);
		documentZbjlDao.save(zbjl);
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

	@Override
	public void deleteByInfoId(String infoId) {
		documentZbjlDao.deleteByInfoId(infoId);
		
	}

	@Override
	public void deleteBySubIdAndInfoId(String subId, String infoId) {
		documentZbjlDao.deleteBySubIdAndInfoId(subId, infoId);
		
	}

	@Override
	public DocumentZbjl queryBySubIdAndInfoId(String subId, String infoId) {
		return documentZbjlDao.queryBySubIdAndInfoId(subId, infoId);
		
	}
	
}
