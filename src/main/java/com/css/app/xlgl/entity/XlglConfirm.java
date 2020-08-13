package com.css.app.xlgl.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 训练管理确认表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-12 17:01:55
 */
public class XlglConfirm implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//确认的部门id
	private String deptid;
	//文id
	private String infoid;
	//确认部门的名称
	private String deptname;
	//0未确认，1确认
	private String status;
	//操作人ID
	private String creator;
	//创建时间
	private Date createdtime;
	//创建人名字
	private String creatorname;
	//报名人数
	private String confirmCount;
	//未报名人数
	private String noConfirmCount;
	//延后请假人数
	private String qjCount;

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
	 * 设置：确认的部门id
	 */
	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}
	/**
	 * 获取：确认的部门id
	 */
	public String getDeptid() {
		return deptid;
	}
	/**
	 * 设置：文id
	 */
	public void setInfoid(String infoid) {
		this.infoid = infoid;
	}
	/**
	 * 获取：文id
	 */
	public String getInfoid() {
		return infoid;
	}
	/**
	 * 设置：确认部门的名称
	 */
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	/**
	 * 获取：确认部门的名称
	 */
	public String getDeptname() {
		return deptname;
	}
	/**
	 * 设置：0未确认，1确认
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：0未确认，1确认
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：操作人ID
	 */
	public void setCreator(String creator) {
		this.creator = creator;
	}
	/**
	 * 获取：操作人ID
	 */
	public String getCreator() {
		return creator;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreatedtime(Date createdtime) {
		this.createdtime = createdtime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreatedtime() {
		return createdtime;
	}
	/**
	 * 设置：创建人名字
	 */
	public void setCreatorname(String creatorname) {
		this.creatorname = creatorname;
	}
	/**
	 * 获取：创建人名字
	 */
	public String getCreatorname() {
		return creatorname;
	}

	public String getConfirmCount() {
		return confirmCount;
	}

	public void setConfirmCount(String confirmCount) {
		this.confirmCount = confirmCount;
	}

	public String getNoConfirmCount() {
		return noConfirmCount;
	}

	public void setNoConfirmCount(String noConfirmCount) {
		this.noConfirmCount = noConfirmCount;
	}

	public String getQjCount() {
		return qjCount;
	}

	public void setQjCount(String qjCount) {
		this.qjCount = qjCount;
	}
}
