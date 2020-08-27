package com.css.app.xlgl.dao;


import com.css.app.xlgl.entity.XlglKtap;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import com.css.base.dao.BaseDao;

/**
 * 训练管理课题安排
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-18 18:32:15
 */
@Mapper
public interface XlglKtapDao extends BaseDao<XlglKtap> {

    @Delete("delete from XLGL_KTAP")
	void deleteAll();
}
