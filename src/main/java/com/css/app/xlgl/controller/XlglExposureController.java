package com.css.app.xlgl.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.css.app.xlgl.entity.XlglExposure;
import com.css.app.xlgl.service.XlglExposureService;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.PageUtils;
import com.css.base.utils.Response;
import com.css.base.utils.UUIDUtils;
import com.github.pagehelper.PageHelper;


/**
 * 首页-曝光台表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-09-08 10:41:01
 */
@Controller
@RequestMapping("app/xlgl/xlglexposure")
public class XlglExposureController {
	@Autowired
	private XlglExposureService xlglExposureService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<XlglExposure> xlglExposureList = xlglExposureService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(xlglExposureList);
		Response.json("page",pageUtil);
	}
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/listInfo")
	public void listInfo(){
		JSONObject jsonObject = new JSONObject();
		Map<String, Object> map = new HashMap<>();
		//查询列表数据
		List<XlglExposure> xlglExposureList = xlglExposureService.queryListInfo(map);
		if(xlglExposureList.size()>0) {
			XlglExposure xlglExposure = xlglExposureList.get(0);
			jsonObject.put("xlglExposure", xlglExposure);
		}
		jsonObject.put("code", "0");
		jsonObject.put("msg", "success");
		Response.json(jsonObject);
	}
	
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info")
	public void info(String id){
		XlglExposure xlglExposure = xlglExposureService.queryObject(id);
		Response.json("xlglExposure", xlglExposure);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	public void save(XlglExposure xlglExposure){
		xlglExposure.setId(UUIDUtils.random());
		xlglExposure.setCreateDate(new Date());
		xlglExposure.setCreateUserid(CurrentUser.getUserId());
		xlglExposure.setCreateUsername(CurrentUser.getUsername());
		xlglExposure.setUpdateDate(new Date());
		xlglExposure.setUpdateUserid(CurrentUser.getUserId());
		xlglExposureService.save(xlglExposure);
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public void update(XlglExposure xlglExposure){
		xlglExposure.setUpdateDate(new Date());
		xlglExposure.setUpdateUserid(CurrentUser.getUserId());
		xlglExposureService.update(xlglExposure);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public void delete(@RequestBody String[] ids){
		xlglExposureService.deleteBatch(ids);
		
		Response.ok();
	}
	
}
