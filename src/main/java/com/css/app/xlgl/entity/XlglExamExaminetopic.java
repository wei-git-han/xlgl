package com.css.app.xlgl.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 训练考核-考核组织-考试副表题目表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-07-30 10:56:43
 */
public class XlglExamExaminetopic implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//考试基本信息表id
	private String examineId;
	//题库科目表id
	private String subjectId;
	//题库题目表id
	private String topicId;
	//待定：1：单选，2：多选，3：判断，4：填空，5：简答。
	private String topicType;
	//题目内容
	private String topicColumn;
	//题目选项
	private String topicOption;
	//答案
	private String topicResult;
	//这道题的分数
	private Integer fractionalNumber;
	//创建人
	private String createUser;
	//创建时间
	private Date createDate;
	//修改人
	private String updateUser;
	//修改时间
	private Date updateDate;
	//排序
	private int sort;
	//补考id
	private String makeUpId;
	//补考状态 0 :不是补考题 ， 1:补考题
	private String makeUpStatus;
	
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
	 * 设置：考试基本信息表id
	 */
	public void setExamineId(String examineId) {
		this.examineId = examineId;
	}
	/**
	 * 获取：考试基本信息表id
	 */
	public String getExamineId() {
		return examineId;
	}
	/**
	 * 设置：题库科目表id
	 */
	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}
	/**
	 * 获取：题库科目表id
	 */
	public String getSubjectId() {
		return subjectId;
	}
	/**
	 * 设置：题库题目表id
	 */
	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}
	/**
	 * 获取：题库题目表id
	 */
	public String getTopicId() {
		return topicId;
	}
	/**
	 * 设置：待定：1：单选，2：多选，3：判断，4：填空，5：简答。
	 */
	public void setTopicType(String topicType) {
		this.topicType = topicType;
	}
	/**
	 * 获取：待定：1：单选，2：多选，3：判断，4：填空，5：简答。
	 */
	public String getTopicType() {
		return topicType;
	}
	/**
	 * 设置：题目内容
	 */
	public void setTopicColumn(String topicColumn) {
		this.topicColumn = topicColumn;
	}
	/**
	 * 获取：题目内容
	 */
	public String getTopicColumn() {
		return topicColumn;
	}
	/**
	 * 设置：题目选项
	 */
	public void setTopicOption(String topicOption) {
		this.topicOption = topicOption;
	}
	/**
	 * 获取：题目选项
	 */
	public String getTopicOption() {
		return topicOption;
	}
	/**
	 * 设置：答案
	 */
	public void setTopicResult(String topicResult) {
		this.topicResult = topicResult;
	}
	/**
	 * 获取：答案
	 */
	public String getTopicResult() {
		return topicResult;
	}
	/**
	 * 设置：这道题的分数
	 */
	public void setFractionalNumber(Integer fractionalNumber) {
		this.fractionalNumber = fractionalNumber;
	}
	/**
	 * 获取：这道题的分数
	 */
	public Integer getFractionalNumber() {
		return fractionalNumber;
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
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public String getMakeUpId() {
		return makeUpId;
	}
	public void setMakeUpId(String makeUpId) {
		this.makeUpId = makeUpId;
	}
	public String getMakeUpStatus() {
		return makeUpStatus;
	}
	public void setMakeUpStatus(String makeUpStatus) {
		this.makeUpStatus = makeUpStatus;
	}
	
}
