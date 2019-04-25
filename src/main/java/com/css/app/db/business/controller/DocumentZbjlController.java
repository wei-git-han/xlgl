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
import com.css.app.db.business.entity.DocumentInfo;
import com.css.app.db.business.entity.DocumentZbjl;
import com.css.app.db.business.entity.SubDocInfo;
import com.css.app.db.business.entity.SubDocTracking;
import com.css.app.db.business.service.DocumentInfoService;
import com.css.app.db.business.service.DocumentZbjlService;
import com.css.app.db.business.service.SubDocInfoService;
import com.css.app.db.business.service.SubDocTrackingService;
import com.css.app.db.util.DbDocStatusDefined;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.Response;
import com.css.base.utils.StringUtils;
import com.css.base.utils.UUIDUtils;


/**
 * 转办记录表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-18 16:39:37
 */
@Controller
@RequestMapping("/app/db/documentzbjl")
public class DocumentZbjlController {
	@Autowired
	private DocumentZbjlService documentZbjlService;
	@Autowired
	private SubDocInfoService subDocInfoService;
	@Autowired
	private BaseAppOrganService baseAppOrganService;
	@Autowired
	private BaseAppUserService baseAppUserService;
	@Autowired
	private DocumentInfoService documentInfoService;
	@Autowired
	private SubDocTrackingService subDocTrackingService;
	
	
	/**
	 * 转办记录
	 * @param infoId 主文件id
	 */
	@ResponseBody
	@RequestMapping("/list")
	public void list(String infoId){
		List<DocumentZbjl> zbjlList = null;
		if(StringUtils.isNotBlank(infoId)) {
			Map<String, Object> map = new HashMap<>();
			map.put("infoId", infoId);
			zbjlList = documentZbjlService.queryList(map);
		}
		Response.json(zbjlList);
	}
	
	
	/**
	 * 保存部转办信息
	 * @param infoId 主文件id
	 * @param deptIds 选中部门的ids
	 * @param deptNames 选中部门的名称
	 */
	@ResponseBody
	@RequestMapping("/save")
	public void save(String infoIds,String deptIds,String deptNames){
		JSONObject json =new JSONObject();
		if(StringUtils.isNotBlank(infoIds) && StringUtils.isNotBlank(deptIds)) {
			String[] ids = infoIds.split(",");
			//获取当前登录人信息
			String loginUserId=CurrentUser.getUserId();
			String loginUserName=CurrentUser.getUsername();
			String loginUserDeptId=CurrentUser.getDepartmentId();
			String loginUserDeptName=CurrentUser.getOrgName();
			for (String infoId : ids) {
				//时间取一个保证数据的统一
				Date date = new Date();
				//添加转办记录
				DocumentZbjl zbjl=new DocumentZbjl();
				zbjl.setId(UUIDUtils.random());
				zbjl.setInfoId(infoId);
				zbjl.setUserId(loginUserId);
				zbjl.setUserName(loginUserName);
				zbjl.setDeptId(loginUserDeptId);
				zbjl.setDeptName(loginUserDeptName);
				zbjl.setReceiverIds(deptIds);
				zbjl.setReceiverNames(deptNames);
				zbjl.setCreatedTime(date);
				documentZbjlService.save(zbjl);
				//第一次转办时间同步到主表
				DocumentInfo info = documentInfoService.queryObject(infoId);
				if(info != null) {
					info.setFirstZbTime(date);
					documentInfoService.update(info);
				}
				//添加子分支主记录,文件状态为待转办
				String[] deptArray = deptIds.split(",");
				for (String deptId : deptArray) {
					BaseAppOrgan organ = baseAppOrganService.queryObject(deptId);
					SubDocInfo subInfo=new SubDocInfo();
					subInfo.setId(UUIDUtils.random());
					subInfo.setInfoId(infoId);
					subInfo.setSubDeptId(deptId);
					if(organ !=null) {
						subInfo.setSubDeptName(organ.getName());
					}
					subInfo.setDocStatus(DbDocStatusDefined.DAI_ZHUAN_BAN);
					subInfo.setCreatedTime(date);
					subDocInfoService.save(subInfo);
				}
			}
			json.put("result", "success");
		}else {
			json.put("result", "fail");
		}		
		Response.json(json);
	}
	
	/**
	 * 局内转办
	 * @param infoId 主记录id
	 * @param subId 分支主id
	 * @param userId 转办接收人id
	 * @param userName 转办接收人
	 */
	@ResponseBody
	@RequestMapping("/subZbSave")
	public void subZbSave(String infoId,String subId,String userId,String userName) {
		JSONObject json=new JSONObject();
		if(StringUtils.isNotBlank(infoId) && StringUtils.isNotBlank(subId)) {
			//获取当前登录人信息
			String loginUserId=CurrentUser.getUserId();
			String loginUserName=CurrentUser.getUsername();
			String loginUserDeptId=CurrentUser.getDepartmentId();
			String loginUserDeptName=CurrentUser.getOrgName();
			//添加转办记录
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
			DocumentZbjl zbjl=new DocumentZbjl();
			zbjl.setId(UUIDUtils.random());
			zbjl.setInfoId(infoId);
			zbjl.setUserId(loginUserId);
			zbjl.setUserName(loginUserName);
			zbjl.setDeptId(loginUserDeptId);
			zbjl.setDeptName(loginUserDeptName);
			zbjl.setReceiverIds(userId);
			zbjl.setReceiverNames(userName);
			zbjl.setReceiverDeptId(deptId);
			zbjl.setReceiverDeptName(deptName);
			zbjl.setCreatedTime(new Date());
			documentZbjlService.save(zbjl);
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
			tracking.setTrackingType("1");
			tracking.setCreatedTime(new Date());
			subDocTrackingService.save(tracking);
			//改变文件状态 ，文件状态为待落实
			SubDocInfo subInfo = subDocInfoService.queryObject(subId);
			if(subInfo != null) {
				subInfo.setDocStatus(DbDocStatusDefined.DAI_LUO_SHI);
				subDocInfoService.update(subInfo);
			}
			json.put("result", "success");
		}else {
			json.put("result", "fail");
		}
		Response.json(json);
	}
}
