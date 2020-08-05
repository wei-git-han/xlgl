package com.css.app.xlgl.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 训练管理-通知公告附件表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-04 13:45:11
 */
public class XlglNoticeFile implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键id
	private String id;
	//创建时间
	private Date createTime;
	//附件名称
	private String fjmc;
	//对应通知公告id
	private String noticeId;

	/**
	 * 设置：主键id
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：主键id
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：附件名称
	 */
	public void setFjmc(String fjmc) {
		this.fjmc = fjmc;
	}
	/**
	 * 获取：附件名称
	 */
	public String getFjmc() {
		return fjmc;
	}
	/**
	 * 设置：对应通知公告id
	 */
	public void setNoticeId(String noticeId) {
		this.noticeId = noticeId;
	}
	/**
	 * 获取：对应通知公告id
	 */
	public String getNoticeId() {
		return noticeId;
	}
}
