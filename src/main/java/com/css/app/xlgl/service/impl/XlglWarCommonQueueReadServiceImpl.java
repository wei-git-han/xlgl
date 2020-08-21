package com.css.app.xlgl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.css.app.xlgl.dao.XlglWarCommonQueueReadDao;
import com.css.app.xlgl.entity.XlglWarCommonQueueRead;
import com.css.app.xlgl.service.XlglWarCommonQueueReadService;



@Service("xlglWarCommonQueueReadService")
public class XlglWarCommonQueueReadServiceImpl implements XlglWarCommonQueueReadService {
	@Autowired
	private XlglWarCommonQueueReadDao xlglWarCommonQueueReadDao;
	
	@Override
	public XlglWarCommonQueueRead queryObject(String id){
		return xlglWarCommonQueueReadDao.queryObject(id);
	}
	
	@Override
	public List<XlglWarCommonQueueRead> queryList(Map<String, Object> map){
		return xlglWarCommonQueueReadDao.queryList(map);
	}
	
	@Override
	public void save(XlglWarCommonQueueRead xlglWarCommonQueueRead){
		xlglWarCommonQueueReadDao.save(xlglWarCommonQueueRead);
	}
	
	@Override
	public void update(XlglWarCommonQueueRead xlglWarCommonQueueRead){
		xlglWarCommonQueueReadDao.update(xlglWarCommonQueueRead);
	}
	
	@Override
	public void delete(String id){
		xlglWarCommonQueueReadDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		xlglWarCommonQueueReadDao.deleteBatch(ids);
	}
	
}
