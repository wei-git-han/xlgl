package com.css.app.xlgl.sportstrain.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-07-30 18:21:45
 */
public class TGroupActivePublish implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//活动发布id
	private String actId;
	//标题
	private String title;
	//活动开始日期(年月日)
	private String activeFromDay;
	//活动结束日期(年月日)
	private String activeToDay;
	//活动开始时间(时分秒)
	private String activeFromTime;
	//活动结束时间(时分秒)
	private String activeToTime;
	//活动地点
	private String place;
	//活动截止日期
	private String activeEndingDay;
	//最大参加人数
	private String peopleNumber;
	//内容
	private String content;
	//
	private String uploadfile;
	//活动状态,0:活动进行中,1:名额已满,2.活动失效
	private String activeStatus;
	//活动发布创建时间
	private Date createTime;
	//活动内容修改时间
	private Date updateTime;
	private String applyStatus;
	

	public String getApplyStatus() {
		return applyStatus;
	}
	public void setApplyStatus(String applyStatus) {
		this.applyStatus = applyStatus;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**
	 * 设置：活动发布id
	 */
	public void setActId(String actId) {
		this.actId = actId;
	}
	/**
	 * 获取：活动发布id
	 */
	public String getActId() {
		return actId;
	}
	/**
	 * 设置：标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：活动开始日期(年月日)
	 */
	public void setActiveFromDay(String activeFromDay) {
		this.activeFromDay = activeFromDay;
	}
	/**
	 * 获取：活动开始日期(年月日)
	 */
	public String getActiveFromDay() {
		return activeFromDay;
	}
	/**
	 * 设置：活动结束日期(年月日)
	 */
	public void setActiveToDay(String activeToDay) {
		this.activeToDay = activeToDay;
	}
	/**
	 * 获取：活动结束日期(年月日)
	 */
	public String getActiveToDay() {
		return activeToDay;
	}
	/**
	 * 设置：活动开始时间(时分秒)
	 */
	public void setActiveFromTime(String activeFromTime) {
		this.activeFromTime = activeFromTime;
	}
	/**
	 * 获取：活动开始时间(时分秒)
	 */
	public String getActiveFromTime() {
		return activeFromTime;
	}
	/**
	 * 设置：活动结束时间(时分秒)
	 */
	public void setActiveToTime(String activeToTime) {
		this.activeToTime = activeToTime;
	}
	/**
	 * 获取：活动结束时间(时分秒)
	 */
	public String getActiveToTime() {
		return activeToTime;
	}
	/**
	 * 设置：活动地点
	 */
	public void setPlace(String place) {
		this.place = place;
	}
	/**
	 * 获取：活动地点
	 */
	public String getPlace() {
		return place;
	}
	/**
	 * 设置：活动截止日期
	 */
	public void setActiveEndingDay(String activeEndingDay) {
		this.activeEndingDay = activeEndingDay;
	}
	/**
	 * 获取：活动截止日期
	 */
	public String getActiveEndingDay() {
		return activeEndingDay;
	}
	/**
	 * 设置：最大参加人数
	 */
	public void setPeopleNumber(String peopleNumber) {
		this.peopleNumber = peopleNumber;
	}
	/**
	 * 获取：最大参加人数
	 */
	public String getPeopleNumber() {
		return peopleNumber;
	}
	/**
	 * 设置：内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：内容
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：
	 */
	public void setUploadfile(String uploadfile) {
		this.uploadfile = uploadfile;
	}
	/**
	 * 获取：
	 */
	public String getUploadfile() {
		return uploadfile;
	}
	/**
	 * 设置：活动状态,0:活动进行中,1:名额已满,2.活动失效
	 */
	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}
	/**
	 * 获取：活动状态,0:活动进行中,1:名额已满,2.活动失效
	 */
	public String getActiveStatus() {
		return activeStatus;
	}
	/**
	 * 设置：活动发布创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：活动发布创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：活动内容修改时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：活动内容修改时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
}
