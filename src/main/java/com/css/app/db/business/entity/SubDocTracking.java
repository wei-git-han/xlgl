package com.css.app.db.business.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 局内流转记录表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-24 13:40:54
 */
public class SubDocTracking implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//唯一标识
	private String id;
	//子分支主键
	private String subId;
	//发送人id
	private String senderId;
	//发送人
	private String senderName;
	//发送人部门id
	private String senDeptId;
	//发送人部门
	private String senDeptName;
	//创建时间
	private Date createdTime;
	//接收人id
	private String receiverId;
	//接收人
	private String receiverName;
	//接收人部门id
	private String recDeptId;
	//接收人部门
	private String recDeptName;
	//流转类型标识（1：转办；2：审批流转；3：退回 ； 4：新一轮反馈流转到承办人）
	private String trackingType;
	//备用字段
	private String remark;
	//转办前状态（撤回时用）
	private Integer docStatus;
	//转办前承办人id（撤回时用）
	private String undertaker;

	public Integer getDocStatus() {
		return docStatus;
	}
	public void setDocStatus(Integer docStatus) {
		this.docStatus = docStatus;
	}
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
	 * 设置：子分支主键
	 */
	public void setSubId(String subId) {
		this.subId = subId;
	}
	/**
	 * 获取：子分支主键
	 */
	public String getSubId() {
		return subId;
	}
	/**
	 * 设置：发送人id
	 */
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}
	/**
	 * 获取：发送人id
	 */
	public String getSenderId() {
		return senderId;
	}
	/**
	 * 设置：发送人
	 */
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	/**
	 * 获取：发送人
	 */
	public String getSenderName() {
		return senderName;
	}
	/**
	 * 设置：发送人部门id
	 */
	public void setSenDeptId(String senDeptId) {
		this.senDeptId = senDeptId;
	}
	/**
	 * 获取：发送人部门id
	 */
	public String getSenDeptId() {
		return senDeptId;
	}
	/**
	 * 设置：发送人部门
	 */
	public void setSenDeptName(String senDeptName) {
		this.senDeptName = senDeptName;
	}
	/**
	 * 获取：发送人部门
	 */
	public String getSenDeptName() {
		return senDeptName;
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
	 * 设置：接收人id
	 */
	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}
	/**
	 * 获取：接收人id
	 */
	public String getReceiverId() {
		return receiverId;
	}
	/**
	 * 设置：接收人
	 */
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	/**
	 * 获取：接收人
	 */
	public String getReceiverName() {
		return receiverName;
	}
	/**
	 * 设置：接收人部门id
	 */
	public void setRecDeptId(String recDeptId) {
		this.recDeptId = recDeptId;
	}
	/**
	 * 获取：接收人部门id
	 */
	public String getRecDeptId() {
		return recDeptId;
	}
	/**
	 * 设置：接收人部门
	 */
	public void setRecDeptName(String recDeptName) {
		this.recDeptName = recDeptName;
	}
	/**
	 * 获取：接收人部门
	 */
	public String getRecDeptName() {
		return recDeptName;
	}
	/**
	 * 设置：流转类型标识（1：转办；2：审批；3：退回）
	 */
	public void setTrackingType(String trackingType) {
		this.trackingType = trackingType;
	}
	/**
	 * 获取：流转类型标识（1：转办；2：审批；3：退回）
	 */
	public String getTrackingType() {
		return trackingType;
	}
	/**
	 * 设置：备用字段
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备用字段
	 */
	public String getRemark() {
		return remark;
	}
	public String getUndertaker() {
		return undertaker;
	}
	public void setUndertaker(String undertaker) {
		this.undertaker = undertaker;
	}
}
