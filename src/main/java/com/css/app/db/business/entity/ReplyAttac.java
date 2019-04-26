package com.css.app.db.business.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 办理反馈附件表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-25 19:07:17
 */
public class ReplyAttac implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//唯一标识
	private String id;
	//分支主id
	private String keyId;
	//文件名
	private String fileName;
	//对应文件服务上的ID
	private String fileServerId;
	//创建时间
	private Date createdTime;
	//反馈teamId
	private String replyTeamId;

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
	 * 设置：分支主id
	 */
	public void setKeyId(String keyId) {
		this.keyId = keyId;
	}
	/**
	 * 获取：分支主id
	 */
	public String getKeyId() {
		return keyId;
	}
	/**
	 * 设置：文件名
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * 获取：文件名
	 */
	public String getFileName() {
		return fileName;
	}
	/**
	 * 设置：对应文件服务上的ID
	 */
	public void setFileServerId(String fileServerId) {
		this.fileServerId = fileServerId;
	}
	/**
	 * 获取：对应文件服务上的ID
	 */
	public String getFileServerId() {
		return fileServerId;
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
	public String getReplyTeamId() {
		return replyTeamId;
	}
	public void setReplyTeamId(String replyTeamId) {
		this.replyTeamId = replyTeamId;
	}
	
}
