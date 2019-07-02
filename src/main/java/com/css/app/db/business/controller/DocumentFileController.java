package com.css.app.db.business.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.css.addbase.FileBaseUtil;
import com.css.app.db.business.entity.DocumentFile;
import com.css.app.db.business.service.DocumentFileService;
import com.css.base.utils.Response;
import com.css.base.utils.StringUtils;

import cn.com.css.filestore.impl.HTTPFile;


/**
 * 基本信息表携带文件的关系表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-18 16:39:11
 */
@Controller
@RequestMapping("/app/db/documentfile")
public class DocumentFileController {
	private final Logger logger = LoggerFactory.getLogger(DocumentFileController.class);

	@Autowired
	private DocumentFileService documentFileService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	public void list(String infoId){
		List<DocumentFile> fileList=null;
		if(StringUtils.isNotBlank(infoId)) {
			Map<String, Object> map = new HashMap<>();
			map.put("infoId", infoId);
			fileList = documentFileService.queryList(map);
		}
		Response.json(fileList);
	}
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/getFile")
	public void info(String id){
		System.err.println(id);
		DocumentFile documentFile = documentFileService.queryObject(id);
		JSONObject json= new JSONObject();
		if(documentFile!=null) {
			String formatId=documentFile.getFileServerFormatId();
			if(StringUtils.isNotBlank(formatId)){
				//获取版式文件的下载路径
				HTTPFile httpFiles = new HTTPFile(formatId);
				if(httpFiles!=null) {
					json.put("formatId", formatId);
					json.put("downFormatIdUrl", httpFiles.getAssginDownloadURL(true));
				}
			}
		}
		Response.json(json);
	}
	
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public void delete(String ids){
		if(StringUtils.isNotBlank(ids)) {
			String[] idArray = ids.split(",");
			documentFileService.deleteBatch(idArray);
			Response.json("result","success");
		}
	}
	/**
	 * 下载公文、暂时支持单个下载；
	 */
	@ResponseBody
	@RequestMapping("/downLoadFile")
	public void downLoadFile(String id){
		List<File> files = new ArrayList<>();
		for (String ss : id.split(",")) {
			try {
				DocumentFile documentFile = documentFileService.queryObject(ss);
				File file = null;
				if(documentFile!=null) {
					String formatId=documentFile.getFileServerFormatId();
					if(StringUtils.isNotBlank(formatId)){
						//获取版式文件的下载路径
						String url = FileBaseUtil.download(formatId);
						HTTPFile httpFiles = new HTTPFile(formatId);
						file = new File(httpFiles.getAssginDownloadURL(true));
						files.add(file);
						this.createZip(files,"d:\\xxx.zip");
					}
				}
			} catch (Exception e) {
				logger.info("下载公文异常：{}", e);
				Response.json("result","fail");
			}
		}
		Response.json("url","d:\\aaa.zip");
	}
	/**
	 * 支持公文批量下载打包zip
	 * @param files
	 * @param zipPath
	 */
	private void createZip(List<File> files, String zipPath) {
		FileInputStream fileInputStream = null;
		ZipOutputStream zipOutputStream = null;
		try {
			for (File file : files) {
				zipOutputStream = new ZipOutputStream(new FileOutputStream(zipPath));
				fileInputStream = new FileInputStream(file);
				zipOutputStream.putNextEntry(new ZipEntry(file.getName()));
				int length;
				if (fileInputStream != null) {
					while ((length = fileInputStream.read()) != -1) {
						zipOutputStream.write(length);
						zipOutputStream.flush();
					}
				}
			}
		} catch (Exception e) {
			logger.info("创建zip包异常：{}",e);
		}finally {
			if (zipOutputStream != null) {
				try {
					zipOutputStream.close();
				} catch (IOException e) {
					logger.info("关闭zipOutputStream流异常：{}",e);
				}
			}
			if (fileInputStream != null) {
				try {
					fileInputStream.close();
				} catch (IOException e) {
					logger.info("关闭fileInputStream流异常：{}",e);
				}
			}
			logger.info("生成xxx.zip包成功！");
		}
	}
}
