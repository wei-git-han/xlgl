package com.css.app.db.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.css.app.db.business.dao.DocumentLsjlDao;
import com.css.app.db.business.entity.DocumentLsjl;
import com.css.app.db.business.service.DocumentLsjlService;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.UUIDUtils;



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
	public void save(DocumentLsjl lsjl){
		String loginUserDeptId=CurrentUser.getDepartmentId();
		String loginUserId=CurrentUser.getUserId();
		String loginUserName=CurrentUser.getUsername();
		String loginUserDeptName=CurrentUser.getOrgName();
		lsjl.setId(UUIDUtils.random());
		lsjl.setUserId(loginUserId);
		lsjl.setUserName(loginUserName);
		lsjl.setDeptId(loginUserDeptId);
		lsjl.setDeptName(loginUserDeptName);
		lsjl.setCreatedTime(new Date());
		documentLsjlDao.save(lsjl);
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

	@Override
	public DocumentLsjl queryLatestLsjl(String infoId) {
		return documentLsjlDao.queryLatestLsjl(infoId);
	}
	
}
