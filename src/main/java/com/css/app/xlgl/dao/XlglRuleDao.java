package com.css.app.xlgl.dao;


import com.css.app.xlgl.entity.XlglRule;
import org.apache.ibatis.annotations.Mapper;

import com.css.base.dao.BaseDao;

import java.util.List;
import java.util.Map;

/**
 * 训练管理法规资料
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-20 20:18:42
 */
@Mapper
public interface XlglRuleDao extends BaseDao<XlglRule> {

    List<XlglRule> queryAll(Map<String,Object> map);
}
