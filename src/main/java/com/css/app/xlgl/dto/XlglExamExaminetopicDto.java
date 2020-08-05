package com.css.app.xlgl.dto;

import java.io.Serializable;

public class XlglExamExaminetopicDto implements Serializable{
	
	private String topicType; //题目类型
	private Integer typeCount; //同一类型的总数量
	private Integer numberAll; //同一类型的总分数
	private Integer fractionalNumber; //同一类型的单题分数
	public String getTopicType() {
		return topicType;
	}
	public void setTopicType(String topicType) {
		this.topicType = topicType;
	}
	public Integer getTypeCount() {
		return typeCount;
	}
	public void setTypeCount(Integer typeCount) {
		this.typeCount = typeCount;
	}
	public Integer getNumberAll() {
		return numberAll;
	}
	public void setNumberAll(Integer numberAll) {
		this.numberAll = numberAll;
	}
	public Integer getFractionalNumber() {
		return fractionalNumber;
	}
	public void setFractionalNumber(Integer fractionalNumber) {
		this.fractionalNumber = fractionalNumber;
	}
	
	
	

}
