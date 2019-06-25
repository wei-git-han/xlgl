package com.css.app.db.business.dao;

import com.css.app.db.business.entity.DocumentZbjl;

import org.apache.ibatis.annotations.Mapper;

import com.css.base.dao.BaseDao;

/**
 * 转办记录表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-06-19 13:24:14
 */
@Mapper
public interface DocumentZbjlDao extends BaseDao<DocumentZbjl> {
	
	void deleteByInfoId(String infoId);

	void deleteBySubIdAndInfoId(String subId, String infoId);

	DocumentZbjl queryBySubIdAndInfoId(String subId, String infoId);
	
}
