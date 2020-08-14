package com.css.app.xlgl.service.impl;

import com.css.app.xlgl.dao.XlglConfirmDao;
import com.css.app.xlgl.dto.XlglConfirmDto;
import com.css.app.xlgl.entity.XlglConfirm;
import com.css.app.xlgl.service.XlglConfirmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;




@Service("xlglConfirmService")
public class XlglConfirmServiceImpl implements XlglConfirmService {
	@Autowired
	private XlglConfirmDao xlglConfirmDao;
	
	@Override
	public XlglConfirm queryObject(String id){
		return xlglConfirmDao.queryObject(id);
	}
	
	@Override
	public List<XlglConfirm> queryList(Map<String, Object> map){
		return xlglConfirmDao.queryList(map);
	}
	
	@Override
	public void save(XlglConfirm xlglConfirm){
		xlglConfirmDao.save(xlglConfirm);
	}
	
	@Override
	public void update(XlglConfirm xlglConfirm){
		xlglConfirmDao.update(xlglConfirm);
	}
	
	@Override
	public void delete(String id){
		xlglConfirmDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		xlglConfirmDao.deleteBatch(ids);
	}

	@Override
	public XlglConfirmDto queryPerDeptInfo(Map<String,Object> map){
		return xlglConfirmDao.queryPerDeptInfo(map);
	}
	
}
