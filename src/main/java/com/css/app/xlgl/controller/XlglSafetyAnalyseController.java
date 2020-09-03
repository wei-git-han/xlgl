package com.css.app.xlgl.controller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;
import com.css.addbase.FileBaseUtil;
import com.css.addbase.apporgan.service.BaseAppOrganService;
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
import com.css.base.utils.StringUtils;
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
	@Autowired
	private BaseAppOrganService baseAppOrganService;
	
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
		if(fileIds !=null) {
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
		if(fileIds !=null) {
			for (int i = 0; i < fileIds.length; i++) {
				XlglPicture xlglPicture = new XlglPicture();
				xlglPicture.setId(UUIDUtils.random());
				xlglPicture.setFileId(random);
				xlglPicture.setIsFirst("1");
				xlglPicture.setPictureId(fileIds[i]);
				HTTPFile httpFile = new HTTPFile(fileIds[i]);
				xlglPicture.setPictureName(httpFile.getFileName());
				xlglPicture.setSort("0");
				xlglPicture.setCreateTime(date);
				xlglPicture.setUserId(userId);
				xlglPicture.setUserName(username);
				xlglPictureService.save(xlglPicture);
			}
		}
		Response.ok();
	}
	/**
	 * 详情里文件列表
	 * */
	@ResponseBody
	@RequestMapping("/infoList")
	public void infoList(String organId,String id){
		Map<String, Object> map = new HashMap<>();
		map.put("organId", organId);	
		List<XlglSafetyAnalyse> list = new ArrayList<XlglSafetyAnalyse>();
		//查询列表数据
		List<XlglSafetyAnalyse> xlglSafetyAnalyseList = xlglSafetyAnalyseService.queryList(map);
		for (XlglSafetyAnalyse xlglSafetyAnalyse : xlglSafetyAnalyseList) {
			map.put("id", xlglSafetyAnalyse.getId());
			List<XlglPicture> queryList = xlglPictureService.queryList(map);
			for (XlglPicture xlglPicture : queryList) {
				XlglSafetyAnalyse xsa = new XlglSafetyAnalyse();
				xsa.setFileIds(xlglPicture.getPictureId());
				xsa.setFileName(xlglPicture.getPictureName());
				xsa.setId(xlglPicture.getId());
				xsa.setUploadDate(xlglPicture.getCreateTime());
				xsa.setCreateUsername(xlglPicture.getUserName());
				xsa.setCreateUser(xlglPicture.getUserId());
				list.add(xsa);
			}
		}
		Response.json(list);
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
	 * 删除文件
	 */
	@ResponseBody
	@RequestMapping("/deletePicture")
	public void deletePicture(String[] ids){
		xlglPictureService.deleteBatch(ids);
		
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
	 * 安全检查上传
	 * @param file
	 */
	@ResponseBody
	@RequestMapping("/upload")
	public void upload(@RequestParam(value="file",required=false) MultipartFile file,String orgId){
		SSOUser ssoUser = CurrentUser.getSSOUser();
		Date date = new Date();
		JSONObject json = new JSONObject();
		Organ organ = orgService.getOrgan(orgId);
		 String fileId = "";
		 String fileName = "";
		try {
			 HTTPFile httpFile=HTTPFile.save(file.getInputStream(),file.getOriginalFilename());
			 //fileId = FileBaseUtil.fileServiceUpload(file);
			 fileName = file.getOriginalFilename();
			 fileId = httpFile.getFileId();
			 json.put("fileId", fileId);
			
		} catch (Exception e) {
			e.printStackTrace();
			Response.error();
		}
			XlglSafetyCheckup xlglSafetyCheckup = new XlglSafetyCheckup();
			xlglSafetyCheckup.setFileId(fileId);
			xlglSafetyCheckup.setFileName(fileName);
			xlglSafetyCheckup.setOrgId(orgId);
			xlglSafetyCheckup.setOrgName(organ.getOrganName());
			xlglSafetyCheckup.setCreateUser(ssoUser.getUserId());
			xlglSafetyCheckup.setCreateDate(date);
			xlglSafetyCheckup.setUpdateDate(date);
			xlglSafetyCheckup.setUpdateUser(ssoUser.getUserId());
			xlglSafetyCheckup.setCreateUserName(ssoUser.getFullname());
			xlglSafetyCheckup.setId(UUIDUtils.random());
			xlglSafetyCheckupService.save(xlglSafetyCheckup);
		
		json.put("code", "0");
		json.put("msg", "success");
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

	/**
	 * 部门树
	 * */
	@RequestMapping(value = "/tree")
	@ResponseBody
	public Object getDeptTree(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		JSONObject list=  getOrganTree("root",map);
		JSONObject json = new JSONObject();
		json.put("opened", true);
		list.put("state", json);
		return list;
	}
	
	
	public JSONObject getOrganTree(String id,Map<String, Object> map){
		JSONObject result = new JSONObject();
		JSONArray jsons = new JSONArray();
		Organ organ = orgService.getOrgan(id);
		result.put("id", organ.getOrganId());
		result.put("text", organ.getOrganName());
		Organ[] organs = orgService.getSubOrg(id, false, true);
		for (Organ sysOrgan:organs) {
			if(!map.containsKey(sysOrgan.getOrganId())) {
				map.put(sysOrgan.getOrganId(), "");
				JSONObject json = new JSONObject();
				json.put("id", sysOrgan.getOrganId());
				json.put("text", sysOrgan.getOrganName());
			    jsons.add(getOrganTree(sysOrgan.getOrganId(),map));
			}
			
		}
		if (jsons.size()>0) {
			result.put("children", jsons);
		}
		return result;
	}
	
}
