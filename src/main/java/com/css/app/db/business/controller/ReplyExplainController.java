package com.css.app.db.business.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.css.app.db.business.entity.ApprovalOpinion;
import com.css.app.db.business.entity.DocumentBjjl;
import com.css.app.db.business.entity.ReplyAttac;
import com.css.app.db.business.entity.ReplyExplain;
import com.css.app.db.business.entity.SubDocInfo;
import com.css.app.db.business.entity.SubDocTracking;
import com.css.app.db.business.service.ApprovalOpinionService;
import com.css.app.db.business.service.DocumentBjjlService;
import com.css.app.db.business.service.ReplyAttacService;
import com.css.app.db.business.service.ReplyExplainService;
import com.css.app.db.business.service.SubDocInfoService;
import com.css.app.db.business.service.SubDocTrackingService;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.Response;
import com.css.base.utils.UUIDUtils;

import cn.com.css.filestore.impl.HTTPFile;


/**
 * 办理反馈表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-25 19:07:17
 */
@Controller
@RequestMapping("/app/db/replyexplain")
public class ReplyExplainController {
	private final Logger logger = LoggerFactory.getLogger(ReplyExplainController.class);
	@Autowired
	private ReplyExplainService replyExplainService;
	@Autowired
	private ReplyAttacService replyAttacService;
	@Autowired
	private SubDocInfoService subDocInfoService;
	@Autowired
	private ApprovalOpinionService approvalOpinionService;
	@Autowired
	private SubDocTrackingService subDocTrackingService;
	/**
	 * 获取某个分支局反馈
	 * @param infoId 主文件id
	 * @param subId 分支局id
	 */
	@ResponseBody
	@RequestMapping("/subReplyList")
	public void subReplyList(String infoId,String subId){
		JSONArray jsonArray = new JSONArray();
		if(StringUtils.isNotBlank(infoId) && StringUtils.isNotBlank(subId)) {
			//承办人
			SubDocInfo subDocInfo = subDocInfoService.queryObject(subId);
			//当前审核人
			SubDocTracking latestRecord = subDocTrackingService.queryLatestRecord(subId);
			boolean isCheckUser=false;
			if(latestRecord != null) {
				String recordId=latestRecord.getReceiverId();
				if(StringUtils.equals(CurrentUser.getUserId(),recordId )) {
					isCheckUser=true;
				}
			}
			if(subDocInfo != null) {
				String cbrId=subDocInfo.getUndertaker();
				//获取某局各组最新的反馈
				List<ReplyExplain> dbReplyExplainList = replyExplainService.querySubLatestReply(infoId, subId);
				for (ReplyExplain replyExplain : dbReplyExplainList) {
					boolean editFlag=false;
					JSONObject json=new JSONObject();
					String teamId=replyExplain.getTeamId();
					Date firstDate = null;
					Map<String, Object> replyMap =new HashMap<>();
					replyMap.put("subId", subId);
					replyMap.put("teamId", teamId);
					replyMap.put("cbrFlag", "1");
					replyMap.put("sort", "asc");
					List<ReplyExplain> list = replyExplainService.queryList(replyMap);
					if(list !=null && list.size()>0) {
						//第一个承办人反馈的时间
						firstDate = list.get(0).getCreatedTime();
						String showFlag = list.get(0).getShowFlag();
						if(StringUtils.isNotBlank(cbrId)) {
							//如果已经正式发布显示这一组最后一个承办人姓名
							if(StringUtils.equals("1", showFlag)) {
								json.put("cbrId", list.get(list.size()-1).getUserId());
								json.put("cbrName", list.get(list.size()-1).getUserName());
							}else {
								//如果未正式发布则显示系统当前承办人姓名（（因为可能会存在流程中转办但下一个承办人承办了但还没做任何反馈的修改的时候））
								json.put("cbrId", cbrId);
								json.put("cbrName", subDocInfo.getUndertakerName());
							}
						}else {
							//如果处在为承办的过程中，则显示当前组的最后一个承办人姓名
							json.put("cbrId", list.get(list.size()-1).getUserId());
							json.put("cbrName", list.get(list.size()-1).getUserName());
						}
					}
					json.put("danwei", subDocInfo.getSubDeptName());
					json.put("firstDate", firstDate);
					json.put("teamId", teamId);
					json.put("content",replyExplain.getReplyContent());
					json.put("updateTime",replyExplain.getCreatedTime());
					//编辑的显示条件：1、当前反馈未正式发布2.登录人为当前处理人3.非待落实状态
					if(!StringUtils.equals("1", replyExplain.getShowFlag()) && isCheckUser && subDocInfo.getDocStatus()!=5) {
						editFlag=true;
					}
					json.put("edit",editFlag);
					//附件
					Map<String, Object> map = new HashMap<>();
					map.put("teamId", teamId);
					map.put("subId", subId);
					List<ReplyAttac> attchList = replyAttacService.queryList(map);
					json.put("attchList",attchList);
					Map<String, Object> opMap = new HashMap<>();
					opMap.put("subId", subId);
					opMap.put("teamId", teamId);
					List<ApprovalOpinion> opinionList = approvalOpinionService.queryList(map);
					if(opinionList != null && opinionList.size()>0) {
						json.put("cuowei","1");
						for(ApprovalOpinion opinion : opinionList) {
							if(StringUtils.equals("1", opinion.getYjType())) {
								if(StringUtils.isNotBlank(opinion.getOpinionContent())) {
									HTTPFile httpFile = new HTTPFile(opinion.getOpinionContent());
									opinion.setOpinionContent(httpFile.getAssginDownloadURL());
								}else {
									System.out.print("标识为手写签批，但局长手写签批获取不到，可能原因为标识存错或者链接不到文件服务");
								}
							}
						}
						json.put("opinionList",opinionList);
					}else {
						json.put("cuowei","0");
					}
					//未完成审批的默认展开标识
					if(StringUtils.equals("1", replyExplain.getShowFlag())) {
						json.put("show","0");
					}else {
						json.put("show","1");
					}
					jsonArray.add(json);
				}
			}
		}
		Response.json(jsonArray);
	}
	
