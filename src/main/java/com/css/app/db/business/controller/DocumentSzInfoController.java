package com.css.app.db.business.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.css.addbase.apporgan.entity.BaseAppOrgan;
import com.css.addbase.apporgan.service.BaseAppOrganService;
import com.css.addbase.msg.MSGTipDefined;
import com.css.addbase.msg.MsgTipUtil;
import com.css.addbase.msg.entity.MsgTip;
import com.css.addbase.msg.service.MsgTipService;
import com.css.app.db.business.entity.DocumentCbjl;
import com.css.app.db.business.entity.DocumentInfo;
import com.css.app.db.business.entity.SubDocInfo;
import com.css.app.db.business.service.DocumentCbjlService;
import com.css.app.db.business.service.DocumentInfoService;
import com.css.app.db.business.service.SubDocInfoService;
import com.css.app.db.config.entity.RoleSet;
import com.css.app.db.config.service.RoleSetService;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.Response;

import dm.jdbc.util.StringUtil;

/**
 * 督办基本信息表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-18 16:34:38
 */
@Controller
@RequestMapping("/app/db/documentszinfo")
public class DocumentSzInfoController {
	@Autowired
	private DocumentInfoService documentInfoService;
	@Autowired
	private DocumentCbjlService documentCbjlService;
	@Autowired
	private RoleSetService roleSetService;
	@Autowired
	private BaseAppOrganService baseAppOrganService;
	@Autowired
	private SubDocInfoService subDocInfoService;
	@Autowired
	private MsgTipService msgService;
	@Autowired
	private MsgTipUtil msgUtil;
	@Value("${csse.dccb.appId}")
	private  String appId;	
	@Value("${csse.dccb.appSecret}")
	private  String clientSecret;
	/**
	 * 首长左侧类型分组
	 * [
	{"id":"01","name":"军委主席重要批示","count":"10"},
	{"id":"02","name":"军委主席重要批示","count":"10"},
	{"id":"03","name":"军委主席重要批示","count":"10"}
]

	 */
	@ResponseBody
	@RequestMapping("/grouplist")
	public void grouplist(String search){
		String userid=CurrentUser.getUserId();
		Map<String, Object> map = new HashMap<>();
		map.put("search", search);
		map.put("status2", "0");
		map.put("latestreply", "0");
		map.put("isnotuserid", userid);
		List<Map<String, Object>> infoList = documentInfoService.queryListByDicType(map);
		JSONArray valdata=new JSONArray();
		if (infoList!=null&&infoList.size()>0) {
			for (Map<String, Object> map2 : infoList) {
				JSONObject jo=new JSONObject();
				jo.put("name", (String) map2.get("name"));
				jo.put("count", (long) map2.get("num"));
				jo.put("id", (String)map2.get("TYPE"));
				valdata.add(jo);
				
			}
		}
		//jo2.put("valdata", valdata);
		Response.json(valdata);
	}
	
	
	/**
	 * 列表查询
	 * type//属于六大指标的类型
	 * orgid//单位id
	 * 
	 * 
	 * "total":100,
		"page":1,
		"rows":[       
					{
						"id":"01",
						"blzt":"0",
						"jwbjh":"【2019】办01",
						"title":"关于十九大讲话的学习安排的报告",
						"pszsmr":"此文件十分重要，需要在5月份前办理完成，希望一处主办。",
						"dblsqk":"此文件十分重要，需要在5月份前办理完成，希望一处主办。",
						"cbdwry":"计划局/李丽(3716688)",
						"update":"2018-4-10 12:00",
						"zbdate":"2018-4-10 12:00",
						"other":0
					}]
	 * 
	 */
	@ResponseBody
	@RequestMapping("/list")
	public void list(Integer page, Integer pagesize,String search,String type,String orgid){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String userid=CurrentUser.getUserId();
		Map<String, Object> map = new HashMap<>();
		map.put("offset", ((page - 1) * pagesize));
		map.put("limit", pagesize);
		
		
		map.put("search", search);
		map.put("docStatus", "2");
		map.put("type", type);
		map.put("orgid", orgid);
		//PageHelper.startPage(page, pagesize);
		List<DocumentInfo> infoList = documentInfoService.queryList(map);
		map.remove("offset");
		map.remove("limit");
		JSONObject jo=new JSONObject();
		JSONArray ja=new JSONArray();
		for (DocumentInfo documentInfo : infoList) {
			jo=new JSONObject();
			jo.put("id", documentInfo.getId());
			jo.put("blzt", documentInfo.getStatus());
			jo.put("jwbjh", documentInfo.getBanjianNumber());
			jo.put("title", documentInfo.getDocTitle());
			jo.put("pszsmr",documentInfo.getJobContent() );
			jo.put("dblsqk","" );
			jo.put("cbdwry","" );
			jo.put("update",sdf.format(documentInfo.getCreatedTime()) );
			jo.put("zbdate",sdf.format(documentInfo.getCreatedTime()) );
			String sz=documentInfo.getSzReadIds();
			if(StringUtils.isEmpty(sz)||!(sz).contains(userid)) {
				jo.put("other","0");
			}else {				
				jo.put("other","1");
			}
			ja.add(jo);
		}
		infoList = documentInfoService.queryList(map);
		JSONObject jo2=new JSONObject();
		jo2.put("total",infoList==null?0:infoList.size());
		jo2.put("page",page);
		jo2.put("rows",ja);
		//GwPageUtils pageUtil = new GwPageUtils(infoList);
		Response.json(jo2);
	}
	
