package com.css.app.db.business.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.css.addbase.AppConfig;
import com.css.addbase.appconfig.entity.BaseAppConfig;
import com.css.addbase.appconfig.service.BaseAppConfigService;
import com.css.addbase.apporgan.entity.BaseAppOrgan;
import com.css.addbase.apporgan.entity.BaseAppUser;
import com.css.addbase.apporgan.service.BaseAppOrganService;
import com.css.addbase.constant.AppConstant;
import com.css.app.db.business.service.DocumentFileService;
import com.css.app.db.business.service.DocumentInfoService;
import com.css.app.db.config.entity.RoleSet;
import com.css.app.db.config.service.RoleSetService;
import com.css.app.db.util.DbDefined;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.GwPageUtils;
import com.css.base.utils.Response;
import com.css.base.utils.StringUtils;

import dm.jdbc.util.StringUtil;



/**
 * 督办基本信息表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-18 16:34:38
 */
@Controller
@RequestMapping("/app/db/documentjcdb")
public class DocumentJcdbController {
	@Autowired
	private AppConfig appConfig;
	@Autowired
	private DocumentInfoService documentInfoService;
	@Autowired
	private DocumentFileService documentFileService;
	@Autowired
	private RoleSetService roleSetService;
	@Autowired
	private BaseAppOrganService baseAppOrganService;
	@Autowired
	private BaseAppConfigService baseAppConfigService;
	
	
	
	/**
	 * 数据统计报表-(年度,状态数量)
	 * {
		年度"year":"2019",
		总数"total":100,
		办理中"blz":100,
		办结"bj":100,
		常态落实"ctls":100,
		完成率"wcl":"98%"
}
	 */
	@ResponseBody
	@RequestMapping("/list")
	public void list(String year){
		JSONObject jo=new JSONObject();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		Map<String, Object> map = new HashMap<>();
		if(StringUtil.isEmpty(year)) {
			year=sdf.format(new Date());
		}
		map.put("year", year);
		List<Map<String, Object>> infoList = documentInfoService.queryListByYear(map);
		long  blz=0;
		long  bj=0;
		long  ctls=0;
		long  total=0;
		// sum(blz+bj+ctls) as total,sum(blz) as blz,sum(bj) as bj,sum(ctls) as ctls 
		if (infoList!=null&&infoList.size()>0) {
			Map<String, Object> map2=infoList.get(0);
			blz= (long) map2.get("blz");
			bj= (long) map2.get("bj");
			ctls= (long) map2.get("ctls");
			total= (long) map2.get("total");
		}
		
		jo.put("blz", blz);
		jo.put("bj", bj);
		jo.put("ctls", ctls);
		jo.put("total", total);
		jo.put("year", year);
		if(total>0) {
			jo.put("wcl", (bj+ctls)*100/total+"%");
		}else {
			jo.put("wcl", "0%");
		}
		Response.json(jo);
	}
	
