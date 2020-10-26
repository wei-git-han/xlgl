package com.css.app.xlgl.dao;


import com.css.app.xlgl.entity.XlglHomepageSportsRead;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import com.css.base.dao.BaseDao;
import org.apache.ibatis.annotations.Select;

/**
 * 训练管理-体育活动-已读未读表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-10-26 13:22:50
 */
@Mapper
public interface XlglHomepageSportsReadDao extends BaseDao<XlglHomepageSportsRead> {

    @Select("select * from XLGL_HOMEPAGE_SPORTS_READ where SPORT_ID = #{0} and USER_ID = #{1}")
    XlglHomepageSportsRead queryBySportAndUserId(String sportId,String userId);

    @Delete("delete from XLGL_HOMEPAGE_SPORTS_READ where SPORT_ID = #{0}")
    void deleteBySportId(String sportId);
	
}
