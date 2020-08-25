package com.css.app.xlgl.controller;

import java.text.ParseException;
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
import com.css.app.xlgl.entity.XlglExamExamine;
import com.css.app.xlgl.entity.XlglExamExamineMakeup;
import com.css.app.xlgl.entity.XlglExamExaminetopic;
import com.css.app.xlgl.service.XlglExamExamineMakeupService;
import com.css.app.xlgl.service.XlglExamExamineService;
import com.css.app.xlgl.service.XlglExamExaminetopicService;


/**
 * 补考表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-11 10:53:14
 */
@Controller
@RequestMapping("app/xlgl/xlglexamexaminemakeup")
public class XlglExamExamineMakeupController {
	private final Logger logger = LoggerFactory.getLogger(XlglNewsController.class);
	
	@Autowired
	private XlglExamExamineMakeupService xlglExamExamineMakeupService;
	@Autowired
	private XlglExamExaminetopicService xlglExamExaminetopicService;
	@Autowired
	private XlglExamExamineService xlglExamExamineService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<XlglExamExamineMakeup> xlglExamExamineMakeupList = xlglExamExamineMakeupService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(xlglExamExamineMakeupList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info")
	public void info(String id){
		XlglExamExamineMakeup xlglExamExamineMakeup = xlglExamExamineMakeupService.queryObject(id);
		Response.json("xlglExamExamineMakeup", xlglExamExamineMakeup);
	}
	
	/**
	 * 补考  保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	public void save(XlglExamExamineMakeup xlglExamExamineMakeup,String[] typeAndNum){
		Map<String,Object> HashMap = new HashMap<String,Object>();
		String random = UUIDUtils.random();
		xlglExamExamineMakeup.setId(random);
		HashMap.put("examineId", xlglExamExamineMakeup.getExamineId());
		List<XlglExamExamineMakeup> queryList = xlglExamExamineMakeupService.queryList(HashMap);
		if(queryList.size() >0) {
			xlglExamExamineMakeup.setSort(queryList.size()+1);
		}else {
			xlglExamExamineMakeup.setSort(0);
		}
		
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
				Date startDate = format.parse(xlglExamExamineMakeup.getMakeUpStartDateStr());
				Date endDate = format.parse(xlglExamExamineMakeup.getMakeUpEndDateStr());
				xlglExamExamineMakeup.setMakeUpStartDate(startDate);
				xlglExamExamineMakeup.setMakeUpEndDate(endDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		
		xlglExamExamineMakeupService.save(xlglExamExamineMakeup);
		XlglExamExamine queryObject = xlglExamExamineService.queryObject(xlglExamExamineMakeup.getExamineId());
		queryObject.setOverStatus("2");
		xlglExamExamineService.update(queryObject);
		queryObject.setOverStatus("2");
		for (int i = 0; i < typeAndNum.length; i++) {
			Map<String,Object> map = new HashMap<String,Object>();
			String[] split2 = typeAndNum[i].split("-");
			map.put("subjectId", queryObject.getExamineSubjectId());
			map.put("topicType", split2[0]);
			map.put("topicNumber", split2[1]);
			map.put("fractionalNumber", split2[2]);
			List<XlglExamExaminetopic> randomExtract = xlglExamExaminetopicService.randomExtract(map, queryObject.getId(),random);
			if(randomExtract.size()>0) {
				xlglExamExaminetopicService.saveBatch(randomExtract);
			}
		}
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public void update(XlglExamExamineMakeup xlglExamExamineMakeup){
		xlglExamExamineMakeupService.update(xlglExamExamineMakeup);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public void delete(String[] ids){
		xlglExamExamineMakeupService.deleteBatch(ids);
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		logger.info("当前删除操作人："+CurrentUser.getUsername()+"---id:"+CurrentUser.getUserId()+"--时间是："+date);
		Response.ok();
	}
	
}
