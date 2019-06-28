package com.css.app.db.business.service.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.css.addbase.WordUtils;
import com.css.app.db.business.service.ExportService;

/**
 * wps相关操作类之 JW主席批示指示督办落实情况表 -1
 * 
 * @author weizy
 *
 */
@Service
public class ExportJWZYServiceImpl2 implements ExportService {
	@SuppressWarnings("static-access")
	@Override
	public FileInputStream exportWPSdoc(List<Map<String, String>> list, String fileName, int banjieNum,
			int weibanjieNum,String docTypeId) throws IOException {
		final String TEMPLATENAME = "军委主席批示指示督办落实情况表.xml";
		final String TEMPLATEPATH = "/com/css/app/db/templates";
		Map<String, Object> map  = new HashMap<>();
		// X密部分
		String security = list.get(0).get("security")==null?"X 密":list.get(0).get("security");
			
		// 标题部分
		String title = "1".equals(docTypeId)?"军委主席批示指示督办落实情况表":"军委首长批示指示督办落实情况表";

		// 基本信息表格
		String fullDate = "填报日期:" + new SimpleDateFormat("yyyy年MM月dd日").format(new Date());
		String tex1 = "一、已办结事项（共" + banjieNum + "项）";
		String tex2 = "一、未办结事项（共" + weibanjieNum + "项）";
		String tex3 = "二、未办结事项（共" + weibanjieNum + "项）";
		
		//存儲信息
		map.put("security", security);
		map.put("title", title);
		map.put("fullDate", fullDate);
		map.put("tex1", tex1);
		map.put("tex2", tex2);
		map.put("tex3", tex3);
		map.put("banjieNum", banjieNum);
		map.put("weibanjieNum", weibanjieNum);
		map.put("list", list);
		WordUtils wordUtil = new WordUtils();
		
		//創建word對象
		wordUtil.creatDoc(map,fileName,TEMPLATENAME,TEMPLATEPATH);
		return new FileInputStream(fileName);
	}	
}
