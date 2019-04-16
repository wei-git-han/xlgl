package com.css.addbase;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.css.addbase.apporgmapped.service.BaseAppOrgMappedService;
import com.css.addbase.orgservice.OrgService;
import com.css.addbase.orgservice.Organ;
import com.css.addbase.orgservice.UserInfo;
import com.css.base.utils.CurrentUser;
/**
 *  单点登录维护的系统人员树
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2017-04-19 13:02:39
 */
@Controller
@RequestMapping("/sysuser")
public class SysUser {
	
	@Autowired
	private OrgService orgService;
	
	@Autowired
	private BaseAppOrgMappedService baseAppOrgMappedService;
	
	@RequestMapping(value = "/tree")
	@ResponseBody
	public Object getUserTree(HttpServletRequest request) {
		String orgid = baseAppOrgMappedService.getBareauByUserId(CurrentUser.getUserId());
		if (StringUtils.isNotEmpty(orgid)) {
			JSONObject list=  getUserTree(orgid);
			JSONObject json = new JSONObject();
			json.put("opened", true);
			list.put("state", json);
			return list;
		} else {
			JSONObject list=  getUserTree("root");
			JSONObject json = new JSONObject();
			json.put("opened", true);
			list.put("state", json);
			return list;
		}
	}
	
	@RequestMapping(value = "/tree1")
	@ResponseBody
	public Object getUserTree1(HttpServletRequest request, String tabId) {
		String orgid = "";
		if ("".equals(tabId)) {
			orgid = CurrentUser.getDepartmentId();
		} else {
			orgid = tabId;
		}
		if (StringUtils.isNotEmpty(orgid)) {
			JSONObject list =  getUserTree(orgid);
			JSONObject json = new JSONObject();
			json.put("opened", true);
			list.put("state", json);
			return list;
		} else {
			JSONObject list=  getUserTree("root");
			JSONObject json = new JSONObject();
			json.put("opened", true);
			list.put("state", json);
			return list;
		}
	}
	
	public JSONObject getUserTree(String id){
		JSONObject result = new JSONObject();
		JSONArray jsons = new JSONArray();
		Organ organ = orgService.getOrgan(id);
		result.put("id", organ.getOrganId());
		result.put("text", organ.getOrganName());
		result.put("type", "0");
		UserInfo[] sysUsers = orgService.getUserInfos(id);
		for (UserInfo sysUser:sysUsers) {
			if (!StringUtils.contains("admin,sysadmin,secadmin,audadmin", sysUser.getAccount())) {
				JSONObject jsonUser = new JSONObject();
				jsonUser.put("id", sysUser.getUserid());
				jsonUser.put("text", sysUser.getFullname());
				jsonUser.put("type", "1");
				jsons.add(jsonUser);
			}
		}
		Organ[] organs = orgService.getSubOrg(id);
		for (Organ sysOrgan:organs) {
			JSONObject json = new JSONObject();
			json.put("id", sysOrgan.getOrganId());
			json.put("text", sysOrgan.getOrganName());
			json.put("type", "0");
		    jsons.add(getUserTree(sysOrgan.getOrganId()));
		}
		if (jsons.size()>0) {
			result.put("children", jsons);
		}
		return result;
	}
	
}
