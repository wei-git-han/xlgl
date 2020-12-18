package com.css.app.xlgl.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.css.addbase.apporgan.entity.BaseAppOrgan;
import com.css.addbase.apporgan.service.BaseAppOrganService;
import com.css.addbase.apporgan.util.RedisUtil;
import com.css.addbase.apporgmapped.entity.BaseAppOrgMapped;
import com.css.addbase.apporgmapped.service.BaseAppOrgMappedService;
import com.css.addbase.constant.AppConstant;
import com.css.addbase.constant.AppInterfaceConstant;
import com.css.app.xlgl.dao.XlglKtapDao;
import com.css.app.xlgl.entity.XlglKtap;
import com.css.app.xlgl.service.PeopleManagementService;
import com.css.app.xlgl.service.XlglKtapService;
import com.css.base.utils.CrossDomainUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Service("peopleManagementService")
public class PeopleManagementServiceImpl implements PeopleManagementService {
	@Autowired
	private BaseAppOrganService baseAppOrganService;
	@Autowired
	private BaseAppOrgMappedService baseAppOrgMappedService;
	@Autowired
	private RedisUtil redisUtil;
	
	@Override
	public boolean setTxlRedis() {
		try {
			HashMap<String,Object> hashMap = new HashMap<String, Object>();
			hashMap.put("parentId", "root");
			List<BaseAppOrgan> queryList = baseAppOrganService.queryList(hashMap);
			BaseAppOrgMapped orgMapped = (BaseAppOrgMapped)baseAppOrgMappedService.orgMappedByOrgId("","root",AppConstant.APP_TXL);
			// 获取清销假app的接口
			String elecPath = orgMapped.getUrl()+ AppInterfaceConstant.WEB_TXL;
			for (BaseAppOrgan baseAppOrgan : queryList) {
				LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
				map.add("orgid", baseAppOrgan.getId());
				JSONObject jsonData = CrossDomainUtil.getJsonData(elecPath, map);
				String jsonArray = jsonData.getJSONArray("rows").toString();
				String str = "xlgl-txlUsetNEWDto-" +baseAppOrgan.getId();
				redisUtil.setString(str, jsonArray);
				System.out.println("redis:"+str+"，缓存成功！！！！！！！");
			}
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean setQxjRedis() {
		try {
			LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
			BaseAppOrgMapped orgMapped = (BaseAppOrgMapped)baseAppOrgMappedService.orgMappedByOrgId("","root",AppConstant.APP_QXJGL);
			// 获取清销假app的接口
			String elecPath = orgMapped.getUrl() + AppInterfaceConstant.WEB_INTERFACE_QXJ_USER_INFO_QJDAYS;
			JSONObject jsonData = CrossDomainUtil.getJsonData(elecPath, map);
			String jsonArray = jsonData.getJSONArray("list").toString();
			redisUtil.setString("xlgl-qxl-people", jsonArray);
			System.out.println("redis:xlgl-qxl-people，缓存成功！！！！！！！");
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	
	

	
}
