package com.css.app.db.business.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.css.addbase.apporgan.service.BaseAppUserService;
import com.css.app.db.business.entity.DocumentInfo;
import com.css.app.db.business.entity.SubDocInfo;
import com.css.app.db.business.entity.SubDocTracking;
import com.css.app.db.business.service.DocumentInfoService;
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
			map.put("docStatus", docStatus);
		}
		//查询列表数据
		PageHelper.startPage(page, pagesize);
		List<SubDocInfo> subDocInfoList = subDocInfoService.queryList(map);
		GwPageUtils pageUtil = new GwPageUtils(subDocInfoList);
		Response.json(pageUtil);
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
			map.put("docStatus", docStatus);
		}
		//查询列表数据
		PageHelper.startPage(page, pagesize);
		List<SubDocInfo> subDocInfoList = subDocInfoService.queryPersonList(map);
		GwPageUtils pageUtil = new GwPageUtils(subDocInfoList);
		Response.json(pageUtil);
	}
	
	/**
	 * 按钮显示参数
	 * @param subId 分支主id
	 */
	@ResponseBody
	@RequestMapping("/buttonParam")
	public void info( String subId){
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
			SubDocInfo dbSubDocInfo = subDocInfoService.queryObject(subId);
			if(dbSubDocInfo != null) {
				docStatus = dbSubDocInfo.getDocStatus();
				if(StringUtils.isNotBlank(dbSubDocInfo.getUndertaker())) {
					isUndertaken=true;
					if(StringUtils.equals(loginUserId, dbSubDocInfo.getUndertaker())) {
						isUndertaker=true;
					}
				}
			}
			//当前审核人
			SubDocTracking latestRecord = subDocTrackingService.queryLatestRecord(subId);
			if(latestRecord != null) {
				if(StringUtils.equals(loginUserId, latestRecord.getReceiverId())) {
					isCheckUser=true;
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
		subDocInfo.setDocStatus(DbDocStatusDefined.BAN_LI_ZHONG);
		subDocInfoService.update(subDocInfo);
		Response.json("result", "success");
	}
	
	/**
	 * 办结操作：有一个分支局状态为非办结状态，主文件则不标识为办结，其他分支局办结的标识为建议办结。各分支局全部办结，则主文件为办结状态
	 * @param infoId 主文件id
	 * @param subId 分支主id
	 */
	@ResponseBody
	@RequestMapping("/banJieOperation")
	public void banJieOperation(String infoId,String subId){
		String loginUserDeptId=CurrentUser.getDepartmentId();
		JSONObject json= new JSONObject();
		if(StringUtils.isNotBlank(infoId) && StringUtils.isNotBlank(subId) && StringUtils.isNotBlank(loginUserDeptId)) {
			//取除本分支机构外的其他机构的最小状态值
			int minDocStatus = subDocInfoService.queryMinDocStatus(infoId,loginUserDeptId);
			SubDocInfo subInfo = subDocInfoService.queryObject(subId);
			//如果最小状态值小于建议办结的状态，则将本分支局状态标示为建议办结
			if(minDocStatus< DbDocStatusDefined.JIAN_YI_BAN_JIE) {
				subInfo.setDocStatus(DbDocStatusDefined.JIAN_YI_BAN_JIE);
			}else {//如果最小状态值不小于建议办结的状态，说明本分支机构状态为最后一个办结的文，则将本分支局状态标示为办结，主文件也标示为办结
				DocumentInfo info = documentInfoService.queryObject(infoId);
				info.setStatus(2);
				documentInfoService.update(info);
				subInfo.setDocStatus(DbDocStatusDefined.BAN_JIE);
			}
			subDocInfoService.update(subInfo);
			json.put("result", "success");
		}else {
			json.put("result", "fail");
		}
		Response.json(json);
	}
	/**
	 * 常态落实操作：有一个分支局状态为常态落实则主文件为常态落实状态
	 * @param infoId 主文件id
	 */
	@ResponseBody
	@RequestMapping("/luoShiOperation")
	public void luoShiOperation(String infoId){
		JSONObject json= new JSONObject();
		if(StringUtils.isNotBlank(infoId)) {
			//主文件状态变为常态落实
			DocumentInfo info = documentInfoService.queryObject(infoId);
			info.setStatus(3);
			documentInfoService.update(info);
			//各分支文件变为常态落实
			subDocInfoService.updateDocStatus(DbDocStatusDefined.CHANG_TAI_LUO_SHI, infoId);
			json.put("result", "success");
		}else {
			json.put("result", "fail");
		}
		Response.json(json);
	}
	
	@ResponseBody
	@RequestMapping("/submitOperation")
	public void update(String subId ){
		Response.ok();
	}
}
