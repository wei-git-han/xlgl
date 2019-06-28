package com.css.app.db.business.service.impl;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBody;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocument1;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageSz;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGrid;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGridCol;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STMerge;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STPageOrientation;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STVerticalJc;
import org.springframework.stereotype.Service;

import com.css.addbase.WordUtils;
import com.css.app.db.business.service.ExportService;

/**
 * wps相关操作类 部领导批示指示
 * 
 * @author weizy
 *
 */
@Service
public class ExportBLDServiceImpl2 implements ExportService {
	@Override
	public FileInputStream exportWPSdoc(List<Map<String, String>> list, String fileName, int banjieNum,
			int weibanjieNum,String docTypeId) throws IOException {
			final String TEMPLATENAME = "装备发展部领导批示指示督办落实情况表.xml";
			final String TEMPLATEPATH = "/com/css/app/db/templates";
			Map<String, Object> map  = new HashMap<>();
			// X密部分
			String security = list.get(0).get("security")==null?"X 密":list.get(0).get("security");
				
			// 标题部分
			String title = "装备发展部领导批示指示督办落实情况表";
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
