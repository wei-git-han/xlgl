package com.css.app.xlgl.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.css.addbase.apporgan.entity.BaseAppUser;
import com.css.addbase.apporgan.service.BaseAppOrganService;
import com.css.addbase.apporgan.service.BaseAppUserService;
import com.css.app.xlgl.dao.XlglExamExamineDao;
import com.css.app.xlgl.dto.XlglExamExaminetopicDto;
import com.css.app.xlgl.entity.XlglExamExamine;
import com.css.app.xlgl.entity.XlglExamExaminetopic;
import com.css.app.xlgl.entity.XlglExamMainAnswer;
import com.css.app.xlgl.service.XlglExamExamineService;
import com.css.app.xlgl.service.XlglExamExaminetopicService;
import com.css.app.xlgl.service.XlglExamMainAnswerService;
import com.css.app.xlgl.service.XlglExamTopicService;
import com.css.base.entity.SSOUser;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.PageUtils;
import com.css.base.utils.Response;
import com.css.base.utils.StringUtils;
import com.css.base.utils.UUIDUtils;
import com.github.pagehelper.PageHelper;


/**
 * 训练考核-考试组织-考试基本信息表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-07-30 10:56:43
 */
@Controller
@RequestMapping("app/xlgl/xlglexamexamine")
public class XlglExamExamineController {
	@Autowired
	private XlglExamExamineService xlglExamExamineService;
	@Autowired
	private XlglExamTopicService xlglExamTopicService;
	@Autowired
	private XlglExamExaminetopicService xlglExamExaminetopicService;
	@Autowired
	private XlglExamMainAnswerService xlglExamMainAnswerService;
	@Autowired
	private BaseAppUserService baseAppUserService;
	@Autowired
	private XlglExamExamineDao xlglExamExamineDao;
	@Autowired
	private BaseAppOrganService baseAppOrganService;


	/**
	 * 考核清单列表
	 * @param issueDate 发布时间
	 * @param examineName 考试名称
	 * @param status 0：考试，1:练习
	 */
	@ResponseBody
	@RequestMapping("/list")
	public void list(Integer page, Integer limit,String issueDate,String examineName,String status){
		Map<String, Object> map = new HashMap<>();
		Date date = new Date();
		int queryTotal = xlglExamExamineService.findCount();//总用户人数
		map.put("issueDate", issueDate);
		map.put("examineName", examineName);
		map.put("issueStatus", "1");
		map.put("status", status);
		PageHelper.startPage(page, limit);
		//查询列表数据
		List<XlglExamExamine> xlglExamExamineList = xlglExamExamineService.queryList(map);
		for (XlglExamExamine xlglExamExamine : xlglExamExamineList) {
			HashMap<String,Object> mapAll = new HashMap<String, Object>();
			mapAll.put("examineId", xlglExamExamine.getId());
			String number = xlglExamMainAnswerService.queryUserCount(mapAll);//每个试卷的参考人数
			Integer numberInto = 0;
			if(StringUtils.isNotBlank(number)) {
				numberInto=Integer.parseInt(number);
			}
			if(xlglExamExamine.getExamineEndDate() !=null && xlglExamExamine.getIssueStatus() !=null
					&&xlglExamExamine.getExamineEndDate().before(date) && xlglExamExamine.getIssueStatus().equals("0")) {
				xlglExamExamine.setIssueStatus("1");
				XlglExamExamine ex = new XlglExamExamine();
				ex.setId(xlglExamExamine.getId());
				ex.setOverStatus("1");
				xlglExamExamineService.update(ex);
			}
			xlglExamExamine.setNumberInto(numberInto);
			Integer numberIntoNot =queryTotal-numberInto;
			if(numberIntoNot<0) {
				xlglExamExamine.setNumberIntoNot(0);
			}else {
				xlglExamExamine.setNumberIntoNot(numberIntoNot);
			}
			Integer raio =((numberInto/queryTotal)*100);
			xlglExamExamine.setRatio(raio.toString()+"%");
		}
		PageUtils pageUtil = new PageUtils(xlglExamExamineList);
		Response.json("page",pageUtil);
	}
	/**
	 * 统计已结束的考试和进行中的考试数量
	 */
	@ResponseBody
	@RequestMapping("/conutInto")
	public void conutInto(){
		Map<String, Object> map = new HashMap<>();
		map.put("issueStatus", "1");
		map.put("overStatus", "0");
		int into = xlglExamExamineDao.queryTotal(map);//进行中
		map.put("overStatus", "1");
		int intoNot = xlglExamExamineDao.queryTotal(map);//已结束
		Response.json("into",into);
		Response.json("intoNot",intoNot);
	}
	
