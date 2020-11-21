package com.css.app.xlgl.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 调查问卷扩展表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-11-21 14:46:59
 */
public class SurveyQuestionExtendInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private String id;
	//调查问卷表ID
	private String surveyQuestionId;
	//扩展类型：SEX; AGE; CAMP
	private String typeId;
	//备注信息
	private String remark;
	//扩展信息名称
	private String typeExtendName;
	//扩展信息类型：MAN, WOMEN; FORTY_UP, FORTY_DOWN......
	private String typeExtend;

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
	 * 设置：调查问卷表ID
	 */
	public void setSurveyQuestionId(String surveyQuestionId) {
		this.surveyQuestionId = surveyQuestionId;
	}
	/**
	 * 获取：调查问卷表ID
	 */
	public String getSurveyQuestionId() {
		return surveyQuestionId;
	}
	/**
	 * 设置：扩展类型：SEX; AGE; CAMP
	 */
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	/**
	 * 获取：扩展类型：SEX; AGE; CAMP
	 */
	public String getTypeId() {
		return typeId;
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
	 * 设置：扩展信息名称
	 */
	public void setTypeExtendName(String typeExtendName) {
		this.typeExtendName = typeExtendName;
	}
	/**
	 * 获取：扩展信息名称
	 */
	public String getTypeExtendName() {
		return typeExtendName;
	}
	/**
	 * 设置：扩展信息类型：MAN, WOMEN; FORTY_UP, FORTY_DOWN......
	 */
	public void setTypeExtend(String typeExtend) {
		this.typeExtend = typeExtend;
	}
	/**
	 * 获取：扩展信息类型：MAN, WOMEN; FORTY_UP, FORTY_DOWN......
	 */
	public String getTypeExtend() {
		return typeExtend;
	}
}
