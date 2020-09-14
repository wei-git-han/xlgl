package com.css.app.xlgl.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.css.app.xlgl.entity.XlglWarCommonSportsFile;
import com.css.app.xlgl.service.XlglWarCommonSportsFileService;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.PageUtils;
import com.css.base.utils.Response;
import com.css.base.utils.UUIDUtils;
import com.github.pagehelper.PageHelper;

import cn.com.css.filestore.impl.HTTPFile;
import net.sf.json.JSONObject;


/**
 * 军事训练-共同训练-军事体育-文件表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-09-12 11:05:50
 */
@Controller
@RequestMapping("/app/xlgl/xlglwarcommonsportsfile")
public class XlglWarCommonSportsFileController {
	@Autowired
	private XlglWarCommonSportsFileService xlglWarCommonSportsFileService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<XlglWarCommonSportsFile> xlglWarCommonSportsFileList = xlglWarCommonSportsFileService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(xlglWarCommonSportsFileList);
		Response.json("page",pageUtil);
	}
	
	/**
	 * 返回一条数据
	 */
	@ResponseBody
	@RequestMapping("/listOne")
	public void listOne(String type){
		JSONObject jsonObject = new JSONObject();
		Map<String, Object> map = new HashMap<>();
		map.put("type", type);
		//查询列表数据
		List<XlglWarCommonSportsFile> xlglWarCommonSportsFileList = xlglWarCommonSportsFileService.queryList(map);
		if(xlglWarCommonSportsFileList.size()>0) {
			XlglWarCommonSportsFile xlglWarCommonSportsFile = xlglWarCommonSportsFileList.get(0);
			jsonObject.put("fileId", xlglWarCommonSportsFile.getFileId());
			jsonObject.put("code", "0");
			jsonObject.put("msg", "success");
		}else {
			jsonObject.put("code", "200");
			jsonObject.put("msg", "请上传标准");
		}
		Response.json(jsonObject);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	public void info(@PathVariable("id") String id){
		XlglWarCommonSportsFile xlglWarCommonSportsFile = xlglWarCommonSportsFileService.queryObject(id);
		Response.json("xlglWarCommonSportsFile", xlglWarCommonSportsFile);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	public void save(XlglWarCommonSportsFile xlglWarCommonSportsFile,String fileId,String fileName){
		Date date = new Date();
		String userId = CurrentUser.getUserId();
		xlglWarCommonSportsFile.setId(UUIDUtils.random());
		xlglWarCommonSportsFile.setFileId(fileId);
		xlglWarCommonSportsFile.setFileName(fileName);
		xlglWarCommonSportsFile.setCreateDate(date);
		xlglWarCommonSportsFile.setCreateUser(userId);
		xlglWarCommonSportsFile.setUpdateDate(date);
		xlglWarCommonSportsFile.setUpdateUser(userId);
		
		xlglWarCommonSportsFileService.save(xlglWarCommonSportsFile);
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public void update(XlglWarCommonSportsFile xlglWarCommonSportsFile){
		xlglWarCommonSportsFileService.update(xlglWarCommonSportsFile);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("xlglwarcommonsportsfile:delete")
	public void delete(String[] ids){
		xlglWarCommonSportsFileService.deleteBatch(ids);
		
		Response.ok();
	}
	
	/**
	 * 上传
	 * @param file
	 */
	@ResponseBody
	@RequestMapping("/upload")
	public void uploadPicture(@RequestParam(value="file",required=false) MultipartFile file ){
		JSONObject json = new JSONObject();
		 try {
			HTTPFile httpFile=HTTPFile.save(file.getInputStream(),file.getOriginalFilename());
			String fileName = httpFile.getFileName();
			String fileId = httpFile.getFileId();
			json.put("fileName", fileName);
			json.put("fileId", fileId);
			json.put("code", "0");
			json.put("msg", "success");
			
		} catch (IOException e) {
			e.printStackTrace();
			json.put("code", "500");
			json.put("msg", "error");
		}
		 Response.json(json);
	}
	
	/**
	 * 文件下载
	 * @param fileId
	 */
	@ResponseBody
	@RequestMapping("/downloadPicture")
	public void downloadPicture(String fileId){
		HTTPFile httpFile = new HTTPFile(fileId);
		Response.download(httpFile.getFileName(), httpFile.getInputSteam());
	}

	/**
	 * 下载功能，只能预览
	 * @param fileId
	 * @param response
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("/downLoad")
	public void downLoad(String fileId)  {
		HTTPFile httpFile = new HTTPFile(fileId);
		String fileName = httpFile.getFileName();
		Response.download(fileName, httpFile.getInputSteam());
	}
	
}
