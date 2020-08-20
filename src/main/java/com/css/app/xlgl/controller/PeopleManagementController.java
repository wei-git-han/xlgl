package com.css.app.xlgl.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.css.addbase.apporgan.entity.BaseAppOrgan;
import com.css.addbase.apporgan.entity.BaseAppUser;
import com.css.addbase.apporgan.service.BaseAppOrganService;
import com.css.addbase.apporgan.service.BaseAppUserService;
import com.css.addbase.apporgmapped.entity.BaseAppOrgMapped;
import com.css.addbase.apporgmapped.service.BaseAppOrgMappedService;
import com.css.addbase.constant.AppConstant;
import com.css.addbase.constant.AppInterfaceConstant;
import com.css.app.xlgl.entity.XlglAdminSet;
import com.css.app.xlgl.service.XlglAdminSetService;
import com.css.base.utils.CrossDomainUtil;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.PageUtils;
import com.css.base.utils.Response;
import com.github.pagehelper.PageHelper;
/**
 * 
 * 日常管理-人员管理
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-03 11:36:19
 * 
 * */
@Controller
@RequestMapping("app/xlgl/peopleManagement")
public class PeopleManagementController {
	@Autowired
	private BaseAppOrgMappedService baseAppOrgMappedService;
	@Autowired
	private BaseAppOrganService baseAppOrganService;
	@Autowired
	private BaseAppUserService baseAppUserService;
	@Autowired
	private XlglAdminSetService adminSetService;

	/**
	 * 
	 * 各单位人员情况统计列表
	 * */
	@RequestMapping("/list")
	public void list(Integer page, Integer limit) {

		String userId = CurrentUser.getUserId();
		Map<String, Object> hashmap = new HashMap<>();
		hashmap.put("userId", userId);
		List<XlglAdminSet> queryList2 = adminSetService.queryList(hashmap);
		XlglAdminSet xlglAdminSet = queryList2.get(0);
		//管理员类型（1：部管理员；2：局管理员；3：参谋）
		boolean status = false;
		if(xlglAdminSet !=null) {
			switch (xlglAdminSet.getAdminType()) {
			case "1":
					status = true;
				break;
			case "2":
				status = true;
			break;
			case "4":
				status = true;
			break;
			default:
				break;
			}
		}
		LinkedMultiValueMap<String, Object> linkeMap = new LinkedMultiValueMap<String,Object>();
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		List<BaseAppOrgan> queryList = baseAppOrganService.queryList(map);
		PageUtils pageUtil = new PageUtils(queryList);
		for (BaseAppOrgan baseAppOrgan : queryList) {
			if(!status) {
				String str =baseAppOrgan.getId().equals(xlglAdminSet.getDeptId())?"1":"0";
				baseAppOrgan.setStatus(str);
			}else {
				baseAppOrgan.setStatus("1");
			}
			linkeMap.add("organId", baseAppOrgan.getId());
			JSONObject jsonData = this.getNumber(linkeMap);
			Integer yzwrs=(Integer)jsonData.get("yzwrs");
			Integer qjrs=(Integer)jsonData.get("qjrs");
			Integer xjrs=(Integer)jsonData.get("xjrs");
			int userIdList = this.userIdNumber();//实际在位人数
			int zwRate = (userIdList /yzwrs)*100; //人员在位率
			baseAppOrgan.setYzwrs(yzwrs);
			baseAppOrgan.setQjrs(qjrs);
			baseAppOrgan.setXjrs(xjrs);
			baseAppOrgan.setSjzwrs(userIdList);
			baseAppOrgan.setZwrate(zwRate);
		}
		Response.json("page",pageUtil);
	}
	
	/**
	 * 单位人员详情-鼠标悬停显示
	 * */
	@ResponseBody
	@RequestMapping("/qxjUserInto")
	public void list(String userId) {
		LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<String,Object>();
		map.add("userId", userId);
		// 获取办件开放的接口
		String elecPath = baseAppOrgMappedService.getWebUrl(AppConstant.APP_QXJGL, AppInterfaceConstant.WEB_INTERFACE_QXJ_USER_INFO_QJDAYS);
		JSONObject jsonData = CrossDomainUtil.getJsonData(elecPath,map);

		Response.json(jsonData);
	}
	
