package com.css.app.db.business.dao;

import com.css.app.db.business.entity.SubDocTracking;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.css.base.dao.BaseDao;

/**
 * 局内流转记录表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-24 13:40:54
 */
@Mapper
public interface SubDocTrackingDao extends BaseDao<SubDocTracking> {
	
	SubDocTracking  queryLatestRecord(String subId);
	void deleteBySubId(String subId);
	List<SubDocTracking> queryListBySubId(String subId);
}
