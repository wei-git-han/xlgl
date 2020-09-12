package com.css.app.xlgl.entity;

import com.amazonaws.services.ec2.model.SummaryStatus;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * 
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-11 15:53:31
 */
public class XlglSubDocTracking implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//
	private String senderName;
	//
	private String senDeptId;
	//
	private String undertaker;
	//
	private Date createdTime;
	//
	private String receiverName;
	//
	private String receiverId;
	//
	private String subId;
	//
	private String ideaGroupId;
	//
	private String trackingType;
	//
	private String senDeptName;
	//
	private String remark;
	//
	private String recDeptId;
	//
	private Integer previousStatus;
	//
	private String senderId;
	//
	private String recDeptName;
	//0未读，1已读
	private String read;

	private String infoId;

	//报名 0未报名，1已报名,2延后
	private String baoming;

	//未报名原因
	private String reason;

	//标题名
	private String title;

	//是否参训 0未参训 1已参训
	private String isWork;

	//训练类型 0是大讲堂，1是日常军事训练
	private String xltype;
	//首页图片地址
	private String picutrePath;
	//训练开始时间
	private String exerciseTime;

	//本单位补充说明
	private String instraction;

	//排序
	private String sort;

	//是否上传了视频
	private String isUpload;

	//视频id集合
	private String listPictureIds;

	//type  0是未开始 1是历史学习
	private String type;

	//报名状态  read和baoming二合一
	//0已接收、1未接受、2已报名、3延后参训
	private String sumStatus;

	public String getSumStatus() {
		return sumStatus;
	}

	public void setSumStatus(String sumStatus) {
		this.sumStatus = sumStatus;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getListPictureIds() {
		return listPictureIds;
	}

	public void setListPictureIds(String listPictureIds) {
		this.listPictureIds = listPictureIds;
	}

	public String getIsUpload() {
		return isUpload;
	}

	public void setIsUpload(String isUpload) {
		this.isUpload = isUpload;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getXltype() {
		return xltype;
	}

	public void setXltype(String xltype) {
		this.xltype = xltype;
	}

	public String getPicutrePath() {
		return picutrePath;
	}

	public void setPicutrePath(String picutrePath) {
		this.picutrePath = picutrePath;
	}

	public String getExerciseTime() {
		return exerciseTime;
	}

	public void setExerciseTime(String exerciseTime) {
		this.exerciseTime = exerciseTime;
	}

	public String getInstraction() {
		return instraction;
	}

	public void setInstraction(String instraction) {
		this.instraction = instraction;
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
	 * 设置：
	 */
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	/**
	 * 获取：
	 */
	public String getSenderName() {
		return senderName;
	}
	/**
	 * 设置：
	 */
	public void setSenDeptId(String senDeptId) {
		this.senDeptId = senDeptId;
	}
	/**
	 * 获取：
	 */
	public String getSenDeptId() {
		return senDeptId;
	}
	/**
	 * 设置：
	 */
	public void setUndertaker(String undertaker) {
		this.undertaker = undertaker;
	}
	/**
	 * 获取：
	 */
	public String getUndertaker() {
		return undertaker;
	}
	/**
	 * 设置：
	 */
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	/**
	 * 获取：
	 */
	public Date getCreatedTime() {
		return createdTime;
	}
	/**
	 * 设置：
	 */
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	/**
	 * 获取：
	 */
	public String getReceiverName() {
		return receiverName;
	}
	/**
	 * 设置：
	 */
	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}
	/**
	 * 获取：
	 */
	public String getReceiverId() {
		return receiverId;
	}
	/**
	 * 设置：
	 */
	public void setSubId(String subId) {
		this.subId = subId;
	}
	/**
	 * 获取：
	 */
	public String getSubId() {
		return subId;
	}
	/**
	 * 设置：
	 */
	public void setIdeaGroupId(String ideaGroupId) {
		this.ideaGroupId = ideaGroupId;
	}
	/**
	 * 获取：
	 */
	public String getIdeaGroupId() {
		return ideaGroupId;
	}
	/**
	 * 设置：
	 */
	public void setTrackingType(String trackingType) {
		this.trackingType = trackingType;
	}
	/**
	 * 获取：
	 */
	public String getTrackingType() {
		return trackingType;
	}
	/**
	 * 设置：
	 */
	public void setSenDeptName(String senDeptName) {
		this.senDeptName = senDeptName;
	}
	/**
	 * 获取：
	 */
	public String getSenDeptName() {
		return senDeptName;
	}
	/**
	 * 设置：
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：
	 */
	public void setRecDeptId(String recDeptId) {
		this.recDeptId = recDeptId;
	}
	/**
	 * 获取：
	 */
	public String getRecDeptId() {
		return recDeptId;
	}
	/**
	 * 设置：
	 */
	public void setPreviousStatus(Integer previousStatus) {
		this.previousStatus = previousStatus;
	}
	/**
	 * 获取：
	 */
	public Integer getPreviousStatus() {
		return previousStatus;
	}
	/**
	 * 设置：
	 */
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}
	/**
	 * 获取：
	 */
	public String getSenderId() {
		return senderId;
	}
	/**
	 * 设置：
	 */
	public void setRecDeptName(String recDeptName) {
		this.recDeptName = recDeptName;
	}
	/**
	 * 获取：
	 */
	public String getRecDeptName() {
		return recDeptName;
	}

	public String getInfoId() {
		return infoId;
	}

	public void setInfoId(String infoId) {
		this.infoId = infoId;
	}

	public String getBaoming() {
		return baoming;
	}

	public void setBaoming(String baoming) {
		this.baoming = baoming;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getRead() {
		return read;
	}

	public void setRead(String read) {
		this.read = read;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsWork() {
		return isWork;
	}

	public void setIsWork(String isWork) {
		this.isWork = isWork;
	}
}
