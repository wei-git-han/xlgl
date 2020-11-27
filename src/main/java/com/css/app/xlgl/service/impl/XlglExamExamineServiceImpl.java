package com.css.app.xlgl.service.impl;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.css.app.xlgl.dao.XlglExamExamineDao;
import com.css.app.xlgl.dto.ExamMainAnswerAnalyseDto;
import com.css.app.xlgl.entity.XlglExamExamine;
import com.css.app.xlgl.service.XlglExamExamineService;




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
	public InputStream createExcelInfoFlie(List<ExamMainAnswerAnalyseDto> list, String[] title, String fileName) throws Exception {
		FileOutputStream fout = null;
		try {
			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet();
			HSSFRow row = sheet.createRow(0);
			for (int i = 0; i < title.length; i++) {
				HSSFCell createCell = row.createCell(i);
				createCell.setCellValue(title[i]);
			}
			for (int i = 1; i < list.size(); i++) {
				HSSFRow rows = sheet.createRow(i);
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
