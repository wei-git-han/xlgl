package com.css.app.xlgl.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.css.app.xlgl.entity.XlglExamExaminetopic;
import com.css.app.xlgl.service.XlglExamExaminetopicService;
import com.css.app.xlgl.service.XlglExamTopicService;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.PageUtils;
import com.css.base.utils.Response;
import com.css.base.utils.UUIDUtils;
import com.github.pagehelper.PageHelper;


/**
 * 训练考核-考核组织-考试副表题目表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-07-30 10:56:43
 */
@Controller
@RequestMapping("app/xlgl/xlglexamexaminetopic")
public class XlglExamExaminetopicController {
	private final Logger logger = LoggerFactory.getLogger(XlglNewsController.class);
	
	@Autowired
	private XlglExamExaminetopicService xlglExamExaminetopicService;
	@Autowired
	private XlglExamTopicService xlglExamTopicService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<XlglExamExaminetopic> xlglExamExaminetopicList = xlglExamExaminetopicService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(xlglExamExaminetopicList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info")
	public void info(String id){
	
		XlglExamExaminetopic xlglExamExaminetopic = xlglExamExaminetopicService.queryObject(id);
		Response.json("xlglExamExaminetopic", xlglExamExaminetopic);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	public void save(XlglExamExaminetopic xlglExamExaminetopic){
		xlglExamExaminetopic.setId(UUIDUtils.random());
		xlglExamExaminetopicService.save(xlglExamExaminetopic);
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public void update(XlglExamExaminetopic xlglExamExaminetopic){
		xlglExamExaminetopicService.update(xlglExamExaminetopic);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public void delete(String[] ids){
		xlglExamExaminetopicService.deleteBatch(ids);
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		logger.info("当前删除操作人："+CurrentUser.getUsername()+"---id:"+CurrentUser.getUserId()+"--时间是："+date);
		Response.ok();
	}
	
	
}
