package com.css.app.db.business.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 协办人反馈意见表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-07-05 14:56:19
 */
public class DocXbInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//唯一标识
	private String id;
	//主文件ID
	private String infoId;
	//分支ID
	private String subId;
	//承办人ID
	private String undertakerId;
	//承办人名字
	private String undertakerName;
	//主办人部门ID
	private String deptId;
	//主办人部门名字
	private String deptName;
	//协办人ID
	private String receiverId;
	//协办人名字
	private String receiverName;
	//协办人部门ID
	private String receiverDeptId;
	//协办人部门名字
	private String receiverDeptName;
	//创建时间
	private Date createdTime;
	//每个部门ID所有协办人名字
	private String xieBanPersonNames;

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
	 * 设置：主文件ID
	 */
	public void setInfoId(String infoId) {
		this.infoId = infoId;
	}
	/**
	 * 获取：主文件ID
	 */
	public String getInfoId() {
		return infoId;
	}
	/**
	 * 设置：分支ID
	 */
	public void setSubId(String subId) {
		this.subId = subId;
	}
	/**
	 * 获取：分支ID
	 */
	public String getSubId() {
		return subId;
	}
	/**
	 * 设置：承办人ID
	 */
	public void setUndertakerId(String undertakerId) {
		this.undertakerId = undertakerId;
	}
	/**
	 * 获取：承办人ID
	 */
	public String getUndertakerId() {
		return undertakerId;
	}
	/**
	 * 设置：承办人名字
	 */
	public void setUndertakerName(String undertakerName) {
		this.undertakerName = undertakerName;
	}
	/**
	 * 获取：承办人名字
	 */
	public String getUndertakerName() {
		return undertakerName;
	}
	/**
	 * 设置：主办人部门ID
	 */
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	/**
	 * 获取：主办人部门ID
	 */
	public String getDeptId() {
		return deptId;
	}
	/**
	 * 设置：主办人部门名字
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	/**
	 * 获取：主办人部门名字
	 */
	public String getDeptName() {
		return deptName;
	}
	/**
	 * 设置：协办人ID
	 */
	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}
	/**
	 * 获取：协办人ID
	 */
	public String getReceiverId() {
		return receiverId;
	}
	/**
	 * 设置：协办人名字
	 */
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	/**
	 * 获取：协办人名字
	 */
	public String getReceiverName() {
		return receiverName;
	}
	/**
	 * 设置：协办人部门ID
	 */
	public void setReceiverDeptId(String receiverDeptId) {
		this.receiverDeptId = receiverDeptId;
	}
	/**
	 * 获取：协办人部门ID
	 */
	public String getReceiverDeptId() {
		return receiverDeptId;
	}
	/**
	 * 设置：协办人部门名字
	 */
	public void setReceiverDeptName(String receiverDeptName) {
		this.receiverDeptName = receiverDeptName;
	}
	/**
	 * 获取：协办人部门名字
	 */
	public String getReceiverDeptName() {
		return receiverDeptName;
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
	public String getXieBanPersonNames() {
		return xieBanPersonNames;
	}
	public void setXieBanPersonNames(String xieBanPersonNames) {
		this.xieBanPersonNames = xieBanPersonNames;
	}
}
