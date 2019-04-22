package com.css.app.db.config.dao;

import com.css.app.db.config.entity.Menu;

import org.apache.ibatis.annotations.Mapper;

import com.css.base.dao.BaseDao;

/**
 * 菜单表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-19 10:22:36
 */
@Mapper
public interface MenuDao extends BaseDao<Menu> {
	
}
