package com.css.app.xlgl.dto;

import java.io.Serializable;

public class AccessoryFileDto implements Serializable {

    //部门名称
    private String fileId;
    //部门id
    private String fileName;
	public String getFileId() {
		return fileId;
	}
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
    

}
