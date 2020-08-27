package com.css.app.xlgl.entity;

import java.io.Serializable;

public class PersonalFile implements Serializable{
	//科目id
	private String examineSubjectId;
	//科目名称
	private String examineSubjectName;
	//考试名称
	private String examineName;
	//总分数
	private Integer fractionSum;
	//用户id
	private String createUserId;
	//用户名称
	private String userName;
	//等级
	private String level;
	//排名
	private String ranking;
	//考试的用户id
	private String replyUserId;
	//考试的用户id
	private String replyUserName;
	//总成绩
	private String totalFraction;
	public String getExamineSubjectId() {
		return examineSubjectId;
	}
	public void setExamineSubjectId(String examineSubjectId) {
		this.examineSubjectId = examineSubjectId;
	}
	public String getExamineSubjectName() {
		return examineSubjectName;
	}
	public void setExamineSubjectName(String examineSubjectName) {
		this.examineSubjectName = examineSubjectName;
	}
	public String getExamineName() {
		return examineName;
	}
	public void setExamineName(String examineName) {
		this.examineName = examineName;
	}
	public Integer getFractionSum() {
		return fractionSum;
	}
	public void setFractionSum(Integer fractionSum) {
		this.fractionSum = fractionSum;
	}
	public String getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getRanking() {
		return ranking;
	}
	public void setRanking(String ranking) {
		this.ranking = ranking;
	}
	public String getReplyUserId() {
		return replyUserId;
	}
	public void setReplyUserId(String replyUserId) {
		this.replyUserId = replyUserId;
	}
	public String getReplyUserName() {
		return replyUserName;
	}
	public void setReplyUserName(String replyUserName) {
		this.replyUserName = replyUserName;
	}
	public String getTotalFraction() {
		return totalFraction;
	}
	public void setTotalFraction(String totalFraction) {
		this.totalFraction = totalFraction;
	}
	
	
}
