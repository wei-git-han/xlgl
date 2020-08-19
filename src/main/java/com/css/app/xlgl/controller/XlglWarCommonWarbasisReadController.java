package com.css.app.xlgl.controller;

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
import com.css.app.xlgl.entity.XlglWarCommonWarbasisRead;
import com.css.app.xlgl.service.XlglWarCommonWarbasisReadService;


/**
 * 军事训练-共同训练-战备基础已读人员表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-19 10:14:38
 */
@Controller
@RequestMapping("/xlglwarcommonwarbasisread")
public class XlglWarCommonWarbasisReadController {
	@Autowired
	private XlglWarCommonWarbasisReadService xlglWarCommonWarbasisReadService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("xlglwarcommonwarbasisread:list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<XlglWarCommonWarbasisRead> xlglWarCommonWarbasisReadList = xlglWarCommonWarbasisReadService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(xlglWarCommonWarbasisReadList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	@RequiresPermissions("xlglwarcommonwarbasisread:info")
	public void info(@PathVariable("id") String id){
		XlglWarCommonWarbasisRead xlglWarCommonWarbasisRead = xlglWarCommonWarbasisReadService.queryObject(id);
		Response.json("xlglWarCommonWarbasisRead", xlglWarCommonWarbasisRead);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	@RequiresPermissions("xlglwarcommonwarbasisread:save")
	public void save(@RequestBody XlglWarCommonWarbasisRead xlglWarCommonWarbasisRead){
		xlglWarCommonWarbasisRead.setId(UUIDUtils.random());
		xlglWarCommonWarbasisReadService.save(xlglWarCommonWarbasisRead);
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("xlglwarcommonwarbasisread:update")
	public void update(@RequestBody XlglWarCommonWarbasisRead xlglWarCommonWarbasisRead){
		xlglWarCommonWarbasisReadService.update(xlglWarCommonWarbasisRead);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("xlglwarcommonwarbasisread:delete")
	public void delete(@RequestBody String[] ids){
		xlglWarCommonWarbasisReadService.deleteBatch(ids);
		
		Response.ok();
	}
	
}
