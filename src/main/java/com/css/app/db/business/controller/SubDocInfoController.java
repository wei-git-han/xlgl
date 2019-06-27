package com.css.app.db.business.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.css.addbase.apporgan.entity.BaseAppOrgan;
import com.css.addbase.apporgan.entity.BaseAppUser;
import com.css.addbase.apporgan.service.BaseAppOrganService;
import com.css.addbase.apporgan.service.BaseAppUserService;
import com.css.addbase.msg.MSGTipDefined;
import com.css.addbase.msg.MsgTipUtil;
import com.css.addbase.msg.entity.MsgTip;
import com.css.addbase.msg.service.MsgTipService;
import com.css.app.db.business.entity.DocumentBjjl;
import com.css.app.db.business.entity.DocumentCbjl;
import com.css.app.db.business.entity.DocumentInfo;
import com.css.app.db.business.entity.DocumentSzps;
import com.css.app.db.business.entity.ReplyExplain;
import com.css.app.db.business.entity.SubDocInfo;
import com.css.app.db.business.entity.SubDocTracking;
import com.css.app.db.business.service.ApprovalOpinionService;
import com.css.app.db.business.service.DocumentBjjlService;
import com.css.app.db.business.service.DocumentCbjlService;
import com.css.app.db.business.service.DocumentInfoService;
import com.css.app.db.business.service.DocumentReadService;
import com.css.app.db.business.service.DocumentSzpsService;
import com.css.app.db.business.service.ReplyExplainService;
import com.css.app.db.business.service.SubDocInfoService;
import com.css.app.db.business.service.SubDocTrackingService;
import com.css.app.db.config.entity.RoleSet;
import com.css.app.db.config.service.RoleSetService;
import com.css.app.db.util.DbDefined;
import com.css.app.db.util.DbDocStatusDefined;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.GwPageUtils;
import com.css.base.utils.Response;
import com.css.base.utils.StringUtils;
import com.github.pagehelper.PageHelper;


/**
 * 各子分支主记录表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-18 16:40:43
 */
