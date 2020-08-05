package com.css.app.xlgl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.css.app.xlgl.entity.XlglExamSubject;
import com.css.base.dao.BaseDao;

/**
 * 训练管理-考核-题目维护-科目表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-07-28 16:17:20
 */
@Mapper
public interface XlglExamSubjectDao extends BaseDao<XlglExamSubject> {
	List<XlglExamSubject> findList();
	
}
