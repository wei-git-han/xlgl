package com.css.app.db.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.css.app.db.business.dao.ApprovalOpinionDao;
import com.css.app.db.business.entity.ApprovalOpinion;
import com.css.app.db.business.service.ApprovalOpinionService;



@Service("approvalOpinionService")
public class ApprovalOpinionServiceImpl implements ApprovalOpinionService {
	@Autowired
	private ApprovalOpinionDao approvalOpinionDao;
	
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
	
}
