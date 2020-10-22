package com.css.app.xlgl.config.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.css.app.xlgl.config.dao.XlglMsgRemindDao;
import com.css.app.xlgl.config.entity.XlglMsgRemind;
import com.css.app.xlgl.config.service.XlglMsgRemindService;



@Service("xlglMsgRemindService")
public class XlglMsgRemindServiceImpl implements XlglMsgRemindService {
	@Autowired
	private XlglMsgRemindDao xlglMsgRemindDao;
	
	@Override
	public XlglMsgRemind queryObject(String id){
		return xlglMsgRemindDao.queryObject(id);
	}
	
	@Override
	public List<XlglMsgRemind> queryList(Map<String, Object> map){
		return xlglMsgRemindDao.queryList(map);
	}
	
	@Override
	public void save(XlglMsgRemind xlglMsgRemind){
		xlglMsgRemindDao.save(xlglMsgRemind);
	}
	
	@Override
	public void update(XlglMsgRemind xlglMsgRemind){
		xlglMsgRemindDao.update(xlglMsgRemind);
	}
	
	@Override
	public void delete(String id){
		xlglMsgRemindDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		xlglMsgRemindDao.deleteBatch(ids);
	}
	
}
