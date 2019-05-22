package com.css.app.db.business.service.impl;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
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


/** 
 * 读取Excel
 * @throws Exception  
 */ 
@Service
public class ImportExcleServiceImpl implements ImportExcleService {
	private static final String EXCEL_XLS = "xls";
	private static final String EXCEL_XLSX = "xlsx";

	@Override
	public List<List<Object>> getExcleDate(MultipartFile excelFile) {
		String docTypeId = "";
		List<List<Object>> totalLis = new ArrayList<List<Object>>();// 用户存储读取excle数据
		try {
			InputStream in = excelFile.getInputStream();
			// 同时支持新老版本
			Workbook workbook = getWorkbok(in, excelFile);
//			int sheetCount = workbook.getNumberOfSheets(); // Sheet的数量
			/**
			 * 设置当前excel中sheet的下标：0开始
			 */
			Sheet sheet = workbook.getSheetAt(0); // 遍历第一个Sheet
			for (Row row : sheet) {
				List<Object> dataLis = new ArrayList<Object>(15);// 用于存储插入数据库
				/**
				 * 创建list来存储读取wps的值 0：军委办件号；1：文件标题；2、承办人姓名；3、批示指示时间；4、发表批示内容
				 * 5、督办落实情况人员姓名；6、督办落实情况时间；7、督办落实情况内容 8、办理状态名字； 9、承办单位；10、承办人员姓名；11承办人员电话
				 * 12、印发时间；13、文件号；14、工作分工内容
				 */
				List<String> resultLis = new ArrayList<String>(15);// 用户存储读取excle数据
				int rowNum = row.getRowNum();
				try {
					// 第一行获取标题来判断DocTypeId
					if (rowNum == 0) {
						Cell cell = row.getCell(2);
						Object value = getValue(cell);
						switch (String.valueOf(value)) {
						case "军委主席批示指示督办落实情况表":
							docTypeId = "1";
							break;
						case "军委首长批示指示督办落实情况表":
							docTypeId = "2";
							break;
						case "党中央、中央军委、国务院重要决策部署分工落实情况表":
							docTypeId = "3";
							break;
						case "装备发展部领导批示指示督办落实情况表":
							docTypeId = "4";
							break;
						case "装备发展部重要工作分工落实情况表":
							docTypeId = "5";
							break;
						case "其他重要工作落实情况表":
							docTypeId = "6";
							break;
						}
						continue;
					}
					if (rowNum == 1) {
						continue;
					}
					// 如果当前行没有数据，跳出循环
					// if(row.getCell(0).toString().equals("")){
					// continue;
					// }
					// 获取总列数(空格的不计算)
					int columnTotalNum = row.getPhysicalNumberOfCells();
					System.out.println("总列数：" + columnTotalNum);
					int end = row.getLastCellNum();
					for (int i = 0; i < end; i++) {
						Cell cell = row.getCell(i);
						String val = String.valueOf(getValue(cell));
						resultLis.add(val);
					}
					dataLis.add(0, resultLis.get(0));// 军 委办件号
					dataLis.add(1, resultLis.get(1));// 文件标题
					// ---------------------批示指示内容
					String comments = resultLis.get(2);
					String[] tcolSplits = comments.split("\\#");
					List<Map<String, String>> pszsnrLis = new ArrayList<Map<String, String>>();// 批示指示内容
					for (String colSplit : tcolSplits) {
						Map<String, String> pszsnrMap = new HashMap<String, String>();
						String[] detailCommentls = colSplit.split("\\|");
						if (detailCommentls == null || detailCommentls.length != 3) {
							new RuntimeException("批示指示内容缺少内容项！");
						}
						pszsnrMap.put("cbrxm", detailCommentls[0]);// 3、承办人姓名；
						pszsnrMap.put("pszssj", detailCommentls[1]);// 4、批示指示时间
						pszsnrMap.put("pizsnr", detailCommentls[2]);// 5、发表批示内容
						pszsnrLis.add(pszsnrMap);
					}
					dataLis.add(2, pszsnrLis);// 批示指示内容
					// -------------------督办落实情况
					String conditions = resultLis.get(3);
					String[] conditionArray = conditions.split("\\#");
					List<Map<String, String>> dblsqkLis = new ArrayList<Map<String, String>>();// 批示指示内容
					for (String condition : conditionArray) {
						Map<String, String> dblsqkMap = new HashMap<String, String>();
						String[] detailConditions = condition.split("\\|");
						if (detailConditions == null || detailConditions.length != 3) {
							new RuntimeException("督办落实情况缺少内容项！");
						}
						dblsqkMap.put("dblsqkryxm", detailConditions[0]);// 6、督办落实情况人员姓名；
						dblsqkMap.put("dblsqksj", detailConditions[1]);// 7、督办落实情况时间；
						dblsqkMap.put("dblsqknr", detailConditions[2]);// 8、督办落实情况内容
						dblsqkLis.add(dblsqkMap);
					}
					dataLis.add(3, dblsqkLis);// 督办落实情况

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
					String[] undertakesArray = undertakes.split("\\#");
					List<Map<String, String>> undertakeLis = new ArrayList<Map<String, String>>();// 承办单位和人员
					for (String undertake : undertakesArray) {
						Map<String, String> undertakeMap = new HashMap<String, String>();
						String[] detailUndertakes = undertake.split("\\|");
						if (detailUndertakes != null && detailUndertakes.length > 0) {
							undertakeMap.put("cbdw", detailUndertakes[0]);// 承办单位；
							undertakeMap.put("cbr", detailUndertakes[1]);// 承办人；
							undertakeMap.put("cbrdh", detailUndertakes[2]);// 承办人电话
							undertakeLis.add(undertakeMap);
						}

					}
					dataLis.add(5, undertakeLis);// 督办落实情况
					dataLis.add(6, docTypeId);// docTypeId
					totalLis.add(dataLis);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return totalLis;
	}

	private Object getValue(Cell cell) {
		Object obj = null;
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

	/**
	 * 判断文件是否是excel
	 * 
	 * @throws Exception
	 */
//	public void checkExcelVaild(MultipartFile file) throws Exception {
//		if (!file.exists()) {
//			throw new Exception("文件不存在");
//		}
//		if (!(file.isFile() && (file.getName().endsWith(EXCEL_XLS) || file.getName().endsWith(EXCEL_XLSX)))) {
//			throw new Exception("文件不是Excel");
//		}
//	}

}
