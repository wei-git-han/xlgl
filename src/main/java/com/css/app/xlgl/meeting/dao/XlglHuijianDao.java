package com.css.app.xlgl.meeting.dao;

import com.css.app.xlgl.meeting.entity.XlglHuijian;

import org.apache.ibatis.annotations.Mapper;

import com.css.base.dao.BaseDao;

/**
 * 保存会见返回的会议号id
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-09-14 14:41:44
 */
@Mapper
public interface XlglHuijianDao extends BaseDao<XlglHuijian> {
	XlglHuijian queryObjectByxlglId(String id);
}
