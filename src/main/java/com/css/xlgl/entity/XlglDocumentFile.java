package com.css.xlgl.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 基本信息表携带文件的关系表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-07-28 13:15:37
 */
public class XlglDocumentFile implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//唯一标识
	private String id;
	//排序
	private Integer sort;
	//创建时间
	private Date createdTime;
	//文件服务流式ID
	private String fileServerStreamId;
	//版式文件下载路径
	private String downloadFormatUrl;
	//文件服务版式ID
	private String fileServerFormatId;
	//主文件id
	private String docInfoId;
	//文件名称
	private String fileName;

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
	 * 设置：文件服务流式ID
	 */
	public void setFileServerStreamId(String fileServerStreamId) {
		this.fileServerStreamId = fileServerStreamId;
	}
	/**
	 * 获取：文件服务流式ID
	 */
	public String getFileServerStreamId() {
		return fileServerStreamId;
	}
	/**
	 * 设置：版式文件下载路径
	 */
	public void setDownloadFormatUrl(String downloadFormatUrl) {
		this.downloadFormatUrl = downloadFormatUrl;
	}
	/**
	 * 获取：版式文件下载路径
	 */
	public String getDownloadFormatUrl() {
		return downloadFormatUrl;
	}
	/**
	 * 设置：文件服务版式ID
	 */
	public void setFileServerFormatId(String fileServerFormatId) {
		this.fileServerFormatId = fileServerFormatId;
	}
	/**
	 * 获取：文件服务版式ID
	 */
	public String getFileServerFormatId() {
		return fileServerFormatId;
	}
	/**
	 * 设置：主文件id
	 */
	public void setDocInfoId(String docInfoId) {
		this.docInfoId = docInfoId;
	}
	/**
	 * 获取：主文件id
	 */
	public String getDocInfoId() {
		return docInfoId;
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
