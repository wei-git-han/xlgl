package com.css.app.xlgl.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.css.addbase.apporgan.entity.BaseAppOrgan;
import com.css.addbase.apporgan.entity.BaseAppUser;
import com.css.addbase.apporgan.service.BaseAppOrganService;
import com.css.app.xlgl.dao.XlglPhysicalDao;
import com.css.app.xlgl.entity.XlglExamTopic;
import com.css.app.xlgl.entity.XlglPhysical;
import com.css.app.xlgl.service.XlglPhysicalService;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.UUIDUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;




@Service("xlglPhysicalService")
public class XlglPhysicalServiceImpl implements XlglPhysicalService {
	@Autowired
	private XlglPhysicalDao xlglPhysicalDao;
	@Autowired
	private BaseAppOrganService baseAppOrganService;
	
	@Override
	public XlglPhysical queryObject(String id){
		return xlglPhysicalDao.queryObject(id);
	}
	
	@Override
	public List<XlglPhysical> queryList(Map<String, Object> map){
		return xlglPhysicalDao.queryList(map);
	}
	
	@Override
	public void save(XlglPhysical xlglPhysical){
		xlglPhysicalDao.save(xlglPhysical);
	}
	
	@Override
	public void update(XlglPhysical xlglPhysical){
		xlglPhysicalDao.update(xlglPhysical);
	}
	
	@Override
	public void delete(String id){
		xlglPhysicalDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		xlglPhysicalDao.deleteBatch(ids);
	}

	@Override
	public void deleteAllRecord(String[] ids){
		xlglPhysicalDao.deleteAllRecord(ids);
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
				cell.setCellValue("性别");
				cell.setCellStyle(style);

				cell = row.createCell(2);
				cell.setCellValue("年龄");
				cell.setCellStyle(style);

				cell = row.createCell(3);
				cell.setCellValue("身高");
				cell.setCellStyle(style);

				cell = row.createCell(4);
				cell.setCellValue("体重");
				cell.setCellStyle(style);

				cell = row.createCell(5);
				cell.setCellValue("引体向上");
				cell.setCellStyle(style);

				cell = row.createCell(6);
				cell.setCellValue("仰卧起坐");
				cell.setCellStyle(style);

				cell = row.createCell(7);
				cell.setCellValue("30*2米");
				cell.setCellStyle(style);

				cell = row.createCell(8);
				cell.setCellValue("3000米");
				cell.setCellStyle(style);

				cell = row.createCell(9);
				cell.setCellValue("类别");
				cell.setCellStyle(style);

				cell = row.createCell(10);
				cell.setCellValue("出生日期");
				cell.setCellStyle(style);

				cell = row.createCell(11);
				cell.setCellValue("人员id");
				cell.setCellStyle(style);

				cell = row.createCell(12);
				cell.setCellValue("所在部门");
				cell.setCellStyle(style);

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
					row.createCell(11).setCellValue(baseAppUser.getUserId());
					BaseAppOrgan baseAppOrgan = baseAppOrganService.queryDeptNameByUserId(baseAppUser.getOrganid());
					row.createCell(12).setCellValue(baseAppOrgan.getName());
				}
				sheet.setColumnWidth(0, 4400);
				sheet.setColumnWidth(1, 4400);
				sheet.setColumnWidth(2, 6000);
				sheet.setColumnWidth(3, 10000);
				sheet.setColumnWidth(4, 6000);
				sheet.setColumnWidth(5, 4400);
				sheet.setColumnWidth(6, 10000);
				sheet.setColumnWidth(7, 10000);
				sheet.setColumnWidth(8, 4400);
				sheet.setColumnWidth(9, 10000);
				sheet.setColumnWidth(10, 4400);
				sheet.setColumnWidth(11, 4400);
				sheet.setColumnWidth(12, 4400);
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
	public List<XlglPhysical> importExcle(InputStream is,String id) throws Exception {
		List<XlglPhysical> list =new ArrayList<XlglPhysical>();
		Workbook wb =new HSSFWorkbook(is);
		Sheet sheet = wb.getSheetAt(0); // 遍历第一个Sheet
		String title = sheet.getRow(0).getCell(0).getStringCellValue();//标题，用于判断是哪一类题
			for(int i = 1 ;i<=sheet.getLastRowNum(); i ++) {
				XlglPhysical xlglPhysical = new XlglPhysical ();
				xlglPhysical.setId(UUIDUtils.random());
				String steCell0 = sheet.getRow(i).getCell(0).getStringCellValue(); //姓名
				String steCell1 = sheet.getRow(i).getCell(1).getStringCellValue(); //性别
				String steCell2 = sheet.getRow(i).getCell(2).getNumericCellValue()+""; //年龄
				String steCell3 = sheet.getRow(i).getCell(3).getNumericCellValue()+""; //身高
				String steCell4 = sheet.getRow(i).getCell(4).getNumericCellValue()+""; //体重
				String steCell5 = sheet.getRow(i).getCell(5).getNumericCellValue()+""; //引体向上
				String steCell6 = sheet.getRow(i).getCell(6).getNumericCellValue()+""; //仰卧起坐
				String steCell7 = sheet.getRow(i).getCell(7).getNumericCellValue()+""; //30*2米
				String steCell8 = sheet.getRow(i).getCell(8).getNumericCellValue()+""; //3000米
				String steCell9 = sheet.getRow(i).getCell(9).getNumericCellValue()+""; //类别
				Date steCell10 = sheet.getRow(i).getCell(10).getDateCellValue();//生日
				String steCell11 = sheet.getRow(i).getCell(11).getStringCellValue(); //人员id
				String steCell12 = sheet.getRow(i).getCell(12).getStringCellValue();//人员部门
				xlglPhysical.setName(steCell0);
				xlglPhysical.setSex(steCell1);
				xlglPhysical.setHigh(steCell3);
				xlglPhysical.setWight(steCell4);
				xlglPhysical.setYtxs(steCell5);
				xlglPhysical.setYwqz(steCell6);
				xlglPhysical.setSxp(steCell7);
				xlglPhysical.setCpf(steCell8);
				xlglPhysical.setType(steCell9);
				xlglPhysical.setUserId(steCell11);
				xlglPhysical.setDeptName(steCell12);
				xlglPhysical.setAge(steCell2);
				xlglPhysical.setUpId(id);//每次上传的id
				xlglPhysical.setNormal("1");//1是正式导入，0是自己保存
				xlglPhysical.setCreatedTime(new Date());
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				xlglPhysical.setBirthday(simpleDateFormat.format(steCell10));
				list.add(xlglPhysical);
			}
		wb.close();
		is.close();
		return list;
	}

	@Override
	public XlglPhysical queryByUserId(String userId,String year){
		return xlglPhysicalDao.queryByUserId(userId,year);
	}

	@Override
	public String querySort(Map<String,Object> map){
		return xlglPhysicalDao.querySort(map);
	}
	
}
