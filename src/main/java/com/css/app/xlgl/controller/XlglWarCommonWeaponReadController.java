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
import com.css.app.xlgl.entity.XlglWarCommonWeaponRead;
import com.css.app.xlgl.service.XlglWarCommonWeaponReadService;


/**
 * 军事训练-共同训练-轻武器操作已读人员表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-19 10:14:38
 */
@Controller
@RequestMapping("/xlglwarcommonweaponread")
public class XlglWarCommonWeaponReadController {
	@Autowired
	private XlglWarCommonWeaponReadService xlglWarCommonWeaponReadService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("xlglwarcommonweaponread:list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<XlglWarCommonWeaponRead> xlglWarCommonWeaponReadList = xlglWarCommonWeaponReadService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(xlglWarCommonWeaponReadList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	@RequiresPermissions("xlglwarcommonweaponread:info")
	public void info(@PathVariable("id") String id){
		XlglWarCommonWeaponRead xlglWarCommonWeaponRead = xlglWarCommonWeaponReadService.queryObject(id);
		Response.json("xlglWarCommonWeaponRead", xlglWarCommonWeaponRead);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	@RequiresPermissions("xlglwarcommonweaponread:save")
	public void save(@RequestBody XlglWarCommonWeaponRead xlglWarCommonWeaponRead){
		xlglWarCommonWeaponRead.setId(UUIDUtils.random());
		xlglWarCommonWeaponReadService.save(xlglWarCommonWeaponRead);
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("xlglwarcommonweaponread:update")
	public void update(@RequestBody XlglWarCommonWeaponRead xlglWarCommonWeaponRead){
		xlglWarCommonWeaponReadService.update(xlglWarCommonWeaponRead);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("xlglwarcommonweaponread:delete")
	public void delete(@RequestBody String[] ids){
		xlglWarCommonWeaponReadService.deleteBatch(ids);
		
		Response.ok();
	}
	
}