@Controller
@RequestMapping("/app/db/subdocinfo")
public class SubDocInfoController {
	private final Logger logger = LoggerFactory.getLogger(SubDocInfoController.class);
	@Autowired
	private SubDocInfoService subDocInfoService;
	@Autowired
	private BaseAppUserService baseAppUserService;
	@Autowired
	private RoleSetService roleSetService;
	@Autowired
	private SubDocTrackingService subDocTrackingService;
	@Autowired
	private DocumentInfoService documentInfoService;
	@Autowired
	private DocumentBjjlService documentBjjlService;
	@Autowired
	private BaseAppOrganService baseAppOrganService;
	@Autowired
	private ReplyExplainService replyExplainService;
	@Autowired
	private ApprovalOpinionService approvalOpinionService;
	@Autowired
	private DocumentCbjlService documentCbjlService;
	@Autowired
	private DocumentReadService documentReadService;
	@Autowired
	private DocumentSzpsService documentSzpsService;
	@Autowired
	private MsgTipService msgService;
	@Autowired
	private MsgTipUtil msgUtil;
	@Value("${csse.dccb.appId}")
	private  String appId;	
	@Value("${csse.dccb.appSecret}")
	private  String clientSecret;
	/**
	 * 局内待办列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	public void list(Integer page, Integer pagesize,String search, String docStatus){
		Map<String, Object> map = new HashMap<>();
		String loginUserId=CurrentUser.getUserId();
		String orgId = baseAppUserService.getBareauByUserId(loginUserId);
		if(StringUtils.isNotBlank(orgId)) {
			map.put("orgId", orgId);
		}
		if(StringUtils.isNotBlank(search)) {
			map.put("search", search);
		}
		if(StringUtils.isNotBlank(docStatus)) {
			if(StringUtils.equals("cui", docStatus)) {
				map.put("cui", docStatus);
			}else {
				map.put("docStatus", docStatus);
			}
		}
		//查询列表数据
		PageHelper.startPage(page, pagesize);
		List<SubDocInfo> subDocInfoList = subDocInfoService.queryList(map);
		for (SubDocInfo subDocInfo : subDocInfoList) {
			//是否已读---暂时不显示改为本局最新反馈，但不能删，随时会换回来
			/*Map<String, Object> readMap = new HashMap<>();
			readMap.put("userId", loginUserId);
			readMap.put("infoId", subDocInfo.getInfoId());
			List<DocumentRead> list = documentReadService.queryList(readMap);
			if(list.size()==0 && StringUtils.isNotBlank(subDocInfo.getLatestReply())) {
				subDocInfo.setUpdateFlag("1");
			}*/
			//首长批示
			Map<String, Object> szpsMap = new HashMap<>();
			szpsMap.put("infoId", subDocInfo.getInfoId());
			List<DocumentSzps> szpsList = documentSzpsService.queryList(szpsMap);
			subDocInfo.setSzpslist(szpsList);
			//本局最新反馈
			subDocInfo.setLatestReply("");
			Map<String, Object> replyMap = new HashMap<>();
			replyMap.put("subId", subDocInfo.getId());
			replyMap.put("infoId", subDocInfo.getInfoId());
			List<ReplyExplain> queryList = replyExplainService.queryList(replyMap);
			if(queryList!=null && queryList.size()>0) {
				subDocInfo.setLatestReply(queryList.get(0).getReplyContent());
			}
			//是否批示超过3个月
			this.isOverTreeMonth(subDocInfo.getLeaderTime(), subDocInfo);
		}
		GwPageUtils pageUtil = new GwPageUtils(subDocInfoList);
		Response.json(pageUtil);
	}
	
	/**
	 * 局内待办数量统计
	 * @param search 搜索
	 */
	@ResponseBody
	@RequestMapping("/numsList")
	public void numsList(String search){
		Map<String, Object> map = new HashMap<>();
		String loginUserId=CurrentUser.getUserId();
		String orgId = baseAppUserService.getBareauByUserId(loginUserId);
		if(StringUtils.isNotBlank(orgId)) {
			map.put("orgId", orgId);
		}
		if(StringUtils.isNotBlank(search)) {
			map.put("search", search);
		}
		int[] arr= {0,0,0,0,0,0,0,0,0};
		List<SubDocInfo> subDocInfoList = subDocInfoService.queryList(map);
		if(subDocInfoList != null && subDocInfoList.size()>0) {
			arr[0]=subDocInfoList.size();
			for (SubDocInfo subDocInfo : subDocInfoList) {
				Integer docStatus = subDocInfo.getDocStatus();
				//待转办
				if(1==docStatus) {
					arr[1]+=1;
				}
				//待落实
				if(5==docStatus) {
					arr[2]+=1;
				}
				//办理中
				if(9==docStatus) {
					arr[3]+=1;
				}
				//待审批
				if(7==docStatus) {
					arr[4]+=1;
				}
				//退回修改
				if(3==docStatus) {
					arr[5]+=1;
				}
				//建议办结
				if(10==docStatus) {
					arr[6]+=1;
				}
				//常态落实
				if(11==docStatus) {
					arr[7]+=1;
				}
				//催办
				if(StringUtils.equals("1", subDocInfo.getCuibanFlag())) {
					arr[8]+=1;
				}
			}
		}
		Response.json(arr);
	}
	
	/**
	 * 个人待办列表
	 * @param page
	 * @param pagesize
	 * @param search
	 * @param docStatus
	 */
	@ResponseBody
	@RequestMapping("/personList")
	public void personList(Integer page, Integer pagesize,String search, String docStatus){
		Map<String, Object> map = new HashMap<>();
		String loginUserId=CurrentUser.getUserId();
		if(StringUtils.isNotBlank(loginUserId)) {
			map.put("loginUserId", loginUserId);
		}
		if(StringUtils.isNotBlank(search)) {
			map.put("search", search);
		}
		if(StringUtils.isNotBlank(docStatus)) {
			if(StringUtils.equals("cui", docStatus)) {
				map.put("cui", docStatus);
			}else {
				map.put("docStatus", docStatus);
			}
		}
		//查询列表数据
		PageHelper.startPage(page, pagesize);
		List<SubDocInfo> subDocInfoList = subDocInfoService.queryPersonList(map);
		for (SubDocInfo subDocInfo : subDocInfoList) {
			/*是否已读---暂时去掉改为本局最新反馈，不能删，随时会换回来
			Map<String, Object> readMap = new HashMap<>();
			readMap.put("userId", loginUserId);
			readMap.put("infoId", subDocInfo.getInfoId());
			List<DocumentRead> list = documentReadService.queryList(readMap);
			if(list.size()==0 && StringUtils.isNotBlank(subDocInfo.getLatestReply())) {
				subDocInfo.setUpdateFlag("1");
			}*/
			//首长批示
			Map<String, Object> szpsMap = new HashMap<>();
			szpsMap.put("infoId", subDocInfo.getInfoId());
			List<DocumentSzps> szpsList = documentSzpsService.queryList(szpsMap);
			subDocInfo.setSzpslist(szpsList);
			//是否批示超过3个月
			this.isOverTreeMonth(subDocInfo.getLeaderTime(), subDocInfo);
			//是否显示撤回按钮
			this.isShowWithdrawButton(subDocInfo);
			//本局最新反馈
			subDocInfo.setLatestReply("");
			Map<String, Object> replyMap = new HashMap<>();
			replyMap.put("subId", subDocInfo.getId());
			replyMap.put("infoId", subDocInfo.getInfoId());
			List<ReplyExplain> queryList = replyExplainService.queryList(replyMap);
			if(queryList!=null && queryList.size()>0) {
				subDocInfo.setLatestReply(queryList.get(0).getReplyContent());
			}
		}
		GwPageUtils pageUtil = new GwPageUtils(subDocInfoList);
		Response.json(pageUtil);
	}
	/**
	 * 计算首长批示时间到现在是否超过三月；
	 * @param leaderTime
	 * @param subDocInfo
	 */
	private void isOverTreeMonth(String leaderTime, SubDocInfo subDocInfo) {
		// 2019年05月08日
		if (StringUtils.isNotBlank(leaderTime)) {
			LocalDate currdate = LocalDate.now();
			LocalDate leaderDate = LocalDate.parse(leaderTime, DateTimeFormatter.ofPattern("yyyy年MM月dd日"));
			//如果该文没有办结且超过批示时间三个月的，显示超期提示；
			if (subDocInfo.getDocStatus() < 12) {
				if ((int)ChronoUnit.YEARS.between(leaderDate, currdate) == 0) {
					if ((int)ChronoUnit.MONTHS.between(leaderDate, currdate) == 3) {
						//提取天数
						if (currdate.getDayOfMonth() > leaderDate.getDayOfMonth()) {
							subDocInfo.setIsOverTreeMonth(1);
						}
					}else if ((int)ChronoUnit.MONTHS.between(leaderDate, currdate) > 3) {
						subDocInfo.setIsOverTreeMonth(1);
					}
				}else if ((int)ChronoUnit.YEARS.between(leaderDate, currdate) > 0){
					subDocInfo.setIsOverTreeMonth(1);
				}
			}
		}
	}

	/**
	 * 个人待办列表中是否显示撤回按钮
	 * @param subDocInfo
	 */
	private void isShowWithdrawButton(SubDocInfo subDocInfo) {
		String userId = CurrentUser.getUserId();
		String id = subDocInfo.getId();
		//查询局内流转记录表
		SubDocTracking subDocTracking = subDocTrackingService.queryLatestRecord(id);
		if (subDocTracking != null) {
			if (StringUtils.equals(userId, subDocTracking.getSenderId()) && !StringUtils.equals(userId, subDocTracking.getReceiverId())) {
				//如果状态为待落实  则此文承办人未送出，撤回删除转办记录表和局内流转表的最新一条
				if (StringUtils.equals(subDocTracking.getTrackingType(), "1") && StringUtils.isBlank(subDocInfo.getUndertaker())) {
					//撤回按钮显示标志
					subDocInfo.setWithdrawFlag(1);
				}
				//如果状态为待审批  则此文承办人已发送审批，但是还在审批中，则支持撤回；
				if (StringUtils.equals(subDocTracking.getTrackingType(), "2") && subDocInfo.getDocStatus() < 10) {
					//撤回按钮显示标志
					subDocInfo.setWithdrawFlag(1);
					//审批撤回弹窗提示标志
					subDocInfo.setApproveWithdrawFlag(1);
				}
			}
		}
	}

	/**
	 * 个人待办数据统计
	 * @param search 搜索
	 */
	@ResponseBody
	@RequestMapping("/presonNumsList")
	public void presonNumsList(String search){
		Map<String, Object> map = new HashMap<>();
		String loginUserId=CurrentUser.getUserId();
		if(StringUtils.isNotBlank(loginUserId)) {
			map.put("loginUserId", loginUserId);
		}
		if(StringUtils.isNotBlank(search)) {
			map.put("search", search);
		}
		int[] arr= {0,0,0,0,0,0,0,0};
		List<SubDocInfo> subDocInfoList = subDocInfoService.queryPersonList(map);
		if(subDocInfoList != null && subDocInfoList.size()>0) {
			arr[0]=subDocInfoList.size();
			for (SubDocInfo subDocInfo : subDocInfoList) {
				Integer docStatus = subDocInfo.getDocStatus();
				//待落实
				if(5==docStatus) {
					arr[1]+=1;
				}
				//办理中
				if(9==docStatus) {
					arr[2]+=1;
				}
				//待审批
				if(7==docStatus) {
					arr[3]+=1;
				}
				//退回修改
				if(3==docStatus) {
					arr[4]+=1;
				}
				//建议办结
				if(10==docStatus) {
					arr[5]+=1;
				}
				//常态落实
				if(11==docStatus) {
					arr[6]+=1;
				}
				//催办
				if(StringUtils.equals("1", subDocInfo.getCuibanFlag())) {
					arr[7]+=1;
				}
			}
		}
		Response.json(arr);
	}
	
	/**
	 * 按钮显示参数
	 * @param subId 分支主id
	 */
	@ResponseBody
	@RequestMapping("/buttonParam")
	public void buttonParam( String subId){
		Integer docStatus=0;//1:待转办；3：退回修改；5：待落实；7：待审批；9：办理中；11：建议办结;
		String roleType = DbDefined.ROLE_6;//角色标识（1：首长；2：首长秘书；3：局长；4：局秘书；5：处长；6：参谋;）
		boolean isCheckUser=false;//是否是当前办理人
		boolean isUndertaken=false;//是否已承办
		boolean isUndertaker=false;//是否承办人
		String loginUserId = CurrentUser.getUserId();
		//当前登录人的角色
		Map<String, Object> roleMap = new HashMap<>();
		roleMap.put("userId", loginUserId);
		List<RoleSet> roleList = roleSetService.queryList(roleMap);
		if(roleList != null && roleList.size()>0) {
			roleType = roleList.get(0).getRoleFlag();
		}
		/*//当前登录人的管理员类型
		Map<String, Object> adminMap = new HashMap<>();
		adminMap.put("userId", loginUserId);
		List<AdminSet> adminList = adminSetService.queryList(adminMap);
		if(adminList != null && adminList.size()>0) {
			adminType = adminList.get(0).getAdminType();
		}*/
		if(StringUtils.isNotBlank(subId)){
			//获取文件状态
			SubDocInfo subDocInfo = subDocInfoService.queryObject(subId);
			if(subDocInfo != null) {
				docStatus = subDocInfo.getDocStatus();
				if(StringUtils.isNotBlank(subDocInfo.getUndertaker())) {
					isUndertaken=true;
					if(StringUtils.equals(loginUserId, subDocInfo.getUndertaker())) {
						isUndertaker=true;
					}
				}
				//当前审核人
				SubDocTracking latestRecord = subDocTrackingService.queryLatestRecord(subId);
				if(latestRecord != null) {
					String recordId=latestRecord.getReceiverId();
					if(StringUtils.equals(loginUserId,recordId )) {
						isCheckUser=true;
					}
				}
				
			}
		}
		JSONObject json=new JSONObject();
		json.put("docStatus", docStatus);
		json.put("roleType", roleType);
		json.put("isCheckUser", isCheckUser);
		json.put("isUndertaken", isUndertaken);
		json.put("isUndertaker", isUndertaker);
		Response.json(json);
	}
	
	/**
	 * 承办操作：1.记录承办人--标识文件已经承办、也可用于【退回修改】按钮判断；2：改变文件状态为办理中
	 * @param subId 分支文件主id
	 */
	@ResponseBody
	@RequestMapping("/undertakeOperation")
	public void undertakeOperation(String subId){
		//获取文件
		SubDocInfo subDocInfo = subDocInfoService.queryObject(subId);
		subDocInfo.setUndertaker(CurrentUser.getUserId());
		subDocInfo.setUndertakerName(CurrentUser.getUsername());
		BaseAppUser appUser = baseAppUserService.queryObject(CurrentUser.getUserId());
		if(appUser !=null) {
			subDocInfo.setUndertakerPhone(appUser.getTelephone());
		}
		subDocInfo.setDocStatus(DbDocStatusDefined.BAN_LI_ZHONG);
		subDocInfoService.update(subDocInfo);
		Response.json("result", "success");
	}
	
	/**
	 * 办结操作：有一个分支局状态为非办结状态，主文件则不标识为办结，其他分支局办结的标识均为建议办结。各分支局全部办结，则主文件为办结状态
	 * @param infoId 主文件id
	 * @param subId 分支主id
	 */
	public void banJieOperation(String infoId,String subId){
		SubDocInfo subInfo = subDocInfoService.queryObject(subId);
		DocumentBjjl bjjl=new DocumentBjjl();
		//取除本分支机构外的其他机构的最小状态值
		int minDocStatus = subDocInfoService.queryMinDocStatus(infoId,subInfo.getSubDeptId());
		int maxDocStatus = subDocInfoService.queryMaxDocStatus(infoId, subInfo.getSubDeptId());
		//说明只有当前一个局
		if(0==minDocStatus && 0==maxDocStatus) {
			//主文件标示为办结
			DocumentInfo info = documentInfoService.queryObject(infoId);
			info.setSzReadIds("");
			info.setStatus(2);
			documentInfoService.update(info);
			//当前分支文件变为办结
			//subDocInfoService.updateDocStatus(DbDocStatusDefined.BAN_JIE, new Date() , infoId);
			subInfo.setDocStatus(DbDocStatusDefined.BAN_JIE);
			bjjl.setContent("办结");
		}else {
			//如果最小状态值小于建议办结的状态，则将本分支局状态标示为建议办结
			if(minDocStatus< DbDocStatusDefined.JIAN_YI_BAN_JIE) {
				subInfo.setDocStatus(DbDocStatusDefined.JIAN_YI_BAN_JIE);
				bjjl.setContent("建议办结");
			}else {//如果最小状态值不小于建议办结的状态，且最大值小于建议落实，说明本分支机构状态全部为建议办结，主文件也标示为办结
				if(maxDocStatus<DbDocStatusDefined.JIAN_YI_LUO_SHI) {
					//主文件标示为办结
					DocumentInfo info = documentInfoService.queryObject(infoId);
					info.setSzReadIds("");
					info.setStatus(2);
					documentInfoService.update(info);
					//当前分支文件变为办结
					//subDocInfoService.updateDocStatus(DbDocStatusDefined.BAN_JIE, new Date() , infoId);
					subInfo.setDocStatus(DbDocStatusDefined.BAN_JIE);
					bjjl.setContent("系统自动办结");
				}
				//如果最小状态值不小于建议办结的状态，且最大值等于建议落实，说明主文件分支机构有常态落实，主文件也标示为常态落实
				if(maxDocStatus==DbDocStatusDefined.JIAN_YI_LUO_SHI) {
					//主文件状态变为常态落实
					DocumentInfo info = documentInfoService.queryObject(infoId);
					info.setSzReadIds("");
					info.setStatus(3);
					documentInfoService.update(info);
					//当前分支文件变为办结
					//subDocInfoService.updateDocStatus(DbDocStatusDefined.BAN_JIE, new Date() , infoId);
					subInfo.setDocStatus(DbDocStatusDefined.BAN_JIE);
					bjjl.setContent("系统自动常态落实");
				}
			}
		}
		subInfo.setUpdateTime(new Date());
		subDocInfoService.update(subInfo);
		//添加办结记录
		bjjl.setInfoId(infoId);
		bjjl.setSubId(subId);
		bjjl.setSubDeptName(subInfo.getSubDeptName());
		documentBjjlService.save(bjjl);
	}
	/**
	 * 常态落实操作：所有分支局必须都处在建议办结或建议落实的状态下，且至少有一个为常态落实
	 * @param infoId 主文件id
	 * @param subId 分支主id
	 */
	public void luoShiOperation(String infoId,String subId){
		SubDocInfo subInfo = subDocInfoService.queryObject(subId);
		int minDocStatus = subDocInfoService.queryMinDocStatus(infoId,subInfo.getSubDeptId());
		int maxDocStatus = subDocInfoService.queryMaxDocStatus(infoId, subInfo.getSubDeptId());
		DocumentBjjl bjjl=new DocumentBjjl();
		//说明只有当前一个局
		if(0==minDocStatus && 0==maxDocStatus) {
			//主文件状态变为常态落实
			DocumentInfo info = documentInfoService.queryObject(infoId);
			info.setSzReadIds("");
			info.setStatus(3);
			documentInfoService.update(info);
			subInfo.setDocStatus(DbDocStatusDefined.CHANG_TAI_LUO_SHI);
			bjjl.setContent("常态落实");
		}else {
			//如果最小状态值小于建议办结的状态，则将本分支局状态标示为建议落实
			if(minDocStatus< DbDocStatusDefined.JIAN_YI_BAN_JIE) {
				subInfo.setDocStatus(DbDocStatusDefined.JIAN_YI_LUO_SHI);
				bjjl.setContent("建议常态落实");
			}else {//如果最小状态值不小于建议办结的状态，且最大值大于等于建议办结，说明本分支机构至少有一个常态落实
				if(maxDocStatus >= DbDocStatusDefined.JIAN_YI_BAN_JIE) {
					//主文件状态变为常态落实
					DocumentInfo info = documentInfoService.queryObject(infoId);
					info.setSzReadIds("");
					info.setStatus(3);
					documentInfoService.update(info);
					//各分支文件变为常态落实
					//subDocInfoService.updateDocStatus(DbDocStatusDefined.CHANG_TAI_LUO_SHI, new Date() , infoId);
					subInfo.setDocStatus(DbDocStatusDefined.CHANG_TAI_LUO_SHI);
					bjjl.setContent("系统自动常态落实");
				}
			}
		}
		subInfo.setUpdateTime(new Date());
		subDocInfoService.update(subInfo);
		//办结落实记录
		bjjl.setInfoId(infoId);
		bjjl.setSubId(subId);
		bjjl.setSubDeptName(subInfo.getSubDeptName());
		documentBjjlService.save(bjjl);
	}
	
	/**
	 * 承办人送审批
	 * @param subId 分支主id
	 * @param userName 接收人
	 * @param userId 接收人id
	 */
	@ResponseBody
	@RequestMapping("/submitOperation")
	public void submitOperation(String infoId,String subId,String userName,String userId,String dbStatus){
		//流转到下一个人并将临时反馈变为发布
		this.submitRelation(subId, userName, userId,"2",dbStatus);
		//分支文件保存最新更新时间及选择状态
		SubDocInfo subDocInfo = subDocInfoService.queryObject(subId);
		if(subDocInfo != null) {
			subDocInfo.setChooseStatus(dbStatus);
			subDocInfo.setDocStatus(DbDocStatusDefined.DAI_SHEN_PI);
			subDocInfo.setUpdateTime(new Date());
			subDocInfoService.update(subDocInfo);
		}
		// 发送消息提醒
		MsgTip msg = msgService.queryObject(MSGTipDefined.DCCB_SONGSHEN_MSG_TITLE);
		if (msg != null) {
			String msgUrl = msg.getMsgRedirect()+"&fileId="+infoId+"&subId="+subId;
			if(StringUtils.isNotBlank(userId)){
				msgUtil.sendMsg(msg.getMsgTitle(), msg.getMsgContent(), msgUrl, userId, appId,clientSecret, msg.getGroupName(), msg.getGroupRedirect(), "","true");
			}				
		}
		Response.json("result", "success");
	}
	
	/**
	 * 批量送审批（含保存意见）
	 * @param subId 分支主id
	 * @param userName 接收人
	 * @param userId 接收人id
	 * @param replyContent 意见内容
	 */
	@ResponseBody
	@RequestMapping(value = "/batchSendOperation")
	public void batchSendOperation(String subIds,String replyContent,String userName,String userId){
		String currUserId = CurrentUser.getUserId();
		logger.info("批量审批传入subIds：{},replyContent：{} ", subIds, replyContent);
		logger.info("批量审批传入userName：{},userId：{} ", userName, userId);
		JSONObject jsonObject = new JSONObject();
//		int count = 0;
		if (StringUtils.isNotBlank(subIds)) {
			for (String subId : subIds.split(",")) {
				try {
					if(StringUtils.isNotBlank(subId)) {
						SubDocInfo subDocInfo = subDocInfoService.queryObject(subId);
						if (this.isUndertaker(subDocInfo)) {
//							count++;
							//如果当前审批文属于承办人送审，则拒绝；
							continue;
						}
						//查詢局內文流转记录最新一笔-判断当前文是否需要本人审批，否则拒绝掉
						SubDocTracking subDocTracking = subDocTrackingService.queryLatestRecord(subId);
						if (StringUtils.equals(currUserId, subDocTracking.getReceiverId())) {
							this.sendApprovalUnifiedDeal(subId,userName, userId, replyContent, subDocInfo.getInfoId());
						}else {
							logger.info("当前文的局ID：{}，由{}正在审批中。", subId, subDocTracking.getReceiverName());
							continue;
						}
					}else {
						logger.info("批量送审批，记录审批意见：subId：{}", subId);
						continue;
					}
				} catch (Exception e) {
					logger.info("批量送审批，记录审批意见：subId：{}，处理异常，异常简述：{}", subId, e);
					continue;
				}
			}
		}else {
			logger.info("批量审批传入subIds：{}", subIds);
			jsonObject.put("result", "fail");
		}
		jsonObject.put("result", "success");
//		jsonObject.put("count", count);
		Response.json(jsonObject);
	}
	/**
	 * 判断当前用户是否为该文的承办人
	 * @param subDocInfo
	 * @return
	 */
	private boolean isUndertaker(SubDocInfo subDocInfo) {
		return StringUtils.equals(CurrentUser.getUserId(), subDocInfo.getUndertaker());
	}

	/**
	 * 送审批（含保存意见）
	 * @param subId 分支主id
	 * @param userName 接收人
	 * @param userId 接收人id
	 * @param replyContent 意见内容
	 */
	@ResponseBody
	@RequestMapping("/sendOperation")
	public void sendOperation(String infoId,String subId,String userName,String userId,String replyContent){
		this.sendApprovalUnifiedDeal(subId,userName, userId, replyContent, infoId);
		Response.json("result", "success");
	}
	/**
	 * 送审批（含保存意见）統一處理方法
	 * @param subId 分支主id
	 * @param userName 接收人
	 * @param userId 接收人id
	 * @param replyContent 意见内容
	 * @param infoId 文ID
	 */
	private void sendApprovalUnifiedDeal(String subId, String userName, String userId, String replyContent, String infoId) {
		//流转到下一个人并将临时反馈变为发布
		this.submitRelation(subId, userName, userId,"2",null);
		//保存审批意见
		approvalOpinionService.saveOpinion(subId, replyContent, "1",null);
		//保存最新更新时间
		SubDocInfo subDocInfo = subDocInfoService.queryObject(subId);
		if(subDocInfo != null) {
			subDocInfo.setDocStatus(DbDocStatusDefined.DAI_SHEN_PI);
			subDocInfo.setUpdateTime(new Date());
			subDocInfoService.update(subDocInfo);
		}
		// 发送消息提醒
		MsgTip msg = msgService.queryObject(MSGTipDefined.DCCB_SONGSHEN_MSG_TITLE);
		if (msg != null) {
			String msgUrl = msg.getMsgRedirect()+"&fileId="+infoId+"&subId="+subId;
			if(StringUtils.isNotBlank(userId)){
			msgUtil.sendMsg(msg.getMsgTitle(), msg.getMsgContent(), msgUrl, userId, appId,clientSecret, msg.getGroupName(), msg.getGroupRedirect(), "","true");
			}				
		}
	}
	/**
	 * 返回修改操作
	 * @param subId 分支主id
	 * @param replyContent 意见内容
	 */
	@ResponseBody
	@RequestMapping("/returnOperation")
	public void returnOperation(String infoId,String subId,String replyContent,String saveFlag){
		JSONObject json=new JSONObject();
		SubDocInfo subDocInfo = subDocInfoService.queryObject(subId);
		if(subDocInfo != null) {
			if(StringUtils.isNotBlank(subDocInfo.getUndertaker())) {
				String userId=subDocInfo.getUndertaker();
				//流转到下一个人并将临时反馈变为发布
				this.submitRelation(subId, subDocInfo.getUndertakerName(),userId,"3",null);
				//保存审批意见
				approvalOpinionService.saveOpinion(subId, replyContent, "3",saveFlag);
				//保存最新更新时间
				subDocInfo.setDocStatus(DbDocStatusDefined.TUIHUI_XIUGAI);
				subDocInfo.setUpdateTime(new Date());
				subDocInfoService.update(subDocInfo);
				// 发送消息提醒
				MsgTip msg = msgService.queryObject(MSGTipDefined.DCCB_TUIHUI_MSG_TITLE);
				if (msg != null) {
					String msgUrl = msg.getMsgRedirect()+"&fileId="+infoId+"&subId="+subId;
					msgUtil.sendMsg(msg.getMsgTitle(), msg.getMsgContent(), msgUrl, userId, appId,clientSecret, msg.getGroupName(), msg.getGroupRedirect(), "","true");
				}
				json.put("result", "success");
			}else {
				json.put("result", "fail");
			}
		}else {
			json.put("result", "fail");
		}
		Response.json(json);
	}
	
	/**
	 * 完成批量审批操作
	 * @param subId 分支主id
	 * @param replyContent 意见内容
	 */
	@ResponseBody
	@RequestMapping("/batchFinishOperation")
	public void batchFinishOperation(String subIds,String content){
		JSONObject json= new JSONObject();
		String currUserId = CurrentUser.getUserId();
		for (String subId : subIds.split(",")) {
			try {
				if(StringUtils.isNotBlank(subId)) {
					SubDocInfo subDocInfo = subDocInfoService.queryObject(subId);
					//查詢局內文流转记录最新一笔-判断当前文是否需要本人审批，否则拒绝掉
					SubDocTracking subDocTracking = subDocTrackingService.queryLatestRecord(subId);
					if (StringUtils.equals(currUserId, subDocTracking.getReceiverId())) {
						this.finishApprovalUnifiedDeal(subId, json, subDocInfo.getInfoId(), content, null);
					}else {
						logger.info("当前文的局ID：{}，由{}正在审批中。", subId, subDocTracking.getReceiverName());
						continue;
					}
				}else {
					logger.info("批量审批完成，记录审批意见：subId：{}", subId);
					continue;
				}
			} catch (Exception e) {
				logger.info("批量审批完成，记录审批意见：subId：{}，处理异常，异常简述：{}", subId, e);
				continue;
			}
		}
		Response.json(json);
	}
	/**
	 * 完成审批操作
	 * @param subId 分支主id
	 * @param replyContent 意见内容
	 */
	@ResponseBody
	@RequestMapping("/finishOperation")
	public void finishOperation(String infoId,String subId,String replyContent,String saveFlag){
		JSONObject json= new JSONObject();
		if(StringUtils.isNotBlank(infoId) && StringUtils.isNotBlank(subId)) {
			this.finishApprovalUnifiedDeal(subId, json, infoId, replyContent, saveFlag);
		}else {
			json.put("result", "fail");
		}
		Response.json(json);
	}
	/**
	 * 统一处理完成审批方法
	 * @param subId
	 * @param json
	 * @param infoId
	 * @param replyContent
	 * @param saveFlag
	 */
	private void finishApprovalUnifiedDeal(String subId,JSONObject json,String infoId,String replyContent,String saveFlag){
		SubDocInfo subDocInfo = subDocInfoService.queryObject(subId);
		String chooseStatus = subDocInfo.getChooseStatus();
		if(StringUtils.equals("1", chooseStatus)) {//承办人提交选择办理中
			//流转到下一个人并将临时反馈变为发布
			this.submitRelation(subId, subDocInfo.getUndertakerName(),subDocInfo.getUndertaker(),"4",null);
			//分支文件更新完成审批标识
			if(subDocInfo != null) {
				subDocInfo.setDocStatus(DbDocStatusDefined.BAN_LI_ZHONG);
				subDocInfo.setUpdateTime(new Date());
				subDocInfoService.update(subDocInfo);
			}
			json.put("result", "success");
		}else if(StringUtils.equals("2", chooseStatus)){//承办人提交选择办结
			//将临时反馈变为发布
			Map<String, Object> map =new HashMap<>();
			map.put("subId", subId);
			map.put("userId", CurrentUser.getUserId());
			map.put("showFlag", "0");
			ReplyExplain tempReply = replyExplainService.queryLastestTempReply(map);
			if(tempReply!=null) {
				tempReply.setReVersion("1");
				replyExplainService.update(tempReply);
			}
			//分支文件更新完成审批标识,并添加办结记录
			this.banJieOperation(infoId, subId);
		}else if(StringUtils.equals("3", chooseStatus)) {//承办人提交选择常态落实
			//将临时反馈变为发布
			Map<String, Object> map =new HashMap<>();
			map.put("subId", subId);
			map.put("userId", CurrentUser.getUserId());
			map.put("showFlag", "0");
			ReplyExplain tempReply = replyExplainService.queryLastestTempReply(map);
			if(tempReply!=null) {
				tempReply.setReVersion("1");
				replyExplainService.update(tempReply);
			}
			//分支文件更新完成审批标识,并添加办结记录
			this.luoShiOperation(infoId, subId);
		}
		
		//保存意见
		approvalOpinionService.saveOpinion(subId, replyContent, "2",saveFlag);
		//催办完成
		DocumentInfo info = documentInfoService.queryObject(infoId);
		if(StringUtils.equals(info.getCuibanFlag(), "1")){
			//催办记录添加响应承办人，并标识完成
			Map<String, Object> cuiBanMap = new HashMap<>();
			cuiBanMap.put("infoId", infoId);
			cuiBanMap.put("finishFlag", 0);
			List<DocumentCbjl> cuibanList = documentCbjlService.queryList(cuiBanMap);
			if(cuibanList != null && cuibanList.size()>0) {
				DocumentCbjl cbjl = cuibanList.get(0);
				cbjl.setCbrId(subDocInfo.getUndertaker());
				cbjl.setCbrName(subDocInfo.getUndertakerName());
				cbjl.setCbTime(new Date());
				cbjl.setFinishFlag(1);
				documentCbjlService.update(cbjl);
			}
			info.setCuibanFlag("0");
		}
		//主记录不标识催办,清理本次首长已读
		info.setSzReadIds("");
		//获取最新反馈(各组)
		List<ReplyExplain> latestReplyList = replyExplainService.querySubLatestReply(infoId, subId);
		if(latestReplyList != null && latestReplyList.size()>0) {
			info.setLatestReply(latestReplyList.get(0).getReplyContent());
			info.setLatestSubDept(subDocInfo.getSubDeptName());
			info.setLatestUndertaker(subDocInfo.getUndertakerName());
			info.setLatestReplyTime(new Date());
		}
		documentInfoService.update(info);
		//清理除首长外的本文件已读
		documentReadService.deleteByInfoId(infoId);
		//反馈对他局和部可见(顺序必须放标识催办完成后边，因为showFlag的值作为参数进行了查询)
		replyExplainService.updateShowFlag(subId);
		//意见对他局和部可见
		approvalOpinionService.updateShowFlag(subId);
		json.put("result", "success");
	}
	
	private void submitRelation(String subId,String userName,String userId,String trackingType,String status) {
		//获取当前登录人信息
		String loginUserId=CurrentUser.getUserId();
		String deptId = null;
		String deptName = null;
		List<BaseAppUser> list = baseAppUserService.findByUserId(userId);
		if(list !=null && list.size()>0) {
			deptId = list.get(0).getOrganid();
			if(StringUtils.isNotBlank(deptId)) {
				BaseAppOrgan organ = baseAppOrganService.queryObject(deptId);
				deptName=organ.getName();
			}
		}
		//将临时反馈变为发布
		Map<String, Object> map =new HashMap<>();
		map.put("subId", subId);
		map.put("userId", loginUserId);
		map.put("showFlag", "0");
		ReplyExplain tempReply = replyExplainService.queryLastestTempReply(map);
		if(tempReply!=null) {
			tempReply.setReVersion("1");
			if(StringUtils.isNotBlank(status)) {
				tempReply.setChooseStatus(status);
			}
			replyExplainService.update(tempReply);
		}
		//添加流转记录
		SubDocTracking tracking = new SubDocTracking();
		String loginUserName=CurrentUser.getUsername();
		String loginUserDeptId=CurrentUser.getDepartmentId();
		String loginUserDeptName=CurrentUser.getOrgName();
		tracking.setSenderId(loginUserId);
		tracking.setSenderName(loginUserName);
		tracking.setSenDeptId(loginUserDeptId);
		tracking.setSenDeptName(loginUserDeptName);
		tracking.setReceiverId(userId);
		tracking.setReceiverName(userName);
		tracking.setRecDeptId(deptId);
		tracking.setRecDeptName(deptName);
		tracking.setSubId(subId);
		tracking.setTrackingType(trackingType);
		if(StringUtils.isNotBlank(status)) {
			tracking.setPreviousStatus(Integer.parseInt(status));
		}
		subDocTrackingService.save(tracking);
	}
	
	/**
	 * @description:个人待办菜单气泡数（都是我正在处理的文：需要落实的，送给自己审核的、退回自己修改的）
	 * @author:zhangyw
	 * @date:2019年5月17日
	 * @Version v1.0
	 */
	@ResponseBody
	@RequestMapping("/grdbMenuNums")
	public void grdbMenuNums() {
		int grdbNum=0;
		Map<String, Object> map = new HashMap<>();
		String loginUserId=CurrentUser.getUserId();
		if(StringUtils.isNotBlank(loginUserId)) {
			map.put("loginUserId", loginUserId);
		}
		map.put("receiver", "receiver");
		List<SubDocInfo> subDocInfoList = subDocInfoService.queryPersonList(map);
		if(subDocInfoList !=null && subDocInfoList.size()>0) {
			grdbNum=subDocInfoList.size();
		}
		Response.json("grdbNum",grdbNum);
	}
	
	/**
	 * @description:局内待办菜单气泡数（部转办到局的数据即指状态为待转办的数据）
	 * @author:zhangyw
	 * @date:2019年5月16日
	 * @Version v1.0
	 */
	@ResponseBody
	@RequestMapping("/jndbMenuNums")
	public void jndbMenuNums() {
		int jndbNum=0;
		Map<String, Object> map = new HashMap<>();
		String loginUserId=CurrentUser.getUserId();
		String orgId = baseAppUserService.getBareauByUserId(loginUserId);
		if(StringUtils.isNotBlank(orgId)) {
			map.put("orgId", orgId);
		}
		map.put("docStatus", DbDocStatusDefined.DAI_ZHUAN_BAN);
		//查询列表数据
		List<SubDocInfo> subDocInfoList = subDocInfoService.queryList(map);
		if(subDocInfoList !=null && subDocInfoList.size()>0) {
			jndbNum=subDocInfoList.size();
		}
		Response.json("jndbNum",jndbNum);
	}
	/**
	 * @description:获取当前用户角色类型
	 * @date:2019年6月24日
	 * @Version v1.0
	 */
	@ResponseBody
	@RequestMapping("/currUserRoleType")
	public void currUserRoleType() {
		JSONObject jsonObject = new JSONObject();
		String loginUserId=CurrentUser.getUserId();
		//当前登录人的角色
		Map<String, Object> roleMap = new HashMap<>();
		roleMap.put("userId", loginUserId);
		List<RoleSet> roleList = roleSetService.queryList(roleMap);
		String currUserRoleType = null;
		if(roleList != null && roleList.size()>0) {
			currUserRoleType = roleList.get(0).getRoleFlag();
			logger.info("===================="+roleList.get(0).getUserName()+"============="+roleList.get(0).getUserId());
			jsonObject.put("currUserRoleType", currUserRoleType);
			jsonObject.put("result", "success");
		}else {
			jsonObject.put("result","fail");
		}
		Response.json(jsonObject);
	}
}
