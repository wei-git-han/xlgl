package com.css.app.xlgl.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.css.app.xlgl.entity.XlglPhysicalRecord;
import com.css.app.xlgl.service.XlglPhysicalRecordService;
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
 * 军事体育上传记录
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-21 14:13:24
 */
@Controller
@RequestMapping("/app/xlgl/xlglphysicalrecord")
public class XlglPhysicalRecordController {
	@Autowired
	private XlglPhysicalRecordService xlglPhysicalRecordService;
	@Autowired
	private XlglPhysicalService xlglPhysicalService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		//PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<XlglPhysicalRecord> xlglPhysicalRecordList = xlglPhysicalRecordService.queryList(map);
		
		Response.json("xlglPhysicalRecordList",xlglPhysicalRecordList);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	@RequiresPermissions("xlglphysicalrecord:info")
	public void info(@PathVariable("id") String id){
		XlglPhysicalRecord xlglPhysicalRecord = xlglPhysicalRecordService.queryObject(id);
		Response.json("xlglPhysicalRecord", xlglPhysicalRecord);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	@RequiresPermissions("xlglphysicalrecord:save")
	public void save(@RequestBody XlglPhysicalRecord xlglPhysicalRecord){
		xlglPhysicalRecord.setId(UUIDUtils.random());
		xlglPhysicalRecordService.save(xlglPhysicalRecord);
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("xlglphysicalrecord:update")
	public void update(@RequestBody XlglPhysicalRecord xlglPhysicalRecord){
		xlglPhysicalRecordService.update(xlglPhysicalRecord);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public void delete(String id){
		String[] ids = id.split(",");
		xlglPhysicalRecordService.deleteBatch(ids);

		xlglPhysicalService.deleteAllRecord(ids);//删除每个人的记录
		
		Response.json("result","success");
	}
	
}
