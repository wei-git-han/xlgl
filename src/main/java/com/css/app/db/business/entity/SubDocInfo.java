package com.css.app.db.business.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 各子分支主记录表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-18 16:40:43
 */
public class SubDocInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//唯一标识
	private String id;
	//主文件id
	private String infoId;
	//分局id
	private String subDeptId;
	//分局名称
	private String subDeptName;
	//带一次转办时间
	private Date createdTime;
	//文件局内状态（1：退回修改；2：待落实；3：待审批；4：办理中；5：建议办结）
	private Integer docStatus;
	//备用字段
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
	 * 设置：主文件id
	 */
	public void setInfoId(String infoId) {
		this.infoId = infoId;
	}
	/**
	 * 获取：主文件id
	 */
	public String getInfoId() {
		return infoId;
	}
	/**
	 * 设置：分局id
	 */
	public void setSubDeptId(String subDeptId) {
		this.subDeptId = subDeptId;
	}
	/**
	 * 获取：分局id
	 */
	public String getSubDeptId() {
		return subDeptId;
	}
	/**
	 * 设置：分局名称
	 */
	public void setSubDeptName(String subDeptName) {
		this.subDeptName = subDeptName;
	}
	/**
	 * 获取：分局名称
	 */
	public String getSubDeptName() {
		return subDeptName;
	}
	/**
	 * 设置：带一次转办时间
	 */
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	/**
	 * 获取：带一次转办时间
	 */
	public Date getCreatedTime() {
		return createdTime;
	}
	/**
	 * 设置：文件局内状态（1：退回修改；2：待落实；3：待审批；4：办理中；5：建议办结）
	 */
	public void setDocStatus(Integer docStatus) {
		this.docStatus = docStatus;
	}
	/**
	 * 获取：文件局内状态（1：退回修改；2：待落实；3：待审批；4：办理中；5：建议办结）
	 */
	public Integer getDocStatus() {
		return docStatus;
	}
	/**
	 * 设置：备用字段
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备用字段
	 */
	public String getRemark() {
		return remark;
	}
}
