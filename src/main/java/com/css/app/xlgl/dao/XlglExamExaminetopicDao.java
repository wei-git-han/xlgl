package com.css.app.xlgl.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.css.app.xlgl.dto.XlglExamExaminetopicDto;
import com.css.app.xlgl.entity.XlglExamExaminetopic;
import com.css.base.dao.BaseDao;

/**
 * 训练考核-考核组织-考试副表题目表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-07-30 10:56:43
 */
@Mapper
public interface XlglExamExaminetopicDao extends BaseDao<XlglExamExaminetopic> {
	void saveBatch(List<XlglExamExaminetopic> list);

	List<XlglExamExaminetopicDto> findCountBySubjectId(Map<String,Object> map);
	List<XlglExamExaminetopic> findListBySubjectId(Map<String,Object> map);

	void deleteByExamineId(Map<String,Object> map);
}