	/**
	 * 单位人员统计列表
	 * */
	@ResponseBody
	@RequestMapping("/qxjUserInfoList")
	public void qxjUserInfoList(Integer page, Integer limit,String organId) {
		LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<String,Object>();
		Map<String, Object> hashmap = new HashMap<>();
		map.add("organId", organId);
		hashmap.put("organId", organId);
		PageHelper.startPage(page, limit);
		List<BaseAppUser> queryListByOrganid = baseAppUserService.queryListByOrganid(hashmap);
		PageUtils pageUtil = new PageUtils(queryListByOrganid);
		List<String> list = getUserArray();
		for (BaseAppUser baseAppUser : queryListByOrganid) {
			if(list.contains(baseAppUser.getAccount())) {
				baseAppUser.setReign("1");
			}else {
				baseAppUser.setReign("0");
			}
		}
	
		Response.json("page",pageUtil);
	}

	/**
	 * 全局人员情况-统计全局休假人数、请假人数、应在位人数(总人数-请假人数-休假人数)、人员在位率(实际在位人数/应在位人数)
	 * @param status 0:全部，1：一个部门
	 * */
	@ResponseBody
	@RequestMapping("/statistics")
	public void statistics(String status) {
		LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<String,Object>();
		if(status.equals("1")) {
			String organId = CurrentUser.getSSOUser().getOrganId();
			map.add("organId", organId);
		}
		JSONObject jsonData = this.getNumber(map);
		int userIdList = this.userIdNumber();//实际在位人数
		Integer object = (Integer)jsonData.get("zwrs");//应在位人数
		int zwRate = (userIdList /object)*100;
		jsonData.put("zwlv", zwRate);
		Response.json(jsonData);
	}
	
	/**
	 * 本局的单位人员情况-全局点击查看功能后
	 * 
	 * */
	@ResponseBody
	@RequestMapping("/listByOrganid")
	public void listByOrganid(String organId) {
		LinkedMultiValueMap<String, Object> linkeMap = new LinkedMultiValueMap<String,Object>();
		BaseAppOrgan baseAppOrgan = baseAppOrganService.queryObject(organId);
		linkeMap.add("organId", baseAppOrgan.getId());
		JSONObject jsonData = this.getNumber(linkeMap);
		Integer yzwrs=(Integer)jsonData.get("yzwrs");
		Integer qjrs=(Integer)jsonData.get("qjrs");
		Integer xjrs=(Integer)jsonData.get("xjrs");
		int userIdList = this.userIdNumber();//实际在位人数
		int zwRate = (userIdList /yzwrs)*100; //人员在位率
		baseAppOrgan.setYzwrs(yzwrs);
		baseAppOrgan.setQjrs(qjrs);
		baseAppOrgan.setXjrs(xjrs);
		baseAppOrgan.setSjzwrs(userIdList);
		baseAppOrgan.setZwrate(zwRate);
		Response.json("baseAppOrgan",baseAppOrgan);
	}
	

	
	private JSONObject getNumber(LinkedMultiValueMap<String, Object> map) {
		// 获取清销假app的接口
		String elecPath = baseAppOrgMappedService.getWebUrl(AppConstant.APP_QXJGL, AppInterfaceConstant.WEB_INTERFACE_QXJ_statistics);
		JSONObject jsonData = CrossDomainUtil.getJsonData(elecPath,map);
		return jsonData;
	}
	
	/**
	 * 在线人
	 */
	private  int userIdNumber() {
		return getUserArray().size();
	}
	/**
	 * 获得在位用户
	 * */
	private List<String> getUserArray() {
		List<String> accountList = new ArrayList<String>();
		LinkedMultiValueMap<String,Object> infoMap = new LinkedMultiValueMap<String,Object>();
		infoMap.add("arch", "arm64");
		BaseAppOrgMapped mapped = (BaseAppOrgMapped) baseAppOrgMappedService.orgMappedByOrgId(null, "root",
				AppInterfaceConstant.APP_XLGLZXR);
		if(mapped != null){
			String url = mapped.getUrl() + AppInterfaceConstant.WEB_INTERFACE_XLGLZXR;
			String returnString = CrossDomainUtil.postJSONString(url, infoMap);
			String accounts = returnString.substring(1,returnString.length()-1).replace("\"", "");
			String [] accountArray = accounts.split("\\s*,\\s*");
			accountList = new ArrayList<String>(Arrays.asList(accountArray));
		}
		return accountList;
	} 

}
