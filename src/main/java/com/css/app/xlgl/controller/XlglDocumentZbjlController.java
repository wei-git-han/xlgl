package com.css.app.xlgl.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.css.addbase.appconfig.service.BaseAppConfigService;
import com.css.addbase.apporgan.entity.BaseAppOrgan;
import com.css.addbase.apporgan.entity.BaseAppUser;
import com.css.addbase.apporgan.service.BaseAppOrganService;
import com.css.addbase.apporgan.service.BaseAppUserService;
import com.css.addbase.apporgmapped.service.BaseAppOrgMappedService;
import com.css.addbase.msg.MSGTipDefined;
import com.css.addbase.msg.MsgTipUtil;
import com.css.addbase.msg.entity.MsgTip;
import com.css.addbase.msg.service.MsgTipService;
import com.css.addbase.orgservice.OrgService;
import com.css.app.db.business.entity.SubDocInfo;
import com.css.app.db.config.service.AdminSetService;
import com.css.app.xlgl.entity.XlglDocumentZbjl;
import com.css.app.xlgl.entity.XlglExamMainAnswer;
import com.css.app.xlgl.entity.XlglSubDocInfo;
import com.css.app.xlgl.entity.XlglSubDocTracking;
import com.css.app.xlgl.entity.XlglXlzzInfo;
import com.css.app.xlgl.service.XlglDocumentZbjlService;
import com.css.app.xlgl.service.XlglExamMainAnswerService;
import com.css.app.xlgl.service.XlglSubDocInfoService;
import com.css.app.xlgl.service.XlglSubDocTrackingService;
import com.css.app.xlgl.service.XlglXlzzInfoService;
import com.css.base.utils.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
    private AdminSetService adminSetService;
    @Autowired
    private MsgTipService msgService;
    @Autowired
    private MsgTipUtil msgUtil;
    @Value("${csse.dccb.appId}")
    private  String appId;
    @Value("${csse.dccb.appSecret}")
    private  String clientSecret;
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
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("xlgldocumentzbjl:list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<XlglDocumentZbjl> xlglDocumentZbjlList = xlglDocumentZbjlService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(xlglDocumentZbjlList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	@RequiresPermissions("xlgldocumentzbjl:info")
	public void info(@PathVariable("id") String id){
		XlglDocumentZbjl xlglDocumentZbjl = xlglDocumentZbjlService.queryObject(id);
		Response.json("xlglDocumentZbjl", xlglDocumentZbjl);
	}
	
	/**
	 * 分发接口
     * fileId为文件的id
     * idAndNames   局id和名字以逗号连接，局与局已分好连接
     * 4832975928423057,信息系统局;385934762908523490,保密局
	 */
	@ResponseBody
	@RequestMapping("/send")
	public void send(String fileId,String idAndNames,String deptIds,String deptNames) {
        if (StringUtils.isNotBlank(fileId) && StringUtils.isNotBlank(idAndNames)) {
            String organId = baseAppOrgMappedService.getBareauByUserId(CurrentUser.getUserId());
            BaseAppOrgan org = baseAppOrganService.queryObject(organId);
            //添加转办记录
            XlglDocumentZbjl xlglDocumentZbjl = new XlglDocumentZbjl();
            xlglDocumentZbjl.setId(UUIDUtils.random());
            xlglDocumentZbjl.setInfoId(fileId);
            xlglDocumentZbjl.setReceiverIds(deptIds);
            xlglDocumentZbjl.setReceiverNames(deptNames);
            xlglDocumentZbjl.setCreatedTime(new Date());
            xlglDocumentZbjl.setOrgName(org.getName());
            xlglDocumentZbjlService.save(xlglDocumentZbjl);
            //添加各分支记录
            String[] ids = idAndNames.split(";");
            List<String> subDeptIds = xlglSubDocInfoService.queryAllSubDeptIds(fileId);
            for (int i = 0; i < ids.length; i++) {
                String[] idAndName = ids[i].split(",");
                String deptId = idAndName[0];
                String deptName = idAndName[1];
                if (!subDeptIds.contains(deptId)) {
                    XlglSubDocInfo xlglSubDocInfo = new XlglSubDocInfo();
                    xlglSubDocInfo.setId(UUIDUtils.random());
                    xlglSubDocInfo.setInfoId(fileId);
                    xlglSubDocInfo.setCreatedTime(new Date());
                    xlglSubDocInfo.setSubDeptId(deptId);
                    xlglSubDocInfo.setSubDeptName(deptName);
                    xlglSubDocInfoService.save(xlglSubDocInfo);
                }
                //获取局管理员,给局管理员发送消息提醒
                List<String> userIds = adminSetService.queryUserIdByOrgId(deptId);
                if (userIds != null && userIds.size() > 0) {
                    for (String user : userIds) {
                        MsgTip msg = msgService.queryObject(MSGTipDefined.DCCB_BU_ZHUANBAN_MSG_TITLE);
                        if (msg != null) {
                            String msgUrl = "";
                            for (String userId : userIds) {
                                msgUtil.sendMsg(msg.getMsgTitle(), msg.getMsgContent(), msgUrl, userId, appId, clientSecret, msg.getGroupName(), msg.getGroupRedirect(), "", "true");
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
    public void sendToUsers(String fileId,String subId) {
        XlglXlzzInfo xlglXlzzInfo = xlglXlzzInfoService.queryObject(fileId);
        String organId = baseAppOrgMappedService.getBareauByUserId(CurrentUser.getUserId());
        List<BaseAppUser> list = baseAppUserService.queryAllUserIdAndName(organId);
        if (list != null && list.size() > 0) {
            XlglSubDocInfo subInfo = xlglSubDocInfoService.queryObject(subId);
            subInfo.setIsSend("1");//更新状态，已分发
            xlglSubDocInfoService.update(subInfo);
            for (BaseAppUser baseAppUser : list) {
                String receiverId = baseAppUser.getUserId();
                String receiverName = baseAppUser.getTruename();
                String userOrganId = baseAppUser.getOrganid();
                BaseAppOrgan organ = baseAppOrganService.queryObject(userOrganId);
                String deptName = organ.getName();
                //转办记录
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
                xlglDocumentZbjlService.save(xl);
                //流转记录
                XlglSubDocTracking tracking = new XlglSubDocTracking();
                String loginUserName = CurrentUser.getUsername();
                String loginUserDeptId = CurrentUser.getDepartmentId();
                String loginUserDeptName = CurrentUser.getOrgName();
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
                tracking.setTrackingType("1");
                tracking.setPreviousStatus(subInfo.getDocStatus());
                tracking.setUndertaker(subInfo.getUndertaker());
                tracking.setBaoming("0");
                tracking.setTitle(xlglXlzzInfo.getTitle());
                tracking.setTrackingType(xlglXlzzInfo.getXltype());//训练类型
                xlglSubDocTrackingService.save(tracking);

                //发送消息提醒
                MsgTip msg = msgService.queryObject(MSGTipDefined.DCCB_JU_ZHUANBAN_MSG_TITLE);
                if (msg != null) {
                    String msgUrl = "";
                    if (StringUtils.isNotBlank(receiverId)) {
                        msgUtil.sendMsg(msg.getMsgTitle(), msg.getMsgContent(), msgUrl, receiverId, appId, clientSecret, msg.getGroupName(), msg.getGroupRedirect(), "", "true");
                    }
                }

            }
            Response.json("result", "success");
        } else {
            Response.json("result", "faild");
        }

    }
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("xlgldocumentzbjl:update")
	public void update(@RequestBody XlglDocumentZbjl xlglDocumentZbjl){
		xlglDocumentZbjlService.update(xlglDocumentZbjl);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("xlgldocumentzbjl:delete")
	public void delete(@RequestBody String[] ids){
		xlglDocumentZbjlService.deleteBatch(ids);
		
		Response.ok();
	}

    /**
     * 报名接口
     * @param infoId
     * @param subId
     * @param baoming 0未报名，1已报名，2延后
     * @param reason
     */
	@ResponseBody
    @RequestMapping("/baoming")
	public void baoming(String infoId,String subId,String baoming,String reason){
	    String userId = CurrentUser.getUserId();
	    XlglSubDocTracking xlglSubDocTracking = xlglSubDocTrackingService.querybaoming(infoId,subId,userId);
	    xlglSubDocTracking.setBaoming(baoming);
	    if("2".equals(baoming) && StringUtils.isNotBlank(reason)){
	        xlglSubDocTracking.setReason(reason);
        }
        xlglSubDocTrackingService.update(xlglSubDocTracking);

    }

    /**
     * 局内分发列表查询
     * @param page
     * @param pagesize
     * @param search
     * isSend字段代表是否分发  0未分发，1已分发
     */
    @ResponseBody
    @RequestMapping("/juList")
    public void juList(Integer page, Integer pagesize, String search,String xltype) {
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
        GwPageUtils pageUtil = new GwPageUtils(list);
        Response.json(pageUtil);
    }


    /**
     * 训练组织个人列表
     * @param page
     * @param pagesize
     * @param search
     */
    @ResponseBody
    @RequestMapping("/personList")
    public void personList(Integer page, Integer pagesize, String search,String type){
        List<XlglSubDocTracking> list = null;
        String userId = CurrentUser.getUserId();
        Map<String,Object> map = new HashMap<String,Object>();
        if(StringUtils.isNotBlank(userId)){
            map.put("userId",userId);
        }
        if(StringUtils.isNotBlank(search)){
            map.put("search",search);
        }
        if(StringUtils.isNotBlank(type)){
            map.put("type",type);
        }

        PageHelper.startPage(page,pagesize);
        list = xlglSubDocTrackingService.queryListForPerson(map);
        GwPageUtils pageUtil = new GwPageUtils(list);
        Response.json(pageUtil);


    }


    /**
     * 训练档案分析--训练成绩清单
     */
    @ResponseBody
    @RequestMapping("/getXlCoreList")
    public void getXlCoreList(){
        String organId = baseAppOrgMappedService.getBareauByUserId(CurrentUser.getUserId());
        //获取局内所有的人
        List<BaseAppUser> list = baseAppUserService.queryAllUserIdAndName(organId);
        JSONArray jsonArray = new JSONArray();
        if(list != null && list.size() > 0){
            for(BaseAppUser baseAppUser : list){
                JSONObject jsonObject = new JSONObject();
                String userOrganId = baseAppUser.getOrganid();
                String userName = baseAppUser.getTruename();//名字
                jsonObject.put("userName",userName);
                BaseAppOrgan organ = baseAppOrganService.queryObject(userOrganId);
                String deptName = organ.getName();//部门名称
                jsonObject.put("deptName",deptName);
                String userId = CurrentUser.getUserId();
                //强装兴装大讲堂得分 ------------------start
                int sum = xlglSubDocTrackingService.queryAllCount(userId);
                int count = xlglSubDocTrackingService.quereyWcCount(userId);
                float f = count/sum;//强装兴装大讲堂得分
                String dj = "优秀，目前写死";
                jsonObject.put("f",f);
                jsonObject.put("dj",dj);
                //强装兴装大讲堂得分 ------------------end

                //共同训练，专业训练，战略训练，军事训练 ------------------start
                String gongtongxunlian = "99";
                String gongtongxunliandengji = "优秀";
                jsonObject.put("gongtongxunlian",gongtongxunlian);
                jsonObject.put("gongtongxunliandengji",gongtongxunliandengji);
                //共同训练，专业训练，战略训练，军事训练 ------------------end
                Map<String, Object> map = new HashMap<String,Object>();
                map.put("replyUserId", baseAppUser.getUserId());
                map.put("examineSubjectName", "共同训练");
                List<XlglExamMainAnswer> commonList = xlglExamMainAnswerService.findListBySubjectId(map);
                map.put("examineSubjectName", "专业训练");
                List<XlglExamMainAnswer> specialtyList = xlglExamMainAnswerService.findListBySubjectId(map);
                map.put("examineSubjectName", "战略训练");
                List<XlglExamMainAnswer> tacticalList = xlglExamMainAnswerService.findListBySubjectId(map);
                map.put("examineSubjectName", "军事训练");
                List<XlglExamMainAnswer> warList = xlglExamMainAnswerService.findListBySubjectId(map);
                jsonObject.put("common", commonList.get(0));
                jsonObject.put("specialty", specialtyList.get(0));
                jsonObject.put("tactical", tacticalList.get(0));
                jsonObject.put("war", warList.get(0));
                jsonArray.add(jsonObject);

            }
        }

        Response.json(jsonArray);

    }



}
