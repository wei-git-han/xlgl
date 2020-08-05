package com.css.app.xlgl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.css.app.xlgl.dao.TGroupApplyRecordDao;
import com.css.app.xlgl.entity.TGroupApplyRecord;
import com.css.app.xlgl.service.TGroupApplyRecordService;



@Service("tGroupApplyRecordService")
public class TGroupApplyRecordServiceImpl implements TGroupApplyRecordService {
	@Autowired
	private TGroupApplyRecordDao tGroupApplyRecordDao;
	
	@Override
	public TGroupApplyRecord queryObject(String id){
		return tGroupApplyRecordDao.queryObject(id);
	}
	
	@Override
	public List<TGroupApplyRecord> queryList(Map<String, Object> map){
		return tGroupApplyRecordDao.queryList(map);
	}
	
	@Override
	public void save(TGroupApplyRecord tGroupApplyRecord){
		tGroupApplyRecordDao.save(tGroupApplyRecord);
	}
	
	@Override
	public void update(TGroupApplyRecord tGroupApplyRecord){
		tGroupApplyRecordDao.update(tGroupApplyRecord);
	}
	
	@Override
	public void delete(String id){
		tGroupApplyRecordDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		tGroupApplyRecordDao.deleteBatch(ids);
	}
	
}
