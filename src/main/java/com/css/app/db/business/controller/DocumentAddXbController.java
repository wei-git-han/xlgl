package com.css.app.db.business.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
import com.css.app.db.business.entity.DocXbIdea;
import com.css.app.db.business.entity.DocXbInfo;
import com.css.app.db.business.entity.ReplyExplain;
import com.css.app.db.business.entity.SubDocInfo;
import com.css.app.db.business.entity.SubDocTracking;
import com.css.app.db.business.service.DocXbIdeaService;
import com.css.app.db.business.service.DocXbInfoService;
import com.css.app.db.business.service.ReplyExplainService;
import com.css.app.db.business.service.SubDocInfoService;
import com.css.app.db.business.service.SubDocTrackingService;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.Response;
import com.css.base.utils.StringUtils;

/**
 * 支持承办人增加协办所有功能
 * 
 * @author 中软信息系统工程有限公司
 * @email
 * @date 2019-07-03 13:40:10
 */
@Controller
@RequestMapping("/app/db/addXbDeal")
public class DocumentAddXbController {
	private final Logger logger = LoggerFactory.getLogger(DocumentAddXbController.class);
	@Autowired
	private SubDocInfoService subDocInfoService;
	@Autowired
	private SubDocTrackingService subDocTrackingService;
	@Autowired
	private DocXbInfoService docXbInfoService;
	@Autowired
	private BaseAppOrganService baseAppOrganService;
	@Autowired
	private BaseAppUserService baseAppUserService;
	@Autowired
	private ReplyExplainService replyExplainService;
	@Autowired
	private DocXbIdeaService docXbIdeaService;
	/**
	 * 控制承办人详情页收集意见按钮显示
	 * @param subId
	 */
	@RequestMapping("/showCollectIdeaButton")
	public void showCollectIdeaButton(String subId) {
		/**
		 * 1、当前人为承办人，且承办人未点击转办或者送审批按钮，此时可以增加协办人
		 * 2、新一轮审批开始，局内流转记录最新一条文接收人为承办人，此时可以增加协办人
		 */
		JSONObject jsonObject = new JSONObject();
		try {
			String userId = CurrentUser.getUserId();
			SubDocInfo subDocInfo = subDocInfoService.queryObject(subId);
			SubDocTracking subDocTracking = subDocTrackingService.queryLatestRecord(subId);
			if (subDocInfo != null) {
				if (StringUtils.equals(userId, subDocInfo.getUndertaker()) && subDocTracking != null) {
					//点击承办按钮未送出
					if (StringUtils.equals(userId, subDocTracking.getReceiverId()) && StringUtils.equals("1", subDocTracking.getTrackingType())) {
						jsonObject.put("result", "success");
					//新一轮反馈
					}else if (StringUtils.equals(userId, subDocTracking.getReceiverId()) && StringUtils.equals("4", subDocTracking.getTrackingType())) {
						jsonObject.put("result", "success");
					}else {
						jsonObject.put("result", "fail");
					}
				}else {
					jsonObject.put("result", "fail");
				}
			}else {
				jsonObject.put("result", "fail");
			}
		} catch (Exception e) {
			logger.info("控制承办人详情页收集意见按钮显示异常：{}", e);
			jsonObject.put("result", "fail");
		}
		Response.json(jsonObject);
	}
	/**
	 * 添加或者编辑协办人
	 * @param userIds 协办人IDS
	 * @param infoId 文ID
	 * @param subId 分支ID
	 */
	@RequestMapping("/addOrEditXbPerson")
	@ResponseBody
	public void addOrEditXbPerson(String userIds, String infoId, String subId) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		for (String userId : userIds.split(",")) {
			map.put("undertakerId", CurrentUser.getUserId());
			map.put("receiverId", userId);
			map.put("infoId", infoId);
			map.put("subId", subId);
			List<DocXbInfo> docXbInfos = docXbInfoService.queryList(map);
			if (docXbInfos != null && docXbInfos.size() > 0) {
				Response.json("result","fail");
				return;
			}else {
				DocXbInfo docXbInfo = new DocXbInfo();
				docXbInfo.setInfoId(infoId);
				docXbInfo.setSubId(subId);
				docXbInfo.setUndertakerId(CurrentUser.getUserId());
				docXbInfo.setUndertakerName(CurrentUser.getUsername());
				docXbInfo.setDeptId(CurrentUser.getDepartmentId());
				BaseAppOrgan organ = this.queryBaseAppOrgan(CurrentUser.getDepartmentId());
				if (organ != null) {
					docXbInfo.setDeptName(organ.getName());
				}else {
					logger.info("请在部门表配置部门ID：{}的部门数据！", CurrentUser.getDepartmentId());
					return;
				}
				docXbInfo.setReceiverId(userId);
				map.clear();
				map.put("userId", userId);
				List<BaseAppUser> baseAppUsers = baseAppUserService.queryList(map);
				if (baseAppUsers != null && baseAppUsers.size() > 0 ) {
					BaseAppUser baseAppUser = baseAppUsers.get(0);
					docXbInfo.setReceiverName(baseAppUser.getTruename());
					String organId = baseAppUser.getOrganid();
					docXbInfo.setReceiverDeptId(organId);
					organ = this.queryBaseAppOrgan(organId);
					if (organ != null) {
						docXbInfo.setReceiverDeptId(organ.getName());
					}else {
						logger.info("请在部门表配置部门ID：{}的部门数据！", organId);
						return;
					}
				}else {
					logger.info("在人员表查不到人员ID：{}的数据！", userId);
					return;
				}
				docXbInfo.setCreatedTime(new Date());
				docXbInfoService.save(docXbInfo);
				Response.json("result","success");
			}
		}
	}
	/**
	 * 根据部门ID查询部门信息
	 * @param orgId
	 * @return
	 */
	private BaseAppOrgan queryBaseAppOrgan(String orgId) {
		return baseAppOrganService.queryObject(CurrentUser.getDepartmentId());
	}
	@ResponseBody
	@RequestMapping("/commitIdea")
	public void collectIdea(String infoId, String subId, String feedBackIdea) {
		/**
		 * 分两种情况
		 * 1、承办人自己提交意见
		 * 2、协办人提交意见
		 */
		//如果当前提交意见是承办人自己，那么相当于自己做协办人，DocXbInfo插入数据
		JSONObject jsonObject = new JSONObject();
//		String userId = CurrentUser.getUserId();
//		SubDocInfo subDocInfo = subDocInfoService.queryObject(subId);
		/**
		 * 分两种情况  文必须在承办人那里协办人才能提意见，此时文的状态必须是办理中  这里按钮已经控制
		 * 1、承办人点击承办，文未送审批，文还在我这 没有反馈记录
		 * 2、新一轮反馈开始，文又到我这了  反馈记录最新一条showFlag = "1"
		 */
//		if (subDocInfo != null && StringUtils.equals(userId, subDocInfo.getUndertaker())) {
//			if (StringUtils.isNotBlank(feedBackIdea)) {
		DocXbIdea docXbIdea = this.organizeDocXbIdea(feedBackIdea, infoId, subId);
		this.productGroupId(docXbIdea, infoId, subId);
		docXbIdeaService.save(docXbIdea);
//			}
//		}else {
//			DocXbIdea docXbIdea = this.organizeDocXbIdea(feedBackIdea, infoId, subId);
//			this.productGroupId(docXbIdea, infoId, subId);
//			docXbIdeaService.save(docXbIdea);
//		}
		jsonObject.put("result", "success");
		Response.json(jsonObject);
	}
	/**
	 * 统一组织意见对象数据
	 * @param feedBackIdea
	 * @param infoId
	 * @param subId
	 * @return
	 */
	private DocXbIdea organizeDocXbIdea(String feedBackIdea, String infoId, String subId) {
		Date date = new Date();
		DocXbIdea docXbIdea = new DocXbIdea();
		docXbIdea.setInfoId(infoId);
		docXbIdea.setSubId(subId);
		docXbIdea.setUserId(CurrentUser.getUserId());
		docXbIdea.setUserName(CurrentUser.getUsername());
		docXbIdea.setFeedBackIdea(feedBackIdea);
		docXbIdea.setCreatedTime(date);
		return docXbIdea;
	}
	/**
	 * 主办人提交意见前，看是否协办人已经提交意见；否则相反；
	 * @param infoId
	 * @param subId
	 * @return
	 */
	private DocXbIdea isCommitIdea(String infoId, String subId) {
		//查询当前协办人是否已经提交意见
		return docXbIdeaService.queryLastNewData(subId, infoId);
	}
	/**
	 * 提意见生成组ID
	 * @param docXbInfo
	 * @param infoId
	 * @param subId
	 * @param isUndertaker
	 */
	private void productGroupId(DocXbIdea docXbIdea,String infoId, String subId) {
		//主办人发起提议  生成新一轮提议组ID
		SubDocTracking subDocTracking = subDocTrackingService.queryLatestRecord(subId);
		if (subDocTracking != null) {
			//主办人登录提交意见
			if (StringUtils.equals(subDocTracking.getReceiverId(), CurrentUser.getUserId())) {
				//第一轮审批
				if (StringUtils.equals(subDocTracking.getTrackingType(), "1")) {
					this.setGroupId(docXbIdea, infoId, subId);
				}
			}else {
				List<ReplyExplain> replyExplains = replyExplainService.querySubLatestReply(infoId, subId);
				if (replyExplains != null && replyExplains.size() > 0) {
					String showFlag = replyExplains.get(0).getShowFlag();
					//新一轮审批
					if (StringUtils.equals("1", showFlag) && StringUtils.equals(subDocTracking.getTrackingType(), "4")) {
						this.setGroupId(docXbIdea, infoId, subId);
					}
				}
			}
		}
	}
	/**
	 * 设置意见组ID
	 * @param docXbIdea
	 * @param infoId
	 * @param subId
	 */
	private void setGroupId(DocXbIdea docXbIdea,String infoId, String subId) {
		DocXbIdea commitIdea = this.isCommitIdea(infoId, subId);
		if (commitIdea != null) {
			docXbIdea.setGroupId(commitIdea.getGroupId());
		}else {
			docXbIdea.setGroupId(UUID.randomUUID().toString());
		}
	}
	/**
	 * 展示意见记录(局内所有人)
	 * @param infoId
	 * @param subId
	 */
	@RequestMapping("/showIdeaRecord")
	@ResponseBody
	public void showIdeaRecord(String infoId, String subId, String ideaGroupId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("subId", subId);
		map.put("infoId", infoId);
		map.put("ideaGroupId", ideaGroupId);
		List<DocXbIdea> docXbIdeas = docXbIdeaService.queryList(map);
		if (docXbIdeas != null && docXbIdeas.size() > 0 ) {
			Response.json(docXbIdeas);
		}
	}
}
