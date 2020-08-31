package com.css.app.xlgl.dao;


import com.css.app.xlgl.entity.XlglPhysical;
import org.apache.ibatis.annotations.Mapper;

import com.css.base.dao.BaseDao;
import org.apache.ibatis.annotations.Select;

/**
 * 军事体育训练
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-20 19:38:37
 */
@Mapper
public interface XlglPhysicalDao extends BaseDao<XlglPhysical> {

    void deleteAllRecord(String[] ids);

    @Select("select * from XLGL_PHYSICAL where USER_ID = #{0} AND CREATED_TIME like '%'||#{1}||'%'")
    XlglPhysical queryByUserId(String userId,String year);
}
