package com.css.app.db.business.controller;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.css.addbase.AppConfig;
import com.css.addbase.FileBaseUtil;
import com.css.addbase.appconfig.entity.BaseAppConfig;
import com.css.addbase.appconfig.service.BaseAppConfigService;
import com.css.addbase.apporgan.service.BaseAppUserService;
import com.css.addbase.constant.AppConstant;
import com.css.addbase.suwell.OfdTransferUtil;
import com.css.app.db.business.entity.DocumentBjjl;
import com.css.app.db.business.entity.DocumentCbjl;
import com.css.app.db.business.entity.DocumentFile;
import com.css.app.db.business.entity.DocumentInfo;
import com.css.app.db.business.entity.DocumentRead;
import com.css.app.db.business.entity.SubDocInfo;
import com.css.app.db.business.entity.SubDocTracking;
import com.css.app.db.business.service.DocumentBjjlService;
import com.css.app.db.business.service.DocumentCbjlService;
import com.css.app.db.business.service.DocumentFileService;
import com.css.app.db.business.service.DocumentInfoService;
import com.css.app.db.business.service.DocumentReadService;
import com.css.app.db.business.service.DocumentSzpsService;
import com.css.app.db.business.service.SubDocInfoService;
import com.css.app.db.business.service.SubDocTrackingService;
import com.css.app.db.config.entity.AdminSet;
import com.css.app.db.config.entity.DocumentDic;
import com.css.app.db.config.entity.RoleSet;
import com.css.app.db.config.service.AdminSetService;
import com.css.app.db.config.service.RoleSetService;
import com.css.app.db.util.DbDefined;
import com.css.app.db.util.DbDocStatusDefined;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.GwPageUtils;
import com.css.base.utils.Response;
import com.css.base.utils.UUIDUtils;
import com.github.pagehelper.PageHelper;

import cn.com.css.filestore.impl.HTTPFile;
import dm.jdbc.util.StringUtil;


/**
 * 督办基本信息表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-18 16:34:38
 */
