package com.css.app.db.business.entity;

import java.io.Serializable;



/**
 * 确认已读表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-18 16:39:53
 */
public class DocumentRead implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//唯一标识
	private String id;
	//主文件id
	private String infoId;
	//分支主文件id
	private String subId;
	//阅读人id
	private String userId;
	//阅读人
	private String userName;
	//是否已读（1为已读）
	private Integer readFlag;

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
	/**
	 * 设置：分支主文件id
	 */
	public void setSubId(String subId) {
		this.subId = subId;
	}
	/**
	 * 获取：分支主文件id
	 */
	public String getSubId() {
		return subId;
	}
	/**
	 * 设置：阅读人id
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：阅读人id
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 设置：阅读人
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：阅读人
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 设置：是否已读（1为已读）
	 */
	public void setReadFlag(Integer readFlag) {
		this.readFlag = readFlag;
	}
	/**
	 * 获取：是否已读（1为已读）
	 */
	public Integer getReadFlag() {
		return readFlag;
	}
}
