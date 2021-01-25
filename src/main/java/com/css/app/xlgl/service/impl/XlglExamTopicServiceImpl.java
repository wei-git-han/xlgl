package com.css.app.xlgl.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.css.app.xlgl.dao.XlglExamSubjectDao;
import com.css.app.xlgl.dao.XlglExamTopicDao;
import com.css.app.xlgl.entity.XlglExamSubject;
import com.css.app.xlgl.entity.XlglExamTopic;
import com.css.app.xlgl.service.XlglExamTopicService;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.UUIDUtils;



@Service("xlglExamTopicService")
public class XlglExamTopicServiceImpl implements XlglExamTopicService {
	@Autowired
	private XlglExamTopicDao xlglExamTopicDao;
	@Autowired
	private XlglExamSubjectDao xlglExamSubjectDao;
	
	
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
	public JSONObject readExcelLists(InputStream is,String subjectId){
		JSONObject json = new JSONObject();
		Map<String, Object> map = new HashMap<>();
		map.put("subjectId", subjectId);
		List<XlglExamTopic> list =new ArrayList<XlglExamTopic>();
		try {
		Workbook wb =new HSSFWorkbook(is);
		Sheet sheet = wb.getSheetAt(0); // 遍历第一个Sheet
		String title = sheet.getRow(0).getCell(0).getStringCellValue();//标题，用于判断是哪一类题
		String titleType ="";
		if(!StringUtils.isEmpty(title)) {
			if(title.equals("单选题")) {
				titleType = "1";
			}else if(title.equals("多选题")) {
				titleType = "2";
			}else if(title.equals("判断题")) {
				titleType = "3";
			}else if(title.equals("填空题")) {
				titleType = "4";
			}else {
				titleType = "5";
			}
		}else {
			titleType = "6";
		}
		XlglExamSubject queryObject = xlglExamSubjectDao.queryObject(subjectId);
		boolean str =false;
		if(queryObject !=null) {
			String subjectType = queryObject.getSubjectType();
			if(!StringUtils.isEmpty(subjectType) && subjectType.contains(titleType)) {
				str = true;
			}
		}
		if(str) {
			if(!StringUtils.isEmpty(title)&& (title.equals("单选题") || title.equals("多选题")) ) {
				String type ="1";
				if(title.equals("多选题")) {
					type = "2";
				}
				map.put("topicType", type);
				xlglExamTopicDao.deleteByType(map);
				for(int i = 2 ;i<=sheet.getLastRowNum(); i ++) {
					XlglExamTopic xlglExamTopic = new XlglExamTopic ();
					xlglExamTopic.setId(UUIDUtils.random());
					String steCell = getCellValue(sheet.getRow(i).getCell(0));; //题目
					xlglExamTopic.setTopicColumn(steCell);

					String steCell2 = getCellValue(sheet.getRow(i).getCell(1)); //选项A
					String steCell3 = getCellValue(sheet.getRow(i).getCell(2)); //选项B
					String steCell4 = getCellValue(sheet.getRow(i).getCell(3)); //选项C
					String steCell5 = getCellValue(sheet.getRow(i).getCell(4)); //选项D
					xlglExamTopic.setTopicOption("A:"+steCell2+",B:"+steCell3+",C:"+steCell4+",D:"+steCell5);//题目选项
					xlglExamTopic.setSubjectId(subjectId);	//科目表id
					String steCell6 = getCellValue(sheet.getRow(i).getCell(5)); //答案
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
				map.put("topicType", type);
				xlglExamTopicDao.deleteByType(map);
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
				wb.close();
			}
			json.put("list", list);
			json.put("code", "200");
			json.put("msg", "题目导入成功");
		}else {
			if(titleType.equals("1")||titleType.equals("2")||titleType.equals("3")||titleType.equals("4")) {
				json.put("msg", "题目导入失败,该科目中无当前导入的题型");
			}else {
				json.put("msg", "题目导入失败,导入文件格式不正确，请按照模板格式导入");
			}
			json.put("list", list);
			json.put("code", "201");
		}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return json;
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
	private String getCellValue(Cell cell) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String str = "";
		if(cell.getCellType() ==0) {
			if(HSSFDateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				str = simpleDateFormat.format(dateCellValue);
			}else {
				str = cell.getNumericCellValue()+"";
				if(str.contains(".")) {
					str =str.substring(0,str.indexOf("."));
				}
			}
		}else if(cell.getCellType() ==1){
			 str = cell.getStringCellValue();
		}
		return str;
	}



}
