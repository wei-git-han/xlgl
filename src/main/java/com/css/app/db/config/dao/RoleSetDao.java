package com.css.app.db.config.dao;

import com.css.app.db.config.entity.RoleSet;

import org.apache.ibatis.annotations.Mapper;

import com.css.base.dao.BaseDao;

/**
 * 角色设置表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-19 10:22:36
 */
@Mapper
public interface RoleSetDao extends BaseDao<RoleSet> {
	
	int deleteByUserId(String userId);
}