@Controller
@RequestMapping("/app/db/documentinfo")
public class DocumentInfoController {
	@Autowired
	private AppConfig appConfig;
	@Autowired
	private DocumentInfoService documentInfoService;
	@Autowired
	private DocumentFileService documentFileService;
	@Autowired
	private AdminSetService adminSetService;
	@Autowired
	private RoleSetService roleSetService;
	@Autowired
	private BaseAppUserService baseAppUserService;
	@Autowired
	private DocumentCbjlService documentCbjlService;
	@Autowired
	private DocumentBjjlService documentBjjlService;
	@Autowired
	private SubDocTrackingService subDocTrackingService;
	@Autowired
	private SubDocInfoService subDocInfoService;
	@Autowired
	private DocumentReadService documentReadService;
	@Autowired
	private DocumentSzpsService documentSzpsService;
	@Autowired
	private BaseAppConfigService baseAppConfigService;
	
	
	/**
	 * 文件上传保存
	 * @param idpdf 主记录id(documentInfo的id)
	 * @param pdf 文件
	 */
	@ResponseBody
	@RequestMapping("/uploadFile")
	public void savePDF(String idpdf,@RequestParam(required = false) MultipartFile[] pdf){
			String formatDownPath = "";//版式文件下载路径
			String retFormatId = null;//返回的版式文件id
			String streamId = null;//流式文件id
			String formatId  = null;//版式文件id
			JSONObject json = new JSONObject();
			if(StringUtils.isNotBlank(idpdf)) {				
				if (pdf != null && pdf.length > 0) {
					for (int i = 0; i < pdf.length; i++) {
						String fileName=pdf[i].getOriginalFilename();
						//获取文件后缀
						String fileType =fileName.substring(fileName.lastIndexOf(".")+1);
						//如果文件是流式则流式转换为版式
						if(!StringUtils.equals("ofd", fileType)){
							streamId = FileBaseUtil.fileServiceUpload(pdf[i]);
							HTTPFile hf = new HTTPFile(streamId);
							try {
								String path = appConfig.getLocalFilePath() + UUIDUtils.random() + "." + hf.getSuffix();
								try {
									FileUtils.moveFile(new File(hf.getFilePath()) , new File(path));
								} catch (IOException e) {
									e.printStackTrace();
								}
								if(StringUtils.isNotBlank(path)){
									formatId = OfdTransferUtil.convertLocalFileToOFD(path);
								}
								//删除本地的临时流式文件
								if(new File(path).exists()){
									new File(path).delete();
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
						}else{
							formatId=FileBaseUtil.fileServiceUpload(pdf[i]);	
						}
						if(StringUtils.isNotBlank(formatId)) {
							if(i==0) {
								retFormatId=formatId;
								//获取版式文件的下载路径
								HTTPFile httpFiles = new HTTPFile(formatId);
								if(httpFiles!=null) {
									formatDownPath = httpFiles.getAssginDownloadURL(true);
								}
							}
							//保存文件相关数据
							DocumentFile file=new DocumentFile();
							file.setId(UUIDUtils.random());
							file.setDocInfoId(idpdf);
							file.setSort(documentFileService.queryMinSort(idpdf));
							file.setFileName(fileName);
							file.setCreatedTime(new Date());
							if(StringUtils.isNotBlank(streamId)) {
								file.setFileServerStreamId(streamId);
							}
							file.setFileServerFormatId(formatId);
							documentFileService.save(file);
						}
					}
					json.put("smjId", retFormatId);
					json.put("smjFilePath", formatDownPath);
					json.put("result", "success");
				}
			}else {
				json.put("result", "fail");
			}
			Response.json(json);
	}
	
	
	/**
	 * 登记录入列表查询
	 */
	@ResponseBody
	@RequestMapping("/list")
	public void list(Integer page, Integer pagesize,String search,String documentStatus){
		Map<String, Object> map = new HashMap<>();
		map.put("search", search);
		map.put("docStatus", documentStatus);
		PageHelper.startPage(page, pagesize);
		List<DocumentInfo> infoList = documentInfoService.queryList(map);
		GwPageUtils pageUtil = new GwPageUtils(infoList);
		Response.json(pageUtil);
	}
	
	/**
	 * 录入界面列表筛选数量统计
	 * @param search 搜索参数
	 */
	@ResponseBody
	@RequestMapping("/numsList")
	public void numsList(String search) {
		int [] arr = {0,0,0};
		Map<String, Object> map = new HashMap<>();
		map.put("search", search);
		List<DocumentInfo> infoList = documentInfoService.queryList(map);
		if(infoList != null && infoList.size()>0) {
			arr[0]=infoList.size();
			for (DocumentInfo documentInfo : infoList) {
				if(documentInfo.getFirstZbTime() != null) {
					arr[2] += 1;
				}else {
					arr[1] += 1;
				}
			}
		}
		Response.json(arr);
	}
	
	/**
	 * 办理反馈列表查询
	 * 注：修改列表查询的参数一定要对应的修改红点显示/getDicByTypet和统计数/replyNums
	 */
	@ResponseBody
	@RequestMapping("/replyList")
	public void replyList(Integer page, Integer pagesize,String search,String status,String typeId,String orgid,String month,String startDate,String endDate){
		String loginUserId=CurrentUser.getUserId();
		String dateStr = null;
		if(!StringUtils.isEmpty(month) && StringUtil.equals("all", month)) {
			dateStr = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE).substring(0,4);
		}else if(!StringUtils.isEmpty(month)) {
			dateStr = LocalDate.now().withMonth(Integer.parseInt(month)).format(DateTimeFormatter.ISO_LOCAL_DATE).substring(0,7);
		}
		String adminType = null;//管理员类型（1：部管理员；2：局管理员）
		String roleType = DbDefined.ROLE_6;//角色标识（1：首长；2：首长秘书；3：局长；4：局秘书；5：处长；6：参谋;）
		//当前登录人的管理员类型
		Map<String, Object> adminMap = new HashMap<>();
		adminMap.put("userId", loginUserId);
		List<AdminSet> adminList = adminSetService.queryList(adminMap);
		if(adminList != null && adminList.size()>0) {
			adminType = adminList.get(0).getAdminType();
		}
		//当前登录人的角色
		Map<String, Object> roleMap = new HashMap<>();
		roleMap.put("userId", loginUserId);
		List<RoleSet> roleList = roleSetService.queryList(roleMap);
		if(roleList != null && roleList.size()>0) {
			roleType = roleList.get(0).getRoleFlag();
		}
		List<DocumentInfo> infoList =null;
		Map<String, Object> map = new HashMap<>();
		map.put("docStatus", "2");
		map.put("type", typeId);
		map.put("search", search);
		map.put("orgid", orgid);
		map.put("year", dateStr);
		if(StringUtils.isNotBlank(status)) {
			if(StringUtils.equals("update", status)) {
				map.put("loginUserId", loginUserId);
				map.put("hasUpdate", status);
			}else {
				map.put("state", status);
			}
		}
		//导出的时间段搜索批示指示时间
		if(StringUtils.isNotBlank(startDate)||StringUtils.isNotBlank(endDate)) {
			if(StringUtils.equals("3", typeId)||StringUtils.equals("5", typeId)||StringUtils.equals("6", typeId)) {
				if(StringUtils.isNotBlank(startDate)) {
					map.put("zbStartDate", startDate);
				}
				if(StringUtils.isNotBlank(endDate)) { 
					map.put("zbEndDate", endDate);
				}
			}else {
				if(StringUtils.isNotBlank(startDate)) {
					map.put("startDate", startDate);
				}
				if(StringUtils.isNotBlank(endDate)) { 
					map.put("endDate", endDate);
				}
			}
		}
		if (!StringUtils.equals("1", adminType) && !StringUtils.equals("2", adminType)
				&& !StringUtils.equals(DbDefined.ROLE_1, roleType) && !StringUtils.equals(DbDefined.ROLE_3, roleType)) {
			if(StringUtils.equals(DbDefined.ROLE_5, roleType)) {
				map.put("deptId", CurrentUser.getDepartmentId());
			}else {
				map.put("loginUserId", loginUserId);
			}
			PageHelper.startPage(page, pagesize);
			infoList = documentInfoService.queryPersonList(map);
		} else {
			if(StringUtils.equals("2", adminType)|| StringUtils.equals(DbDefined.ROLE_3, roleType)) {
				String orgId = baseAppUserService.getBareauByUserId(loginUserId);
				if(StringUtils.isNotBlank(orgId)) {
					map.put("orgid", orgId);
				}
			}
			PageHelper.startPage(page, pagesize);
			infoList = documentInfoService.queryList(map);
		}
		for (DocumentInfo info : infoList) {
			//是否已读
			Map<String, Object> readMap = new HashMap<>();
			readMap.put("userId", loginUserId);
			readMap.put("infoId", info.getId());
			List<DocumentRead> list = documentReadService.queryList(readMap);
			
			//催办为0，未读，最新反馈字段有值则标识为已更新
			if(list.size()==0 && StringUtils.isNotBlank(info.getLatestReply())) {
				info.setUpdateFlag("1");
			}
		}
		GwPageUtils pageUtil = new GwPageUtils(infoList);
		Response.json(pageUtil);
	}
	
	/**
	 * 办理反馈数量统计
	 * @param search 搜索
	 * @param typeId 文件类型
	 */
	@ResponseBody
	@RequestMapping("/replyNums")
	public void replyNums(String search,String typeId,String orgid,String month) {
		String dateStr = null;
		if(!StringUtils.isEmpty(month) && StringUtil.equals("all", month)) {
			dateStr = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE).substring(0,4);
		}else if(!StringUtils.isEmpty(month)) {
			dateStr = LocalDate.now().withMonth(Integer.parseInt(month)).format(DateTimeFormatter.ISO_LOCAL_DATE).substring(0,7);
		}
		int [] arr = {0,0,0,0,0};
		String loginUserId=CurrentUser.getUserId();
		String adminType = null;//管理员类型（1：部管理员；2：局管理员）
		String roleType = DbDefined.ROLE_6;//角色标识（1：首长；2：首长秘书；3：局长；4：局秘书；5：处长；6：参谋;）
		//当前登录人的管理员类型
		Map<String, Object> adminMap = new HashMap<>();
		adminMap.put("userId", loginUserId);
		List<AdminSet> adminList = adminSetService.queryList(adminMap);
		if(adminList != null && adminList.size()>0) {
			adminType = adminList.get(0).getAdminType();
		}
		//当前登录人的角色
		Map<String, Object> roleMap = new HashMap<>();
		roleMap.put("userId", loginUserId);
		List<RoleSet> roleList = roleSetService.queryList(roleMap);
		if(roleList != null && roleList.size()>0) {
			roleType = roleList.get(0).getRoleFlag();
		}
		List<DocumentInfo> infoList =null;
		Map<String, Object> map = new HashMap<>();
		map.put("docStatus", "2");
		map.put("search", search);
		map.put("type", typeId);
		map.put("orgid", orgid);
		map.put("year", dateStr);
		if (!StringUtils.equals("1", adminType) && !StringUtils.equals("2", adminType)
				&& !StringUtils.equals(DbDefined.ROLE_1, roleType) && !StringUtils.equals(DbDefined.ROLE_3, roleType)) {
			if(StringUtils.equals(DbDefined.ROLE_5, roleType)) {
				map.put("deptId", CurrentUser.getDepartmentId());
			}else {
				map.put("loginUserId", loginUserId);
			}
			infoList = documentInfoService.queryPersonList(map);
		} else {
			if(StringUtils.equals("2", adminType)|| StringUtils.equals(DbDefined.ROLE_3, roleType)) {
				String orgId = baseAppUserService.getBareauByUserId(loginUserId);
				if(StringUtils.isNotBlank(orgId)) {
					map.put("orgid", orgId);
				}
			}
			infoList = documentInfoService.queryList(map);
		}
		arr[0]=infoList.size();
		for (DocumentInfo info : infoList) {
			Integer restatus = info.getStatus();
			if(1==restatus) {
				arr[1]+=1;
			}
			if(2==restatus){
				arr[2]+=1;
			}
			if(3==restatus){
				arr[3]+=1;
			}
			//是否已读
			Map<String, Object> readMap = new HashMap<>();
			readMap.put("userId", loginUserId);
			readMap.put("infoId", info.getId());
			List<DocumentRead> list = documentReadService.queryList(readMap);
			if(list.size()==0 && StringUtils.isNotBlank(info.getLatestReply())) {
				arr[4]+=1;
			}
		}
		Response.json(arr);
	}	
	
