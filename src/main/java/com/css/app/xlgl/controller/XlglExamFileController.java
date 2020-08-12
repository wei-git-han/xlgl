package com.css.app.xlgl.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

import com.css.base.utils.CurrentUser;
import com.css.base.utils.PageUtils;
import com.css.base.utils.UUIDUtils;
import com.github.pagehelper.PageHelper;
import com.css.base.utils.Response;
import com.css.app.xlgl.entity.XlglExamFile;
import com.css.app.xlgl.service.XlglExamFileService;


/**
 * 考试模块模板文件id
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-11 15:17:38
 */
@Controller
@RequestMapping("app/xlgl/xlglexamfile")
public class XlglExamFileController {
	private final Logger logger = LoggerFactory.getLogger(XlglNewsController.class);
	
	@Autowired
	private XlglExamFileService xlglExamFileService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	public void list(){
		Map<String, Object> map = new HashMap<>();
		//PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<XlglExamFile> xlglExamFileList = xlglExamFileService.queryList(map);
		
		//PageUtils pageUtil = new PageUtils(xlglExamFileList);
		Response.json("list",xlglExamFileList);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info")
	@RequiresPermissions("xlglexamfile:info")
	public void info(String id){
		XlglExamFile xlglExamFile = xlglExamFileService.queryObject(id);
		Response.json("xlglExamFile", xlglExamFile);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	public void save(XlglExamFile xlglExamFile){
		xlglExamFile.setId(UUIDUtils.random());
		xlglExamFileService.save(xlglExamFile);
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public void update(XlglExamFile xlglExamFile){
		xlglExamFileService.update(xlglExamFile);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public void delete(String[] ids){
		xlglExamFileService.deleteBatch(ids);
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		logger.info("当前删除操作人："+CurrentUser.getUsername()+"---id:"+CurrentUser.getUserId()+"--时间是："+date);
		Response.ok();
	}
	
}
