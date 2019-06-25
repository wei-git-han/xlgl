package com.css.app.db.business.dao;

import com.css.app.db.business.entity.ReplyAttac;

import org.apache.ibatis.annotations.Mapper;

import com.css.base.dao.BaseDao;

/**
 * 办理反馈附件表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-25 19:07:17
 */
@Mapper
public interface ReplyAttacDao extends BaseDao<ReplyAttac> {
	void deleteBySubId(String subId);
	
	void deleteBySubIdAndTeamId(String subId,String teamId);
	
}
