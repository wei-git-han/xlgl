package com.css.addbase;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.css.addbase.apporgmapped.service.BaseAppOrgMappedService;
import com.css.addbase.orgservice.OrgService;
import com.css.addbase.orgservice.Organ;
import com.css.base.utils.CurrentUser;
/**
 * 单点登录维护的系统组织机构树
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2017-04-19 13:05:36
 */
@Controller
@RequestMapping("/sysorgan")
public class SysOrgan {
	
	@Autowired
	private OrgService orgService;
	
	@Autowired
	private BaseAppOrgMappedService baseAppOrgMappedService;
	
	@RequestMapping(value = "/tree")
	@ResponseBody
	public Object getDeptTree(HttpServletRequest request) {
		String orgid = baseAppOrgMappedService.getBareauByUserId(CurrentUser.getUserId());
		if (StringUtils.isNotEmpty(orgid)) {
			JSONObject list=  getOrganTree(orgid);
			JSONObject json = new JSONObject();
			json.put("opened", true);
			list.put("state", json);
			list.put("currentOrgId", orgid);
			return list;
		} else {
			JSONObject list=  getOrganTree("root");
			JSONObject json = new JSONObject();
			json.put("opened", true);
			list.put("state", json);
			return list;
		}
		
	}
	
	@RequestMapping(value = "/currenttree")
	@ResponseBody
	public Object getDeptCurrentTree(HttpServletRequest request) {
		String orgid = baseAppOrgMappedService.getBareauByUserId(CurrentUser.getUserId());
		JSONObject list=  getOrganTree("root");
		JSONObject json = new JSONObject();
		json.put("opened", true);
		list.put("state", json);
		list.put("currentOrgId", "root");
		return list;
	}
	
	public JSONObject getOrganTree(String id){
		JSONObject result = new JSONObject();
		JSONArray jsons = new JSONArray();
		Organ organ = orgService.getOrgan(id);
		result.put("id", organ.getOrganId());
		result.put("text", organ.getOrganName());
		Organ[] organs = orgService.getSubOrg(id, true, true);
		for (Organ sysOrgan:organs) {
			JSONObject json = new JSONObject();
			json.put("id", sysOrgan.getOrganId());
			json.put("text", sysOrgan.getOrganName());
		    jsons.add(getOrganTree(sysOrgan.getOrganId()));
		}
		if (jsons.size()>0) {
			result.put("children", jsons);
		}
		return result;
	}
	/**
	 * 从组织结构根目录的下获取组织
	 * */
	@RequestMapping(value = "/currenttreeByRoot")
	@ResponseBody
	public Object getDeptCurrentTreeByRoot(HttpServletRequest request) {
		JSONObject list=  getOrganTree("root");
		JSONObject json = new JSONObject();
		json.put("opened", true);
		list.put("state", json);
		list.put("currentOrgId", "root");
		return list;
	}
	
}
