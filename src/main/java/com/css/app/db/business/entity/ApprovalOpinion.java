package com.css.app.db.business.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 审批意见表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-25 19:09:02
 */
public class ApprovalOpinion implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//唯一标识
	private String id;
	//创建人id
	private String userId;
	//创建人
	private String userName;
	//意见内容，签批的为文件id
	private String opinionContent;
	//创建时间
	private Date createdTime;
	//分支主id
	private String subId;
	//是否发布(给别的局或部首长看)
	private String showFlag;
	//流转类型（1：流转；2：审批完成；3：退回修改)
	private String trackingType;
	//办理反馈的teamId
	private String replyTeamId;
	//手写签批标识
	private String yjType;
	//意见组ID
	private String ideaGroupId;
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
	 * 设置：意见内容，签批的为文件id
	 */
	public void setOpinionContent(String opinionContent) {
		this.opinionContent = opinionContent;
	}
	/**
	 * 获取：意见内容，签批的为文件id
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
	 * 设置：分支主id
	 */
	public void setSubId(String subId) {
		this.subId = subId;
	}
	/**
	 * 获取：分支主id
	 */
	public String getSubId() {
		return subId;
	}
	/**
	 * 设置：是否发布
	 */
	public void setShowFlag(String showFlag) {
		this.showFlag = showFlag;
	}
	/**
	 * 获取：是否发布
	 */
	public String getShowFlag() {
		return showFlag;
	}
	public String getTrackingType() {
		return trackingType;
	}
	public void setTrackingType(String trackingType) {
		this.trackingType = trackingType;
	}
	public String getReplyTeamId() {
		return replyTeamId;
	}
	public void setReplyTeamId(String replyTeamId) {
		this.replyTeamId = replyTeamId;
	}
	public String getYjType() {
		return yjType;
	}
	public void setYjType(String yjType) {
		this.yjType = yjType;
	}
	public String getIdeaGroupId() {
		return ideaGroupId;
	}
	public void setIdeaGroupId(String ideaGroupId) {
		this.ideaGroupId = ideaGroupId;
	}	
}
