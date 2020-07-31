package com.css.app.xlgl.sportstrain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.css.app.xlgl.sportstrain.dao.TGroupActivePublishDao;
import com.css.app.xlgl.sportstrain.entity.TGroupActivePublish;
import com.css.app.xlgl.sportstrain.service.TGroupActivePublishService;



@Service("tGroupActivePublishService")
public class TGroupActivePublishServiceImpl implements TGroupActivePublishService {
	@Autowired
	private TGroupActivePublishDao tGroupActivePublishDao;
	
	@Override
	public TGroupActivePublish queryObject(String actId){
		return tGroupActivePublishDao.queryObject(actId);
	}
	
	@Override
	public List<TGroupActivePublish> queryList(Map<String, Object> map){
		return tGroupActivePublishDao.queryList(map);
	}
	
	@Override
	public void save(TGroupActivePublish tGroupActivePublish){
		tGroupActivePublishDao.save(tGroupActivePublish);
	}
	
	@Override
	public void update(TGroupActivePublish tGroupActivePublish){
		tGroupActivePublishDao.update(tGroupActivePublish);
	}
	
	@Override
	public void delete(String actId){
		tGroupActivePublishDao.delete(actId);
	}
	
	@Override
	public void deleteBatch(String[] actIds){
		tGroupActivePublishDao.deleteBatch(actIds);
	}
	
}
