package com.css.app.xlgl.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 首页-体育活动
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-10-16 10:45:44
 */
public class XlglHomepageSports implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//创建人id
	private String createUser;
	//活动结束时间
	private Date sportsEndTime;
	//修改时间
	private Date updateDate;
	//已报名的人数
	private Integer haveNumber;
	//待定-当前字段无使用,无定义
	private String status;
	//活动开始时间
	private Date sportsStartTime;
	//活动地点
	private String place;
	//修改人id
	private String updateUser;
	//创建时间
	private Date createDate;
	//需要的人数
	private Integer needNumber;
	//活动名称
	private String sportsName;
	//通知内容
	private String content;

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
	 * 设置：活动结束时间
	 */
	public void setSportsEndTime(Date sportsEndTime) {
		this.sportsEndTime = sportsEndTime;
	}
	/**
	 * 获取：活动结束时间
	 */
	public Date getSportsEndTime() {
		return sportsEndTime;
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
	/**
	 * 设置：已报名的人数
	 */
	public void setHaveNumber(Integer haveNumber) {
		this.haveNumber = haveNumber;
	}
	/**
	 * 获取：已报名的人数
	 */
	public Integer getHaveNumber() {
		return haveNumber;
	}
	/**
	 * 设置：待定-当前字段无使用,无定义
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：待定-当前字段无使用,无定义
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：活动开始时间
	 */
	public void setSportsStartTime(Date sportsStartTime) {
		this.sportsStartTime = sportsStartTime;
	}
	/**
	 * 获取：活动开始时间
	 */
	public Date getSportsStartTime() {
		return sportsStartTime;
	}
	/**
	 * 设置：活动地点
	 */
	public void setPlace(String place) {
		this.place = place;
	}
	/**
	 * 获取：活动地点
	 */
	public String getPlace() {
		return place;
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
	 * 设置：需要的人数
	 */
	public void setNeedNumber(Integer needNumber) {
		this.needNumber = needNumber;
	}
	/**
	 * 获取：需要的人数
	 */
	public Integer getNeedNumber() {
		return needNumber;
	}
	/**
	 * 设置：活动名称
	 */
	public void setSportsName(String sportsName) {
		this.sportsName = sportsName;
	}
	/**
	 * 获取：活动名称
	 */
	public String getSportsName() {
		return sportsName;
	}
	/**
	 * 设置：通知内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：通知内容
	 */
	public String getContent() {
		return content;
	}
}
