package com.css.app.xlgl.dao;


import com.css.app.xlgl.entity.XlglMineStudy;

import java.util.List;

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

    @Select("select top 1* from XLGL_MINE_STUDY where USER_ID = #{0} and CURENT_YEAR like '%'||#{1}||'%'")
    XlglMineStudy queryByUserId(String userId,String year);
    
    @Select("select * from XLGL_MINE_STUDY  as a where not exists (select * from XLGL_MINE_STUDY as b where a.user_id = b.user_id and a.created_time < b.created_time) and a.CURENT_YEAR like '%'||#{0}||'%'")
    List<XlglMineStudy> queryByUserIdList(String year);
}
