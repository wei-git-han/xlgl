package com.css.app.db.config.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.css.app.db.config.entity.DocumentDic;
import com.css.base.dao.BaseDao;

/**
 * 字典配置表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-19 15:23:36
 */
@Mapper
public interface DocumentDicDao extends BaseDao<DocumentDic> {
	
	List<DocumentDic> queryDicByType(String dicType);

	DocumentDic queryIdAndDicType(String id, String docType);
	
}
