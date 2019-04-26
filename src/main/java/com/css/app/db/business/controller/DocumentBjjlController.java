package com.css.app.db.business.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.css.app.db.business.entity.DocumentBjjl;
import com.css.app.db.business.service.DocumentBjjlService;
import com.css.base.utils.Response;


/**
 * 办结记录表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-25 19:46:10
 */
@Controller
@RequestMapping("/app/db/documentbjjl")
public class DocumentBjjlController {
	@Autowired
	private DocumentBjjlService documentBjjlService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	public void list(String infoId){
		List<DocumentBjjl> bjjlList=null;
		if(StringUtils.isNotBlank(infoId)) {
			Map<String, Object> map = new HashMap<>();
			map.put("infoId", infoId);
			//查询列表数据
			bjjlList = documentBjjlService.queryList(map);
		}
		Response.json(bjjlList);
	}
	
}
