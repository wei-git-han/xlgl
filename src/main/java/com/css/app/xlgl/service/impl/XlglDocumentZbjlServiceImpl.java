package com.css.app.xlgl.service.impl;

import com.css.app.xlgl.dao.XlglDocumentZbjlDao;
import com.css.app.xlgl.entity.XlglDocumentZbjl;
import com.css.app.xlgl.service.XlglDocumentZbjlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;




@Service("xlglDocumentZbjlService")
public class XlglDocumentZbjlServiceImpl implements XlglDocumentZbjlService {
	@Autowired
	private XlglDocumentZbjlDao xlglDocumentZbjlDao;
	
	@Override
	public XlglDocumentZbjl queryObject(String id){
		return xlglDocumentZbjlDao.queryObject(id);
	}
	
	@Override
	public List<XlglDocumentZbjl> queryList(Map<String, Object> map){
		return xlglDocumentZbjlDao.queryList(map);
	}
	
	@Override
	public void save(XlglDocumentZbjl xlglDocumentZbjl){
		xlglDocumentZbjlDao.save(xlglDocumentZbjl);
	}
	
	@Override
	public void update(XlglDocumentZbjl xlglDocumentZbjl){
		xlglDocumentZbjlDao.update(xlglDocumentZbjl);
	}
	
	@Override
	public void delete(String id){
		xlglDocumentZbjlDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		xlglDocumentZbjlDao.deleteBatch(ids);
	}
	@Override
	public XlglDocumentZbjl queryByInfoId(String fileId){
		return xlglDocumentZbjlDao.queryByInfoId(fileId);
	}

	@Override
	public void deleteByInfoId(String fileId){
		xlglDocumentZbjlDao.deleteByInfoId(fileId);
	}

	
}
