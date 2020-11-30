package com.css.app.xlgl.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 调查问卷表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-11-20 18:45:19
 */
public class SurveyCountQuestion implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//目前收集数量
	private String count;
	//结束时间
	private Date endTime;
	//开始时间
	private Date startTime;

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
}
