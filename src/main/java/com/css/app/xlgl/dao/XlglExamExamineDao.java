package com.css.app.xlgl.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.css.app.xlgl.entity.XlglExamExamine;
import com.css.base.dao.BaseDao;

/**
 * 训练考核-考试组织-考试基本信息表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-07-30 10:56:43
 */
@Mapper
public interface XlglExamExamineDao extends BaseDao<XlglExamExamine> {
	int findCount(String id);
	
	List<XlglExamExamine> queryVerifyList(Map<String, Object> map);
	
}
