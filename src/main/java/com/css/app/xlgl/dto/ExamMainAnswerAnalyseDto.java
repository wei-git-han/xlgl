package com.css.app.xlgl.dto;

public class ExamMainAnswerAnalyseDto {
		//部门id
		private String organId; 
		//部门名称
		private String organName;
		//优秀率
		private String excellentlv;
		//待考人数
		private Integer fillUpNum;
		//参考率
		private String raioAll;
		//已(参)考人数
		private Integer peopleNum;
		//优秀人数
		private Integer excellent;
		//优良人数
		private Integer  fine ;
		// 及格人数
		private Integer pass ;
		//优良率
		private String finelv;
		//及格率
		private String passlv;
		
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
		public String getRaioAll() {
			return raioAll;
		}
		public void setRaioAll(String raioAll) {
			this.raioAll = raioAll;
		}
		public Integer getPeopleNum() {
			return peopleNum;
		}
		public void setPeopleNum(Integer peopleNum) {
			this.peopleNum = peopleNum;
		}
		public String getExcellentlv() {
			return excellentlv;
		}
		public void setExcellentlv(String excellentlv) {
			this.excellentlv = excellentlv;
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
		public String getFinelv() {
			return finelv;
		}
		public void setFinelv(String finelv) {
			this.finelv = finelv;
		}
		public String getPasslv() {
			return passlv;
		}
		public void setPasslv(String passlv) {
			this.passlv = passlv;
		}
		
}
