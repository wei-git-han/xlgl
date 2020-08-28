package com.css.app.xlgl.dao;


import com.css.app.xlgl.entity.XlglZbgl;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import com.css.base.dao.BaseDao;

/**
 * 训练管理装备管理
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-17 19:34:44
 */
@Mapper
public interface XlglZbglDao extends BaseDao<XlglZbgl> {

    @Delete("delete from XLGL_ZBGL")
    void deleteAll();
}
