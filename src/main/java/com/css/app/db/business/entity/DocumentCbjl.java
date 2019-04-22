package com.css.app.db.business.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 催办记录表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-18 16:40:16
 */
public class DocumentCbjl implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//唯一标识
	private String id;
	//主文件ID
	private String infoId;
	//催办人id
	private String userId;
	//催办人
	private String userName;
	//催办说明
	private String urgeContent;
	//催办时间
	private Date createdTime;
	//是否结束（0：未结束；1：已结束）
	private Integer finishFlag;

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
	 * 设置：催办人id
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：催办人id
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 设置：催办人
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：催办人
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 设置：催办说明
	 */
	public void setUrgeContent(String urgeContent) {
		this.urgeContent = urgeContent;
	}
	/**
	 * 获取：催办说明
	 */
	public String getUrgeContent() {
		return urgeContent;
	}
	/**
	 * 设置：催办时间
	 */
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	/**
	 * 获取：催办时间
	 */
	public Date getCreatedTime() {
		return createdTime;
	}
	/**
	 * 设置：是否结束（0：未结束；1：已结束）
	 */
	public void setFinishFlag(Integer finishFlag) {
		this.finishFlag = finishFlag;
	}
	/**
	 * 获取：是否结束（0：未结束；1：已结束）
	 */
	public Integer getFinishFlag() {
		return finishFlag;
	}
}
