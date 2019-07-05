package com.css.app.db.business.dao;

import com.css.app.db.business.entity.DocXbIdea;

import org.apache.ibatis.annotations.Mapper;

import com.css.base.dao.BaseDao;

/**
 * 
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-07-05 14:56:19
 */
@Mapper
public interface DocXbIdeaDao extends BaseDao<DocXbIdea> {

	DocXbIdea queryLastNewData();
	
}
