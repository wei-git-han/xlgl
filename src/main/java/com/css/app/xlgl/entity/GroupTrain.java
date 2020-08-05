package com.css.app.xlgl.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-07-29 15:37:11
 */
public class GroupTrain implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String gtType;
	
	private String planTime;
	//
	private String id;
	//标题
	private String title;
	//内容
	private String content;
	//目标
	private String goal;
	//
	private String createdUserId;
	//
	private String createdUser;
	//创建时间
	private Date createdTime;
	//
	private String startDate;
	//
	private String endDate;
	//
	private String startTime;
	//组训计划时间
	private String endTime;
	//申请截止日期
	private Date applyEndTime;
	//组训地点
	private String place;
	//0:未发布，1：已发布
	private String type;
	//训练部门
	private String trainDept;
	//训练局id
	private String trainDeptId;

	public String getGtType() {
		return gtType;
	}
	public void setGtType(String gtType) {
		this.gtType = gtType;
	}
	public String getPlanTime() {
		return planTime;
	}
	public void setPlanTime(String planTime) {
		this.planTime = planTime;
	}
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
	 * 设置：目标
	 */
	public void setGoal(String goal) {
		this.goal = goal;
	}
	/**
	 * 获取：目标
	 */
	public String getGoal() {
		return goal;
	}
	/**
	 * 设置：
	 */
	public void setCreatedUserId(String createdUserId) {
		this.createdUserId = createdUserId;
	}
	/**
	 * 获取：
	 */
	public String getCreatedUserId() {
		return createdUserId;
	}
	/**
	 * 设置：
	 */
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}
	/**
	 * 获取：
	 */
	public String getCreatedUser() {
		return createdUser;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreatedTime() {
		return createdTime;
	}
	/**
	 * 设置：
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	/**
	 * 获取：
	 */
	public String getStartDate() {
		return startDate;
	}
	/**
	 * 设置：
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	/**
	 * 获取：
	 */
	public String getEndDate() {
		return endDate;
	}
	/**
	 * 设置：
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	/**
	 * 获取：
	 */
	public String getStartTime() {
		return startTime;
	}
	/**
	 * 设置：组训计划时间
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	/**
	 * 获取：组训计划时间
	 */
	public String getEndTime() {
		return endTime;
	}
	/**
	 * 设置：申请截止日期
	 */
	public void setApplyEndTime(Date applyEndTime) {
		this.applyEndTime = applyEndTime;
	}
	/**
	 * 获取：申请截止日期
	 */
	public Date getApplyEndTime() {
		return applyEndTime;
	}
	/**
	 * 设置：组训地点
	 */
	public void setPlace(String place) {
		this.place = place;
	}
	/**
	 * 获取：组训地点
	 */
	public String getPlace() {
		return place;
	}
	/**
	 * 设置：0:未发布，1：已发布
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：0:未发布，1：已发布
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：训练部门
	 */
	public void setTrainDept(String trainDept) {
		this.trainDept = trainDept;
	}
	/**
	 * 获取：训练部门
	 */
	public String getTrainDept() {
		return trainDept;
	}
	/**
	 * 设置：训练局id
	 */
	public void setTrainDeptId(String trainDeptId) {
		this.trainDeptId = trainDeptId;
	}
	/**
	 * 获取：训练局id
	 */
	public String getTrainDeptId() {
		return trainDeptId;
	}
}
