package com.css.app.xlgl.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 调查问卷题干类型表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-11-20 18:52:12
 */
public class SurveyQuestionTopicType implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private String id;
	//名称
	private String name;

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
	 * 设置：名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：名称
	 */
	public String getName() {
		return name;
	}
}
