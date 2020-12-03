package com.css.app.xlgl.dto;

public class ExamMainAnswerAnalyseDto /*implements Comparable<ExamMainAnswerAnalyseDto>*/ {
		//部门id
		private String organId; 
		//部门名称
		private String organName;
		//优秀率
		private Float excellentlv;
		//待考人数
		private Integer fillUpNum;
		//参考率
		private Float raioAll;
		//已(参)考人数
		private Integer peopleNum;
		//优秀人数
		private Integer excellent;
		//优良人数
		private Integer  fine ;
		// 及格人数
		private Integer pass ;
		//优良率
		private Float finelv;
		//及格率
		private Float passlv;
		//权限字段 部管理员和首长有查看其他局的权限
		private boolean status;
		
		public String getOrganId() {
			return organId;
		}
		public void setOrganId(String organId) {
			this.organId = organId;
		}
		public String getOrganName() {
			return organName;
		}
		public void setOrganName(String organName) {
			this.organName = organName;
		}
		public Integer getFillUpNum() {
			return fillUpNum;
		}
		public void setFillUpNum(Integer fillUpNum) {
			this.fillUpNum = fillUpNum;
		}
	
		public Integer getPeopleNum() {
			return peopleNum;
		}
		public void setPeopleNum(Integer peopleNum) {
			this.peopleNum = peopleNum;
		}
		
		public Integer getExcellent() {
			return excellent;
		}
		public void setExcellent(Integer excellent) {
			this.excellent = excellent;
		}
		public Integer getFine() {
			return fine;
		}
		public void setFine(Integer fine) {
			this.fine = fine;
		}
		public Integer getPass() {
			return pass;
		}
		public void setPass(Integer pass) {
			this.pass = pass;
		}
		public boolean isStatus() {
			return status;
		}
		public void setStatus(boolean status) {
			this.status = status;
		}
		public Float getExcellentlv() {
			return excellentlv;
		}
		public void setExcellentlv(Float excellentlv) {
			this.excellentlv = excellentlv;
		}
		public Float getRaioAll() {
			return raioAll;
		}
		public void setRaioAll(Float raioAll) {
			this.raioAll = raioAll;
		}
		public Float getFinelv() {
			return finelv;
		}
		public void setFinelv(Float finelv) {
			this.finelv = finelv;
		}
		public Float getPasslv() {
			return passlv;
		}
		public void setPasslv(Float passlv) {
			this.passlv = passlv;
		}
		
}
