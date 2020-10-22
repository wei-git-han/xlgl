package com.css.app.xlgl.config.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 消息提醒开关表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-10-15 16:14:46
 */
public class XlglMsgRemind implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//单位分钟，提前多少分钟提醒
	private Integer remindDate;
	//创建人ID
	private String createUser;
	//当前只有参训受训需要消息提醒，0：为参训受训
	private String type;
	//创建时间
	private Date createDate;
	//true为开启消息提醒，false未关闭提醒
	private String state;
	//提醒内容
	private String content;

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
	 * 设置：单位分钟，提前多少分钟提醒
	 */
	public void setRemindDate(Integer remindDate) {
		this.remindDate = remindDate;
	}
	/**
	 * 获取：单位分钟，提前多少分钟提醒
	 */
	public Integer getRemindDate() {
		return remindDate;
	}
	/**
	 * 设置：创建人ID
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	/**
	 * 获取：创建人ID
	 */
	public String getCreateUser() {
		return createUser;
	}
	/**
	 * 设置：当前只有参训受训需要消息提醒，0：为参训受训
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：当前只有参训受训需要消息提醒，0：为参训受训
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateDate() {
		return createDate;
	}
	/**
	 * 设置：true为开启消息提醒，false未关闭提醒
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * 获取：true为开启消息提醒，false未关闭提醒
	 */
	public String getState() {
		return state;
	}
	/**
	 * 设置：提醒内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：提醒内容
	 */
	public String getContent() {
		return content;
	}
}
