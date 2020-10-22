package com.css.app.xlgl.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;



/**
 * 训练管理-考核-题目表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-07-28 16:17:20
 */
public class XlglExamTopic implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//题目内容
	private String topicColumn;
	//待定：1：单选，2：多选，3：判断，4：填空，5：简答。
	private String topicType;
	//题目选项
	private String topicOption;
	//科目表id
	private String subjectId;
	//答案
	private String topicResult;
	//创建人
	private String createUser;
	//创建时间
	private Date createDate;
	//修改人
	private String updateUser;
	//修改时间
	private Date updateDate;
	//图目选项是图的 0:是图片标志
	private String pictureStatus;

	//图片集合
	private  List<String> list;
	
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
	 * 设置：科目表id
	 */
	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}
	/**
	 * 获取：科目表id
	 */
	public String getSubjectId() {
		return subjectId;
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
	public String getPictureStatus() {
		return pictureStatus;
	}
	public void setPictureStatus(String pictureStatus) {
		this.pictureStatus = pictureStatus;
	}
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	
}
