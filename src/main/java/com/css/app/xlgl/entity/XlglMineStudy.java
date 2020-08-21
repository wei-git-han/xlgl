package com.css.app.xlgl.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 训练管理自学表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-21 14:37:00
 */
public class XlglMineStudy implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//姓名
	private String userName;
	//人员id
	private String userId;
	//分数
	private String score;
	//等级
	private String dj;
	//创建时间
	private Date createdTime;
	//部门名称
	private String deptName;
	//上传id，用于统计和删除
	private String upId;

	/**
	 * 设置：
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：姓名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：姓名
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 设置：人员id
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：人员id
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 设置：分数
	 */
	public void setScore(String score) {
		this.score = score;
	}
	/**
	 * 获取：分数
	 */
	public String getScore() {
		return score;
	}
	/**
	 * 设置：等级
	 */
	public void setDj(String dj) {
		this.dj = dj;
	}
	/**
	 * 获取：等级
	 */
	public String getDj() {
		return dj;
	}

	/**
	 * 设置：部门名称
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	/**
	 * 获取：部门名称
	 */
	public String getDeptName() {
		return deptName;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getUpId() {
		return upId;
	}

	public void setUpId(String upId) {
		this.upId = upId;
	}
}
