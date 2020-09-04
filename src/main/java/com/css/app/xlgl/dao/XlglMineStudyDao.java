package com.css.app.xlgl.dao;


import com.css.app.xlgl.entity.XlglMineStudy;
import org.apache.ibatis.annotations.Mapper;

import com.css.base.dao.BaseDao;
import org.apache.ibatis.annotations.Select;

/**
 * 训练管理自学表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-21 14:37:00
 */
@Mapper
public interface XlglMineStudyDao extends BaseDao<XlglMineStudy> {

    void deleteAllRecord(String[] ids);

    @Select("select top 1* from XLGL_MINE_STUDY where USER_ID = #{0} and CREATED_TIME like '%'||#{1}||'%'")
    XlglMineStudy queryByUserId(String userId,String year);
}
