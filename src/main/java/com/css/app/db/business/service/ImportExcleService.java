package com.css.app.db.business.service;

import java.io.InputStream;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;
/**
 * excle导入接口类
 * @author weizy
 *
 */
public interface ImportExcleService {
	public List<List<Object>> getExcleDate(MultipartFile file);
}
