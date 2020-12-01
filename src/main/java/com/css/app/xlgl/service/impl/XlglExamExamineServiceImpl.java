package com.css.app.xlgl.service.impl;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.css.app.xlgl.dao.XlglExamExamineDao;
import com.css.app.xlgl.dto.ExamMainAnswerAnalyseDto;
import com.css.app.xlgl.entity.XlglExamExamine;
import com.css.app.xlgl.service.XlglExamExamineService;
import com.alibaba.fastjson.JSONObject;



@Service("xlglExamExamineService")
public class XlglExamExamineServiceImpl implements XlglExamExamineService {
	@Autowired
	private XlglExamExamineDao xlglExamExamineDao;
	
	@Override
	public XlglExamExamine queryObject(String id){
		return xlglExamExamineDao.queryObject(id);
	}
	
	@Override
	public List<XlglExamExamine> queryList(Map<String, Object> map){
		return xlglExamExamineDao.queryList(map);
	}
	
	@Override
	public void save(XlglExamExamine xlglExamExamine){
		xlglExamExamineDao.save(xlglExamExamine);
	}
	
	@Override
	public void update(XlglExamExamine xlglExamExamine){
		xlglExamExamineDao.update(xlglExamExamine);
	}
	
	@Override
	public void delete(String id){
		xlglExamExamineDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		xlglExamExamineDao.deleteBatch(ids);
	}

	@Override
	public int findCount(Map<String, Object> map) {
		return xlglExamExamineDao.findCount(map);
	}

	@Override
	public List<XlglExamExamine> queryVerifyList(Map<String, Object> map) {
		return xlglExamExamineDao.queryVerifyList(map);
	}

	@Override
	public InputStream createExcelInfoFlie(List<ExamMainAnswerAnalyseDto> list, String[] title, String fileName,JSONObject json,String totalName,String listName) throws Exception {
		FileOutputStream fout = null;
		String[] totalTitle = new String [] {"参考率","已考人数","待考人数","优秀率","优良率","及格率"};
		try {
			HSSFWorkbook wb = new HSSFWorkbook();
			
			HSSFCellStyle style = wb.createCellStyle();
			style.setAlignment(HorizontalAlignment.CENTER);//样式左右居中
			
			HSSFSheet sheet = wb.createSheet();
			CellRangeAddress region = new CellRangeAddress(0,0,0,6);//起始行，结束行，起始列，结束列
			sheet.addMergedRegion(region);
			
			CellRangeAddress region2 = new CellRangeAddress(3,3,0,7);//起始行，结束行，起始列，结束列
			sheet.addMergedRegion(region2);
			
			HSSFRow row = sheet.createRow(0);
			HSSFCell totalCell = row.createCell(0);
			totalCell.setCellStyle(style);
			totalCell.setCellValue(totalName);
			
			HSSFRow row1 = sheet.createRow(1);
			for (int i = 0; i < totalTitle.length; i++) {
				HSSFCell createCell = row1.createCell(i);
				createCell.setCellValue(totalTitle[i]);
			}
			HSSFRow row2 = sheet.createRow(2);
			HSSFCell row2cell0 = row2.createCell(0);
			Float raioAll = json.getFloat("raioAll");
			row2cell0.setCellValue(raioAll+"%");
			
			HSSFCell row2cell1 = row2.createCell(1);
			Integer peopleNum = json.getInteger("peopleNum");
			row2cell1.setCellValue(peopleNum);
			
			HSSFCell row2cell2 = row2.createCell(2);
			Integer fillUpNum = json.getInteger("fillUpNum");
			row2cell2.setCellValue(fillUpNum);
			
			HSSFCell row2cell3 = row2.createCell(3);
			Float excellent = json.getFloat("excellent");
			row2cell3.setCellValue(excellent+"%");
			
			HSSFCell row2cell4 = row2.createCell(4);
			Float fine = json.getFloat("fine");
			row2cell4.setCellValue(fine+"%");
			
			HSSFCell row2cell5 = row2.createCell(5);
			Float pass = json.getFloat("pass");
			row2cell5.setCellValue(pass+"%");
			
			HSSFRow row3 = sheet.createRow(3);
			HSSFCell row3cell0 = row3.createCell(0);
			row3cell0.setCellValue(listName);
			row3cell0.setCellStyle(style);
			
			HSSFRow row4 = sheet.createRow(4);
			for (int i = 0; i < title.length; i++) {
				HSSFCell createCell = row4.createCell(i);
				createCell.setCellValue(title[i]);
			}
			for (int i = 1; i < list.size(); i++) {
				HSSFRow rows = sheet.createRow(i+4);
				HSSFCell cell0 = rows.createCell(0);// 单位名称
				cell0.setCellValue(list.get(i-1).getOrganName());
				
				HSSFCell cell1 = rows.createCell(1);// 参考率
				cell1.setCellValue(list.get(i - 1).getRaioAll());
				
				HSSFCell cell2 = rows.createCell(2);// 已(参)考人数
				cell2.setCellValue(list.get(i - 1).getPeopleNum());
				
				HSSFCell cell3 = rows.createCell(3);// 待考人数
				cell3.setCellValue(list.get(i - 1).getFillUpNum());
				
				HSSFCell cell4 = rows.createCell(4);// 优秀率
				cell4.setCellValue(list.get(i - 1).getExcellentlv()+"%");
				
				HSSFCell cell5 = rows.createCell(5);// 优良率
				cell5.setCellValue(list.get(i - 1).getFinelv());
				
				HSSFCell cell6 = rows.createCell(6);// 及格率
				cell6.setCellValue(list.get(i - 1).getPasslv());
			}
			fout = new FileOutputStream(fileName);
			wb.write(fout);
			fout.flush();
		}catch(Exception  e) {
			e.printStackTrace();
		}finally {
			fout.close();
		}
		return new FileInputStream(fileName);
	}
	
}
