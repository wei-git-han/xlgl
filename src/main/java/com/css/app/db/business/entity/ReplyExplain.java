package com.css.app.db.business.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 办理反馈表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-25 19:07:17
 */
public class ReplyExplain implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//唯一标识
	private String id;
	//创建人id
	private String userId;
	//创建人
	private String userName;
	//办理反馈内容
	private String replyContent;
	//创建时间
	private Date createdTime;
	//主文件id
	private String infoId;
	//分支主id
	private String subId;
	//是否发布(给别的局或部首长看)
	private String showFlag;
	//分局id
	private String subDeptId;
	//分局名称
	private String subDeptName;
	//反馈次数区别
	private String teamId;
	//临时反馈还是已发布
	private String reVersion;
	//1为承办人
	private String cbrFlag;
	//当前文件状态（1:办理中；2：办结；3：常态落实；）
	private String chooseStatus;

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
	 * 设置：创建人id
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：创建人id
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 设置：创建人
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：创建人
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 设置：办理反馈内容
	 */
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	/**
	 * 获取：办理反馈内容
	 */
	public String getReplyContent() {
		return replyContent;
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
	 * 设置：分支主id
	 */
	public void setSubId(String subId) {
		this.subId = subId;
	}
	/**
	 * 获取：分支主id
	 */
	public String getSubId() {
		return subId;
	}
	/**
	 * 设置：是否发布
	 */
	public void setShowFlag(String showFlag) {
		this.showFlag = showFlag;
	}
	/**
	 * 获取：是否发布
	 */
	public String getShowFlag() {
		return showFlag;
	}
	public String getSubDeptId() {
		return subDeptId;
	}
	public void setSubDeptId(String subDeptId) {
		this.subDeptId = subDeptId;
	}
	public String getSubDeptName() {
		return subDeptName;
	}
	public void setSubDeptName(String subDeptName) {
		this.subDeptName = subDeptName;
	}
	public String getTeamId() {
		return teamId;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	public String getReVersion() {
		return reVersion;
	}
	public void setReVersion(String reVersion) {
		this.reVersion = reVersion;
	}
	public String getCbrFlag() {
		return cbrFlag;
	}
	public void setCbrFlag(String cbrFlag) {
		this.cbrFlag = cbrFlag;
	}
	public String getChooseStatus() {
		return chooseStatus;
	}
	public void setChooseStatus(String chooseStatus) {
		this.chooseStatus = chooseStatus;
	}
	
}
