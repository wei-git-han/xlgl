package com.css.app.db.business.service;

import java.util.List;
import java.util.Map;

import com.css.app.db.business.entity.ReplyExplain;

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
	
	ReplyExplain queryLastestTempReply(Map<String, Object> map);
	
	void saveReply(String subId,String infoId,String userId,String userName,String teamId,String replyContent,String subDeptId,String subDeptName);
	
	void updateShowFlag(String subId);
	//查询所有分支局的反馈
	List<ReplyExplain> queryAllLatestReply(String infoId);
	//查询某分支局的反馈
	List<ReplyExplain> querySubLatestReply(String infoId,String subId);
	//查询所有分支局的最新一条反馈
	List<ReplyExplain> queryAllLatestOneReply(String infoId);
}
