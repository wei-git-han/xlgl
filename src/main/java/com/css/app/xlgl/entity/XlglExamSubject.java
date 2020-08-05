package com.css.app.xlgl.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 训练管理-考核-题目维护-科目表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-07-28 16:17:20
 */
public class XlglExamSubject implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//科目名称
	private String subjectName;
	//创建人
	private String createUser;
	//修改时间
	private Date updateDate;
	//修改人
	private String updateUser;
	//题目类型待定：1：单选，2：多选，3：判断，4：填空，5：简答。
	private String subjectType;
	//创建时间
	private Date createDate;
	//题目类型
	private String[] subjectTypeAll;
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
	 * 设置：科目名称
	 */
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	/**
	 * 获取：科目名称
	 */
	public String getSubjectName() {
		return subjectName;
	}
	/**
	 * 设置：创建人
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	/**
	 * 获取：创建人
	 */
	public String getCreateUser() {
		return createUser;
	}
	/**
	 * 设置：修改时间
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getUpdateDate() {
		return updateDate;
	}
	/**
	 * 设置：修改人
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	/**
	 * 获取：修改人
	 */
	public String getUpdateUser() {
		return updateUser;
	}
	/**
	 * 设置：待定：1：单选，2：多选，3：判断，4：填空，5：简答。
	 */
	public void setSubjectType(String subjectType) {
		this.subjectType = subjectType;
	}
	/**
	 * 获取：待定：1：单选，2：多选，3：判断，4：填空，5：简答。
	 */
	public String getSubjectType() {
		return subjectType;
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
	public String[] getSubjectTypeAll() {
		return subjectTypeAll;
	}
	public void setSubjectTypeAll(String[] subjectTypeAll) {
		this.subjectTypeAll = subjectTypeAll;
	}
	
}
