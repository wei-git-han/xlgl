package com.css.app.xlgl.service.impl;

import com.css.app.xlgl.dao.XlglPictureDao;
import com.css.app.xlgl.entity.XlglPicture;
import com.css.app.xlgl.service.XlglPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;




@Service("xlglPictureService")
public class XlglPictureServiceImpl implements XlglPictureService {
	@Autowired
	private XlglPictureDao xlglPictureDao;
	
	@Override
	public XlglPicture queryObject(String id){
		return xlglPictureDao.queryObject(id);
	}
	
	@Override
	public List<XlglPicture> queryList(Map<String, Object> map){
		return xlglPictureDao.queryList(map);
	}
	
	@Override
	public void save(XlglPicture xlglPicture){
		xlglPictureDao.save(xlglPicture);
	}
	
	@Override
	public void update(XlglPicture xlglPicture){
		xlglPictureDao.update(xlglPicture);
	}
	
	@Override
	public void delete(String id){
		xlglPictureDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		xlglPictureDao.deleteBatch(ids);
	}
	
}
