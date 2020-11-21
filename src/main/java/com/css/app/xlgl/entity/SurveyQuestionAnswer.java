package com.css.app.xlgl.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 调查问卷问答表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-11-20 19:22:47
 */
public class SurveyQuestionAnswer implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private String id;
	//创建用户ID
	private String createUserId;
	//选票
	private String piao;
	//选项ID
	private String questionTopicOptionId;
	//选项
	private String optionContent;
	//创建时间
	private Date createTime;
	//题干ID
	private String questionTopicId;
	//题干
	private String questionContent;
	//创建用户名称
	private String createUserName;
	//调查问卷ID
	private String surverQuestionId;

	public String getPiao() {
		return piao;
	}

	public void setPiao(String piao) {
		this.piao = piao;
	}

	public String getOptionContent() {
		return optionContent;
	}

	public void setOptionContent(String optionContent) {
		this.optionContent = optionContent;
	}

	public String getQuestionContent() {
		return questionContent;
	}

	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}

	/**
	 * 设置：主键ID
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：主键ID
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：创建用户ID
	 */
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}
	/**
	 * 获取：创建用户ID
	 */
	public String getCreateUserId() {
		return createUserId;
	}
	/**
	 * 设置：选项ID
	 */
	public void setQuestionTopicOptionId(String questionTopicOptionId) {
		this.questionTopicOptionId = questionTopicOptionId;
	}
	/**
	 * 获取：选项ID
	 */
	public String getQuestionTopicOptionId() {
		return questionTopicOptionId;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：题干ID
	 */
	public void setQuestionTopicId(String questionTopicId) {
		this.questionTopicId = questionTopicId;
	}
	/**
	 * 获取：题干ID
	 */
	public String getQuestionTopicId() {
		return questionTopicId;
	}
	/**
	 * 设置：创建用户名称
	 */
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}
	/**
	 * 获取：创建用户名称
	 */
	public String getCreateUserName() {
		return createUserName;
	}
	/**
	 * 设置：调查问卷ID
	 */
	public void setSurverQuestionId(String surverQuestionId) {
		this.surverQuestionId = surverQuestionId;
	}
	/**
	 * 获取：调查问卷ID
	 */
	public String getSurverQuestionId() {
		return surverQuestionId;
	}
}
