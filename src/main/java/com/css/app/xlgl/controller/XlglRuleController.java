package com.css.app.xlgl.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

import cn.com.css.filestore.impl.HTTPFile;
import com.alibaba.fastjson.JSONObject;
import com.css.addbase.AppConfig;
import com.css.addbase.FileBaseUtil;
import com.css.addbase.suwell.OfdTransferUtil;
import com.css.app.xlgl.entity.XlglCarsManager;
import com.css.app.xlgl.entity.XlglPicture;
import com.css.app.xlgl.entity.XlglRule;
import com.css.app.xlgl.service.XlglCarsManagerService;
import com.css.app.xlgl.service.XlglRuleService;
import com.css.base.utils.CurrentUser;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import com.css.base.utils.PageUtils;
import com.css.base.utils.UUIDUtils;
import com.github.pagehelper.PageHelper;
import com.css.base.utils.Response;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;


/**
 * 训练管理法规资料
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-20 20:18:42
 */
@Controller
@RequestMapping("/app/xlgl/xlglrule")
public class XlglRuleController {
	@Autowired
	private XlglRuleService xlglRuleService;
	@Autowired
	private AppConfig appConfig;
	@Autowired
	private XlglCarsManagerService xlglCarsManagerService;
	
	/**
	 * 列表
	 * type : 0:全军管理法规；1:装备发展部管理法规；2：常用资料；3：其他法规; 4:军事法规
	 */
	@ResponseBody
	@RequestMapping("/list")
	public void list(Integer page, Integer limit,String type){
		List<XlglRule> xlglRuleList = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		map.put("type",type);
		PageHelper.startPage(page, limit);
		


		if("1".equals(type)){
			xlglRuleList = xlglRuleService.queryAll(map);
		}else {
			//查询列表数据
			xlglRuleList = xlglRuleService.queryList(map);
		}
		
		PageUtils pageUtil = new PageUtils(xlglRuleList);
		Response.json("page",pageUtil);
	}

	//获取文件列表
	//type : 0:全军管理法规；1:装备发展部管理法规；2：常用资料；3：其他法规; 4:军事法规
	@ResponseBody
	@RequestMapping("/getFileList")
	public void getFileList(Integer page, Integer limit,String type){
		List<XlglRule> xlglRuleList = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		map.put("type",type);
		PageHelper.startPage(page, limit);
		if("1".equals(type)){
			xlglRuleList = xlglRuleService.queryAll(map);
		}else {
			//查询列表数据
			xlglRuleList = xlglRuleService.queryList(map);
		}

		PageUtils pageUtil = new PageUtils(xlglRuleList);
		Response.json("page",pageUtil);

	}
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	@RequiresPermissions("xlglrule:info")
	public void info(@PathVariable("id") String id){
		XlglRule xlglRule = xlglRuleService.queryObject(id);
		Response.json("xlglRule", xlglRule);
	}
	
	/**
	 * 保存
	 * 点击新增的时候，调用这个接口，创建一个表数据
	 * type : 0:全军管理法规；1:装备发展部管理法规；2：常用资料；3：其他法规
	 */
	@ResponseBody
	@RequestMapping("/save")
	public void save(XlglRule xlglRule){
		xlglRule.setId(UUIDUtils.random());
		xlglRule.setCreatedTime(new Date());
		xlglRule.setUploadUser(CurrentUser.getUserId());
		xlglRuleService.save(xlglRule);
		Response.json("xlglRule",xlglRule);
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("xlglrule:update")
	public void update(@RequestBody XlglRule xlglRule){
		xlglRuleService.update(xlglRule);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public void delete(String id){
		String[] ids = id.split(",");
		xlglRuleService.deleteBatch(ids);
		xlglCarsManagerService.deleteBatch(ids);
		Response.json("result","success");
	}

	/**
	 * 文件上传保存
	 *
	 * @param fileId
	 *            主记录id(documentInfo的id)
	 * @param pdf
	 *            文件
	 */
	@ResponseBody
	@RequestMapping("/uploadFile1111")
	public void savePDF(String fileId, @RequestParam(required = false) MultipartFile[] pdf) {
		String formatDownPath = "";// 版式文件下载路径
		String retFormatId = null;// 返回的版式文件id
		String streamId = null;// 流式文件id
		String formatId = null;// 版式文件id
		JSONObject json = new JSONObject();
		if (StringUtils.isNotBlank(fileId)) {
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
						XlglRule file = new XlglRule();
						file.setId(fileId);
						file.setInfoId(fileId);
						file.setFileName(fileName);
						file.setFileServerFormatId(formatId);
						xlglRuleService.save(file);
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

	@ResponseBody
	@RequestMapping("/uploadFile")
	public void upLoad(@RequestParam(required = false) MultipartFile[] file,String type) {
		JSONObject json = new JSONObject();
			String fileId =FileBaseUtil.fileServiceUpload(file[0]);
			String fileName = file[0].getOriginalFilename();
			XlglRule file1 = new XlglRule();
			file1.setId(UUIDUtils.random());
			file1.setInfoId(fileId);
			file1.setFileName(fileName);
			file1.setUploadUser(CurrentUser.getUsername());
			file1.setType(type);
			file1.setCreatedTime(new Date());
			xlglRuleService.save(file1);
	
	
		json.put("fileId", fileId);
	
		Response.json(json);
	}
/*	@ResponseBody
	@RequestMapping("/uploadFile")
	public void upLoad(@RequestParam(required = false) MultipartFile file) {
		JSONObject json = new JSONObject();
		String fileId = FileBaseUtil.fileServiceUpload(file);
		json.put("fileId", fileId);
		Response.json(json);
	}
	
	@ResponseBody
	@RequestMapping("/uploadFileSave")
	public void upLoad(String[] ids,String type) {
		for (String string : ids) {
			HTTPFile httpFile = new HTTPFile(string);
			XlglRule file1 = new XlglRule();
			file1.setId(UUIDUtils.random());
			file1.setInfoId(string);
			file1.setFileName(httpFile.getFileName());
			file1.setUploadUser(CurrentUser.getUsername());
			file1.setType(type);
			file1.setCreatedTime(new Date());
			xlglRuleService.save(file1);
		}
	}*/
	
	
	@ResponseBody
	@RequestMapping("/downLoad")
	public void downLoad(String fileId,HttpServletResponse response) throws IOException {
		OutputStream os = null;
		byte[] buff = new byte[1024];
		HTTPFile httpFile = new HTTPFile(fileId);
		String fileName = httpFile.getFileName();
		response.reset();
		response.setContentType("application/octet-stream");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
		os = response.getOutputStream();
		BufferedInputStream bis = new BufferedInputStream(httpFile.getInputSteam());
		int i = 0;
		try {
			while ((i = bis.read(buff)) != -1) {
				os.write(buff, 0, i);
				os.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			bis.close();
		}
	}


	@ResponseBody
	@RequestMapping("/downLoadFile")
	public void downLoad(String fileId) {
		HTTPFile httpFile = new HTTPFile(fileId);
		String fileName = httpFile.getFileName();
		Response.download(fileName, httpFile.getInputSteam());
	}

	
}
