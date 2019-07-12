package com.css.app.db.business.dao;

import com.css.app.db.business.entity.DocXbInfo;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.css.base.dao.BaseDao;

/**
 * 协办人反馈意见表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-07-05 14:56:19
 */
@Mapper
public interface DocXbInfoDao extends BaseDao<DocXbInfo> {

	List<DocXbInfo> queryXbRecord(String infoId, String subId, String undertakerId);

	void deleteBySubIdAndReceiverId(String subId, String userId, String ideaGroupId);


	void deleteAllXBRecord(String subId, String ideaGroupId);

	
}
