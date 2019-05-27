package com.css.app.db.business.service.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.css.app.db.business.service.ExportService;
import com.css.app.db.business.service.ExportWPSservice;

public class ExportWPSserviceImpl implements ExportWPSservice {
    
	//持有响应接受者对象
	private ExportService exportService;
	List<Map<String, String>> list;
	String fileName;
	int banjieNum;
	int weibanjieNum;
	public ExportWPSserviceImpl(ExportService exportService,List<Map<String, String>> list,String fileName,int banjieNum,int weibanjieNum) {
		this.exportService=exportService;
		this.list=list;
		this.fileName=fileName;
		this.banjieNum=banjieNum;
		this.weibanjieNum=weibanjieNum;
	}
	@Override
	public FileInputStream exportExecude() throws IOException {
		return exportService.exportWPSdoc(list, fileName,banjieNum,weibanjieNum);
	}

}
