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
import com.css.app.xlgl.entity.TGroupActivePublish;
import com.css.app.xlgl.service.TGroupActivePublishService;


/**
 * 
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-07-30 18:21:45
 */
@Controller
@RequestMapping("/tgroupactivepublish")
public class TGroupActivePublishController {
	@Autowired
	private TGroupActivePublishService tGroupActivePublishService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("tgroupactivepublish:list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<TGroupActivePublish> tGroupActivePublishList = tGroupActivePublishService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(tGroupActivePublishList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{actId}")
	@RequiresPermissions("tgroupactivepublish:info")
	public void info(@PathVariable("actId") String actId){
		TGroupActivePublish tGroupActivePublish = tGroupActivePublishService.queryObject(actId);
		Response.json("tGroupActivePublish", tGroupActivePublish);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	@RequiresPermissions("tgroupactivepublish:save")
	public void save(@RequestBody TGroupActivePublish tGroupActivePublish){
		tGroupActivePublish.setActId(UUIDUtils.random());
		tGroupActivePublishService.save(tGroupActivePublish);
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("tgroupactivepublish:update")
	public void update(@RequestBody TGroupActivePublish tGroupActivePublish){
		tGroupActivePublishService.update(tGroupActivePublish);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("tgroupactivepublish:delete")
	public void delete(@RequestBody String[] actIds){
		tGroupActivePublishService.deleteBatch(actIds);
		
		Response.ok();
	}
	
}
