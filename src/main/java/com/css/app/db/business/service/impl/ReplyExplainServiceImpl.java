package com.css.app.db.business.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.css.app.db.business.dao.ReplyExplainDao;
import com.css.app.db.business.entity.DocXbInfo;
import com.css.app.db.business.entity.ReplyExplain;
import com.css.app.db.business.entity.SubDocTracking;
import com.css.app.db.business.service.ReplyExplainService;
import com.css.app.db.business.service.SubDocTrackingService;
import com.css.base.utils.UUIDUtils;



@Service("replyExplainService")
public class ReplyExplainServiceImpl implements ReplyExplainService {
	@Autowired
	private ReplyExplainDao replyExplainDao;
	@Autowired
	private SubDocTrackingService subDocTrackingService;
	
	@Override
	public ReplyExplain queryObject(String id){
		return replyExplainDao.queryObject(id);
	}
	
	@Override
	public List<ReplyExplain> queryList(Map<String, Object> map){
		return replyExplainDao.queryList(map);
	}
	
	@Override
	public void save(ReplyExplain replyExplain){
		replyExplainDao.save(replyExplain);
	}
	
	@Override
	public void update(ReplyExplain dbReplyExplain){
		replyExplainDao.update(dbReplyExplain);
	}
	
	@Override
	public void delete(String id){
		replyExplainDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		replyExplainDao.deleteBatch(ids);
	}

	@Override
	public ReplyExplain queryLastestTempReply(Map<String, Object> map) {
		return replyExplainDao.queryLastestTempReply(map);
	}
	@Override
	public ReplyExplain queryReplyExplain(String opinionId){
		return replyExplainDao.queryReplyExplain(opinionId);
	}

	@Override
	public void saveReply(String subId, String infoId, String userId, String userName, String teamId,
			String replyContent, String subDeptId, String subDeptName,String cbrFlag,String checkStatus) {
		ReplyExplain reply=new ReplyExplain();
		reply.setId(UUIDUtils.random());
		reply.setSubId(subId);
		reply.setInfoId(infoId);
		reply.setUserId(userId);
		reply.setUserName(userName);
		reply.setCreatedTime(new Date());
		reply.setReplyContent(replyContent);
		reply.setTeamId(teamId);
		reply.setSubDeptId(subDeptId);
		reply.setSubDeptName(subDeptName);
		reply.setShowFlag("0");
		reply.setReVersion("0");
		reply.setCbrFlag(cbrFlag);
		if(StringUtils.isNotBlank(checkStatus)) {
			reply.setChooseStatus(checkStatus);
		}
		SubDocTracking subDocTracking = subDocTrackingService.queryLatestRecord(subId);
		if (subDocTracking != null) {
			String ideaGroupId = subDocTracking.getIdeaGroupId();
			reply.setIdeaGroupId(ideaGroupId);
		}
		replyExplainDao.save(reply);
	}

	@Override
	public void saveNewReply(String subId, String infoId, String userId, String userName, String teamId,
						  String replyContent, String subDeptId, String subDeptName,String cbrFlag,String checkStatus,String ideaGroupId) {
		ReplyExplain reply=new ReplyExplain();
		reply.setId(UUIDUtils.random());
		reply.setSubId(subId);
		reply.setInfoId(infoId);
		reply.setUserId(userId);
		reply.setUserName(userName);
		reply.setCreatedTime(new Date());
		reply.setReplyContent(replyContent);
		reply.setTeamId(teamId);
		reply.setSubDeptId(subDeptId);
		reply.setSubDeptName(subDeptName);
		reply.setShowFlag("1");
		reply.setReVersion("1");
		reply.setCbrFlag(cbrFlag);
		if(StringUtils.isNotBlank(checkStatus)) {
			reply.setChooseStatus(checkStatus);
		}
		reply.setIdeaGroupId(ideaGroupId);
		reply.setChowTime(new Date());
		reply.setVersionTime(new Date());
		replyExplainDao.save(reply);
	}

	@Override
	public void updateShowFlag(Date showTime,String subId) {
		replyExplainDao.updateShowFlag(showTime,subId);
	}

	@Override
	public List<ReplyExplain> queryAllLatestReply(String infoId) {
		return replyExplainDao.queryAllLatestReply(infoId);
	}

	@Override
	public List<ReplyExplain> querySubLatestReply(String infoId, String subId) {
		return replyExplainDao.querySubLatestReply(infoId, subId);
	}

	@Override
	public List<ReplyExplain> queryAllLatestOneReply(String infoId) {
		return replyExplainDao.queryAllLatestOneReply(infoId);
	}

	@Override
	public void deleteByParam(Map<String, Object> map) {
		replyExplainDao.deleteByParam(map);
	}

	@Override
	public ReplyExplain queryLastNewData(String infoId, String subId) {
		// TODO Auto-generated method stub
		return replyExplainDao.queryLastNewData(infoId, subId);
	}
	
}
