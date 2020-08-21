package com.css.app.xlgl.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.css.app.xlgl.entity.XlglStudyRecord;
import com.css.app.xlgl.service.XlglMineStudyService;
import com.css.app.xlgl.service.XlglStudyRecordService;
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
 * 自学上传记录
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-21 14:42:54
 */
@Controller
@RequestMapping("/app/xlgl/xlglstudyrecord")
public class XlglStudyRecordController {
	@Autowired
	private XlglStudyRecordService xlglStudyRecordService;
	@Autowired
	private XlglMineStudyService xlglMineStudyService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<XlglStudyRecord> xlglStudyRecordList = xlglStudyRecordService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(xlglStudyRecordList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	@RequiresPermissions("xlglstudyrecord:info")
	public void info(@PathVariable("id") String id){
		XlglStudyRecord xlglStudyRecord = xlglStudyRecordService.queryObject(id);
		Response.json("xlglStudyRecord", xlglStudyRecord);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	@RequiresPermissions("xlglstudyrecord:save")
	public void save(@RequestBody XlglStudyRecord xlglStudyRecord){
		xlglStudyRecord.setId(UUIDUtils.random());
		xlglStudyRecordService.save(xlglStudyRecord);
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("xlglstudyrecord:update")
	public void update(@RequestBody XlglStudyRecord xlglStudyRecord){
		xlglStudyRecordService.update(xlglStudyRecord);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public void delete(@RequestBody String id){
		String[] ids = id.split(",");
		xlglStudyRecordService.deleteBatch(ids);

		xlglMineStudyService.deleteAllRecord(ids);
		
		Response.json("result","success");
	}
	
}
