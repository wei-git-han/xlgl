package com.css.app.db.business.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

import com.css.base.utils.PageUtils;
import com.css.base.utils.UUIDUtils;
import com.github.pagehelper.PageHelper;
import com.css.base.utils.Response;
import com.css.app.db.business.entity.DocumentCbjl;
import com.css.app.db.business.service.DocumentCbjlService;


/**
 * 催办记录表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-18 16:40:16
 */
@Controller
@RequestMapping("/documentcbjl")
public class DocumentCbjlController {
	@Autowired
	private DocumentCbjlService documentCbjlService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("dbdocumentcbjl:list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<DocumentCbjl> dbDocumentCbjlList = documentCbjlService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(dbDocumentCbjlList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	@RequiresPermissions("dbdocumentcbjl:info")
	public void info(@PathVariable("id") String id){
		DocumentCbjl dbDocumentCbjl = documentCbjlService.queryObject(id);
		Response.json("dbDocumentCbjl", dbDocumentCbjl);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	@RequiresPermissions("dbdocumentcbjl:save")
	public void save(@RequestBody DocumentCbjl dbDocumentCbjl){
		dbDocumentCbjl.setId(UUIDUtils.random());
		documentCbjlService.save(dbDocumentCbjl);
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("dbdocumentcbjl:update")
	public void update(@RequestBody DocumentCbjl dbDocumentCbjl){
		documentCbjlService.update(dbDocumentCbjl);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("dbdocumentcbjl:delete")
	public void delete(@RequestBody String[] ids){
		documentCbjlService.deleteBatch(ids);
		
		Response.ok();
	}
	
}
