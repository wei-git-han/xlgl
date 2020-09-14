package com.css.app.xlgl.meeting.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 保存会见返回的会议号id
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-09-14 14:41:44
 */
public class XlglHuijian implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//创建人id
	private String createUser;
	//会议id
	private String confId;
	//创建时间
	private Date createDate;
	//0:没删除或没失效，1：已删除或已失效
	private String isDelete;
	//训练id
	private String xlglId;

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
	 * 设置：创建人id
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	/**
	 * 获取：创建人id
	 */
	public String getCreateUser() {
		return createUser;
	}
	/**
	 * 设置：会议id
	 */
	public void setConfId(String confId) {
		this.confId = confId;
	}
	/**
	 * 获取：会议id
	 */
	public String getConfId() {
		return confId;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateDate() {
		return createDate;
	}
	/**
	 * 设置：0:没删除或没失效，1：已删除或已失效
	 */
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
	/**
	 * 获取：0:没删除或没失效，1：已删除或已失效
	 */
	public String getIsDelete() {
		return isDelete;
	}
	public String getXlglId() {
		return xlglId;
	}
	public void setXlglId(String xlglId) {
		this.xlglId = xlglId;
	}
	
}
