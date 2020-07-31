package com.css.app.xlgl.sportstrain.controller;

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
import com.css.app.xlgl.sportstrain.entity.TGroupApplyRecord;
import com.css.app.xlgl.sportstrain.service.TGroupApplyRecordService;


/**
 * 
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-07-30 18:21:45
 */
@Controller
@RequestMapping("/tgroupapplyrecord")
public class TGroupApplyRecordController {
	@Autowired
	private TGroupApplyRecordService tGroupApplyRecordService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("tgroupapplyrecord:list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<TGroupApplyRecord> tGroupApplyRecordList = tGroupApplyRecordService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(tGroupApplyRecordList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	@RequiresPermissions("tgroupapplyrecord:info")
	public void info(@PathVariable("id") String id){
		TGroupApplyRecord tGroupApplyRecord = tGroupApplyRecordService.queryObject(id);
		Response.json("tGroupApplyRecord", tGroupApplyRecord);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	@RequiresPermissions("tgroupapplyrecord:save")
	public void save(@RequestBody TGroupApplyRecord tGroupApplyRecord){
		tGroupApplyRecord.setId(UUIDUtils.random());
		tGroupApplyRecordService.save(tGroupApplyRecord);
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("tgroupapplyrecord:update")
	public void update(@RequestBody TGroupApplyRecord tGroupApplyRecord){
		tGroupApplyRecordService.update(tGroupApplyRecord);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("tgroupapplyrecord:delete")
	public void delete(@RequestBody String[] ids){
		tGroupApplyRecordService.deleteBatch(ids);
		
		Response.ok();
	}
	
}
