package com.css.app.db.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.css.app.db.business.dao.ApprovalOpinionDao;
import com.css.app.db.business.dao.ReplyExplainDao;
import com.css.app.db.business.entity.ApprovalOpinion;
import com.css.app.db.business.entity.DocXbIdea;
import com.css.app.db.business.entity.ReplyExplain;
import com.css.app.db.business.service.ApprovalOpinionService;
import com.css.app.db.business.service.DocXbIdeaService;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.UUIDUtils;



@Service("approvalOpinionService")
public class ApprovalOpinionServiceImpl implements ApprovalOpinionService {
	@Autowired
	private ApprovalOpinionDao approvalOpinionDao;
	@Autowired
	private ReplyExplainDao replyExplainDao;
	@Autowired
	private DocXbIdeaService docXbIdeaService;
	
	@Override
	public ApprovalOpinion queryObject(String id){
		return approvalOpinionDao.queryObject(id);
	}
	
	@Override
	public List<ApprovalOpinion> queryList(Map<String, Object> map){
		return approvalOpinionDao.queryList(map);
	}
	
	@Override
	public void save(ApprovalOpinion approvalOpinion){
		approvalOpinion.setShowFlag("0");
		approvalOpinionDao.save(approvalOpinion);
	}
	
	@Override
	public void update(ApprovalOpinion dbApprovalOpinion){
		approvalOpinionDao.update(dbApprovalOpinion);
	}
	
	@Override
	public void delete(String id){
		approvalOpinionDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		approvalOpinionDao.deleteBatch(ids);
	}

	@Override
	public void saveOpinion(String subId, String replyContent,String trackingType,String saveFlag) {
		//保存审批意见
		String replyTeamId=null;
		Map<String, Object> replyMap =new HashMap<>();
		replyMap.put("subId", subId);
		replyMap.put("showFlag", "0");
		List<ReplyExplain> queryList = replyExplainDao.queryList(replyMap);
		//查询意见表获取组ID
		List<DocXbIdea> docXbIdeas = docXbIdeaService.queryList(replyMap);
		if(queryList !=null && queryList.size()>0) {
			replyTeamId = queryList.get(0).getTeamId();
		}
		ApprovalOpinion opinion=new ApprovalOpinion();
		opinion.setId(UUIDUtils.random());
		opinion.setOpinionContent(replyContent);
		opinion.setReplyTeamId(replyTeamId);
		opinion.setSubId(subId);
		opinion.setTrackingType(trackingType);
		opinion.setUserId(CurrentUser.getUserId());
		opinion.setUserName(CurrentUser.getUsername());
		opinion.setCreatedTime(new Date());
		opinion.setYjType(saveFlag);
		if (docXbIdeas != null && docXbIdeas.size() > 0) {
			opinion.setIdeaGroupId(docXbIdeas.get(0).getGroupId());
		}
		approvalOpinionDao.save(opinion);
	}

	@Override
	public void updateShowFlag(String subId) {
		approvalOpinionDao.updateShowFlag(subId);
	}

	@Override
	public void deleteBySubId(String subId) {
		approvalOpinionDao.deleteBySubId(subId);
		
	}

	@Override
	public void deleteByParam(Map<String, Object> map) {
		approvalOpinionDao.deleteByParam(map);
		
	}
	
}
