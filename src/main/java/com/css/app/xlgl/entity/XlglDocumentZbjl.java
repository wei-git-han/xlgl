package com.css.app.xlgl.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 转办记录表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-11 11:11:27
 */
public class XlglDocumentZbjl implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//唯一标识
	private String id;
	//转办人id
	private String userId;
	//转办人部门
	private String deptName;
	//转办人部门id
	private String deptId;
	//转办时间
	private Date createdTime;
	//接收人的部门id
	private String receiverDeptId;
	//子分支主键
	private String subId;
	//转办人单位
	private String orgName;
	//转办人
	private String userName;
	//主文件id
	private String infoId;
	//接收人/部门ids
	private String receiverIds;
	//接收人/部门
	private String receiverNames;
	//接收人的部门
	private String receiverDeptName;

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
	 * 设置：转办人id
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：转办人id
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 设置：转办人部门
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	/**
	 * 获取：转办人部门
	 */
	public String getDeptName() {
		return deptName;
	}
	/**
	 * 设置：转办人部门id
	 */
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	/**
	 * 获取：转办人部门id
	 */
	public String getDeptId() {
		return deptId;
	}
	/**
	 * 设置：转办时间
	 */
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	/**
	 * 获取：转办时间
	 */
	public Date getCreatedTime() {
		return createdTime;
	}
	/**
	 * 设置：接收人的部门id
	 */
	public void setReceiverDeptId(String receiverDeptId) {
		this.receiverDeptId = receiverDeptId;
	}
	/**
	 * 获取：接收人的部门id
	 */
	public String getReceiverDeptId() {
		return receiverDeptId;
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
	 * 设置：转办人单位
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	/**
	 * 获取：转办人单位
	 */
	public String getOrgName() {
		return orgName;
	}
	/**
	 * 设置：转办人
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：转办人
	 */
	public String getUserName() {
		return userName;
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
	 * 设置：接收人/部门ids
	 */
	public void setReceiverIds(String receiverIds) {
		this.receiverIds = receiverIds;
	}
	/**
	 * 获取：接收人/部门ids
	 */
	public String getReceiverIds() {
		return receiverIds;
	}
	/**
	 * 设置：接收人/部门
	 */
	public void setReceiverNames(String receiverNames) {
		this.receiverNames = receiverNames;
	}
	/**
	 * 获取：接收人/部门
	 */
	public String getReceiverNames() {
		return receiverNames;
	}
	/**
	 * 设置：接收人的部门
	 */
	public void setReceiverDeptName(String receiverDeptName) {
		this.receiverDeptName = receiverDeptName;
	}
	/**
	 * 获取：接收人的部门
	 */
	public String getReceiverDeptName() {
		return receiverDeptName;
	}
}
