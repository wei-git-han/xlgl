package com.css.app.xlgl.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.css.app.xlgl.entity.XlglNoticeRead;
import com.css.app.xlgl.service.XlglNoticeReadService;
import com.css.base.entity.SSOUser;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.PageUtils;
import com.css.base.utils.Response;
import com.css.base.utils.UUIDUtils;
import com.github.pagehelper.PageHelper;


/**
 * 通知公告已阅人员表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-12 17:14:57
 */
@Controller
@RequestMapping("/app/xlgl/xlglnoticeread")
public class XlglNoticeReadController {
	@Autowired
	private XlglNoticeReadService xlglNoticeReadService;
	
	/**
	 * 通知公告已阅人员列表
	 * @param noticeId notic表id 
	 */
	@ResponseBody
	@RequestMapping("/list")
	public void list(Integer page, Integer limit,String id){
		Map<String, Object> map = new HashMap<>();
		map.put("noticeId", id);
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<XlglNoticeRead> xlglNoticeReadList = xlglNoticeReadService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(xlglNoticeReadList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info")
	public void info(String id){
		XlglNoticeRead xlglNoticeRead = xlglNoticeReadService.queryObject(id);
		Response.json("xlglNoticeRead", xlglNoticeRead);
	}
	
	/**
	 * 通知公告已阅人员保存
	 * @param noticeId  notic表id 
	 */
	@ResponseBody
	@RequestMapping("/save")
	public void save(String id){
		SSOUser ssoUser = CurrentUser.getSSOUser();
		//判断是否已读过，已读就不更新表了
		XlglNoticeRead xlgl = xlglNoticeReadService.queryIsRead(id,ssoUser.getUserId());
		if(xlgl == null){
		XlglNoticeRead xlglNoticeRead = new XlglNoticeRead();
		xlglNoticeRead.setId(UUIDUtils.random());
		xlglNoticeRead.setNoticeId(id);
		xlglNoticeRead.setReadDate(new Date());
		xlglNoticeRead.setReadUserId(ssoUser.getUserId());
		xlglNoticeRead.setReadUserName(ssoUser.getFullname());
		xlglNoticeRead.setReadOrgId(ssoUser.getOrganId());
		xlglNoticeRead.setReadOrgName(ssoUser.getOrgName());
		xlglNoticeReadService.save(xlglNoticeRead);
		}
		Response.json("result","success");
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public void update(XlglNoticeRead xlglNoticeRead){
		xlglNoticeReadService.update(xlglNoticeRead);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public void delete(String[] ids){
		xlglNoticeReadService.deleteBatch(ids);
		
		Response.ok();
	}
	
}
