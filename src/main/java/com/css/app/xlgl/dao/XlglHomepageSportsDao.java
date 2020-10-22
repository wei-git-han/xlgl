package com.css.app.xlgl.dao;

import com.css.app.xlgl.entity.XlglHomepageSports;

import org.apache.ibatis.annotations.Mapper;

import com.css.base.dao.BaseDao;
import org.apache.ibatis.annotations.Update;

/**
 * 首页-体育活动
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-10-16 10:45:44
 */
@Mapper
public interface XlglHomepageSportsDao extends BaseDao<XlglHomepageSports> {

    @Update("update XLGL_HOMEPAGE_SPORTS set STATUS = '2' where id = #{0}")
    void cacle(String id);
}
