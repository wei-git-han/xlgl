package com.css.app.db.config.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 提醒管理表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-02-18 14:45:49
 */
public class RemindAdministration implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//提醒角色
	private String remindRole;
	//提醒时间
	private String remindTime;
	//提醒内容
	private String remindContent;
	//状态
	private String state;
	//创建人id
	private String creatorId;
	//创建人
	private String creator;
	//创建时间
	private Date createdTime;
	//备注
	private String remark;
	//区分局内未转办，未承办或未反馈，催填提醒
	private String type;
	
	//催填提醒开始时间
	private String startTime;
	//催填提醒结束时间
	private String endTime;

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
	 * 设置：提醒角色
	 */
	public void setRemindRole(String remindRole) {
		this.remindRole = remindRole;
	}
	/**
	 * 获取：提醒角色
	 */
	public String getRemindRole() {
		return remindRole;
	}
	/**
	 * 设置：提醒时间
	 */
	public void setRemindTime(String remindTime) {
		this.remindTime = remindTime;
	}
	/**
	 * 获取：提醒时间
	 */
	public String getRemindTime() {
		return remindTime;
	}
	/**
	 * 设置：提醒内容
	 */
	public void setRemindContent(String remindContent) {
		this.remindContent = remindContent;
	}
	/**
	 * 获取：提醒内容
	 */
	public String getRemindContent() {
		return remindContent;
	}
	/**
	 * 设置：状态
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * 获取：状态
	 */
	public String getState() {
		return state;
	}
	/**
	 * 设置：创建人id
	 */
	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}
	/**
	 * 获取：创建人id
	 */
	public String getCreatorId() {
		return creatorId;
	}
	/**
	 * 设置：创建人
	 */
	public void setCreator(String creator) {
		this.creator = creator;
	}
	/**
	 * 获取：创建人
	 */
	public String getCreator() {
		return creator;
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
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	
	
	
	
}
