package com.css.app.xlgl.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.css.app.xlgl.entity.XlglDocumentZbjl;
import com.css.app.xlgl.service.XlglDocumentZbjlService;
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


/**
 * 转办记录表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-11 11:11:27
 */
@Controller
@RequestMapping("/xlgldocumentzbjl")
public class XlglDocumentZbjlController {
	@Autowired
	private XlglDocumentZbjlService xlglDocumentZbjlService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("xlgldocumentzbjl:list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<XlglDocumentZbjl> xlglDocumentZbjlList = xlglDocumentZbjlService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(xlglDocumentZbjlList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	@RequiresPermissions("xlgldocumentzbjl:info")
	public void info(@PathVariable("id") String id){
		XlglDocumentZbjl xlglDocumentZbjl = xlglDocumentZbjlService.queryObject(id);
		Response.json("xlglDocumentZbjl", xlglDocumentZbjl);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	@RequiresPermissions("xlgldocumentzbjl:save")
	public void save(@RequestBody XlglDocumentZbjl xlglDocumentZbjl){
		xlglDocumentZbjl.setId(UUIDUtils.random());
		xlglDocumentZbjlService.save(xlglDocumentZbjl);
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("xlgldocumentzbjl:update")
	public void update(@RequestBody XlglDocumentZbjl xlglDocumentZbjl){
		xlglDocumentZbjlService.update(xlglDocumentZbjl);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("xlgldocumentzbjl:delete")
	public void delete(@RequestBody String[] ids){
		xlglDocumentZbjlService.deleteBatch(ids);
		
		Response.ok();
	}
	
}
