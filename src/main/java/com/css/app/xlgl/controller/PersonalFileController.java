package com.css.app.xlgl.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import com.css.addbase.apporgan.entity.BaseAppOrgan;
import com.css.addbase.apporgan.entity.BaseAppUser;
import com.css.addbase.apporgan.service.BaseAppOrganService;
import com.css.addbase.apporgan.service.BaseAppUserService;
import com.css.app.xlgl.entity.XlglMineStudy;
import com.css.app.xlgl.entity.XlglPhysical;
import com.css.app.xlgl.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.css.app.xlgl.dto.PersonalFileDto;
import com.css.app.xlgl.entity.PersonalFile;
import com.css.app.xlgl.entity.XlglExamSubject;
import com.css.base.entity.SSOUser;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.Response;
import org.springframework.web.context.request.NativeWebRequest;

/**
 * 
 * 训练档案-个人训练档案
 * */
@Controller
@RequestMapping("app/xlgl/personalfile")
public class PersonalFileController {
	@Autowired
	private XlglExamMainAnswerService xlglExamMainAnswerService;
	@Autowired
	private PersonalFileService personalFileService;
	@Autowired
	private XlglExamSubjectService xlglExamSubjectService;
	@Autowired
	private XlglPhysicalService xlglPhysicalService;
	@Autowired
	private XlglStudyRecordService xlglStudyRecordService;
	@Autowired
	private XlglMineStudyService xlglMineStudyService;
	@Autowired
	private BaseAppUserService baseAppUserService;
	@Autowired
	private BaseAppOrganService baseAppOrganService;
	/**
	 * 训练档案-个人训练档案 列表
	 * 
	 * */
	@ResponseBody
	@RequestMapping("/list")
	public void list() {
		SSOUser ssoUser = CurrentUser.getSSOUser();
		JSONObject jsonObject = new JSONObject();
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("replyUserId", ssoUser.getUserId());
		map.put("year", "1");
		List<XlglExamSubject> subjectList = xlglExamSubjectService.queryList(null);
		
		Calendar date = Calendar.getInstance();
		String year = String.valueOf(date.get(Calendar.YEAR));
		
		List<PersonalFile> queryList = personalFileService.queryList(map);
		Integer numberAll = 0;
		for (PersonalFile personalFile : queryList) {
			numberAll += personalFile.getFractionSum();
		}
		List<XlglPhysical> queryPhysicalList = xlglPhysicalService.queryList(map);//军事体育成绩
		List<XlglMineStudy> xlglMineStudyList  = xlglMineStudyService.queryList(map);//自学成绩
		List<PersonalFileDto> list =new ArrayList<PersonalFileDto>();
		for (XlglExamSubject xlglExamSubject : subjectList) {
			List<PersonalFile> PersonalFilelist =new ArrayList<PersonalFile>();
			for (PersonalFile personalFile : queryList) {
				if(xlglExamSubject.getSubjectName().equals(personalFile.getExamineSubjectName())) {
					PersonalFilelist.add(personalFile);
				}
			}
			if(PersonalFilelist.size()>0) {
				PersonalFileDto personalFileDto = new PersonalFileDto();
				personalFileDto.setExamineSubjectName(xlglExamSubject.getSubjectName());
				personalFileDto.setList(PersonalFilelist);
				list.add(personalFileDto);
			}
		}
		if(queryPhysicalList != null && queryPhysicalList.size() > 0){
			PersonalFileDto personalFileDto = new PersonalFileDto();
			personalFileDto.setExamineSubjectName("军事体育训练");
			personalFileDto.setXlglPhysicalList(queryPhysicalList);
			list.add(personalFileDto);
		}
		if(xlglMineStudyList != null && xlglMineStudyList.size() > 0){
			PersonalFileDto personalFileDto = new PersonalFileDto();
			personalFileDto.setExamineSubjectName("自学成绩");
			personalFileDto.setXlglMineStudyList(xlglMineStudyList);
			list.add(personalFileDto);
		}

		jsonObject.put("XlglPhysical",queryPhysicalList);//体育成绩
		jsonObject.put("personalFileList", list);
		jsonObject.put("currentUserName", ssoUser.getFullname());
		jsonObject.put("orgName", ssoUser.getOrgName());
		jsonObject.put("numberAll", numberAll);//总分
		jsonObject.put("year", year);
		Response.json(jsonObject);
	}
	/**
	 * 训练档案-个人训练档案用户详情按钮训练考核
	 * */
	@ResponseBody
	@RequestMapping("/count")
	public void count() {
		JSONObject jsonObject = new JSONObject();
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("replyUserId", CurrentUser.getUserId());
		int total = personalFileService.queryTotal(map);
		map.put("level", "1");
		int levelTotal = personalFileService.queryTotal(map);
		String level ="";
		if(total > 0){
			Integer levelrate = (levelTotal/total)*100;

			if(levelrate >= 85) {
				level = "优秀";
			}else if(70 <= levelrate && levelrate < 85){
				level = "优良";
			}else if(60 <= levelrate && levelrate < 70) {
				level = "及格";
			}else {
				level = "不及格";
			}
			jsonObject.put("levelrate", levelrate);//优秀比率
		}
		jsonObject.put("level", level);//优秀等级
		jsonObject.put("total", total);//已考科目总数

		Response.json(jsonObject);
	}
	
