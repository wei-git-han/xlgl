package com.css.app.xlgl.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 考试模块模板文件id
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-11 15:17:38
 */
public class XlglExamFile implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//文件类型1：单选，2：多选，3：判断，4：填空
	private String fileType;
	//创建人
	private String createUser;
	//文件id
	private String fileId;
	//创建时间
	private Date createDate;
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
	 * 设置：文件类型1：单选，2：多选，3：判断，4：填空
	 */
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	/**
	 * 获取：文件类型1：单选，2：多选，3：判断，4：填空
	 */
	public String getFileType() {
		return fileType;
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
}
