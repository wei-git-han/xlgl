package com.css.app.xlgl.dao;

import com.css.app.xlgl.entity.XlglNoticeRead;

import org.apache.ibatis.annotations.Mapper;

import com.css.base.dao.BaseDao;
import org.apache.ibatis.annotations.Select;

/**
 * 通知公告已阅人员表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-12 17:14:57
 */
@Mapper
public interface XlglNoticeReadDao extends BaseDao<XlglNoticeRead> {

    @Select("select * from XLGL_NOTICE_READ where READ_USER_ID = #{0} and NOTICE_ID = #{1}")
    XlglNoticeRead queryIsRead(String noticeId,String userId);
}
