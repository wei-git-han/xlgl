package com.css.app.xlgl.dao;


import com.css.app.xlgl.entity.XlglSubDocTracking;
import org.apache.ibatis.annotations.Delete;
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

    @Select("select * from XLGL_SUB_DOC_TRACKING where INFO_ID = #{0} and RECEIVER_ID = #{1} and XLTYPE = '1'")
    XlglSubDocTracking queryInfo(String id,String userId);

    @Select("select * from XLGL_SUB_DOC_TRACKING where INFO_ID = #{0} and RECEIVER_ID = #{1}")
    XlglSubDocTracking queryInfomation(String id,String userId);

    @Select("select * from XLGL_SUB_DOC_TRACKING where INFO_ID = #{0} and RECEIVER_ID = #{1} and XLTYPE = '0'")
    XlglSubDocTracking queryDjtInfo(String infoId,String userId);

    @Select("select * from XLGL_SUB_DOC_TRACKING where INFO_ID = #{0} and RECEIVER_ID = #{2} and SUB_ID = #{1}")
    XlglSubDocTracking querybaoming(String infoId,String subId,String userId);

    @Select("select * from XLGL_SUB_DOC_TRACKING where INFO_ID = #{0} and RECEIVER_ID = #{1}")
    XlglSubDocTracking queryStatusByInfoIdAndUserId(String infoId,String userId);

    @Select("select * from ( select ROW_NUMBER() OVER(order by t.EXERCISE_TIME desc ) as SORT, t.*  from XLGL_SUB_DOC_TRACKING t  where RECEIVER_ID = #{1} ) where INFO_ID = #{0}")
    XlglSubDocTracking querySortByInfoIdAndUserId(String infoId,String usreId);

    List<Map<String,Object>> queryBmInfo(String infoId,String deptId);

    List<XlglSubDocTracking> queryListForPerson(Map<String,Object> map);

    List<XlglSubDocTracking> queryListForPerson1(Map<String,Object> map);

    //@Select("select INFO_ID from XLGL_SUB_DOC_TRACKING where RECEIVER_ID = #{0} and BAOMING = #{1}")
    List<XlglSubDocTracking> queryAllInfos(Map<String,Object> map1);

    List<XlglSubDocTracking> queryAllInfoHistory(Map<String,Object> map1);


    List<XlglSubDocTracking> queryAllYear(Map<String,Object> map1);

    @Select("select count(1) from XLGL_SUB_DOC_TRACKING where INFO_ID = #{0} and IS_WORK = '1'")
    int queryCount(String fileId);

    //@Select("select * from BASE_APP_ORGAN where ISDELETE=0 and TREE_PATH like '%'||#{deptId}||'%' ")
    @Select("select count(1) from XLGL_SUB_DOC_TRACKING where RECEIVER_ID = #{0} and EXERCISE_TIME like '%'||#{1}||'%'" )
    int queryAllCount(String userId,String year);

    @Select("select * from XLGL_SUB_DOC_TRACKING where RECEIVER_ID = #{0} and EXERCISE_TIME like '%'||#{1}||'%'")
    List<XlglSubDocTracking> queryByUserIdAndYear(String userId,String year);

    @Select("select count(1) from XLGL_SUB_DOC_TRACKING where RECEIVER_ID = #{0} and XLTYPE = '0' and IS_WORK = '1' and EXERCISE_TIME like '%'||#{1}||'%'")
    int quereyWcCount(String userId,String year);

    @Select("select count(1) from XLGL_SUB_DOC_TRACKING where RECEIVER_ID = #{0} and BAOMING = '2' and EXERCISE_TIME like '%'||#{1}||'%'")
    int queryYhCount(String userId,String year);

    int queryCurrentYear(Map<String,Object> map);

    int queryCxCount(Map<String,Object> map);

    int queryBkCount(Map<String,Object> map);

    int queryBmCount(Map<String,Object> map);

    @Select("select count(1) from XLGL_SUB_DOC_TRACKING where IS_WORK = '1' and EXERCISE_TIME like '%'||#{0}||'%'")
    int queryAllYx(String year);

    @Select("select count(1) from XLGL_SUB_DOC_TRACKING where IS_WORK = '1' and INFO_ID = #{0}")
    int queryAllCx(String fileId);

    @Select("select count(1) from XLGL_SUB_DOC_TRACKING where IS_WORK = '0' and INFO_ID = #{0}")
    int queryAllBkCount(String fileId);

    @Select("select count(1) from XLGL_SUB_DOC_TRACKING where IS_WORK = '1' and INFO_ID = #{0} and REC_DEPT_ID = #{1}")
    int queryAllCxByInfoId(String fileId,String orgId);

    @Select("select count(1) from XLGL_SUB_DOC_TRACKING where IS_WORK = '0' and INFO_ID = #{0} and REC_DEPT_ID = #{1}")
    int queryAllBkByInfoId(String fileId,String orgId);

    @Select("select count(1) from XLGL_SUB_DOC_TRACKING where IS_WORK = '0' and INFO_ID = #{0}")
    int queryAllYh(String fileId);

    int queryCxAllCount(Map<String,Object> map);

    List<XlglSubDocTracking> queryBySort(Map<String,Object> map);

    @Delete("delete from XLGL_SUB_DOC_TRACKING where INFO_ID = #{0} and RECEIVER_ID = #{1}")
    void deleteByInfoIdAndUserId(String infoId,String userId);

    @Delete("delete from XLGL_SUB_DOC_TRACKING where INFO_ID = #{0}")
    void deleteByInfoId(String id);

    @Delete("delete from   XLGL_SUB_DOC_TRACKING where  INFO_ID = #{0} and REC_DEPT_ID in  (select id from BASE_APP_ORGAN start with ID = #{1}  and ISDELETE=0 connect by prior ID = PARENT_ID)")
    void deleteByInfoIdAndOrgId(String orgId,String id);
    
    List<XlglSubDocTracking>   queryMsgRemind();

    @Select("select count(*) from XLGL_SUB_DOC_TRACKING where  INFO_ID = #{0} and IS_WORK = '1' and ORG_ID = #{1} and CREATED_TIME like '%'||#{2}||'%'")
    int queryAllWcByInfoIdAndOrgId(String infoId,String orgId,String year);
    
    @Select("select RECEIVER_ID as userId , count(RECEIVER_ID) as sum from XLGL_SUB_DOC_TRACKING where  EXERCISE_TIME like '%'||#{1}||'%' GROUP BY RECEIVER_ID" )
    List<Map<String,Object>> queryAllCountList(String year);
    
    @Select("select RECEIVER_ID as userId , count(RECEIVER_ID) as sum from XLGL_SUB_DOC_TRACKING where  XLTYPE = '0' and IS_WORK = '1' and EXERCISE_TIME like '%'||#{1}||'%' GROUP BY RECEIVER_ID")
    List<Map<String,Object>> quereyWcCountList(String userId,String year);
  
}
