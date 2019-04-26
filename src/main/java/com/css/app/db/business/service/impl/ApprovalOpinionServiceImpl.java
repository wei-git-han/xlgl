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
import com.css.app.db.business.entity.ReplyExplain;
import com.css.app.db.business.service.ApprovalOpinionService;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.UUIDUtils;



@Service("approvalOpinionService")
public class ApprovalOpinionServiceImpl implements ApprovalOpinionService {
	@Autowired
	private ApprovalOpinionDao approvalOpinionDao;
	@Autowired
	private ReplyExplainDao replyExplainDao;
	
	@Override
	public ApprovalOpinion queryObject(String id){
		return approvalOpinionDao.queryObject(id);
	}
	
	@Override
	public List<ApprovalOpinion> queryList(Map<String, Object> map){
		return approvalOpinionDao.queryList(map);
	}
	
	@Override
	public void save(ApprovalOpinion dbApprovalOpinion){
		approvalOpinionDao.save(dbApprovalOpinion);
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
	public void saveOpinion(String subId, String replyContent,String trackingType) {
		//保存审批意见
		String replyTeamId=null;
		Map<String, Object> replyMap =new HashMap<>();
		replyMap.put("subId", subId);
		replyMap.put("showFlag", "0");
		List<ReplyExplain> queryList = replyExplainDao.queryList(replyMap);
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
		approvalOpinionDao.save(opinion);
	}

	@Override
	public int updateShowFlag(String subId) {
		return approvalOpinionDao.updateShowFlag(subId);
	}
	
}
