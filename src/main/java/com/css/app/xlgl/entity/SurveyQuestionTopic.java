package com.css.app.xlgl.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 调查问卷题干表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-11-20 18:51:46
 */
public class SurveyQuestionTopic implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private String id;
	//最大选择数：多选题可选数，其他默认1
	private Integer choiceBlanksNumber;
	//所属调查问卷题目
	private String surveyQuestionId;
	//是否必填：1是，0否
	private Boolean required;
	//题目内容
	private String questionContent;
	//创建时间
	private Date createTime;
	//题干类型ID
	private String questionTopicTypeId;
	//备注信息
	private String remark;
	//题展示的题号的顺序，用于前台排序展示
	private Integer questionSequence;
	private String zong;

	public String getZong() {
		return zong;
	}

	public void setZong(String zong) {
		this.zong = zong;
	}

	//题干类型名称
	private String questionTopicTypeName;

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
	 * 设置：最大选择数：多选题可选数，其他默认1
	 */
	public void setChoiceBlanksNumber(Integer choiceBlanksNumber) {
		this.choiceBlanksNumber = choiceBlanksNumber;
	}
	/**
	 * 获取：最大选择数：多选题可选数，其他默认1
	 */
	public Integer getChoiceBlanksNumber() {
		return choiceBlanksNumber;
	}
	/**
	 * 设置：所属调查问卷题目
	 */
	public void setSurveyQuestionId(String surveyQuestionId) {
		this.surveyQuestionId = surveyQuestionId;
	}
	/**
	 * 获取：所属调查问卷题目
	 */
	public String getSurveyQuestionId() {
		return surveyQuestionId;
	}
	/**
	 * 设置：是否必填：1是，0否
	 */
	public void setRequired(Boolean required) {
		this.required = required;
	}
	/**
	 * 获取：是否必填：1是，0否
	 */
	public Boolean getRequired() {
		return required;
	}
	/**
	 * 设置：题目内容
	 */
	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}
	/**
	 * 获取：题目内容
	 */
	public String getQuestionContent() {
		return questionContent;
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
	 * 设置：题干类型ID
	 */
	public void setQuestionTopicTypeId(String questionTopicTypeId) {
		this.questionTopicTypeId = questionTopicTypeId;
	}
	/**
	 * 获取：题干类型ID
	 */
	public String getQuestionTopicTypeId() {
		return questionTopicTypeId;
	}
	/**
	 * 设置：备注信息
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注信息
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：题展示的题号的顺序，用于前台排序展示
	 */
	public void setQuestionSequence(Integer questionSequence) {
		this.questionSequence = questionSequence;
	}
	/**
	 * 获取：题展示的题号的顺序，用于前台排序展示
	 */
	public Integer getQuestionSequence() {
		return questionSequence;
	}

	public String getQuestionTopicTypeName() {
		return questionTopicTypeName;
	}

	public void setQuestionTopicTypeName(String questionTopicTypeName) {
		this.questionTopicTypeName = questionTopicTypeName;
	}
}
