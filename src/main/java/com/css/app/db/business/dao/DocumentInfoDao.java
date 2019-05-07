package com.css.app.db.business.dao;

import com.css.app.db.business.entity.DocumentInfo;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.css.base.dao.BaseDao;

/**
 * 督办基本信息表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-18 16:34:38
 */
@Mapper
public interface DocumentInfoDao extends BaseDao<DocumentInfo> {

	List<Map<String, Object>> queryListByYear(Map<String, Object> map);

	List<Map<String, Object>> queryListByOrgYear(Map<String, Object> map);

	List<Map<String, Object>> queryListByDicType(Map<String, Object> map);

	List<Map<String, Object>> queryListByDicStu(Map<String, Object> map);
	
	List<DocumentInfo> queryPersonList(Map<String, Object> map);

	List<Map<String, Object>> queryListByDicStutas(Map<String, Object> map);
	
}
