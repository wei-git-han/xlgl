package com.css.app.xlgl.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.css.app.xlgl.dao.XlglPictureDao;
import com.css.app.xlgl.entity.XlglPicture;
import com.css.app.xlgl.service.XlglPictureService;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.UUIDUtils;

import cn.com.css.filestore.impl.HTTPFile;




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

	@Override
	public int queryTotal(Map<String, Object> map) {
		return xlglPictureDao.queryTotal(map);
	}

	@Override
	public void savePicture(String fileId, String pictureId, String pictureType) {
		XlglPicture xlglPicture = new XlglPicture();
		//HTTPFile httpFile = new HTTPFile(pictureId);
		//String fileName = httpFile.getFileName();
		xlglPicture.setId(UUIDUtils.random());
		xlglPicture.setFileId(fileId);
		xlglPicture.setPictureId(pictureId);
		xlglPicture.setPictureType(pictureType);
		xlglPicture.setIsFirst("0");
		xlglPicture.setPictureName("ttt");
		xlglPicture.setCreateTime(new Date());
		xlglPicture.setUserId(CurrentUser.getUserId());
		xlglPicture.setUserName(CurrentUser.getUsername());
		Integer valueOf=xlglPictureDao.queryTotal(null)+1;
		xlglPicture.setSort(valueOf.toString());
		xlglPictureDao.save(xlglPicture);
		
	}

	@Override
	public List<XlglPicture> queryAllInfoByInfoId(Map<String,Object> map){
		return xlglPictureDao.queryAllInfoByInfoId(map);
	}

	@Override
	public int deleteByPictureId(Object id) {
		// TODO Auto-generated method stub
		return xlglPictureDao.deleteByPictureId(id);
	}
	@Override
	public XlglPicture queryVedio(String id){
		return xlglPictureDao.queryVedio(id);

	}

	@Override
	public List<XlglPicture> queryTopOne(){
		return xlglPictureDao.queryTopOne();
	}

	@Override
	public XlglPicture queryByInfo(Map<String,Object> map){
		return xlglPictureDao.queryByInfo(map);
	}

	@Override
	public void deleteByInfoId(String infoId){
		xlglPictureDao.deleteByInfoId(infoId);
	}

	@Override
	public List<XlglPicture> queryAllVedioByInfoId(Map<String,Object> map){
		return xlglPictureDao.queryAllVedioByInfoId(map);
	}

	@Override
	public void deleteVedioOrFileOrPicture(String infoId,String id){
		xlglPictureDao.deleteVedioOrFileOrPicture(infoId,id);
	}

	@Override
	public List<XlglPicture> queryListByType(Map<String, Object> map) {
		return xlglPictureDao.queryListByType(map);
	}

}
