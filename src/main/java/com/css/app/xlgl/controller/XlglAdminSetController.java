package com.css.app.xlgl.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.css.addbase.apporgan.entity.BaseAppOrgan;
import com.css.addbase.apporgan.entity.BaseAppUser;
import com.css.addbase.apporgan.service.BaseAppOrganService;
import com.css.addbase.apporgan.service.BaseAppUserService;
import com.css.app.xlgl.entity.XlglAdminSet;
import com.css.app.xlgl.service.XlglAdminSetService;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.GwPageUtils;
import com.css.base.utils.Response;
import com.css.base.utils.UUIDUtils;
import com.github.pagehelper.PageHelper;

@Controller
@RequestMapping("/app/xlgl/adminset")
public class XlglAdminSetController {
	private final Logger logger = LoggerFactory.getLogger(XlglAdminSetController.class);
	
	@Autowired
	private XlglAdminSetService adminSetService;
	@Autowired
	private BaseAppOrganService baseAppOrganService;	
	@Autowired
	private BaseAppUserService baseAppUserService;	

	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	public void list(Integer page, Integer pagesize ,String adminType){
		PageHelper.startPage(page, pagesize);
		Map<String, Object > map = new HashMap<>();
		map.put("adminType", adminType);
		List<XlglAdminSet> adminSetList = adminSetService.queryList(map);
		GwPageUtils pageUtil = new GwPageUtils(adminSetList);
		Response.json(pageUtil);
	}
	
	/**
	 * 局管理员列表
	 */
	@ResponseBody
	@RequestMapping("/juList")
	public void juList(Integer page, Integer pagesize ,String adminType){
		List<XlglAdminSet> adminSetList=null;
		String loginUserId = CurrentUser.getUserId();
		//获取当前人的管理员类型（0:超级管理员 ;1：部管理员；2：局管理员；3：即是部管理员又是局管理员;4:处管理员）
		String adminFlag = adminSetService.getAdminTypeByUserId(loginUserId);
		PageHelper.startPage(page, pagesize);
		if(StringUtils.equals("2", adminFlag) || StringUtils.equals("3", adminFlag)) {
			adminSetList=adminSetService.queryJuAdminList(loginUserId);
		}else {
			Map<String, Object > map = new HashMap<>();
			map.put("adminType", adminType);
			adminSetList = adminSetService.queryList(map);
			for (XlglAdminSet adminSet : adminSetList) {
				adminSet.setEditFlag("1");
			}
		}
		GwPageUtils pageUtil = new GwPageUtils(adminSetList);
		Response.json(pageUtil);
	}
	
