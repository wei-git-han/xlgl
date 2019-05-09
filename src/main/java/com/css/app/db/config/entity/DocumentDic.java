package com.css.app.db.config.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 字典配置表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-19 15:23:36
 */
public class DocumentDic implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//唯一标识
	private String id;
	//键值
	private String value;
	//文字显示
	private String text;
	//字典标识
	private String dicType;
	//排序
	private Integer sort;
	//创建人id
	private String creatorId;
	//创建人
	private String creator;
	//创建时间
	private Date createdTime;
	//表格分类
	private Integer gridFlag;
	//排序
	private int tempValue;
	/**
	 * 设置：唯一标识
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：唯一标识
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：键值
	 */
	public void setValue(String value) {
		this.tempValue = Integer.parseInt(value);
		this.value = value;
	}
	/**
	 * 获取：键值
	 */
	public String getValue() {
		return value;
	}
	/**
	 * 设置：文字显示
	 */
	public void setText(String text) {
		this.text = text;
	}
	/**
	 * 获取：文字显示
	 */
	public String getText() {
		return text;
	}
	/**
	 * 设置：字典标识
	 */
	public void setDicType(String dicType) {
		this.dicType = dicType;
	}
	/**
	 * 获取：字典标识
	 */
	public String getDicType() {
		return dicType;
	}
	/**
	 * 设置：排序
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	/**
	 * 获取：排序
	 */
	public Integer getSort() {
		return sort;
	}
	/**
	 * 设置：创建人id
	 */
	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}
	/**
	 * 获取：创建人id
	 */
	public String getCreatorId() {
		return creatorId;
	}
	/**
	 * 设置：创建人
	 */
	public void setCreator(String creator) {
		this.creator = creator;
	}
	/**
	 * 获取：创建人
	 */
	public String getCreator() {
		return creator;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreatedTime() {
		return createdTime;
	}
	public Integer getGridFlag() {
		return gridFlag;
	}
	public void setGridFlag(Integer gridFlag) {
		this.gridFlag = gridFlag;
	}
	public int getTempValue() {
		return tempValue;
	}
	public void setTempValue(int tempValue) {
		this.tempValue = tempValue;
	}
	
}
