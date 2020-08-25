package com.css.app.xlgl.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;



/**
 * 训练考核-考核清单-用户答题表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-03 11:35:28
 */
public class XlglExamAnswer implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//考试信息基本表id
	private String examineId;
	//试卷题目id
	private String examineTopicId;
	//题目
	private String topicColumn;
	//题目类型待定：1：单选，2：多选，3：判断，4：填空，5：简答。
	private String topicType;
	//题目选项
	private String topicOption;
	//答案
	private String topicResult;
	//用户回答
	private String reply;
	//答题的用户id 答题的用户就是创建人
	private String replyUserId;
	//创建时间
	private Date createDate;
	//修改时间
	private Date updateDate;
	//0:没做过，1:做过了
	private String status;
	//0:正确，1：错误
	private String correctStatus;
	//用户部门id
	private String organId;
	//用户部门名称
	private String organName;
	//分数
	private Integer fraction;
	//答题的用户名称
	private String replyUserName;
	//主表id
	private String mainAnswerId;
	
	
	private Map<String,Object> topicOptionMap;
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
	 * 设置：考试信息基本表id
	 */
	public void setExamineId(String examineId) {
		this.examineId = examineId;
	}
	/**
	 * 获取：考试信息基本表id
	 */
	public String getExamineId() {
		return examineId;
	}
	/**
	 * 设置：试卷题目id
	 */
	public void setExamineTopicId(String examineTopicId) {
		this.examineTopicId = examineTopicId;
	}
	/**
	 * 获取：试卷题目id
	 */
	public String getExamineTopicId() {
		return examineTopicId;
	}
	/**
	 * 设置：题目
	 */
	public void setTopicColumn(String topicColumn) {
		this.topicColumn = topicColumn;
	}
	/**
	 * 获取：题目
	 */
	public String getTopicColumn() {
		return topicColumn;
	}
	/**
	 * 设置：题目类型待定：1：单选，2：多选，3：判断，4：填空，5：简答。
	 */
	public void setTopicType(String topicType) {
		this.topicType = topicType;
	}
	/**
	 * 获取：题目类型待定：1：单选，2：多选，3：判断，4：填空，5：简答。
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
	 * 设置：用户回答
	 */
	public void setReply(String reply) {
		this.reply = reply;
	}
	/**
	 * 获取：用户回答
	 */
	public String getReply() {
		return reply;
	}
	/**
	 * 设置：答题的用户id
	 */
	public void setReplyUserId(String replyUserId) {
		this.replyUserId = replyUserId;
	}
	/**
	 * 获取：答题的用户id
	 */
	public String getReplyUserId() {
		return replyUserId;
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
	 * 设置：0:没做过，1:做过了
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：0:没做过，1:做过了
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：0:正确，1：错误
	 */
	public void setCorrectStatus(String correctStatus) {
		this.correctStatus = correctStatus;
	}
	/**
	 * 获取：0:正确，1：错误
	 */
	public String getCorrectStatus() {
		return correctStatus;
	}
	/**
	 * 设置：用户部门id
	 */
	public void setOrganId(String organId) {
		this.organId = organId;
	}
	/**
	 * 获取：用户部门id
	 */
	public String getOrganId() {
		return organId;
	}
	/**
	 * 设置：用户部门名称
	 */
	public void setOrganName(String organName) {
		this.organName = organName;
	}
	/**
	 * 获取：用户部门名称
	 */
	public String getOrganName() {
		return organName;
	}
	/**
	 * 设置：分数
	 */
	public void setFraction(Integer fraction) {
		this.fraction = fraction;
	}
	/**
	 * 获取：分数
	 */
	public Integer getFraction() {
		return fraction;
	}
	/**
	 * 设置：答题的用户名称
	 */
	public void setReplyUserName(String replyUserName) {
		this.replyUserName = replyUserName;
	}
	/**
	 * 获取：答题的用户名称
	 */
	public String getReplyUserName() {
		return replyUserName;
	}
	/**
	 * 设置：主表id
	 */
	public void setMainAnswerId(String mainAnswerId) {
		this.mainAnswerId = mainAnswerId;
	}
	/**
	 * 获取：主表id
	 */
	public String getMainAnswerId() {
		return mainAnswerId;
	}
	public Map<String, Object> getTopicOptionMap() {
		return topicOptionMap;
	}
	public void setTopicOptionMap(Map<String, Object> topicOptionMap) {
		this.topicOptionMap = topicOptionMap;
	}
	
	
}
