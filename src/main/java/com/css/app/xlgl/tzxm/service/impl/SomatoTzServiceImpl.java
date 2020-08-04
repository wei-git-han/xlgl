package com.css.app.xlgl.tzxm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.css.app.xlgl.tzxm.dao.SomatoTzDao;
import com.css.app.xlgl.tzxm.entity.SoldierTz;
import com.css.app.xlgl.tzxm.service.SomatoTzService;

@Service
public class SomatoTzServiceImpl implements SomatoTzService {
	
	@Autowired
	private SomatoTzDao somatoTzDao;

	@Override
	public SoldierTz selectBMI(Float height, Float weight, String sex,int age) {
		return somatoTzDao.selectBMI(height,weight,sex,age);
	}

	
}