	/**
	 * 数据统计报表-(年度,状态数量)
	 * {"id":"01","dwname":"办公厅","blz":"100","bj":"101","ctls":"102"},
	{"id":"02","dwname":"办公厅","blz":"100","bj":"101","ctls":"102"},
	{"id":"03","dwname":"办公厅","blz":"100","bj":"101","ctls":"102"},
	{"id":"04","dwname":"办公厅","blz":"100","bj":"101","ctls":"102"},
	{"id":"05","dwname":"办公厅","blz":"100","bj":"101","ctls":"102"}
	
		public String getRoleType() {
		//当前登录人的角色
		//角色标识（1：首长；2：首长秘书；3：局长；4：局秘书；5：处长；6：参谋;）
		 * 
	d.SUB_DEPT_ID,d.SUB_DEPT_NAME,sum(blz) as blz,sum(bj) as bj,sum(ctls) as ctls
	 */
	@ResponseBody
	@RequestMapping("/orglist")
	public void orglist(String year,String month){
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		Map<String, Object> map = new HashMap<>();
		if(StringUtil.isEmpty(year)) {
			int mon=Calendar.MONTH+1;
			year=sdf.format(new Date());
			if(StringUtil.isEmpty(month)) {				
				year+="-"+(mon<10?"0"+month:month+"");
			}else if(!StringUtil.equals("all", month)){
				year+="-"+month;
			}
		}
		map.put("year", year);
		List<Map<String, Object>> infoList = documentInfoService.queryListByOrgYear(map);
		String role=getRoleType();
		String orgid="";
		if(!"1".equals(role)&&!"2".equals(role)) {
			BaseAppOrgan org = baseAppOrganService.queryObject(CurrentUser.getDepartmentId());
			if(org != null){
				String[] pathArr = org.getTreePath().split(",");
				if(pathArr.length > 2){
					orgid= pathArr[2];
				} 
			}
		}
		String szorgid=getSzOrgid();
		//blz= (int) map2.get("blz");
		JSONArray ja=new JSONArray();
		if (infoList!=null&&infoList.size()>0) {
			for (Map<String, Object> map2 : infoList) {
				String danweiid=(String) map2.get("ID");
				JSONObject jo=new JSONObject();
				jo.put("blz", (long) map2.get("blz"));
				jo.put("bj", (long) map2.get("bj"));
				jo.put("ctls", (long) map2.get("ctls"));
				jo.put("id",danweiid);
				jo.put("dwname", (String) map2.get("dwname"));
				
				if("1".equals(role)) {//首长
					jo.put("state", "1");//点击所有单位
					jo.put("type", "1");
				}else {
					if("2".equals(role)) {//部管理员
						jo.put("state", "1");//点击所有单位
					}else {
						if(orgid.equals(danweiid)) {//局
							jo.put("state", "1");//该局的数据
						}else {
							jo.put("state", "0");
						}
					}
					jo.put("type", "0");
				}
				//state
				if(!StringUtils.equals(szorgid, danweiid)) {
					ja.add(jo);
				}
				
			}
		}
		
		
		
		
		Response.json(ja);
	}
	/**
	 * {
	"legend":["办理中","办结","常态落实"],
	"xdata":["办公厅","计划局","科定局","系统局","鉴定局","监管局","装备合作","政工","921","项目管理中心"],
	"blzdata":[2, 4, 7, 23, 25, 76, 135, 162, 32, 20],
	"bjdata":[2, 5, 9, 26, 28, 70, 175, 182, 48, 18],
	"ctlsdata":[2, 5, 9, 26, 28, 70, 175, 182, 48, 18]
	
	
	
	"otherdata":{
		"部首长":{
			"blz":{"type":"","id":"","month":""},
			"bj":{"type":"","id":"","month":""},
			"ctls":{"type":"","id":"","month":""}
		},
		"办公厅":{
			"blz":{"type":"","id":"","month":""},
			"bj":{"type":"","id":"","month":""},
			"ctls":{"type":"","id":"","month":""}
		}
	
	
	
	
	
	
	
}
	 */
	@ResponseBody
	@RequestMapping("/orglist2")
	public void orglist2(String year){
		JSONObject jo2=new JSONObject();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		Map<String, Object> map = new HashMap<>();
		if(StringUtil.isEmpty(year)) {
			year=sdf.format(new Date());
		}
		map.put("year", year);
		List<Map<String, Object>> infoList = documentInfoService.queryListByOrgYear(map);
		JSONArray xdata=new JSONArray();
		JSONArray blzdata=new JSONArray();
		JSONArray bjdata=new JSONArray();
		JSONArray ctlsdata=new JSONArray();
		JSONArray legend=new JSONArray();
		JSONArray otherdata=new JSONArray();
		JSONObject jo=new JSONObject();
		JSONObject jo3=new JSONObject();
		String role=getRoleType();
		String orgid="";
		String month="all";
		if(!"1".equals(role)&&!"2".equals(role)) {
			BaseAppOrgan org = baseAppOrganService.queryObject(CurrentUser.getDepartmentId());
			if(org != null){
				String[] pathArr = org.getTreePath().split(",");
				if(pathArr.length > 2){
					orgid= pathArr[2];
				} 
			}
		}
		String szorgid=getSzOrgid();
		if (infoList!=null&&infoList.size()>0) {
			for (Map<String, Object> map2 : infoList) {
				String danweiid=(String) map2.get("ID");
				//授权--------strat
				jo=new JSONObject();
				jo.put("id",danweiid);
				jo.put("month",month);
				if("1".equals(role)) {//首长
					jo.put("state", "1");//点击所有单位
					jo.put("type", "1");
				}else {
					if("2".equals(role)) {//部管理员
						jo.put("state", "1");//点击所有单位
					}else {
						if(orgid.equals(danweiid)) {//局
							jo.put("state", "1");//该局的数据
						}else {
							jo.put("state", "0");
						}
					}
					jo.put("type", "0");
				}
				if(!StringUtils.equals(szorgid, danweiid)) {
					jo3.put((String) map2.get("dwname"), jo);
					//授权--------end
					//otherdata.add(jo);
					xdata.add((String) map2.get("dwname"));
					blzdata.add((long) map2.get("blz"));
					bjdata.add((long) map2.get("bj"));
					ctlsdata.add((long) map2.get("ctls"));
				}
				
			}
		}
		legend.add("办理中");
		legend.add("办结");
		legend.add("常态落实");
		jo2.put("legend",legend);
		jo2.put("xdata", xdata);
		jo2.put("blzdata", blzdata);
		jo2.put("bjdata", bjdata);
		jo2.put("ctlsdata", ctlsdata);
		jo2.put("otherdata", jo3);
		
		
		
		Response.json(jo2);
	}
	//documentDicService.queryDicByType(DbDicTypeDefined.DOCUMENT_TYPE)
	/**
	 * {
	{
	"legend":["JW主席批示指示","党,军,国务院决策部署","其他重要工作","JW首长批示指示","ZBFZB重要工作分工","ZBFZB领导批示指示"],
	"valdata":[
	    {"value":10, "name":"JW主席批示指示"},
	    {"value":20, "name":"党,军,国务院决策部署"},
	    {"value":30, "name":"其他重要工作"},
	    {"value":20, "name":"JW首长批示指示"},
	    {"value":10, "name":"ZBFZB重要工作分工"},
	    {"value":10, "name":"ZBFZB领导批示指示"}
	]
}
}
	 */
	@ResponseBody
	@RequestMapping("/orglist3")
	public void orglist3(String year){
		JSONObject jo2=new JSONObject();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		Map<String, Object> map = new HashMap<>();
		if(StringUtil.isEmpty(year)) {
			year=sdf.format(new Date());
		}
		map.put("year", year);
		List<Map<String, Object>> infoList = documentInfoService.queryListByDicType(map);
		JSONArray valdata=new JSONArray();
		JSONArray legend=new JSONArray();
		if (infoList!=null&&infoList.size()>0) {
			for (Map<String, Object> map2 : infoList) {
				JSONObject jo=new JSONObject();
				String name=(String) map2.get("name");
				jo.put("name", name);
				jo.put("value", (long) map2.get("num"));
				legend.add(name);
				valdata.add(jo);
				
			}
		}
		jo2.put("legend", legend);
		jo2.put("valdata", valdata);
		Response.json(jo2);
	}
	/**
	 * {
	"xdata":["JW主席批示指示","JW首长批示指示","党,军,国务院决策部署","ZBFZB重要工作分工","其他重要工作","ZBFZB领导批示指示"],
	"wcldata":[10,4,7,23,25,76]
}
	 * @param year
	 */
	@ResponseBody
	@RequestMapping("/orglist4")
	public void orglist4(String year){
		JSONObject jo2=new JSONObject();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		Map<String, Object> map = new HashMap<>();
		if(StringUtil.isEmpty(year)) {
			year=sdf.format(new Date());
		}
		map.put("year", year);
		List<Map<String, Object>> infoList = documentInfoService.queryListByDicStu(map);
		JSONArray wcldata=new JSONArray();
		JSONArray xdata=new JSONArray();
		if (infoList!=null&&infoList.size()>0) {
			for (Map<String, Object> map2 : infoList) {
				JSONObject jo=new JSONObject();
				String name=(String) map2.get("name");
				long bj=(long) map2.get("bj");
				long total=(long) map2.get("total");
				xdata.add(name);
				if(total>0) {					
					wcldata.add((bj*100/total));
				}else {					
					wcldata.add(0);
				}
				
			}
		}
		jo2.put("xdata", xdata);
		jo2.put("wcldata", wcldata);
		Response.json(jo2);
	}
	
	public String getRoleType() {
		//当前登录人的角色
		//角色标识（1：首长；2：首长秘书；3：局长；4：局秘书；5：处长；6：参谋;）
		JSONObject jo=new JSONObject();
		Map<String, Object> roleMap = new HashMap<>();
		String userid=CurrentUser.getUserId();
		roleMap.put("userId",userid);
		List<RoleSet> roleList = roleSetService.queryList(roleMap);
		String roleType="";
		String orgid="";
		if(roleList != null && roleList.size()>0) {
			return roleType = roleList.get(0).getRoleFlag();
		}
		return "";
		/*BaseAppOrgan org = baseAppOrganService.queryObject(CurrentUser.getDepartmentId());
		if(org != null){
			String[] pathArr = org.getTreePath().split(",");
			if(pathArr.length > 2){
				orgid= pathArr[2];
			} 
		}
		jo.put("roleType", roleType);
		jo.put("orgid", orgid);
		Response.json(jo);*/
	}
	public String getSzOrgid() {
		BaseAppConfig mapped = baseAppConfigService.queryObject(AppConstant.LEAD_TEAM);
		if(mapped != null && StringUtils.isNotBlank(mapped.getValue())){
			return mapped.getValue();
		}
		return "";
	}
}