	/**
	 * 获取文件信息
	 * @param id 文件id
	 */
	@ResponseBody
	@RequestMapping("/info")
	public void info(String id){
		DocumentInfo documentInfo = documentInfoService.queryObject(id);
		String roleid=getRoleType();
		if(!"".equals(roleid)&&StringUtils.equals("1", roleid)) {//首长
			if(StringUtils.isNotBlank(documentInfo.getLatestReply())) {//局长意见有更新并且待办件
				String szreadids=documentInfo.getSzReadIds();
				if(StringUtils.isBlank(szreadids)) {
					documentInfo.setSzReadIds(CurrentUser.getUserId());
				}else if(!szreadids.contains(CurrentUser.getUserId())){
					documentInfo.setSzReadIds(szreadids+","+CurrentUser.getUserId());				
				}
				documentInfoService.update(documentInfo);
			}
			
		}
		Response.json(documentInfo);
	}
	public String getRoleType() {
		BaseAppConfig mapped = baseAppConfigService.queryObject(AppConstant.LEAD_TEAM);//首长单位id
		String depid=CurrentUser.getDepartmentId();
		//当前登录人的角色
		//角色标识（1：首长；2：首长秘书；3：局长；4：局秘书；5：处长；6：参谋;）
		Map<String, Object> roleMap = new HashMap<>();
		String userid=CurrentUser.getUserId();
		roleMap.put("userId",userid);
		List<RoleSet> roleList = roleSetService.queryList(roleMap);
		if(roleList != null && roleList.size()>0) {
			return roleList.get(0).getRoleFlag();
		}else if(mapped!=null){
			if(depid.equals(mapped.getValue())) {
				return "1";//首长单位下的人(默认为首长)
			}
		}
		return "";
	}	
	/**
	 * 新增或修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public void update(DocumentInfo documentInfo){
		String uuid="";
		JSONObject jo=new JSONObject();
		if (StringUtils.isNotBlank(documentInfo.getId())) {
			jo.put("id",documentInfo.getId());
			documentInfoService.update(documentInfo);
		} else {
			uuid=UUIDUtils.random();
			documentInfo.setId(uuid);
			documentInfo.setStatus(0);
			documentInfoService.save(documentInfo);
			jo.put("id",uuid);
		}
		Response.json(jo);
	}
	
	/**
	 * 按钮显示参数
	 * @param id 主文件id
	 */
	@ResponseBody
	@RequestMapping("/buttonParam")
	public void buttonParam(String id){
		String loginUserId=CurrentUser.getUserId();
		String adminType = "0";//管理员类型（1：部管理员；2：局管理员）
		boolean cuiBanBtn =false;
		boolean zhuanBanBtn =false;
		boolean quXiaoBtn =false;
		boolean banjieBtn =false;
		
		//当前登录人的管理员类型
		Map<String, Object> adminMap = new HashMap<>();
		adminMap.put("userId", loginUserId);
		List<AdminSet> adminList = adminSetService.queryList(adminMap);
		if(adminList != null && adminList.size()>0) {
			adminType = adminList.get(0).getAdminType();
		}
		//获取文件信息
		DocumentInfo documentInfo = documentInfoService.queryObject(id);
		if(documentInfo != null) {
			Integer status = documentInfo.getStatus();
			String cuibanFlag = documentInfo.getCuibanFlag();
			if(StringUtils.equals("1", adminType)) {
				if(status<2) {
					zhuanBanBtn=true;
					banjieBtn=true;
					if(!StringUtils.equals("1", cuibanFlag)) {
						cuiBanBtn=true;
					}
				}else {
					quXiaoBtn=true;
				}
			}
		}
		JSONObject json= new JSONObject();
		json.put("cuiBanBtn", cuiBanBtn);
		json.put("quXiaoBtn", quXiaoBtn);
		json.put("zhuanBanBtn", zhuanBanBtn);
		json.put("banjieBtn", banjieBtn);
		Response.json(json);
	}
	
