package com.css.app.xlgl.dao;

import com.css.app.xlgl.entity.XlglHomepageSportsPerson;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import com.css.base.dao.BaseDao;
import org.apache.ibatis.annotations.Select;

/**
 * 首页-体育活动-人员报名表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-10-16 10:45:44
 */
@Mapper
public interface XlglHomepageSportsPersonDao extends BaseDao<XlglHomepageSportsPerson> {

    @Delete("delete from XLGL_HOMEPAGE_SPORTS_PERSON where SPORTS_ID = #{0} and USER_ID = #{1}")
    void deleteBySportIdAndUserId(String sportId,String userId);

    @Select("select * from XLGL_HOMEPAGE_SPORTS_PERSON where SPORTS_ID = #{0} and USER_ID = #{1}")
    XlglHomepageSportsPerson queryByUserAndSportId(String sportId,String userId);
}
