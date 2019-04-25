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
import com.css.app.db.business.entity.OpinionAttac;
import com.css.app.db.business.service.OpinionAttacService;


/**
 * 意见反馈附件表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-25 15:10:36
 */
@Controller
@RequestMapping("/dbopinionattac")
public class OpinionAttacController {
	@Autowired
	private OpinionAttacService dbOpinionAttacService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("dbopinionattac:list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<OpinionAttac> dbOpinionAttacList = dbOpinionAttacService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(dbOpinionAttacList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	@RequiresPermissions("dbopinionattac:info")
	public void info(@PathVariable("id") String id){
		OpinionAttac dbOpinionAttac = dbOpinionAttacService.queryObject(id);
		Response.json("dbOpinionAttac", dbOpinionAttac);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	@RequiresPermissions("dbopinionattac:save")
	public void save(@RequestBody OpinionAttac dbOpinionAttac){
		dbOpinionAttac.setId(UUIDUtils.random());
		dbOpinionAttacService.save(dbOpinionAttac);
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("dbopinionattac:update")
	public void update(@RequestBody OpinionAttac dbOpinionAttac){
		dbOpinionAttacService.update(dbOpinionAttac);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("dbopinionattac:delete")
	public void delete(@RequestBody String[] ids){
		dbOpinionAttacService.deleteBatch(ids);
		
		Response.ok();
	}
	
}
