package com.css.app.xlgl.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;
import com.css.addbase.orgservice.OrgService;
import com.css.addbase.orgservice.Organ;
import com.css.app.xlgl.entity.XlglPicture;
import com.css.app.xlgl.entity.XlglSafetyAnalyse;
import com.css.app.xlgl.entity.XlglSafetyCheckup;
import com.css.app.xlgl.service.XlglPictureService;
import com.css.app.xlgl.service.XlglSafetyAnalyseService;
import com.css.app.xlgl.service.XlglSafetyCheckupService;
import com.css.base.entity.SSOUser;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.PageUtils;
import com.css.base.utils.Response;
import com.css.base.utils.UUIDUtils;
import com.github.pagehelper.PageHelper;

import cn.com.css.filestore.impl.HTTPFile;
import net.sf.json.JSONObject;


/**
 * 安全管理-安全分析与预案表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-20 16:39:37
 */
@Controller
@RequestMapping("/app/xlgl/xlglsafetyanalyse")
public class XlglSafetyAnalyseController {
	@Autowired
	private XlglSafetyAnalyseService xlglSafetyAnalyseService;
	@Autowired
	private OrgService orgService;
	@Autowired
	private XlglPictureService xlglPictureService;
	@Autowired
	private XlglSafetyCheckupService xlglSafetyCheckupService;
	
