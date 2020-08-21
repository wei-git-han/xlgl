package com.css.app.xlgl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.css.app.xlgl.dao.XlglWarCommonWeaponDao;
import com.css.app.xlgl.entity.XlglWarCommonWeapon;
import com.css.app.xlgl.service.XlglWarCommonWeaponService;



@Service("xlglWarCommonWeaponService")
public class XlglWarCommonWeaponServiceImpl implements XlglWarCommonWeaponService {
	@Autowired
	private XlglWarCommonWeaponDao xlglWarCommonWeaponDao;
	
	@Override
	public XlglWarCommonWeapon queryObject(String id){
		return xlglWarCommonWeaponDao.queryObject(id);
	}
	
	@Override
	public List<XlglWarCommonWeapon> queryList(Map<String, Object> map){
		return xlglWarCommonWeaponDao.queryList(map);
	}
	
	@Override
	public void save(XlglWarCommonWeapon xlglWarCommonWeapon){
		xlglWarCommonWeaponDao.save(xlglWarCommonWeapon);
	}
	
	@Override
	public void update(XlglWarCommonWeapon xlglWarCommonWeapon){
		xlglWarCommonWeaponDao.update(xlglWarCommonWeapon);
	}
	
	@Override
	public void delete(String id){
		xlglWarCommonWeaponDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		xlglWarCommonWeaponDao.deleteBatch(ids);
	}
	
}
