package com.css.app.xlgl.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.css.addbase.apporgan.entity.BaseAppOrgan;
import com.css.addbase.apporgan.service.BaseAppOrganService;
import com.css.addbase.apporgan.service.BaseAppUserService;
import com.css.addbase.apporgan.util.OrgUtil;
import com.css.app.xlgl.config.entity.XlglRoleSet;
import com.css.app.xlgl.config.service.XlglRoleSetService;
import com.css.app.xlgl.entity.XlglAdminSet;
import com.css.app.xlgl.entity.XlglExamExamine;
import com.css.app.xlgl.entity.XlglExamMainAnswer;
import com.css.app.xlgl.service.XlglAdminSetService;
import com.css.app.xlgl.service.XlglExamExamineService;
import com.css.app.xlgl.service.XlglExamMainAnswerService;
import com.css.base.entity.SSOUser;
import com.css.base.filter.SSOAuthFilter;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.PageUtils;
import com.css.base.utils.Response;
import com.css.base.utils.StringUtils;
import com.css.base.utils.UUIDUtils;
import com.github.pagehelper.PageHelper;


/**
 * 训练考核-考核清单-主表用户答题表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-03 11:36:19
 */
@Controller
@RequestMapping("app/xlgl/xlglexammainanswer")
public class XlglExamMainAnswerController {
	private final Logger logger = LoggerFactory.getLogger(XlglNewsController.class);
	
	@Autowired
	private XlglExamMainAnswerService xlglExamMainAnswerService;
	@Autowired
	private XlglExamExamineService xlglExamExamineService;
	@Autowired
	private BaseAppOrganService baseAppOrganService;
	@Autowired
	private XlglRoleSetService xlglRoleSetService;
	@Autowired
	private XlglAdminSetService adminSetService;
	@Autowired
	private BaseAppUserService baseAppUserService;
	
	/**
	 *考核清单-参考人员/未考人员清单 列表
	 *@param examineId 试卷基本信息表id
	 *@param makeupStatus //补考考状态0：没补考考，1:补考了
	 *@param level 查询等级参数
	 *@param replyUserName 查询答题人名称
	 *@param organId 查询答题人的部门id
	 *@param isNotExam //考试状态 0:没考，1:考了
	 *@param status  //状态 0：考试，1：练习
	 *@param deptId 部门id
	 */
	@ResponseBody
	@RequestMapping("/list")
	public void list(Integer page, Integer limit,String examineId,String makeupStatus,String level,String replyUserName
			,String organId,String isNotExam,String status,String deptId){
		Map<String, Object> map = new HashMap<>();	
		map.put("examineId", examineId);
		map.put("level", level);
		map.put("makeupStatus", makeupStatus);
		map.put("replyUserName", replyUserName);
		map.put("organId", organId);
		map.put("isNotExam", isNotExam);
		map.put("status", status);
		if(StringUtils.isNotBlank(deptId)) {
			List<BaseAppOrgan> organs = baseAppOrganService.queryList(null);
			List<String> arrayList = new ArrayList<String>();
			arrayList = OrgUtil.getOrganTreeList(organs,deptId,true,true,arrayList);
			map.put("deptList", arrayList);
		}
		PageHelper.startPage(page, limit);
		//查询列表数据
		List<XlglExamMainAnswer> xlglExamMainAnswerList = xlglExamMainAnswerService.queryList(map);
		PageUtils pageUtil = new PageUtils(xlglExamMainAnswerList);
		Response.json("page",pageUtil);
	}
	
	/**
	 *考核清单-当前用户练习的成绩 列表
	 *@param examineId 试卷基本信息表id
	 */
	@ResponseBody
	@RequestMapping("/exerciseList")
	public void exerciseList(Integer page, Integer limit,String examineId){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		map.put("examineId", examineId);
		map.put("makeupStatus", "1");
		//查询列表数据
		List<XlglExamMainAnswer> xlglExamMainAnswerList = xlglExamMainAnswerService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(xlglExamMainAnswerList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info")
	public void info(String id){
		XlglExamMainAnswer xlglExamMainAnswer = xlglExamMainAnswerService.queryObject(id);
		Response.json("xlglExamMainAnswer", xlglExamMainAnswer);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	public void save(XlglExamMainAnswer xlglExamMainAnswer){
		xlglExamMainAnswer.setId(UUIDUtils.random());
		xlglExamMainAnswerService.save(xlglExamMainAnswer);
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public void update(XlglExamMainAnswer xlglExamMainAnswer){
		xlglExamMainAnswerService.update(xlglExamMainAnswer);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public void delete(String[] ids){
		xlglExamMainAnswerService.deleteBatch(ids);
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		logger.info("当前删除操作人："+CurrentUser.getUsername()+"---id:"+CurrentUser.getUserId()+"--时间是："+date);
		Response.ok();
	}
	/**
	 * 用户 具体情况以及交卷时间
	 * @param mainAnswerId 成绩单id
	 * @param examineId 考试id
	 * */
	@ResponseBody
	@RequestMapping("/getMainAnsUser")
	public void getMainAns(String mainAnswerId,String examineId) {
		JSONObject jsonObject = new JSONObject();
		XlglExamMainAnswer queryObject = null;
		XlglExamExamine queryObject2 = null;
		if(StringUtils.isNotBlank(mainAnswerId)) {
			queryObject=xlglExamMainAnswerService.queryObject(mainAnswerId);
			queryObject2=xlglExamExamineService.queryObject(queryObject.getExamineId());
		}else {
			Map<String, Object> map = new HashMap<>();	
			map.put("examineId", examineId);
			map.put("replyUserId", CurrentUser.getUserId());
			List<XlglExamMainAnswer> queryList = xlglExamMainAnswerService.queryList(map);
			if(queryList != null && queryList.size() > 0){
				queryObject=queryList.get(0);
				queryObject2=xlglExamExamineService.queryObject(queryObject.getExamineId());
			}

		}
		String orgName = "";
		BaseAppOrgan queryObject3 = baseAppOrganService.queryObject(queryObject.getOrganId());
		if(StringUtils.isNotBlank(queryObject3.getTreePath())) {
			String[] split = queryObject3.getTreePath().split(",");
			List<BaseAppOrgan> queryListByIds = baseAppOrganService.queryListByIds(split);
			for (BaseAppOrgan baseAppOrgan : queryListByIds) {
				if(baseAppOrgan.getParentId().equals("root")) {
					orgName = baseAppOrgan.getName()+"-";
					break;
				}
			}
		}
		jsonObject.put("time", queryObject.getUpdateDate());
		jsonObject.put("userName", queryObject.getReplyUserName());
		jsonObject.put("userId", queryObject.getReplyUserId());
		jsonObject.put("orgName", orgName+queryObject.getOrganName());
		jsonObject.put("orgId", queryObject.getOrganId());
		jsonObject.put("level", queryObject.getLevel());
		jsonObject.put("fractionsum", queryObject.getFractionsum());
		jsonObject.put("examineName", queryObject2.getExamineName());
		Response.json(jsonObject);
	}
	

}
