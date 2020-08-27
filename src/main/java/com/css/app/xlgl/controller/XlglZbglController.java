package com.css.app.xlgl.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.css.filestore.impl.HTTPFile;
import com.alibaba.fastjson.JSONObject;
import com.css.addbase.AppConfig;
import com.css.addbase.FileBaseUtil;
import com.css.addbase.suwell.OfdTransferUtil;
import com.css.app.xlgl.entity.XlglCarsManager;
import com.css.app.xlgl.entity.XlglPicture;
import com.css.app.xlgl.entity.XlglZbgl;
import com.css.app.xlgl.service.XlglZbglService;
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
 * 训练管理装备管理
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-17 19:34:44
 */
@Controller
@RequestMapping("/app/xlgl/xlglzbgl")
public class XlglZbglController {
	@Autowired
	private XlglZbglService xlglZbglService;
	@Autowired
	private AppConfig appConfig;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		//查询列表数据
		List<XlglZbgl> xlglZbglList = xlglZbglService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(xlglZbglList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	@RequiresPermissions("xlglzbgl:info")
	public void info(@PathVariable("id") String id){
		XlglZbgl xlglZbgl = xlglZbglService.queryObject(id);
		Response.json("xlglZbgl", xlglZbgl);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	public void save(XlglZbgl xlglZbgl,@RequestParam(required = false) MultipartFile[] pdf){
		String formatDownPath = "";// 版式文件下载路径
		String retFormatId = null;// 返回的版式文件id
		String streamId = null;// 流式文件id
		String formatId = null;// 版式文件id
		JSONObject json = new JSONObject();
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
					XlglZbgl xlglZbgl1 = xlglZbglService.queryObject(xlglZbgl.getId());
					if(xlglZbgl == null){
						xlglZbgl.setId(UUIDUtils.random());
						xlglZbgl.setCreatedTime(new Date());
						xlglZbgl.setFileId(formatId);
						xlglZbgl.setFileName(fileName);
						xlglZbgl.setCreator(CurrentUser.getUserId());
						xlglZbglService.save(xlglZbgl);
					}else {
						xlglZbgl.setFileId(formatId);
						xlglZbgl.setFileName(fileName);
						xlglZbgl.setCreatedTime(new Date());
						xlglZbglService.update(xlglZbgl);
					}

				}
			}
			json.put("smjId", retFormatId);
			json.put("smjFilePath", formatDownPath);
			json.put("result", "success");
		}

		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("xlglzbgl:update")
	public void update(@RequestBody XlglZbgl xlglZbgl){
		xlglZbglService.update(xlglZbgl);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public void delete(String id){
		String[] ids = id.split(",");
		xlglZbglService.deleteBatch(ids);
		Response.json("result","success");
	}

	@ResponseBody
	@RequestMapping("/uploadFile")
	public void upLoad(@RequestParam(required = false) MultipartFile[] file) {
		JSONObject json = new JSONObject();
		String fileId = FileBaseUtil.fileServiceUpload(file[0]);
		String fileName = file[0].getOriginalFilename();
		json.put("fileId", fileId);
		XlglZbgl file1 = new XlglZbgl();
		xlglZbglService.deleteAll();//上传之前先删除之前的
		file1.setId(UUIDUtils.random());
		file1.setFileId(fileId);
		file1.setFileName(fileName);
		//file1.setFileServerFormatId(formatId);
		file1.setCreatedTime(new Date());
		file1.setCreator(CurrentUser.getUsername());
		xlglZbglService.save(file1);
		Response.json(json);
	}

//	@ResponseBody
//	@RequestMapping("/downLoad")
//	public void downLoad(String fileId) {
//		HTTPFile httpFile = new HTTPFile(fileId);
//		String fileName = httpFile.getFileName();
//		Response.download(fileName, httpFile.getInputSteam());
//	}

	@ResponseBody
	@RequestMapping("/downLoad")
	public void downLoad(String fileId,HttpServletResponse response) throws IOException {
		OutputStream os = null;
		byte[] buff = new byte[1024];
		HTTPFile httpFile = new HTTPFile(fileId);
		String fileName = httpFile.getFileName();
		response.reset();
		response.setContentType("application/octet-stream");
		response.setCharacterEncoding("utf-8");
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

	//获取文件列表
	@ResponseBody
	@RequestMapping("/getFileList")
	public void getFileList(){
		Map<String,Object> map = new HashMap<>();
		List<XlglZbgl> list = xlglZbglService.queryList(map);
		Response.json("list",list);

	}
	
}
