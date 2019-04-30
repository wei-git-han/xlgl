package com.css.app.db.business.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 落实记录表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-28 19:32:01
 */
public class DocumentLsjl implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//唯一标识
	private String id;
	//创建人id
	private String userId;
	//创建人
	private String userName;
	//创建人部门id
	private String deptId;
	//创建人部门
	private String deptName;
	//创建时间
	private Date createdTime;
	//落实类型
	private String content;
	//主文件id
	private String infoId;
	//分支主文件id
	private String subId;

	/**
	 * 设置：唯一标识
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：唯一标识
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：创建人id
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：创建人id
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 设置：创建人
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：创建人
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 设置：创建人部门id
	 */
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	/**
	 * 获取：创建人部门id
	 */
	public String getDeptId() {
		return deptId;
	}
	/**
	 * 设置：创建人部门
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	/**
	 * 获取：创建人部门
	 */
	public String getDeptName() {
		return deptName;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreatedTime() {
		return createdTime;
	}
	/**
	 * 设置：落实类型
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：落实类型
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：主文件id
	 */
	public void setInfoId(String infoId) {
		this.infoId = infoId;
	}
	/**
	 * 获取：主文件id
	 */
	public String getInfoId() {
		return infoId;
	}
	public String getSubId() {
		return subId;
	}
	public void setSubId(String subId) {
		this.subId = subId;
	}
	
}
