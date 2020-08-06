package com.css.app.xlgl.config.dao;

import com.css.app.xlgl.config.entity.XlglRoleSet;
import com.css.base.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 角色设置表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-19 10:22:36
 */
@Mapper
public interface XlglRoleSetDao extends BaseDao<XlglRoleSet> {
	
	int deleteByUserId(String userId);
}
