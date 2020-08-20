package com.css.app.xlgl.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.css.app.xlgl.entity.XlglPhysical;
import com.css.app.xlgl.service.XlglPhysicalService;
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
 * 军事体育训练
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-20 19:38:37
 */
@Controller
@RequestMapping("/app/xlgl/xlglphysical")
public class XlglPhysicalController {
	@Autowired
	private XlglPhysicalService xlglPhysicalService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("xlglphysical:list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<XlglPhysical> xlglPhysicalList = xlglPhysicalService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(xlglPhysicalList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	@RequiresPermissions("xlglphysical:info")
	public void info(@PathVariable("id") String id){
		XlglPhysical xlglPhysical = xlglPhysicalService.queryObject(id);
		Response.json("xlglPhysical", xlglPhysical);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	@RequiresPermissions("xlglphysical:save")
	public void save(@RequestBody XlglPhysical xlglPhysical){
		xlglPhysical.setId(UUIDUtils.random());
		xlglPhysicalService.save(xlglPhysical);
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("xlglphysical:update")
	public void update(@RequestBody XlglPhysical xlglPhysical){
		xlglPhysicalService.update(xlglPhysical);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("xlglphysical:delete")
	public void delete(@RequestBody String[] ids){
		xlglPhysicalService.deleteBatch(ids);
		
		Response.ok();
	}
	
}
