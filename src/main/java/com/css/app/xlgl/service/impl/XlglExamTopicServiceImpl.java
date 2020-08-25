package com.css.app.xlgl.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.css.app.xlgl.dao.XlglExamTopicDao;
import com.css.app.xlgl.entity.XlglExamTopic;
import com.css.app.xlgl.service.XlglExamTopicService;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.UUIDUtils;



@Service("xlglExamTopicService")
public class XlglExamTopicServiceImpl implements XlglExamTopicService {
	@Autowired
	private XlglExamTopicDao xlglExamTopicDao;
	
	
	@Override
	public XlglExamTopic queryObject(String id){
		return xlglExamTopicDao.queryObject(id);
	}
	
	@Override
	public List<XlglExamTopic> queryList(Map<String, Object> map){
		return xlglExamTopicDao.queryList(map);
	}
	
	@Override
	public void save(XlglExamTopic xlglExamTopic){
		xlglExamTopicDao.save(xlglExamTopic);
	}
	
	@Override
	public void update(XlglExamTopic xlglExamTopic){
		xlglExamTopicDao.update(xlglExamTopic);
	}
	
	@Override
	public void delete(String id){
		xlglExamTopicDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		xlglExamTopicDao.deleteBatch(ids);
	}
	/**
	 * 
	 * 1：单选，2：多选，3：判断，4：填空，5：简答。
	 * */
	@Override
	public List<XlglExamTopic> readExcelLists(InputStream is,String subjectId) throws Exception {
		List<XlglExamTopic> list =new ArrayList<XlglExamTopic>();
		Workbook wb =new HSSFWorkbook(is);
		//int numberOfSheets = wb.getNumberOfSheets();
		Sheet sheet = wb.getSheetAt(0); // 遍历第一个Sheet
		String title = sheet.getRow(0).getCell(0).getStringCellValue();//标题，用于判断是哪一类题
		if(!StringUtils.isEmpty(title)&& (title.equals("单选题") || title.equals("多选题")) ) {
			String type ="1";
			if(title.equals("多选题")) {
				type = "2";
			}
			for(int i = 2 ;i<=sheet.getLastRowNum(); i ++) {
				XlglExamTopic xlglExamTopic = new XlglExamTopic ();
				xlglExamTopic.setId(UUIDUtils.random());
				String steCell = sheet.getRow(i).getCell(0).getStringCellValue(); //题目
				xlglExamTopic.setTopicColumn(steCell);
				String steCell2 = sheet.getRow(i).getCell(1).getStringCellValue(); //选项A
				String steCell3 = sheet.getRow(i).getCell(2).getStringCellValue(); //选项B
				String steCell4 = sheet.getRow(i).getCell(3).getStringCellValue(); //选项C
				String steCell5 = sheet.getRow(i).getCell(4).getStringCellValue(); //选项D
				xlglExamTopic.setTopicOption("A:"+steCell2+",B:"+steCell3+",C:"+steCell4+",D:"+steCell5);//题目选项
				xlglExamTopic.setSubjectId(subjectId);	//科目表id
				String steCell6 = sheet.getRow(i).getCell(5).getStringCellValue(); //答案
				xlglExamTopic.setTopicResult(steCell6);
				xlglExamTopic.setTopicType(type);
				xlglExamTopic.setCreateUser(CurrentUser.getUserId());
				xlglExamTopic.setCreateDate(new Date());
				xlglExamTopic.setUpdateUser(CurrentUser.getUserId());
				xlglExamTopic.setCreateDate(new Date());
				list.add(xlglExamTopic);
			}
		}else if(!StringUtils.isEmpty(title)&& (title.equals("判断题") || title.equals("填空题"))){
			String type ="3";
			if(title.equals("填空题")) {
				type = "4";
			}
			for(int i = 2 ;i<=sheet.getLastRowNum(); i ++) {
				XlglExamTopic xlglExamTopic = new XlglExamTopic ();
				xlglExamTopic.setId(UUIDUtils.random());
				String steCell = sheet.getRow(i).getCell(0).getStringCellValue(); //题目
				xlglExamTopic.setTopicColumn(steCell);
				xlglExamTopic.setSubjectId(subjectId);	//科目表id
				String steCell1 = sheet.getRow(i).getCell(1).getStringCellValue(); //答案
				xlglExamTopic.setTopicResult(steCell1);
				xlglExamTopic.setTopicType(type);
				xlglExamTopic.setCreateUser(CurrentUser.getUserId());
				xlglExamTopic.setCreateDate(new Date());
				xlglExamTopic.setUpdateUser(CurrentUser.getUserId());
				xlglExamTopic.setCreateDate(new Date());
				list.add(xlglExamTopic);
			}	
		}
		wb.close();
		is.close();
		return list;
	}

	@Override
	public void saveList(List<XlglExamTopic> list) {
		xlglExamTopicDao.saveList(list);
	}

	@Override
	public List<XlglExamTopic> queryListByIds(Object[] id) {
		return xlglExamTopicDao.queryListByIds(id);
	}

	@Override
	public void deleteByType(Map<String, Object> map) {
		xlglExamTopicDao.deleteByType(map);;
	}
	
}
