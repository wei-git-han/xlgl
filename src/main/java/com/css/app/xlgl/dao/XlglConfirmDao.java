package com.css.app.xlgl.dao;


import com.css.app.xlgl.dto.XlglConfirmDto;
import com.css.app.xlgl.entity.XlglConfirm;
import org.apache.ibatis.annotations.Mapper;

import com.css.base.dao.BaseDao;

import java.util.Map;

/**
 * 训练管理确认表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-12 17:01:55
 */
@Mapper
public interface XlglConfirmDao extends BaseDao<XlglConfirm> {

    XlglConfirmDto queryPerDeptInfo(Map<String,Object> map);
}
