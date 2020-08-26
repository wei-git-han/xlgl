package com.css.app.xlgl.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.css.app.xlgl.dto.XlglExamExaminetopicDto;
import com.css.app.xlgl.entity.XlglExamAnswer;
import com.css.app.xlgl.entity.XlglExamExamine;
import com.css.app.xlgl.entity.XlglExamExaminetopic;
import com.css.app.xlgl.entity.XlglExamMainAnswer;
import com.css.app.xlgl.service.XlglExamAnswerService;
import com.css.app.xlgl.service.XlglExamExamineService;
import com.css.app.xlgl.service.XlglExamExaminetopicService;
import com.css.app.xlgl.service.XlglExamMainAnswerService;
import com.css.base.entity.SSOUser;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.PageUtils;
import com.css.base.utils.Response;
import com.css.base.utils.StringUtils;
import com.css.base.utils.UUIDUtils;
import com.github.pagehelper.PageHelper;


/**
 * 训练考核-考核清单-用户答题表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-03 11:35:28
 */
@Controller
@RequestMapping("app/xlgl/xlglexamanswer")
public class XlglExamAnswerController {
	private final Logger logger = LoggerFactory.getLogger(XlglNewsController.class);
	
	@Autowired
	private XlglExamAnswerService xlglExamAnswerService;
	@Autowired
	private XlglExamMainAnswerService xlglExamMainAnswerService;
	@Autowired
	private XlglExamExamineService xlglExamExamineService;
	@Autowired
	private XlglExamExaminetopicService xlglExamExaminetopicService;
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<XlglExamAnswer> xlglExamAnswerList = xlglExamAnswerService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(xlglExamAnswerList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info")
	public void info(String id){
		XlglExamAnswer xlglExamAnswer = xlglExamAnswerService.queryObject(id);
		Response.json("xlglExamAnswer", xlglExamAnswer);
	}
	
	/**
	 * 用户答完题的试卷信息答题过程中试卷详情
	 */
	@ResponseBody
	@RequestMapping("/view/info")
	public void viewinfo(String examineId){
		JSONObject jsonObject = new JSONObject();
		jsonObject = getAllAnswer(examineId);
		Response.json(jsonObject);
	}
	private JSONObject getAllAnswer(String examineId) {
		JSONObject jsonObject = new JSONObject();
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("examineId", examineId);
		map.put("replyUserId", CurrentUser.getUserId());
		map.put("makeUpStatus", "0");
		List<XlglExamAnswer> list = xlglExamAnswerService.queryList(map);
		XlglExamExamine xlglExamExamine = xlglExamExamineService.queryObject(examineId);
		List<XlglExamAnswer> listType1 = new ArrayList<XlglExamAnswer>();
		List<XlglExamAnswer> listType2 = new ArrayList<XlglExamAnswer>();
		List<XlglExamAnswer> listType3 = new ArrayList<XlglExamAnswer>();
		List<XlglExamAnswer> listType4 = new ArrayList<XlglExamAnswer>();
		for (XlglExamAnswer xlglExamAnswer : list) {
			HashMap<String, Object> hashMap = new HashMap<String,Object>();
			if(StringUtils.isNotBlank(xlglExamAnswer.getTopicOption()) 
					&& xlglExamAnswer.getTopicOption().contains(",")) {
				String[] split = xlglExamAnswer.getTopicOption().split(",");
				for (String str : split) {
					if(str.contains(":")) {
						String[] split2 = str.split(":");
						hashMap.put(split2[0], split2[1]);
					}
				}
			}
			xlglExamAnswer.setTopicOptionMap(hashMap);
			switch (xlglExamAnswer.getTopicType()) {
			case "1":	
				listType1.add(xlglExamAnswer);
				break;
			case "2":
				listType2.add(xlglExamAnswer);
				break;
			case "3":
				listType3.add(xlglExamAnswer);
				break;
			case "4":
				listType4.add(xlglExamAnswer);
				break;
			default:
				break;
			}
		}
		List<XlglExamExaminetopicDto> listCount = xlglExamExaminetopicService.findCountBySubjectId(map);
		jsonObject.put("listType1", listType1);
		jsonObject.put("listType2", listType2);
		jsonObject.put("listType3", listType3);
		jsonObject.put("listType4", listType4);
		jsonObject.put("topicCount", listCount);
		jsonObject.put("xlglExamExamine", xlglExamExamine);
		return jsonObject;
	}
	
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	public void save(XlglExamAnswer xlglExamAnswer){
		xlglExamAnswer.setId(UUIDUtils.random());
		xlglExamAnswerService.save(xlglExamAnswer);
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public void update(XlglExamAnswer xlglExamAnswer){
		xlglExamAnswerService.update(xlglExamAnswer);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public void delete(String[] ids){
		xlglExamAnswerService.deleteBatch(ids);
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		logger.info("当前删除操作人："+CurrentUser.getUsername()+"---id:"+CurrentUser.getUserId()+"--时间是："+date);
		Response.ok();
	}
	/**
	 * 用户考试完成保存
	 * @param xlglExamAnswer 前端传jsonarray,
	 * @param mainAnswerId 成绩单id
	 * @param status 0：考试，1：练习
	 * @param makeupStatus  0：没补考考，1:补考了
	 */
	@ResponseBody
	@RequestMapping("/saveBatch")
	public void saveBath(String xlglExamAnswer,String mainAnswerId,String status,String makeupStatus){
		JSONObject jsonObject = new JSONObject();
		List<XlglExamAnswer> parseArray = JSONArray.parseArray(xlglExamAnswer, XlglExamAnswer.class);
		Integer sum = 0;
		SSOUser ssoUser = CurrentUser.getSSOUser();
		Date date = new Date();
		XlglExamMainAnswer queryObject = xlglExamMainAnswerService.queryObject(mainAnswerId);
		XlglExamExamine xlglExamExamine = xlglExamExamineService.queryObject(queryObject.getExamineId());
		for (XlglExamAnswer eanswer : parseArray) {
			eanswer.setId(UUIDUtils.random());
			eanswer.setMainAnswerId(mainAnswerId);
			eanswer.setReplyUserId(ssoUser.getUserId());
			eanswer.setCreateDate(date);
			eanswer.setUpdateDate(date);
			eanswer.setOrganId(ssoUser.getOrganId());
			eanswer.setOrganName(ssoUser.getOrgName());
			eanswer.setReplyUserName(ssoUser.getFullname());
			eanswer.setExamineId(xlglExamExamine.getId());
			if(StringUtils.isNotBlank(eanswer.getReply())) {
				eanswer.setStatus("1");
				eanswer = getRightReply(eanswer);
				if(eanswer.getCorrectStatus().equals("0")) {
					sum +=eanswer.getFraction();
				}
			}else {
				eanswer.setStatus("0");
				eanswer.setCorrectStatus("1");
			}
		}
		String level ="";
		if(sum >=(xlglExamExamine.getExamineAllNumber()*0.9)) {
			level="优秀";
		}else if((xlglExamExamine.getExamineAllNumber()*0.9) >sum && sum >=(xlglExamExamine.getExamineAllNumber()*0.75) ) {
			level="优良";
		}else if((xlglExamExamine.getExamineAllNumber()*0.75) >sum && sum >=(xlglExamExamine.getExamineAllNumber()*0.6)){
			level="及格";
		}else {
			level="不及格";
		}
		XlglExamMainAnswer xlglExamMainAnswer = new XlglExamMainAnswer();
		xlglExamMainAnswer.setLevel(level);
		xlglExamMainAnswer.setFractionsum(sum);
		if(StringUtils.isNotBlank(makeupStatus)) {
			xlglExamMainAnswer.setMakeupStatus(makeupStatus);
		}else {
			xlglExamMainAnswer.setMakeupStatus("0");
		}
		if(StringUtils.isNotBlank(status)) {
			xlglExamMainAnswer.setStatus(status);
		}else {
			xlglExamMainAnswer.setStatus("0");
		}
		xlglExamMainAnswer.setIsNotExam("1");
		xlglExamMainAnswer.setUpdateDate(date);
		xlglExamMainAnswer.setId(mainAnswerId);
		xlglExamMainAnswerService.update(xlglExamMainAnswer);
		xlglExamAnswerService.saveBatch(parseArray);
		jsonObject.put("mainAnswer", queryObject);
		jsonObject.put("answerList", parseArray);
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("examineId", queryObject.getExamineId());
		map.put("makeUpStatus", "0");
		List<XlglExamExaminetopicDto> listCount = xlglExamExaminetopicService.findCountBySubjectId(map);
		jsonObject.put("listCount", listCount);
		jsonObject.put("code", 0);
		//Response.json(jsonObject);
		Response.ok();
	}
	/**
	 * 判断用户答题是否正确
	 * */
	private XlglExamAnswer getRightReply(XlglExamAnswer eanswer) {
		switch (eanswer.getTopicType()) {
		case "1":
			eanswer.setCorrectStatus(eanswer.getTopicResult().equals(eanswer.getReply())?"0":"1");
			break;
		case "2":
			eanswer.setCorrectStatus(eanswer.getTopicResult().equals(eanswer.getReply())?"0":"1");
			break;
		case "3":
			eanswer.setCorrectStatus(eanswer.getTopicResult().equals(eanswer.getReply())?"0":"1");
			break;
		case "4":
			if(eanswer.getTopicResult().contains(",")) {
				String[] split = eanswer.getTopicResult().split(",");
				for (String string : split) {
					if(!eanswer.getTopicResult().contains(string)) {
						eanswer.setCorrectStatus("1");
						break;
					}
				}
				eanswer.setCorrectStatus("0");
			}else {
				eanswer.setCorrectStatus(eanswer.getTopicResult().equals(eanswer.getReply())?"0":"1");
			}
			break;
		default:
			break;
		}
		return eanswer;
		
	}
	
	/**
	 * 用户练习考试完成保存
	 * @param xlglExamAnswer 前端传jsonarray,
	 * @param mainAnswerId 成绩单id
	 * @param status 0：考试，1：练习
	 */
	@ResponseBody
	@RequestMapping("/saveBatchLIANXI")
	public void saveBathLIANXI(String xlglExamAnswer,String mainAnswerId,String status){
		try {
		JSONObject jsonObject = new JSONObject();
		List<XlglExamAnswer> parseArray = JSONArray.parseArray(xlglExamAnswer, XlglExamAnswer.class);
		Integer sum = 0;
		SSOUser ssoUser = CurrentUser.getSSOUser();
		Date date = new Date();
		XlglExamMainAnswer queryObject = xlglExamMainAnswerService.queryObject(mainAnswerId);
		XlglExamExamine xlglExamExamine = xlglExamExamineService.queryObject(queryObject.getExamineId());
		jsonObject.put("examineId", xlglExamExamine.getId());
		for (XlglExamAnswer eanswer : parseArray) {
			eanswer.setId(UUIDUtils.random());
			eanswer.setMainAnswerId(mainAnswerId);
			eanswer.setReplyUserId(ssoUser.getUserId());
			eanswer.setCreateDate(date);
			eanswer.setUpdateDate(date);
			eanswer.setOrganId(ssoUser.getOrganId());
			eanswer.setOrganName(ssoUser.getOrgName());
			eanswer.setReplyUserName(ssoUser.getFullname());
			eanswer.setExamineId(xlglExamExamine.getId());
			if(StringUtils.isNotBlank(eanswer.getReply())) {
				eanswer.setStatus("1");
				eanswer = getRightReply(eanswer);
				if(eanswer.getCorrectStatus().equals("0")) {
					sum +=eanswer.getFraction();
				}
			}else {
				eanswer.setStatus("0");
				eanswer.setCorrectStatus("1");
			}
		}
		XlglExamMainAnswer xlglExamMainAnswer = new XlglExamMainAnswer();
		String level ="";
		if(StringUtils.isNotBlank(xlglExamExamine.getLianxiType()) && xlglExamExamine.getLianxiType().equals("0")) {
			if(sum >=(xlglExamExamine.getExamineAllNumber()*0.9)) {
				level="优秀";
			}else if((xlglExamExamine.getExamineAllNumber()*0.9) >sum && sum >=(xlglExamExamine.getExamineAllNumber()*0.75) ) {
				level="优良";
			}else if((xlglExamExamine.getExamineAllNumber()*0.75) >sum && sum >=(xlglExamExamine.getExamineAllNumber()*0.6)){
				level="及格";
			}else {
				level="不及格";
			}
			xlglExamMainAnswer.setLevel(level);
			xlglExamMainAnswer.setFractionsum(sum);
		}
		xlglExamMainAnswer.setMakeupStatus("0");
		
		xlglExamMainAnswer.setStatus(status);
		xlglExamMainAnswer.setIsNotExam("1");
		xlglExamMainAnswer.setUpdateDate(date);
		xlglExamMainAnswer.setId(mainAnswerId);
		xlglExamMainAnswerService.update(xlglExamMainAnswer);
		xlglExamAnswerService.saveBatch(parseArray);
		jsonObject.put("mainAnswerId", queryObject.getId());	
		jsonObject.put("code", 0);
		jsonObject.put("msg", "success");
		Response.json(jsonObject);
		}catch (Exception e) {
			Response.error();
		}
	}
	
}
