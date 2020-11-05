package com.css.app.xlgl.dto;

public class ExamMainAnswerAnalyseDto {
		//部门id
		private String organId; 
		//部门名称
		private String organName;
		//优秀率
		private String excellent;
		//待考人数
		private Integer fillUpNum;
		//参考率
		private String raioAll;
		//参考人数
		private Integer peopleNum;
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
		public String getExcellent() {
			return excellent;
		}
		public void setExcellent(String excellent) {
			this.excellent = excellent;
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
		
}
