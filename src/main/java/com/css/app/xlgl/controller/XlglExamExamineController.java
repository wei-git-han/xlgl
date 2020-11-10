package com.css.app.xlgl.controller;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.css.addbase.apporgan.entity.BaseAppOrgan;
import com.css.addbase.apporgan.entity.BaseAppUser;
import com.css.addbase.apporgan.service.BaseAppOrganService;
import com.css.addbase.apporgan.service.BaseAppUserService;
import com.css.app.xlgl.dao.XlglExamExamineDao;
import com.css.app.xlgl.dto.ExamMainAnswerAnalyseDto;
import com.css.app.xlgl.dto.XlglExamExaminetopicDto;
import com.css.app.xlgl.entity.XlglExamExamine;
import com.css.app.xlgl.entity.XlglExamExamineMakeup;
import com.css.app.xlgl.entity.XlglExamExaminetopic;
import com.css.app.xlgl.entity.XlglExamMainAnswer;
import com.css.app.xlgl.entity.XlglExamTopic;
import com.css.app.xlgl.service.XlglExamExamineMakeupService;
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
	private final Logger logger = LoggerFactory.getLogger(XlglNewsController.class);

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
	@Autowired
	private XlglExamExamineMakeupService xlglExamExamineMakeupService;

	/**
	 * 考核清单列表
	 * 
	 * @param time
	 *            发布时间
	 * @param examineName
	 *            考试名称
	 * @param status
	 *            0：考试，1:练习xlglexamanswer
	 */
	@ResponseBody
	@RequestMapping("/list")
	public void list(Integer page, Integer limit, String time, String examineName, String status) {
		Map<String, Object> map = new HashMap<>();
		Date date = new Date();
		String userId = CurrentUser.getUserId();

		map.put("issueDate", time);
		map.put("examineName", examineName);
		map.put("issueStatus", "1");
		map.put("status", status);
		PageHelper.startPage(page, limit);
		// 查询列表数据
		List<XlglExamExamine> xlglExamExamineList = xlglExamExamineService.queryList(map);
		PageUtils pageUtil = new PageUtils(xlglExamExamineList);
		DecimalFormat format = new DecimalFormat("0.00");
		for (XlglExamExamine xlglExamExamine : xlglExamExamineList) {
			int queryTotal = xlglExamExamineService.findCount(xlglExamExamine.getId());// 总用户人数
			HashMap<String, Object> mapAll = new HashMap<String, Object>();
			Map<String, Object> mapAnswer = new HashMap<>();
			mapAll.put("examineId", xlglExamExamine.getId());
			mapAll.put("isNotExam", "1");
			String number = xlglExamMainAnswerService.queryUserCount(mapAll);// 每个试卷的参考人数

			// 当前用户考试状态 UserStatus 1:已参加 2开始考试  3:超时未考  4:无法考试，无成绩单	//overStatus  考试是否结束 0：没结束进行中，1：已结束已完结 2 :补考开始，99：未开始
			mapAnswer.put("examineId", xlglExamExamine.getId());
			mapAnswer.put("replyUserId", userId);
			List<XlglExamMainAnswer> queryList = xlglExamMainAnswerService.queryList(mapAnswer);
			if (queryList.size() > 0) {
				XlglExamMainAnswer xlglExamMainAnswer = queryList.get(0);
				if (xlglExamExamine.getOverStatus().equals("0") && xlglExamMainAnswer.getIsNotExam().equals("0") ) {
					xlglExamExamine.setUserStatus("2");
				} else if (xlglExamExamine.getOverStatus().equals("0") && xlglExamMainAnswer.getIsNotExam().equals("1") ) {
					xlglExamExamine.setUserStatus("1");
				} else if (xlglExamExamine.getOverStatus().equals("1") && xlglExamMainAnswer.getIsNotExam().equals("0") ) {
					xlglExamExamine.setUserStatus("3");
				}else if(xlglExamExamine.getOverStatus().equals("1") && xlglExamMainAnswer.getIsNotExam().equals("1")) {
					xlglExamExamine.setUserStatus("1");
				}else if(xlglExamExamine.getOverStatus().equals("2")&& xlglExamMainAnswer.getIsNotExam().equals("0")){
					xlglExamExamine.setUserStatus("2");
				}else if(xlglExamExamine.getOverStatus().equals("2")&& xlglExamMainAnswer.getIsNotExam().equals("1")) {
					xlglExamExamine.setUserStatus("1");
				}else if(xlglExamExamine.getOverStatus().equals("99")) {
					xlglExamExamine.setUserStatus("2");
				}else {
					xlglExamExamine.setUserStatus("2");
				}
			} else {
				xlglExamExamine.setUserStatus("4");
			}
			
			// 当前考试是否发起补考
			List<XlglExamExamineMakeup> makeupList = xlglExamExamineMakeupService.queryList(mapAnswer);
			if (makeupList.size() > 0 && xlglExamExamine.getOverStatus().equals("2")) {
				String id = makeupList.get(0).getId();
				xlglExamExamine.setMakeupId(id);
			}

			// 当前考试参考人员人数，未参考人员人数、参考率计算
			Integer numberInto = 0;
			if (StringUtils.isNotBlank(number)) {
				numberInto = Integer.parseInt(number);
			}
			xlglExamExamine.setNumberInto(numberInto);
			Integer numberIntoNot = queryTotal - numberInto;
			if (numberIntoNot < 0) {
				xlglExamExamine.setNumberIntoNot(0);
			} else {
				xlglExamExamine.setNumberIntoNot(numberIntoNot);
			}
			String raio;
			if (numberInto == 0 || queryTotal == 0) {
				raio = "0";
			} else {
				raio = format.format(((float) numberInto / queryTotal) * 100);// 参考率
			}
			xlglExamExamine.setRatio(raio + "%");
			// 更改状态
			if (makeupList.size() > 0) {// 查看是否有补考，如果有补考则以补考结束时间为准
				XlglExamExamineMakeup xlglExamExamineMakeup = makeupList.get(0);
				if (xlglExamExamineMakeup.getMakeUpEndDate() != null && xlglExamExamineMakeup.getMakeUpStartDate() != null) {
					xlglExamExamine.setExamineEndDate(xlglExamExamineMakeup.getMakeUpEndDate());
					xlglExamExamine.setExamineStartDate(xlglExamExamineMakeup.getMakeUpStartDate());
				}
				if (xlglExamExamineMakeup.getMakeUpEndDate() != null
						&& xlglExamExamineMakeup.getMakeUpEndDate().before(date)) {
					XlglExamExamine ex = new XlglExamExamine();
					ex.setId(xlglExamExamine.getId());
					ex.setOverStatus("1");
					xlglExamExamine.setOverStatus("1");
					xlglExamExamineService.update(ex);
				} else if (xlglExamExamineMakeup.getMakeUpEndDate() != null
						&& xlglExamExamineMakeup.getMakeUpStartDate().before(date)
						&& xlglExamExamineMakeup.getMakeUpEndDate().after(date)
						&& !xlglExamExamine.getOverStatus().equals("0")) {
					XlglExamExamine ex = new XlglExamExamine();
					ex.setId(xlglExamExamine.getId());
					ex.setOverStatus("2");
					xlglExamExamineService.update(ex);
				} else if (xlglExamExamineMakeup.getMakeUpStartDate() != null
						&& xlglExamExamineMakeup.getMakeUpEndDate() != null
						&& xlglExamExamineMakeup.getMakeUpStartDate().after(date)) {
					XlglExamExamine ex = new XlglExamExamine();
					ex.setId(xlglExamExamine.getId());
					ex.setOverStatus("99");
					xlglExamExamineService.update(ex);
				}
			} else {
				if (xlglExamExamine.getExamineEndDate() != null && xlglExamExamine.getIssueStatus() != null
						&& xlglExamExamine.getExamineEndDate().before(date)) {
					XlglExamExamine ex = new XlglExamExamine();
					ex.setId(xlglExamExamine.getId());
					ex.setOverStatus("1");
					xlglExamExamine.setOverStatus("1");
					xlglExamExamineService.update(ex);
				} else if (xlglExamExamine.getExamineEndDate() != null && xlglExamExamine.getIssueStatus() != null
						&& xlglExamExamine.getExamineStartDate().before(date)
						&& xlglExamExamine.getExamineEndDate().after(date)
						&& !xlglExamExamine.getOverStatus().equals("0")) {
					XlglExamExamine ex = new XlglExamExamine();
					ex.setId(xlglExamExamine.getId());
					ex.setOverStatus("0");
					xlglExamExamineService.update(ex);
				}
			}
			//XlglExamExamine queryObject = xlglExamExamineService.queryObject(xlglExamExamine.getId());
		}
		Response.json("page", pageUtil);
	}

	/**
	 * 统计已结束的考试和进行中的考试数量
	 */
	@ResponseBody
	@RequestMapping("/conutInto")
	public void conutInto() {
		JSONObject jsonObject = new JSONObject();
		Map<String, Object> map = new HashMap<>();
		map.put("issueStatus", "1");
		Date date = new Date();
		// 查询列表数据
		List<XlglExamExamine> xlglExamExamineList = xlglExamExamineService.queryList(map);
		for (XlglExamExamine xlglExamExamine : xlglExamExamineList) {
			map.put("examineId", xlglExamExamine.getId());
			// 当前考试是否发起补考
			List<XlglExamExamineMakeup> makeupList = xlglExamExamineMakeupService.queryList(map);
			if (makeupList.size() > 0) {// 查看是否有补考，如果有补考则以补考结束时间为准
				XlglExamExamineMakeup xlglExamExamineMakeup = makeupList.get(0);
				if (xlglExamExamineMakeup.getMakeUpEndDate() != null
						&& xlglExamExamineMakeup.getMakeUpEndDate().before(date)) {
					XlglExamExamine ex = new XlglExamExamine();
					ex.setId(xlglExamExamine.getId());
					ex.setOverStatus("1");
					xlglExamExamine.setOverStatus("1");
					xlglExamExamineService.update(ex);
				} else if (xlglExamExamineMakeup.getMakeUpEndDate() != null
						&& xlglExamExamineMakeup.getMakeUpStartDate().before(date)
						&& xlglExamExamineMakeup.getMakeUpEndDate().after(date)
						&& !xlglExamExamine.getOverStatus().equals("0")) {
					XlglExamExamine ex = new XlglExamExamine();
					ex.setId(xlglExamExamine.getId());
					ex.setOverStatus("2");
					xlglExamExamineService.update(ex);
				} else if (xlglExamExamineMakeup.getMakeUpStartDate() != null
						&& xlglExamExamineMakeup.getMakeUpEndDate() != null
						&& xlglExamExamineMakeup.getMakeUpStartDate().after(date)) {
					XlglExamExamine ex = new XlglExamExamine();
					ex.setId(xlglExamExamine.getId());
					ex.setOverStatus("99");
					xlglExamExamineService.update(ex);
				}
			} else {
				if (xlglExamExamine.getExamineEndDate() != null && xlglExamExamine.getIssueStatus() != null
						&& xlglExamExamine.getExamineEndDate().before(new Date())) {
					XlglExamExamine ex = new XlglExamExamine();
					ex.setId(xlglExamExamine.getId());
					ex.setOverStatus("1");
					xlglExamExamine.setOverStatus("1");
					xlglExamExamineService.update(ex);
				} else if (xlglExamExamine.getExamineEndDate() != null && xlglExamExamine.getIssueStatus() != null
						&& date.after(xlglExamExamine.getExamineStartDate())
						&& date.before(xlglExamExamine.getExamineEndDate())
						&& !xlglExamExamine.getOverStatus().equals("0")) {
					XlglExamExamine ex = new XlglExamExamine();
					ex.setId(xlglExamExamine.getId());
					ex.setOverStatus("0");
					xlglExamExamineService.update(ex);
				}
			}
		}
		map.put("status", "0");
		map.put("overStatus", "0");
		int into = xlglExamExamineDao.queryTotal(map);// 进行中
		map.put("overStatus", "2");
		int makeUp = xlglExamExamineDao.queryTotal(map);// 补考中
		map.put("overStatus", "1");
		int intoNot = xlglExamExamineDao.queryTotal(map);// 已结束
		jsonObject.put("into", into + makeUp);
		jsonObject.put("intoNot", intoNot);
		Response.json(jsonObject);
	}

	/**
	 * 考核组织-未发布考核列表
	 */
	@ResponseBody
	@RequestMapping("/issueStatusList")
	public void issueStatusList(Integer page, Integer limit, String examineName) {
		Map<String, Object> map = new HashMap<>();
		map.put("issueStatus", "0");
		map.put("examineName", examineName);
		PageHelper.startPage(page, limit);

		// 查询列表数据
		List<XlglExamExamine> xlglExamExamineList = xlglExamExamineService.queryList(map);
		for (XlglExamExamine xlglExamExamine : xlglExamExamineList) {
			BaseAppUser queryObject = baseAppUserService.queryObject(xlglExamExamine.getUpdateUser());
			xlglExamExamine.setUpdateUserName(queryObject.getTruename());
		}

		PageUtils pageUtil = new PageUtils(xlglExamExamineList);
		Response.json("page", pageUtil);
	}

	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info")
	public void info(String id) {
		JSONObject jsonObject = new JSONObject();
		Map<String, Object> map = new HashMap<String, Object>();
		XlglExamExamine xlglExamExamine = xlglExamExamineService.queryObject(id);
		map.put("examineId", id);
		map.put("makeUpStatus", "0");
		List<XlglExamExaminetopicDto> listCount = xlglExamExaminetopicService.findCountBySubjectId(map);
		List<XlglExamExaminetopic> list = xlglExamExaminetopicService.findListBySubjectId(map);
		StringBuffer strbu = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			if (i == list.size() - 1) {
				strbu.append(list.get(i).getId());
			} else {
				strbu.append(list.get(i).getId() + ",");
			}
		}
		map.put("replyUserId", CurrentUser.getUserId());
		List<XlglExamMainAnswer> queryList = xlglExamMainAnswerService.queryList(map);
		if (queryList != null && queryList.size() > 0) {
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
	public void save(XlglExamExamine xlglExamExamine) {
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
	public void update(XlglExamExamine xlglExamExamine) {
		xlglExamExamineService.update(xlglExamExamine);

		Response.ok();
	}

	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public void delete(String[] ids) {
		for (String string : ids) {
			xlglExamExamineService.delete(string);
		}
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		logger.info("当前删除操作人：" + CurrentUser.getUsername() + "---id:" + CurrentUser.getUserId() + "--时间是：" + date);
		/*
		 * for (int i = 0; i < ids.length; i++) {
		 * xlglExamExaminetopicService.deleteByExamineId(ids[i]); }
		 */
		Response.ok();
	}

	/**
	 * 考核清单-用户开始考试详情
	 * 
	 * @param examineId
	 *            试卷基本信息表id
	 * @param isNotExam
	 *            未考状态0：没考，1:考了
	 * @param makeupExamineId
	 *            补考id
	 * @param makeupStatus
	 *            //补考考状态0：没补考考，1:补考了
	 * @param status
	 *            状态 0：考试，1：练习
	 */
	@ResponseBody
	@RequestMapping("/view/examine")
	public void viewExamine(String examineId, String isNotExam, String makeupExamineId, String makeupStatus,
			String status) {
		JSONObject jsonObject = new JSONObject();
		Map<String, Object> map = new HashMap<>();
		SSOUser ssoUser = CurrentUser.getSSOUser();
		map.put("examineId", examineId);
		map.put("replyUserId", ssoUser.getUserId());
		map.put("isNotExam", isNotExam);
		map.put("status", status);
		List<XlglExamExamineMakeup> makeupList = xlglExamExamineMakeupService.queryList(map);
		if (makeupList.size() > 0) {
			XlglExamExamineMakeup xlglExamExamineMakeup = makeupList.get(0);
			jsonObject = getExamine(examineId, xlglExamExamineMakeup.getId());
		} else {
			jsonObject = getExamine(examineId, null);
		}
		List<XlglExamMainAnswer> queryList = xlglExamMainAnswerService.queryList(map);
		if (queryList.size() > 0) {
			XlglExamMainAnswer xlglExamMainAnswer = queryList.get(0);
			jsonObject.put("MainAnswerID", xlglExamMainAnswer.getId());
		}else {
			XlglExamExamine queryObject = xlglExamExamineService.queryObject(examineId);
			XlglExamMainAnswer xlglExamMainAnswer = new XlglExamMainAnswer();
			String random = UUIDUtils.random();
			xlglExamMainAnswer.setId(random);
			xlglExamMainAnswer.setExamineId(examineId);
			xlglExamMainAnswer.setOrganId(ssoUser.getOrganId());
			xlglExamMainAnswer.setOrganName(ssoUser.getOrgName());
			xlglExamMainAnswer.setReplyUserId(ssoUser.getUserId());
			xlglExamMainAnswer.setReplyUserName(ssoUser.getFullname());
			xlglExamMainAnswer.setCreateDate(new Date());
			xlglExamMainAnswer.setUpdateDate(new Date());
			xlglExamMainAnswer.setMakeupStatus("0");
			xlglExamMainAnswer.setStatus(queryObject.getStatus());
			xlglExamMainAnswer.setIsNotExam("0");
			xlglExamMainAnswer.setCreateUser(CurrentUser.getUserId());
			xlglExamMainAnswer.setUpdateUser(CurrentUser.getUserId());
			xlglExamMainAnswerService.save(xlglExamMainAnswer);
			jsonObject.put("MainAnswerID",random);
		}
		Response.json(jsonObject);
	}

	/**
	 * 考核清单-查看原考题
	 */
	@ResponseBody
	@RequestMapping("/view")
	public void view(String examineId) {
		JSONObject jsonObject = getExamine(examineId, null);
		Response.json(jsonObject);

	}

	private JSONObject getExamine(String examineId, String makeUpId) {
		JSONObject jsonObject = new JSONObject();
		Map<String, Object> map = new HashMap<String, Object>();
		if (StringUtils.isNotBlank(makeUpId)) {
			map.put("makeUpStatus", "1");
			map.put("examineId", examineId);
			map.put("makeUpId", makeUpId);
		} else {
			map.put("examineId", examineId);
			map.put("makeUpStatus", "0");
		}
		map.put("makeUpId", makeUpId);
		XlglExamExamine xlglExamExamine = xlglExamExamineService.queryObject(examineId);
		List<XlglExamExaminetopic> queryList = xlglExamExaminetopicService.queryList(map);
		List<XlglExamExaminetopic> listType1 = new ArrayList<XlglExamExaminetopic>();
		List<XlglExamExaminetopic> listType2 = new ArrayList<XlglExamExaminetopic>();
		List<XlglExamExaminetopic> listType3 = new ArrayList<XlglExamExaminetopic>();
		List<XlglExamExaminetopic> listType4 = new ArrayList<XlglExamExaminetopic>();
		for (XlglExamExaminetopic xlglExamExaminetopic : queryList) {
			HashMap<String, Object> hashMap = new HashMap<String, Object>();
			if (StringUtils.isNotBlank(xlglExamExaminetopic.getTopicOption())
					&& xlglExamExaminetopic.getTopicOption().contains(",")) {
				String[] split = xlglExamExaminetopic.getTopicOption().split(",");
				for (String str : split) {
					if (str.contains(":")) {
						String[] split2 = str.split(":");
						if (split2.length == 2) {
							hashMap.put(split2[0], split2[1]);
						} else {
							hashMap.put(split2[0], "");
						}
					}
				}
			}
			if (StringUtils.isNotBlank(xlglExamExaminetopic.getPictureStatus())
					&& xlglExamExaminetopic.getPictureStatus().equals("0")) {
				List<String> columnList = new LinkedList<String>();
				HashMap<String, String> pictureMap = new HashMap<String, String>();
				if (StringUtils.isNotBlank(xlglExamExaminetopic.getPictureColumn())
						&& xlglExamExaminetopic.getPictureColumn().contains(",")) {
					String[] split = xlglExamExaminetopic.getPictureColumn().split(",");
					for (String string : split) {
						columnList.add(string);
					}
				} else if (StringUtils.isNotBlank(xlglExamExaminetopic.getPictureColumn())) {
					columnList.add(xlglExamExaminetopic.getPictureColumn());
				}
				if (StringUtils.isNotBlank(xlglExamExaminetopic.getPictureOption())
						&& xlglExamExaminetopic.getPictureOption().contains(",")) {
					String[] split = xlglExamExaminetopic.getPictureOption().split(",");
					for (String string : split) {
						String[] split2 = string.split("-");
						pictureMap.put(split2[0], split2[1]);
					}
				} else if (StringUtils.isNotBlank(xlglExamExaminetopic.getPictureOption())) {
					String[] split = xlglExamExaminetopic.getPictureOption().split("-");
					hashMap.put(split[0], split[1]);
				}
				xlglExamExaminetopic.setColumnList(columnList);
				xlglExamExaminetopic.setMap(pictureMap);
			}
			xlglExamExaminetopic.setTopicOptionMap(hashMap);
			switch (xlglExamExaminetopic.getTopicType()) {
			case "1":
				listType1.add(xlglExamExaminetopic);
				break;
			case "2":
				listType2.add(xlglExamExaminetopic);
				break;
			case "3":
				listType3.add(xlglExamExaminetopic);
				break;
			case "4":
				listType4.add(xlglExamExaminetopic);
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
	 * 保存 考试基本信息和题目信息
	 * 
	 * @param IssueStatus
	 *            0：保存，1：发布
	 * @param status
	 *            状态 0：考试，1：练习
	 * @param typeAndNum
	 *            题类型，题数量，题分数
	 * @param lianxiType
	 *            0：模拟练习，1：自主练习
	 */
	@ResponseBody
	@RequestMapping("/saveOrUpdate")
	public void saveExamineAndTopic(XlglExamExamine xlglExamExamine, String IssueStatus, String[] typeAndNum,
			String status) {
		try {
			JSONObject jsonObject = new JSONObject();
			String random = UUIDUtils.random();
			jsonObject.put("examineId", random);
			String userId = CurrentUser.getUserId();
			Date date = new Date();
			if (StringUtils.isNotBlank(status) && status.equals("0")) {
				if (xlglExamExamine.getExamineStartDateStr().contains(".")) {
					SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
					Date startDate = format.parse(xlglExamExamine.getExamineStartDateStr());
					Date endDate = format.parse(xlglExamExamine.getExamineEndDateStr());
					xlglExamExamine.setExamineStartDate(startDate);
					xlglExamExamine.setExamineEndDate(endDate);
				} else if (xlglExamExamine.getExamineStartDateStr().contains("-")) {
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date startDate = format.parse(xlglExamExamine.getExamineStartDateStr());
					Date endDate = format.parse(xlglExamExamine.getExamineEndDateStr());
					xlglExamExamine.setExamineStartDate(startDate);
					xlglExamExamine.setExamineEndDate(endDate);
				}
			}
			if (status.equals("0")) {
				if (StringUtils.isNotBlank(IssueStatus)) {
					xlglExamExamine.setIssueStatus(IssueStatus);
					if (IssueStatus.equals("1"))
						xlglExamExamine.setIssueDate(date);
				} else {
					xlglExamExamine.setIssueStatus("0"); // 为空时默认保存
				}
			}
			xlglExamExamine.setStatus(status);
			if (xlglExamExamine.getExamineStartDate() != null
					&& xlglExamExamine.getExamineStartDate().before(new Date())) {
				xlglExamExamine.setOverStatus("0");
			} else {
				xlglExamExamine.setOverStatus("99");
			}
			boolean boole = true;
			if (StringUtils.isNotBlank(xlglExamExamine.getId())) {// 修改
				xlglExamExamine.setUpdateUser(userId);
				xlglExamExamine.setUpdateDate(date);
				xlglExamExamine.setMakeupStatus("0");
				xlglExamExamineService.update(xlglExamExamine);
				if (typeAndNum.length > 0) {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("examineId", xlglExamExamine.getId());
					map.put("makeUpStatus", "0");
					xlglExamExaminetopicService.deleteByExamineId(map);
				}
			} else {
				String typeNumStr = "";
				for (int i = 0; i < typeAndNum.length; i++) {
					if (typeAndNum.length - 1 == i) {
						typeNumStr = typeNumStr + typeAndNum[i];
					} else {
						typeNumStr = typeNumStr + typeAndNum[i] + ",";
					}
				}
				boole = false;
				xlglExamExamine.setTypeNumStr(typeNumStr);
				xlglExamExamine.setMakeupStatus("0");
				xlglExamExamine.setCreateUser(userId);
				xlglExamExamine.setCreateDate(date);
				xlglExamExamine.setUpdateUser(userId);
				xlglExamExamine.setUpdateDate(date);
				xlglExamExamine.setId(random);
				if (xlglExamExamine.getExamineAllNumber() == null) {
					Integer sum = 0;
					for (int i = 0; i < typeAndNum.length; i++) {
						String[] split2 = typeAndNum[i].split("-");
						sum += Integer.parseInt(split2[1]) * Integer.parseInt(split2[2]);
					}
					xlglExamExamine.setExamineAllNumber(sum);
				}
				xlglExamExamineService.save(xlglExamExamine);
			}
			for (int i = 0; i < typeAndNum.length; i++) {
				Map<String, Object> map = new HashMap<String, Object>();
				String[] split2 = typeAndNum[i].split("-");
				map.put("subjectId", xlglExamExamine.getExamineSubjectId());
				map.put("topicType", split2[0]);
				map.put("topicNumber", split2[1]);
				map.put("fractionalNumber", split2[2]);
				List<XlglExamExaminetopic> randomExtract = xlglExamExaminetopicService.randomExtract(map,
						xlglExamExamine.getId(), null);
				if (randomExtract.size() > 0) {
					List<XlglExamExaminetopic> list = new ArrayList<XlglExamExaminetopic>();
					for (int j = 0; j < randomExtract.size(); j++) {
						list.add(randomExtract.get(j));
						if (list.size() == 10) {
							xlglExamExaminetopicService.saveBatch(list);
							list = new ArrayList<XlglExamExaminetopic>();
						} else if (randomExtract.size() - 1 - j == 0) {
							xlglExamExaminetopicService.saveBatch(list);
						}
					}

				}
			}
			if (status.equals("0")) {
				if (IssueStatus.equals("1") && StringUtils.isNotBlank(xlglExamExamine.getId())) {
					List<BaseAppUser> queryList = baseAppUserService.queryList(null);
					List<XlglExamMainAnswer> mainExaminelist = new ArrayList<XlglExamMainAnswer>();
					int i = 1;
					for (BaseAppUser baseAppUser : queryList) {
						XlglExamMainAnswer xlglExamMainAnswer = new XlglExamMainAnswer();
						xlglExamMainAnswer.setId(UUIDUtils.random());
						if (boole) {
							xlglExamMainAnswer.setExamineId(xlglExamExamine.getId());
						} else {
							xlglExamMainAnswer.setExamineId(random);
						}
						xlglExamMainAnswer.setOrganId(baseAppUser.getOrganid());
						xlglExamMainAnswer
								.setOrganName(baseAppOrganService.queryObject(baseAppUser.getOrganid()).getName());
						xlglExamMainAnswer.setReplyUserId(baseAppUser.getId());
						xlglExamMainAnswer.setReplyUserName(baseAppUser.getTruename());
						xlglExamMainAnswer.setCreateDate(new Date());
						xlglExamMainAnswer.setUpdateDate(new Date());
						xlglExamMainAnswer.setMakeupStatus("0");
						xlglExamMainAnswer.setStatus(status);
						xlglExamMainAnswer.setIsNotExam("0");
						xlglExamMainAnswer.setCreateUser(CurrentUser.getUserId());
						xlglExamMainAnswer.setUpdateUser(CurrentUser.getUserId());
						mainExaminelist.add(xlglExamMainAnswer);
						if (mainExaminelist.size() == 10) {
							xlglExamMainAnswerService.saveBatch(mainExaminelist);
							mainExaminelist = new ArrayList<XlglExamMainAnswer>();
						} else if (queryList.size() - i == 0) {
							xlglExamMainAnswerService.saveBatch(mainExaminelist);
						}
						i++;
					}
				}
			} else if (status.equals("1")) {
				SSOUser ssoUser = CurrentUser.getSSOUser();
				XlglExamMainAnswer xlglExamMainAnswer = new XlglExamMainAnswer();
				xlglExamMainAnswer.setId(UUIDUtils.random());
				xlglExamMainAnswer.setExamineId(random);
				xlglExamMainAnswer.setOrganId(ssoUser.getOrganId());
				xlglExamMainAnswer.setOrganName(ssoUser.getOrgName());
				xlglExamMainAnswer.setReplyUserId(ssoUser.getUserId());
				xlglExamMainAnswer.setReplyUserName(ssoUser.getFullname());
				xlglExamMainAnswer.setCreateDate(new Date());
				xlglExamMainAnswer.setUpdateDate(new Date());
				xlglExamMainAnswer.setMakeupStatus("0");
				xlglExamMainAnswer.setStatus(status);
				xlglExamMainAnswer.setIsNotExam("0");
				xlglExamMainAnswer.setCreateUser(CurrentUser.getUserId());
				xlglExamMainAnswer.setUpdateUser(CurrentUser.getUserId());
				xlglExamMainAnswer.setLianxiType(xlglExamExamine.getLianxiType());
				xlglExamMainAnswerService.save(xlglExamMainAnswer);
			}
			jsonObject.put("code", "0");
			jsonObject.put("msg", "success");
			Response.json(jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
			Response.error();
		}
	}

	/**
	 * 
	 * 试卷 参考率、参考人数、优秀率
	 * 
	 * @param examineId
	 *            试卷id
	 */
	@ResponseBody
	@RequestMapping("/examineTotal")
	public void examineTotal(String examineId) {
		JSONObject jsonObject = new JSONObject();
		int queryTotal = xlglExamExamineService.findCount(examineId);// 需要参考的人数
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("examineId", examineId);
		map.put("isNotExam", "1");
		map.put("status", "0");
		String number = xlglExamMainAnswerService.queryUserCount(map);// 试卷的参考人数
		Integer numberInto = 0;
		if (StringUtils.isNotBlank(number)) {
			numberInto = Integer.parseInt(number);
		}
		DecimalFormat format = new DecimalFormat("0.00");
		String raio;
		if (numberInto == 0 || queryTotal == 0) {
			raio = "0";
		} else {
			raio = format.format(((float) numberInto / queryTotal) * 100);// 参考率
		}

		Integer numberIntoNot = queryTotal - numberInto;// 需要补考人数
		// Integer raio =(numberInto/queryTotal)*100;
		map.put("level", "优秀");
		int total1 = xlglExamMainAnswerService.queryTotal(map);// 优秀人数
		map.put("level", "优良");
		int total2 = xlglExamMainAnswerService.queryTotal(map);// 优良人数
		map.put("level", "及格");
		int total3 = xlglExamMainAnswerService.queryTotal(map);// 及格人数
		String total1Raio;
		if (numberInto == 0 || total1 == 0) {
			total1Raio = "0";
		} else {
			total1Raio = format.format(((float) total1 / numberInto) * 100);// 优秀率
		}
		String total2Raio;
		if (numberInto == 0 || (total2+total1) == 0) {
			total2Raio = "0";
		} else {
			total2Raio = format.format((((float) total2 +(float) total1)/ numberInto) * 100);// 优良率
		}

		String total3Raio;
		if (numberInto == 0 || (total3+total2+total1) == 0) {
			total3Raio = "0";
		} else {
			total3Raio = format.format((((float) total3+(float) total2 +(float) total1) / numberInto) * 100);// 及格率
		}
		/*
		 * Integer total1Raio = (total1/numberInto) *100; Integer total2Raio =
		 * (total2/numberInto) *100; Integer total2Raio = (total3/numberInto) *100;
		 */
		jsonObject.put("raioAll", Float.valueOf(raio));
		jsonObject.put("peopleNum", numberInto);
		jsonObject.put("fillUpNum", numberIntoNot);
		jsonObject.put("excellent", Float.valueOf(total1Raio));
		jsonObject.put("fine", Float.valueOf(total2Raio));
		jsonObject.put("pass", Float.valueOf(total3Raio));
		XlglExamExamine queryObject = xlglExamExamineService.queryObject(examineId);
		jsonObject.put("examine", queryObject);
		Response.json(jsonObject);
	}

	/**
	 * 原考题四项题型比例
	 * 
	 * @param examineId
	 *            试卷id
	 */
	@ResponseBody
	@RequestMapping("/topicTypeCount")
	public void topicTypeCount(String examineId) {
		JSONObject jsonObject = new JSONObject();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("examineId", examineId);
		map.put("makeUpStatus", "0");
		List<XlglExamExaminetopicDto> listCount = xlglExamExaminetopicService.findCountBySubjectId(map);
		Integer originalTypeCount = 0;
		Integer originalnumberAll = 0;
		for (XlglExamExaminetopicDto xlglExamExaminetopicDto : listCount) {
			originalTypeCount += xlglExamExaminetopicDto.getTypeCount();
			originalnumberAll += xlglExamExaminetopicDto.getNumberAll();
		}
		List<XlglExamExamineMakeup> queryList = xlglExamExamineMakeupService.queryList(map);
		if (queryList.size() > 0) {
			XlglExamExamineMakeup xlglExamExamineMakeup = queryList.get(0);
			map.put("makeUpStatus", "1");
			map.put("makeUpId", xlglExamExamineMakeup.getId());
			List<XlglExamExaminetopicDto> findCountBySubjectId = xlglExamExaminetopicService.findCountBySubjectId(map);
			jsonObject.put("makeUpTopic", findCountBySubjectId);
		} else {
			jsonObject.put("makeUpTopic", "0");
		}
		jsonObject.put("originalTopic", listCount);
		Response.json(jsonObject);
	}

	/**
	 * 考试名称重复校验
	 */
	@ResponseBody
	@RequestMapping("/verify")
	public void verify(String examineName) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("examineName", examineName);
		List<XlglExamExamine> list = xlglExamExamineService.queryVerifyList(map);
		boolean status = true; // 考试名称无重复
		if (list.size() > 0) {
			status = false; // 考试名称重复
		}
		Response.json("status", status);
	}

	/**
	 * 再来一次，随机生成题目
	 * 
	 * @param IssueStatus
	 *            0：保存，1：发布
	 * @param status
	 *            状态 0：考试，1：练习
	 * @param typeAndNum
	 *            题类型，题数量，题分数
	 * @param lianxiType
	 *            0：模拟练习，1：自主练习
	 */
	@ResponseBody
	@RequestMapping("/randomExam")
	public void randomExam(XlglExamExamine xlglExamExamine, String[] typeAndNum, String status) {
		try {
			JSONObject jsonObject = new JSONObject();
			String userId = CurrentUser.getUserId();
			Date date = new Date();
			xlglExamExamine.setStatus(status);
			XlglExamExamine xlglExamExamineInfo = xlglExamExamineService.queryObject(xlglExamExamine.getId());
			if (StringUtils.isNotBlank(xlglExamExamine.getId())) {// 修改
				xlglExamExamine.setUpdateUser(userId);
				xlglExamExamine.setUpdateDate(date);
				xlglExamExamine.setMakeupStatus("0");
				xlglExamExamineService.update(xlglExamExamine);
				if (typeAndNum.length > 0) {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("examineId", xlglExamExamine.getId());
					map.put("makeUpStatus", "0");
					xlglExamExaminetopicService.deleteByExamineId(map);
				}
			}
			for (int i = 0; i < typeAndNum.length; i++) {
				Map<String, Object> map = new HashMap<String, Object>();
				String[] split2 = typeAndNum[i].split("-");
				map.put("subjectId", xlglExamExamineInfo.getExamineSubjectId());
				map.put("topicType", split2[0]);
				map.put("topicNumber", split2[1]);
				map.put("fractionalNumber", split2[2]);
				List<XlglExamExaminetopic> randomExtract = xlglExamExaminetopicService.randomExtract(map,
						xlglExamExamine.getId(), null);
				if (randomExtract.size() > 0) {
					List<XlglExamExaminetopic> list = new ArrayList<XlglExamExaminetopic>();
					for (int j = 0; j < randomExtract.size(); j++) {
						list.add(randomExtract.get(j));
						if (list.size() == 10) {
							xlglExamExaminetopicService.saveBatch(list);
							list = new ArrayList<XlglExamExaminetopic>();
						} else if (randomExtract.size() - 1 - j == 0) {
							xlglExamExaminetopicService.saveBatch(list);
						}
					}

				}
			}
			jsonObject.put("code", "0");
			jsonObject.put("msg", "success");
			Response.json(jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
			Response.error();
		}
	}
	/**
	 * 局单位的组织的参考率、参考人数、待考人数、优秀率
	 * */
	@ResponseBody
	@RequestMapping("/examAnalyse")
	public void examAnalyse(String examineId,String organId) {
		JSONObject jsonObject = new JSONObject();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("parentId", "root");
		List<BaseAppOrgan> queryList = baseAppOrganService.queryList(map);
		DecimalFormat format = new DecimalFormat("0.00");
		ArrayList<ExamMainAnswerAnalyseDto> list = new ArrayList<ExamMainAnswerAnalyseDto>();
		for (BaseAppOrgan baseAppOrgan : queryList) {
			Integer fillUpNum = 0; //待考人数
			Integer peopleNum = 0; //参考人数
			Integer total = 0; //优秀人数
			String excellent = ""; //优秀率
			String raioAll = ""; //参考率
			//传参实体
			ExamMainAnswerAnalyseDto analyseDto = new ExamMainAnswerAnalyseDto();
			analyseDto.setOrganId(baseAppOrgan.getId());
			analyseDto.setOrganName(baseAppOrgan.getName());
			map.put("examId", examineId);
			map.put("status", "0");
			map.put("organId", baseAppOrgan.getId());
			List<XlglExamMainAnswer> findExamByOrganId = xlglExamMainAnswerService.findExamByOrganId(map);
			for (XlglExamMainAnswer xlglExamMainAnswer : findExamByOrganId) {
				// IsNotExam 考试状态 0:没考，1:考了
				if(xlglExamMainAnswer.getIsNotExam().equals("0")) {
					fillUpNum++;
				}else if(xlglExamMainAnswer.getIsNotExam().equals("1")) {
					if(StringUtils.isNotBlank(xlglExamMainAnswer.getLevel())
							&&xlglExamMainAnswer.getLevel().equals("优秀")) {
						total++;
					}
					peopleNum++;
				}
			}
			if (peopleNum == 0 || total == 0) {
				excellent = "0";
			} else {
				excellent = format.format(((float) total / peopleNum) * 100);// 优秀率
			}
			if (peopleNum == 0 ) {
				raioAll = "0";
			} else {
				raioAll = format.format(((float) peopleNum / findExamByOrganId.size()) * 100);// 参考率
			}
			analyseDto.setExcellent(excellent);//优秀率
			analyseDto.setFillUpNum(fillUpNum);//待考人数
			analyseDto.setRaioAll(raioAll);//参考率
			analyseDto.setPeopleNum(peopleNum);	//参考人数
			list.add(analyseDto);
		}
		if(list.size()>0) {
			jsonObject.put("code", "0");
			jsonObject.put("msg", "success");
			jsonObject.put("list", list);
		}else {
			jsonObject.put("code", "500");
			jsonObject.put("msg", "错误!无返回数据");
		}

		Response.json(jsonObject);
	}
	
}
