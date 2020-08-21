package com.css.app.xlgl.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 日常管理-安全管理-安全检查
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-21 15:52:37
 */
public class XlglSafetyCheckup implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//文件id
	private String fileId;
	//文件名称
	private String fileName;
	//部门id
	private String orgId;
	//部门名称
	private String orgName;
	//创建人id
	private String createUser;
	//创建时间
	private Date createDate;
	//修改人id
	private String updateUser;
	//修改时间
	private Date updateDate;

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
	 * 设置：部门id
	 */
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	/**
	 * 获取：部门id
	 */
	public String getOrgId() {
		return orgId;
	}
	/**
	 * 设置：部门名称
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	/**
	 * 获取：部门名称
	 */
	public String getOrgName() {
		return orgName;
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
}
