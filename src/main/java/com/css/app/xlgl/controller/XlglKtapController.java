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
import com.css.app.xlgl.entity.XlglKtap;
import com.css.app.xlgl.entity.XlglZbgl;
import com.css.app.xlgl.service.XlglKtapService;
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
 * 训练管理课题安排
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-18 18:32:15
 */
@Controller
@RequestMapping("/app/xlgl/xlglktap")
public class XlglKtapController {
	@Autowired
	private XlglKtapService xlglKtapService;
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
		List<XlglKtap> xlglKtapList = xlglKtapService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(xlglKtapList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 课堂安排一进来先调这个接口，无参数
	 */
	@ResponseBody
	@RequestMapping("/info")
	public void info(){
		JSONObject jsonObject = new JSONObject();
		String isHave = "";
		String fileId = null;
		Map<String,Object> map = new HashMap<>();
		List<XlglKtap> xlglKtap = xlglKtapService.queryList(map);
		if(xlglKtap != null && xlglKtap.size() > 0){
			fileId = xlglKtap.get(0).getFileId();
		}
		jsonObject.put("fileId",fileId);
		jsonObject.put("reuslt","success");
		Response.json(jsonObject);
	}

	/**
	 * 上传接口
	 */
	@ResponseBody
	@RequestMapping("/save111")
	public void save(String id,@RequestParam(required = false)MultipartFile[] pdf){
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
					XlglKtap xlglKtap = new XlglKtap();
					if(StringUtils.isNotBlank(id)){
						xlglKtap = xlglKtapService.queryObject(id);
					}
					if(StringUtils.isNotBlank(xlglKtap.getId())){

						xlglKtap.setFileId(formatId);
						xlglKtap.setFileName(fileName);
						xlglKtap.setCreatedTime(new Date());
						xlglKtapService.update(xlglKtap);
					}else {
						xlglKtap.setId(UUIDUtils.random());
						xlglKtap.setCreatedTime(new Date());
						xlglKtap.setFileId(formatId);
						xlglKtap.setFileName(fileName);
						xlglKtap.setCreator(CurrentUser.getUserId());
						xlglKtapService.save(xlglKtap);
					}

				}
			}
			json.put("smjId", retFormatId);
			json.put("smjFilePath", formatDownPath);
			json.put("result", "success");
		}


		Response.json(json);
	}

	@ResponseBody
	@RequestMapping("/uploadFile")
	public void upLoad(@RequestParam(required = false) MultipartFile[] pdf) {
		JSONObject json = new JSONObject();
		String fileId = FileBaseUtil.fileServiceUpload(pdf[0]);
		String fileName = pdf[0].getOriginalFilename();
		json.put("fileId", fileId);
		xlglKtapService.deleteAll();
		XlglKtap xlglKtap = new XlglKtap();
		xlglKtap.setId(UUIDUtils.random());
		xlglKtap.setFileId(fileId);
		xlglKtap.setFileName(fileName);
		xlglKtap.setCreatedTime(new Date());
		xlglKtap.setCreator(CurrentUser.getUsername());
		//file1.setFileServerFormatId(formatId);
		xlglKtapService.save(xlglKtap);
		json.put("fileId",xlglKtap.getFileId());
		Response.json(json);
	}

	/**
	 * 下载功能，只能预览
	 * @param fileId
	 * @param response
	 * @throws IOException
	 */
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
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("xlglktap:update")
	public void update(@RequestBody XlglKtap xlglKtap){
		xlglKtapService.update(xlglKtap);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("xlglktap:delete")
	public void delete(@RequestBody String[] ids){
		xlglKtapService.deleteBatch(ids);
		
		Response.ok();
	}
	
}