	/**
	 * 列表
	 * @param 按月季度查询
	 */
	@ResponseBody
	@RequestMapping("/list")
	public void list(Integer page, Integer limit,String quarter){
		Map<String, Object> map = new HashMap<>();
		map.put("quarter", quarter);
		PageHelper.startPage(page, limit);
		//查询列表数据
		List<XlglSafetyAnalyse> xlglSafetyAnalyseList = xlglSafetyAnalyseService.queryList(map);
		PageUtils pageUtil = new PageUtils(xlglSafetyAnalyseList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info")
	public void info(String id){
		JSONObject jsonObject = new JSONObject();
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		XlglSafetyAnalyse xlglSafetyAnalyse = xlglSafetyAnalyseService.queryObject(id);
		List<XlglPicture> queryList = xlglPictureService.queryList(map);
		jsonObject.put("list", queryList);
		jsonObject.put("xlglSafetyAnalyse", xlglSafetyAnalyse);
		Response.json(jsonObject);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	public void save(XlglSafetyAnalyse xlglSafetyAnalyse,String [] fileIds){
		String userId = CurrentUser.getUserId();
		String username = CurrentUser.getUsername();
		Date date = new Date();
		String random = UUIDUtils.random();
		xlglSafetyAnalyse.setId(random);
		if(fileIds.length>0) {
			xlglSafetyAnalyse.setStatus("1");
		}else {
			xlglSafetyAnalyse.setStatus("0");
		}
		xlglSafetyAnalyse.setCreateUser(userId);
		xlglSafetyAnalyse.setCreateDate(date);
		xlglSafetyAnalyse.setCreateUsername(username);
		xlglSafetyAnalyse.setUpdateDate(date);
		xlglSafetyAnalyse.setUpdateUser(userId);
		xlglSafetyAnalyse.setUploadDate(date);
		xlglSafetyAnalyse.setUploadUser(userId);
		xlglSafetyAnalyseService.save(xlglSafetyAnalyse);
		for (int i = 0; i < fileIds.length; i++) {
			XlglPicture xlglPicture = new XlglPicture();
			xlglPicture.setId(UUIDUtils.random());
			xlglPicture.setFileId(random);
			xlglPicture.setIsFirst("1");
			xlglPicture.setPictureId(fileIds[i]);
			xlglPicture.setSort("0");
			xlglPicture.setCreateTime(date);
			xlglPicture.setUserId(userId);
			xlglPicture.setUserName(username);
			xlglPictureService.save(xlglPicture);
		}
		Response.ok();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public void update(XlglSafetyAnalyse xlglSafetyAnalyse){
		xlglSafetyAnalyseService.update(xlglSafetyAnalyse);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public void delete(String[] ids){
		xlglSafetyAnalyseService.deleteBatch(ids);
		
		Response.ok();
	}
	
	/**
	 * 上传
	 * @param file
	 */
	@ResponseBody
	@RequestMapping("/uploadPicture")
	public void uploadPicture(@RequestParam(value="file",required=false) MultipartFile[] file ){
		JSONObject json = new JSONObject();
		LinkedList<String> filePathList = new LinkedList<String>();
		LinkedList<String> fileidList = new LinkedList<String>();
		try {
			for (MultipartFile multipartFile : file) {
				 HTTPFile httpFile=HTTPFile.save( multipartFile.getInputStream(),multipartFile.getOriginalFilename());
				 filePathList.add(httpFile.getFilePath()); 
				 fileidList.add(httpFile.getFileId());
			}
			 json.put("filePath",filePathList);
			 json.put("fileid", fileidList);
			 Response.json(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 安全检查上传
	 * @param file
	 */
	@ResponseBody
	@RequestMapping("/upload")
	public void uploadPicture(@RequestParam(value="file",required=false) MultipartFile file ){
		SSOUser ssoUser = CurrentUser.getSSOUser();
		Date date = new Date();
		JSONObject json = new JSONObject();
		Map<String, Object> map = new HashMap<>();
		map.put("orgId", ssoUser.getOrganId());
		List<XlglSafetyCheckup> queryList = xlglSafetyCheckupService.queryList(map);
		 String filePath = "";
		 String fileId = "";
		 String fileName = "";
		try {
			 HTTPFile httpFile=HTTPFile.save( file.getInputStream(),file.getOriginalFilename());
			 filePath = httpFile.getFilePath();
			 fileId = httpFile.getFileId();
			 fileName = httpFile.getFileName();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(queryList.size()>0) {
			XlglSafetyCheckup xlglSafetyCheckup = queryList.get(0);
			xlglSafetyCheckup.setFileId(fileId);
			xlglSafetyCheckup.setFileName(fileName);
			xlglSafetyCheckup.setUpdateDate(date);
			xlglSafetyCheckup.setUpdateUser(ssoUser.getUserId());
			xlglSafetyCheckupService.update(xlglSafetyCheckup);
		}else {
			XlglSafetyCheckup xlglSafetyCheckup = new XlglSafetyCheckup();
			xlglSafetyCheckup.setFileId(fileId);
			xlglSafetyCheckup.setFileName(fileName);
			xlglSafetyCheckup.setOrgId(ssoUser.getOrganId());
			xlglSafetyCheckup.setOrgName(ssoUser.getOrgName());
			xlglSafetyCheckup.setCreateUser(ssoUser.getUserId());
			xlglSafetyCheckup.setCreateDate(date);
			xlglSafetyCheckup.setUpdateDate(date);
			xlglSafetyCheckup.setUpdateUser(ssoUser.getUserId());
			xlglSafetyCheckupService.save(xlglSafetyCheckup);
		}
		 Response.ok();
	}
	
	/**
	 * 文件下载
	 * @param fileId
	 */
	@ResponseBody
	@RequestMapping("/downloadPicture")
	public void downloadPicture(String fileId){
		HTTPFile httpFile = new HTTPFile(fileId);
		String filePath = httpFile.getFilePath();
		Response.json(filePath);
	}
	

	
	@RequestMapping(value = "/tree")
	@ResponseBody
	public Object getDeptTree(HttpServletRequest request) {
		JSONObject list=  getOrganTree("root");
		JSONObject json = new JSONObject();
		json.put("opened", true);
		list.put("state", json);
		return list;
	}
	
	
	public JSONObject getOrganTree(String id){
		JSONObject result = new JSONObject();
		JSONArray jsons = new JSONArray();
		Organ organ = orgService.getOrgan(id);
		result.put("id", organ.getOrganId());
		result.put("text", organ.getOrganName());
		Organ[] organs = orgService.getSubOrg(id, true, true);
		for (Organ sysOrgan:organs) {
			JSONObject json = new JSONObject();
			json.put("id", sysOrgan.getOrganId());
			json.put("text", sysOrgan.getOrganName());
		    jsons.add(getOrganTree(sysOrgan.getOrganId()));
		}
		if (jsons.size()>0) {
			result.put("children", jsons);
		}
		return result;
	}
	
}