	/**
	 * 训练档案-个人训练档案 详情按钮 训练考核统计数据，点击出现折叠框 考试列表
	 * */
	@ResponseBody
	@RequestMapping("/subjectList")
	public void subjectList(String subjectId) {
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("replyUserId", CurrentUser.getUserId());
		map.put("subjectId", subjectId);
		List<PersonalFile> list = personalFileService.queryListBySubjectId(map);
		Response.json("subjectList",list);
	}
	
	
	/**
	 * 训练档案-个人训练档案 详情按钮 训练考核统计数据，科目标题
	 * */
	@ResponseBody
	@RequestMapping("/subjectTitle")
	public void subjectTitle() {
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("replyUserId", CurrentUser.getUserId());
		List<PersonalFile> titleList = personalFileService.getTitleList(map);
		Response.json("titleList",titleList);
	}
	
	/**
	 * 训练档案-个人训练档案 详情按钮 用户成绩与排名
	 * */
	@ResponseBody
	@RequestMapping("/userPerformance")
	public void userPerformance() {
		JSONObject jsonObject = new JSONObject();
		List<PersonalFile> queryRanking = personalFileService.queryRanking();
		SSOUser ssoUser = CurrentUser.getSSOUser();
		String userId = ssoUser.getUserId();
		for (PersonalFile personalFile : queryRanking) {
			if(personalFile.getReplyUserId().equals(userId)) {
				jsonObject.put("totalFraction", personalFile.getTotalFraction());
				String totalFraction = personalFile.getTotalFraction();//得总分
				Integer fractionSum = personalFile.getFractionSum();//所有考试总分
				int parseInt = Integer.parseInt(totalFraction);
				if(parseInt >=fractionSum*0.9) {
					jsonObject.put("level", "优秀");
				}else if(parseInt < fractionSum*0.9  && parseInt >=fractionSum*0.75) {
					jsonObject.put("level", "优良");
				}else if(fractionSum*0.75 > parseInt && parseInt >= fractionSum*0.6) {
					jsonObject.put("level", "良好");
				}else {
					jsonObject.put("level", "差");
				}
				break;
			}
		}
		jsonObject.put("userId", userId);
		jsonObject.put("userName", ssoUser.getFullname());
		jsonObject.put("orgName", ssoUser.getOrgName());
		Response.json(jsonObject);
	}

	/**
	 * 训练档案-个人档案-详情-军事体育训练
	 */
	@ResponseBody
	@RequestMapping("/getUserPerXlInfo")
	public void getUserPerXlInfo(){
		Calendar calendar = Calendar.getInstance();
		String year = String.valueOf(calendar.get(Calendar.YEAR));
		String userId = CurrentUser.getUserId();
		XlglPhysical xlglPhysical = xlglPhysicalService.queryByUserId(userId,year);
		Response.json("xlglPhysical",xlglPhysical);
	}

	/**
	 * 训练档案-个人档案-详情-自学成绩
	 */
	@ResponseBody
	@RequestMapping("/getUserPerZxInfo")
	public void getUserPerZxInfo(){
		Calendar calendar = Calendar.getInstance();
		String year = String.valueOf(calendar.get(Calendar.YEAR));
		String userId = CurrentUser.getUserId();
		XlglMineStudy xlglMineStudy = xlglMineStudyService.queryByUserId(userId,year);
		Response.json("xlglMineStudy",xlglMineStudy);

	}

