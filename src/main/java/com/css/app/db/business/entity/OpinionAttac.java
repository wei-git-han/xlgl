package com.css.app.db.business.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 意见反馈附件表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-25 15:10:36
 */
public class OpinionAttac implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//唯一标识
	private String id;
	//意见id
	private String opinionId;
	//文件名
	private String fileName;
	//对应文件服务上的ID
	private String fileServerId;
	//创建时间
	private Date createdTime;
	//排序
	private Integer sort;

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
	 * 设置：意见id
	 */
	public void setOpinionId(String opinionId) {
		this.opinionId = opinionId;
	}
	/**
	 * 获取：意见id
	 */
	public String getOpinionId() {
		return opinionId;
	}
	/**
	 * 设置：文件名
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * 获取：文件名
	 */
	public String getFileName() {
		return fileName;
	}
	/**
	 * 设置：对应文件服务上的ID
	 */
	public void setFileServerId(String fileServerId) {
		this.fileServerId = fileServerId;
	}
	/**
	 * 获取：对应文件服务上的ID
	 */
	public String getFileServerId() {
		return fileServerId;
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
	 * 设置：排序
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	/**
	 * 获取：排序
	 */
	public Integer getSort() {
		return sort;
	}
}
