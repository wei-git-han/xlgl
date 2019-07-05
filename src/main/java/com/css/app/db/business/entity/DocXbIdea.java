package com.css.app.db.business.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-07-05 14:56:19
 */
public class DocXbIdea implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//
	private String infoId;
	//
	private String subId;
	//
	private String userId;
	//
	private String userName;
	//
	private String feedBackIdea;
	//
	private Date createdTime;
	//
	private String groupId;

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
	 * 设置：
	 */
	public void setInfoId(String infoId) {
		this.infoId = infoId;
	}
	/**
	 * 获取：
	 */
	public String getInfoId() {
		return infoId;
	}
	/**
	 * 设置：
	 */
	public void setSubId(String subId) {
		this.subId = subId;
	}
	/**
	 * 获取：
	 */
	public String getSubId() {
		return subId;
	}
	/**
	 * 设置：
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 设置：
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 设置：
	 */
	public void setFeedBackIdea(String feedBackIdea) {
		this.feedBackIdea = feedBackIdea;
	}
	/**
	 * 获取：
	 */
	public String getFeedBackIdea() {
		return feedBackIdea;
	}
	/**
	 * 设置：
	 */
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	/**
	 * 获取：
	 */
	public Date getCreatedTime() {
		return createdTime;
	}
	/**
	 * 设置：
	 */
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	/**
	 * 获取：
	 */
	public String getGroupId() {
		return groupId;
	}
}
