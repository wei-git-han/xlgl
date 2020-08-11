package com.css.app.xlgl.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 训练管理存图片表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-10 15:13:49
 */
public class XlglPicture implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//文id
	private String fileId;
	//图片id
	private String pictureId;
	//0置顶，1不置顶
	private String isFirst;
	//排序
	private String sort;

	private Date createTime;

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
	 * 设置：文id
	 */
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	/**
	 * 获取：文id
	 */
	public String getFileId() {
		return fileId;
	}
	/**
	 * 设置：图片id
	 */
	public void setPictureId(String pictureId) {
		this.pictureId = pictureId;
	}
	/**
	 * 获取：图片id
	 */
	public String getPictureId() {
		return pictureId;
	}
	/**
	 * 设置：0置顶，1不置顶
	 */
	public void setIsFirst(String isFirst) {
		this.isFirst = isFirst;
	}
	/**
	 * 获取：0置顶，1不置顶
	 */
	public String getIsFirst() {
		return isFirst;
	}
	/**
	 * 设置：排序
	 */
	public void setSort(String sort) {
		this.sort = sort;
	}
	/**
	 * 获取：排序
	 */
	public String getSort() {
		return sort;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
