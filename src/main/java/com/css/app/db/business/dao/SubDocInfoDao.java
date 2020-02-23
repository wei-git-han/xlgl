package com.css.app.db.business.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.css.app.db.business.entity.SubDocInfo;
import com.css.base.dao.BaseDao;

/**
 * 各子分支主记录表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-18 16:40:43
 */
@Mapper
public interface SubDocInfoDao extends BaseDao<SubDocInfo> {
	
	List<SubDocInfo> queryPersonList(Map<String, Object> map);
	List<SubDocInfo> queryPersonList1(Map<String, Object> map);
	
	void updateDocStatus(Integer status,Date updateTime,String infoId);
	
	int queryMinDocStatus(String infoId,String subDeptId);
	
	int queryMaxDocStatus(String infoId,String subDeptId);
	
	List<String> queryAllSubDeptIds(String infoId);
	
	List<SubDocInfo> queryLastEndSubInfo(String infoId);
	
	List<SubDocInfo> queryAllSubByInfoId(String infoId);
	
	List<SubDocInfo> queryAllSubInfo(Map<String, Object> map);

	SubDocInfo querySubDocInfoBySubIdAndInfoId(String subId, String infoId);

	void updateSubDocInfoById(SubDocInfo subDocInfo);
	List<SubDocInfo> queryTmingTaskList(Map<String, Object> map);
	List<SubDocInfo> NoFeedbackTmingTaskList();
	List<SubDocInfo> firstNoFeedbackTmingTaskList();
	List<SubDocInfo> notTransferredTmingTaskList();
	
	
	
	
}
