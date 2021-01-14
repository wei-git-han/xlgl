package com.css.app.xlgl.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.css.addbase.apporgan.service.BaseAppUserService;
import com.css.app.xlgl.entity.XlglUrgentNotice;
import com.css.app.xlgl.service.XlglUrgentNoticeService;
import com.css.base.utils.CurrentUser;
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
 * 紧急通知公告
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-13 14:35:46
 */
@Controller
@RequestMapping("app/xlgl/xlglurgentnotice")
public class XlglUrgentNoticeController {
	@Autowired
	private XlglUrgentNoticeService xlglUrgentNoticeService;
	@Autowired
	private BaseAppUserService baseAppUserService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("xlglurgentnotice:list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<XlglUrgentNotice> xlglUrgentNoticeList = xlglUrgentNoticeService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(xlglUrgentNoticeList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 紧急通知公告详情
	 */
	@ResponseBody
	@RequestMapping("/info")
	public void info() {
		String orgId = baseAppUserService.getBareauByUserId(CurrentUser.getUserId());
		XlglUrgentNotice xlglUrgentNotice = xlglUrgentNoticeService.queryNotice(orgId);
		if (xlglUrgentNotice != null) {
			Response.json("xlglUrgentNotice", xlglUrgentNotice);
		}
	}
	
	/**
	 * 紧急通知公告发布接口
	 */
	@ResponseBody
	@RequestMapping("/save")
	public void save(XlglUrgentNotice xlglUrgentNotice){
		xlglUrgentNoticeService.deleteAll();//保存之前先删掉，只保存一条数据
		xlglUrgentNotice.setId(UUIDUtils.random());
		xlglUrgentNotice.setCreator(CurrentUser.getUserId());
		xlglUrgentNotice.setCreatedTime(new Date());
		xlglUrgentNoticeService.save(xlglUrgentNotice);
		Response.json("result","success");
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("xlglurgentnotice:update")
	public void update(@RequestBody XlglUrgentNotice xlglUrgentNotice){
		xlglUrgentNoticeService.update(xlglUrgentNotice);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("xlglurgentnotice:delete")
	public void delete(@RequestBody String[] ids){
		xlglUrgentNoticeService.deleteBatch(ids);
		
		Response.ok();
	}
	
}
