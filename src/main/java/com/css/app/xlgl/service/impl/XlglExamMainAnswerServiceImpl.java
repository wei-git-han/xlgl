package com.css.app.xlgl.service.impl;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
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

import com.alibaba.fastjson.JSONObject;
import com.css.addbase.apporgan.entity.BaseAppOrgan;
import com.css.addbase.apporgan.service.BaseAppOrganService;
import com.css.addbase.apporgan.util.OrgUtil;
import com.css.app.xlgl.dao.XlglExamMainAnswerDao;
import com.css.app.xlgl.entity.XlglExamMainAnswer;
import com.css.app.xlgl.service.XlglExamMainAnswerService;
import com.css.base.utils.StringUtils;




@Service("xlglExamMainAnswerService")
public class XlglExamMainAnswerServiceImpl implements XlglExamMainAnswerService {
	@Autowired
	private XlglExamMainAnswerDao xlglExamMainAnswerDao;
	@Autowired
	private BaseAppOrganService baseAppOrganService;
	
	@Override
	public XlglExamMainAnswer queryObject(String id){
		return xlglExamMainAnswerDao.queryObject(id);
	}
	
	@Override
	public List<XlglExamMainAnswer> queryList(Map<String, Object> map){
		return xlglExamMainAnswerDao.queryList(map);
	}
	
	@Override
	public void save(XlglExamMainAnswer xlglExamMainAnswer){
		xlglExamMainAnswerDao.save(xlglExamMainAnswer);
	}
	
	@Override
	public void update(XlglExamMainAnswer xlglExamMainAnswer){
		xlglExamMainAnswerDao.update(xlglExamMainAnswer);
	}
	
	@Override
	public void delete(String id){
		xlglExamMainAnswerDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		xlglExamMainAnswerDao.deleteBatch(ids);
	}

	@Override
	public void saveBatch(List<XlglExamMainAnswer> list) {
		xlglExamMainAnswerDao.saveBatch(list);
		
	}

	@Override
	public String queryUserCount(HashMap<String, Object> mapAll) {
		// TODO Auto-generated method stub
		return xlglExamMainAnswerDao.queryUserCount(mapAll);
	}

	@Override
	public int queryTotal(Map<String, Object> map) {	
		return xlglExamMainAnswerDao.queryTotal(map);
	}

	@Override
	public List<XlglExamMainAnswer> findListBySubjectId(Map<String, Object> map) {
		return xlglExamMainAnswerDao.findListBySubjectId(map);
	}

	@Override
	public List<XlglExamMainAnswer> findListAllExam(Map<String, Object> map) {
		return xlglExamMainAnswerDao.findListAllExam(map);
	}

	@Override
	public List<XlglExamMainAnswer> queryExamByUserIdAndExamId(Map<String, Object> map) {
		return xlglExamMainAnswerDao.queryExamByUserIdAndExamId(map);
	}

	@Override
	public List<XlglExamMainAnswer> findExamByOrganId(Map<String, Object> map) {
		return xlglExamMainAnswerDao.findExamByOrganId(map);
	}

	@Override
	public InputStream createExcelInfoFlie(List<XlglExamMainAnswer> list, String[] title, String fileName,JSONObject json,String totalName)
			throws Exception {
		FileOutputStream fout = null;
		String[] totalTitle = new String [] {"参考率","已考人数","待考人数","优秀率","优良率","及格率"};
		try {
			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFCellStyle style = wb.createCellStyle();
			style.setAlignment(HorizontalAlignment.CENTER);//样式左右居中
			
			HSSFSheet sheet = wb.createSheet();
			CellRangeAddress region = new CellRangeAddress(0,0,0,6);//起始行，结束行，起始列，结束列
			sheet.addMergedRegion(region);
			
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
			for (int i = 0; i < title.length; i++) {
				HSSFCell createCell = row3.createCell(i);
				createCell.setCellValue(title[i]);
			}
			for (int i = 1; i < list.size(); i++) {
				HSSFRow rows = sheet.createRow(i+3);
				HSSFCell cell0 = rows.createCell(0);// 姓名
				cell0.setCellValue(list.get(i-1).getReplyUserName());
				
				HSSFCell cell1 = rows.createCell(1);// 部门名称
				cell1.setCellValue(list.get(i-1).getOrganName());
				
				HSSFCell cell2 = rows.createCell(2);// 得分总分数
				cell2.setCellValue(list.get(i-1).getFractionsum());
				
				HSSFCell cell3 = rows.createCell(3);// 考试方式
				if(StringUtils.isNotBlank(list.get(i-1).getMakeupStatus())
						&&list.get(i-1).getMakeupStatus().equals("0")) {
					cell3.setCellValue("正常");
				}else if(StringUtils.isNotBlank(list.get(i-1).getMakeupStatus())
						&&list.get(i-1).getMakeupStatus().equals("1")) {
					cell3.setCellValue("补考");
				}else {
					cell3.setCellValue("正常");
				}
				
				HSSFCell cell4 = rows.createCell(4);// 等级
				cell4.setCellValue(list.get(i-1).getLevel());
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

	@Override
	public List<XlglExamMainAnswer> getListing(String examineId, String makeupStatus, String level,
			String replyUserName, String organId, String isNotExam, String status, String deptId) {
		Map<String, Object> map = new HashMap<>();	
		map.put("examineId", examineId);
		map.put("level", level);
		map.put("makeupStatus", makeupStatus);
		map.put("replyUserName", replyUserName);
		map.put("organId", organId);
		map.put("isNotExam", isNotExam);
		map.put("status", status);
		if(StringUtils.isNotBlank(deptId)) {
			List<BaseAppOrgan> organs = baseAppOrganService.queryList(null);
			List<String> arrayList = new ArrayList<String>();
			arrayList = OrgUtil.getOrganTreeList(organs,organId,true,true,arrayList);
			map.put("deptList", arrayList);
		}
		//查询列表数据
		List<XlglExamMainAnswer> xlglExamMainAnswerList = this.queryList(map);
		return xlglExamMainAnswerList;
	}

	@Override
	public InputStream createExcelNotExam(List<XlglExamMainAnswer> list, String[] title, String fileName,JSONObject json,String totalName)
			throws Exception {
		FileOutputStream fout = null;
		String[] totalTitle = new String [] {"参考率","已考人数","待考人数","优秀率","优良率","及格率"};
		try {
			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFCellStyle style = wb.createCellStyle();
			style.setAlignment(HorizontalAlignment.CENTER);//样式左右居中
			
			HSSFSheet sheet = wb.createSheet();
			CellRangeAddress region = new CellRangeAddress(0,0,0,6);//起始行，结束行，起始列，结束列
			sheet.addMergedRegion(region);
			
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
			for (int i = 0; i < title.length; i++) {
				HSSFCell createCell = row3.createCell(i);
				createCell.setCellValue(title[i]);
			}
			for (int i = 1; i < list.size(); i++) {
				HSSFRow rows = sheet.createRow(i+3);
				HSSFCell cell0 = rows.createCell(0);// 姓名
				cell0.setCellValue(list.get(i-1).getReplyUserName());
				
				HSSFCell cell1 = rows.createCell(1);// 部门名称
				cell1.setCellValue(list.get(i-1).getOrganName());
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
