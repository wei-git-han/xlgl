package com.css.app.db.business.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.css.app.db.business.entity.DocumentFile;
import com.css.app.db.business.service.DocumentFileService;
import com.css.base.utils.Response;
import com.css.base.utils.StringUtils;
import com.css.base.utils.UUIDUtils;


/**
 * 基本信息表携带文件的关系表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-18 16:39:11
 */
@Controller
@RequestMapping("/app/db/documentfile")
public class DocumentFileController {
	@Autowired
	private DocumentFileService documentFileService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	public void list(String infoId){
		List<DocumentFile> fileList=null;
		if(StringUtils.isNotBlank(infoId)) {
			Map<String, Object> map = new HashMap<>();
			map.put("infoId", infoId);
			 fileList = documentFileService.queryList(map);
		}
		Response.json(fileList);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	@RequiresPermissions("dbdocumentfile:info")
	public void info(@PathVariable("id") String id){
		DocumentFile dbDocumentFile = documentFileService.queryObject(id);
		Response.json("dbDocumentFile", dbDocumentFile);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	@RequiresPermissions("dbdocumentfile:save")
	public void save(@RequestBody DocumentFile dbDocumentFile){
		dbDocumentFile.setId(UUIDUtils.random());
		documentFileService.save(dbDocumentFile);
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("dbdocumentfile:update")
	public void update(@RequestBody DocumentFile dbDocumentFile){
		documentFileService.update(dbDocumentFile);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public void delete(String id){
		documentFileService.delete(id);
		Response.json("result","success");
	}
	
}
