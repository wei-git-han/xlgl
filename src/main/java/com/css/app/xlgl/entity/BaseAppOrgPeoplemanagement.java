package com.css.app.xlgl.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 某局下新增处级单位
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2021-01-25 10:47:51
 */
public class BaseAppOrgPeoplemanagement implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//应在位人数
	private Integer answerReignNumber;
	//局级单位名称
	private String deptName;
	//局级单位id
	private String deptId;
	//处级单位名称
	private String name;
	//在位人数
	private Integer reignNumber;
	//修改日期
	private Date updateDate;
	//注册人数
	private Integer registerNumber;
	//创建日期
	private Date createDate;
	//
	private String id;
	//出差人数
	private Integer evectionNumber;
	//请假人数
	private Integer leaveNumber;
	//编辑按钮权限
	private String updateState;

	/**
	 * 设置：应在位人数
	 */
	public void setAnswerReignNumber(Integer answerReignNumber) {
		this.answerReignNumber = answerReignNumber;
	}
	/**
	 * 获取：应在位人数
	 */
	public Integer getAnswerReignNumber() {
		return answerReignNumber;
	}
	/**
	 * 设置：局级单位名称
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	/**
	 * 获取：局级单位名称
	 */
	public String getDeptName() {
		return deptName;
	}
	/**
	 * 设置：局级单位id
	 */
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	/**
	 * 获取：局级单位id
	 */
	public String getDeptId() {
		return deptId;
	}
	/**
	 * 设置：处级单位名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：处级单位名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：在位人数
	 */
	public void setReignNumber(Integer reignNumber) {
		this.reignNumber = reignNumber;
	}
	/**
	 * 获取：在位人数
	 */
	public Integer getReignNumber() {
		return reignNumber;
	}
	/**
	 * 设置：修改日期
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	/**
	 * 获取：修改日期
	 */
	public Date getUpdateDate() {
		return updateDate;
	}
	/**
	 * 设置：注册人数
	 */
	public void setRegisterNumber(Integer registerNumber) {
		this.registerNumber = registerNumber;
	}
	/**
	 * 获取：注册人数
	 */
	public Integer getRegisterNumber() {
		return registerNumber;
	}
	/**
	 * 设置：创建日期
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * 获取：创建日期
	 */
	public Date getCreateDate() {
		return createDate;
	}
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
	 * 设置：出差人数
	 */
	public void setEvectionNumber(Integer evectionNumber) {
		this.evectionNumber = evectionNumber;
	}
	/**
	 * 获取：出差人数
	 */
	public Integer getEvectionNumber() {
		return evectionNumber;
	}
	/**
	 * 设置：请假人数
	 */
	public void setLeaveNumber(Integer leaveNumber) {
		this.leaveNumber = leaveNumber;
	}
	/**
	 * 获取：请假人数
	 */
	public Integer getLeaveNumber() {
		return leaveNumber;
	}
	public String getUpdateState() {
		return updateState;
	}
	public void setUpdateState(String updateState) {
		this.updateState = updateState;
	}
	
}
