package com.css.app.xlgl.dao;

import com.css.app.xlgl.entity.XlglExposure;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.css.base.dao.BaseDao;

/**
 * 首页-曝光台表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-09-08 10:41:01
 */
@Mapper
public interface XlglExposureDao extends BaseDao<XlglExposure> {
	List<XlglExposure> queryListInfo(Map<String, Object> map);
	
}
