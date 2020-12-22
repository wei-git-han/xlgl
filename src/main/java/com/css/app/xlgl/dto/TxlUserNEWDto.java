package com.css.app.xlgl.dto;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.JSONObject;

/**
 * 
 * 
 * @author 中软信息系统工程有限公司
 * @email
 * @date 2017-11-21 09:21:03
 */
public class TxlUserNEWDto implements Serializable {
	private static final long serialVersionUID = 1L;

	// 用户ID
	private String userid;
	//账号
	private String account;
	// 用户名字
	private String fullname;
	// 组织机构ID
	private String organid;
	// 排序ID
	private String orderid;
	// 是否删除
	private String isdelete;
	// 用户UUID
	private String useruuid;
	// 移动电话
	private String mobile;
	// 职位
	private String post;
	// 座机电话
	private String telephone;
	// 房间号
	private String address;
	private String dept;	
	// 组织机构Name
	private String organName;
	private String orgName;
	
	//是否显示
	private String isShow;//isShow 1： 在线 ， 2：请假 ，3：出差，4：异常
	// 移动电话2
	private String mobileTwo;
	// 座机电话2
	private String telephoneTwo;

	// 已休假天数
	private String QXJxiuJiaDays;
	// 应休天数
	private String QXJtotalDays;
	// 未请假天数
	private String QXJweixiujiaDays;
	// 请假类别
	private String QXJtype;
	// 请假开始时间
	private Date QXJstartDate;
	// 请假结束时间
	private Date QXJendDate;
	//当前所在省市
	private String QXJcities;
	//具体位置
	private String QXJaddress;
	//事由
	private String QXJmatters;
	//本月在线天数
	private String thisMonthDays;
	//累计在线天数
	private String thisYearDays;
	//在线状态
	private String status;
	
	//查询状态
	private String isSelect;
	
	public String getIsSelect() {
		return isSelect;
	}


	public void setIsSelect(String isSelect) {
		this.isSelect = isSelect;
	}


	public TxlUserNEWDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getFullname() {
		return fullname;
	}


	public void setFullname(String fullname) {
		this.fullname = fullname;
	}


	public String getOrganid() {
		return organid;
	}


	public void setOrganid(String organid) {
		this.organid = organid;
	}


	public String getOrderid() {
		return orderid;
	}


	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}


	public String getIsdelete() {
		return isdelete;
	}


	public void setIsdelete(String isdelete) {
		this.isdelete = isdelete;
	}


	public String getUseruuid() {
		return useruuid;
	}


	public void setUseruuid(String useruuid) {
		this.useruuid = useruuid;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getPost() {
		return post;
	}


	public void setPost(String post) {
		this.post = post;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getDept() {
		return dept;
	}


	public void setDept(String dept) {
		this.dept = dept;
	}


	public String getOrganName() {
		return organName;
	}


	public void setOrganName(String organName) {
		this.organName = organName;
	}


	public String getOrgName() {
		return orgName;
	}


	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}


	public String getIsShow() {
		return isShow;
	}


	public void setIsShow(String isShow) {
		this.isShow = isShow;
	}


	public String getMobileTwo() {
		return mobileTwo;
	}


	public void setMobileTwo(String mobileTwo) {
		this.mobileTwo = mobileTwo;
	}


	public String getTelephoneTwo() {
		return telephoneTwo;
	}


	public void setTelephoneTwo(String telephoneTwo) {
		this.telephoneTwo = telephoneTwo;
	}


	public String getQXJxiuJiaDays() {
		return QXJxiuJiaDays;
	}


	public void setQXJxiuJiaDays(String qXJxiuJiaDays) {
		QXJxiuJiaDays = qXJxiuJiaDays;
	}


	public String getQXJtotalDays() {
		return QXJtotalDays;
	}


	public void setQXJtotalDays(String qXJtotalDays) {
		QXJtotalDays = qXJtotalDays;
	}


	public String getQXJweixiujiaDays() {
		return QXJweixiujiaDays;
	}


	public void setQXJweixiujiaDays(String qXJweixiujiaDays) {
		QXJweixiujiaDays = qXJweixiujiaDays;
	}


	public String getQXJtype() {
		return QXJtype;
	}


	public void setQXJtype(String qXJtype) {
		QXJtype = qXJtype;
	}


	public Date getQXJstartDate() {
		return QXJstartDate;
	}


	public void setQXJstartDate(Date qXJstartDate) {
		QXJstartDate = qXJstartDate;
	}


	public Date getQXJendDate() {
		return QXJendDate;
	}


	public void setQXJendDate(Date qXJendDate) {
		QXJendDate = qXJendDate;
	}


	public String getQXJcities() {
		return QXJcities;
	}


	public void setQXJcities(String qXJcities) {
		QXJcities = qXJcities;
	}


	public String getQXJaddress() {
		return QXJaddress;
	}


	public void setQXJaddress(String qXJaddress) {
		QXJaddress = qXJaddress;
	}


	public String getQXJmatters() {
		return QXJmatters;
	}


	public void setQXJmatters(String qXJmatters) {
		QXJmatters = qXJmatters;
	}


	public String getThisMonthDays() {
		return thisMonthDays;
	}


	public void setThisMonthDays(String thisMonthDays) {
		this.thisMonthDays = thisMonthDays;
	}


	public String getThisYearDays() {
		return thisYearDays;
	}


	public void setThisYearDays(String thisYearDays) {
		this.thisYearDays = thisYearDays;
	}


	public String getAccount() {
		return account;
	}


	public void setAccount(String account) {
		this.account = account;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	




	
	
}
