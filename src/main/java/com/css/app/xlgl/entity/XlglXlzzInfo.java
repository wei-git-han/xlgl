package com.css.app.xlgl.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 训练组织基本信息表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-11 10:12:29
 */
public class XlglXlzzInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//讲堂标题
	private String title;
	//训练类型
	private String xltype;
	//主讲部门
	private String zjdept;
	//会议主题
	private String meetingIssue;
	//开始时间
	private String startTime;
	//结束时间
	private String endTime;
	//主讲人
	private String zjpersion;
	//线下地点
	private String xxadress;
	//会议链接
	private String meetingLine;
	//分发单位id
	private String todeptId;
	//分发单位名称
	private String todeptName;
	//课题详情
	private String content;
	//备注
	private String bz;
	//创建时间
	private Date createTime;
	//创建人
	private String creator;
	//状态
	private String status;

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
	 * 设置：讲堂标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：讲堂标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：训练类型
	 */
	public void setXltype(String xltype) {
		this.xltype = xltype;
	}
	/**
	 * 获取：训练类型
	 */
	public String getXltype() {
		return xltype;
	}
	/**
	 * 设置：主讲部门
	 */
	public void setZjdept(String zjdept) {
		this.zjdept = zjdept;
	}
	/**
	 * 获取：主讲部门
	 */
	public String getZjdept() {
		return zjdept;
	}
	/**
	 * 设置：会议主题
	 */
	public void setMeetingIssue(String meetingIssue) {
		this.meetingIssue = meetingIssue;
	}
	/**
	 * 获取：会议主题
	 */
	public String getMeetingIssue() {
		return meetingIssue;
	}
	/**
	 * 设置：开始时间
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	/**
	 * 获取：开始时间
	 */
	public String getStartTime() {
		return startTime;
	}
	/**
	 * 设置：结束时间
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	/**
	 * 获取：结束时间
	 */
	public String getEndTime() {
		return endTime;
	}
	/**
	 * 设置：主讲人
	 */
	public void setZjpersion(String zjpersion) {
		this.zjpersion = zjpersion;
	}
	/**
	 * 获取：主讲人
	 */
	public String getZjpersion() {
		return zjpersion;
	}
	/**
	 * 设置：线下地点
	 */
	public void setXxadress(String xxadress) {
		this.xxadress = xxadress;
	}
	/**
	 * 获取：线下地点
	 */
	public String getXxadress() {
		return xxadress;
	}
	/**
	 * 设置：会议链接
	 */
	public void setMeetingLine(String meetingLine) {
		this.meetingLine = meetingLine;
	}
	/**
	 * 获取：会议链接
	 */
	public String getMeetingLine() {
		return meetingLine;
	}
	/**
	 * 设置：分发单位id
	 */
	public void setTodeptId(String todeptId) {
		this.todeptId = todeptId;
	}
	/**
	 * 获取：分发单位id
	 */
	public String getTodeptId() {
		return todeptId;
	}
	/**
	 * 设置：分发单位名称
	 */
	public void setTodeptName(String todeptName) {
		this.todeptName = todeptName;
	}
	/**
	 * 获取：分发单位名称
	 */
	public String getTodeptName() {
		return todeptName;
	}
	/**
	 * 设置：课题详情
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：课题详情
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：备注
	 */
	public void setBz(String bz) {
		this.bz = bz;
	}
	/**
	 * 获取：备注
	 */
	public String getBz() {
		return bz;
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
	 * 设置：创建人
	 */
	public void setCreator(String creator) {
		this.creator = creator;
	}
	/**
	 * 获取：创建人
	 */
	public String getCreator() {
		return creator;
	}
	/**
	 * 设置：状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：状态
	 */
	public String getStatus() {
		return status;
	}
}
