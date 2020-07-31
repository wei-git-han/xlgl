package com.css.app.xlgl.sportstrain.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-07-30 18:21:45
 */
public class TGroupApplyRecord implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//申请记录表主键
	private String id;
	//活动发布id
	private String actId;
	//用户id
	private String userId;
	//报名人姓名
	private String userName;
	//
	private String deptId;
	//报名人部门
	private String dept;
	//报名时间
	private String applyTime;
	//报名状态(0,未报名,1,已报名,2,无报名权限)
	private String applyStatus;
	//
	private String test2;
	
	private String peopleNumber;
	
	

	public String getPeopleNumber() {
		return peopleNumber;
	}
	public void setPeopleNumber(String peopleNumber) {
		this.peopleNumber = peopleNumber;
	}
	/**
	 * 设置：申请记录表主键
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：申请记录表主键
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：活动发布id
	 */
	public void setActId(String actId) {
		this.actId = actId;
	}
	/**
	 * 获取：活动发布id
	 */
	public String getActId() {
		return actId;
	}
	/**
	 * 设置：用户id
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户id
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 设置：报名人姓名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：报名人姓名
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 设置：
	 */
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	/**
	 * 获取：
	 */
	public String getDeptId() {
		return deptId;
	}
	/**
	 * 设置：报名人部门
	 */
	public void setDept(String dept) {
		this.dept = dept;
	}
	/**
	 * 获取：报名人部门
	 */
	public String getDept() {
		return dept;
	}
	/**
	 * 设置：报名时间
	 */
	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}
	/**
	 * 获取：报名时间
	 */
	public String getApplyTime() {
		return applyTime;
	}
	/**
	 * 设置：报名状态(0,未报名,1,已报名,2,无报名权限)
	 */
	public void setApplyStatus(String applyStatus) {
		this.applyStatus = applyStatus;
	}
	/**
	 * 获取：报名状态(0,未报名,1,已报名,2,无报名权限)
	 */
	public String getApplyStatus() {
		return applyStatus;
	}
	/**
	 * 设置：
	 */
	public void setTest2(String test2) {
		this.test2 = test2;
	}
	/**
	 * 获取：
	 */
	public String getTest2() {
		return test2;
	}
}
