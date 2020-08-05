package com.css.app.xlgl.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 训练管理-新闻动态表
 * @author admin
 *
 */

public class XlglNews implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//主键id
	private String id;
	//新闻标题
	private String title;
	//发布单位id
	private String releaseOrganid;
	//发布单位
	private String releaseOrgan;
	//发布人id
	private String releaseUserid;
	//发布人
	private String releaseUser;
	//发布日期
	private Date releaseDate;
	//新闻类型
	private String newsType;
	//新闻内容(带格式)
	private String content;
	//新闻内容(不带格式)
	private String contentText;
	//是否发布;0:未发布、1：已发布
	private String isRelease;
	//点击量
	private Integer hits;
	//图片地址
	private String picturePath;
	//是否置顶
	private Integer isTop;
	//发布部门id
	private String releaseDeptid;
	//发布部门
	private String releaseDept;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getReleaseOrganid() {
		return releaseOrganid;
	}
	public void setReleaseOrganid(String releaseOrganid) {
		this.releaseOrganid = releaseOrganid;
	}
	public String getReleaseOrgan() {
		return releaseOrgan;
	}
	public void setReleaseOrgan(String releaseOrgan) {
		this.releaseOrgan = releaseOrgan;
	}
	public String getReleaseUserid() {
		return releaseUserid;
	}
	public void setReleaseUserid(String releaseUserid) {
		this.releaseUserid = releaseUserid;
	}
	public String getReleaseUser() {
		return releaseUser;
	}
	public void setReleaseUser(String releaseUser) {
		this.releaseUser = releaseUser;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getNewsType() {
		return newsType;
	}
	public void setNewsType(String newsType) {
		this.newsType = newsType;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getContentText() {
		return contentText;
	}
	public void setContentText(String contentText) {
		this.contentText = contentText;
	}
	public String getIsRelease() {
		return isRelease;
	}
	public void setIsRelease(String isRelease) {
		this.isRelease = isRelease;
	}
	public Integer getHits() {
		return hits;
	}
	public void setHits(Integer hits) {
		this.hits = hits;
	}
	public String getPicturePath() {
		return picturePath;
	}
	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}
	public Integer getIsTop() {
		return isTop;
	}
	public void setIsTop(Integer isTop) {
		this.isTop = isTop;
	}
	public String getReleaseDeptid() {
		return releaseDeptid;
	}
	public void setReleaseDeptid(String releaseDeptid) {
		this.releaseDeptid = releaseDeptid;
	}
	public String getReleaseDept() {
		return releaseDept;
	}
	public void setReleaseDept(String releaseDept) {
		this.releaseDept = releaseDept;
	}
	
	
	
}
