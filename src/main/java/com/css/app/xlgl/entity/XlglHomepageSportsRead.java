package com.css.app.xlgl.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 训练管理-体育活动-已读未读表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-10-26 13:22:50
 */
public class XlglHomepageSportsRead implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//报名人Id
	private String userId;
	//活动id
	private String sportId;
	//报名人名字
	private String userName;
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
	 * 设置：报名人Id
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：报名人Id
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 设置：活动id
	 */
	public void setSportId(String sportId) {
		this.sportId = sportId;
	}
	/**
	 * 获取：活动id
	 */
	public String getSportId() {
		return sportId;
	}
	/**
	 * 设置：报名人名字
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：报名人名字
	 */
	public String getUserName() {
		return userName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
