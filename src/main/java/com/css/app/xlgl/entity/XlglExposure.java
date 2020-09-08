package com.css.app.xlgl.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 首页-曝光台表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-09-08 10:41:01
 */
public class XlglExposure implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//修改时间
	private Date updateDate;
	//修改人id
	private String updateUserid;
	//创建人id
	private String createUserid;
	//创建人名称
	private String createUsername;
	//创建时间
	private Date createDate;
	//内容
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
	 * 设置：修改人id
	 */
	public void setUpdateUserid(String updateUserid) {
		this.updateUserid = updateUserid;
	}
	/**
	 * 获取：修改人id
	 */
	public String getUpdateUserid() {
		return updateUserid;
	}
	/**
	 * 设置：创建人id
	 */
	public void setCreateUserid(String createUserid) {
		this.createUserid = createUserid;
	}
	/**
	 * 获取：创建人id
	 */
	public String getCreateUserid() {
		return createUserid;
	}
	/**
	 * 设置：创建人名称
	 */
	public void setCreateUsername(String createUsername) {
		this.createUsername = createUsername;
	}
	/**
	 * 获取：创建人名称
	 */
	public String getCreateUsername() {
		return createUsername;
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
	 * 设置：内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：内容
	 */
	public String getContent() {
		return content;
	}
}
