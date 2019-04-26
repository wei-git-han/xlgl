package com.css.app.db.business.service;

import com.css.app.db.business.entity.ReplyExplain;

import java.util.List;
import java.util.Map;

/**
 * 办理反馈表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-25 19:07:17
 */
public interface ReplyExplainService {
	
	ReplyExplain queryObject(String id);
	
	List<ReplyExplain> queryList(Map<String, Object> map);
	
	void save(ReplyExplain dbReplyExplain);
	
	void update(ReplyExplain dbReplyExplain);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
	
	ReplyExplain queryLastestTempReplyByTeamId(String subId,String teamId,String userId);
}