	/**
	 * 具体到某个人的优秀率
	 */
	@ResponseBody
	@RequestMapping("/getPerScore")
	public int getPerScore(String userId){
		Calendar calendar = Calendar.getInstance();
		String year = String.valueOf(calendar.get(Calendar.YEAR));
		//String userId = CurrentUser.getUserId();
		int t = 0;
		int yxSum = 0;//优秀个数
		int ylSum = 0;//优良个数
		int jgSum = 0;//及格个数
		int njgSum = 0;//不及格个数
		int result = 0;//最终结果 0是优秀，1是优良，2是及格，3是不及格
		//训练考核优秀率----start
		HashMap<String,Object> map = new HashMap<String,Object>();
		int total = personalFileService.queryTotal(map);
		map.put("level", "1");
		map.put("replyUserId", userId);
		int levelTotal = personalFileService.queryTotal(map);
		Integer levelrate = (levelTotal/total)*100;
		String level ="";
		if(levelrate >= 85) {
			level = "优秀";
			yxSum +=1;
		}else if(70 <= levelrate && levelrate < 85){
			level = "优良";
			ylSum +=1;
		}else if(60 <= levelrate && levelrate < 70) {
			level = "及格";
			jgSum +=1;
		}else {
			level = "不及格";
		}
		//训练考核优秀率----end

		//体育成绩-----start
		XlglPhysical xlglPhysical = xlglPhysicalService.queryByUserId(userId,year);
		int levelTy = Integer.parseInt(xlglPhysical.getAllScore());
		String dj = "";
		if(levelTy >= 260 && levelTy < 340){
			dj = "及格";
			jgSum +=1;
		}else if(levelTy >= 340 && levelTy < 380){
			dj = "良好";
			ylSum +=1;
		}else if(levelTy >= 380 && levelTy < 440){
			dj = "优秀";
			yxSum +=1;
		}else if(levelTy >= 440 && levelTy < 480){
			dj = "特3级";
			yxSum +=1;
		}else if(levelTy >= 480 && levelTy < 500){
			dj = "特2级";
			yxSum +=1;
		}else if(levelTy > 500){
			dj = "特1级";
			yxSum +=1;
		}
		//体育成绩------end

		//自学成绩----start
		XlglMineStudy xlglMineStudy = xlglMineStudyService.queryByUserId(userId,year);
		int levelStudy = Integer.parseInt(xlglMineStudy.getScore());
		String studyDj = "";
		if(levelStudy >=90 && levelStudy <=100){
			studyDj = "优秀";
			yxSum +=1;
		}else if(levelStudy >=75 && levelStudy <90){
			studyDj = "良好";
			ylSum +=1;
		}else if(levelStudy >=60 && levelStudy <75){
			studyDj = "及格";
			jgSum +=1;
		}else {
			studyDj = "不及格";
		}
		//自学成绩-----end

		if(yxSum >= 2 && ylSum == 3){//所有成绩良好及以上，优秀率50%及以上
			result = 0;//优秀
		}else if(yxSum >= 2 && jgSum == 3 && levelStudy >=75){//所有成绩及格及以上，优秀率70%及以上，个人自学成绩良好及以上
			result = 0;//优秀
		}else if(jgSum == 3 && yxSum >= 2 && levelStudy >=75){
			result = 1;//优良
		}else if(levelStudy >=60 && jgSum >=2){
			result = 2;//及格
		}else {
			result = 3;//不及格
		}

		return result;



	}
	//某局所有的优秀
	@ResponseBody
	@RequestMapping("/getAllYxl")
	public JSONObject getAllYxl(String deptId){
		JSONObject jsonObject = new JSONObject();
		int result = 0;
		int highSum = 0;//优秀
		int midSum = 0;//优良
		int lowSum = 0;//及格
		String orgId = baseAppUserService.getBareauByUserId(CurrentUser.getUserId());
		List<BaseAppUser> list = baseAppUserService.queryAllUserIdAndName(orgId);
		if(list != null && list.size() > 0){
			for(BaseAppUser baseAppUser : list) {
				String userId = baseAppUser.getUserId();
				result = getPerScore(userId);
				if (result == 0) {
					highSum += 1;
				} else if (result == 1) {
					midSum += 1;
				} else if (result == 2) {
					lowSum += 1;
				}
			}
		}
		int sum = list.size();//总人数
		float yxLv = highSum/sum;
		float ylLv = midSum/sum;
		float jgLv = lowSum/sum;
		jsonObject.put("highSum",highSum);//优秀人数
		jsonObject.put("midSum",midSum);//优良人数
		jsonObject.put("lowSum",lowSum);//及格人数
		jsonObject.put("yxLv",yxLv);//优秀率
		jsonObject.put("ylLv",ylLv);//优良率
		jsonObject.put("jgLv",jgLv);//及格率
//		Response.json(jsonObject);
		return jsonObject;
	}

	/**
	 * 获取所有局的情况
	 */
	@ResponseBody
	@RequestMapping("/getAllDeptInfo")
	public void getAllDeptInfo(){
		List listAll = new ArrayList();
		List<BaseAppOrgan> list = baseAppOrganService.findByParentId("root");
		if(list != null && list.size() > 0){
			for(BaseAppOrgan baseAppOrgan : list){
				String deptId = baseAppOrgan.getId();
				JSONObject jsonObject = getAllYxl(deptId);
				listAll.add(jsonObject);
			}
		}
		Response.json(listAll);
	}

}
