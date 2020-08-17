package com.css.app.xlgl.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 军事训练-共同训练-军事体育已读人员表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-17 10:26:33
 */
public class XlglWarCommonSportsRead implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//已读人员部门名称
	private String readOrgName;
	//军事训练-共同训练-军事体育id
	private String sportsId;
	//已读人员名称
	private String readUserName;
	//已读人员部门id
	private String readOrgId;
	//已读人员id
	private String readUserId;
	//已读时间
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
	 * 设置：已读人员部门名称
	 */
	public void setReadOrgName(String readOrgName) {
		this.readOrgName = readOrgName;
	}
	/**
	 * 获取：已读人员部门名称
	 */
	public String getReadOrgName() {
		return readOrgName;
	}
	/**
	 * 设置：军事训练-共同训练-军事体育id
	 */
	public void setSportsId(String sportsId) {
		this.sportsId = sportsId;
	}
	/**
	 * 获取：军事训练-共同训练-军事体育id
	 */
	public String getSportsId() {
		return sportsId;
	}
	/**
	 * 设置：已读人员名称
	 */
	public void setReadUserName(String readUserName) {
		this.readUserName = readUserName;
	}
	/**
	 * 获取：已读人员名称
	 */
	public String getReadUserName() {
		return readUserName;
	}
	/**
	 * 设置：已读人员部门id
	 */
	public void setReadOrgId(String readOrgId) {
		this.readOrgId = readOrgId;
	}
	/**
	 * 获取：已读人员部门id
	 */
	public String getReadOrgId() {
		return readOrgId;
	}
	/**
	 * 设置：已读人员id
	 */
	public void setReadUserId(String readUserId) {
		this.readUserId = readUserId;
	}
	/**
	 * 获取：已读人员id
	 */
	public String getReadUserId() {
		return readUserId;
	}
	/**
	 * 设置：已读时间
	 */
	public void setReadDate(Date readDate) {
		this.readDate = readDate;
	}
	/**
	 * 获取：已读时间
	 */
	public Date getReadDate() {
		return readDate;
	}
}
