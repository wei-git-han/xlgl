package com.css.app.db.config.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.css.app.db.config.dao.DbExpDeedbackSetDao;
import com.css.app.db.config.entity.DbExpDeedbackSet;
import com.css.app.db.config.service.DbExpDeedbackSetService;



@Service("dbExpDeedbackSetService")
public class DbExpDeedbackSetServiceImpl implements DbExpDeedbackSetService {
	@Autowired
	private DbExpDeedbackSetDao dbExpDeedbackSetDao;
	
	@Override
	public DbExpDeedbackSet queryObject(String id){
		return dbExpDeedbackSetDao.queryObject(id);
	}
	
	@Override
	public List<DbExpDeedbackSet> queryList(Map<String, Object> map){
		return dbExpDeedbackSetDao.queryList(map);
	}
	
	@Override
	public List<DbExpDeedbackSet> queryListDefault(Map<String, Object> map){
		return dbExpDeedbackSetDao.queryListDefault(map);
	}
	
	@Override
	public void save(DbExpDeedbackSet dbExpDeedbackSet){
		dbExpDeedbackSetDao.save(dbExpDeedbackSet);
	}
	
	@Override
	public void update(DbExpDeedbackSet dbExpDeedbackSet){
		dbExpDeedbackSetDao.update(dbExpDeedbackSet);
	}
	
	@Override
	public void delete(String id){
		dbExpDeedbackSetDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		dbExpDeedbackSetDao.deleteBatch(ids);
	}
	
}
