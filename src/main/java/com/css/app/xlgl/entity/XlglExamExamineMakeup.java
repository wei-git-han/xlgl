package com.css.app.xlgl.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 补考表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-11 10:53:14
 */
public class XlglExamExamineMakeup implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//
	private String examineId;
	//记录是第几次补考
	private Integer sort;
	//考试结束时间
	private Date makeUpEndDate;
	//考试开始时间
	private Date makeUpStartDate;
	//
	private String createUser;
	//
	private Date updateDate;
	//
	private String updateUser;
	//
	private Date createDate;
	
	
	private String makeUpStartDateStr;
	private String makeUpEndDateStr;

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
	 * 设置：
	 */
	public void setExamineId(String examineId) {
		this.examineId = examineId;
	}
	/**
	 * 获取：
	 */
	public String getExamineId() {
		return examineId;
	}
	/**
	 * 设置：记录是第几次补考
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	/**
	 * 获取：记录是第几次补考
	 */
	public Integer getSort() {
		return sort;
	}
	/**
	 * 设置：
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	/**
	 * 获取：
	 */
	public String getCreateUser() {
		return createUser;
	}
	/**
	 * 设置：
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	/**
	 * 获取：
	 */
	public Date getUpdateDate() {
		return updateDate;
	}
	/**
	 * 设置：
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	/**
	 * 获取：
	 */
	public String getUpdateUser() {
		return updateUser;
	}
	/**
	 * 设置：
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * 获取：
	 */
	public Date getCreateDate() {
		return createDate;
	}
	public Date getMakeUpEndDate() {
		return makeUpEndDate;
	}
	public void setMakeUpEndDate(Date makeUpEndDate) {
		this.makeUpEndDate = makeUpEndDate;
	}
	public Date getMakeUpStartDate() {
		return makeUpStartDate;
	}
	public void setMakeUpStartDate(Date makeUpStartDate) {
		this.makeUpStartDate = makeUpStartDate;
	}
	public String getMakeUpStartDateStr() {
		return makeUpStartDateStr;
	}
	public void setMakeUpStartDateStr(String makeUpStartDateStr) {
		this.makeUpStartDateStr = makeUpStartDateStr;
	}
	public String getMakeUpEndDateStr() {
		return makeUpEndDateStr;
	}
	public void setMakeUpEndDateStr(String makeUpEndDateStr) {
		this.makeUpEndDateStr = makeUpEndDateStr;
	}
	
	
}
