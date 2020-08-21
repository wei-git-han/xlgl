package com.css.app.xlgl.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 军事体育上传记录
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-21 14:13:24
 */
public class XlglPhysicalRecord implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//上传时间
	private Date createdTime;
	//上传人id
	private String upUserId;
	//上传人名字
	private String upUserName;
	//上传人部门
	private String upDeptName;

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
	 * 设置：上传时间
	 */
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	/**
	 * 获取：上传时间
	 */
	public Date getCreatedTime() {
		return createdTime;
	}
	/**
	 * 设置：上传人id
	 */
	public void setUpUserId(String upUserId) {
		this.upUserId = upUserId;
	}
	/**
	 * 获取：上传人id
	 */
	public String getUpUserId() {
		return upUserId;
	}
	/**
	 * 设置：上传人名字
	 */
	public void setUpUserName(String upUserName) {
		this.upUserName = upUserName;
	}
	/**
	 * 获取：上传人名字
	 */
	public String getUpUserName() {
		return upUserName;
	}
	/**
	 * 设置：上传人部门
	 */
	public void setUpDeptName(String upDeptName) {
		this.upDeptName = upDeptName;
	}
	/**
	 * 获取：上传人部门
	 */
	public String getUpDeptName() {
		return upDeptName;
	}
}
