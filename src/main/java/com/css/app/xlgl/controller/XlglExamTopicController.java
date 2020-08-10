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

import com.css.app.xlgl.entity.XlglExamTopic;
import com.css.app.xlgl.service.XlglExamTopicService;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.PageUtils;
import com.css.base.utils.Response;
import com.css.base.utils.UUIDUtils;
import com.github.pagehelper.PageHelper;


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
	@Value("${filePath}")
	private String filePath;
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	public void list(Integer page, Integer limit,String subjectId,
			String topicType,String topicColumn){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		map.put("subjectId", subjectId);
		map.put("topicType", topicType);
		map.put("topicColumn", topicColumn);
		
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
	  *@param topicType 1：单选，2：多选，3：判断，4：填空，5：简答。
	  * 下载模板
	  * */
	@RequestMapping("/downloadFile")
	 public void downloadFile(HttpServletRequest request,HttpServletResponse response,String topicType) {
		 FileOutputStream fout = null;
		 String fileName = "题目模板";
		 Workbook wb = new HSSFWorkbook();
		 CellStyle style = wb.createCellStyle();
		 style.setAlignment(HorizontalAlignment.CENTER);
		 if(topicType !=null &&(topicType.equals("1")||topicType.equals("2"))) {
			 String type = "单选题";
			 if(topicType.equals("2")) {
				 type = "多选题";
			 }
			 fileName =fileName+"-"+type+".xls";
			 Sheet sheet = wb.createSheet(type);
			 CellRangeAddress cellRangeAddress = new CellRangeAddress(0,0,0,6);
			 sheet.addMergedRegion(cellRangeAddress);
			 Row row = sheet.createRow(0);
			 row.createCell(0).setCellValue(type);
			 Row row1 = sheet.createRow(1);
			 row1.createCell(0).setCellValue("题目");
			 row1.createCell(1).setCellValue("A");
			 row1.createCell(2).setCellValue("B");
			 row1.createCell(3).setCellValue("C");
			 row1.createCell(4).setCellValue("D");
			 row1.createCell(5).setCellValue("答案");
		 }else if(topicType !=null &&(topicType.equals("3")||topicType.equals("4"))) {
			 String type = "判断题";
			 if(topicType.equals("4")) {
				 type = "填空题";
			 }
			 fileName =fileName+"-"+type+".xls";
			 Sheet sheet = wb.createSheet(type);
			 CellRangeAddress cellRangeAddress = new CellRangeAddress(0,0,0,6);
			 sheet.addMergedRegion(cellRangeAddress);
			 Row row = sheet.createRow(0);
			 row.createCell(0).setCellValue(type);
			 Row row1 = sheet.createRow(1);
			 row1.createCell(0).setCellValue("题目");
			 row1.createCell(1).setCellValue("答案");
		 }
		 File tempFile=new File(filePath,fileName);
		 Map<String,Object> resultMap =new HashMap<String,Object>();
		 try {
			 fout = new FileOutputStream(tempFile.getAbsolutePath());
			 FileInputStream is = new FileInputStream(tempFile.getAbsolutePath());
			 is.close();
			 wb.write(fout);
			 fout.flush();
			 fout.flush();
			 wb.close();
			 resultMap.put("code","200");
			 resultMap.put("fileUrl", tempFile.getAbsoluteFile());
			 resultMap.put("fileName",tempFile.getName());
			 resultMap.put("result","success");
		} catch (IOException e) {
			e.printStackTrace();
			Response.error();
		}finally {
		      if (fout != null) {
			        try {
						fout.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			      }
			    }
		 Response.json(resultMap);
	 }
	 
	 /**
	  * 题目导入
	 * @throws Exception 
	  * */
	 @RequestMapping("/readExcelSave")
	 public void readExcelSave(HttpServletRequest request,String subjectId, @RequestParam(required = false) MultipartFile file)  {
		 try {
			InputStream fileInputStream = new FileInputStream(file.getOriginalFilename());
			List<XlglExamTopic> readExcelLists = xlglExamTopicService.readExcelLists(fileInputStream,subjectId);
			xlglExamTopicService.saveList(readExcelLists);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			Response.error();
		}catch (Exception e) {
			e.printStackTrace();
			Response.error();
		}
		 Response.ok();
	 } 
	 
	
}
