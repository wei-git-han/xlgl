package com.css.app.xlgl.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 自学上传记录
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-21 14:42:54
 */
public class XlglStudyRecord implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//上传人
	private String userId;
	//上传人名字
	private String userName;
	//上传人部门名称
	private String deptName;
	//上传时间
	private Date createdTime;
	//分数
	private String score;
	//等级
	private String judge;

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getJudge() {
		return judge;
	}

	public void setJudge(String judge) {
		this.judge = judge;
	}

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
	 * 设置：上传人
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：上传人
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 设置：上传人名字
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：上传人名字
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 设置：上传人部门名称
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	/**
	 * 获取：上传人部门名称
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
}
