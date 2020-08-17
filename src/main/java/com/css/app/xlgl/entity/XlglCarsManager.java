package com.css.app.xlgl.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 训练管理车辆管理表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-17 14:15:57
 */
public class XlglCarsManager implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//创建时间
	private Date creaetdTime;
	//题目
	private String title;

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
	 * 设置：创建时间
	 */
	public void setCreaetdTime(Date creaetdTime) {
		this.creaetdTime = creaetdTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreaetdTime() {
		return creaetdTime;
	}
	/**
	 * 设置：题目
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：题目
	 */
	public String getTitle() {
		return title;
	}
}
