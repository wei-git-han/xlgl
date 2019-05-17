package com.css.app.db.business.controller;

import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSONObject;
import com.css.addbase.apporgmapped.constant.AppType;
import com.css.addbase.apporgmapped.entity.BaseAppOrgMapped;
import com.css.addbase.apporgmapped.service.BaseAppOrgMappedService;
import com.css.app.db.business.entity.DocumentInfo;
import com.css.app.db.business.entity.DocumentSzps;
import com.css.app.db.business.entity.ReplyExplain;
import com.css.app.db.business.entity.SubDocInfo;
import com.css.app.db.business.service.DocumentInfoService;
import com.css.app.db.business.service.DocumentSzpsService;
import com.css.app.db.business.service.ExportService;
import com.css.app.db.business.service.ExportWPSservice;
import com.css.app.db.business.service.ReplyExplainService;
import com.css.app.db.business.service.SubDocInfoService;
import com.css.app.db.business.service.impl.ExportBLDServiceImpl;
import com.css.app.db.business.service.impl.ExportBNZYGZServiceImpl;
import com.css.app.db.business.service.impl.ExportInvoke;
import com.css.app.db.business.service.impl.ExportJWSZServiceImpl;
import com.css.app.db.business.service.impl.ExportJWZYServiceImpl;
import com.css.app.db.business.service.impl.ExportQTServiceImpl;
import com.css.app.db.business.service.impl.ExportWPSserviceImpl;
import com.css.app.db.business.service.impl.ExportZYJCServiceImpl;
import com.css.base.utils.CrossDomainUtil;
import com.css.base.utils.Response;

/**
 * 导入wps-excle
 * @author weizy
 *
 */
@RestController
@RequestMapping("/app/db/export")
public class ImportController{
    @Autowired
	DocumentInfoService documentInfoService;
    @Autowired
    DocumentSzpsService documentSzpsService;
    @Autowired
    ReplyExplainService replyExplainService;
    @Autowired
    SubDocInfoService subDocInfoService;
    @Autowired
    BaseAppOrgMappedService baseAppOrgMappedService;
    @Autowired
    ExportInvoke exportInvoke;    
	@Value("${filePath}")
	private String filePath;

	
	@RequestMapping("/imxportExcle")
	public void imxportExcle(String stringIds) {
		
		
		
		
	}

   /**
    * 创建file
    * @param exportFileName
    * @return
    */
	private File creatFile(String exportFileName) {
		File tempFile;
		tempFile = new File(filePath, exportFileName);
		if (tempFile.exists()) {
			tempFile.delete();
		} else {
			tempFile.getParentFile().mkdirs();
		}
		return tempFile;
	}

}
