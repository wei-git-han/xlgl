package com.css.app.xlgl.dao;


import com.css.app.xlgl.entity.XlglDocumentZbjl;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import com.css.base.dao.BaseDao;
import org.apache.ibatis.annotations.Select;

/**
 * 转办记录表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-11 11:11:27
 */
@Mapper
public interface XlglDocumentZbjlDao extends BaseDao<XlglDocumentZbjl> {

    @Select("select * from XLGL_DOCUMENT_ZBJL where INFO_ID = #{0}")
    XlglDocumentZbjl queryByInfoId(String fileId);

    @Delete("delete from XLGL_DOCUMENT_ZBJL where INFO_ID = #{0}")
    void deleteByInfoId(String fileId);
}
