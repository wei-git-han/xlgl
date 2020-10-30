package com.css.app.xlgl.service.impl;

import com.css.addbase.apporgan.entity.BaseAppOrgan;
import com.css.addbase.apporgan.entity.BaseAppUser;
import com.css.addbase.apporgan.service.BaseAppOrganService;
import com.css.app.xlgl.dao.XlglMineStudyDao;
import com.css.app.xlgl.entity.XlglMineStudy;
import com.css.app.xlgl.entity.XlglPhysical;
import com.css.app.xlgl.service.XlglMineStudyService;
import com.css.base.utils.UUIDUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;



@Service("xlglMineStudyService")
public class XlglMineStudyServiceImpl implements XlglMineStudyService {
	@Autowired
	private XlglMineStudyDao xlglMineStudyDao;
	@Autowired
	private BaseAppOrganService baseAppOrganService;
	
	@Override
	public XlglMineStudy queryObject(String id){
		return xlglMineStudyDao.queryObject(id);
	}
	
	@Override
	public List<XlglMineStudy> queryList(Map<String, Object> map){
		return xlglMineStudyDao.queryList(map);
	}
	
	@Override
	public void save(XlglMineStudy xlglMineStudy){
		xlglMineStudyDao.save(xlglMineStudy);
	}
	
	@Override
	public void update(XlglMineStudy xlglMineStudy){
		xlglMineStudyDao.update(xlglMineStudy);
	}
	
	@Override
	public void delete(String id){
		xlglMineStudyDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		xlglMineStudyDao.deleteBatch(ids);
	}

	@Override
	public void deleteAllRecord(String[] ids){
		xlglMineStudyDao.deleteAllRecord(ids);
	}

	@Override
	public InputStream createExcelInfoFile(List<BaseAppUser> list, String fileName) throws Exception {
		//String ministry = baseAppOrgMappedService.getAppLevelByType(AppConstant.APP_DZBMS);

		FileOutputStream fout = null;
		try {
			int size = list.size();
			HSSFWorkbook wb = new HSSFWorkbook();
			int rowsOfSheet = 5000;
			int sheets = 1;
			if (size > rowsOfSheet) {
				sheets = size % rowsOfSheet != 0 ? size / rowsOfSheet + 1 : size / rowsOfSheet;
			}
			for (int j = 0; j < sheets; j++) {
				HSSFSheet sheet = wb.createSheet("文件列表_" + j);
				HSSFRow row = sheet.createRow(0);
				HSSFCellStyle style = wb.createCellStyle();
				//style.setAlignment((short)2);
				//局级
				HSSFCell cell = row.createCell(0);
				cell.setCellValue("姓名");
				cell.setCellStyle(style);

				cell = row.createCell(1);
				cell.setCellValue("部门名称");
				cell.setCellStyle(style);

				cell = row.createCell(2);
				cell.setCellValue("分数");
				cell.setCellStyle(style);

				cell = row.createCell(3);
				cell.setCellValue("等级");
				cell.setCellStyle(style);

				cell = row.createCell(4);
				cell.setCellValue("人员id");
				cell.setCellStyle(style);

//				cell = row.createCell(5);
//				cell.setCellValue("年份");
//				cell.setCellStyle(style);



				int k = rowsOfSheet;
				if ((size % rowsOfSheet != 0) && (j == size / rowsOfSheet)) {
					k = size % rowsOfSheet;
				}
				if(size==0) {
					k=0;
				}
				for (int i = 0; i < k; i++) {
					row = sheet.createRow(i + 1);
					BaseAppUser baseAppUser = (BaseAppUser) list.get(rowsOfSheet * j + i);
					row.createCell(0).setCellValue(baseAppUser.getTruename());
					row.createCell(4).setCellValue(baseAppUser.getUserId());
					BaseAppOrgan baseAppOrgan = baseAppOrganService.queryDeptNameByUserId(baseAppUser.getOrganid());
					row.createCell(1).setCellValue(baseAppOrgan.getName());
				}
				sheet.setColumnWidth(0, 4400);
				sheet.setColumnWidth(1, 4400);
				sheet.setColumnWidth(2, 6000);
				sheet.setColumnWidth(3, 10000);
				sheet.setColumnWidth(4, 6000);
				//sheet.setColumnWidth(5,4400);
				fout = new FileOutputStream(fileName);
				wb.write(fout);
				fout.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fout != null) {
				fout.close();
			}
		}
		return new FileInputStream(fileName);
	}


	@Override
	public List<XlglMineStudy> importExcle(InputStream is, String id,String year) throws Exception {
		List<XlglMineStudy> list =new ArrayList<XlglMineStudy>();
		Workbook wb =new HSSFWorkbook(is);
		Sheet sheet = wb.getSheetAt(0); // 遍历第一个Sheet
		String title = sheet.getRow(0).getCell(0).getStringCellValue();//标题，用于判断是哪一类题
		for(int i = 1 ;i<=sheet.getLastRowNum(); i ++) {
			XlglMineStudy xlglMineStudy = new XlglMineStudy ();
			xlglMineStudy.setId(UUIDUtils.random());
			String steCell0 = sheet.getRow(i).getCell(0).getStringCellValue(); //姓名
			String steCell1 = sheet.getRow(i).getCell(1).getStringCellValue(); //部门名称
			String steCell2 = sheet.getRow(i).getCell(2).getNumericCellValue()+""; //分数
			String steCell3 = sheet.getRow(i).getCell(3).getStringCellValue()+""; //等级
			String steCell4 = sheet.getRow(i).getCell(4).getStringCellValue(); //人员id
			//String steCell5 = sheet.getRow(i).getCell(5).getStringCellValue();//年份
			xlglMineStudy.setUserName(steCell0);
			xlglMineStudy.setDeptName(steCell1);
			xlglMineStudy.setScore(steCell2);
			xlglMineStudy.setDj(steCell3);
			xlglMineStudy.setUserId(steCell4);
			xlglMineStudy.setUpId(id);//每次上传的id
			xlglMineStudy.setCurentYear(year);
			list.add(xlglMineStudy);
		}
		wb.close();
		is.close();
		return list;
	}

	@Override
	public XlglMineStudy queryByUserId(String userId,String year){
		return xlglMineStudyDao.queryByUserId(userId,year);
	}
	
}
