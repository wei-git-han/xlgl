package com.css.app.xlgl.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.css.addbase.apporgan.entity.BaseAppOrgan;
import com.css.addbase.apporgan.service.BaseAppOrganService;
import com.css.addbase.apporgan.service.BaseAppUserService;
import com.css.addbase.apporgmapped.service.BaseAppOrgMappedService;
import com.css.app.xlgl.service.XlglAdminSetService;
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
	 * 
	 * */
	@ResponseBody
	@RequestMapping("/organTreeList")
	public void organTreeList() {
		HashMap<String,Object> hashMap = new HashMap<String, Object>();
		hashMap.put("parentId", "root");
		List<BaseAppOrgan> findByParentIdAndIsinvalid = baseAppOrganService.findByParentIdAndIsinvalid(hashMap);
		Response.json(findByParentIdAndIsinvalid);
	}
	
}
