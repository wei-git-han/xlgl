package com.css.app.xlgl.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 安全管理-安全分析与预案表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-20 16:39:37
 */
public class XlglSafetyAnalyse implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//上传人id
	private String uploadUser;
	//创建人id
	private String createUser;
	//修改时间
	private Date updateDate;
	//状态：0：未上传，1：已上传
	private String status;
	//上传时间
	private Date uploadDate;
	//部门id
	private String organId;
	//创建人名称
	private String createUsername;
	//修改人id
	private String updateUser;
	//部门名称
	private String organName;
	//创建时间
	private Date createDate;
	//主题
	private String content;
	//文件ids
	private String fileIds;
	//文件名称
	private String fileName;

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
	 * 设置：上传人id
	 */
	public void setUploadUser(String uploadUser) {
		this.uploadUser = uploadUser;
	}
	/**
	 * 获取：上传人id
	 */
	public String getUploadUser() {
		return uploadUser;
	}
	/**
	 * 设置：创建人id
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	/**
	 * 获取：创建人id
	 */
	public String getCreateUser() {
		return createUser;
	}
	/**
	 * 设置：修改时间
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getUpdateDate() {
		return updateDate;
	}
	/**
	 * 设置：状态：0：未上传，1：已上传
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：状态：0：未上传，1：已上传
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：上传时间
	 */
	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}
	/**
	 * 获取：上传时间
	 */
	public Date getUploadDate() {
		return uploadDate;
	}
	/**
	 * 设置：部门id
	 */
	public void setOrganId(String organId) {
		this.organId = organId;
	}
	/**
	 * 获取：部门id
	 */
	public String getOrganId() {
		return organId;
	}
	/**
	 * 设置：创建人名称
	 */
	public void setCreateUsername(String createUsername) {
		this.createUsername = createUsername;
	}
	/**
	 * 获取：创建人名称
	 */
	public String getCreateUsername() {
		return createUsername;
	}
	/**
	 * 设置：修改人id
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	/**
	 * 获取：修改人id
	 */
	public String getUpdateUser() {
		return updateUser;
	}
	/**
	 * 设置：部门名称
	 */
	public void setOrganName(String organName) {
		this.organName = organName;
	}
	/**
	 * 获取：部门名称
	 */
	public String getOrganName() {
		return organName;
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
	 * 设置：主题
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：主题
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 获取：文件ids
	 */
	public String getFileIds() {
		return fileIds;
	}
	/**
	 * 设置：文件ids
	 */
	public void setFileIds(String fileIds) {
		this.fileIds = fileIds;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
}