	/**
	 * 列表查询
	 * "total":100,
		"page":1,
		"rows":[       
					{
						"id":"01",
						"blzt":"0",
						"jwbjh":"【2019】办01",
						"title":"关于十九大讲话的学习安排的报告",
						"pszsmr":"此文件十分重要，需要在5月份前办理完成，希望一处主办。",
						"dblsqk":"此文件十分重要，需要在5月份前办理完成，希望一处主办。",
						"cbdwry":"计划局/李丽(3716688)",
						"update":"2018-4-10 12:00",
						"zbdate":"2018-4-10 12:00",
						"other":0,
						"miji":"绝密",
						"tbdw":"JWZBFZBXXX",
						"tbrq":"2019年1月29日",
						"array":[
                    					{
                    						"dw":"信息局",
                    						"ry":"张参谋",
                    						"cont":"一切顺利，初期、中期已经完成。一切顺利，初期、中期已经完成。"
                    					},
                    					{
                    						"dw":"信息局",
                    						"ry":"张参谋",
                    						"cont":"一切顺利，初期、中期已经完成。一切顺利，初期、中期已经完成。"
                    					}
                    	]

					}
					id为类型
	 */
	@ResponseBody
	@RequestMapping("/homelist")
	public void homelist(Integer page, Integer pagesize,String search,String id ,String state,String month,String year,String orgid,String isMain,String sorttype){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		//SimpleDateFormat sdf2=new SimpleDateFormat("yyyy年MM月dd日");
		SimpleDateFormat sdf3=new SimpleDateFormat("yyyy");
		String userid=CurrentUser.getUserId();
		JSONObject jo2=new JSONObject();
		Map<String, Object> map = new HashMap<>();
		map.put("search", search);
		map.put("docStatus", "2");
		map.put("jz", "1");
		map.put("type", id);
		if(StringUtils.isNotBlank(state)) {
			if("0".equals(state)) {
				
				map.put("state2", "0");
				map.put("latestreply", "0");
				map.put("isnotuserid", userid);
			}else {
				map.put("state", state);
			}
		}
		if(StringUtil.isEmpty(isMain)&&StringUtil.isEmpty(year)) {
			int mon=Calendar.MONTH+1;
			year=sdf3.format(new Date());
			if(StringUtil.isEmpty(month)) {				
				year+="-"+(mon<10?"0"+mon:mon+"");
			}else if(!StringUtil.equals("all", month)){
				year+="-"+month;
			}
		}
		map.put("orgid", orgid);
		map.put("year", year);
		map.put("sorttype", sorttype);
		//PageHelper.startPage(page, pagesize);
		map.put("offset", ((page - 1) * pagesize));
		map.put("limit", pagesize);
		List<DocumentInfo> infoList = documentInfoService.queryList(map);
		
		
		map.remove("offset");
		map.remove("limit");
		List<DocumentInfo> infoallList = documentInfoService.queryList(map);
		JSONObject numjo=new JSONObject();
		if(StringUtils.isNotBlank(id)) {
			
			map = new HashMap<>();
			map.put("type", id);
			List<Map<String, Object>> infoMap = documentInfoService.queryListByDicStutas(map);
			long blz=0;
			long bj=0;
			long ctls=0;
			if (infoMap!=null&&infoMap.size()>0) {
				for (Map<String, Object> map2 : infoMap) {
					blz+=(long) map2.get("blz");
					bj+=(long) map2.get("bj");
					ctls+=(long) map2.get("ctls");
					
				}
				jo2.put("count2", blz);
				jo2.put("count3", bj);
				jo2.put("count4", ctls);
			}
			map.put("search", search);
			map.put("isnotuserid", userid);
			map.put("status2", "0");
			map.put("latestreply", "0");
			List<Map<String, Object>> genxinList = documentInfoService.queryListByDicType(map);
			if (genxinList!=null&&genxinList.size()>0) {
				for (Map<String, Object> map2 : genxinList) {
					jo2.put("count5", (long) map2.get("num"));
					
				}
			}
		}
		
		
	
		JSONObject jo=new JSONObject();
		JSONArray ja=new JSONArray();
		Map<String, Object> danweimap = new HashMap<>();
		for (DocumentInfo documentInfo : infoList) {
			jo=new JSONObject();
			jo.put("id", documentInfo.getId());
			jo.put("blzt", documentInfo.getStatus());
			jo.put("jwbjh", documentInfo.getBanjianNumber());
			jo.put("title", documentInfo.getDocTitle());
			String sz=documentInfo.getSzReadIds();
			if(StringUtils.isNotBlank(documentInfo.getLeaderName())) {
				jo.put("pszsmr", documentInfo.getLeaderName()+":" +documentInfo.getLeaderContent() +" " +(documentInfo.getLeaderTime()==null?"":documentInfo.getLeaderTime()));
				//jo.put("pszsmr", "");				
			}else {
				jo.put("pszsmr", "");				
			}
			//szpsCont=rowdata.leaderName+":"+rowdata.leaderContent+" "+rowdata.leaderTime.substring(0,16)
			
			if(documentInfo.getFirstZbTime()!=null) {				
				jo.put("update",sdf.format(documentInfo.getFirstZbTime()) );
			}else {
				jo.put("update","");				
			}
			if(documentInfo.getLatestReplyTime()!=null) {				
				jo.put("zbdate",sdf.format(documentInfo.getLatestReplyTime()) );
			}else {
				jo.put("zbdate","");								
			}
			
			//jo.put("other","1");
			String CuibanFlag=documentInfo.getCuibanFlag();
			jo.put("CuibanFlag",CuibanFlag );//是否催办    1显示      0不显示
			//other为0时显示确认已读按钮;1时显示催办按钮,2时都不显示
			if(documentInfo.getStatus()>1) {//已办结,或落实常态(已经结束)
				jo.put("other","2");//不显示催办和是否已读按钮
				//jo.put("other","1" );//是否催办    1显示      0不显示
				jo.put("CuibanFlag","0" );//是否催办    1显示      0不显示
			}else if(StringUtils.isBlank(documentInfo.getLatestReply())&&StringUtils.equals("0", documentInfo.getCuibanFlag())){//无局长意见也无催办操作时,显示催办按钮
				jo.put("other","1");//显示催办按钮
			}else if(StringUtils.isBlank(documentInfo.getLatestReply())&&StringUtils.equals("1", documentInfo.getCuibanFlag())){//无局长意见有催办操作时,显示催办按钮
				jo.put("other","2");//不显示催办和确认按钮
			}else {//办理中   有局长意见
				if(StringUtils.isEmpty(sz)||!(sz).contains(userid)) {
					jo.put("other","0");//确认已读按钮显示
				}else if(StringUtils.equals("0", documentInfo.getCuibanFlag())){//显示催办按钮				
					jo.put("other","1");
				}else {
					jo.put("other","2");//被催办,并且已读(不显示催办和确认按钮)				
				}
			}
			
			
			//单位意见
			danweimap = new HashMap<>();
			danweimap.put("infoId",documentInfo.getId());
			JSONArray yijianja=new JSONArray();
			JSONObject yijianjo=new JSONObject();
			//查询列表数据
			String gengxin="0";
			String cbdw=documentInfo.getLatestSubDept()==null?"":documentInfo.getLatestSubDept();
			String cbry=documentInfo.getLatestUndertaker()==null?"":documentInfo.getLatestUndertaker();
			String cont=documentInfo.getLatestReply()==null?"":documentInfo.getLatestReply();
			
			//LATEST_REPLY
			if((StringUtils.isEmpty(sz)||!(sz).contains(userid))&&StringUtils.isNotBlank(cont)) {//有局长审批意见,但sz不包含该首长userid,显示已更新
				gengxin="1";//已更新显示
			}
			
			
			jo.put("gengxin",gengxin);//已更新显示
			jo.put("dblsqk",StringUtils.isBlank(cont)?"":cont);
			if("".equals(cbdw)) {
				jo.put("cbdwry","");
				yijianjo.put("dw","");
				yijianjo.put("ry", "");
				yijianjo.put("cont", "");
				yijianjo.put("dwry", "");
				yijianja.add(yijianjo);
			}else {
				//${dw}-${ry}
				cbdw=StringUtils.isBlank(cbdw)?"":cbdw;
				cbry=StringUtils.isBlank(cbry)?"":cbry;
				yijianjo.put("dw",cbdw);
				yijianjo.put("ry", cbry);
				yijianjo.put("cont", StringUtils.isBlank(cont)?"":cont);
				yijianjo.put("dwry", StringUtils.isBlank(cbdw)?"":cbdw+"-"+cbry+":");
				yijianja.add(yijianjo);
				jo.put("cbdwry",StringUtils.isBlank(cbdw)?"":(cbdw+"/"+cbry));	
				
			}
			
			
			jo.put("array",yijianja);//
			jo.put("miji",documentInfo.getSecurityClassification());
			jo.put("tbdw","新增");
			jo.put("tbrq",sdf.format(documentInfo.getFirstZbTime()));
			ja.add(jo);
		}
		
		
		jo2.put("total",infoallList==null?0:infoallList.size());
		jo2.put("page",page);
		jo2.put("rows",ja);
		jo2.put("num",numjo);
		//GwPageUtils pageUtil = new GwPageUtils(infoList);
		//Response.json(pageUtil);
		Response.json(jo2);
	}
	
