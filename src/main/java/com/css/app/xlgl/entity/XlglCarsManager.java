package com.css.app.xlgl.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 训练管理车辆管理表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-17 14:15:57
 */
public class XlglCarsManager implements Serializable {
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

	public String getUploadUser() {
		return uploadUser;
	}

	public void setUploadUser(String uploadUser) {
		this.uploadUser = uploadUser;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getInfoId() {
		return infoId;
	}

	public void setInfoId(String infoId) {
		this.infoId = infoId;
	}

	public String getFileServerFormatId() {
		return fileServerFormatId;
	}

	public void setFileServerFormatId(String fileServerFormatId) {
		this.fileServerFormatId = fileServerFormatId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
}
