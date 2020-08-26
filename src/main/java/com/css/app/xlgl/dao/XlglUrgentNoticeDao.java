package com.css.app.xlgl.dao;


import com.css.app.xlgl.entity.XlglUrgentNotice;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import com.css.base.dao.BaseDao;
import org.apache.ibatis.annotations.Select;

/**
 * 紧急通知公告
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-13 14:35:46
 */
@Mapper
public interface XlglUrgentNoticeDao extends BaseDao<XlglUrgentNotice> {

    @Select("select * from XLGL_URGENT_NOTICE")
    XlglUrgentNotice queryNotice();

    @Delete("delete from XLGL_URGENT_NOTICE")
    void deleteAll();
}
