package com.css.app.xlgl.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;



/**
 * 军事训练-战略训练
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-14 16:50:25
 */
public class XlglWarTactic implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//附件上传
	private String accessoryFile;
	//创建人
	private String createUser;
	//修改时间
	private String updateDate;
	//封面上传
	private String coverFile;
	//发布单位名称
	private String createOrganName;
	//目标要求
	private String target;
	//修改人
	private String updateUser;
	//发布时间
	private Date publishDate;
	//创建时间
	private Date createDate;
	//训练概述
	private String content;
	//训练标题
	private String tacticTitle;
	//视频上传
	private String videoFile;
	//发布单位id
	private String createOrganId;
	//观看次数
	private Integer viewNumber;
	
	
	//附件上传
	private List<String> accessoryFileArray;
	//已读、未读标志 0：未读，1：已读
	private String readStatus;
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
	 * 设置：附件上传
	 */
	public void setAccessoryFile(String accessoryFile) {
		this.accessoryFile = accessoryFile;
	}
	/**
	 * 获取：附件上传
	 */
	public String getAccessoryFile() {
		return accessoryFile;
	}
	/**
	 * 设置：创建人
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	/**
	 * 获取：创建人
	 */
	public String getCreateUser() {
		return createUser;
	}
	/**
	 * 设置：修改时间
	 */
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	/**
	 * 获取：修改时间
	 */
	public String getUpdateDate() {
		return updateDate;
	}
	/**
	 * 设置：封面上传
	 */
	public void setCoverFile(String coverFile) {
		this.coverFile = coverFile;
	}
	/**
	 * 获取：封面上传
	 */
	public String getCoverFile() {
		return coverFile;
	}
	/**
	 * 设置：发布单位名称
	 */
	public void setCreateOrganName(String createOrganName) {
		this.createOrganName = createOrganName;
	}
	/**
	 * 获取：发布单位名称
	 */
	public String getCreateOrganName() {
		return createOrganName;
	}
	/**
	 * 设置：目标要求
	 */
	public void setTarget(String target) {
		this.target = target;
	}
	/**
	 * 获取：目标要求
	 */
	public String getTarget() {
		return target;
	}
	/**
	 * 设置：修改人
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	/**
	 * 获取：修改人
	 */
	public String getUpdateUser() {
		return updateUser;
	}
	/**
	 * 设置：发布时间
	 */
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	/**
	 * 获取：发布时间
	 */
	public Date getPublishDate() {
		return publishDate;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateDate() {
		return createDate;
	}
	/**
	 * 设置：训练概述
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：训练概述
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：训练标题
	 */
	public void setTacticTitle(String tacticTitle) {
		this.tacticTitle = tacticTitle;
	}
	/**
	 * 获取：训练标题
	 */
	public String getTacticTitle() {
		return tacticTitle;
	}
	/**
	 * 设置：视频上传
	 */
	public void setVideoFile(String videoFile) {
		this.videoFile = videoFile;
	}
	/**
	 * 获取：视频上传
	 */
	public String getVideoFile() {
		return videoFile;
	}
	/**
	 * 设置：发布单位id
	 */
	public void setCreateOrganId(String createOrganId) {
		this.createOrganId = createOrganId;
	}
	/**
	 * 获取：发布单位id
	 */
	public String getCreateOrganId() {
		return createOrganId;
	}
	public List<String> getAccessoryFileArray() {
		return accessoryFileArray;
	}
	public void setAccessoryFileArray(List<String> accessoryFileArray) {
		this.accessoryFileArray = accessoryFileArray;
	}
	public Integer getViewNumber() {
		return viewNumber;
	}
	public void setViewNumber(Integer viewNumber) {
		this.viewNumber = viewNumber;
	}
	public String getReadStatus() {
		return readStatus;
	}
	public void setReadStatus(String readStatus) {
		this.readStatus = readStatus;
	}
	
	
}
