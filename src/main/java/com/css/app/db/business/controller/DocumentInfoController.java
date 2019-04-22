package com.css.app.db.business.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.tomcat.jni.FileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.css.addbase.AppConfig;
import com.css.addbase.FileBaseUtil;
import com.css.addbase.apporgmapped.entity.BaseAppOrgMapped;
import com.css.addbase.constant.AppConstant;
import com.css.addbase.suwell.OfdTransferUtil;
import com.css.app.db.business.entity.DocumentFile;
import com.css.app.db.business.entity.DocumentInfo;
import com.css.app.db.business.service.DocumentFileService;
import com.css.app.db.business.service.DocumentInfoService;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.PageUtils;
import com.css.base.utils.Response;
import com.css.base.utils.UUIDUtils;
import com.github.pagehelper.PageHelper;

import cn.com.css.filestore.impl.HTTPFile;


/**
 * 督办基本信息表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-18 16:34:38
 */
@Controller
@RequestMapping("/app/db/documentinfo")
public class DocumentInfoController {
	@Autowired
	private AppConfig appConfig;
	@Autowired
	private DocumentInfoService documentInfoService;
	@Autowired
	private DocumentFileService documentFileService;
	
	
	
	/**
	 * 文件上传保存
	 * @param idpdf 主记录id(documentInfo的id)
	 * @param pdf 文件
	 */
	@ResponseBody
	@RequestMapping("/uploadFile")
	public void savePDF(String idpdf,@RequestParam(value = "pdf", required = false) MultipartFile pdf){
			String formatDownPath = "";//版式文件下载路径
			String streamId = null;//流式文件id
			String formatId  = null;//版式文件id
			JSONObject json = new JSONObject();
			if(StringUtils.isNotBlank(idpdf)) {				
				if (pdf != null && pdf.getSize() > 0) {
					String fileName=pdf.getOriginalFilename();
					//获取文件后缀
					String fileType =fileName.substring(fileName.lastIndexOf(".")+1);
					//如果文件是流式则流式转换为版式
					if(!StringUtils.equals("ofd", fileType)){
						streamId = FileBaseUtil.fileServiceUpload(pdf);
						HTTPFile hf = new HTTPFile(streamId);
						try {
							String path = appConfig.getLocalFilePath() + UUIDUtils.random() + "." + hf.getSuffix();
							try {
								FileUtils.moveFile(new File(hf.getFilePath()) , new File(path));
							} catch (IOException e) {
								e.printStackTrace();
							}
							if(StringUtils.isNotBlank(path)){
								formatId = OfdTransferUtil.convertLocalFileToOFD(path);
							}
							//删除本地的临时流式文件
							if(new File(path).exists()){
								new File(path).delete();
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}else{
						formatId=FileBaseUtil.fileServiceUpload(pdf);	
					}
					if(StringUtils.isNotBlank(formatId)) {
						//获取版式文件的下载路径
						HTTPFile httpFiles = new HTTPFile(formatId);
						if(httpFiles!=null) {
							formatDownPath = httpFiles.getAssginDownloadURL(true);
						}
						//保存文件相关数据
						DocumentFile file=new DocumentFile();
						file.setId(UUIDUtils.random());
						file.setDocInfoId(idpdf);
						file.setSort(documentFileService.queryMinSort(idpdf));
						file.setFileName(fileName);
						file.setCreatedTime(new Date());
						if(StringUtils.isNotBlank(streamId)) {
							file.setFileServerStreamId(streamId);
						}
						file.setFileServerFormatId(formatId);
						documentFileService.save(file);
					}
					json.put("smjId", formatId);
					json.put("smjFilePath", formatDownPath);
					json.put("result", "success");
				}
			}else {
				json.put("result", "fail");
			}
			Response.json(json);
	}
	
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("dbdocumentinfo:list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<DocumentInfo> dbDocumentInfoList = documentInfoService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(dbDocumentInfoList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	@RequiresPermissions("dbdocumentinfo:info")
	public void info(@PathVariable("id") String id){
		DocumentInfo dbDocumentInfo = documentInfoService.queryObject(id);
		Response.json("dbDocumentInfo", dbDocumentInfo);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	@RequiresPermissions("dbdocumentinfo:save")
	public void save(@RequestBody DocumentInfo dbDocumentInfo){
		dbDocumentInfo.setId(UUIDUtils.random());
		documentInfoService.save(dbDocumentInfo);
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public void update(DocumentInfo documentInfo){
		String uuid="";
		JSONObject jo=new JSONObject();
		if (StringUtils.isNotBlank(documentInfo.getId())) {
			jo.put("id",documentInfo.getId());
			documentInfoService.update(documentInfo);
		} else {
			uuid=UUIDUtils.random();
			documentInfo.setId(uuid);
			documentInfoService.save(documentInfo);
			jo.put("id",uuid);
		}
		Response.json(jo);
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("dbdocumentinfo:delete")
	public void delete(@RequestBody String[] ids){
		documentInfoService.deleteBatch(ids);
		
		Response.ok();
	}
	
	@ResponseBody
	@RequestMapping("/getLoginUser")
	public void getLoginUser() {
		JSONObject jo=new JSONObject();
		jo.put("userId", CurrentUser.getUserId());
		jo.put("userName", CurrentUser.getUsername());
		Response.json(jo);
	}
}
