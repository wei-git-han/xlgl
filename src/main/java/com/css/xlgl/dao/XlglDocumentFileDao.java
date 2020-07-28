package com.css.xlgl.dao;


import org.apache.ibatis.annotations.Mapper;

import com.css.base.dao.BaseDao;
import com.css.xlgl.entity.XlglDocumentFile;

/**
 * 基本信息表携带文件的关系表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-07-28 13:15:37
 */
@Mapper
public interface XlglDocumentFileDao extends BaseDao<XlglDocumentFile> {
	int queryMinSort(String docInfoId);
}
