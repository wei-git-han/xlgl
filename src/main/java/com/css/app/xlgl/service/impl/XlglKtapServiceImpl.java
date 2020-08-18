package com.css.app.xlgl.service.impl;

import com.css.app.xlgl.dao.XlglKtapDao;
import com.css.app.xlgl.entity.XlglKtap;
import com.css.app.xlgl.service.XlglKtapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service("xlglKtapService")
public class XlglKtapServiceImpl implements XlglKtapService {
	@Autowired
	private XlglKtapDao xlglKtapDao;
	
	@Override
	public XlglKtap queryObject(String id){
		return xlglKtapDao.queryObject(id);
	}
	
	@Override
	public List<XlglKtap> queryList(Map<String, Object> map){
		return xlglKtapDao.queryList(map);
	}
	
	@Override
	public void save(XlglKtap xlglKtap){
		xlglKtapDao.save(xlglKtap);
	}
	
	@Override
	public void update(XlglKtap xlglKtap){
		xlglKtapDao.update(xlglKtap);
	}
	
	@Override
	public void delete(String id){
		xlglKtapDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		xlglKtapDao.deleteBatch(ids);
	}
	
}
