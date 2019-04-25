package com.css.app.db.business.service;

import com.css.app.db.business.entity.ReplyOpinion;

import java.util.List;
import java.util.Map;

/**
 * 意见反馈表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-25 15:10:37
 */
public interface ReplyOpinionService {
	
	ReplyOpinion queryObject(String id);
	
	List<ReplyOpinion> queryList(Map<String, Object> map);
	
	void save(ReplyOpinion dbReplyOpinion);
	
	void update(ReplyOpinion dbReplyOpinion);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
}