	/**
	 * 处管理员列表
	 */
	@ResponseBody
	@RequestMapping("/chuList")
	public void chuList(Integer page, Integer pagesize ,String adminType){
		List<XlglAdminSet> adminSetList=null;
		String loginUserId = CurrentUser.getUserId();
		//获取当前人的管理员类型（0:超级管理员 ;1：部管理员；2：局管理员；3：即是部管理员又是局管理员;4:处管理员）
		String adminFlag = adminSetService.getAdminTypeByUserId(loginUserId);
		PageHelper.startPage(page, pagesize);
		if(StringUtils.equals("2", adminFlag) || StringUtils.equals("3", adminFlag)||StringUtils.equals("4", adminFlag)) {
			adminSetList=adminSetService.queryChuAdminList(loginUserId);
		}else {
			Map<String, Object > map = new HashMap<>();
			map.put("adminType", adminType);
			adminSetList = adminSetService.queryList(map);
			for (XlglAdminSet adminSet : adminSetList) {
				adminSet.setEditFlag("1");
			}
		}
		GwPageUtils pageUtil = new GwPageUtils(adminSetList);
		Response.json(pageUtil);
	}
	
	
	/**
	 * 	获取某人的管理员类型（0:超级管理员 ;1：部管理员；2：局管理员；3：即是部管理员又是局管理员;4:处管理员）
	 */
	@ResponseBody
	@RequestMapping("/getAuthor")
	public void getAuthor(){
		String adminFlag = adminSetService.getAdminTypeByUserId(CurrentUser.getUserId());
		Response.json(adminFlag);
	}
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info")
	public void info(String id){
		XlglAdminSet adminSet = adminSetService.queryObject(id);
		Response.json(adminSet);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/saveOrUpdate")
	public void save(XlglAdminSet adminSet){
		String deptId="";
		String deptName="";
		String orgName="";
		String orgId="";
		String userId = adminSet.getUserId();
		if(StringUtils.isNotBlank(userId)) {
			orgId = baseAppUserService.getBareauByUserId(userId);
			if(StringUtils.isNotBlank(orgId)) {
				BaseAppOrgan organ = baseAppOrganService.queryObject(orgId);
				if(organ != null) {
					orgName=organ.getName();
				}
			}
			List<BaseAppUser> users = baseAppUserService.findByUserId(userId);
			if(users != null) {
				deptId = users.get(0).getOrganid();
				BaseAppOrgan dept = baseAppOrganService.queryObject(deptId);
				if(dept != null) {
					deptName=dept.getName();
				}
			}
		}
		if(StringUtils.isNotBlank(adminSet.getId())) {
            Map<String, Object> adminMap = new HashMap<>();
            adminMap.put("userId", adminSet.getUserId());
            //如果是处管理员，不能添加局管理员
        	if(adminSet.getAdminType().equals("2")) {
        		adminMap.put("adminType", "4");
        		List<XlglAdminSet> chuList = adminSetService.queryList(adminMap);
        		if(chuList.size()>0) {
        			Response.json("result", "ischu");
    				return;
        		}
        	//如果是局管理员，不能添加处管理员
        	}else if(adminSet.getAdminType().equals("4")){
        		adminMap.put("adminType", "2");
        		List<XlglAdminSet> juList = adminSetService.queryList(adminMap);
        		if(juList.size()>0) {
        			Response.json("result", "isju");
    				return;
        		}
        	}
            adminMap.put("adminType", adminSet.getAdminType());
            List<XlglAdminSet> queryList = adminSetService.queryList(adminMap);
            if(queryList != null && queryList.size()>0) {
                Response.json("result", "exist");
                return;
            }else {
                adminSet.setDeptId(deptId);
                adminSet.setDeptName(deptName);
                adminSet.setOrgId(orgId);
                adminSet.setOrgName(orgName);
                adminSet.setOrgName(orgName);
                adminSetService.update(adminSet);
            }
        }else {
        	Map<String, Object> adminMap = new HashMap<>();
        	adminMap.put("userId", adminSet.getUserId());
        	//如果是处管理员，不能添加局管理员
        	if(adminSet.getAdminType().equals("2")) {
        		adminMap.put("adminType", "4");
        		List<XlglAdminSet> chuList = adminSetService.queryList(adminMap);
        		if(chuList.size()>0) {
        			Response.json("result", "ischu");
    				return;
        		}
        	//如果是局管理员，不能添加处管理员
        	}else if(adminSet.getAdminType().equals("4")){
        		adminMap.put("adminType", "2");
        		List<XlglAdminSet> juList = adminSetService.queryList(adminMap);
        		if(juList.size()>0) {
        			Response.json("result", "isju");
    				return;
        		}
        	}
			
			adminMap.put("adminType", adminSet.getAdminType());
			
			List<XlglAdminSet> queryList = adminSetService.queryList(adminMap);
			if(queryList != null && queryList.size()>0) {
				Response.json("result", "exist");
				return;
			}else {
				adminSet.setId(UUIDUtils.random());
				adminSet.setDeptId(deptId);
				adminSet.setDeptName(deptName);
				adminSet.setOrgId(orgId);
				adminSet.setOrgName(orgName);
				adminSetService.save(adminSet);
			}
		}
		Response.json("result", "success");
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public void delete(String ids){
		Date date = new Date();
		logger.info("当前操作人："+CurrentUser.getUsername()+"---id:"+CurrentUser.getUserId()+"--时间是："+date);
		String[] idArry = ids.split(",");
		adminSetService.deleteBatch(idArry);
		Response.json("result","success");
	}

}
