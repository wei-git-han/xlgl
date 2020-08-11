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
import com.css.app.xlgl.entity.XlglExamFile;
import com.css.app.xlgl.service.XlglExamFileService;


/**
 * 考试模块模板文件id
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-11 15:17:38
 */
@Controller
@RequestMapping("app/xlgl/xlglexamfile")
public class XlglExamFileController {
	@Autowired
	private XlglExamFileService xlglExamFileService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	public void list(){
		Map<String, Object> map = new HashMap<>();
		//PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<XlglExamFile> xlglExamFileList = xlglExamFileService.queryList(map);
		
		//PageUtils pageUtil = new PageUtils(xlglExamFileList);
		Response.json("list",xlglExamFileList);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	@RequiresPermissions("xlglexamfile:info")
	public void info(@PathVariable("id") String id){
		XlglExamFile xlglExamFile = xlglExamFileService.queryObject(id);
		Response.json("xlglExamFile", xlglExamFile);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	@RequiresPermissions("xlglexamfile:save")
	public void save(@RequestBody XlglExamFile xlglExamFile){
		xlglExamFile.setId(UUIDUtils.random());
		xlglExamFileService.save(xlglExamFile);
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("xlglexamfile:update")
	public void update(@RequestBody XlglExamFile xlglExamFile){
		xlglExamFileService.update(xlglExamFile);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("xlglexamfile:delete")
	public void delete(@RequestBody String[] ids){
		xlglExamFileService.deleteBatch(ids);
		
		Response.ok();
	}
	
}
