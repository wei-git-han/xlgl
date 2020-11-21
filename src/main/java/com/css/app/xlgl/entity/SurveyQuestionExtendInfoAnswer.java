package com.css.app.xlgl.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 调查问卷扩展表问答表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-11-21 14:59:21
 */
public class SurveyQuestionExtendInfoAnswer implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private String id;
	//问答用户ID
	private String currentUserId;
	//调查问卷扩展表ID
	private String extendInfoId;
	//问答时间
	private Date createTime;

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
	 * 设置：问答用户ID
	 */
	public void setCurrentUserId(String currentUserId) {
		this.currentUserId = currentUserId;
	}
	/**
	 * 获取：问答用户ID
	 */
	public String getCurrentUserId() {
		return currentUserId;
	}
	/**
	 * 设置：调查问卷扩展表ID
	 */
	public void setExtendInfoId(String extendInfoId) {
		this.extendInfoId = extendInfoId;
	}
	/**
	 * 获取：调查问卷扩展表ID
	 */
	public String getExtendInfoId() {
		return extendInfoId;
	}
	/**
	 * 设置：问答时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：问答时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
}
