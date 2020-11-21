package com.css.app.xlgl.entity;

import java.util.Date;

public class SurveyCountQuestionExport {
	private static final long serialVersionUID = 1L;
	
	// 题干名称
	private String questionContent;
	// 题干名称Id
	private String questionContentId;
	// 选项名称
	private String optionContent;
	// 票数
	private String countNum;
	// 百分比
	private String countPercentage;

	public String getQuestionContentId() {
		return questionContentId;
	}

	public void setQuestionContentId(String questionContentId) {
		this.questionContentId = questionContentId;
	}

	public String getQuestionContent() {
		return questionContent;
	}

	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}

	public String getOptionContent() {
		return optionContent;
	}

	public void setOptionContent(String optionContent) {
		this.optionContent = optionContent;
	}

	public String getCountNum() {
		return countNum;
	}

	public void setCountNum(String countNum) {
		this.countNum = countNum;
	}
	
	public String getCountPercentage() {
		return countPercentage;
	}

	public void setCountPercentage(String countPercentage) {
		this.countPercentage = countPercentage;
	}
}