	/**
	 * 考核组织-未发布考核列表
	 */
	@ResponseBody
	@RequestMapping("/issueStatusList")
	public void issueStatusList(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		map.put("issueStatus", "0");
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<XlglExamExamine> xlglExamExamineList = xlglExamExamineService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(xlglExamExamineList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info")
	public void info(String id){
		JSONObject jsonObject = new JSONObject();
		Map<String, Object> map = new HashMap<String,Object>();
		XlglExamExamine xlglExamExamine = xlglExamExamineService.queryObject(id);
		map.put("examineId", id);
		List<XlglExamExaminetopicDto> listCount = xlglExamExaminetopicService.findCountBySubjectId(map);
		List<XlglExamExaminetopic> list = xlglExamExaminetopicService.findListBySubjectId(map);
		StringBuffer strbu = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			if(i==list.size()-1) {
				strbu.append(list.get(i).getId());
			}else {
				strbu.append(list.get(i).getId()+",");
			}
		}
		map.put("replyUserId", CurrentUser.getUserId());
		List<XlglExamMainAnswer> queryList = xlglExamMainAnswerService.queryList(map);
		if(queryList!=null && queryList.size()>0) {
			XlglExamMainAnswer xlglExamMainAnswer = queryList.get(0);
			jsonObject.put("xlglExamMainAnswer", xlglExamMainAnswer);
		}
		jsonObject.put("examineTopicIds", strbu.toString());
		jsonObject.put("listCount", listCount);
		jsonObject.put("xlglExamExamine", xlglExamExamine);
		Response.json(jsonObject);
	}
	
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	public void save(XlglExamExamine xlglExamExamine){
		String random = UUIDUtils.random();
		xlglExamExamine.setId(random);
		xlglExamExamine.setIssueStatus("0");
		xlglExamExamineService.save(xlglExamExamine);
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public void update(XlglExamExamine xlglExamExamine){
		xlglExamExamineService.update(xlglExamExamine);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public void delete(String[] ids){
		xlglExamExamineService.deleteBatch(ids);
		for (int i = 0; i < ids.length; i++) {
			xlglExamExaminetopicService.deleteByExamineId(ids[i]);
		}
		Response.ok();
	}
	
	/**
	 * 考核清单-用户开始考试，并创建用户成绩表
	 * @param examineId 试卷基本信息表id
	 * @param makeupStatus 未考状态0：没考，1:考了
	 * @param makeupExamineId 补考id
	 * */
	@ResponseBody
	@RequestMapping("/view/examine")
	public void viewExamine(String examineId,String makeupStatus,String makeupExamineId) {
		JSONObject jsonObject = getExamine(examineId);
		XlglExamMainAnswer xlglExamMainAnswer = new XlglExamMainAnswer();
		xlglExamMainAnswer.setId(UUIDUtils.random());
		SSOUser ssoUser = CurrentUser.getSSOUser();
		xlglExamMainAnswer.setOrganId(ssoUser.getOrganId());
		xlglExamMainAnswer.setOrganName(ssoUser.getOrgName());
		xlglExamMainAnswer.setReplyUserId(ssoUser.getUserId());
		xlglExamMainAnswer.setReplyUserName(CurrentUser.getUsername());
		xlglExamMainAnswer.setExamineId(makeupExamineId);
		xlglExamMainAnswer.setCreateDate(new Date());
		xlglExamMainAnswer.setUpdateDate(new Date());
		if(makeupStatus.equals("1")) {
			xlglExamMainAnswer.setMakeupExamineId(makeupExamineId);
			xlglExamMainAnswer.setMakeupStatus("1");
		}
		xlglExamMainAnswer.setMakeupStatus("0");
		xlglExamMainAnswerService.save(xlglExamMainAnswer);
		Response.json(jsonObject);
	}
	
	/**
	 * 考核清单-查看原考题
	 * */
	@ResponseBody
	@RequestMapping("/view")
	public void view(String examineId) {
		JSONObject jsonObject = getExamine(examineId);
		Response.json(jsonObject);
		
	}
	
	private JSONObject getExamine(String examineId) {
		JSONObject jsonObject = new JSONObject();
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("examineId", examineId);
		XlglExamExamine xlglExamExamine = xlglExamExamineService.queryObject(examineId);
		List<XlglExamExaminetopic> queryList = xlglExamExaminetopicService.queryList(map);
		List<XlglExamExaminetopicDto> listCount = xlglExamExaminetopicService.findCountBySubjectId(map);
		jsonObject.put("topicList", queryList);
		jsonObject.put("topicCount", listCount);
		jsonObject.put("xlglExamExamine", xlglExamExamine);
		return jsonObject;
	}
	
	/**
	 * 保存 考试基本信息和题目信息
	 * @param IssueStatus 0：保存，1：发布
	 * @param typeAndNum 题类型，题数量，题分数
	 */
	@ResponseBody
	@RequestMapping("/saveOrUpdate")
	public void saveExamineAndTopic(XlglExamExamine xlglExamExamine,String IssueStatus,String[] typeAndNum){
		String random = UUIDUtils.random();
		String userId = CurrentUser.getUserId();
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date startDate = format.parse(xlglExamExamine.getExamineStartDateStr());
			Date endDate = format.parse(xlglExamExamine.getExamineEndDateStr());
			xlglExamExamine.setExamineStartDate(startDate);
			xlglExamExamine.setExamineEndDate(endDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if(StringUtils.isNotBlank(IssueStatus)) {
			xlglExamExamine.setIssueStatus(IssueStatus);
			if(IssueStatus.equals("1"))
				xlglExamExamine.setIssueDate(date);
		}else {
			xlglExamExamine.setIssueStatus("0"); //为空时默认保存
		}
		
		xlglExamExamine.setOverStatus("0");
	/*	if( xlglExamExamine.getExamineStartDate().before(date)&& xlglExamExamine.getExamineEndDate().after(date)) {
			xlglExamExamine.setOverStatus("0");
		}else {
			xlglExamExamine.setOverStatus("1");
		}*/
		
		if(StringUtils.isNotBlank(xlglExamExamine.getId())) {
			xlglExamExamine.setUpdateUser(userId);
			xlglExamExamine.setUpdateDate(date);
			xlglExamExamineService.update(xlglExamExamine);
			if(typeAndNum.length >0) {
				xlglExamExaminetopicService.deleteByExamineId(xlglExamExamine.getId());
			}
		}else {
			xlglExamExamine.setCreateUser(userId);
			xlglExamExamine.setCreateDate(date);
			xlglExamExamine.setUpdateUser(userId);
			xlglExamExamine.setUpdateDate(date);
			xlglExamExamine.setId(random);
			xlglExamExamineService.save(xlglExamExamine);
		}	
			for (int i = 0; i < typeAndNum.length; i++) {
				Map<String,Object> map = new HashMap<String,Object>();
				String[] split2 = typeAndNum[i].split("-");
				Integer fractionalNumber =Integer.parseInt(split2[2]) /Integer.parseInt(split2[1]);
				map.put("subjectId", xlglExamExamine.getExamineSubjectId());
				map.put("topicType", split2[0]);
				map.put("topicNumber", split2[1]);
				map.put("fractionalNumber", fractionalNumber);
				List<XlglExamExaminetopic> randomExtract = xlglExamExaminetopicService.randomExtract(map, xlglExamExamine.getId());
				if(randomExtract.size()>0) {
					xlglExamExaminetopicService.saveBatch(randomExtract);
				}
			}
		
		if(IssueStatus.equals("1")) {
			List<BaseAppUser> queryList = baseAppUserService.queryList(null);
			List<XlglExamMainAnswer> mainExaminelist =new ArrayList<XlglExamMainAnswer>();
			for (BaseAppUser baseAppUser : queryList) {
				XlglExamMainAnswer xlglExamMainAnswer = new XlglExamMainAnswer();
				xlglExamMainAnswer.setId(UUIDUtils.random());
				xlglExamMainAnswer.setExamineId(random);
				xlglExamMainAnswer.setOrganId(baseAppUser.getOrganid());
				xlglExamMainAnswer.setOrganName(baseAppOrganService.queryObject(baseAppUser.getOrganid()).getName());
				xlglExamMainAnswer.setReplyUserId(baseAppUser.getId());
				xlglExamMainAnswer.setReplyUserName(baseAppUser.getTruename());
				xlglExamMainAnswer.setCreateDate(new Date());
				xlglExamMainAnswer.setUpdateDate(new Date());
				xlglExamMainAnswer.setMakeupStatus("0");
				mainExaminelist.add(xlglExamMainAnswer);
				if(mainExaminelist.size() ==10) {
					xlglExamMainAnswerService.saveBatch(mainExaminelist);
					mainExaminelist =new ArrayList<XlglExamMainAnswer>();
				}
			}
			
		}	
		Response.ok();
	}
	
}
