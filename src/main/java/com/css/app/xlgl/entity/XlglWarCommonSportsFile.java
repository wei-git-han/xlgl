package com.css.app.xlgl.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 军事训练-共同训练-军事体育-文件表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-09-12 11:05:50
 */
public class XlglWarCommonSportsFile implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//文件id
	private String fileId;
	//文件名称
	private String fileName;
	//创建人
	private String createUser;
	//创建时间
	private Date createDate;
	//修改人
	private String updateUser;
	//修改时间
	private Date updateDate;
	//1:体型信息，2：科目成绩
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
	 * 设置：文件id
	 */
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	/**
	 * 获取：文件id
	 */
	public String getFileId() {
		return fileId;
	}
	/**
	 * 设置：文件名称
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * 获取：文件名称
	 */
	public String getFileName() {
		return fileName;
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
	 * 设置：1:体型信息，2：科目成绩
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：1:体型信息，2：科目成绩
	 */
	public String getType() {
		return type;
	}
}
