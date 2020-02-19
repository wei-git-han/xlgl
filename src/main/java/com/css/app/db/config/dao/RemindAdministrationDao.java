package com.css.app.db.config.dao;

import com.css.app.db.config.entity.RemindAdministration;

import org.apache.ibatis.annotations.Mapper;

import com.css.base.dao.BaseDao;

/**
 * 提醒管理表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-02-18 14:45:49
 */
@Mapper
public interface RemindAdministrationDao extends BaseDao<RemindAdministration> {
	
}
