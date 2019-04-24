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
import com.css.addbase.apporgan.service.BaseAppOrganService;
import com.css.app.db.business.entity.DocumentInfo;
import com.css.app.db.business.entity.DocumentZbjl;
import com.css.app.db.business.entity.SubDocInfo;
import com.css.app.db.business.service.DocumentInfoService;
import com.css.app.db.business.service.DocumentZbjlService;
import com.css.app.db.business.service.SubDocInfoService;
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
	private DocumentInfoService documentInfoService;
	/**
	 * 列表
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
	 * 保存转办信息
	 * @param infoId 主文件id
	 * @param deptIds 选中部门的ids
	 * @param deptNames 选中部门的名称
	 */
	@ResponseBody
	@RequestMapping("/save")
	public void save(String infoId,String deptIds,String deptNames){
		JSONObject json =new JSONObject();
		if(StringUtils.isNotBlank(infoId) && StringUtils.isNotBlank(deptIds)) {
			//获取当前登录人信息
			String loginUserId=CurrentUser.getUserId();
			String loginUserName=CurrentUser.getUsername();
			String loginUserDeptId=CurrentUser.getDepartmentId();
			String loginUserDeptName=CurrentUser.getOrgName();
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
			//添加子分支主记录
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
			json.put("result", "success");
		}else {
			json.put("result", "fail");
		}		
		Response.json(json);
	}	
}