	/**
	 * @description:部管理员强制常态落实
	 * @author:zhangyw
	 * @date:2019年5月24日
	 * @Version v1.0
	 * @param infoId 主文件id
	 */
	@ResponseBody
	@RequestMapping("/luoShiOperation")
	public void luoShiOperation(String infoId){
		JSONObject json= new JSONObject();
		if(StringUtils.isNotBlank(infoId)) {
			//主文件状态变为常态落实
			DocumentInfo info = documentInfoService.queryObject(infoId);
			info.setSzReadIds("");
			info.setStatus(3);
			documentInfoService.update(info);
			//办结落实记录
			DocumentBjjl bjjl=new DocumentBjjl();
			bjjl.setInfoId(infoId);
			bjjl.setContent("常态落实");
			documentBjjlService.save(bjjl);
			json.put("result", "success");
		}else {
			json.put("result", "fail");
		}
		Response.json(json);
	}
	/**
	 * @description:部管理员强制办结
	 * @author:zhangyw
	 * @date:2019年5月24日
	 * @Version v1.0
	 * @param infoId 主文件id
	 */
	@ResponseBody
	@RequestMapping("/banJieOperation")
	public void banJieOperation(String infoId){
		JSONObject json= new JSONObject();
		if(StringUtils.isNotBlank(infoId)) {
			//主文件状态变为办结
			DocumentInfo info = documentInfoService.queryObject(infoId);
			info.setSzReadIds("");
			info.setStatus(2);
			documentInfoService.update(info);
			//办结落实记录
			DocumentBjjl bjjl=new DocumentBjjl();
			bjjl.setInfoId(infoId);
			bjjl.setContent("办结");
			documentBjjlService.save(bjjl);
			json.put("result", "success");
		}else {
			json.put("result", "fail");
		}
		Response.json(json);
	}
	/**
	 * 取消办结操作
	 * @param id 主文件id
	 */
	@ResponseBody
	@RequestMapping("/cancleOperation")
	public void cancleOperation(String id){
		JSONObject json= new JSONObject();
		DocumentInfo info = documentInfoService.queryObject(id);
		//取最后办结或落实的局的主文件(正常系统中只会有一个分支文件的状态大于11，导入的会有多个)
		//文件局内状态（1:待转办；3：退回修改；5：待落实；7：待审批；9：办理中；10：建议办结；11：建议落实；12：办结；1:3：常态落实）
		List<SubDocInfo> lastEndSubInfos = subDocInfoService.queryLastEndSubInfo(id);
		if(lastEndSubInfos !=null && lastEndSubInfos.size()>0) {
			//lastEndSubInfos存在说明是承办人办结的文或导入的已办结的文
			for (SubDocInfo lastEndSubInfo : lastEndSubInfos) {
				String subId =lastEndSubInfo.getId();
				if(StringUtils.isNotBlank(subId)) {
					Integer subStatus = DbDocStatusDefined.BAN_LI_ZHONG;
					//添加办结记录
					DocumentBjjl newBjjl=new DocumentBjjl();
					newBjjl.setContent("取消办结");
					newBjjl.setInfoId(id);
					newBjjl.setSubId(subId);
					documentBjjlService.save(newBjjl);				
					//取最后一条流转记录
					SubDocTracking tracking = subDocTrackingService.queryLatestRecord(subId);
					//trackingType（1：转办；2：审批流转；3：退回;4:新一轮反馈的开始，即承办人的办理）
					String trackingType = tracking.getTrackingType();
					//如果最后一条流转为审批，接收人为承办人则文件为办理中，否则文件为待审批
					if(StringUtils.equals("2",trackingType)) {
						if(!StringUtils.equals(lastEndSubInfo.getUndertaker(), tracking.getReceiverId())) {
							subStatus = DbDocStatusDefined.DAI_SHEN_PI;
						}
						//如果最后一条流转为退回修改，则文件状态为退回修改
					}else if(StringUtils.equals("3",trackingType)){
						subStatus = DbDocStatusDefined.TUIHUI_XIUGAI;
					}
					//修改最后一个局的文件状态
					lastEndSubInfo.setDocStatus(subStatus);
					subDocInfoService.update(lastEndSubInfo);
				}else {
					json.put("result", "fail");
				}
			}
		}
		//lastEndSubInfos不存在说明是部管理员强制办结的文，只需要将主文件变为办理中
		info.setStatus(1);
		documentInfoService.update(info);
		json.put("result", "success");
		Response.json(json);
	}
	
