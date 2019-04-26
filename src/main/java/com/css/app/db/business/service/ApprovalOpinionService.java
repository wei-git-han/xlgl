package com.css.app.db.business.service;

import com.css.app.db.business.entity.ApprovalOpinion;

import java.util.List;
import java.util.Map;

/**
 * 审批意见表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-25 19:09:02
 */
public interface ApprovalOpinionService {
	
	ApprovalOpinion queryObject(String id);
	
	List<ApprovalOpinion> queryList(Map<String, Object> map);
	
	void save(ApprovalOpinion dbApprovalOpinion);
	
	void update(ApprovalOpinion dbApprovalOpinion);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
	
	void saveOpinion(String subId,String replyContent,String trackingType);
	
	int updateShowFlag(String subId);
}