	/**
	 * 获取所有分支局反馈
	 * @param infoId 主文件id
	 */
	@ResponseBody
	@RequestMapping("/allReplyList")
	public void allReplyList(String infoId){
		JSONArray jsonArray = new JSONArray();
		if(StringUtils.isNotBlank(infoId)) {
			//获取所有分支局已经正式发布的反馈按创建时间倒叙排列
			List<ReplyExplain> dbReplyExplainList = replyExplainService.queryAllLatestReply(infoId);
			for (ReplyExplain replyExplain : dbReplyExplainList) {
				String subId=replyExplain.getSubId();
				SubDocInfo subDocInfo = subDocInfoService.queryObject(subId);
				if(subDocInfo != null) {
					JSONObject json=new JSONObject();
					String teamId=replyExplain.getTeamId();
					Date firstDate = null;
					Map<String, Object> replyMap =new HashMap<>();
					replyMap.put("subId", subId);
					replyMap.put("teamId", teamId);
					replyMap.put("cbrFlag", "1");
					replyMap.put("sort", "asc");
					List<ReplyExplain> list = replyExplainService.queryList(replyMap);
					if(list !=null && list.size()>0) {
						firstDate = list.get(0).getCreatedTime();
						json.put("cbrId", list.get(list.size()-1).getUserId());
						json.put("cbrName", list.get(list.size()-1).getUserName());
					}
					json.put("danwei", subDocInfo.getSubDeptName());
					json.put("firstDate", firstDate);
					json.put("subId", subId);
					json.put("teamId", teamId);
					json.put("content",replyExplain.getReplyContent());
					json.put("updateTime",replyExplain.getCreatedTime());
					//附件
					Map<String, Object> map = new HashMap<>();
					map.put("teamId", teamId);
					map.put("subId", subId);
					List<ReplyAttac> attchList = replyAttacService.queryList(map);
					json.put("attchList",attchList);
					Map<String, Object> opMap = new HashMap<>();
					opMap.put("subId", subId);
					opMap.put("teamId", teamId);
					List<ApprovalOpinion> opinionList = approvalOpinionService.queryList(map);
					if(opinionList != null && opinionList.size()>0) {
						json.put("cuowei","1");
						for(ApprovalOpinion opinion : opinionList) {
							if(StringUtils.equals("1", opinion.getYjType())) {
								if(StringUtils.isNotBlank(opinion.getOpinionContent())) {
									HTTPFile httpFile = new HTTPFile(opinion.getOpinionContent());
									opinion.setOpinionContent(httpFile.getAssginDownloadURL());
								}else {
									System.out.print("标识为手写签批，但局长手写签批获取不到，可能原因为标识存错或者链接不到文件服务");
								}
							}
						}
						json.put("opinionList",opinionList);
					}else {
						json.put("cuowei","0");
					}
					jsonArray.add(json);
				}
			}
		}
		Response.json(jsonArray);
	}
	
