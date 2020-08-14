package com.css.app.xlgl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.css.app.xlgl.dao.XlglWarCommonQueueDao;
import com.css.app.xlgl.entity.XlglWarCommonQueue;
import com.css.app.xlgl.service.XlglWarCommonQueueService;



@Service("xlglWarCommonQueueService")
public class XlglWarCommonQueueServiceImpl implements XlglWarCommonQueueService {
	@Autowired
	private XlglWarCommonQueueDao xlglWarCommonQueueDao;
	
	@Override
	public XlglWarCommonQueue queryObject(String id){
		return xlglWarCommonQueueDao.queryObject(id);
	}
	
	@Override
	public List<XlglWarCommonQueue> queryList(Map<String, Object> map){
		return xlglWarCommonQueueDao.queryList(map);
	}
	
	@Override
	public void save(XlglWarCommonQueue xlglWarCommonQueue){
		xlglWarCommonQueueDao.save(xlglWarCommonQueue);
	}
	
	@Override
	public void update(XlglWarCommonQueue xlglWarCommonQueue){
		xlglWarCommonQueueDao.update(xlglWarCommonQueue);
	}
	
	@Override
	public void delete(String id){
		xlglWarCommonQueueDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		xlglWarCommonQueueDao.deleteBatch(ids);
	}
	
}
