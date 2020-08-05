package com.css.app.xlgl.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.css.app.xlgl.entity.XlglAdminSet;
import com.css.base.dao.BaseDao;

/**
 * 管理员设置表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-19 10:22:04
 */
@Mapper
public interface XlglAdminSetDao extends BaseDao<XlglAdminSet> {
	
	List<XlglAdminSet> queryJuAdminList(String userId);
	
	List<String> queryUserIdByOrgId(String orgId);
	
	List<XlglAdminSet> queryChuAdminList(String userId);
}
