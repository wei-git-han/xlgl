package com.css.app.xlgl.dao;


import com.css.app.xlgl.entity.XlglSubDocInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import com.css.base.dao.BaseDao;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * 各子分支主记录表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-11 11:04:56
 */
@Mapper
public interface XlglSubDocInfoDao extends BaseDao<XlglSubDocInfo> {

    List<String> queryAllSubDeptIds(String fileId);

    List<XlglSubDocInfo> queryListForJu(Map<String,Object> map);

    List<XlglSubDocInfo> queryListForPerson(Map<String,Object> map);

    @Delete("delete from XLGL_SUB_DOC_INFO where SUB_DEPT_ID = #{0} and INFO_ID = #{1}")
    void deleteSub(String orgId,String fileId);

    @Select("select * from XLGL_SUB_DOC_INFO where SUB_DEPT_ID = #{0} and EXERCISE_TIME like '%'||#{1}||'%'")
    List<XlglSubDocInfo> queryAllClass(String orgId,String year);
}
