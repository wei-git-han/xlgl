package com.css.app.db.business.dao;

import com.css.app.db.business.entity.ReplyExplain;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.css.base.dao.BaseDao;

/**
 * 办理反馈表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-25 19:07:17
 */
@Mapper
public interface ReplyExplainDao extends BaseDao<ReplyExplain> {
	//获取临时反馈
	ReplyExplain queryLastestTempReply(Map<String, Object> map);
	//更新发布状态
	int updateShowFlag(String subId);
	//查询所有分支局的反馈
	List<ReplyExplain> queryAllLatestReply(String infoId);
	//查询某分支局的反馈
	List<ReplyExplain> querySubLatestReply(String infoId,String subId);
}
