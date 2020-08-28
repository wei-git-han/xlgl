package com.css.app.xlgl.dto;

import java.io.Serializable;
import java.util.List;

import com.css.app.xlgl.entity.PersonalFile;

public class PersonalFileDto implements Serializable {

	//科目id
	private String examineSubjectId;
	//科目名称
	private String examineSubjectName;
	//
	private List<PersonalFile> list;
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
	public List<PersonalFile> getList() {
		return list;
	}
	public void setList(List<PersonalFile> list) {
		this.list = list;
	}
	
	

}
