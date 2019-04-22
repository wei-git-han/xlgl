package com.css.app.db.config.entity;

import java.io.Serializable;



/**
 * 角色设置表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-19 10:22:36
 */
public class RoleSet implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//唯一标识
	private String id;
	//用户id
	private String userId;
	//用户姓名
	private String userName;
	//用户部门id
	private String deptId;
	//用户部门
	private String deptName;
	//角色标识（1：局长；2：秘书；3：处长；4：参谋）
	private String roleFlag;
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
	 * 设置：用户id
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户id
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 设置：用户姓名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：用户姓名
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 设置：用户部门id
	 */
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	/**
	 * 获取：用户部门id
	 */
	public String getDeptId() {
		return deptId;
	}
	/**
	 * 设置：用户部门
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	/**
	 * 获取：用户部门
	 */
	public String getDeptName() {
		return deptName;
	}
	/**
	 * 设置：角色标识（1：局长；2：秘书；3：处长；4：参谋）
	 */
	public void setRoleFlag(String roleFlag) {
		this.roleFlag = roleFlag;
	}
	/**
	 * 获取：角色标识（1：局长；2：秘书；3：处长；4：参谋）
	 */
	public String getRoleFlag() {
		return roleFlag;
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
