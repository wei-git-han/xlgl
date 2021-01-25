package com.css.app.xlgl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.css.app.xlgl.dao.BaseAppOrgPeoplemanagementDao;
import com.css.app.xlgl.entity.BaseAppOrgPeoplemanagement;
import com.css.app.xlgl.service.BaseAppOrgPeoplemanagementService;



@Service("baseAppOrgPeoplemanagementService")
public class BaseAppOrgPeoplemanagementServiceImpl implements BaseAppOrgPeoplemanagementService {
	@Autowired
	private BaseAppOrgPeoplemanagementDao baseAppOrgPeoplemanagementDao;
	
	@Override
	public BaseAppOrgPeoplemanagement queryObject(String answerReignNumber){
		return baseAppOrgPeoplemanagementDao.queryObject(answerReignNumber);
	}
	
	@Override
	public List<BaseAppOrgPeoplemanagement> queryList(Map<String, Object> map){
		return baseAppOrgPeoplemanagementDao.queryList(map);
	}
	
	@Override
	public void save(BaseAppOrgPeoplemanagement baseAppOrgPeoplemanagement){
		baseAppOrgPeoplemanagementDao.save(baseAppOrgPeoplemanagement);
	}
	
	@Override
	public void update(BaseAppOrgPeoplemanagement baseAppOrgPeoplemanagement){
		baseAppOrgPeoplemanagementDao.update(baseAppOrgPeoplemanagement);
	}
	
	@Override
	public void delete(Integer answerReignNumber){
		baseAppOrgPeoplemanagementDao.delete(answerReignNumber);
	}
	
	@Override
	public void deleteBatch(Integer[] answerReignNumbers){
		baseAppOrgPeoplemanagementDao.deleteBatch(answerReignNumbers);
	}
	
}
