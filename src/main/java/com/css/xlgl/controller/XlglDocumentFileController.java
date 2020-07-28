package com.css.xlgl.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSONObject;
import com.css.addbase.AppConfig;
import com.css.addbase.FileBaseUtil;
import com.css.addbase.suwell.OfdTransferUtil;
import com.css.base.utils.PageUtils;
import com.css.base.utils.UUIDUtils;
import com.css.xlgl.entity.XlglDocumentFile;
import com.css.xlgl.service.XlglDocumentFileService;
import com.github.pagehelper.PageHelper;

import cn.com.css.filestore.impl.HTTPFile;

import com.css.base.utils.Response;
import com.css.base.utils.StringUtils;


/**
 * 基本信息表携带文件的关系表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-07-28 13:15:37
 */
@Controller
@RequestMapping("/xlgldocumentfile")
public class XlglDocumentFileController {
	@Autowired
	private XlglDocumentFileService xlglDocumentFileService;
	@Autowired
	private AppConfig appConfig;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("xlgldocumentfile:list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<XlglDocumentFile> xlglDocumentFileList = xlglDocumentFileService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(xlglDocumentFileList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	@RequiresPermissions("xlgldocumentfile:info")
	public void info(@PathVariable("id") String id){
		XlglDocumentFile xlglDocumentFile = xlglDocumentFileService.queryObject(id);
		Response.json("xlglDocumentFile", xlglDocumentFile);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	@RequiresPermissions("xlgldocumentfile:save")
	public void save(@RequestBody XlglDocumentFile xlglDocumentFile){
		xlglDocumentFile.setId(UUIDUtils.random());
		xlglDocumentFileService.save(xlglDocumentFile);
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("xlgldocumentfile:update")
	public void update(@RequestBody XlglDocumentFile xlglDocumentFile){
		xlglDocumentFileService.update(xlglDocumentFile);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("xlgldocumentfile:delete")
	public void delete(@RequestBody String[] ids){
		xlglDocumentFileService.deleteBatch(ids);
		
		Response.ok();
	}
	
	/**
	 * 文件上传保存
	 * 
	 * @param idpdf
	 *            主记录id(documentInfo的id)
	 * @param pdf
	 *            文件
	 */
	@ResponseBody
	@RequestMapping("/uploadFile")
	public void savePDF(String idpdf, @RequestParam(required = false) MultipartFile[] pdf) {
		String formatDownPath = "";// 版式文件下载路径
		String retFormatId = null;// 返回的版式文件id
		String streamId = null;// 流式文件id
		String formatId = null;// 版式文件id
		JSONObject json = new JSONObject();
		if (StringUtils.isNotBlank(idpdf)) {
			if (pdf != null && pdf.length > 0) {
				for (int i = 0; i < pdf.length; i++) {
					String fileName = pdf[i].getOriginalFilename();
					// 获取文件后缀
					String fileType = fileName.substring(fileName.lastIndexOf(".") + 1);
					// 如果文件是流式则流式转换为版式
					if (!StringUtils.equals("ofd", fileType)) {
						streamId = FileBaseUtil.fileServiceUpload(pdf[i]);
						HTTPFile hf = new HTTPFile(streamId);
						try {
							String path = appConfig.getLocalFilePath() + UUIDUtils.random() + "." + hf.getSuffix();
							try {
								FileUtils.moveFile(new File(hf.getFilePath()), new File(path));
							} catch (IOException e) {
								e.printStackTrace();
							}
							if (StringUtils.isNotBlank(path)) {
								formatId = OfdTransferUtil.convertLocalFileToOFD(path);
							}
							// 删除本地的临时流式文件
							if (new File(path).exists()) {
								new File(path).delete();
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					} else {
						formatId = FileBaseUtil.fileServiceUpload(pdf[i]);
					}
					if (StringUtils.isNotBlank(formatId)) {
						if (i == 0) {
							retFormatId = formatId;
							// 获取版式文件的下载路径
							HTTPFile httpFiles = new HTTPFile(formatId);
							if (httpFiles != null) {
								formatDownPath = httpFiles.getAssginDownloadURL(true);
							}
						}
						// 保存文件相关数据
						XlglDocumentFile file = new XlglDocumentFile();
						file.setId(UUIDUtils.random());
						file.setDocInfoId(idpdf);
						file.setSort(xlglDocumentFileService.queryMinSort(idpdf));
						file.setFileName(fileName);
						file.setCreatedTime(new Date());
						if (StringUtils.isNotBlank(streamId)) {
							file.setFileServerStreamId(streamId);
						}
						file.setFileServerFormatId(formatId);
						xlglDocumentFileService.save(file);
					}
				}
				json.put("smjId", retFormatId);
				json.put("smjFilePath", formatDownPath);
				json.put("result", "success");
			}
		} else {
			json.put("result", "fail");
		}
		Response.json(json);
	}
	
}
