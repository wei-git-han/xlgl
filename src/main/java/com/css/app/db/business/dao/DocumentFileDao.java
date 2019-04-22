package com.css.app.db.business.dao;

import com.css.app.db.business.entity.DocumentFile;

import org.apache.ibatis.annotations.Mapper;

import com.css.base.dao.BaseDao;

/**
 * 基本信息表携带文件的关系表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-18 16:39:11
 */
@Mapper
public interface DocumentFileDao extends BaseDao<DocumentFile> {
	
	int queryMinSort(String docInfoId);
	
}