	/**
	 * 获取所有局最新一条的已发布反馈
	 * @param infoId
	 */
	@ResponseBody
	@RequestMapping("/getAllLatestOneReply")
	public void getAllLatestOneReply(String infoId) {
		List<ReplyExplain> latestOneReply = replyExplainService.queryAllLatestOneReply(infoId);
		for (ReplyExplain replyExplain : latestOneReply) {
			Map<String, Object> replyMap =new HashMap<>();
			replyMap.put("subId", replyExplain.getSubId());
			replyMap.put("teamId", replyExplain.getTeamId());
			replyMap.put("cbrFlag", "1");
			List<ReplyExplain> list = replyExplainService.queryList(replyMap);
			if(list !=null && list.size()>0) {
				replyExplain.setUserName(list.get(0).getUserName());
			}
		}
		Response.json(latestOneReply);
	}
	
	/**
	 * 获取某个反馈的审批意见----暂时没有用（本来想点击展开的时候单独获取用）
	 * @param subId 分局主id
	 * @param teamId 某个反馈
	 */
	@ResponseBody
	@RequestMapping("/getOpinion")
	public void getOpinion(String subId,String teamId) {
		Map<String, Object> map = new HashMap<>();
		map.put("subId", subId);
		map.put("teamId", teamId);
		List<ApprovalOpinion> queryList = approvalOpinionService.queryList(map);
		Response.json(queryList);
	}
	
	/**
	 * 获取某个人的反馈---------注：已经废弃不用了
	 * @param subId 分支主文件id
	 * @param teamId 某组反馈的id
	 * @param userId 人的id
	 */
	@ResponseBody
	@RequestMapping("/personReply")
	public void personReply(String subId,String teamId,String userId) {
		ReplyExplain reply=null;
		Map<String, Object> map = new HashMap<>();
		map.put("subId", subId);
		map.put("teamId", teamId);
		map.put("userId", userId);
		List<ReplyExplain> queryList = replyExplainService.queryList(map);
		if(queryList !=null && queryList.size()>0) {
			reply=queryList.get(0);
		}
		Response.json(reply);
	}
	
	/**
	 * 获取某组办理反馈
	 * @param subId
	 * @param teamId
	 */
	@ResponseBody
	@RequestMapping("/getReplyByTeamId")
	public void getReplyByTeamId(String subId,String teamId) {
		Map<String, Object> map = new HashMap<>();
		map.put("subId", subId);
		map.put("teamId", teamId);
		List<ReplyExplain> queryList = replyExplainService.queryList(map);
		Response.json(queryList);
	}
	
