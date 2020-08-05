package com.css.app.xlgl.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.css.app.xlgl.dao.XlglNoticeFileDao;
import com.css.app.xlgl.entity.XlglNoticeFile;
import com.css.app.xlgl.service.XlglNoticeFileService;




@Service("xlglNoticeFileService")
public class XlglNoticeFileServiceImpl implements XlglNoticeFileService {
	@Autowired
	private XlglNoticeFileDao xlglNoticeFileDao;
	
	@Override
	public XlglNoticeFile queryObject(String id){
		return xlglNoticeFileDao.queryObject(id);
	}
	
	@Override
	public List<XlglNoticeFile> queryList(Map<String, Object> map){
		return xlglNoticeFileDao.queryList(map);
	}
	
	@Override
	public void save(XlglNoticeFile xlglNoticeFile){
		xlglNoticeFileDao.save(xlglNoticeFile);
	}
	
	@Override
	public void update(XlglNoticeFile xlglNoticeFile){
		xlglNoticeFileDao.update(xlglNoticeFile);
	}
	
	@Override
	public void delete(String id){
		xlglNoticeFileDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		xlglNoticeFileDao.deleteBatch(ids);
	}
	
}
