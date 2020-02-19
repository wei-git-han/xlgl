package com.css.app.db.config.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.css.app.db.config.dao.RemindAdministrationDao;
import com.css.app.db.config.entity.RemindAdministration;
import com.css.app.db.config.service.RemindAdministrationService;



@Service("remindAdministrationService")
public class RemindAdministrationServiceImpl implements RemindAdministrationService {
	@Autowired
	private RemindAdministrationDao remindAdministrationDao;
	
	@Override
	public RemindAdministration queryObject(String id){
		return remindAdministrationDao.queryObject(id);
	}
	
	@Override
	public List<RemindAdministration> queryList(Map<String, Object> map){
		return remindAdministrationDao.queryList(map);
	}
	
	@Override
	public void save(RemindAdministration remindAdministration){
		remindAdministrationDao.save(remindAdministration);
	}
	
	@Override
	public void update(RemindAdministration remindAdministration){
		remindAdministrationDao.update(remindAdministration);
	}
	
	@Override
	public void delete(String id){
		remindAdministrationDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		remindAdministrationDao.deleteBatch(ids);
	}
	
}
