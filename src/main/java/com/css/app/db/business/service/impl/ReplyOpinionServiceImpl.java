package com.css.app.db.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.css.app.db.business.dao.ReplyOpinionDao;
import com.css.app.db.business.entity.ReplyOpinion;
import com.css.app.db.business.service.ReplyOpinionService;



@Service("replyOpinionService")
public class ReplyOpinionServiceImpl implements ReplyOpinionService {
	@Autowired
	private ReplyOpinionDao replyOpinionDao;
	
	@Override
	public ReplyOpinion queryObject(String id){
		return replyOpinionDao.queryObject(id);
	}
	
	@Override
	public List<ReplyOpinion> queryList(Map<String, Object> map){
		return replyOpinionDao.queryList(map);
	}
	
	@Override
	public void save(ReplyOpinion dbReplyOpinion){
		replyOpinionDao.save(dbReplyOpinion);
	}
	
	@Override
	public void update(ReplyOpinion dbReplyOpinion){
		replyOpinionDao.update(dbReplyOpinion);
	}
	
	@Override
	public void delete(String id){
		replyOpinionDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		replyOpinionDao.deleteBatch(ids);
	}
	
}
