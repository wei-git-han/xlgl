package com.css.app.xlgl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.css.addbase.appconfig.service.BaseAppConfigService;
import com.css.addbase.apporgan.entity.BaseAppOrgan;
import com.css.addbase.apporgan.entity.BaseAppUser;
import com.css.addbase.apporgan.service.BaseAppOrganService;
import com.css.addbase.apporgan.service.BaseAppUserService;
import com.css.addbase.apporgan.util.RedisUtil;
import com.css.addbase.apporgmapped.service.BaseAppOrgMappedService;
import com.css.addbase.msg.MSGTipDefined;
import com.css.addbase.msg.MsgTipUtil;
import com.css.addbase.msg.entity.MsgTip;
import com.css.addbase.msg.service.MsgTipService;
import com.css.addbase.orgservice.OrgService;
import com.css.app.xlgl.config.entity.XlglRoleSet;
import com.css.app.xlgl.config.service.XlglRoleSetService;
import com.css.app.xlgl.entity.*;
import com.css.app.xlgl.meeting.entity.XlglHuijian;
import com.css.app.xlgl.meeting.service.XlglHuijianService;
import com.css.app.xlgl.service.*;
import com.css.base.utils.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.aspectj.weaver.ast.And;
import org.codehaus.groovy.util.HashCodeHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

import com.github.pagehelper.PageHelper;

/**
 * 转办记录表
 * 
 * @author 中软信息系统工程有限公司
 * @email
 * @date 2020-08-11 11:11:27
 */
@Controller
@RequestMapping("/app/xlgl/xlgldocumentzbjl")
public class XlglDocumentZbjlController {
	@Autowired
	private XlglDocumentZbjlService xlglDocumentZbjlService;
	@Autowired
	private BaseAppOrgMappedService baseAppOrgMappedService;
	@Autowired
	private BaseAppOrganService baseAppOrganService;
	@Autowired
	private XlglSubDocInfoService xlglSubDocInfoService;
	@Autowired
	private XlglAdminSetService adminSetService;
	@Autowired
	private MsgTipService msgService;
	@Autowired
	private MsgTipUtil msgUtil;
	@Autowired
	private BaseAppUserService baseAppUserService;
	@Autowired
	private OrgService orgService;
	@Autowired
	private BaseAppConfigService baseAppConfigService;
	@Autowired
	private XlglSubDocTrackingService xlglSubDocTrackingService;
	@Autowired
	private XlglXlzzInfoService xlglXlzzInfoService;
	@Autowired
	private XlglExamMainAnswerService xlglExamMainAnswerService;
	@Autowired
	private XlglPhysicalService xlglPhysicalService;
	@Autowired
	private XlglPictureService xlglPictureService;
	@Autowired
	private XlglConfirmService xlglConfirmService;
	@Autowired
	private XlglMineStudyService xlglMineStudyService;
	@Autowired
	private XlglRoleSetService xlglRoleSetService;
	@Autowired
	private XlglHuijianService xlglHuijianService;
	@Autowired
	private RedisUtil redisUtil;
	@Value("${csse.meeting.appid}")
	private String huiJianAppId;
	@Value("${csse.meeting.appSecret}")
	private String clientSecret;
	@Value("${csse.xlgl.appId}")
	private String AppId;
	@Value("${csse.xlgl.appSecret}")
	private String appSecret;

	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("xlgldocumentzbjl:list")
	public void list(Integer page, Integer limit) {
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);

		// 查询列表数据
		List<XlglDocumentZbjl> xlglDocumentZbjlList = xlglDocumentZbjlService.queryList(map);

