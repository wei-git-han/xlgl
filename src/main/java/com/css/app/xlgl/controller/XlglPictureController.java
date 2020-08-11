package com.css.app.xlgl.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.css.app.xlgl.entity.XlglPicture;
import com.css.app.xlgl.service.XlglPictureService;
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
 * 训练管理存图片表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-10 15:13:49
 */
@Controller
@RequestMapping("/xlglpicture")
public class XlglPictureController {
	@Autowired
	private XlglPictureService xlglPictureService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("xlglpicture:list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<XlglPicture> xlglPictureList = xlglPictureService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(xlglPictureList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	@RequiresPermissions("xlglpicture:info")
	public void info(@PathVariable("id") String id){
		XlglPicture xlglPicture = xlglPictureService.queryObject(id);
		Response.json("xlglPicture", xlglPicture);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	@RequiresPermissions("xlglpicture:save")
	public void save(@RequestBody XlglPicture xlglPicture){
		xlglPicture.setId(UUIDUtils.random());
		xlglPictureService.save(xlglPicture);
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("xlglpicture:update")
	public void update(@RequestBody XlglPicture xlglPicture){
		xlglPictureService.update(xlglPicture);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("xlglpicture:delete")
	public void delete(@RequestBody String[] ids){
		xlglPictureService.deleteBatch(ids);
		
		Response.ok();
	}
	
}
