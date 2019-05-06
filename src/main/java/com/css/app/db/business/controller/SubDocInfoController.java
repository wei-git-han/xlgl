package com.css.app.db.business.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.css.addbase.apporgan.entity.BaseAppOrgan;
import com.css.addbase.apporgan.entity.BaseAppUser;
import com.css.addbase.apporgan.service.BaseAppOrganService;
import com.css.addbase.apporgan.service.BaseAppUserService;
import com.css.app.db.business.entity.DocumentBjjl;
import com.css.app.db.business.entity.DocumentCbjl;
import com.css.app.db.business.entity.DocumentInfo;
import com.css.app.db.business.entity.DocumentLsjl;
import com.css.app.db.business.entity.ReplyExplain;
import com.css.app.db.business.entity.SubDocInfo;
import com.css.app.db.business.entity.SubDocTracking;
import com.css.app.db.business.service.ApprovalOpinionService;
import com.css.app.db.business.service.DocumentBjjlService;
import com.css.app.db.business.service.DocumentCbjlService;
import com.css.app.db.business.service.DocumentInfoService;
import com.css.app.db.business.service.DocumentLsjlService;
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
import com.css.base.utils.UUIDUtils;
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
	private DocumentLsjlService documentLsjlService;
	
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
		GwPageUtils pageUtil = new GwPageUtils(subDocInfoList);
		Response.json(pageUtil);
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
		subDocInfo.setDocStatus(DbDocStatusDefined.BAN_LI_ZHONG);
		subDocInfoService.update(subDocInfo);
		Response.json("result", "success");
	}
	
	/**
	 * 办结操作：有一个分支局状态为非办结状态，主文件则不标识为办结，其他分支局办结的标识均为建议办结。各分支局全部办结，则主文件为办结状态
	 * @param infoId 主文件id
	 * @param subId 分支主id
	 */
	@ResponseBody
	@RequestMapping("/banJieOperation")
	public void banJieOperation(String infoId,String subId){
		JSONObject json= new JSONObject();
		if(StringUtils.isNotBlank(infoId) && StringUtils.isNotBlank(subId)) {
			SubDocInfo subInfo = subDocInfoService.queryObject(subId);
			DocumentBjjl bjjl=new DocumentBjjl();
			//取除本分支机构外的其他机构的最小状态值
			int minDocStatus = subDocInfoService.queryMinDocStatus(infoId,subInfo.getSubDeptId());
			int maxDocStatus = subDocInfoService.queryMaxDocStatus(infoId, subInfo.getSubDeptId());
			if(0==minDocStatus && 0==maxDocStatus) {
				//主文件标示为办结
				DocumentInfo info = documentInfoService.queryObject(infoId);
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
						info.setStatus(2);
						documentInfoService.update(info);
						//当前分支文件变为办结
						//subDocInfoService.updateDocStatus(DbDocStatusDefined.BAN_JIE, new Date() , infoId);
						subInfo.setDocStatus(DbDocStatusDefined.BAN_JIE);
						bjjl.setContent("系统自动办结");
					}
				}
			}
			subInfo.setUpdateTime(new Date());
			subDocInfoService.update(subInfo);
			//添加办结记录
			bjjl.setInfoId(infoId);
			bjjl.setSubId(subId);
			documentBjjlService.save(bjjl);
			json.put("result", "success");
		}else {
			json.put("result", "fail");
		}
		Response.json(json);
	}
	/**
	 * 常态落实操作：所有分支局必须都处在建议办结或建议落实的状态下，且至少有一个为常态落实
	 * @param infoId 主文件id
	 * @param subId 分支主id
	 */
	@ResponseBody
	@RequestMapping("/luoShiOperation")
	public void luoShiOperation(String infoId,String subId){
		JSONObject json= new JSONObject();
		if(StringUtils.isNotBlank(infoId)) {
			SubDocInfo subInfo = subDocInfoService.queryObject(subId);
			int minDocStatus = subDocInfoService.queryMinDocStatus(infoId,subInfo.getSubDeptId());
			int maxDocStatus = subDocInfoService.queryMaxDocStatus(infoId, subInfo.getSubDeptId());
			DocumentLsjl lsjl= new DocumentLsjl();
			if(0==minDocStatus && 0==maxDocStatus) {
				//主文件状态变为常态落实
				DocumentInfo info = documentInfoService.queryObject(infoId);
				info.setStatus(3);
				documentInfoService.update(info);
				subInfo.setDocStatus(DbDocStatusDefined.CHANG_TAI_LUO_SHI);
				lsjl.setContent("常态落实");
			}else {
				//如果最小状态值小于建议办结的状态，则将本分支局状态标示为建议落实
				if(minDocStatus< DbDocStatusDefined.JIAN_YI_BAN_JIE) {
					subInfo.setDocStatus(DbDocStatusDefined.JIAN_YI_LUO_SHI);
					lsjl.setContent("建议落实");
				}else {//如果最小状态值不小于建议办结的状态，且最大值大于等于建议办结，说明本分支机构至少有一个常态落实
					if(maxDocStatus >= DbDocStatusDefined.JIAN_YI_BAN_JIE) {
						//主文件状态变为常态落实
						DocumentInfo info = documentInfoService.queryObject(infoId);
						info.setStatus(3);
						documentInfoService.update(info);
						//各分支文件变为常态落实
						//subDocInfoService.updateDocStatus(DbDocStatusDefined.CHANG_TAI_LUO_SHI, new Date() , infoId);
						subInfo.setDocStatus(DbDocStatusDefined.CHANG_TAI_LUO_SHI);
						lsjl.setContent("系统自动常态落实");
					}
				}
			}
			subInfo.setUpdateTime(new Date());
			subDocInfoService.update(subInfo);
			//添加落实记录
			lsjl.setInfoId(infoId);
			lsjl.setSubId(subId);
			documentLsjlService.save(lsjl);
			json.put("result", "success");
		}else {
			json.put("result", "fail");
		}
		Response.json(json);
	}
	
	/**
	 * 承办人送审批
	 * @param subId 分支主id
	 * @param userName 接收人
	 * @param userId 接收人id
	 */
	@ResponseBody
	@RequestMapping("/submitOperation")
	public void submitOperation(String subId,String userName,String userId){
		//流转到下一个人并将临时反馈变为发布
		this.submitRelation(subId, userName, userId,"2");
		//分支文件更新完成审批标识
		SubDocInfo subDocInfo = subDocInfoService.queryObject(subId);
		if(subDocInfo != null) {
			subDocInfo.setDocStatus(DbDocStatusDefined.DAI_SHEN_PI);
			subDocInfo.setUpdateTime(new Date());
			subDocInfoService.update(subDocInfo);
		}
		Response.json("result", "success");
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
	public void sendOperation(String subId,String userName,String userId,String replyContent){
		//流转到下一个人并将临时反馈变为发布
		this.submitRelation(subId, userName, userId,"2");
		//保存审批意见
		approvalOpinionService.saveOpinion(subId, replyContent, "1");
		//保存最新更新时间
		SubDocInfo subDocInfo = subDocInfoService.queryObject(subId);
		if(subDocInfo != null) {
			subDocInfo.setDocStatus(DbDocStatusDefined.DAI_SHEN_PI);
			subDocInfo.setUpdateTime(new Date());
			subDocInfoService.update(subDocInfo);
		}
		Response.json("result", "success");
	}
	
	/**
	 * 返回修改操作
	 * @param subId 分支主id
	 * @param replyContent 意见内容
	 */
	@ResponseBody
	@RequestMapping("/returnOperation")
	public void returnOperation(String subId,String replyContent){
		JSONObject json=new JSONObject();
		SubDocInfo subDocInfo = subDocInfoService.queryObject(subId);
		if(subDocInfo != null) {
			if(StringUtils.isNotBlank(subDocInfo.getUndertaker())) {
				//流转到下一个人并将临时反馈变为发布
				this.submitRelation(subId, subDocInfo.getUndertakerName(),subDocInfo.getUndertaker(),"3");
				//保存审批意见
				approvalOpinionService.saveOpinion(subId, replyContent, "3");
				//保存最新更新时间
				subDocInfo.setDocStatus(DbDocStatusDefined.TUIHUI_XIUGAI);
				subDocInfo.setUpdateTime(new Date());
				subDocInfoService.update(subDocInfo);
			}else {
				json.put("result", "fail");
			}
		}else {
			json.put("result", "fail");
		}
		Response.json("result", "success");
	}
	
	/**
	 * 完成审批操作
	 * @param subId 分支主id
	 * @param replyContent 意见内容
	 */
	@ResponseBody
	@RequestMapping("/finishOperation")
	public void finishOperation(String infoId,String subId,String replyContent){
		SubDocInfo subDocInfo = subDocInfoService.queryObject(subId);
		//流转到下一个人并将临时反馈变为发布
		this.submitRelation(subId, subDocInfo.getUndertakerName(),subDocInfo.getUndertaker(),"4");
		//保存意见
		approvalOpinionService.saveOpinion(subId, replyContent, "2");
		//分支文件更新完成审批标识
		if(subDocInfo != null) {
			subDocInfo.setDocStatus(DbDocStatusDefined.BAN_LI_ZHONG);
			subDocInfo.setUpdateTime(new Date());
			subDocInfoService.update(subDocInfo);
		}
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
			//主记录不标识催办,添加最新的反馈
			info.setSzReadIds("");
			info.setCuibanFlag("0");
            //获取最新反馈(各组)
			List<ReplyExplain> latestReplyList = replyExplainService.querySubLatestReply(infoId, subId);
			if(latestReplyList != null && latestReplyList.size()>0) {
				info.setLatestReply(latestReplyList.get(0).getReplyContent());
				info.setLatestSubDept(subDocInfo.getSubDeptName());
				info.setLatestUndertaker(subDocInfo.getUndertakerName());
				info.setLatestReplyTime(new Date());
			}
			documentInfoService.update(info);
		}
		//反馈对他局和部可见(顺序必须放标识催办完成后边，因为showFlag的值作为参数进行了查询)
		replyExplainService.updateShowFlag(subId);
		//意见对他局和部可见
		approvalOpinionService.updateShowFlag(subId);
		Response.json("result", "success");
	}
	
	private void submitRelation(String subId,String userName,String userId,String trackingType) {
		//获取当前登录人信息
		String loginUserId=CurrentUser.getUserId();
		String loginUserName=CurrentUser.getUsername();
		String loginUserDeptId=CurrentUser.getDepartmentId();
		String loginUserDeptName=CurrentUser.getOrgName();
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
		//添加流转记录
		SubDocTracking tracking = new SubDocTracking();
		tracking.setId(UUIDUtils.random());
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
		tracking.setCreatedTime(new Date());
		subDocTrackingService.save(tracking);
		//将临时反馈变为发布
		Map<String, Object> map =new HashMap<>();
		map.put("subId", subId);
		map.put("userId", loginUserId);
		map.put("showFlag", "0");
		ReplyExplain tempReply = replyExplainService.queryLastestTempReply(map);
		if(tempReply!=null) {
			tempReply.setReVersion("1");
			replyExplainService.update(tempReply);
		}
	}
}
