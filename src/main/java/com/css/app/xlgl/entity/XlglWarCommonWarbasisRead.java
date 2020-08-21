package com.css.app.xlgl.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;



/**
 * 军事训练-共同训练-战备基础已读人员表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-19 10:14:38
 */
public class XlglWarCommonWarbasisRead implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//已读人员id
	private String readUserId;
	//已读人员名称
	private String readUserName;
	//已读人员部门id
	private String readOrgId;
	//已读人员部门名称
	private String readOrgName;
	//已读时间
	private Date readDate;
	//军事训练-共同训练-战备基础id
	private String warbasisId;
	
	//封面上传
	private List<String> coverFileArray;
	//视频上传
	private List<String> videoFileArray;
	//附件上传
	private List<String> accessoryFileArray;
	//已读、未读标志 0：未读，1：已读
	private String readStatus;

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
	/**
	 * 设置：军事训练-共同训练-战备基础id
	 */
	public void setWarbasisId(String warbasisId) {
		this.warbasisId = warbasisId;
	}
	/**
	 * 获取：军事训练-共同训练-战备基础id
	 */
	public String getWarbasisId() {
		return warbasisId;
	}
}
