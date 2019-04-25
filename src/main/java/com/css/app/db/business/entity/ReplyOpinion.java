package com.css.app.db.business.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 意见反馈表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-25 15:15:38
 */
public class ReplyOpinion implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//唯一标识
	private String id;
	//创建人id
	private String userId;
	//创建人
	private String userName;
	//意见反馈内容
	private String opinionContent;
	//创建时间
	private Date createdTime;
	//流转类型
	private String trackingType;
	//发布标识（0：临时1：发布）
	private String opVersion;

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
	 * 设置：意见反馈内容
	 */
	public void setOpinionContent(String opinionContent) {
		this.opinionContent = opinionContent;
	}
	/**
	 * 获取：意见反馈内容
	 */
	public String getOpinionContent() {
		return opinionContent;
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
	 * 设置：流转类型
	 */
	public void setTrackingType(String trackingType) {
		this.trackingType = trackingType;
	}
	/**
	 * 获取：流转类型
	 */
	public String getTrackingType() {
		return trackingType;
	}
	/**
	 * 设置：发布标识（0：临时1：发布）
	 */
	public void setOpVersion(String opVersion) {
		this.opVersion = opVersion;
	}
	/**
	 * 获取：发布标识（0：临时1：发布）
	 */
	public String getOpVersion() {
		return opVersion;
	}
}
