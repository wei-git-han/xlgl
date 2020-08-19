package com.css.app.xlgl.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 训练管理课题安排
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-18 18:32:15
 */
public class XlglKtap implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//文档id
	private String fileId;
	//文档名字
	private String fileName;
	//上传人
	private String creator;
	//创建时间
	private Date createdTime;

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
	 * 设置：文档id
	 */
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	/**
	 * 获取：文档id
	 */
	public String getFileId() {
		return fileId;
	}
	/**
	 * 设置：文档名字
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * 获取：文档名字
	 */
	public String getFileName() {
		return fileName;
	}
	/**
	 * 设置：上传人
	 */
	public void setCreator(String creator) {
		this.creator = creator;
	}
	/**
	 * 获取：上传人
	 */
	public String getCreator() {
		return creator;
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
}
