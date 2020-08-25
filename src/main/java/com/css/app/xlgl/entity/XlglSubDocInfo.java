package com.css.app.xlgl.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 各子分支主记录表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-11 11:04:56
 */
public class XlglSubDocInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//唯一标识
	private String id;
	//承办人手机号
	private String undertakerPhone;
	//承办人id
	private String undertaker;
	//第一次转办时间
	private Date createdTime;
	//更新时间（最近一次呈送、退回、审批完成、建议办结、常态落实时间）
	private Date updateTime;
	//分局名称
	private String subDeptName;
	//承办人名字
	private Integer ideaCount;
	//承办人提交选择的状态
	private String chooseStatus;
	//当前局是否正式反馈过
	private Integer firstReply;
	//主文件id
	private String infoId;
	//承办人
	private String undertakerName;
	//文件局内状态
	private Integer docStatus;
	//分局id
	private String subDeptId;
	//承办人ID
	private Integer ideaAddFlag;

	//是否分发
	private String isSend;

	//标题
	private String title;
	//训练类型
	private String xltype;
	//首页图片地址
	private String picturePath;
	//训练开始时间
	private String exerciseTime;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getXltype() {
		return xltype;
	}

	public void setXltype(String xltype) {
		this.xltype = xltype;
	}

	public String getPicturePath() {
		return picturePath;
	}

	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}

	public String getExerciseTime() {
		return exerciseTime;
	}

	public void setExerciseTime(String exerciseTime) {
		this.exerciseTime = exerciseTime;
	}

	/**
	 * 设置：唯一标识
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：唯一标识
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：承办人手机号
	 */
	public void setUndertakerPhone(String undertakerPhone) {
		this.undertakerPhone = undertakerPhone;
	}
	/**
	 * 获取：承办人手机号
	 */
	public String getUndertakerPhone() {
		return undertakerPhone;
	}
	/**
	 * 设置：承办人id
	 */
	public void setUndertaker(String undertaker) {
		this.undertaker = undertaker;
	}
	/**
	 * 获取：承办人id
	 */
	public String getUndertaker() {
		return undertaker;
	}
	/**
	 * 设置：第一次转办时间
	 */
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	/**
	 * 获取：第一次转办时间
	 */
	public Date getCreatedTime() {
		return createdTime;
	}
	/**
	 * 设置：更新时间（最近一次呈送、退回、审批完成、建议办结、常态落实时间）
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：更新时间（最近一次呈送、退回、审批完成、建议办结、常态落实时间）
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：分局名称
	 */
	public void setSubDeptName(String subDeptName) {
		this.subDeptName = subDeptName;
	}
	/**
	 * 获取：分局名称
	 */
	public String getSubDeptName() {
		return subDeptName;
	}
	/**
	 * 设置：承办人名字
	 */
	public void setIdeaCount(Integer ideaCount) {
		this.ideaCount = ideaCount;
	}
	/**
	 * 获取：承办人名字
	 */
	public Integer getIdeaCount() {
		return ideaCount;
	}
	/**
	 * 设置：承办人提交选择的状态
	 */
	public void setChooseStatus(String chooseStatus) {
		this.chooseStatus = chooseStatus;
	}
	/**
	 * 获取：承办人提交选择的状态
	 */
	public String getChooseStatus() {
		return chooseStatus;
	}
	/**
	 * 设置：当前局是否正式反馈过
	 */
	public void setFirstReply(Integer firstReply) {
		this.firstReply = firstReply;
	}
	/**
	 * 获取：当前局是否正式反馈过
	 */
	public Integer getFirstReply() {
		return firstReply;
	}
	/**
	 * 设置：主文件id
	 */
	public void setInfoId(String infoId) {
		this.infoId = infoId;
	}
	/**
	 * 获取：主文件id
	 */
	public String getInfoId() {
		return infoId;
	}
	/**
	 * 设置：承办人
	 */
	public void setUndertakerName(String undertakerName) {
		this.undertakerName = undertakerName;
	}
	/**
	 * 获取：承办人
	 */
	public String getUndertakerName() {
		return undertakerName;
	}
	/**
	 * 设置：文件局内状态
	 */
	public void setDocStatus(Integer docStatus) {
		this.docStatus = docStatus;
	}
	/**
	 * 获取：文件局内状态
	 */
	public Integer getDocStatus() {
		return docStatus;
	}
	/**
	 * 设置：分局id
	 */
	public void setSubDeptId(String subDeptId) {
		this.subDeptId = subDeptId;
	}
	/**
	 * 获取：分局id
	 */
	public String getSubDeptId() {
		return subDeptId;
	}
	/**
	 * 设置：承办人ID
	 */
	public void setIdeaAddFlag(Integer ideaAddFlag) {
		this.ideaAddFlag = ideaAddFlag;
	}
	/**
	 * 获取：承办人ID
	 */
	public Integer getIdeaAddFlag() {
		return ideaAddFlag;
	}

	public String getIsSend() {
		return isSend;
	}

	public void setIsSend(String isSend) {
		this.isSend = isSend;
	}
}
