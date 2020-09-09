package com.css.app.xlgl.dao;


import com.css.app.xlgl.entity.XlglXlzzInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import com.css.base.dao.BaseDao;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * 训练组织基本信息表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-11 10:12:29
 */
@Mapper
public interface XlglXlzzInfoDao extends BaseDao<XlglXlzzInfo> {

    @Select("select top 1 * from XLGL_XLZZ_INFO order by CREATE_TIME desc")
    List<XlglXlzzInfo> queryTopOne();

    @Delete("delete from XLGL_XLZZ_INFO where ID = #{0}")
    void deleteById(String id);

    List<XlglXlzzInfo> queryBySort(Map<String,Object> map);

    XlglXlzzInfo queryDelete(Map<String,Object> map);
}