	/**
	 * 保存反馈意见
	 */
	@ResponseBody
	@RequestMapping("/save")
	public void save(String subId,String infoId,String teamId,String replyContent,@RequestParam(value = "file", required = false) MultipartFile[] files){
		String loginUserId=CurrentUser.getUserId();
		String loginUserName=CurrentUser.getUsername();
		String cbrFlag="0";
		JSONObject json=new JSONObject();
		if(StringUtils.isNotBlank(infoId) && StringUtils.isNotBlank(subId)) {
			SubDocInfo subDocInfo = subDocInfoService.queryObject(subId);
			if(StringUtils.equals(loginUserId, subDocInfo.getUndertaker())) {
				cbrFlag="1";
			}
			if(StringUtils.isBlank(teamId)) {
				String uuid=UUIDUtils.random();
				//新增反馈及附件
				replyExplainService.saveReply(subId, infoId, loginUserId, loginUserName, uuid, replyContent, subDocInfo.getSubDeptId(), subDocInfo.getSubDeptName(),cbrFlag);
				if(files!=null){
					replyAttacService.saveAttacs(files, subId, uuid);
				}
			}else {
				Map<String, Object> map =new HashMap<>();
				map.put("subId", subId);
				map.put("userId", loginUserId);
				map.put("teamId", teamId);
				map.put("showFlag", "0");
				ReplyExplain tempReply = replyExplainService.queryLastestTempReply(map);
				if(tempReply != null) {
					tempReply.setReplyContent(replyContent);
					replyExplainService.update(tempReply);
					
				}else {
					Map<String, Object> cbrMap =new HashMap<>();
					cbrMap.put("subId", subId);
					cbrMap.put("teamId", teamId);
					cbrMap.put("showFlag", "0");
					ReplyExplain zbTempReply = replyExplainService.queryLastestTempReply(cbrMap);
					if(zbTempReply != null) {
						if(StringUtils.equals("1", zbTempReply.getCbrFlag()) && StringUtils.equals("1", cbrFlag)) {
							zbTempReply.setCbrFlag("0");
						}
						zbTempReply.setReVersion("1");
						replyExplainService.update(zbTempReply);
					}
					replyExplainService.saveReply(subId, infoId, loginUserId, loginUserName, teamId, replyContent, subDocInfo.getSubDeptId(), subDocInfo.getSubDeptName(),cbrFlag);
				}
				if(files!=null && files.length>0){
					replyAttacService.saveAttacs(files, subId, teamId);
				}
			}
			
			json.put("result", "success");
		}else {
			json.put("result", "fail");
		}
		Response.json(json);
	}
	/**
	 * 编辑反馈意见
	 */
	@ResponseBody
	@RequestMapping("/edit")
	public void edit(String subId,String infoId,String teamId,String replyContent){
		String loginUserId=CurrentUser.getUserId();
		String loginUserName=CurrentUser.getUsername();
		String cbrFlag="0";
		JSONObject json=new JSONObject();
		if(StringUtils.isNotBlank(infoId) && StringUtils.isNotBlank(subId)) {
			SubDocInfo subDocInfo = subDocInfoService.queryObject(subId);
			if(StringUtils.equals(loginUserId, subDocInfo.getUndertaker())) {
				cbrFlag="1";
			}
			if(StringUtils.isBlank(teamId)) {
				String uuid=UUIDUtils.random();
				//新增反馈及附件
				replyExplainService.saveReply(subId, infoId, loginUserId, loginUserName, uuid, replyContent, subDocInfo.getSubDeptId(), subDocInfo.getSubDeptName(),cbrFlag);
			}else {
				Map<String, Object> map =new HashMap<>();
				map.put("subId", subId);
				map.put("userId", loginUserId);
				map.put("teamId", teamId);
				map.put("showFlag", "0");
				ReplyExplain tempReply = replyExplainService.queryLastestTempReply(map);
				if(tempReply != null) {
					tempReply.setReplyContent(replyContent);
					replyExplainService.update(tempReply);
				}else {
					replyExplainService.saveReply(subId, infoId, loginUserId, loginUserName, teamId, replyContent, subDocInfo.getSubDeptId(), subDocInfo.getSubDeptName(),cbrFlag);
				}
			}
			json.put("result", "success");
		}else {
			json.put("result", "fail");
		}
		Response.json(json);
	}
	
	/**
	 * 保存反馈意见
	 *//*
	@ResponseBody
	@RequestMapping("/save")
	public void save(String subId,String infoId,String teamId,String replyContent){
		String loginUserId=CurrentUser.getUserId();
		String loginUserName=CurrentUser.getUsername();
		JSONObject json=new JSONObject();
		if(StringUtils.isNotBlank(infoId) && StringUtils.isNotBlank(subId)) {
			SubDocInfo subDocInfo = subDocInfoService.queryObject(subId);
			if(StringUtils.isBlank(teamId)) {
				String uuid=UUIDUtils.random();
				//新增反馈及附件
				replyExplainService.saveReply(subId, infoId, loginUserId, loginUserName, uuid, replyContent, subDocInfo.getSubDeptId(), subDocInfo.getSubDeptName());
				
			}else {
				Map<String, Object> map =new HashMap<>();
				map.put("subId", subId);
				map.put("userId", loginUserId);
				map.put("teamId", teamId);
				map.put("showFlag", "0");
				ReplyExplain tempReply = replyExplainService.queryLastestTempReply(map);
				if(tempReply != null) {
					tempReply.setReplyContent(replyContent);
					replyExplainService.update(tempReply);
				}else {
					replyExplainService.saveReply(subId, infoId, loginUserId, loginUserName, teamId, replyContent, subDocInfo.getSubDeptId(), subDocInfo.getSubDeptName());
				}
			}
			json.put("result", "success");
		}else {
			json.put("result", "fail");
		}
		Response.json(json);
	}*/
	/**
	 * 删除附件
	 * @param id 附件id
	 */
	@ResponseBody
	@RequestMapping("/deleteAttch")
	public void delete(String id){
		replyAttacService.delete(id);
		Response.json("result", "success");
	}
	
    /**
     * 下载附件
     * @param fileId
     */
	@ResponseBody
	@RequestMapping("/downLoad")
	public void downLoad(String fileId){
		String url="";
		if(StringUtils.isNotBlank(fileId)){
			HTTPFile hf = new HTTPFile(fileId);
		    url = hf.getAssginDownloadURL();
		}
		Response.json("url", url);
	}
}
