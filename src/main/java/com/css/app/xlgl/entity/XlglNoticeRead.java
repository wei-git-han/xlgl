package com.css.app.xlgl.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 通知公告已阅人员表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-12 17:14:57
 */
public class XlglNoticeRead implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//已阅人员部门名称
	private String readOrgName;
	//已阅人员名称
	private String readUserName;
	//已阅人员部门id
	private String readOrgId;
	//通知公告id
	private String noticeId;
	//已阅人员id
	private String readUserId;
	//已阅时间
	private Date readDate;

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
	 * 设置：已阅人员部门名称
	 */
	public void setReadOrgName(String readOrgName) {
		this.readOrgName = readOrgName;
	}
	/**
	 * 获取：已阅人员部门名称
	 */
	public String getReadOrgName() {
		return readOrgName;
	}
	/**
	 * 设置：已阅人员名称
	 */
	public void setReadUserName(String readUserName) {
		this.readUserName = readUserName;
	}
	/**
	 * 获取：已阅人员名称
	 */
	public String getReadUserName() {
		return readUserName;
	}
	/**
	 * 设置：已阅人员部门id
	 */
	public void setReadOrgId(String readOrgId) {
		this.readOrgId = readOrgId;
	}
	/**
	 * 获取：已阅人员部门id
	 */
	public String getReadOrgId() {
		return readOrgId;
	}
	/**
	 * 设置：通知公告id
	 */
	public void setNoticeId(String noticeId) {
		this.noticeId = noticeId;
	}
	/**
	 * 获取：通知公告id
	 */
	public String getNoticeId() {
		return noticeId;
	}
	/**
	 * 设置：已阅人员id
	 */
	public void setReadUserId(String readUserId) {
		this.readUserId = readUserId;
	}
	/**
	 * 获取：已阅人员id
	 */
	public String getReadUserId() {
		return readUserId;
	}
	/**
	 * 设置：已阅时间
	 */
	public void setReadDate(Date readDate) {
		this.readDate = readDate;
	}
	/**
	 * 获取：已阅时间
	 */
	public Date getReadDate() {
		return readDate;
	}
}
