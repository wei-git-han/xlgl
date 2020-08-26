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

    List<XlglSubDocTracking> queryListForPerson1(Map<String,Object> map);

    //@Select("select INFO_ID from XLGL_SUB_DOC_TRACKING where RECEIVER_ID = #{0} and BAOMING = #{1}")
    List<XlglSubDocTracking> queryAllInfos(Map<String,Object> map1);


    List<XlglSubDocTracking> queryAllYear(Map<String,Object> map1);

    @Select("select count(1) from XLGL_SUB_DOC_TRACKING where INFO_ID = #{0} and IS_WORK = '1'")
    int queryCount(String fileId);

    //@Select("select * from BASE_APP_ORGAN where ISDELETE=0 and TREE_PATH like '%'||#{deptId}||'%' ")
    @Select("select count(1) from XLGL_SUB_DOC_TRACKING where RECEIVER_ID = #{0} and EXERCISE_TIME like '%'||#{1}||'%'" )
    int queryAllCount(String userId,String year);
    @Select("select count(1) from XLGL_SUB_DOC_TRACKING where RECEIVER_ID = #{0} and IS_WORK = '1' and EXERCISE_TIME like '%'||#{1}||'%'")
    int quereyWcCount(String userId,String year);

    int queryCurrentYear(Map<String,Object> map);

    int queryCxCount(Map<String,Object> map);

    int queryBmCount(Map<String,Object> map);
}
