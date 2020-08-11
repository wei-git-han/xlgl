package com.css.app.xlgl.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.css.addbase.FileBaseUtil;
import com.css.app.xlgl.entity.XlglExamFile;
import com.css.app.xlgl.entity.XlglExamTopic;
import com.css.app.xlgl.service.XlglExamFileService;
import com.css.app.xlgl.service.XlglExamTopicService;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.PageUtils;
import com.css.base.utils.Response;
import com.css.base.utils.UUIDUtils;
import com.github.pagehelper.PageHelper;

import cn.com.css.filestore.impl.HTTPFile;


/**
 * 训练管理-考核-题目表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-07-28 16:17:20
 */
@Controller
@RequestMapping("app/xlgl/xlglexamtopic")
public class XlglExamTopicController {
	@Autowired
	private XlglExamTopicService xlglExamTopicService;
	@Autowired
	private XlglExamFileService xlglExamFileService;
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	public void list(Integer page, Integer limit,String subjectId,
			String topicType,String topicColumn){
		Map<String, Object> map = new HashMap<>();
		map.put("subjectId", subjectId);
		map.put("topicType", topicType);
		map.put("topicColumn", topicColumn);
		PageHelper.startPage(page, limit);
		//查询列表数据
		List<XlglExamTopic> xlglExamTopicList = xlglExamTopicService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(xlglExamTopicList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info")
	public void info(String id){
		XlglExamTopic xlglExamTopic = xlglExamTopicService.queryObject(id);
		Response.json("xlglExamTopic", xlglExamTopic);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	public void save(XlglExamTopic xlglExamTopic){
		xlglExamTopic.setId(UUIDUtils.random());
		xlglExamTopicService.save(xlglExamTopic);
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public void update(XlglExamTopic xlglExamTopic){
		Date date = new Date();
		xlglExamTopic.setUpdateDate(date);
		xlglExamTopic.setUpdateUser(CurrentUser.getUserId());
		xlglExamTopicService.update(xlglExamTopic);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public void delete(String[] ids){
		xlglExamTopicService.deleteBatch(ids);
		
		Response.ok();
	}
	
	 /**
	  * 文件下载接口
	  * 下载模板
	  * */
	@RequestMapping("/downloadFile")
	 public void downloadFile(String fileId) {
		HTTPFile httpFile = new HTTPFile(fileId);
		String fileName = httpFile.getFileName();
		Response.download(fileName, httpFile.getInputSteam());
	}
	
	/**
	 * 模板文件上传接口
	 * @param file
	 */
	@ResponseBody
	@RequestMapping("/upLoadFile")
	public void upLoad(@RequestParam(value="file",required = false) MultipartFile file,String fileType) {
		JSONObject json = new JSONObject();
		Map<String, Object> map = new HashMap<>();
		map.put("fileType", fileType);
		String fileId = FileBaseUtil.fileServiceUpload(file);
		json.put("fileId", fileId);
		List<XlglExamFile> queryList = xlglExamFileService.queryList(map);
		if(queryList.size()>0) {
			XlglExamFile xlglExamFile = queryList.get(0);
			if(xlglExamFile.getFileType().equals(fileType)) {
				HTTPFile httpFile = new HTTPFile(xlglExamFile.getFileId());
				httpFile.delete();
				xlglExamFile.setFileId(fileId);
				xlglExamFile.setFileName(file.getName());
				xlglExamFile.setCreateDate(new Date());
				xlglExamFile.setCreateUser(CurrentUser.getUserId());
				xlglExamFileService.update(xlglExamFile);
			}
		}else {
			XlglExamFile xlglExamFile = new XlglExamFile();
			xlglExamFile.setId(UUIDUtils.random());
			xlglExamFile.setFileId(fileId);
			xlglExamFile.setFileName(file.getName());
			xlglExamFile.setFileType(fileType);
			xlglExamFile.setCreateDate(new Date());
			xlglExamFile.setCreateUser(CurrentUser.getUserId());
			xlglExamFileService.save(xlglExamFile);
		}
		Response.json(json);
	}
	
	 /**
	  * 题目导入
	 * @throws Exception 
	  * */
	 @ResponseBody
	 @RequestMapping("/readExcelSave")
	 public void readExcelSave(HttpServletRequest request,String subjectId, @RequestParam(value="file",required = false) MultipartFile file)  {
		 JSONObject json = new JSONObject();
		 try {
			String fileId = FileBaseUtil.fileServiceUpload(file);
			HTTPFile httpFile = new HTTPFile(fileId);
			InputStream fileInputStream = httpFile.getInputSteam();
			List<XlglExamTopic> readExcelLists = xlglExamTopicService.readExcelLists(fileInputStream,subjectId);
			xlglExamTopicService.saveList(readExcelLists);
			json.put("fileId", fileId);
			XlglExamFile xlglExamFile = new XlglExamFile();
			xlglExamFile.setId(UUIDUtils.random());
			xlglExamFile.setFileId(fileId);
			xlglExamFile.setFileName(file.getName());
			xlglExamFile.setCreateDate(new Date());
			xlglExamFile.setCreateUser(CurrentUser.getUserId());
			xlglExamFileService.save(xlglExamFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			Response.error();
		}catch (Exception e) {
			e.printStackTrace();
			Response.error();
		}
		 Response.json(json);
	 } 
	 
	
}
