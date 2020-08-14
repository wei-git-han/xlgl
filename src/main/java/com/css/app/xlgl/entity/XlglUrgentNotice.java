package com.css.app.xlgl.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 紧急通知公告
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-13 14:35:46
 */
public class XlglUrgentNotice implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//接收通知单位id
	private String reDeptId;
	//接收通知单位名称
	private String reDeptName;
	//发布人
	private String creator;
	//发布时间
	private Date createdTime;
	//发布内容
	private String content;
	//发送单位id
	private String sendDeptId;

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
	 * 设置：接收通知单位id
	 */
	public void setReDeptId(String reDeptId) {
		this.reDeptId = reDeptId;
	}
	/**
	 * 获取：接收通知单位id
	 */
	public String getReDeptId() {
		return reDeptId;
	}
	/**
	 * 设置：接收通知单位名称
	 */
	public void setReDeptName(String reDeptName) {
		this.reDeptName = reDeptName;
	}
	/**
	 * 获取：接收通知单位名称
	 */
	public String getReDeptName() {
		return reDeptName;
	}
	/**
	 * 设置：发布人
	 */
	public void setCreator(String creator) {
		this.creator = creator;
	}
	/**
	 * 获取：发布人
	 */
	public String getCreator() {
		return creator;
	}
	/**
	 * 设置：发布时间
	 */
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	/**
	 * 获取：发布时间
	 */
	public Date getCreatedTime() {
		return createdTime;
	}
	/**
	 * 设置：发布内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：发布内容
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：发送单位id
	 */
	public void setSendDeptId(String sendDeptId) {
		this.sendDeptId = sendDeptId;
	}
	/**
	 * 获取：发送单位id
	 */
	public String getSendDeptId() {
		return sendDeptId;
	}
}
