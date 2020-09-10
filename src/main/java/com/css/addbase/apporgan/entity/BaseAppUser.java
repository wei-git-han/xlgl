package com.css.addbase.apporgan.entity;

import java.io.Serializable;

/**
 * 人员表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2017-11-29 15:10:13
 */
public class BaseAppUser implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键
	private String id;
	//用户id
	private String userId;
	//删除标志
	private Integer isdelete;
	//更新时间
	private Long timestamp;
	//排序字段
	private Integer sort;
	//真实姓名
	private String truename;
	//更新类型
	private Integer type;
	//部门id
	private String organid;
	//帐号
	private String account;
	//联系方式
	private String mobile;
	//邮箱
	private String useremail;
	//等级
	private String seclevel;
	//性别(0:男，1:女)
	private String sex;
	
	private String telephone;

	// 0不在编，1在编
	private String sfzb;
	
	private String sfzw;

	private String baoming;

	//是否有效 0有效，1无效
	private String sfyx;

	//有效时间
	private String startTime;
	//失效时间
	private String endTime;
	//是否在位 0：不在，1:在位
	private String reign;
	//是否已读
	private String read;

	//是否参训
	private String isWork;
	//部门
	private String deptName;

	//延后原因
	private String reason;

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getIsWork() {
		return isWork;
	}

	public void setIsWork(String isWork) {
		this.isWork = isWork;
	}

	public String getRead() {
		return read;
	}

	public void setRead(String read) {
		this.read = read;
	}

	/**
	 * 设置：主键
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：主键
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
	 * 设置：删除标志
	 */
	public void setIsdelete(Integer isdelete) {
		this.isdelete = isdelete;
	}
	/**
	 * 获取：删除标志
	 */
	public Integer getIsdelete() {
		return isdelete;
	}
	/**
	 * 设置：更新时间
	 */
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	/**
	 * 获取：更新时间
	 */
	public Long getTimestamp() {
		return timestamp;
	}
	/**
	 * 设置：排序字段
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	/**
	 * 获取：排序字段
	 */
	public Integer getSort() {
		return sort;
	}
	/**
	 * 设置：真实姓名
	 */
	public void setTruename(String truename) {
		this.truename = truename;
	}
	/**
	 * 获取：真实姓名
	 */
	public String getTruename() {
		return truename;
	}
	/**
	 * 设置：更新类型
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：更新类型
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * 设置：部门id
	 */
	public void setOrganid(String organid) {
		this.organid = organid;
	}
	/**
	 * 获取：部门id
	 */
	public String getOrganid() {
		return organid;
	}
	/**
	 * 设置：帐号
	 */
	public void setAccount(String account) {
		this.account = account;
	}
	/**
	 * 获取：帐号
	 */
	public String getAccount() {
		return account;
	}
	/**
	 * 设置：联系方式
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * 获取：联系方式
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * 设置：邮箱
	 */
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	/**
	 * 获取：邮箱
	 */
	public String getUseremail() {
		return useremail;
	}
	/**
	 * 设置：等级
	 */
	public void setSeclevel(String seclevel) {
		this.seclevel = seclevel;
	}
	/**
	 * 获取：等级
	 */
	public String getSeclevel() {
		return seclevel;
	}
	/**
	 * 设置：性别(0:男，1:女)
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * 获取：性别(0:男，1:女)
	 */
	public String getSex() {
		return sex;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getSfzb() {
		return sfzb;
	}
	public void setSfzb(String sfzb) {
		this.sfzb = sfzb;
	}
	public String getSfzw() {
		return sfzw;
	}
	public void setSfzw(String sfzw) {
		this.sfzw = sfzw;
	}

	public String getBaoming() {
		return baoming;
	}

	public void setBaoming(String baoming) {
		this.baoming = baoming;
	}

	public String getSfyx() {
		return sfyx;
	}

	public void setSfyx(String sfyx) {
		this.sfyx = sfyx;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getReign() {
		return reign;
	}
	public void setReign(String reign) {
		this.reign = reign;
	}
	
	
}