	/**
	 * 首长已读按钮
	 */
	@ResponseBody
	@RequestMapping("/read")
	public void read(String ids){
		String ids_[]=ids.split(",");
		for (String id : ids_) {
			DocumentInfo info=documentInfoService.queryObject(id);
			String szreadids=info.getSzReadIds();
			if(StringUtils.isBlank(szreadids)) {
				info.setSzReadIds(CurrentUser.getUserId());
			}else {
				info.setSzReadIds(szreadids+","+CurrentUser.getUserId());				
			}
			documentInfoService.update(info);
		}
		
		
		Response.json("result", "success");
	}
	/**
	 * 首长已读按钮
	 */
	@ResponseBody
	@RequestMapping("/AllreadByType")
	public void AllreadByType(String menuid){
		String userid=CurrentUser.getUserId();
		if(StringUtils.isNotBlank(menuid)) {
			Map<String, Object> map = new HashMap<>();
			map.put("docStatus", "2");
			map.put("type", menuid);
			map.put("isnotuserid", userid);
			//PageHelper.startPage(page, pagesize);
			List<DocumentInfo> infoList = documentInfoService.queryList(map);
			for (DocumentInfo info : infoList) {
				String szreadids=info.getSzReadIds();
				if(StringUtils.isBlank(szreadids)) {
					info.setSzReadIds(userid);
				}else if(!szreadids.contains(userid)){
					info.setSzReadIds(szreadids+","+userid);				
				}
				documentInfoService.update(info);
			}
			
			
			
		}
		Response.json("result", "success");
	}
	
