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

import com.css.app.xlgl.entity.XlglNoticeFile;
import com.css.app.xlgl.service.XlglNoticeFileService;
import com.css.base.utils.PageUtils;
import com.css.base.utils.Response;
import com.css.base.utils.UUIDUtils;
import com.github.pagehelper.PageHelper;



/**
 * 训练管理-通知公告附件表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-04 13:45:11
 */
@Controller
@RequestMapping("/xlglnoticefile")
public class XlglNoticeFileController {
	@Autowired
	private XlglNoticeFileService xlglNoticeFileService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("xlglnoticefile:list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<XlglNoticeFile> xlglNoticeFileList = xlglNoticeFileService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(xlglNoticeFileList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	@RequiresPermissions("xlglnoticefile:info")
	public void info(@PathVariable("id") String id){
		XlglNoticeFile xlglNoticeFile = xlglNoticeFileService.queryObject(id);
		Response.json("xlglNoticeFile", xlglNoticeFile);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	@RequiresPermissions("xlglnoticefile:save")
	public void save(@RequestBody XlglNoticeFile xlglNoticeFile){
		xlglNoticeFile.setId(UUIDUtils.random());
		xlglNoticeFileService.save(xlglNoticeFile);
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("xlglnoticefile:update")
	public void update(@RequestBody XlglNoticeFile xlglNoticeFile){
		xlglNoticeFileService.update(xlglNoticeFile);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("xlglnoticefile:delete")
	public void delete(@RequestBody String[] ids){
		xlglNoticeFileService.deleteBatch(ids);
		
		Response.ok();
	}
	
}
