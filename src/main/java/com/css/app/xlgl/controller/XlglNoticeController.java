package com.css.app.xlgl.controller;

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

import com.css.app.xlgl.entity.XlglNotice;
import com.css.app.xlgl.service.XlglNoticeService;
import com.css.base.utils.PageUtils;
import com.css.base.utils.Response;
import com.css.base.utils.UUIDUtils;
import com.github.pagehelper.PageHelper;



/**
 * 训练管理-通知公告表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-04 13:44:55
 */
@Controller
@RequestMapping("/xlglnotice")
public class XlglNoticeController {
	@Autowired
	private XlglNoticeService xlglNoticeService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("xlglnotice:list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<XlglNotice> xlglNoticeList = xlglNoticeService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(xlglNoticeList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	@RequiresPermissions("xlglnotice:info")
	public void info(@PathVariable("id") String id){
		XlglNotice xlglNotice = xlglNoticeService.queryObject(id);
		Response.json("xlglNotice", xlglNotice);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	@RequiresPermissions("xlglnotice:save")
	public void save(@RequestBody XlglNotice xlglNotice){
		xlglNotice.setId(UUIDUtils.random());
		xlglNoticeService.save(xlglNotice);
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("xlglnotice:update")
	public void update(@RequestBody XlglNotice xlglNotice){
		xlglNoticeService.update(xlglNotice);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("xlglnotice:delete")
	public void delete(@RequestBody String[] ids){
		xlglNoticeService.deleteBatch(ids);
		
		Response.ok();
	}
	
}