	/**
	 * 撤回操作
	 * @param id
	 */
	@ResponseBody
	@RequestMapping("/cheHuiOperation")
	public void cheHuiOperation(String id){
		documentInfoService.deleteByCheHui(id);
		Response.json("result", "success");
	}
	
	/**
	 * 批量已读
	 * @param ids 主文件id
	 */
	@ResponseBody
	@RequestMapping("/batchRead")
	public void batchRead(String ids){
		String[] idArry = ids.split(",");
		for (String id : idArry) {
			Map<String, Object> map=new HashMap<>();
			map.put("userId", CurrentUser.getUserId());
			map.put("infoId", id);
			map.put("readFlag", "1");
			List<DocumentRead> list = documentReadService.queryList(map);
			if(list.size()==0 || list ==null) {
				DocumentRead read=new DocumentRead();
				read.setInfoId(id);
				documentReadService.save(read);
			}
		}
		Response.json("result", "success");
	}
	
	/**
	 * 删除文件
	 * @param id 主文件id
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public void delete(String id){
		documentSzpsService.deleteByInfoId(id);
		documentFileService.deleteByInfoId(id);
		documentInfoService.delete(id);
		Response.json("result", "success");
	}
	/**
	 * 获取当前登录人信息
	 */
	@ResponseBody
	@RequestMapping("/getLoginUser")
	public void getLoginUser() {
		JSONObject jo=new JSONObject();
		jo.put("userId", CurrentUser.getUserId());
		jo.put("userName", CurrentUser.getUsername());
		Response.json(jo);
	}
	