	/**
	 * 首长催办按钮
	 */
	@ResponseBody
	@RequestMapping("/press")
	public void press(String id,String textarea){
		String userid=CurrentUser.getUserId();
		DocumentInfo info=documentInfoService.queryObject(id);
		info.setCuibanFlag("1");//首长催办
		String szreadids=info.getSzReadIds();
		if(StringUtils.isBlank(szreadids)) {
			info.setSzReadIds(userid);
		}else if(!szreadids.contains(userid)){
			info.setSzReadIds(szreadids+","+userid);				
		}
		
		documentInfoService.update(info);
		//保存催办历史
		DocumentCbjl cb=new DocumentCbjl();
		cb.setUrgeContent(textarea);
		cb.setInfoId(id);
		documentCbjlService.save(cb);
		// 发送消息提醒
		Map<String, Object> map=new HashMap<>();
		map.put("infoId", id);
		List<SubDocInfo> subInfos = subDocInfoService.queryAllSubInfo(map);
		if(subInfos!=null && subInfos.size()>0) {
			for (SubDocInfo subDocInfo : subInfos) {
				String userId=subDocInfo.getUndertaker();
				if(StringUtils.isNotBlank(userId)) {
					MsgTip msg = msgService.queryObject(MSGTipDefined.DCCB_CUIBAN_MSG_TITLE);
					if (msg != null) {
						String msgUrl = msg.getMsgRedirect()+"&fileId="+id+"&subId="+subDocInfo.getId();
						msgUtil.sendMsg(msg.getMsgTitle(), msg.getMsgContent(), msgUrl, userId, appId,clientSecret, msg.getGroupName(), msg.getGroupRedirect(), "","true");
					}
				}
			}
		}
		Response.json("result", "success");
	}
	
	/**
	 * 获取当前登录人信息(角色)
	 */
	@ResponseBody
	@RequestMapping("/getRoleType")
	public void getRoleType() {
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
			roleType = roleList.get(0).getRoleFlag();
		}
		BaseAppOrgan org = baseAppOrganService.queryObject(CurrentUser.getDepartmentId());
		if(org != null){
			String[] pathArr = org.getTreePath().split(",");
			if(pathArr.length > 2){
				orgid= pathArr[2];
			} 
		}
		jo.put("roleType", roleType);
		jo.put("orgid", orgid);
		Response.json(jo);
	}
}
