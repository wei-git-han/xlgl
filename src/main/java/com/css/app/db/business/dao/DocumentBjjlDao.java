package com.css.app.db.business.dao;

import com.css.app.db.business.entity.DocumentBjjl;

import org.apache.ibatis.annotations.Mapper;

import com.css.base.dao.BaseDao;

/**
 * 办结记录表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-25 19:46:10
 */
@Mapper
public interface DocumentBjjlDao extends BaseDao<DocumentBjjl> {
	
	DocumentBjjl queryLatestBjjl(String infoId);
}
