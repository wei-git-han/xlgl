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
import com.css.app.db.business.entity.DocumentZbjl;
import com.css.app.db.business.service.DocumentZbjlService;


/**
 * 转办记录表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-18 16:39:37
 */
@Controller
@RequestMapping("/documentzbjl")
public class DocumentZbjlController {
	@Autowired
	private DocumentZbjlService documentZbjlService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("dbdocumentzbjl:list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<DocumentZbjl> dbDocumentZbjlList = documentZbjlService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(dbDocumentZbjlList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	@RequiresPermissions("dbdocumentzbjl:info")
	public void info(@PathVariable("id") String id){
		DocumentZbjl dbDocumentZbjl = documentZbjlService.queryObject(id);
		Response.json("dbDocumentZbjl", dbDocumentZbjl);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	@RequiresPermissions("dbdocumentzbjl:save")
	public void save(@RequestBody DocumentZbjl dbDocumentZbjl){
		dbDocumentZbjl.setId(UUIDUtils.random());
		documentZbjlService.save(dbDocumentZbjl);
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("dbdocumentzbjl:update")
	public void update(@RequestBody DocumentZbjl dbDocumentZbjl){
		documentZbjlService.update(dbDocumentZbjl);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("dbdocumentzbjl:delete")
	public void delete(@RequestBody String[] ids){
		documentZbjlService.deleteBatch(ids);
		
		Response.ok();
	}
	
}
