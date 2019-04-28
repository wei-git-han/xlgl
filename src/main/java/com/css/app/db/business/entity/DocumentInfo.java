package com.css.app.db.business.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 督办基本信息表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-18 16:34:38
 */
public class DocumentInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//唯一标识
	private String id;
	//文件标题
	private String docTitle;
	//密级ID
	private String securityId;
	//密级
	private String securityClassification;
	//紧急程度ID
	private String urgencyId;
	//紧急程度
	private String urgencyDegree;
	//文件号
	private String docCode;
	//军委办件号
	private String banjianNumber;
	//登记人ID
	private String userId;
	//登记人
	private String userName;
	//登记时间
	private String applyTime;
	//印发日期
	private String printDate;
	//工作分工内容
	private String jobContent;
	//部管理员第一次转办时间
	private Date firstZbTime;
	//已读首长ids
	private String szReadIds;
	//催办标识
	private String cuibanFlag = "0";
	//文件类型id
	private String docTypeId;
	//文件类型
	private String docTypeName;
	//创建时间
	private Date createdTime;
	//办理反馈状态
	private Integer status = 0; 
	//完成时间
	private Date finishTime;
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
	 * 设置：文件标题
	 */
	public void setDocTitle(String docTitle) {
		this.docTitle = docTitle;
	}
	/**
	 * 获取：文件标题
	 */
	public String getDocTitle() {
		return docTitle;
	}
	/**
	 * 设置：密级ID
	 */
	public void setSecurityId(String securityId) {
		this.securityId = securityId;
	}
	/**
	 * 获取：密级ID
	 */
	public String getSecurityId() {
		return securityId;
	}
	/**
	 * 设置：密级
	 */
	public void setSecurityClassification(String securityClassification) {
		this.securityClassification = securityClassification;
	}
	/**
	 * 获取：密级
	 */
	public String getSecurityClassification() {
		return securityClassification;
	}
	/**
	 * 设置：紧急程度ID
	 */
	public void setUrgencyId(String urgencyId) {
		this.urgencyId = urgencyId;
	}
	/**
	 * 获取：紧急程度ID
	 */
	public String getUrgencyId() {
		return urgencyId;
	}
	/**
	 * 设置：紧急程度
	 */
	public void setUrgencyDegree(String urgencyDegree) {
		this.urgencyDegree = urgencyDegree;
	}
	/**
	 * 获取：紧急程度
	 */
	public String getUrgencyDegree() {
		return urgencyDegree;
	}
	/**
	 * 设置：文件号
	 */
	public void setDocCode(String docCode) {
		this.docCode = docCode;
	}
	/**
	 * 获取：文件号
	 */
	public String getDocCode() {
		return docCode;
	}
	/**
	 * 设置：军委办件号
	 */
	public void setBanjianNumber(String banjianNumber) {
		this.banjianNumber = banjianNumber;
	}
	/**
	 * 获取：军委办件号
	 */
	public String getBanjianNumber() {
		return banjianNumber;
	}
	/**
	 * 设置：登记人ID
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：登记人ID
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 设置：登记人
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：登记人
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 设置：登记时间
	 */
	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}
	/**
	 * 获取：登记时间
	 */
	public String getApplyTime() {
		return applyTime;
	}
	/**
	 * 设置：印发日期
	 */
	public void setPrintDate(String printDate) {
		this.printDate = printDate;
	}
	/**
	 * 获取：印发日期
	 */
	public String getPrintDate() {
		return printDate;
	}
	/**
	 * 设置：工作分工内容
	 */
	public void setJobContent(String jobContent) {
		this.jobContent = jobContent;
	}
	/**
	 * 获取：工作分工内容
	 */
	public String getJobContent() {
		return jobContent;
	}
	/**
	 * 设置：部管理员第一次转办时间
	 */
	public void setFirstZbTime(Date firstZbTime) {
		this.firstZbTime = firstZbTime;
	}
	/**
	 * 获取：部管理员第一次转办时间
	 */
	public Date getFirstZbTime() {
		return firstZbTime;
	}
	/**
	 * 设置：已读首长ids
	 */
	public void setSzReadIds(String szReadIds) {
		this.szReadIds = szReadIds;
	}
	/**
	 * 获取：已读首长ids
	 */
	public String getSzReadIds() {
		return szReadIds;
	}
	/**
	 * 设置：催办标识
	 */
	public void setCuibanFlag(String cuibanFlag) {
		this.cuibanFlag = cuibanFlag;
	}
	/**
	 * 获取：催办标识
	 */
	public String getCuibanFlag() {
		return cuibanFlag;
	}
	/**
	 * 获取：文件类型id
	 */
	public String getDocTypeId() {
		return docTypeId;
	}
	/**
	 * 设置：文件类型id
	 */
	public void setDocTypeId(String docTypeId) {
		this.docTypeId = docTypeId;
	}
	/**
	 * 获取：文件类型
	 */
	public String getDocTypeName() {
		return docTypeName;
	}
	/**
	 * 设置：文件类型
	 */
	public void setDocTypeName(String docTypeName) {
		this.docTypeName = docTypeName;
	}
	/**
	 * 设置：创建时间
	 */
	public Date getCreatedTime() {
		return createdTime;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
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
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}
	
}
