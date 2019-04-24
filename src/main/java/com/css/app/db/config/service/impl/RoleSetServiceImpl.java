package com.css.app.db.config.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.css.app.db.config.dao.RoleSetDao;
import com.css.app.db.config.entity.RoleSet;
import com.css.app.db.config.service.RoleSetService;



@Service("roleSetService")
public class RoleSetServiceImpl implements RoleSetService {
	@Autowired
	private RoleSetDao roleSetDao;
	
	@Override
	public RoleSet queryObject(String id){
		return roleSetDao.queryObject(id);
	}
	
	@Override
	public List<RoleSet> queryList(Map<String, Object> map){
		return roleSetDao.queryList(map);
	}
	
	@Override
	public void save(RoleSet dbRoleSet){
		roleSetDao.save(dbRoleSet);
	}
	
	@Override
	public void update(RoleSet dbRoleSet){
		roleSetDao.update(dbRoleSet);
	}
	
	@Override
	public void delete(String id){
		roleSetDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		roleSetDao.deleteBatch(ids);
	}

	@Override
	public int deleteByUserId(String userId) {
		return roleSetDao.deleteByUserId(userId);
	}
	
}
