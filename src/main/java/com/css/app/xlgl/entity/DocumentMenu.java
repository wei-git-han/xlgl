package com.css.app.xlgl.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-04 15:18:03
 */
public class DocumentMenu implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//
	private String menuName;
	//
	private Integer sort;
	//
	private Date createdTime;
	//
	private String lssjPage;
	//
	private String centerPage;
	//
	private String menuLevel;
	//
	private String isGrant;
	//
	private String displayName;
	//
	private String defaultPage;
	//
	private String parentId;

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
	 * 设置：
	 */
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	/**
	 * 获取：
	 */
	public String getMenuName() {
		return menuName;
	}
	/**
	 * 设置：
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	/**
	 * 获取：
	 */
	public Integer getSort() {
		return sort;
	}
	/**
	 * 设置：
	 */
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	/**
	 * 获取：
	 */
	public Date getCreatedTime() {
		return createdTime;
	}
	/**
	 * 设置：
	 */
	public void setLssjPage(String lssjPage) {
		this.lssjPage = lssjPage;
	}
	/**
	 * 获取：
	 */
	public String getLssjPage() {
		return lssjPage;
	}
	/**
	 * 设置：
	 */
	public void setCenterPage(String centerPage) {
		this.centerPage = centerPage;
	}
	/**
	 * 获取：
	 */
	public String getCenterPage() {
		return centerPage;
	}
	/**
	 * 设置：
	 */
	public void setMenuLevel(String menuLevel) {
		this.menuLevel = menuLevel;
	}
	/**
	 * 获取：
	 */
	public String getMenuLevel() {
		return menuLevel;
	}
	/**
	 * 设置：
	 */
	public void setIsGrant(String isGrant) {
		this.isGrant = isGrant;
	}
	/**
	 * 获取：
	 */
	public String getIsGrant() {
		return isGrant;
	}
	/**
	 * 设置：
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	/**
	 * 获取：
	 */
	public String getDisplayName() {
		return displayName;
	}
	/**
	 * 设置：
	 */
	public void setDefaultPage(String defaultPage) {
		this.defaultPage = defaultPage;
	}
	/**
	 * 获取：
	 */
	public String getDefaultPage() {
		return defaultPage;
	}
	/**
	 * 设置：
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	/**
	 * 获取：
	 */
	public String getParentId() {
		return parentId;
	}
}
