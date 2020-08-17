package com.css.app.xlgl.dao;


import com.css.app.xlgl.entity.XlglSubDocTracking;
import org.apache.ibatis.annotations.Mapper;

import com.css.base.dao.BaseDao;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-11 15:53:31
 */
@Mapper
public interface XlglSubDocTrackingDao extends BaseDao<XlglSubDocTracking> {

    @Select("select * from XLGL_SUB_DOC_TRACKING where INFO_ID = #{0} and RECEIVER_ID = #{1}")
    XlglSubDocTracking queryInfo(String id,String userId);

    @Select("select * from XLGL_SUB_DOC_TRACKING where INFO_ID = #{0} and RECEIVER_ID = #{2} and SUB_ID = #{1}")
    XlglSubDocTracking querybaoming(String infoId,String subId,String userId);

    @Select("select * from XLGL_SUB_DOC_TRACKING where INFO_ID = #{0} and RECEIVER_ID = #{1}")
    XlglSubDocTracking queryStatusByInfoIdAndUserId(String infoId,String userId);

    List<Map<String,Object>> queryBmInfo(String infoId,String deptId);

    List<XlglSubDocTracking> queryListForPerson(Map<String,Object> map);
}
