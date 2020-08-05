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

	@Override
	public int selYtxsCount(String age, String ytxscount) {
		return somatoTzDao.selYtxsCount(age,ytxscount);
	}

	@Override
	public int selQbxcCount(String age, String qbxcCount) {
		return somatoTzDao.selQbxcCount(age,qbxcCount);
	}

	@Override
	public int selYwqzCount(String age, String sex, String ywqzcount) {
		return somatoTzDao.selYwqzCount(age,sex,ywqzcount);
	}

	@Override
	public int selSrunCount(String age, String sex, String sruncount) {
		return somatoTzDao.selSrunCount(age,sex,sruncount);
	}

	@Override
	public int selTsruncount(String age, String sex, String tsruncount) {
		return somatoTzDao.selTsruncount(age,sex,tsruncount);
	}

	
}
