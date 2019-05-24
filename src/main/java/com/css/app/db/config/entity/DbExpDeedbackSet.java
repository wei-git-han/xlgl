package com.css.app.db.config.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 督办-反馈范例配置表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-05-24 15:06:41
 */
public class DbExpDeedbackSet implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键
	private String id;
	//范例名称
	private String expName;
	//创建人
	private String createdUser;
	//创建人ID
	private String createdUserId;
	//创建时间
	private Date createdTime;
	//修改人
	private String modifiedUser;
	//修改人ID
	private String modifiedUserId;
	//修改时间
	private Date modifiedTime;
	//备注（冗余字段1）
	private String remark;
	//备注（冗余字段2）
	private String flag;
	//范例内容
	private String expContent;

	/**
	 * 设置：主键
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：主键
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：范例名称
	 */
	public void setExpName(String expName) {
		this.expName = expName;
	}
	/**
	 * 获取：范例名称
	 */
	public String getExpName() {
		return expName;
	}
	/**
	 * 设置：创建人
	 */
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}
	/**
	 * 获取：创建人
	 */
	public String getCreatedUser() {
		return createdUser;
	}
	/**
	 * 设置：创建人ID
	 */
	public void setCreatedUserId(String createdUserId) {
		this.createdUserId = createdUserId;
	}
	/**
	 * 获取：创建人ID
	 */
	public String getCreatedUserId() {
		return createdUserId;
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
	 * 设置：修改人
	 */
	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}
	/**
	 * 获取：修改人
	 */
	public String getModifiedUser() {
		return modifiedUser;
	}
	/**
	 * 设置：修改人ID
	 */
	public void setModifiedUserId(String modifiedUserId) {
		this.modifiedUserId = modifiedUserId;
	}
	/**
	 * 获取：修改人ID
	 */
	public String getModifiedUserId() {
		return modifiedUserId;
	}
	/**
	 * 设置：修改时间
	 */
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getModifiedTime() {
		return modifiedTime;
	}
	/**
	 * 设置：备注（冗余字段1）
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注（冗余字段1）
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：备注（冗余字段2）
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}
	/**
	 * 获取：备注（冗余字段2）
	 */
	public String getFlag() {
		return flag;
	}
	public String getExpContent() {
		return expContent;
	}
	public void setExpContent(String expContent) {
		this.expContent = expContent;
	}
	
}
