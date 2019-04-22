package com.css.app.db.config.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.css.app.db.config.dao.AdminSetDao;
import com.css.app.db.config.entity.AdminSet;
import com.css.app.db.config.service.AdminSetService;



@Service("adminSetService")
public class AdminSetServiceImpl implements AdminSetService {
	@Autowired
	private AdminSetDao adminSetDao;
	
	@Override
	public AdminSet queryObject(String id){
		return adminSetDao.queryObject(id);
	}
	
	@Override
	public List<AdminSet> queryList(Map<String, Object> map){
		return adminSetDao.queryList(map);
	}
	
	@Override
	public void save(AdminSet dbAdminSet){
		adminSetDao.save(dbAdminSet);
	}
	
	@Override
	public void update(AdminSet dbAdminSet){
		adminSetDao.update(dbAdminSet);
	}
	
	@Override
	public void delete(String id){
		adminSetDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		adminSetDao.deleteBatch(ids);
	}
	
}