		PageUtils pageUtil = new PageUtils(xlglDocumentZbjlList);
		Response.json("page", pageUtil);
	}

	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	@RequiresPermissions("xlgldocumentzbjl:info")
	public void info(@PathVariable("id") String id) {
		XlglDocumentZbjl xlglDocumentZbjl = xlglDocumentZbjlService.queryObject(id);
		Response.json("xlglDocumentZbjl", xlglDocumentZbjl);
	}

	/**
	 * 分发接口 fileId为文件的id idAndNames 局id和名字以逗号连接，局与局已分好连接
	 * 4832975928423057,信息系统局;385934762908523490,保密局
	 */
	@ResponseBody
	@RequestMapping("/send")
	public void send(String fileId, String idAndNames, String deptIds, String deptNames) {
		if (StringUtils.isNotBlank(fileId) && StringUtils.isNotBlank(idAndNames)) {
			String organId = baseAppOrgMappedService.getBareauByUserId(CurrentUser.getUserId());
			BaseAppOrgan org = baseAppOrganService.queryObject(organId);
			// 添加转办记录
			XlglDocumentZbjl xlglDocumentZbjl1 = xlglDocumentZbjlService.queryByInfoId(fileId);
			if (xlglDocumentZbjl1 != null) {
				xlglDocumentZbjlService.deleteByInfoId(fileId);
			}
			XlglDocumentZbjl xlglDocumentZbjl = new XlglDocumentZbjl();
			xlglDocumentZbjl.setId(UUIDUtils.random());
			xlglDocumentZbjl.setInfoId(fileId);
			xlglDocumentZbjl.setReceiverIds(deptIds);
			xlglDocumentZbjl.setReceiverNames(deptNames);
			xlglDocumentZbjl.setCreatedTime(new Date());
			xlglDocumentZbjl.setOrgName(org.getName());
			// xlglDocumentZbjlService.save(xlglDocumentZbjl);

			XlglXlzzInfo xlglXlzzInfo = xlglXlzzInfoService.queryObject(fileId);
			xlglXlzzInfo.setTodeptName(deptNames);
			xlglXlzzInfo.setTodeptId(deptIds);
			xlglXlzzInfoService.update(xlglXlzzInfo);
			// 添加各分支记录
			String[] ids = idAndNames.split(";");
			List<String> subDeptIds = xlglSubDocInfoService.queryAllSubDeptIds(fileId);
			for (int i = 0; i < ids.length; i++) {
				String[] idAndName = ids[i].split(",");
				String deptId = idAndName[0];
				String deptName = idAndName[1];
				if (!subDeptIds.contains(deptId)) {// 防止多次分发，多次分发只是分发新增的那些
					XlglSubDocInfo xlglSubDocInfo = new XlglSubDocInfo();
					xlglSubDocInfo.setId(UUIDUtils.random());
					xlglSubDocInfo.setInfoId(fileId);
					xlglSubDocInfo.setCreatedTime(new Date());
					xlglSubDocInfo.setSubDeptId(deptId);
					xlglSubDocInfo.setSubDeptName(deptName);
					xlglSubDocInfo.setXltype(xlglXlzzInfo.getXltype());
					xlglSubDocInfo.setExerciseTime(xlglXlzzInfo.getExerciseTime());
					xlglSubDocInfo.setPicturePath(xlglXlzzInfo.getPicturePath());
					xlglSubDocInfo.setIsSend("0");
					xlglSubDocInfo.setExerciseTime(xlglXlzzInfo.getExerciseTime());
					xlglSubDocInfoService.save(xlglSubDocInfo);
				}
				// 获取局管理员,给局管理员发送消息提醒
				List<String> userIds = adminSetService.queryUserIdByOrgId(deptId);
				if (userIds != null && userIds.size() > 0) {
					for (String userId : userIds) {
						MsgTip msg = msgService.queryObject(MSGTipDefined.XLGL);
						if (msg != null) {
							String msgUrl ="";// msg.getMsgRedirect() + "&fileId=" + infoId + "&subId=" + subId;
							if (StringUtils.isNotBlank(userId)) {
								msgUtil.sendMsg(msg.getMsgTitle(), msg.getMsgContent(), msgUrl, userId, AppId, appSecret,
										msg.getGroupName(), msg.getGroupRedirect(), "", "true");
							}
						}
					}
				}

			}
			Response.json("result", "success");
		} else {
			Response.json("result", "faild");
		}

	}

	/**
	 * 局内分发
	 */
	@ResponseBody
	@RequestMapping("/sendToUsers")
	public void sendToUsers(String fileId, String subId, String instraction) {
		Map<String, Object> map = new HashMap<String, Object>();

		XlglXlzzInfo xlglXlzzInfo = xlglXlzzInfoService.queryObject(fileId);
		String organId = baseAppOrgMappedService.getBareauByUserId(CurrentUser.getUserId());
		map.put("organId", organId);
		List<BaseAppUser> list = baseAppUserService.queryAllUserIdAndName(map);
		if (list != null && list.size() > 0) {
			XlglSubDocInfo subInfo = xlglSubDocInfoService.queryObject(subId);
			subInfo.setInstraction(instraction);
			subInfo.setIsSend("1");// 更新状态，已分发
			xlglSubDocInfoService.update(subInfo);
			for (BaseAppUser baseAppUser : list) {
				String receiverId = baseAppUser.getUserId();
				String receiverName = baseAppUser.getTruename();
				String userOrganId = baseAppUser.getOrganid();
				BaseAppOrgan organ = baseAppOrganService.queryObject(userOrganId);
				String deptName = organ.getName();
				// 转办记录
				XlglDocumentZbjl xl = new XlglDocumentZbjl();
				xl.setId(UUIDUtils.random());
				xl.setInfoId(fileId);
				xl.setReceiverIds(receiverId);
				xl.setReceiverNames(receiverName);
				xl.setReceiverDeptId(userOrganId);
				xl.setReceiverDeptName(deptName);
				xl.setOrgName(subInfo.getSubDeptName());
				xl.setSubId(subId);
				xl.setCreatedTime(new Date());
				// xlglDocumentZbjlService.save(xl);
				// 流转记录
				XlglSubDocTracking tracking = new XlglSubDocTracking();
				// 多次分发，先删除该文件上次分发的
				xlglSubDocTrackingService.deleteByInfoIdAndUserId(fileId, receiverId);
				String loginUserName = CurrentUser.getUsername();
				String loginUserDeptId = CurrentUser.getDepartmentId();
				String loginUserDeptName = CurrentUser.getOrgName();
				tracking.setId(UUIDUtils.random());
				tracking.setInfoId(fileId);
				tracking.setSenderId(CurrentUser.getUserId());
				tracking.setSenderName(loginUserName);
				tracking.setSenDeptId(loginUserDeptId);
				tracking.setSenDeptName(loginUserDeptName);
				tracking.setReceiverId(receiverId);
				tracking.setReceiverName(receiverName);
				tracking.setRecDeptId(userOrganId);
				tracking.setRecDeptName(deptName);
				tracking.setSubId(subId);
				// tracking.setTrackingType("1");
				tracking.setPreviousStatus(subInfo.getDocStatus());
				tracking.setUndertaker(subInfo.getUndertaker());
				tracking.setBaoming("0");
				tracking.setTitle(xlglXlzzInfo.getTitle());
				tracking.setTrackingType(xlglXlzzInfo.getXltype());// 训练类型
				tracking.setXltype(xlglXlzzInfo.getXltype());
				tracking.setPicturePath(xlglXlzzInfo.getPicturePath());
				tracking.setExerciseTime(xlglXlzzInfo.getExerciseTime());
				tracking.setInstraction(subInfo.getInstraction());
				tracking.setRead("0");// 0是未接受，1是已接受
				tracking.setIsWork("0");// 0是未参训
				tracking.setCreatedTime(new Date());
				tracking.setOrgId(organId);
				xlglSubDocTrackingService.save(tracking);

				// 发送消息提醒
//				XlglHuijian queryObjectByxlglId = xlglHuijianService.queryObjectByxlglId(fileId);
//				if (queryObjectByxlglId != null) {
//					String msgRedirect = xlglHuijianService.getMsgRedirect(queryObjectByxlglId.getConfId());
//					String msgUrl = "";
//					if (StringUtils.isNotBlank(receiverId)) {
//						msgUtil.sendMsg("会见系统", "您有一条新的会议链接", msgUrl, receiverId, huiJianAppId, huiJianAppSecret,
//								"训练管理", msgRedirect, "", "true");
//					}
//				}
				/**
				 * 发送消息提醒
				 */
				MsgTip msg = msgService.queryObject(MSGTipDefined.XLGL);
				if (msg != null) {
					String msgUrl ="";// msg.getMsgRedirect() + "&fileId=" + infoId + "&subId=" + subId;
					if (StringUtils.isNotBlank(receiverId)) {
						msgUtil.sendMsg(msg.getMsgTitle(), msg.getMsgContent(), msgUrl, receiverId, AppId, appSecret,
								msg.getGroupName(), msg.getGroupRedirect(), "", "true");
					}
				}

			}
			Response.json("result", "success");
		} else {
			Response.json("result", "faild");
		}

	}

	/**
	 * 人员是否参训状态修改
	 *
	 * @param infoId
	 *            文id
	 * @param userId
	 *            用户id
	 * @param isWork
	 *            0是未参训，1是已参训
	 * type 0是参训受训 1是大讲堂
	 * status 参训受训 0已报名，1延后参训，2未接受，3已接受
	 * status 大讲堂 0延后参训 1已参训
	 */
	@ResponseBody
	@RequestMapping("/updateStatus")
	public void updateStatus(String infoId, String userId, String isWork,String status,String type) {
		// 0:超级管理员 ;1：部管理员；2：局管理员；3：即是部管理员又是局管理员;4:处管理员
		String adminFlag = adminSetService.getAdminTypeByUserId(CurrentUser.getUserId());
		BaseAppUser baseAppUser = baseAppUserService.query(userId);
		String userDept = "";// 被修改人的部门id
		if (baseAppUser != null) {
			userDept = baseAppUser.getOrganid();
		}
		String dept = "";// 当前登录人的部门id，当前登录人是处管理员的前提下，查下他的部门id和被修改人的部门id是否一致，一致说明是同一个处，否则不是
		// 同一个处的处管理员才能修改
		if ("4".equals(adminFlag)) {
			XlglAdminSet xlglAdminSet = adminSetService.queryByUserId(CurrentUser.getUserId());
			dept = xlglAdminSet.getDeptId();
		}
		boolean t = false;
		if (userDept.equals(dept)) {
			t = true;
		} else {
			t = false;
		}
		if (userId.equals(CurrentUser.getUserId()) || "1".equals(adminFlag) || "2".equals(adminFlag) || t) {
			String deptId = baseAppUserService.queryByUserId(CurrentUser.getUserId());
			List<XlglConfirm> xlglConfirmList = xlglConfirmService.queryByInfoIdAndDeptId(deptId, infoId);
			if (xlglConfirmList != null && xlglConfirmList.size() > 0) {
				Response.json("result", "confirm");
			} else {
				List<XlglSubDocTracking> list = xlglSubDocInfoService.queryByInfoIdAndUserId(infoId, userId);
				if (list != null && list.size() > 0) {
					XlglSubDocTracking xlglSubDocTracking = list.get(0);
					if("0".equals(type)){
						if(StringUtils.isNotBlank(status)){
							if("0".equals(status)){
								xlglSubDocTracking.setBaoming("1");//已报名
							}else if("1".equals(status)){
								xlglSubDocTracking.setBaoming("2");//延后参训
							}else if("2".equals(status)){
								xlglSubDocTracking.setRead("0");
							}else if("3".equals(status)){
								xlglSubDocTracking.setRead("1");
							}
						}
					}else if("1".equals(type)){
						if(StringUtils.isNotBlank(status)){
							if("0".equals(status)){
								xlglSubDocTracking.setBaoming("2");
								xlglSubDocTracking.setIsWork("0");
							}else if("1".equals(status)){
								xlglSubDocTracking.setIsWork("1");
							}
						}
					}
					xlglSubDocTrackingService.update(xlglSubDocTracking);
					Response.json("result", "success");
				} else {
					Response.json("result", "fail");
				}
			}
		} else {
			Response.json("result", "no Perssion");
		}
	}



	// public void confirm(String infoId){
	// String orgId = baseAppUserService.getBareauByUserId(CurrentUser.getUserId());
	// //3：局长；4：局秘书；5：处长；6：参谋；2：首长秘书；1：首长；）
	// XlglRoleSet xlglRoleSet =
	// xlglRoleSetService.queryByuserId(CurrentUser.getUserId());
	// String adminType = xlglRoleSet.getRoleFlag();
	// if("3".equals(adminType)){
	// List<XlglConfirm> xlglConfirm =
	// xlglConfirmService.queryByInfoIdAndDeptId(orgId,infoId);
	// }
	// }

	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("xlgldocumentzbjl:update")
	public void update(@RequestBody XlglDocumentZbjl xlglDocumentZbjl) {
		xlglDocumentZbjlService.update(xlglDocumentZbjl);

		Response.ok();
	}

	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("xlgldocumentzbjl:delete")
	public void delete(@RequestBody String[] ids) {
		xlglDocumentZbjlService.deleteBatch(ids);

		Response.ok();
	}

	/**
	 * 报名接口
	 *
	 * @param infoId
	 * @param subId
	 * @param baoming
	 *            0未报名，1已报名，2延后
	 * @param reason
	 */
	@ResponseBody
	@RequestMapping("/baoming")
	public void baoming(String infoId, String subId, String baoming, String reason) {
		String userId = CurrentUser.getUserId();
		XlglSubDocTracking xlglSubDocTracking = xlglSubDocTrackingService.querybaoming(infoId, subId, userId);
		if (xlglSubDocTracking != null) {
			xlglSubDocTracking.setBaoming(baoming);
			String xlType = xlglSubDocTracking.getXltype();
			if (StringUtils.isNotBlank(xlType)) {
				if ("1".equals(xlType)) {
					xlglSubDocTracking.setIsWork("1");// 日常军事训练的，已报名就代表已参训
				}
			}
			if ("2".equals(baoming) && StringUtils.isNotBlank(reason)) {
				xlglSubDocTracking.setReason(reason);
			}
			xlglSubDocTrackingService.update(xlglSubDocTracking);
			Response.json("result", "success");
		} else {
			Response.json("result", "fail");
		}
	}

	/**
	 * 局内分发列表查询
	 *
	 * @param page
	 * @param pagesize
	 * @param search
	 *            isSend字段代表是否分发 0未分发，1已分发
	 */
	@ResponseBody
	@RequestMapping("/juList")
	public void juList(Integer page, Integer pagesize, String search, String xltype) {
		Map<String, Object> map = new HashMap<String, Object>();
		String loginUserId = CurrentUser.getUserId();
		String orgId = baseAppUserService.getBareauByUserId(loginUserId);
		if (StringUtils.isNotBlank(orgId)) {
			map.put("orgId", orgId);
		}
		if (StringUtils.isNotBlank(search)) {
			map.put("search", search);
		}
		if (StringUtils.isNotBlank(xltype)) {
			map.put("xltype", xltype);
		}
		PageHelper.startPage(page, pagesize);
		List<XlglSubDocInfo> list = xlglSubDocInfoService.queryListForJu(map);
		for (XlglSubDocInfo xlglSubDocInfo : list) {
			Map<String, Object> hashmap = new HashMap<String, Object>();
			hashmap.put("id", xlglSubDocInfo.getInfoId());
			hashmap.put("type", "4");
			List<XlglPicture> queryList = xlglPictureService.queryListByType(hashmap);
			if (queryList.size() > 0) {
				if (queryList.get(0).getFileId().equals(xlglSubDocInfo.getInfoId())) {
					xlglSubDocInfo.setPicturePath(queryList.get(0).getPictureId());
				}
			}
		
		}
		GwPageUtils pageUtil = new GwPageUtils(list);
		Response.json(pageUtil);
	}

	/**
	 * 训练组织个人列表
	 *
	 * @param page
	 * @param pagesize
	 * @param search
	 *            type 0 未开始 1已完成
	 */
	@ResponseBody
	@RequestMapping("/personList")
	public void personList(Integer page, Integer pagesize, String search, String type, String xltype) {
		List<XlglSubDocTracking> list = null;
		String userId = CurrentUser.getUserId();
		Map<String, Object> map = new HashMap<String, Object>();
		if (StringUtils.isNotBlank(userId)) {
			map.put("userId", userId);
		}
		if (StringUtils.isNotBlank(search)) {
			map.put("search", search);
		}
		if (StringUtils.isNotBlank(type)) {
			map.put("type", type);
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		map.put("time", format.format(new Date()));

		map.put("xltype", xltype);

		if ("0".equals(type)) {
			PageHelper.startPage(page, pagesize);
			list = xlglSubDocTrackingService.queryListForPerson(map);
		} else if ("1".equals(type)) {
			PageHelper.startPage(page, pagesize);
			list = xlglSubDocTrackingService.queryListForPerson1(map);
		}
		if (list != null && list.size() > 0) {
			for (XlglSubDocTracking xlglSubDocTracking : list) {
				Map<String, Object> mapList = new HashMap<>();
				String fileId = xlglSubDocTracking.getInfoId();
				mapList.put("fileId", fileId);
				// List<XlglPicture> pictureList = xlglPictureService.queryList(mapList);
				// if(pictureList != null && pictureList.size() > 0){
				// xlglSubDocTracking.setPicturePath(pictureList.get(0).getPictureId());
				// }
				XlglXlzzInfo xlglXlzzInfo = xlglXlzzInfoService.queryObject(fileId);
				xlglSubDocTracking.setPicturePath(xlglXlzzInfo.getPicturePath());
				// 0未接收、1已接受、2已报名、3延后参训,4已参训
				String read = xlglSubDocTracking.getRead();
				String baoming = xlglSubDocTracking.getBaoming();
				String isWork = xlglSubDocTracking.getIsWork();
				if (StringUtils.isNotBlank(baoming) && !"0".equals(baoming)) {
					if ("1".equals(baoming)) {
						xlglSubDocTracking.setSumStatus("2");
					} else if ("2".equals(baoming)) {
						// if(StringUtils.isNotBlank(isWork) && "1".equals(isWork)){
						// xlglSubDocTracking.setSumStatus("4");
						// }else {
						xlglSubDocTracking.setSumStatus("3");
						// }
					}
				} else {
					if ("0".equals(read)) {
						xlglSubDocTracking.setSumStatus("1");
					} else {
						xlglSubDocTracking.setSumStatus("0");
					}
				}
				Map<String, Object> hashmap = new HashMap<String, Object>();
				hashmap.put("id", xlglSubDocTracking.getInfoId());
				hashmap.put("type", "4");
				List<XlglPicture> queryList = xlglPictureService.queryListByType(hashmap);
				if (queryList.size() > 0) {
					if (queryList.get(0).getFileId().equals(xlglSubDocTracking.getInfoId())) {
						xlglSubDocTracking.setPicturePath(queryList.get(0).getPictureId());
					}
				}
			}
		}

		GwPageUtils pageUtil = new GwPageUtils(list);
		Response.json(pageUtil);

	}

	/**
	 * 训练档案分析--训练成绩清单
	 *@param 排序类型 type：1：强装，2：个人自学，3：军事体育，4：战略训练，5：专业训练，6：共同训练，7：军事职业教育
	 */
	@ResponseBody
	@RequestMapping("/getXlCoreList")
	public void getXlCoreList(String userNames, String depId, String type,String time) {
		Calendar calendar = Calendar.getInstance();
		String year = String.valueOf(calendar.get(Calendar.YEAR));//默认查询的是当前年，若time有值，查对应的年份
		if(StringUtils.isNotBlank(time)){
			year = time;
		}
		String organId = baseAppOrgMappedService.getBareauByUserId(CurrentUser.getUserId());
		Map<String, Object> hashmap = new HashMap<String, Object>();

		if (StringUtils.isNotBlank(depId)) {
			hashmap.put("organId", depId);
			//hashmap.put("depId", depId);
		} else {
			hashmap.put("organId", organId);
		}

		hashmap.put("userNames", userNames);
		//hashmap.put("year", year);
		// 获取局内所有的人
		List<BaseAppUser> list = baseAppUserService.queryAllUserIdAndName(hashmap);
		Map<String, Object> countMap = xlglSubDocTrackingService.queryAllCountList(year);
		Map<String, Object> wcCountMap = xlglSubDocTrackingService.quereyWcCountList(year);
		Map<String, XlglPhysical> queryPhysicalMap = xlglPhysicalService.queryByUserIdList(year);//所有用户的军事导入成绩
		Map<String, XlglMineStudy> queryMineStudyMap = xlglMineStudyService.queryByUserIdList(year);//所有用户的自学成绩
		List<XlglExamMainAnswer> commonList1 = xlglExamMainAnswerService.findListAllExam(hashmap);	//所有的考试科目
		String string2 = redisUtil.getString("queryExamineMap-getXlCoreList");
		Map<String, XlglExamMainAnswer> queryExamineMap = new HashMap<String, XlglExamMainAnswer>();
		if(StringUtils.isBlank(string2)) {
			 queryExamineMap = xlglExamMainAnswerService.queryExamineIdAndReplyUserId(hashmap);//所有考试每个已考人员的成绩
		}
		 
		JSONArray jsonArray = new JSONArray();
		if (list != null && list.size() > 0) {
			for (BaseAppUser baseAppUser : list) {
				JSONObject jsonObject = new JSONObject();
				String userName = baseAppUser.getTruename();// 名字
				jsonObject.put("userName", userName);
				jsonObject.put("deptName", baseAppUser.getDeptName());

				// 强装兴装大讲堂得分 ------------------start
				int sum = 0;
				if(countMap.containsKey(baseAppUser.getUserId())) {
					sum =(Integer) countMap.get(baseAppUser.getUserId());
				}
				int count = 0;
				if(wcCountMap.containsKey(baseAppUser.getUserId())) {
					count =(Integer) wcCountMap.get(baseAppUser.getUserId());
				}
				String dj = "--";
				float f = 0;
				if (count == 0) {
					f = 0;
				} else {
					f = (float) ((new BigDecimal((float) count / sum).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue()) * 100);//强装兴装大讲堂得分
					if (f < 0.6) {
						dj = "不及格";
					} else if (f >= 0.6 && f < 0.75) {
						dj = "及格";
					} else if (f >= 0.75 && f < 0.9) {
						dj = "良好";
					} else {
						dj = "优秀";
					}
				}

				jsonObject.put("djt", f);
				jsonObject.put("djtdj", dj);
				// 强装兴装大讲堂得分 ------------------end

				// 军事体育成绩得分----------------------start
				XlglPhysical xlglPhysical = new XlglPhysical();
				if(queryPhysicalMap.containsKey(baseAppUser.getId())) {
					xlglPhysical = queryPhysicalMap.get(baseAppUser.getId());
				}
				String jtScore = "0";
				String jtDj = "--";
				String up = "";//引体向上
				String dan="";//单杠
				String fwc="";//俯卧撑
				String sit = "";
				String srun = "";
				String trun = "";
				String sex = "";
				String age = "";
				String ytxs = "";
				String ywqz = "";
				String sxp = "";
				String cpf = "";
				String cpm = "";
				String judge = "";

				String weight = "";//体重
				String birthday = "";//出生日期
				String high = "";//身高
				if (xlglPhysical != null) {
					if (StringUtils.isNotBlank(xlglPhysical.getWight())) {
						weight = xlglPhysical.getWight();
					}
					if (StringUtils.isNotBlank(xlglPhysical.getBirthday())) {
						birthday = xlglPhysical.getBirthday();
					}
					if (StringUtils.isNotBlank(xlglPhysical.getHigh())) {
						high = xlglPhysical.getHigh();
					}

					if (StringUtils.isNotBlank(xlglPhysical.getAllScore())) {
						jtScore = xlglPhysical.getAllScore();
					}
					if (StringUtils.isNotBlank(xlglPhysical.getAllJudge())) {
						jtDj = xlglPhysical.getAllJudge();
					}
					if(StringUtils.isNotBlank(xlglPhysical.getAge())){
						age = xlglPhysical.getAge();
					}
					if(StringUtils.isNotBlank(xlglPhysical.getUp())){
						String agestr="0";
						if(StringUtils.isNotBlank(xlglPhysical.getAge())) {
							String s = xlglPhysical.getAge();
							if(s.contains(".")){
								agestr = xlglPhysical.getAge().substring(0,age.indexOf("."));
							}else {
								agestr = xlglPhysical.getAge();
							}
						}
						if(StringUtils.isNotBlank(xlglPhysical.getAge()) && Integer.parseInt(agestr)>=40) {
							fwc =xlglPhysical.getUp();
						}else if(StringUtils.isNotBlank(xlglPhysical.getAge()) && Integer.parseInt(agestr)<40) {
							if(StringUtils.isNotBlank(xlglPhysical.getSex()) && xlglPhysical.getSex().equals("女")) {
								dan =xlglPhysical.getUp();
							}else {
								up=xlglPhysical.getUp();
							}
						}else {
							up=xlglPhysical.getUp();
						}

					}
					if(StringUtils.isNotBlank(xlglPhysical.getSit())){
						sit = xlglPhysical.getSit();
					}
					if(StringUtils.isNotBlank(xlglPhysical.getSrun())){
						srun = xlglPhysical.getSrun();
					}
					if(StringUtils.isNotBlank(xlglPhysical.getTrun())){
						trun = xlglPhysical.getTrun();
					}
					if(StringUtils.isNotBlank(xlglPhysical.getSex())){
						sex = xlglPhysical.getSex();
					}

					if(StringUtils.isNotBlank(xlglPhysical.getYtxs())){
						ytxs = xlglPhysical.getYtxs();
					}
					if(StringUtils.isNotBlank(xlglPhysical.getYwqz())){
						ywqz = xlglPhysical.getYwqz();
					}
					if(StringUtils.isNotBlank(xlglPhysical.getSxp())){
						sxp = xlglPhysical.getSxp();
					}
					if(StringUtils.isNotBlank(xlglPhysical.getCpf())){
						cpf = xlglPhysical.getCpf();
					}
					if(StringUtils.isNotBlank(xlglPhysical.getCpm())){
						cpm = xlglPhysical.getCpm();
					}
					if(StringUtils.isNotBlank(xlglPhysical.getJudge())){
						judge = xlglPhysical.getJudge();
					}
				}
				jsonObject.put("weight", weight);// 体重
				jsonObject.put("birthday", birthday);// 出生日期
				jsonObject.put("high",high);//身高
				jsonObject.put("up",up);//引体向上
				jsonObject.put("dan",dan);//单杠
				jsonObject.put("fwc",fwc);//俯卧撑

				jsonObject.put("jtScore", jtScore);// 得分
				jsonObject.put("jtDj", jtDj);// 等级
				jsonObject.put("sit",sit);//仰卧起坐
				jsonObject.put("srun",srun);//蛇形跑
				jsonObject.put("trun",trun);//3000米长跑
				jsonObject.put("sex",sex);//性别
				if(StringUtils.isNotBlank(age)){
					if(age.contains(".")){
						jsonObject.put("age",age.substring(0,age.indexOf(".")));//年龄
					}else {
						jsonObject.put("age",age);//年龄
					}
				}else {
					jsonObject.put("age","0");//年龄
				}
				if(StringUtils.isNotBlank(ytxs)){
					if(ytxs.contains(".")){
						jsonObject.put("ytxs",ytxs.substring(0,ytxs.indexOf(".")));//引体向上
					}else {
						jsonObject.put("ytxs",ytxs);//引体向上
					}
				}else {
					jsonObject.put("ytxs","0");//引体向上
				}
				if(StringUtils.isNotBlank(ywqz)){
					if(ywqz.contains(".")){
						jsonObject.put("ywqz",ywqz.substring(0,ywqz.indexOf(".")));//仰卧起坐
					}else {
						jsonObject.put("ywqz",ywqz);//仰卧起坐
					}
				}else {
					jsonObject.put("ywqz","0");//仰卧起坐
				}
				jsonObject.put("sxp",sxp);//蛇形跑
				jsonObject.put("cp",cpf+cpm);
				jsonObject.put("judge",judge);//体型
				// 军事体育成绩得分-----------------------end

				// 自学成绩得分------------------------------start
				XlglMineStudy xlglMineStudy = new XlglMineStudy();
				if(queryMineStudyMap.containsKey(baseAppUser.getId())) {
					xlglMineStudy = queryMineStudyMap.get(baseAppUser.getId());
				}
				String studyScore = "0";
				String studyDj = "--";
				if (xlglMineStudy != null) {
					if (StringUtils.isNotBlank(xlglMineStudy.getScore())) {
						studyScore = xlglMineStudy.getScore();// 自学成绩得分
					}
					if (StringUtils.isNotBlank(xlglMineStudy.getDj())) {
						studyDj = xlglMineStudy.getDj();// 自学成绩等级
					}
				}
				jsonObject.put("studyScore", studyScore);
				jsonObject.put("studyDj", studyDj);
				// 自学成绩得分-------------------------------end
				//训练管理-当前用户已经考过考试-----------------start
				JSONArray jsonArrayExam = new JSONArray();
				if(commonList1 != null && commonList1.size() > 0){
					for(XlglExamMainAnswer xlglExamMainAnswer : commonList1){
						JSONObject jsonExam = new JSONObject();
						String examId  = xlglExamMainAnswer.getExamineId();
						if(redisUtil.getString(examId+"-"+baseAppUser.getUserId()+"-getXlCoreList") !=null) {
							String string = redisUtil.getString(examId+"-"+baseAppUser.getUserId()+"-getXlCoreList");
							JSONObject parseObject = JSONObject.parseObject(string);
							jsonExam.put("xlglExamName",parseObject.get("xlglExamName"));
							jsonExam.put("xlglCore",parseObject.get("xlglCore"));
							jsonExam.put("xlglLevel",parseObject.get("xlglLevel"));
							jsonArrayExam.add(jsonExam);
						}else {
							if(queryExamineMap != null && queryExamineMap.containsKey(examId+"-"+baseAppUser.getUserId())){
								XlglExamMainAnswer xlglExamMainAnswer2 = queryExamineMap.get(examId+"-"+baseAppUser.getUserId());
								jsonExam.put("xlglExamName",xlglExamMainAnswer.getExamineName());
								jsonExam.put("xlglCore",xlglExamMainAnswer2.getFractionsum());
								jsonExam.put("xlglLevel",xlglExamMainAnswer2.getLevel());
								jsonArrayExam.add(jsonExam);
								redisUtil.setString(examId+"-"+baseAppUser.getUserId()+"-getXlCoreList",JSONObject.toJSONString(jsonExam) ,7200);
								redisUtil.setString("queryExamineMap-getXlCoreList","queryExamineMap",7200);
							}else {
								jsonExam.put("xlglExamName","--");
								jsonExam.put("xlglCore","--");
								jsonExam.put("xlglLevel","--");
								jsonArrayExam.add(jsonExam);
							}
						}
					}
				}
				jsonObject.put("examine", jsonArrayExam);
				// 共同训练，专业训练，战略训练，军事训练 ------------------end
				jsonArray.add(jsonObject);
			}
		}
		Response.json(jsonArray);

	}

	/**
	 * 档案分析，考试成绩加载列表展示
	 */
	@ResponseBody
	@RequestMapping("/getExam")
	public void getExam(String time){
		Calendar calendar = Calendar.getInstance();
		String year = String.valueOf(calendar.get(Calendar.YEAR));//默认查询的是当前年，若time有值，查对应的年份
		Map<String,Object> map = new HashMap<>();
		if(StringUtils.isNotBlank(time)) {
			year = time;
		}
		//map.put("year",year);
		List list = new ArrayList();
		JSONObject jsonObject = new JSONObject();
		List<XlglExamMainAnswer> commonList = xlglExamMainAnswerService.findListAllExam(map);
		if(commonList != null && commonList.size() > 0){
			for(XlglExamMainAnswer xlglExamMainAnswer : commonList){
				String exam = xlglExamMainAnswer.getExamineName();
				list.add(exam);
			}
		}

		Response.json("result",list);

	}

	/**
	 * 获取当前登录人的角色 flag 角色标识（3：局长；4：局秘书；5：处长；6：参谋；2：首长秘书；1：首长；）
	 */
	@ResponseBody
	@RequestMapping("/getRoleSet")
	public void getRoleSet() {
		JSONObject jsonObject = new JSONObject();
		String flag = "";
		String userId = CurrentUser.getUserId();
		XlglRoleSet xlglRoleSet = xlglRoleSetService.queryByuserId(userId);
		if (xlglRoleSet != null) {
			flag = xlglRoleSet.getRoleFlag();
			jsonObject.put("flag", flag);
		} else {
			jsonObject.put("flag", "no");
		}
		Response.json(jsonObject);
	}

}
