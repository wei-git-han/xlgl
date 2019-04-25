package com.css.app.db.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.css.app.db.business.dao.OpinionAttacDao;
import com.css.app.db.business.entity.OpinionAttac;
import com.css.app.db.business.service.OpinionAttacService;



@Service("opinionAttacService")
public class OpinionAttacServiceImpl implements OpinionAttacService {
	@Autowired
	private OpinionAttacDao opinionAttacDao;
	
	@Override
	public OpinionAttac queryObject(String id){
		return opinionAttacDao.queryObject(id);
	}
	
	@Override
	public List<OpinionAttac> queryList(Map<String, Object> map){
		return opinionAttacDao.queryList(map);
	}
	
	@Override
	public void save(OpinionAttac dbOpinionAttac){
		opinionAttacDao.save(dbOpinionAttac);
	}
	
	@Override
	public void update(OpinionAttac dbOpinionAttac){
		opinionAttacDao.update(dbOpinionAttac);
	}
	
	@Override
	public void delete(String id){
		opinionAttacDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		opinionAttacDao.deleteBatch(ids);
	}
	
}
