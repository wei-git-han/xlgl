package com.css.app.xlgl.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 训练考核-考核清单-主表用户答题表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-03 11:36:19
 */
public class XlglExamMainAnswer implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//考试信息基本表id
	private String examineId;
	//得分总分数
	private Integer fractionsum;
	//等级
	private String level;
	//用户部门id
	private String organId;
	//用户部门名称
	private String organName;
	//答题的用户id
	private String replyUserId;
	//答题的用户名称
	private String replyUserName;
	//创建时间
	private Date createDate;
	//修改时间
	private Date updateDate;
	//补考考状态0：没补考考，1:补考了
	private String makeupStatus;
	//补考id
	private String makeupExamineId;
	//状态 0：考试，1：练习
	private String status;
	//考试状态 0:没考，1:考了
	private String isNotExam;
	private String createUser;
	private String updateUser;
	//练习状态 0 模拟练习，1自主练习
	private String lianxiType;

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
	 * 设置：考试信息基本表id
	 */
	public void setExamineId(String examineId) {
		this.examineId = examineId;
	}
	/**
	 * 获取：考试信息基本表id
	 */
	public String getExamineId() {
		return examineId;
	}
	/**
	 * 设置：得分总分数
	 */
	public void setFractionsum(Integer fractionsum) {
		this.fractionsum = fractionsum;
	}
	/**
	 * 获取：得分总分数
	 */
	public Integer getFractionsum() {
		return fractionsum;
	}
	/**
	 * 设置：等级
	 */
	public void setLevel(String level) {
		this.level = level;
	}
	/**
	 * 获取：等级
	 */
	public String getLevel() {
		return level;
	}
	/**
	 * 设置：用户部门id
	 */
	public void setOrganId(String organId) {
		this.organId = organId;
	}
	/**
	 * 获取：用户部门id
	 */
	public String getOrganId() {
		return organId;
	}
	/**
	 * 设置：用户部门名称
	 */
	public void setOrganName(String organName) {
		this.organName = organName;
	}
	/**
	 * 获取：用户部门名称
	 */
	public String getOrganName() {
		return organName;
	}
	/**
	 * 设置：答题的用户id
	 */
	public void setReplyUserId(String replyUserId) {
		this.replyUserId = replyUserId;
	}
	/**
	 * 获取：答题的用户id
	 */
	public String getReplyUserId() {
		return replyUserId;
	}
	/**
	 * 设置：答题的用户名称
	 */
	public void setReplyUserName(String replyUserName) {
		this.replyUserName = replyUserName;
	}
	/**
	 * 获取：答题的用户名称
	 */
	public String getReplyUserName() {
		return replyUserName;
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
	 * 设置：补考状态0：没补考，1:补考了
	 */
	public void setMakeupStatus(String makeupStatus) {
		this.makeupStatus = makeupStatus;
	}
	/**
	 * 获取：补考状态0：没补考，1:补考了
	 */
	public String getMakeupStatus() {
		return makeupStatus;
	}
	/**
	 * 设置：补考id
	 */
	public void setMakeupExamineId(String makeupExamineId) {
		this.makeupExamineId = makeupExamineId;
	}
	/**
	 * 获取：补考id
	 */
	public String getMakeupExamineId() {
		return makeupExamineId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getIsNotExam() {
		return isNotExam;
	}
	public void setIsNotExam(String isNotExam) {
		this.isNotExam = isNotExam;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	public String getLianxiType() {
		return lianxiType;
	}
	public void setLianxiType(String lianxiType) {
		this.lianxiType = lianxiType;
	}
	
}
