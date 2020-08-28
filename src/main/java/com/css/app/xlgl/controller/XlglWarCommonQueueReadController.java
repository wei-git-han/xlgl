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
import com.css.app.xlgl.entity.XlglWarCommonQueueRead;
import com.css.app.xlgl.service.XlglWarCommonQueueReadService;


/**
 * 军事训练-共同训练-队列训练已读人员表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-17 10:26:33
 */
@Controller
@RequestMapping("app/xlgl/xlglwarcommonqueueread")
public class XlglWarCommonQueueReadController {
	@Autowired
	private XlglWarCommonQueueReadService xlglWarCommonQueueReadService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<XlglWarCommonQueueRead> xlglWarCommonQueueReadList = xlglWarCommonQueueReadService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(xlglWarCommonQueueReadList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	public void info(String id){
		XlglWarCommonQueueRead xlglWarCommonQueueRead = xlglWarCommonQueueReadService.queryObject(id);
		Response.json("xlglWarCommonQueueRead", xlglWarCommonQueueRead);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	public void save(XlglWarCommonQueueRead xlglWarCommonQueueRead){
		xlglWarCommonQueueRead.setId(UUIDUtils.random());
		xlglWarCommonQueueReadService.save(xlglWarCommonQueueRead);
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public void update(XlglWarCommonQueueRead xlglWarCommonQueueRead){
		xlglWarCommonQueueReadService.update(xlglWarCommonQueueRead);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public void delete(String[] ids){
		xlglWarCommonQueueReadService.deleteBatch(ids);
		
		Response.ok();
	}
	
}
