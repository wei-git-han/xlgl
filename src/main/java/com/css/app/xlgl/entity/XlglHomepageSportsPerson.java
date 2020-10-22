package com.css.app.xlgl.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 首页-体育活动-人员报名表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-10-16 10:45:44
 */
public class XlglHomepageSportsPerson implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//报名人员id
	private String userId;
	//创建人
	private String createUser;
	//报名人员名称
	private String userName;
	//首页-体育活动表id
	private String sportsId;
	//部门id
	private String organId;
	//部门名称
	private String organName;
	//创建时间
	private Date createDate;

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
	 * 设置：报名人员id
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：报名人员id
	 */
	public String getUserId() {
		return userId;
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
	 * 设置：报名人员名称
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：报名人员名称
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 设置：首页-体育活动表id
	 */
	public void setSportsId(String sportsId) {
		this.sportsId = sportsId;
	}
	/**
	 * 获取：首页-体育活动表id
	 */
	public String getSportsId() {
		return sportsId;
	}
	/**
	 * 设置：部门id
	 */
	public void setOrganId(String organId) {
		this.organId = organId;
	}
	/**
	 * 获取：部门id
	 */
	public String getOrganId() {
		return organId;
	}
	/**
	 * 设置：部门名称
	 */
	public void setOrganName(String organName) {
		this.organName = organName;
	}
	/**
	 * 获取：部门名称
	 */
	public String getOrganName() {
		return organName;
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
}
