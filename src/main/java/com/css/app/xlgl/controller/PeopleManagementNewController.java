package com.css.app.xlgl.controller;

import java.util.HashMap;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.css.addbase.apporgan.entity.BaseAppOrgan;
import com.css.addbase.apporgan.service.BaseAppOrganService;
import com.css.addbase.apporgan.service.BaseAppUserService;
import com.css.addbase.apporgmapped.entity.BaseAppOrgMapped;
import com.css.addbase.apporgmapped.service.BaseAppOrgMappedService;
import com.css.addbase.constant.AppConstant;
import com.css.addbase.constant.AppInterfaceConstant;
import com.css.app.xlgl.service.XlglAdminSetService;
import com.css.base.utils.CrossDomainUtil;
import com.css.base.utils.Response;

@Controller
@RequestMapping("app/xlgl/peopleManagementNew")
public class PeopleManagementNewController {
	@Autowired
	private BaseAppOrgMappedService baseAppOrgMappedService;
	@Autowired
	private BaseAppOrganService baseAppOrganService;
	@Autowired
	private BaseAppUserService baseAppUserService;
	@Autowired
	private XlglAdminSetService adminSetService;

	@Value("${filePath}")
	private String filePath;
	@Value("${csse.mircoservice.zaiwei}")
	private String urls;
	
	/**局单位树
	 * @throws JSONException 
	 * 
	 * */
	@ResponseBody
	@RequestMapping("/organTreeList")
	public void organTreeList(){
		JSONArray jsonArray = new JSONArray();
		HashMap<String,Object> hashMap = new HashMap<String, Object>();
		hashMap.put("parentId", "root");
		List<BaseAppOrgan> queryList = baseAppOrganService.queryList(hashMap);
		for (BaseAppOrgan baseAppOrgan : queryList) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", baseAppOrgan.getId());
			jsonObject.put("name", baseAppOrgan.getName());
			jsonArray.add(jsonObject);
		}
		Response.json(jsonArray);
	}
	
    /**
     * 训练管理-人员管理-地图人员接口
     * @author 李振楠 2020-12-16
     * */
    @ResponseBody
    @RequestMapping("/getPlatNumber")
    public void getPlatNumber(String organId,String timeStr){
    	LinkedMultiValueMap<String, Object> hashmap = new LinkedMultiValueMap<String, Object>();
    	hashmap.add("organId", organId);
    	hashmap.add("timeStr", timeStr);
    	BaseAppOrgMapped orgMapped = (BaseAppOrgMapped)baseAppOrgMappedService.orgMappedByOrgId("","root",AppConstant.APP_QXJGL);
		// 获取清销假app的接口
		String elecPath = orgMapped.getUrl() + AppInterfaceConstant.WEB_QXJ_XLGLAPICONTROLLER_GETPLATNUMBER;
		JSONObject jsonData = CrossDomainUtil.getJsonData(elecPath, hashmap);
		Response.json(jsonData);
    }
}
