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
import com.css.app.xlgl.entity.XlglWarCommonSportsRead;
import com.css.app.xlgl.service.XlglWarCommonSportsReadService;


/**
 * 军事训练-共同训练-军事体育已读人员表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-17 10:26:33
 */
@Controller
@RequestMapping("app/xlgl/xlglwarcommonsportsread")
public class XlglWarCommonSportsReadController {
	@Autowired
	private XlglWarCommonSportsReadService xlglWarCommonSportsReadService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<XlglWarCommonSportsRead> xlglWarCommonSportsReadList = xlglWarCommonSportsReadService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(xlglWarCommonSportsReadList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info")
	@RequiresPermissions("xlglwarcommonsportsread:info")
	public void info(String id){
		XlglWarCommonSportsRead xlglWarCommonSportsRead = xlglWarCommonSportsReadService.queryObject(id);
		Response.json("xlglWarCommonSportsRead", xlglWarCommonSportsRead);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	public void save(XlglWarCommonSportsRead xlglWarCommonSportsRead){
		xlglWarCommonSportsRead.setId(UUIDUtils.random());
		xlglWarCommonSportsReadService.save(xlglWarCommonSportsRead);
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public void update(XlglWarCommonSportsRead xlglWarCommonSportsRead){
		xlglWarCommonSportsReadService.update(xlglWarCommonSportsRead);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public void delete(String[] ids){
		xlglWarCommonSportsReadService.deleteBatch(ids);
		
		Response.ok();
	}
	
}