	/**
	 * 部管理员添加催办
	 * @param textarea 催办内容
	 * @param infoId 主文件id
	 */
	@ResponseBody
	@RequestMapping("/saveCuiBan")
	public void saveCuiBan(String textarea,String infoId){
		//保存催办历史
		DocumentCbjl cb=new DocumentCbjl();
		cb.setUrgeContent(textarea);
		cb.setInfoId(infoId);
		documentCbjlService.save(cb);
		//主文件标识催办
		DocumentInfo info=documentInfoService.queryObject(infoId);
		info.setCuibanFlag("1");
		documentInfoService.update(info);
		Response.json("result", "success");
	}
	
	/**
	 * 获取最新催办数据
	 * @param infoId 主文件id
	 */
	@ResponseBody
	@RequestMapping("/getLatestCuiBan")
	public void getLatestCuiBan(String infoId){
		DocumentCbjl cuiBan =null;
		DocumentInfo info=documentInfoService.queryObject(infoId);
		if(StringUtils.equals("1", info.getCuibanFlag())) {
			cuiBan= documentCbjlService.queryLatestCuiBan(infoId);
		}
		Response.json(cuiBan);
	}
	
	/**
	 * 催办记录列表
	 * @param infoId 主文件id
	 */
	@ResponseBody
	@RequestMapping("/getCuiBanlist")
	public void getCuiBanlist(String infoId){
		List<DocumentCbjl> list=null;
		if(StringUtils.isNotBlank(infoId)) {
			Map<String, Object> map = new HashMap<>();
			map.put("infoId", infoId);
			//查询列表数据
			list = documentCbjlService.queryList(map);
		}
		Response.json(list);
	}
	
