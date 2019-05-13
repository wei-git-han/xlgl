package com.css.app.db.business.service;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 命令接口，声明执行的操作
 * @author weizy
 *
 */
public interface ExportWPSservice {
	//执行命令的对应操作
	public FileInputStream exportExecude() throws IOException;
	

}
