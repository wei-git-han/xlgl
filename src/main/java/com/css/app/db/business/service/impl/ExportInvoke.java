package com.css.app.db.business.service.impl;

import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.stereotype.Component;

import com.css.app.db.business.service.ExportService;
import com.css.app.db.business.service.ExportWPSservice;

/**
 * invoke类，持有导出不同格式对应的命令对象
 * @author weizy
 *
 */
@Component
public class ExportInvoke {

	private ExportWPSservice exportWPSservice;
	//设置导出命令对象
	public void setExportWPSservice(ExportWPSservice exportWPSservice) {		
		this.exportWPSservice=exportWPSservice;
	}
	
	public FileInputStream export() throws IOException {
		FileInputStream exportExecude = exportWPSservice.exportExecude();
		return exportExecude;
	}
}
