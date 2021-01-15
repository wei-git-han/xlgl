package com.css.app.xlgl.controller;

import java.text.DecimalFormat;
import java.util.*;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.css.addbase.apporgan.entity.BaseAppOrgan;
import com.css.addbase.apporgan.entity.BaseAppUser;
import com.css.addbase.apporgan.service.BaseAppOrganService;
import com.css.addbase.apporgan.service.BaseAppUserService;
import com.css.app.xlgl.entity.XlglMineStudy;
import com.css.app.xlgl.entity.XlglPhysical;
import com.css.app.xlgl.service.*;
import com.css.base.utils.StringUtils;
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
	public void list(String time) {
//		List listAll = new ArrayList();
//		SSOUser ssoUser = CurrentUser.getSSOUser();
//		JSONObject jsonObject = new JSONObject();
//		HashMap<String,Object> map = new HashMap<String,Object>();
//		map.put("replyUserId", ssoUser.getUserId());
//		Calendar date = Calendar.getInstance();
//		String year = String.valueOf(date.get(Calendar.YEAR));
//		if(StringUtils.isNotBlank(time)){
//			map.put("year", time);
//		}else {
//			map.put("year", year);
//		}
//		List<PersonalFile> queryList = personalFileService.queryList(map);
//		Integer numberAll = 0;
//		for (PersonalFile personalFile : queryList) {
//			numberAll += personalFile.getFractionSum();
//			personalFile.setUserName(personalFile.getUserName());
//		}
//		List<XlglPhysical> queryPhysicalList = xlglPhysicalService.queryList(map);//军事体育成绩
//		List<XlglMineStudy> xlglMineStudyList  = xlglMineStudyService.queryList(map);//自学成绩
//		List<PersonalFileDto> list =new ArrayList<PersonalFileDto>();
//		Map<String, Object> xlglMap = new HashMap<String, Object>();
//		xlglMap.put("replyUserId", ssoUser.getUserId());
//		List<XlglExamMainAnswer> commonList = xlglExamMainAnswerService.findListBySubjectId(map);
//		if(commonList.size()>0) {
//			for (XlglExamMainAnswer xlglExamMainAnswer : commonList) {
//			    JSONObject jsonObject2 = new JSONObject();
//				jsonObject2.put("subJectName", xlglExamMainAnswer.getExamineName());
//				if(xlglExamMainAnswer.getFractionsum() != null){
//					jsonObject2.put("score", xlglExamMainAnswer.getFractionsum());
//				}else {
//					jsonObject2.put("score", "0");
//				}
//				jsonObject2.put("currentName", CurrentUser.getUsername());
//				if(xlglExamMainAnswer.getFractionsum() != null){
//					numberAll +=xlglExamMainAnswer.getFractionsum();
//				}
//				listAll.add(jsonObject2);
//			}
//		}
//
//
//		if(queryPhysicalList != null && queryPhysicalList.size() > 0){
//			for(XlglPhysical xlglPhysical : queryPhysicalList){
//				numberAll += Integer.parseInt(xlglPhysical.getAllScore());
//			}
//			for(XlglPhysical xlglPhysical : queryPhysicalList){
//				JSONObject jsonObject1 = new JSONObject();
//				jsonObject1.put("score",xlglPhysical.getAllScore());
//				jsonObject1.put("subJectName","军事体育训练");
//				jsonObject1.put("currentName",CurrentUser.getUsername());
//				listAll.add(jsonObject1);
//
//			}
//		}
//
//		if(xlglMineStudyList != null && xlglMineStudyList.size() > 0){
//			for(XlglMineStudy xlglMineStudy : xlglMineStudyList){
//				numberAll += Integer.parseInt(xlglMineStudy.getScore());
//			}
//
//			for(XlglMineStudy xlglMineStudy : xlglMineStudyList){
//				JSONObject jsonObject1 = new JSONObject();
//				jsonObject1.put("score",xlglMineStudy.getScore());
//				jsonObject1.put("subJectName","自学成绩");
//				jsonObject1.put("currentName",CurrentUser.getUsername());
//				listAll.add(jsonObject1);
//			}
//		}
//
//		//jsonObject.put("XlglPhysical",queryPhysicalList);//体育成绩
//		jsonObject.put("list", listAll);
//		jsonObject.put("currentUserName", ssoUser.getFullname());
//		jsonObject.put("orgName", ssoUser.getOrgName());
//		jsonObject.put("numberAll", numberAll);//总分
//		jsonObject.put("year", year);
//		Response.json(jsonObject);

		SSOUser ssoUser = CurrentUser.getSSOUser();
		JSONObject jsonObject = new JSONObject();
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("replyUserId", ssoUser.getUserId());

		List<XlglExamSubject> subjectList = xlglExamSubjectService.queryList(null);

		Calendar date = Calendar.getInstance();
		String year = String.valueOf(date.get(Calendar.YEAR));
		if(StringUtils.isNotBlank(time)){
			map.put("year", time);
		}else {
			map.put("year", year);
		}
		List<PersonalFile> queryList = personalFileService.queryList(map);
		Integer numberAll = 0;
		for (PersonalFile personalFile : queryList) {
			if(personalFile.getFractionSum() != null){
				numberAll += personalFile.getFractionSum();
			}else {
				numberAll += 0;
			}

			personalFile.setUserName(personalFile.getUserName());
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
			personalFileDto.setScore(queryPhysicalList.get(0).getAllScore());
			list.add(personalFileDto);
			for(XlglPhysical xlglPhysical : queryPhysicalList){
				if(StringUtils.isNotBlank(xlglPhysical.getAllScore())){
					numberAll += Integer.parseInt(xlglPhysical.getAllScore());
				}else {
					numberAll += 0;
				}

			}
		}
		if(xlglMineStudyList != null && xlglMineStudyList.size() > 0){
			PersonalFileDto personalFileDto = new PersonalFileDto();
			personalFileDto.setExamineSubjectName("自学成绩");
			personalFileDto.setXlglMineStudyList(xlglMineStudyList);
			personalFileDto.setScore(xlglMineStudyList.get(0).getScore());
			list.add(personalFileDto);
			for(XlglMineStudy xlglMineStudy : xlglMineStudyList){
				String tscore = "";
				String score = xlglMineStudy.getScore();
				if(StringUtils.isNotBlank(score)) {
					if(score.contains(".")) {
						tscore = score.substring(0,score.indexOf("."));
					}else {
						tscore = score;
					}
				}
				int sc = Integer.parseInt(tscore);
				numberAll += sc;
			}
		}

		//jsonObject.put("XlglPhysical",queryPhysicalList);//体育成绩
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
	public void count(String year) {
		JSONObject jsonObject = new JSONObject();
		Calendar calendar = Calendar.getInstance();
		if(StringUtils.isBlank(year)) {
			 year = String.valueOf(calendar.get(Calendar.YEAR));
		}
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("replyUserId", CurrentUser.getUserId());
		map.put("year", year);
		int total = personalFileService.queryTotal(map);
		map.put("level", "优秀");
		int levelTotal = personalFileService.queryTotal(map);
		String level ="";
		DecimalFormat decimalFormat = new DecimalFormat(".00");
		if(total > 0){
			float levelrate = ((float)levelTotal/(float)total)*100;
			if(levelrate >= 85) {
				level = "优秀";
			}else if(70 <= levelrate && levelrate < 85){
				level = "优良";
			}else if(60 <= levelrate && levelrate < 70) {
				level = "及格";
			}else {
				level = "不及格";
			}
			String format = decimalFormat.format(levelrate);
			jsonObject.put("levelrate", format);//优秀比率
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
			if (personalFile.getReplyUserId().equals(userId)) {
				jsonObject.put("totalFraction", personalFile.getTotalFraction());
				String totalFraction = personalFile.getTotalFraction();//得总分
				Integer fractionSum = personalFile.getFractionSum();//所有考试总分
				int parseInt = Integer.parseInt(totalFraction);
				if (parseInt >= fractionSum * 0.9) {
					jsonObject.put("level", "优秀");
				} else if (parseInt < fractionSum * 0.9 && parseInt >= fractionSum * 0.75) {
					jsonObject.put("level", "优良");
				} else if (fractionSum * 0.75 > parseInt && parseInt >= fractionSum * 0.6) {
					jsonObject.put("level", "良好");
				} else {
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
	public void getUserPerXlInfo(String year){
		Calendar calendar = Calendar.getInstance();
		if(StringUtils.isBlank(year)) {
			 year = String.valueOf(calendar.get(Calendar.YEAR));
		}
		String userId = CurrentUser.getUserId();
		//只查出导入的数据，且只取最新的一次的
		XlglPhysical xlglPhysical = xlglPhysicalService.queryByUserId(userId,year);
		if(xlglPhysical != null){
		String age = xlglPhysical.getAge();
		String age1 = "";
		if(age.contains(".")){
			age1 = age.substring(0,age.indexOf("."));
		}else {
			age1 = age;
		}
		String ytxs = xlglPhysical.getYtxs();
		String ytxs1 = "";
		if(ytxs.contains(".")){
			ytxs1 = ytxs.substring(0,ytxs.indexOf("."));
		}else {
			ytxs1 = ytxs;
		}
		String ywqz = xlglPhysical.getYwqz();
		String ywqz1 = "";
		if(ywqz.contains(".")){
			ywqz1 = ywqz.substring(0,ywqz.indexOf("."));
		}else {
			ywqz1 = ywqz;
		}
		String sRun = xlglPhysical.getSxp();
		String tRun = xlglPhysical.getCpf();
		String t = "";
		String sex = xlglPhysical.getSex();
		String weiht = xlglPhysical.getWight();
		String weiht1 = "";
		if(weiht.contains(".")){
			weiht1 = weiht.substring(0,weiht.indexOf("."));
		}else {
			weiht1 = weiht;
		}
		String high = xlglPhysical.getHigh();
		String high1 = "";
		if(high.contains(".")){
			high1 = high.substring(0,high.indexOf("."));
		}else {
			high1 = high;
		}
		String type = xlglPhysical.getType();
		String type1 = "";
		if(type.contains(".")){
			type1 = type.substring(0,type.indexOf("."));
		}else {
			type1 = type;
		}
		XlglPhysicalController xlglPhysicalController = new XlglPhysicalController();
		JSONObject jsonObject = xlglPhysicalController.getPerSumCore(age1,ytxs1,ywqz1,sRun,tRun,t,sex,type1,weiht1,high1);
		int score = (int)jsonObject.get("score");
		String dj = (String)jsonObject.get("dj");
		float BMI = (Float) jsonObject.get("BMI");
		String hg = (String)jsonObject.get("hg");
		int shang = (int)jsonObject.get("shang");
		int zuo = (int)jsonObject.get("zuo");
		int pao = (int)jsonObject.get("pao");
		int changpao = (int)jsonObject.get("changpao");
		xlglPhysical.setUp(String.valueOf(shang));
		xlglPhysical.setSit(String.valueOf(zuo));
		xlglPhysical.setSrun(String.valueOf(pao));
		xlglPhysical.setTrun(String.valueOf(changpao));
		xlglPhysical.setAllScore(String.valueOf(score));
		xlglPhysical.setAllJudge(dj);
		xlglPhysical.setTscore(String.valueOf(BMI));
		xlglPhysical.setJudge(hg);
		xlglPhysicalService.update(xlglPhysical);
		}
		Response.json("xlglPhysical",xlglPhysical);
	}

	/**
	 * 训练档案-个人档案-详情-自学成绩
	 */
	@ResponseBody
	@RequestMapping("/getUserPerZxInfo")
	public void getUserPerZxInfo(String year){
		Calendar calendar = Calendar.getInstance();
		if(StringUtils.isBlank(year)) {
			 year = String.valueOf(calendar.get(Calendar.YEAR));
		}
		String userId = CurrentUser.getUserId();
		XlglMineStudy xlglMineStudy = xlglMineStudyService.queryByUserId(userId,year);
		Response.json("xlglMineStudy",xlglMineStudy);

	}

	/**
	 * 具体到某个人的优秀率
	 */
	@ResponseBody
	@RequestMapping("/getPerScore")
	public int getPerScore(String userId,String year){
		//Calendar calendar = Calendar.getInstance();
		//String year = String.valueOf(calendar.get(Calendar.YEAR));
		//String userId = CurrentUser.getUserId();
		int t = 0;
		int yxSum = 0;//优秀个数
		int ylSum = 0;//优良个数
		int jgSum = 0;//及格个数
		int njgSum = 0;//不及格个数
		int result = 0;//最终结果 0是优秀，1是优良，2是及格，3是不及格
		//训练考核优秀率----start
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("year",year);
		int total = personalFileService.queryTotal(map);
		map.put("level", "优秀");
		map.put("replyUserId", userId);
		int levelTotal = personalFileService.queryTotal(map);
		if(total > 0){
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
				njgSum +=1;
			}
		}

		//训练考核优秀率----end

		//体育成绩-----start
		Map<String,Object> mapPhysical = new HashMap<>();
		mapPhysical.put("userId",userId);
		mapPhysical.put("year",year);
		List<XlglPhysical> xlglPhysicalList = xlglPhysicalService.queryList(mapPhysical);
		if(xlglPhysicalList != null && xlglPhysicalList.size() > 0){
			int levelTy = 0;
			if(StringUtils.isNotBlank(xlglPhysicalList.get(0).getAllScore())){
				levelTy = Integer.parseInt(xlglPhysicalList.get(0).getAllScore());
			}
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
		}else if(levelTy < 260){
			njgSum +=1;
		}
		}
		//体育成绩------end

		//自学成绩----start
		XlglMineStudy xlglMineStudy = xlglMineStudyService.queryByUserId(userId,year);
		int levelStudy = 0;
		if(xlglMineStudy != null){
			if(StringUtils.isNotBlank(xlglMineStudy.getScore())){
				if(xlglMineStudy.getScore().contains(".")){
					levelStudy	= Integer.parseInt(xlglMineStudy.getScore().substring(0,xlglMineStudy.getScore().indexOf(".")));
				}else {
					levelStudy = Integer.parseInt(xlglMineStudy.getScore());
				}
				}


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
			njgSum +=1;
		}
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
	public JSONObject getAllYxl(String deptId,String year){
		JSONObject jsonObject = new JSONObject();
		int result = 0;
		int highSum = 0;//优秀
		int midSum = 0;//优良
		int lowSum = 0;//及格
		String orgId = baseAppUserService.getBareauByUserId(CurrentUser.getUserId());
		String name = baseAppOrganService.queryObject(deptId).getName();
		 Map<String, Object> hashmap = new HashMap<String,Object>();
	        hashmap.put("organId", deptId);
		List<BaseAppUser> list = baseAppUserService.queryAllUserIdAndName(hashmap);
		if(list != null && list.size() > 0){
			for(BaseAppUser baseAppUser : list) {
				String userId = baseAppUser.getUserId();
				result = getPerScore(userId,year);
				if (result == 0) {
					highSum += 1;
				} else if (result == 1) {
					midSum += 1;
				} else if (result == 2) {
					lowSum += 1;
				}
			}
			int sum = list.size();//总人数
			float yxLv = highSum/sum * 100;
			float ylLv = midSum/sum * 100;
			float jgLv = lowSum/sum * 100;
			jsonObject.put("yxLv",yxLv);//优秀率
			jsonObject.put("ylLv",ylLv);//优良率
			jsonObject.put("jgLv",jgLv);//不及格率
		}

		jsonObject.put("name",name);
		jsonObject.put("highSum",highSum);//优秀人数
		jsonObject.put("midSum",midSum);//优良人数
		jsonObject.put("lowSum",lowSum);//不及格人数

		return jsonObject;
	}

	/**
	 * 获取所有局的情况
	 */
	@ResponseBody
	@RequestMapping("/getAllDeptInfo")
	public void getAllDeptInfo(String time){
		Calendar calendar = Calendar.getInstance();
		if(StringUtils.isBlank(time)){
			time = String.valueOf(calendar.get(Calendar.YEAR));
		}
		List list2 = new ArrayList();
		String orgId = baseAppUserService.getBareauByUserId(CurrentUser.getUserId());
		List listAll = new ArrayList();
		List<BaseAppOrgan> list = baseAppOrganService.findByParentId("root");
		//所有局
		if(list != null && list.size() > 0){
			for(BaseAppOrgan baseAppOrgan : list){
				String deptId = baseAppOrgan.getId();

				JSONObject jsonObject = getAllYxl(deptId,time);
				if(orgId.equals(deptId)){//当前登录人所在的局的信息
					JSONObject jsCurrentDept = new JSONObject();
					jsCurrentDept.put("name",jsonObject.get("name"));
					jsCurrentDept.put("highSum",jsonObject.get("highSum"));//优秀人数
					jsCurrentDept.put("midSum",jsonObject.get("midSum"));//优良人数
					jsCurrentDept.put("lowSum",jsonObject.get("lowSum"));//及格人数
					jsCurrentDept.put("yxLv",jsonObject.get("yxLv"));//优秀率
					jsCurrentDept.put("ylLv",jsonObject.get("ylLv"));//优良率
					jsCurrentDept.put("jgLv",jsonObject.get("jgLv"));//及格率
					list2.add(jsCurrentDept);
				}
				listAll.add(jsonObject);
			}
		}
		JSONObject result = new JSONObject();
		result.put("listAll",listAll);
		result.put("listCurrent",list2);
		result.put("result","success");
		Response.json(result);
	}

}
