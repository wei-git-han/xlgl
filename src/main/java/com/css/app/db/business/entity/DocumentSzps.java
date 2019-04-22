package com.css.app.db.business.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 首长批示内容表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-19 14:39:12
 */
public class DocumentSzps implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//唯一标识
	private String id;
	//首长id
	private String userId;
	//首长姓名
	private String userName;
	//首长批示
	private String leaderComment;
	//创建时间
	private String createdTime;
	//主文件id
	private String infoId;

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
	 * 设置：首长id
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：首长id
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 设置：首长姓名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：首长姓名
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 设置：首长批示
	 */
	public void setLeaderComment(String leaderComment) {
		this.leaderComment = leaderComment;
	}
	/**
	 * 获取：首长批示
	 */
	public String getLeaderComment() {
		return leaderComment;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}
	/**
	 * 获取：创建时间
	 */
	public String getCreatedTime() {
		return createdTime;
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
}
