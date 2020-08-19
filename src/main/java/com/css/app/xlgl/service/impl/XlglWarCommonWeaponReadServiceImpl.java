package com.css.app.xlgl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.css.app.xlgl.dao.XlglWarCommonWeaponReadDao;
import com.css.app.xlgl.entity.XlglWarCommonWeaponRead;
import com.css.app.xlgl.service.XlglWarCommonWeaponReadService;



@Service("xlglWarCommonWeaponReadService")
public class XlglWarCommonWeaponReadServiceImpl implements XlglWarCommonWeaponReadService {
	@Autowired
	private XlglWarCommonWeaponReadDao xlglWarCommonWeaponReadDao;
	
	@Override
	public XlglWarCommonWeaponRead queryObject(String id){
		return xlglWarCommonWeaponReadDao.queryObject(id);
	}
	
	@Override
	public List<XlglWarCommonWeaponRead> queryList(Map<String, Object> map){
		return xlglWarCommonWeaponReadDao.queryList(map);
	}
	
	@Override
	public void save(XlglWarCommonWeaponRead xlglWarCommonWeaponRead){
		xlglWarCommonWeaponReadDao.save(xlglWarCommonWeaponRead);
	}
	
	@Override
	public void update(XlglWarCommonWeaponRead xlglWarCommonWeaponRead){
		xlglWarCommonWeaponReadDao.update(xlglWarCommonWeaponRead);
	}
	
	@Override
	public void delete(String id){
		xlglWarCommonWeaponReadDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		xlglWarCommonWeaponReadDao.deleteBatch(ids);
	}
	
}
