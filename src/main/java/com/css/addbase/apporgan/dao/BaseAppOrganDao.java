package com.css.addbase.apporgan.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.css.addbase.apporgan.entity.BaseAppOrgan;
import com.css.base.dao.BaseDao;

/**
 * 部门表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2017-11-29 15:10:13
 */
@Mapper
public interface BaseAppOrganDao extends BaseDao<BaseAppOrgan> {
	
	int queryTotal(Map<String,Object> map);
	
	/**
	 * 根据父Id获取部门信息
	 * @author gengds
	 */
	@Select("select * from BASE_APP_ORGAN where ISDELETE=0 and PARENT_ID = #{parentId} order by SORT")
	List<BaseAppOrgan> findByParentId(String parentId);
	
	/**
	 * 根据ID获取该部门及其全部子部门信息
	 * @author gengds
	 */
	@Select("select * from BASE_APP_ORGAN where ISDELETE=0 and TREE_PATH like '%'||#{deptId}||'%' ")
	List<BaseAppOrgan> findAllDeptById(String deptId);
	
	/**
	 * 根据ID获取该部门及其全部子部门信息
	 * @author gengds
	 */
	@Select("select ID from BASE_APP_ORGAN start with ID= #{id} and ISDELETE=0 connect by prior ID = PARENT_ID")
	List<BaseAppOrgan> findAllByparentId(String id);
	
	/**
	 * 清空组织机构
	 * @author gengds
	 */
	@Delete("delete from BASE_APP_ORGAN")
	void clearOrgan();
	
	List<BaseAppOrgan> queryListByIds(String[] ids);
	
	@Select("select * from BASE_APP_ORGAN where PARENT_ID = #{0}")
	List<BaseAppOrgan> queryAllDept(String root);
	
	@Select("select * from BASE_APP_ORGAN where PARENT_ID = #{id} and ISDELETE = 0 order by sort")
	List<BaseAppOrgan> getSubOrg(String id);
	
	List<BaseAppOrgan> getSubOrgSync(Map<String, Object> map);

	@Select("select * from BASE_APP_ORGAN start with ID = #{0}  and ISDELETE=0 connect by prior ID = PARENT_ID")
	List<BaseAppOrgan> queryAllDeptId(String orgId);

	@Select("select * from BASE_APP_ORGAN where PARENT_ID = 'root'")
	List<BaseAppOrgan> queryAllDeptIds();

	@Select("select * from BASE_APP_ORGAN where ID = #{0}")
	List<BaseAppOrgan> queryPerDept(String deptId);

	@Select("select * from BASE_APP_ORGAN where id = #{0}")
	BaseAppOrgan queryDeptNameByUserId(String orgId);


	BaseAppOrgan queryDeptByUserId(Map<String,Object> map);
	
	List<String> queryListByTREEPATH(String orgId);
	
	/**
	 * 根据父Id获取部门信息，判断业务配置是否有效
	 * @author gengds
	 */
	List<BaseAppOrgan> findByParentIdAndIsinvalid(Map<String, Object> map);
	
	
	void updateIsInvalId(Map<String, Object> map);
	
	
	List<BaseAppOrgan> queryListAndIsInvalId (Map<String, Object> map);
	
	/**
	 * 根据父Id获取部门信息
	 * @author gengds
	 */
	@Select("select * from ( select * from BASE_APP_ORGAN start with ID  = #{parentId} and ISDELETE=0  connect by prior ID = PARENT_ID) where  PARENT_ID != 'root' and (IS_INVALID = '0' or IS_INVALID is null) ")
	List<BaseAppOrgan> findOrganByParentIdAll(String parentId);
}


