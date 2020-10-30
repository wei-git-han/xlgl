package com.css.app.xlgl.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.css.app.xlgl.entity.TaskMenu;
import com.css.base.dao.BaseDao;

/**
 * 
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-05 13:46:02
 */
@Mapper
public interface TaskMenuDao extends BaseDao<TaskMenu> {
	@Select("select * from TASK_MENU where PARENT_ID = #{parentId} order by SORT")
	List<TaskMenu> findByParentId(String id);
	
	List<TaskMenu> queryAuthList(Map<String, Object> map);

	@Select("select * from TASK_MENU")
	List<TaskMenu> queryAll();
}
