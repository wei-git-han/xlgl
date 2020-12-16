package com.css.addbase.apporgan.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.css.addbase.apporgan.entity.BaseAppUser;
import com.css.base.dao.BaseDao;

/**
 * 人员表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2017-11-29 15:10:13
 */
@Mapper
public interface BaseAppUserDao extends BaseDao<BaseAppUser> {
	
	int queryTotal(Map<String,Object> map);
	
	/**
	 * 根据用户ID获取人员信息
	 * @author gengds
	 * @date 2017年6月17日
	 */
	@Select("select * from BASE_APP_USER where USER_ID = #{userId}")
	List<BaseAppUser> findByUserId(String userId);
	
	/**
	 * 根据部门ID获取人员信息
	 * @author gengds
	 * @date 2017年6月17日
	 */
	@Select("select * from BASE_APP_USER where ISDELETE=0 and ORGANID = #{organid} order by SORT")
	List<BaseAppUser> findByDepartmentId(String organid);
	
	/**
	 * 根据用户ID删除人员信息
	 * @author gengds
	 */
	@Delete("delete from BASE_APP_USER where USER_ID = #{userId}")
	List<BaseAppUser> deleteByUserId(String userId);
	
	/**
	 * 根据部门ID获取人员信息
	 * @author gengds
	 * @date 2017年6月17日
	 */
	@Select("select a.*,b.name as organid from BASE_APP_USER a,BASE_APP_ORGAN b where a.ISDELETE=0 and b.ISDELETE=0 and a.ORGANID = #{organid} and b.ID=a.ORGANID order by a.SORT")
	List<BaseAppUser> findByOrganid(String organid);
	
	/**
	 * 根据用户ID获取人员信息
	 * @param userIds
	 * @return
	 */
	List<BaseAppUser> queryObjectByUserIds(String[] userIds);
	
	/**
	 * 根据部门ID获取人员信息
	 * @param userIds
	 * @return
	 */
	List<BaseAppUser> queryObjectByDeptIds(String[] deptIds);
	
	/**
	 * 获取某个部门下的总人数
	 * @param deptId
	 * @return
	 */
	@Select("select count(uuid) from TASK_USER where user_dept_id in (select uuid from TASK_DEPT start with uuid= #{deptId} connect by prior uuid = dept_parent)")
	int queryCountUser(String deptId);
	
	/**
	 * 清空组织人员
	 */
	@Delete("delete from BASE_APP_USER")
	void clearUser();

	List<BaseAppUser> queryListBySet(Map<String, Object> map);

	List<BaseAppUser> queryUserByName(String name);
	
	/**
	 * @description:获取同一单位下名字为XX的人员
	 * @author:zhangyw
	 * @date:2019年5月23日
	 * @Version v1.0
	 */
	List<BaseAppUser> selectUserByNameAndUnitId(String name,String unitId);
	
	
	//@Select("select count(1) from BASE_APP_USER")
	int queryAllUser(String deptId);
	
	//@Select("select count(1) from BASE_APP_USER  where")
	int queryZbUser(String deptId);
	
	@Select("select count(1) from BASE_APP_USER where ORGANID = #{0}")
	int queryUserNum(String deptId);

	@Select("select * from BASE_APP_USER where ORGANID = #{0}")
	List<BaseAppUser> queryUsers(String deptId);

	List<BaseAppUser> queryAllUserIdAndName(Map<String,Object> map);

	@Select("select  t.*,d.BAOMING,d.INFO_ID,d.READ,d.IS_WORK,d.REASON from BASE_APP_USER t left join XLGL_SUB_DOC_TRACKING d on t.USER_ID = d.RECEIVER_ID  and d.INFO_ID = #{1} where  t.ORGANID in  (  select id from BASE_APP_ORGAN start with ID = #{0} and ISDELETE=0 connect by prior ID = PARENT_ID )")
	List<BaseAppUser> queryAllUserByDeptId(String deptId,String infoId);

	@Select("select  t.*,d.BAOMING,d.INFO_ID,d.READ,d.IS_WORK,d.REASON from BASE_APP_USER t left join XLGL_SUB_DOC_TRACKING d on t.USER_ID = d.RECEIVER_ID  and d.INFO_ID = #{1} where  t.ORGANID in  (  select id from BASE_APP_ORGAN where ID = #{0})")
	List<BaseAppUser> queryAllJuUserByDeptId(String deptId,String infoId);

	@Select("select  count(*) from BASE_APP_USER t left join XLGL_SUB_DOC_TRACKING d on t.USER_ID = d.RECEIVER_ID  and d.INFO_ID = #{0} and d.baoming = #{1} where  d.REC_DEPT_ID  = #{2}")
	int queryBmCout(String infoId,String status,String deptId);

//	@Select("select  count(*) from BASE_APP_USER t left join XLGL_SUB_DOC_TRACKING d on t.USER_ID = d.RECEIVER_ID  and d.INFO_ID = #{0} and d.baoming = #{1} where  d.REC_DEPT_ID in  (  select id from BASE_APP_ORGAN start with ID = #{2} and ISDELETE=0 connect by prior ID = PARENT_ID)")
//	int queryBmCout(String infoId,String status,String deptId);

	@Select("select  count(*) from BASE_APP_USER t left join XLGL_SUB_DOC_TRACKING d on t.USER_ID = d.RECEIVER_ID  and d.INFO_ID = #{1} and d.READ = '1' where  d.REC_DEPT_ID in  (  select id from BASE_APP_ORGAN start with ID = #{0} and ISDELETE=0 connect by prior ID = PARENT_ID)")
	int queryYjs(String deptId,String infoId);

	@Select("select  count(*) from BASE_APP_USER t left join XLGL_SUB_DOC_TRACKING d on t.USER_ID = d.RECEIVER_ID  and d.INFO_ID = #{1} and d.READ = '0' where  d.REC_DEPT_ID in  (  select id from BASE_APP_ORGAN start with ID = #{0} and ISDELETE=0 connect by prior ID = PARENT_ID)")
	int queryWjs(String deptId,String infoId);

	@Select("select ORGANID from BASE_APP_USER where USER_ID = #{0}")
	String queryByUserId(String userId);

	int queryListAllYx(Map<String,Object> map);

	List<BaseAppUser> queryAllExcelList(Map<String,Object> map);
	
	
	List<BaseAppUser>  queryListByOrganid(Map<String,Object> map);

	@Select("select  count(*) from BASE_APP_USER where SFYX = '0'")
	int queryListAllYxCount();

	@Select("select  count(*) from BASE_APP_USER where SFZB = '1'")
	int getAllZbSum();

	int queryYxCount(Map<String, Object> map);

	@Select("select  * from BASE_APP_USER where USER_ID = #{0}")
	BaseAppUser query(String userId);

	@Select("select  count(*) from BASE_APP_USER where SFZB = '1'")
	int queryAllZbCount();
	
	List<BaseAppUser>  queryByOrganidTREEPATH(Map<String,Object> map);

	@Select("select  * from BASE_APP_USER")
	List<BaseAppUser> queryAllUsers();

	@Select("select * from BASE_APP_USER where USER_ID not in (select REPLY_USER_ID from XLGL_EXAM_MAIN_ANSWER where EXAMINE_ID = #{0})")
	List<BaseAppUser> queryData(String id);
	
}
