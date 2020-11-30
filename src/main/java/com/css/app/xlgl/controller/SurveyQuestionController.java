package com.css.app.xlgl.controller;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.css.app.xlgl.service.impl.SurveyQuestionCountServiceImpl;
import com.css.base.utils.CurrentUser;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

import com.css.base.utils.PageUtils;
import com.css.base.utils.UUIDUtils;
import com.github.pagehelper.PageHelper;

import freemarker.template.Configuration;
import freemarker.template.Template;

import com.css.base.utils.Response;
import com.css.addbase.WordUtils;
import com.css.addbase.suwell.ConvertServerConnect;
import com.css.app.xlgl.entity.SurveyCountQuestionExport;
import com.css.app.xlgl.entity.SurveyQuestion;
import com.css.app.xlgl.service.SurveyQuestionService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 调查问卷表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-11-20 18:45:19
 */
@Controller
@RequestMapping("app/surveyquestion")
public class SurveyQuestionController {
	@Autowired
	private SurveyQuestionService surveyQuestionService;
	@Autowired
	private SurveyQuestionCountServiceImpl surveyQuestionCountService;
	@Value("${filePath}")
	private String filePath;
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("surveyquestion:list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);

		//查询列表数据
		List<SurveyQuestion> surveyQuestionList = surveyQuestionService.queryList(map);

		PageUtils pageUtil = new PageUtils(surveyQuestionList);
		Response.json("page",pageUtil);
	}

	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/querySurveyQuestionList")
	public void querySurveyQuestionList(String serveyQuestionId){
		//查询列表数据
		JSONObject surveyQuestionList = surveyQuestionService.querySurveyQuestionList(serveyQuestionId);
		Response.json("surveyQuestionList",surveyQuestionList);
	}

	/**
	 * 调查列表
	 */
	@ResponseBody
	@RequestMapping("/surveyQuestionList")
	public void surveyQuestionList(Integer page, Integer limit, String title) {
		String userId = CurrentUser.getUserId();
		Map<String, Object> map = new HashMap<>();
		map.put("title", title);
		map.put("userId", userId);
		PageHelper.startPage(page, limit);
		// 查询列表数据
		List<SurveyQuestion> xlglWarTacticList = surveyQuestionService.surveyQuestionList(map);;
		PageUtils pageUtil = new PageUtils(xlglWarTacticList);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("rows", xlglWarTacticList);
		result.put("page", pageUtil.getCurrPage());
		result.put("total", pageUtil.getTotalCount());
		Response.json(result);
	}

	/**
	 * 问卷列表导出
	 */
	@ResponseBody
	@RequestMapping("/exportList")
	public void export(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<>();
		map.put("parentId", "root");
		List<SurveyQuestion> xlglWarTacticList = surveyQuestionService.surveyQuestionList(map);
		String serveyQuestionId = request.getParameter("serveyQuestionId");
		String sex = request.getParameter("sex");
		String olds = request.getParameter("olds");
		String area = request.getParameter("area");
//		serveyQuestionId = "cb7fe77e-763c-c76d-a3a7-983ab7ab34bd";
		List<SurveyCountQuestionExport> surveyCountQuestionExportList = surveyQuestionCountService.querySurveyExportList(serveyQuestionId,sex,olds,area);
		
		String format = new SimpleDateFormat("yyyy-MM-ddHHmmss").format(new Date());
		String fileName = "军事体育训练问卷调查-" + format + ".xls";

		File tempFile = new File(filePath, fileName);
		if (tempFile.exists()) {
			tempFile.delete();
		} else {
			tempFile.getParentFile().mkdirs();
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		InputStream is;
		String[] title = { "序号", "题目", "选项", "票数", "百分比"};
		try {
			is = createExcelList(surveyCountQuestionExportList, title, tempFile.getAbsolutePath());
			String string = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
			response.reset();
			response.setContentType("application/octet-stream");
			response.setCharacterEncoding("UTF-8");
			response.setHeader("Content-Disposition", "attachment;filename=" + string);
			OutputStream os = response.getOutputStream();
			BufferedInputStream bis = new BufferedInputStream(is);
			byte[] buff = new byte[1024];
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
				os.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Response.json(resultMap);
	}

	/**
	 * 各单位人员情况统计列表导出
	 */
	private InputStream createExcelList(List<SurveyCountQuestionExport> list, String[] title, String fileName) throws Exception {
		FileOutputStream fout = null;
		try {
			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet("军事体育训练问卷调查");
			HSSFCellStyle cellStyle = wb.createCellStyle();
			cellStyle.setAlignment(HorizontalAlignment.CENTER);
			HSSFRow row = sheet.createRow(0);
//			sheet.addMergedRegion(new CellRangeAddress(1, 3, 0, 0));
			for (int i = 0; i < title.length; i++) {
				HSSFCell createCell = row.createCell(i);
				createCell.setCellValue(title[i]);
			}
			for (int i = 1; i < list.size() + 1; i++) {
				HSSFRow rows = sheet.createRow(i);
				HSSFCell cell0 = rows.createCell(0);// 序号
				cell0.setCellValue(i);
                
				HSSFCell cell1 = rows.createCell(1);// 题目
                cell1.setCellValue(list.get(i - 1).getQuestionContent());

				HSSFCell cell2 = rows.createCell(2);// 选项
				cell2.setCellValue(list.get(i - 1).getOptionContent());

				HSSFCell cell3 = rows.createCell(3);// 实际在位人数
				cell3.setCellValue(list.get(i - 1).getCountNum());

				HSSFCell cell4 = rows.createCell(4);// 人员在未率
				cell4.setCellValue(list.get(i - 1).getCountPercentage());
			}
			fout = new FileOutputStream(fileName);
			wb.write(fout);
			fout.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fout.close();
		}
		return new FileInputStream(fileName);
	}



	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	@RequiresPermissions("surveyquestion:info")
	public void info(@PathVariable("id") String id){
		SurveyQuestion surveyQuestion = surveyQuestionService.queryObject(id);
		Response.json("surveyQuestion", surveyQuestion);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	@RequiresPermissions("surveyquestion:save")
	public void save(@RequestBody SurveyQuestion surveyQuestion){
		surveyQuestion.setId(UUIDUtils.random());
		surveyQuestionService.save(surveyQuestion);
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("surveyquestion:update")
	public void update(@RequestBody SurveyQuestion surveyQuestion){
		surveyQuestionService.update(surveyQuestion);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("surveyquestion:delete")
	public void delete(@RequestBody String[] ids){
		surveyQuestionService.deleteBatch(ids);
		
		Response.ok();
	}

}
