package com.css.app.xlgl.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 调查问卷题干的选项表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-11-20 18:52:05
 */
public class SurveyQuestionTopicOption implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private String id;
	//选项的排序，用于前端展示
	private Integer optionSequence;
	//选项内容
	private String optionContent;
	//创建时间
	private Date createTime;
	//备注信息
	private String remark;
	//题干表ID
	private String questionTopicId;
	//选票
	private String piao;
	//比例
	private String bili;

	public String getBili() {
		return bili;
	}

	public void setBili(String bili) {
		this.bili = bili;
	}

	public String getPiao() {
		return piao;
	}

	public void setPiao(String piao) {
		this.piao = piao;
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
	 * 设置：选项的排序，用于前端展示
	 */
	public void setOptionSequence(Integer optionSequence) {
		this.optionSequence = optionSequence;
	}
	/**
	 * 获取：选项的排序，用于前端展示
	 */
	public Integer getOptionSequence() {
		return optionSequence;
	}
	/**
	 * 设置：选项内容
	 */
	public void setOptionContent(String optionContent) {
		this.optionContent = optionContent;
	}
	/**
	 * 获取：选项内容
	 */
	public String getOptionContent() {
		return optionContent;
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
	 * 设置：题干表ID
	 */
	public void setQuestionTopicId(String questionTopicId) {
		this.questionTopicId = questionTopicId;
	}
	/**
	 * 获取：题干表ID
	 */
	public String getQuestionTopicId() {
		return questionTopicId;
	}
}
