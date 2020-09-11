package com.css.app.xlgl.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.css.app.xlgl.dao.XlglNewsDao;
import com.css.app.xlgl.entity.XlglNews;
import com.css.app.xlgl.service.XlglNewsService;



@Service("xlglNewsService")
public class XlglNewsServiceImpl implements XlglNewsService {
	
	@Autowired
	private XlglNewsDao xlglNewsDao;
	
	@Override
	public XlglNews queryObject(String id) {
		// TODO Auto-generated method stub
		return xlglNewsDao.queryObject(id);
	}

	@Override
	public List<XlglNews> queryList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return xlglNewsDao.queryList(map);
	}

	@Override
	public void save(XlglNews xlglNews) {
		// TODO Auto-generated method stub
		xlglNewsDao.save(xlglNews);
	}

	@Override
	public void update(XlglNews xlglNews) {
		// TODO Auto-generated method stub
		xlglNewsDao.update(xlglNews);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		xlglNewsDao.delete(id);
	}

	@Override
	public void deleteBatch(String[] ids) {
		// TODO Auto-generated method stub
		xlglNewsDao.deleteBatch(ids);
	}

	@Override
	public int queryTotalYear() {
		// TODO Auto-generated method stub
		return xlglNewsDao.queryTotalYear();
	}

	@Override
	public int queryTotalMonth() {
		// TODO Auto-generated method stub
		return xlglNewsDao.queryTotalMonth();
	}

	@Override
	public int queryTotalWeek() {
		// TODO Auto-generated method stub
		return xlglNewsDao.queryTotalWeek();
	}

	

	@Override
	public XlglNews queryNowTop() {
		// TODO Auto-generated method stub
		return xlglNewsDao.queryNowTop();
	}

	@Override
	public List<LinkedHashMap<String, Integer>> queryTotalYearByOrgan() {
		// TODO Auto-generated method stub
		return xlglNewsDao.queryTotalYearByOrgan();
	}

	@Override
	public List<LinkedHashMap<String, Integer>> queryTotalMonthByOrgan() {
		// TODO Auto-generated method stub
		return xlglNewsDao.queryTotalMonthByOrgan();
	}

	@Override
	public List<LinkedHashMap<String, Integer>> queryTotalWeekByOrgan() {
		// TODO Auto-generated method stub
		return xlglNewsDao.queryTotalWeekByOrgan();
	}

	@Override
	public List<XlglNews> queryDrafts(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return xlglNewsDao.queryDrafts(map);
	}

	@Override
	public List<XlglNews> querySort(Map<String,Object> map){
		return xlglNewsDao.querySort(map);
	}

}
