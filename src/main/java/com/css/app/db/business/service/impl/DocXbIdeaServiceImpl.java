package com.css.app.db.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.css.app.db.business.dao.DocXbIdeaDao;
import com.css.app.db.business.entity.DocXbIdea;
import com.css.app.db.business.service.DocXbIdeaService;



@Service("DocXbIdeaService")
public class DocXbIdeaServiceImpl implements DocXbIdeaService {
	@Autowired
	private DocXbIdeaDao DocXbIdeaDao;
	
	@Override
	public DocXbIdea queryObject(String id){
		return DocXbIdeaDao.queryObject(id);
	}
	
	@Override
	public List<DocXbIdea> queryList(Map<String, Object> map){
		return DocXbIdeaDao.queryList(map);
	}
	
	@Override
	public void save(DocXbIdea DocXbIdea){
		DocXbIdeaDao.save(DocXbIdea);
	}
	
	@Override
	public void update(DocXbIdea DocXbIdea){
		DocXbIdeaDao.update(DocXbIdea);
	}
	
	@Override
	public void delete(String id){
		DocXbIdeaDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		DocXbIdeaDao.deleteBatch(ids);
	}

	@Override
	public DocXbIdea queryLastNewData(String subId, String infoId) {
		// TODO Auto-generated method stub
		return DocXbIdeaDao.queryLastNewData();
	}
	
}
