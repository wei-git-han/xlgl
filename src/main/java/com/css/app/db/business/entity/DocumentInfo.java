package com.css.app.db.business.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;



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
	//催办标识（催办中为1）
	private String cuibanFlag;
	//文件类型id
	private String docTypeId;
	//文件类型
	private String docTypeName;
	//创建时间
	private Date createdTime;
	//办理状态(0:还未转办1：办理中；2：办结：3：常态落实)
	private Integer status; 
	//完成时间
	private Date finishTime;
	//备注
	private String remark;
	//最新反馈
	private String latestReply;
	//最新反馈单位
	private String latestSubDept;
	//最新反馈的承办人
	private String latestUndertaker;
	//最新反馈审批完成时间
	private Date latestReplyTime;
	//期数
	private String period;
	/*------------------------------------*/
	//最新的首长名字
	private String leaderName;
	//最新的首长批示
	private String leaderContent;
	//最新的首长批示时间
	private String leaderTime;
	//已更新标识
	private String updateFlag;
	//承办单位/人
	private String underDepts;
	//首长批示
	private List<DocumentSzps> szpslist;
	//首长批示
	private Integer isOverTreeMonth;
	//落实事项
	private String workableMatter;
	//是否显示补录按钮
	private Integer isAddRecord;
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
	public String getLatestReply() {
		return latestReply;
	}
	public void setLatestReply(String latestReply) {
		this.latestReply = latestReply;
	}
	public String getLatestSubDept() {
		return latestSubDept;
	}
	public void setLatestSubDept(String latestSubDept) {
		this.latestSubDept = latestSubDept;
	}
	public String getLatestUndertaker() {
		return latestUndertaker;
	}
	public void setLatestUndertaker(String latestUndertaker) {
		this.latestUndertaker = latestUndertaker;
	}
	public Date getLatestReplyTime() {
		return latestReplyTime;
	}
	public void setLatestReplyTime(Date latestReplyTime) {
		this.latestReplyTime = latestReplyTime;
	}
	public String getLeaderName() {
		return leaderName;
	}
	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}
	public String getLeaderContent() {
		return leaderContent;
	}
	public void setLeaderContent(String leaderContent) {
		this.leaderContent = leaderContent;
	}
	public String getLeaderTime() {
		return leaderTime;
	}
	public void setLeaderTime(String leaderTime) {
		this.leaderTime = leaderTime;
	}
	public String getUpdateFlag() {
		return updateFlag;
	}
	public void setUpdateFlag(String updateFlag) {
		this.updateFlag = updateFlag;
	}
	public String getUnderDepts() {
		return underDepts;
	}
	public void setUnderDepts(String underDepts) {
		this.underDepts = underDepts;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public List<DocumentSzps> getSzpslist() {
		return szpslist;
	}
	public void setSzpslist(List<DocumentSzps> szpslist) {
		this.szpslist = szpslist;
	}
	public Integer getIsOverTreeMonth() {
		return isOverTreeMonth;
	}
	public void setIsOverTreeMonth(Integer isOverTreeMonth) {
		this.isOverTreeMonth = isOverTreeMonth;
	}
	public String getWorkableMatter() {
		return workableMatter;
	}
	public void setWorkableMatter(String workableMatter) {
		this.workableMatter = workableMatter;
	}
	public Integer getIsAddRecord() {
		return isAddRecord;
	}
	public void setIsAddRecord(Integer isAddRecord) {
		this.isAddRecord = isAddRecord;
	}
	
}
