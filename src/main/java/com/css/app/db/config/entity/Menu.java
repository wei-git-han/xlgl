package com.css.app.db.config.entity;

import java.io.Serializable;



/**
 * 菜单表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-19 10:22:36
 */
public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//唯一标识
	private String id;
	//菜单名称
	private String menuName;
	//默认页面路径
	private String defaultPage;
	//排序
	private Integer sort;
	//备注
	private String remark;

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
	 * 设置：菜单名称
	 */
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	/**
	 * 获取：菜单名称
	 */
	public String getMenuName() {
		return menuName;
	}
	/**
	 * 设置：默认页面路径
	 */
	public void setDefaultPage(String defaultPage) {
		this.defaultPage = defaultPage;
	}
	/**
	 * 获取：默认页面路径
	 */
	public String getDefaultPage() {
		return defaultPage;
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
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}
}
