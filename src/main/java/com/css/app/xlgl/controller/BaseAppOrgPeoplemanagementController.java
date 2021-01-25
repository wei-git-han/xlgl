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
import com.css.app.xlgl.entity.BaseAppOrgPeoplemanagement;
import com.css.app.xlgl.service.BaseAppOrgPeoplemanagementService;


/**
 * 某局下新增处级单位
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2021-01-25 10:47:51
 */
@Controller
@RequestMapping("/baseapporgpeoplemanagement")
public class BaseAppOrgPeoplemanagementController {
	@Autowired
	private BaseAppOrgPeoplemanagementService baseAppOrgPeoplemanagementService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("baseapporgpeoplemanagement:list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<BaseAppOrgPeoplemanagement> baseAppOrgPeoplemanagementList = baseAppOrgPeoplemanagementService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(baseAppOrgPeoplemanagementList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{answerReignNumber}")
	@RequiresPermissions("baseapporgpeoplemanagement:info")
	public void info(@PathVariable("answerReignNumber") Integer answerReignNumber){
		BaseAppOrgPeoplemanagement baseAppOrgPeoplemanagement = baseAppOrgPeoplemanagementService.queryObject(answerReignNumber);
		Response.json("baseAppOrgPeoplemanagement", baseAppOrgPeoplemanagement);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	@RequiresPermissions("baseapporgpeoplemanagement:save")
	public void save(@RequestBody BaseAppOrgPeoplemanagement baseAppOrgPeoplemanagement){
		baseAppOrgPeoplemanagement.setId(UUIDUtils.random());
		baseAppOrgPeoplemanagementService.save(baseAppOrgPeoplemanagement);
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public void update(@RequestBody BaseAppOrgPeoplemanagement baseAppOrgPeoplemanagement){
		baseAppOrgPeoplemanagementService.update(baseAppOrgPeoplemanagement);
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("baseapporgpeoplemanagement:delete")
	public void delete(@RequestBody Integer[] answerReignNumbers){
		baseAppOrgPeoplemanagementService.deleteBatch(answerReignNumbers);
		
		Response.ok();
	}
	
}
