package com.css.app.db.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.css.app.db.business.dao.ReplyAttacDao;
import com.css.app.db.business.entity.ReplyAttac;
import com.css.app.db.business.service.ReplyAttacService;



@Service("replyAttacService")
public class ReplyAttacServiceImpl implements ReplyAttacService {
	@Autowired
	private ReplyAttacDao replyAttacDao;
	
	@Override
	public ReplyAttac queryObject(String id){
		return replyAttacDao.queryObject(id);
	}
	
	@Override
	public List<ReplyAttac> queryList(Map<String, Object> map){
		return replyAttacDao.queryList(map);
	}
	
	@Override
	public void save(ReplyAttac dbReplyAttac){
		replyAttacDao.save(dbReplyAttac);
	}
	
	@Override
	public void update(ReplyAttac dbReplyAttac){
		replyAttacDao.update(dbReplyAttac);
	}
	
	@Override
	public void delete(String id){
		replyAttacDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		replyAttacDao.deleteBatch(ids);
	}
	
}
