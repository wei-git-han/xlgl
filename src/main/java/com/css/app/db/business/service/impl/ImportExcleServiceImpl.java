package com.css.app.db.business.service.impl;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.css.app.db.business.service.ImportExcleService;
import com.css.base.utils.StringUtils;


/** 
 * 读取Excel
 * @throws Exception  
 */ 
@Service
public class ImportExcleServiceImpl implements ImportExcleService {
	private static final String EXCEL_XLS = "xls";
	private static final String EXCEL_XLSX = "xlsx";

	/**
	 * 创建list来存储读取wps键值对对应情况 0：军委办件号；1：文件标题；2、批示指示内容；3、督办落实情况；4、办理状态
	 * 5、承办单位/人员；6、docTypeId；7、印发时间；8、文件号； 9、工作分工内容；
	 */
	@Override
	public List<List<Object>> getExcleDate(MultipartFile excelFile) {
		String docTypeId = "";
		List<List<Object>> totalLis = new ArrayList<List<Object>>();// 用户存储读取excle数据
		try {
			InputStream in = excelFile.getInputStream();
			// 同时支持新老版本
			Workbook workbook = getWorkbok(in, excelFile);
			/**
			 * 设置当前excel中sheet的下标：0开始
			 */
			Sheet sheet = workbook.getSheetAt(0); // 遍历第一个Sheet

			try {
				// 第一行获取标题来判断DocTypeId
				Cell titleCell = sheet.getRow(0).getCell(2);
				Object value = getValue(titleCell);
				switch (String.valueOf(value)) {
				case "军委主席批示指示督办落实情况表":
					docTypeId = "1";
					packDatasForJWZX(docTypeId, totalLis, sheet);
					break;
				case "军委首长批示指示督办落实情况表":
					docTypeId = "2";
					packDatasForJWZX(docTypeId, totalLis, sheet);
					break;
				case "党中央、中央军委、国务院重要决策部署分工落实情况表":
					docTypeId = "3";
					packDatasForZYJC(docTypeId, totalLis, sheet);
					break;
				case "装备发展部领导批示指示督办落实情况表":
					docTypeId = "4";
					packDatasForLDPS(docTypeId, totalLis, sheet);
					break;
				case "装备发展部重要工作分工落实情况表":
					docTypeId = "5";
					packDatasForZYJC(docTypeId, totalLis, sheet);
					break;
				case "其他重要工作落实情况表":
					docTypeId = "6";
					packDatasForZYJC(docTypeId, totalLis, sheet);
					break;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return totalLis;
	}

	/**
	 * JW主席批示指示督办落实情况表 军委首长批示指示督办落实情况表 装备发展部领导批示指示督办落实情况表
	 * 
	 * @param docTypeId
	 * @param totalLis
	 * @param sheet
	 */
	private void packDatasForJWZX(String docTypeId, List<List<Object>> totalLis, Sheet sheet) {
		for (Row row : sheet) {
			List<Object> dataLis = new ArrayList<Object>(15);// 用于存储插入数据库
			List<String> resultLis = new ArrayList<String>(15);// 用户存储读取excle数据
			int rowNum = row.getRowNum();
			if (rowNum == 0 || rowNum == 1) {
				continue;
			}
			// 获取总列数(空格的不计算)
			int columnTotalNum = row.getPhysicalNumberOfCells();
			System.out.println("总列数：" + columnTotalNum);
			int end = row.getLastCellNum();
			for (int i = 0; i < end; i++) {
				String val = null;
				Cell cell = row.getCell(i);
				if (cell != null) {
					val = String.valueOf(getValue(cell)).trim();
				} else {
					val = "";
				}
				resultLis.add(val);
			}
			dataLis.add(0, resultLis.get(0));// 军 委办件号
			dataLis.add(1, resultLis.get(1));// 文件标题
			// ---------------------批示指示内容
			String comments = resultLis.get(2);
			if (comments != null && !"".equals(comments) && !"null".equals(comments)) {
				String[] tcolSplits = comments.split("\\#");
				List<Map<String, String>> pszsnrLis = new ArrayList<Map<String, String>>();// 批示指示内容
				for (String colSplit : tcolSplits) {
					Map<String, String> pszsnrMap = new HashMap<String, String>();
					String[] detailCommentls = colSplit.split("\\|");
					if (detailCommentls == null || detailCommentls.length != 3) {
						new Exception("批示指示内容缺少内容项！");
					}
					pszsnrMap.put("szxm", detailCommentls[0]);// 3、承办人姓名；
					pszsnrMap.put("pszssj", detailCommentls[1]);// 4、批示指示时间
					pszsnrMap.put("pizsnr", detailCommentls[2]);// 5、发表批示内容
					pszsnrLis.add(pszsnrMap);
				}
				dataLis.add(2, pszsnrLis);// 批示指示内容
			} else {
				dataLis.add(2, "");// 批示指示内容
			}
			// -------------------督办落实情况
			String conditions = resultLis.get(3);
			if (conditions != null && !"".equals(conditions) && !"null".equals(conditions)) {
				String[] conditionArray = conditions.split("\\#");
				List<Map<String, String>> dblsqkLis = new ArrayList<Map<String, String>>();// 批示指示内容
				for (String condition : conditionArray) {
					Map<String, String> dblsqkMap = new HashMap<String, String>();
					String[] detailConditions = condition.split("\\|");
					if (detailConditions == null || detailConditions.length != 4) {
						new Exception("督办落实情况缺少内容项！");
					}
					dblsqkMap.put("dblsqkrydw", detailConditions[0]);// 督办落实情况人员单位；
					dblsqkMap.put("dblsqkryxm", detailConditions[1]);// 督办落实情况人员姓名；
					dblsqkMap.put("dblsqksj", detailConditions[2]);// 督办落实情况时间；
					dblsqkMap.put("dblsqknr", detailConditions[3]);// 督办落实情况内容
					dblsqkLis.add(dblsqkMap);
				}
				dataLis.add(3, dblsqkLis);// 督办落实情况
			} else {
				dataLis.add(3, "");// 督办落实情况

			}

			// ---------------------办理状态
			Integer bjStatus = null;
			switch (resultLis.get(4)) {
			case "办理中":
				bjStatus = 1;
				break;
			case "办结":
				bjStatus = 2;
				break;
			case "常态落实":
				bjStatus = 3;
				break;
			}
			dataLis.add(4, bjStatus);// 状态

			// ---------------------承办单位和人员
			String undertakes = resultLis.get(5);
			if (undertakes != null && !"".equals(undertakes) && !"null".equals(undertakes)) {
				String[] undertakesArray = undertakes.split("\\#");
				List<Map<String, String>> undertakeLis = new ArrayList<Map<String, String>>();// 承办单位和人员
				for (String undertake : undertakesArray) {
					Map<String, String> undertakeMap = new HashMap<String, String>();
					String[] detailUndertakes = undertake.split("\\|");
					if (detailUndertakes != null && detailUndertakes.length > 0) {
						undertakeMap.put("cbdw", detailUndertakes[0]);// 承办单位；
						if (StringUtils.equals("*", detailUndertakes[1])) {
							undertakeMap.put("cbr", "");// 承办人；
						} else {
							undertakeMap.put("cbr", detailUndertakes[1]);// 承办人；
						}
						if (StringUtils.equals("*", detailUndertakes[2])) {
							undertakeMap.put("cbrdh", "");// 承办人；
						} else {
							undertakeMap.put("cbrdh", detailUndertakes[2]);// 承办人电话
						}
						undertakeLis.add(undertakeMap);
					}
				}
				dataLis.add(5, undertakeLis);// 承办单位和人员
			} else {
				dataLis.add(5, "");// 承办单位和人员
			}
			dataLis.add(6, docTypeId);// docTypeId
			totalLis.add(dataLis);
		}
	}

	private void packDatasForLDPS(String docTypeId, List<List<Object>> totalLis, Sheet sheet) {
		for (Row row : sheet) {
			List<Object> dataLis = new ArrayList<Object>(15);// 用于存储插入数据库
			List<String> resultLis = new ArrayList<String>(15);// 用户存储读取excle数据
			int rowNum = row.getRowNum();
			if (rowNum == 0 || rowNum == 1) {
				continue;
			}
			// 获取总列数(空格的不计算)
			int columnTotalNum = row.getPhysicalNumberOfCells();
			System.out.println("总列数：" + columnTotalNum);
			int end = row.getLastCellNum();
			for (int i = 0; i < end; i++) {
				Cell cell = row.getCell(i);
				String val = String.valueOf(getValue(cell));
				resultLis.add(val);
			}
			dataLis.add(0, "");
			dataLis.add(1, resultLis.get(0));// 文件标题
			// ---------------------批示指示内容
			String comments = resultLis.get(1);
			if (comments != null && !"".equals(comments) && !"null".equals(comments)) {
				String[] tcolSplits = comments.split("\\#");
				List<Map<String, String>> pszsnrLis = new ArrayList<Map<String, String>>();// 批示指示内容
				for (String colSplit : tcolSplits) {
					Map<String, String> pszsnrMap = new HashMap<String, String>();
					String[] detailCommentls = colSplit.split("\\|");
					if (detailCommentls == null || detailCommentls.length != 3) {
						new Exception("批示指示内容缺少内容项！");
					}
					pszsnrMap.put("szxm", detailCommentls[0]);// 3、承办人姓名；
					pszsnrMap.put("pszssj", detailCommentls[1]);// 4、批示指示时间
					pszsnrMap.put("pizsnr", detailCommentls[2]);// 5、发表批示内容
					pszsnrLis.add(pszsnrMap);
				}
				dataLis.add(2, pszsnrLis);// 批示指示内容
			}else {
				dataLis.add(2, "");// 批示指示内容
			}
			// -------------------督办落实情况
			String conditions = resultLis.get(2);
			if (conditions != null && !"".equals(conditions) && !"null".equals(conditions)) {
				String[] conditionArray = conditions.split("\\#");
				List<Map<String, String>> dblsqkLis = new ArrayList<Map<String, String>>();// 批示指示内容
				for (String condition : conditionArray) {
					Map<String, String> dblsqkMap = new HashMap<String, String>();
					String[] detailConditions = condition.split("\\|");
					if (detailConditions == null || detailConditions.length != 4) {
						new Exception("督办落实情况缺少内容项！");
					}
					dblsqkMap.put("dblsqkrydw", detailConditions[0]);// 督办落实情况人员单位；
					dblsqkMap.put("dblsqkryxm", detailConditions[1]);// 督办落实情况人员姓名；
					dblsqkMap.put("dblsqksj", detailConditions[2]);// 督办落实情况时间；
					dblsqkMap.put("dblsqknr", detailConditions[3]);// 督办落实情况内容
					dblsqkLis.add(dblsqkMap);
				}
				dataLis.add(3, dblsqkLis);// 督办落实情况
			}else {
				dataLis.add(3, "");// 督办落实情况
			}
			// ---------------------办理状态
			Integer bjStatus = null;
			switch (resultLis.get(3)) {
			case "办理中":
				bjStatus = 1;
				break;
			case "办结":
				bjStatus = 2;
				break;
			case "常态落实":
				bjStatus = 3;
				break;
			}
			dataLis.add(4, bjStatus);// 状态

			// ---------------------承办单位和人员
			String undertakes = resultLis.get(4);
			if (undertakes != null && !"".equals(undertakes) && !"null".equals(undertakes)) {
				String[] undertakesArray = undertakes.split("\\#");
				List<Map<String, String>> undertakeLis = new ArrayList<Map<String, String>>();// 承办单位和人员
				for (String undertake : undertakesArray) {
					Map<String, String> undertakeMap = new HashMap<String, String>();
					String[] detailUndertakes = undertake.split("\\|");
					if (detailUndertakes != null && detailUndertakes.length > 0) {
						undertakeMap.put("cbdw", detailUndertakes[0]);// 承办单位；
						if (StringUtils.equals("*", detailUndertakes[1])) {
							undertakeMap.put("cbr", "");// 承办人；
						} else {
							undertakeMap.put("cbr", detailUndertakes[1]);// 承办人；
						}
						if (StringUtils.equals("*", detailUndertakes[2])) {
							undertakeMap.put("cbrdh", "");// 承办人；
						} else {
							undertakeMap.put("cbrdh", detailUndertakes[2]);// 承办人电话
						}
						undertakeLis.add(undertakeMap);
					}
				}
				dataLis.add(5, undertakeLis);// 承办单位和人员
			}else {
				dataLis.add(5, "");// 承办单位和人员

			}
			dataLis.add(6, docTypeId);// docTypeId
			totalLis.add(dataLis);
		}
	}

	/**
	 * 党中央、中央军委、国务院重要决策部署分工落实情况表 ZBFZB重要工作分工落实情况表 其他重要工作落实情况表
	 * 
	 * @param docTypeId
	 * @param totalLis
	 * @param sheet
	 */
	private void packDatasForZYJC(String docTypeId, List<List<Object>> totalLis, Sheet sheet) {
		for (Row row : sheet) {
			List<Object> dataLis = new ArrayList<Object>(10);// 用于存储插入数据库
			List<String> resultLis = new ArrayList<String>();// 用户存储读取excle数据
			int rowNum = row.getRowNum();
			if (rowNum == 0 || rowNum == 1) {
				continue;
			}
			// 获取总列数(空格的不计算)
			int columnTotalNum = row.getPhysicalNumberOfCells();
			System.out.println("总列数：" + columnTotalNum);
			int end = row.getLastCellNum();
			for (int i = 0; i < end; i++) {
				Cell cell = row.getCell(i);
				String val = String.valueOf(getValue(cell));
				resultLis.add(val);
			}
			dataLis.add(0, "");// 印发时间
			dataLis.add(1, resultLis.get(2));// 文件标题
			dataLis.add(2, "");// 文件标题
			// -------------------督办落实情况
			String conditions = resultLis.get(4);
			if (conditions != null && !"".equals(conditions) && !"null".equals(conditions)) {
				String[] conditionArray = conditions.split("\\#");
				List<Map<String, String>> dblsqkLis = new ArrayList<Map<String, String>>();// 批示指示内容
				for (String condition : conditionArray) {
					Map<String, String> dblsqkMap = new HashMap<String, String>();
					String[] detailConditions = condition.split("\\|");
					if (detailConditions == null || detailConditions.length != 4) {
						new RuntimeException("督办落实情况缺少内容项！");
					}
					dblsqkMap.put("dblsqkrydw", detailConditions[0]);// 督办落实情况人员单位；
					dblsqkMap.put("dblsqkryxm", detailConditions[1]);// 6、督办落实情况人员姓名；
					dblsqkMap.put("dblsqksj", detailConditions[2]);// 7、督办落实情况时间；
					dblsqkMap.put("dblsqknr", detailConditions[3]);// 8、督办落实情况内容
					dblsqkLis.add(dblsqkMap);
				}
				dataLis.add(3, dblsqkLis);// 督办落实情况
			}else {
				dataLis.add(3, "");// 督办落实情况

			}
			// ---------------------办理状态
			Integer bjStatus = null;
			switch (resultLis.get(5)) {
			case "办理中":
				bjStatus = 1;
				break;
			case "办结":
				bjStatus = 2;
				break;
			case "常态落实":
				bjStatus = 3;
				break;
			}
			dataLis.add(4, bjStatus);// 状态

			// ---------------------承办单位和人员
			String undertakes = resultLis.get(6);
			if (undertakes != null && !"".equals(undertakes) && !"null".equals(undertakes)) {
				String[] undertakesArray = undertakes.split("\\#");
				List<Map<String, String>> undertakeLis = new ArrayList<Map<String, String>>();// 承办单位和人员
				for (String undertake : undertakesArray) {
					Map<String, String> undertakeMap = new HashMap<String, String>();
					String[] detailUndertakes = undertake.split("\\|");
					if (detailUndertakes != null && detailUndertakes.length > 0) {
						undertakeMap.put("cbdw", detailUndertakes[0]);// 承办单位；
						if (StringUtils.equals("\\*", detailUndertakes[1])) {
							undertakeMap.put("cbr", "");// 承办人；
						} else {
							undertakeMap.put("cbr", detailUndertakes[1]);// 承办人；
						}
						if (StringUtils.equals("\\*", detailUndertakes[2])) {
							undertakeMap.put("cbrdh", "");// 承办人；
						} else {
							undertakeMap.put("cbrdh", detailUndertakes[2]);// 承办人电话
						}
						undertakeLis.add(undertakeMap);
					}

				}
				dataLis.add(5, undertakeLis);// 督办落实情况
			}else {
				dataLis.add(5, "");// 督办落实情况

			}
			dataLis.add(6, docTypeId);// docTypeId
			dataLis.add(7, resultLis.get(0));// 印发时间
			dataLis.add(8, resultLis.get(1)==null?"":resultLis.get(1));// 文件号
			// ---------------------工作分工内容
			String comments = resultLis.get(3);
			dataLis.add(9, comments==null?"":comments);// 工作分工内容
			totalLis.add(dataLis);
		}
	}

	private Object getValue(Cell cell) {
		Object obj = null;
		if (cell != null) {
			switch (cell.getCellTypeEnum()) {
			case BOOLEAN:
				obj = cell.getBooleanCellValue();
				break;
			case ERROR:
				obj = cell.getErrorCellValue();
				break;
			case NUMERIC:
				obj = cell.getNumericCellValue();
				break;
			case STRING:
				obj = cell.getStringCellValue();
				break;
			default:
				break;
			}
		}
		return obj;
	}

	/**
	 * 判断Excel的版本,获取Workbook
	 * 
	 * @param in
	 * @param filename
	 * @return
	 * @throws IOException
	 */
	public Workbook getWorkbok(InputStream in, MultipartFile file) throws IOException {
		Workbook wb = null;
		if (file.getOriginalFilename().endsWith(EXCEL_XLS)) { // 老版本Excel
			wb = new HSSFWorkbook(in);
		} else if (file.getOriginalFilename().endsWith(EXCEL_XLSX)) { // 新版本Excel
			wb = new XSSFWorkbook(in);
		}
		return wb;
	}

}
