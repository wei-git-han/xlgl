package com.css.app.xlgl.dao;


import org.apache.ibatis.annotations.Mapper;

import com.css.app.xlgl.entity.DocumentMenuPermission;
import com.css.base.dao.BaseDao;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-04 16:13:34
 */
@Mapper
public interface DocumentMenuPermissionDao extends BaseDao<DocumentMenuPermission> {
	void deleteByUserId(String uid);

	@Select("select MENU_ID from DOCUMENT_MENU_PERMISSION where USER_ID = #{0}")
	List<String> queryAllList(String userId);
}
