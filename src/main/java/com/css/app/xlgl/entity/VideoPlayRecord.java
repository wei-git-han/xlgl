package com.css.app.xlgl.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 视频播放记录表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-09-22 15:00:50
 */
public class VideoPlayRecord implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//文件id
	private String fileId;
	//视频id
	private String videoId;
	//播放人id
	private String userId;
	//视频总时间
	private String sumTime;
	//视频播放当前时间
	private String curentTime;
	//创建时间
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
	 * 设置：视频id
	 */
	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}
	/**
	 * 获取：视频id
	 */
	public String getVideoId() {
		return videoId;
	}
	/**
	 * 设置：播放人id
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：播放人id
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 设置：视频总时间
	 */
	public void setSumTime(String sumTime) {
		this.sumTime = sumTime;
	}
	/**
	 * 获取：视频总时间
	 */
	public String getSumTime() {
		return sumTime;
	}
	/**
	 * 设置：视频播放当前时间
	 */
	public void setCurentTime(String curentTime) {
		this.curentTime = curentTime;
	}
	/**
	 * 获取：视频播放当前时间
	 */
	public String getCurentTime() {
		return curentTime;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
}
