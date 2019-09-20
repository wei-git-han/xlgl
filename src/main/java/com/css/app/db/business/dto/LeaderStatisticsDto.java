package com.css.app.db.business.dto;

import java.io.Serializable;

/**
 * 首长统计dto
 * 
 * @author zhangyw
 * @date 2019-06-23 15:22:18
 */
public class LeaderStatisticsDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//首长id
	private String leaderId;
	//首长姓名
	private String leaderName;
	//办理中数量
	private Integer blzCount;
	//已办结数量
	private Integer ybjCount;
	//常态落实数量
	private Integer ctlsCount;
	//常态落实数量
	private Integer wfkCount;
	
	public String getLeaderId() {
		return leaderId;
	}
	public void setLeaderId(String leaderId) {
		this.leaderId = leaderId;
	}
	public String getLeaderName() {
		return leaderName;
	}
	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}
	public Integer getBlzCount() {
		return blzCount;
	}
	public void setBlzCount(Integer blzCount) {
		this.blzCount = blzCount;
	}
	public Integer getYbjCount() {
		return ybjCount;
	}
	public void setYbjCount(Integer ybjCount) {
		this.ybjCount = ybjCount;
	}
	public Integer getCtlsCount() {
		return ctlsCount;
	}
	public void setCtlsCount(Integer ctlsCount) {
		this.ctlsCount = ctlsCount;
	}

	public Integer getWfkCount() {
		return wfkCount;
	}

	public void setWfkCount(Integer wfkCount) {
		this.wfkCount = wfkCount;
	}
}
