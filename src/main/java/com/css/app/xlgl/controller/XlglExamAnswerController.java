package com.css.app.xlgl.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	@RequestMapping("/info/{id}")
	public void info(@PathVariable("id") String id){
		XlglExamAnswer xlglExamAnswer = xlglExamAnswerService.queryObject(id);
		Response.json("xlglExamAnswer", xlglExamAnswer);
	}
	
	/**
	 * 用户答完题的试卷信息答题过程中试卷详情
	 */
	@ResponseBody
	@RequestMapping("/view/info")
	public void viewinfo( String examineId){
		JSONObject jsonObject = new JSONObject();
		Map<String, Object> map = new HashMap<>();
		map.put("examineId", examineId);
		List<XlglExamAnswer> xlglExamAnswerList = xlglExamAnswerService.queryList(map);
		XlglExamExamine queryObject = xlglExamExamineService.queryObject(examineId);
		jsonObject.put("list", xlglExamAnswerList);
		jsonObject.put("examine", queryObject);
		Response.json(jsonObject);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	public void save(@RequestBody XlglExamAnswer xlglExamAnswer){
		xlglExamAnswer.setId(UUIDUtils.random());
		xlglExamAnswerService.save(xlglExamAnswer);
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public void update(@RequestBody XlglExamAnswer xlglExamAnswer){
		xlglExamAnswerService.update(xlglExamAnswer);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public void delete(@RequestBody String[] ids){
		xlglExamAnswerService.deleteBatch(ids);
		
		Response.ok();
	}
	/**
	 * 用户考试完成保存
	 * @param xlglExamAnswer 前端传jsonarray,
	 */
	@ResponseBody
	@RequestMapping("/saveBatch")
	public void saveBath(String xlglExamAnswer,String mainAnswerId){
		JSONObject jsonObject = new JSONObject();
		List<XlglExamAnswer> parseArray = JSONArray.parseArray(xlglExamAnswer, XlglExamAnswer.class);
		Integer sum = 0;
		SSOUser ssoUser = CurrentUser.getSSOUser();
		Date date = new Date();
		for (XlglExamAnswer eanswer : parseArray) {
			eanswer.setId(UUIDUtils.random());
			eanswer.setMainAnswerId(mainAnswerId);
			eanswer.setReplyUserId(ssoUser.getUserId());
			eanswer.setCreateDate(date);
			eanswer.setUpdateDate(date);
			eanswer.setOrganId(ssoUser.getOrganId());
			eanswer.setOrganName(ssoUser.getOrgName());
			eanswer.setReplyUserName(ssoUser.getFullname());
			if(StringUtils.isNotBlank(eanswer.getReply())) {
				eanswer.setStatus("1");
				if(eanswer.getTopicResult().equals(eanswer.getReply())) {
					sum +=eanswer.getFraction();
					eanswer.setCorrectStatus("0");
				}else {
					eanswer.setCorrectStatus("1");
				}
			}else {
				eanswer.setStatus("0");
			}
		}
		String level ="";
		if(sum >=85) {
			level="优秀";
		}else if(85 >sum && sum >=70 ) {
			level="优良";
		}else if(70 >sum && sum >=60){
			level="及格";
		}else {
			level="不及格";
		}
		XlglExamMainAnswer xlglExamMainAnswer = new XlglExamMainAnswer();
		xlglExamMainAnswer.setLevel(level);
		xlglExamMainAnswer.setFractionsum(sum);
		xlglExamMainAnswer.setMakeupStatus("1");
		xlglExamMainAnswer.setUpdateDate(date);
		xlglExamMainAnswerService.update(xlglExamMainAnswer);
		xlglExamAnswerService.saveBatch(parseArray);
		XlglExamMainAnswer queryObject = xlglExamMainAnswerService.queryObject("mainAnswerId");
		jsonObject.put("mainAnswer", queryObject);
		jsonObject.put("answerList", parseArray);
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("examineId", queryObject.getExamineId());
		map.put("makeUpStatus", "0");
		List<XlglExamExaminetopicDto> listCount = xlglExamExaminetopicService.findCountBySubjectId(map);
		jsonObject.put("listCount", listCount);
		Response.json(jsonObject);
	}
	
}
