package com.css.app.xlgl.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 调查问卷表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-11-20 18:45:19
 */
public class SurveyQuestion implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private String id;
	//调查问卷名称
	private String surveyName;
	//创建时间
	private Date createTime;
	//备注信息
	private String remark;
	//结束时间
	private Date endTime;
	//开始时间
	private Date startTime;


	//待填写数量
	private String waitFillCount;
	//已收集数量
	private String collectedCount;

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
	 * 设置：调查问卷名称
	 */
	public void setSurveyName(String surveyName) {
		this.surveyName = surveyName;
	}
	/**
	 * 获取：调查问卷名称
	 */
	public String getSurveyName() {
		return surveyName;
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
	 * 设置：结束时间
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	/**
	 * 获取：结束时间
	 */
	public Date getEndTime() {
		return endTime;
	}
	/**
	 * 设置：开始时间
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	/**
	 * 获取：开始时间
	 */
	public Date getStartTime() {
		return startTime;
	}

	public String getWaitFillCount() {
		return waitFillCount;
	}

	public void setWaitFillCount(String waitFillCount) {
		this.waitFillCount = waitFillCount;
	}

	public String getCollectedCount() {
		return collectedCount;
	}

	public void setCollectedCount(String collectedCount) {
		this.collectedCount = collectedCount;
	}
}
