package com.css.app.db.business.controller;

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
import com.css.app.db.business.entity.ApprovalOpinion;
import com.css.app.db.business.service.ApprovalOpinionService;


/**
 * 审批意见表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-25 19:09:02
 */
@Controller
@RequestMapping("/dbapprovalopinion")
public class ApprovalOpinionController {
	@Autowired
	private ApprovalOpinionService dbApprovalOpinionService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("dbapprovalopinion:list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<ApprovalOpinion> dbApprovalOpinionList = dbApprovalOpinionService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(dbApprovalOpinionList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	@RequiresPermissions("dbapprovalopinion:info")
	public void info(@PathVariable("id") String id){
		ApprovalOpinion dbApprovalOpinion = dbApprovalOpinionService.queryObject(id);
		Response.json("dbApprovalOpinion", dbApprovalOpinion);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	@RequiresPermissions("dbapprovalopinion:save")
	public void save(@RequestBody ApprovalOpinion dbApprovalOpinion){
		dbApprovalOpinion.setId(UUIDUtils.random());
		dbApprovalOpinionService.save(dbApprovalOpinion);
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("dbapprovalopinion:update")
	public void update(@RequestBody ApprovalOpinion dbApprovalOpinion){
		dbApprovalOpinionService.update(dbApprovalOpinion);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("dbapprovalopinion:delete")
	public void delete(@RequestBody String[] ids){
		dbApprovalOpinionService.deleteBatch(ids);
		
		Response.ok();
	}
	
}
