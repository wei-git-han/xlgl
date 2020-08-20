package com.css.app.xlgl.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 训练管理法规资料
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-20 20:18:42
 */
public class XlglRule implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//创建时间
	private Date createdTime;
	//上传人
	private String uploadUser;
	//文件标题
	private String fileName;
	//主文件id
	private String infoId;
	//文件服务流式ID
	private String fileServerFormatId;
	//类别
	private String type;

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
	 * 设置：上传人
	 */
	public void setUploadUser(String uploadUser) {
		this.uploadUser = uploadUser;
	}
	/**
	 * 获取：上传人
	 */
	public String getUploadUser() {
		return uploadUser;
	}
	/**
	 * 设置：文件标题
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * 获取：文件标题
	 */
	public String getFileName() {
		return fileName;
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
	 * 设置：文件服务流式ID
	 */
	public void setFileServerFormatId(String fileServerFormatId) {
		this.fileServerFormatId = fileServerFormatId;
	}
	/**
	 * 获取：文件服务流式ID
	 */
	public String getFileServerFormatId() {
		return fileServerFormatId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
