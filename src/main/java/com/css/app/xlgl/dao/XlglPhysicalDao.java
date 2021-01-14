package com.css.app.xlgl.dao;


import com.css.app.xlgl.entity.XlglPhysical;
import org.apache.ibatis.annotations.Mapper;

import com.css.base.dao.BaseDao;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

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

    @Select("select top 1 * from XLGL_PHYSICAL where USER_ID = #{0} and NORMAL = '1' AND CURENT_YEAR like '%'||#{1}||'%'")
    XlglPhysical queryByUserId(String userId, String year);

    String querySort(Map<String,Object> map);
    
    @Select("select * from XLGL_PHYSICAL as a where not exists (select * from XLGL_PHYSICAL as b where a.user_id = b.user_id and a.created_time < b.created_time) and a.NORMAL = '1' AND a.CURENT_YEAR like '%'||#{0}||'%'")
    List<XlglPhysical> queryByUserIdList(String year);
}
