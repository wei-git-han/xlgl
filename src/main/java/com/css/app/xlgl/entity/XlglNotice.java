package com.css.app.xlgl.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;



/**
 * 训练管理-通知公告表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-04 13:44:55
 */
public class XlglNotice implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键id
	private String id;
	//发布时间
	private Date releaseTime;
	//通知类型:通知、公告0：通知，1：公告
	private String type;
	//是否置顶
	private Integer isTop;
	//标题
	private String title;
	//发布部门id
	private String releaseOrganid;
	//发布部门
	private String releaseOrgan;
	//内容(带格式)
	private String content;
	//内容(不带格式)
	private String contenttext;
	//访问量
	private Integer viewNumber;
	
	
	//图片或视频的fileid
	private List<String> pictureIds;
	//
	private String releaseTimeStr;

	//发布人
	private String creator;
	
	//阅读人数
	private Integer userReadNumber;

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	/**
	 * 设置：主键id
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：主键id
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：发布时间
	 */
	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}
	/**
	 * 获取：发布时间
	 */
	public Date getReleaseTime() {
		return releaseTime;
	}
	/**
	 * 设置：通知类型:通知、公告
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：通知类型:通知、公告
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：是否置顶
	 */
	public void setIsTop(Integer isTop) {
		this.isTop = isTop;
	}
	/**
	 * 获取：是否置顶
	 */
	public Integer getIsTop() {
		return isTop;
	}
	/**
	 * 设置：标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：发布部门id
	 */
	public void setReleaseOrganid(String releaseOrganid) {
		this.releaseOrganid = releaseOrganid;
	}
	/**
	 * 获取：发布部门id
	 */
	public String getReleaseOrganid() {
		return releaseOrganid;
	}
	/**
	 * 设置：发布部门
	 */
	public void setReleaseOrgan(String releaseOrgan) {
		this.releaseOrgan = releaseOrgan;
	}
	/**
	 * 获取：发布部门
	 */
	public String getReleaseOrgan() {
		return releaseOrgan;
	}
	/**
	 * 设置：内容(带格式)
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：内容(带格式)
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：内容(不带格式)
	 */
	public void setContenttext(String contenttext) {
		this.contenttext = contenttext;
	}
	/**
	 * 获取：内容(不带格式)
	 */
	public String getContenttext() {
		return contenttext;
	}
	public Integer getViewNumber() {
		return viewNumber;
	}
	public void setViewNumber(Integer viewNumber) {
		this.viewNumber = viewNumber;
	}
	public List<String> getPictureIds() {
		return pictureIds;
	}
	public void setPictureIds(List<String> pictureIds) {
		this.pictureIds = pictureIds;
	}
	public String getReleaseTimeStr() {
		return releaseTimeStr;
	}
	public void setReleaseTimeStr(String releaseTimeStr) {
		this.releaseTimeStr = releaseTimeStr;
	}

	public Integer getUserReadNumber() {
		return userReadNumber;
	}

	public void setUserReadNumber(Integer userReadNumber) {
		this.userReadNumber = userReadNumber;
	}
	
	
}
