package com.css.app.db.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.css.addbase.FileBaseUtil;
import com.css.app.db.business.dao.ReplyAttacDao;
import com.css.app.db.business.entity.ReplyAttac;
import com.css.app.db.business.service.ReplyAttacService;
import com.css.base.utils.UUIDUtils;



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

	@Override
	public void saveAttacs(MultipartFile[] files, String subId, String teamId) {
		for(int i=0;i<files.length;i++) {
			ReplyAttac attach=new ReplyAttac();
			String fileId = FileBaseUtil.fileServiceUpload(files[i]);
			attach.setId(UUIDUtils.random());
			attach.setKeyId(subId);
			attach.setReplyTeamId(teamId);
			attach.setFileName(files[i].getOriginalFilename());
			attach.setFileServerId(fileId);
			attach.setCreatedTime(new Date());
			replyAttacDao.save(attach);
		}
	}

	@Override
	public void deleteBySubId(String subId) {
		replyAttacDao.deleteBySubId(subId);
		
	}
	
}
