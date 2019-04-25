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
import com.css.app.db.business.entity.ReplyOpinion;
import com.css.app.db.business.service.ReplyOpinionService;


/**
 * 意见反馈表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-25 15:10:37
 */
@Controller
@RequestMapping("/dbreplyopinion")
public class ReplyOpinionController {
	@Autowired
	private ReplyOpinionService dbReplyOpinionService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("dbreplyopinion:list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<ReplyOpinion> dbReplyOpinionList = dbReplyOpinionService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(dbReplyOpinionList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	@RequiresPermissions("dbreplyopinion:info")
	public void info(@PathVariable("id") String id){
		ReplyOpinion dbReplyOpinion = dbReplyOpinionService.queryObject(id);
		Response.json("dbReplyOpinion", dbReplyOpinion);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	@RequiresPermissions("dbreplyopinion:save")
	public void save(@RequestBody ReplyOpinion dbReplyOpinion){
		dbReplyOpinion.setId(UUIDUtils.random());
		dbReplyOpinionService.save(dbReplyOpinion);
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("dbreplyopinion:update")
	public void update(@RequestBody ReplyOpinion dbReplyOpinion){
		dbReplyOpinionService.update(dbReplyOpinion);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("dbreplyopinion:delete")
	public void delete(@RequestBody String[] ids){
		dbReplyOpinionService.deleteBatch(ids);
		
		Response.ok();
	}
	
}
