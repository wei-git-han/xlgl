package com.css.app.xlgl.dao;


import com.css.app.xlgl.entity.XlglSubDocInfo;
import org.apache.ibatis.annotations.Mapper;

import com.css.base.dao.BaseDao;

import java.util.List;
import java.util.Map;

/**
 * 各子分支主记录表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-11 11:04:56
 */
@Mapper
public interface XlglSubDocInfoDao extends BaseDao<XlglSubDocInfo> {

    List<String> queryAllSubDeptIds(String fileId);

    List<XlglSubDocInfo> queryListForJu(Map<String,Object> map);

    List<XlglSubDocInfo> queryListForPerson(Map<String,Object> map);
}