	/**
	 * 办结记录列表
	 * @param infoId
	 */
	@ResponseBody
	@RequestMapping("/getBanJieList")
	public void getBanJieList(String infoId){
		List<DocumentBjjl> bjjlList=null;
		if(StringUtils.isNotBlank(infoId)) {
			Map<String, Object> map = new HashMap<>();
			map.put("infoId", infoId);
			//查询列表数据
			bjjlList = documentBjjlService.queryList(map);
		}
		Response.json(bjjlList);
	}
	
	/**
	 * 获取办理反馈左侧菜单及更新数量
	 */
	@ResponseBody
	@RequestMapping("/getDicByTypet")
	public void getDicByTypet(String orgid,String month,boolean menuFlag){
		String dateStr = null;
		if(!StringUtils.isEmpty(month) && StringUtil.equals("all", month)) {
			dateStr = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE).substring(0,4);
		}else if(!StringUtils.isEmpty(month)) {
			dateStr = LocalDate.now().withMonth(Integer.parseInt(month)).format(DateTimeFormatter.ISO_LOCAL_DATE).substring(0,7);
		}
		String loginUserId=CurrentUser.getUserId();
		String adminType = null;//管理员类型（1：部管理员；2：局管理员）
		String roleType = DbDefined.ROLE_6;//角色标识（1：首长；2：首长秘书；3：局长；4：局秘书；5：处长；6：参谋;）
		//当前登录人的管理员类型
		Map<String, Object> adminMap = new HashMap<>();
		adminMap.put("userId", loginUserId);
		List<AdminSet> adminList = adminSetService.queryList(adminMap);
		if(adminList != null && adminList.size()>0) {
			adminType = adminList.get(0).getAdminType();
		}
		//当前登录人的角色
		Map<String, Object> roleMap = new HashMap<>();
		roleMap.put("userId", loginUserId);
		List<RoleSet> roleList = roleSetService.queryList(roleMap);
		if(roleList != null && roleList.size()>0) {
			roleType = roleList.get(0).getRoleFlag();
		}
		Map<String, Object> map = new HashMap<>();
		map.put("userId", loginUserId);
		map.put("docType", DbDefined.DOCUMENT_TYPE);
		map.put("orgId", orgid);
		map.put("year", dateStr);
		/*if(StringUtils.isNotBlank(status)) {
			if(StringUtils.equals("update", status)) {
				map.put("loginUserId", loginUserId);
				map.put("hasUpdate", status);
			}else {
				map.put("state", status);
			}
		}*/
		if (!StringUtils.equals("1", adminType) && !StringUtils.equals("2", adminType)
				&& !StringUtils.equals(DbDefined.ROLE_1, roleType) && !StringUtils.equals(DbDefined.ROLE_3, roleType)) {
			if(StringUtils.equals(DbDefined.ROLE_5, roleType)) {
				map.put("deptId", CurrentUser.getDepartmentId());
			}else {
				map.put("loginUserId", loginUserId);
			}
		}else {
			if(StringUtils.equals("2", adminType)|| StringUtils.equals(DbDefined.ROLE_3, roleType)) {
				String orgId = baseAppUserService.getBareauByUserId(loginUserId);
				if(StringUtils.isNotBlank(orgId)) {
					map.put("orgId", orgId);
				}
			}
		}
		List<DocumentDic> dicByType = documentInfoService.queryDicByType(map);
		int blfkNum=0;
		if(menuFlag) {
			for (DocumentDic dic : dicByType) {
				blfkNum +=dic.getHasUpdateNum();
			}
			Response.json("blfkNum",blfkNum);
			return;
		}
		Response.json(DbDefined.DOCUMENT_TYPE, dicByType);
	}
	
	/**
	 * 将扫描筛选后的图片，保存成PDF文件
	 * @param smwj 文件
	 * @param infoId 公文ID
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/saveSmjPsFile")
	public void saveSmjToFile(@RequestParam(value = "smwj", required = false) String smwj,@RequestParam(value = "infoId", required = true) String infoId)
			throws Exception {
		DocumentInfo fileInfo = documentInfoService.queryObject(infoId);
		if(fileInfo != null) {
			//将扫描件上传到电子数据中心
			String fileId = getFilePath(smwj, fileInfo, CurrentUser.getUsername());
			// 获得批示首页文件的绝对路径
			String scanFilePath = "";
			if(StringUtils.isNotBlank(fileId)) {
				HTTPFile httpFile = new HTTPFile(fileId);
				scanFilePath = httpFile.getAssginDownloadURL(true);
			}
			JSONObject result = new JSONObject();
			result.put("result", "success");
			result.put("scanId", StringUtils.isNotBlank(fileId) ? fileId :"");
			result.put("scanFilePath", scanFilePath);
			Response.json(result);
		}
	}
	
	private String getFilePath(String smwj, DocumentInfo model, String loginUserName){
		String fileId = "";
		// 将扫描件上传到电子数据中心
		if (StringUtils.isNotBlank(smwj)) {
			fileId = OfdTransferUtil.createdOFDFile(smwj, model.getId());
			if (StringUtils.isNotBlank(fileId)) {
				//保存文件相关数据
				DocumentFile file=new DocumentFile();
				file.setId(UUIDUtils.random());
				file.setDocInfoId(model.getId());
				file.setSort(documentFileService.queryMinSort(model.getId()));
				HTTPFile httpFile = new HTTPFile(fileId);
				file.setFileName(httpFile.getFileName());
				file.setCreatedTime(new Date());
				file.setFileServerFormatId(fileId);
				documentFileService.save(file);
			}
		}
		return fileId;
	}
}
