package com.css.app.xlgl.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 训练考核-考试组织-考试基本信息表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-07-30 10:56:43
 */
public class XlglExamExamine implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//考试名称
	private String examineName;
	//考试时长（单位：分钟）
	private String examineDate;
	//考试开始时间
	private Date examineStartDate;
	//总分数
	private Integer examineAllNumber;
	//科目表id
	private String examineSubjectId;
	//科目表名称
	private String examineSubjectName;
	//创建人
	private String createUser;
	//创建时间
	private Date createDate;
	//修改人
	private String updateUser;
	//修改时间
	private Date updateDate;
	//是否发布0:没发布，1发布
	private String issueStatus;
	//考试是否结束 0：没结束进行中，1：已结束已完结 2 :补考开始，99：未开始
	private String overStatus;
	//考试结束时间
	private Date examineEndDate;
	//发布时间
	private Date issueDate;
	//状态 0：考试，1：练习
	private String status;
	//练习状态 0：模拟练习， 1自主练习
	private String lianxiType;
	//每次考试仅能发起一次补考，（仅用于判断是否发起过补考，不与其他状态直接有关联）0：没补考，1：发起补考
	private String makeupStatus;
	
	//已参加人数
	private Integer numberInto;
	//未参加人数
	private Integer numberIntoNot;
	//参考率
	private String ratio;
	//考试开始时间
	private String examineStartDateStr;
	//考试结束时间
	private String examineEndDateStr;
	
	//用户考试状态  1：已完成，2：未考试，3：已补考
	private String userStatus;
	//补考id
	private String makeupId;
	//编辑人名称
	private String updateUserName;

	

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
	 * 设置：考试名称
	 */
	public void setExamineName(String examineName) {
		this.examineName = examineName;
	}
	/**
	 * 获取：考试名称
	 */
	public String getExamineName() {
		return examineName;
	}
	/**
	 * 设置：考试时长（单位：分钟）
	 */
	public void setExamineDate(String examineDate) {
		this.examineDate = examineDate;
	}
	/**
	 * 获取：考试时长（单位：分钟）
	 */
	public String getExamineDate() {
		return examineDate;
	}
	/**
	 * 设置：考试开始时间
	 */
	public void setExamineStartDate(Date examineStartDate) {
		this.examineStartDate = examineStartDate;
	}
	/**
	 * 获取：考试开始时间
	 */
	public Date getExamineStartDate() {
		return examineStartDate;
	}
	/**
	 * 设置：总分数
	 */
	public void setExamineAllNumber(Integer examineAllNumber) {
		this.examineAllNumber = examineAllNumber;
	}
	/**
	 * 获取：总分数
	 */
	public Integer getExamineAllNumber() {
		return examineAllNumber;
	}
	/**
	 * 设置：科目表id
	 */
	public void setExamineSubjectId(String examineSubjectId) {
		this.examineSubjectId = examineSubjectId;
	}
	/**
	 * 获取：科目表id
	 */
	public String getExamineSubjectId() {
		return examineSubjectId;
	}
	/**
	 * 设置：科目表名称
	 */
	public void setExamineSubjectName(String examineSubjectName) {
		this.examineSubjectName = examineSubjectName;
	}
	/**
	 * 获取：科目表名称
	 */
	public String getExamineSubjectName() {
		return examineSubjectName;
	}
	/**
	 * 设置：创建人
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	/**
	 * 获取：创建人
	 */
	public String getCreateUser() {
		return createUser;
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
	 * 设置：修改人
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	/**
	 * 获取：修改人
	 */
	public String getUpdateUser() {
		return updateUser;
	}
	/**
	 * 设置：修改时间
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getUpdateDate() {
		return updateDate;
	}
	/**
	 * 设置：是否发布0:没发布，1发布
	 */
	public void setIssueStatus(String issueStatus) {
		this.issueStatus = issueStatus;
	}
	/**
	 * 获取：是否发布0:没发布，1发布
	 */
	public String getIssueStatus() {
		return issueStatus;
	}
	public String getOverStatus() {
		return overStatus;
	}
	public void setOverStatus(String overStatus) {
		this.overStatus = overStatus;
	}
	public Date getExamineEndDate() {
		return examineEndDate;
	}
	public void setExamineEndDate(Date examineEndDate) {
		this.examineEndDate = examineEndDate;
	}
	public Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	public Integer getNumberInto() {
		return numberInto;
	}
	public void setNumberInto(Integer numberInto) {
		this.numberInto = numberInto;
	}
	public Integer getNumberIntoNot() {
		return numberIntoNot;
	}
	public void setNumberIntoNot(Integer numberIntoNot) {
		this.numberIntoNot = numberIntoNot;
	}
	public String getRatio() {
		return ratio;
	}
	public void setRatio(String ratio) {
		this.ratio = ratio;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getExamineStartDateStr() {
		return examineStartDateStr;
	}
	public void setExamineStartDateStr(String examineStartDateStr) {
		this.examineStartDateStr = examineStartDateStr;
	}
	public String getExamineEndDateStr() {
		return examineEndDateStr;
	}
	public void setExamineEndDateStr(String examineEndDateStr) {
		this.examineEndDateStr = examineEndDateStr;
	}
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	public String getMakeupId() {
		return makeupId;
	}
	public void setMakeupId(String makeupId) {
		this.makeupId = makeupId;
	}
	public String getUpdateUserName() {
		return updateUserName;
	}
	public void setUpdateUserName(String updateUserName) {
		this.updateUserName = updateUserName;
	}
	public String getLianxiType() {
		return lianxiType;
	}
	public void setLianxiType(String lianxiType) {
		this.lianxiType = lianxiType;
	}
	public String getMakeupStatus() {
		return makeupStatus;
	}
	public void setMakeupStatus(String makeupStatus) {
		this.makeupStatus = makeupStatus;
	}
	

}
