package com.css.app.xlgl.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.css.app.xlgl.entity.XlglPhysical;
import com.css.app.xlgl.service.XlglPhysicalService;
import com.css.base.utils.CurrentUser;
import org.apache.poi.hssf.eventusermodel.examples.XLS2CSVmra;
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
 * 军事体育训练
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-20 19:38:37
 */
@Controller
@RequestMapping("/app/xlgl/xlglphysical")
public class XlglPhysicalController {
	@Autowired
	private XlglPhysicalService xlglPhysicalService;

	private TestController testController;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		map.put("userId",CurrentUser.getUserId());
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<XlglPhysical> xlglPhysicalList = xlglPhysicalService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(xlglPhysicalList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info")
	public void info(String id){
		XlglPhysical xlglPhysical = xlglPhysicalService.queryObject(id);
		Response.json("xlglPhysical", xlglPhysical);
	}

	//(int age,int up,int sit,int sRun,int tRun,int sex,int type )
	/**
	 * 保存
	 * 页面输入分数，会自动算出所有的分数，按照不同字段传进来就行
	 */
	@ResponseBody
	@RequestMapping("/save")
	public void save(XlglPhysical xlglPhysical){
		xlglPhysical.setId(UUIDUtils.random());
		xlglPhysical.setCreator(CurrentUser.getUserId());
		xlglPhysical.setCreatedTime(new Date());
		xlglPhysical.setUserId(CurrentUser.getUserId());

//		int age = Integer.parseInt(xlglPhysical.getAge());
//		int up = Integer.parseInt(xlglPhysical.getUp());
//		int sit = Integer.parseInt(xlglPhysical.getSit());
//		int sRun = Integer.parseInt(xlglPhysical.getSrun());
//		int tRun = Integer.parseInt(xlglPhysical.getTrun());
//		int sex = Integer.parseInt(xlglPhysical.getSex());
//		int type = Integer.parseInt(xlglPhysical.getType());
//		persinalCore persinalCore = new persinalCore();
//		JSONObject jsonObject = persinalCore.getSumCore(age,up,sit,sRun,tRun,sex,type);
//		String score = jsonObject.get("score").toString();
//		String dj =jsonObject.get("dj").toString();
//		xlglPhysical.setAllScore(score);
//		xlglPhysical.setAllJudge(dj);
		xlglPhysicalService.save(xlglPhysical);

		
		Response.json("result","success");
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("xlglphysical:update")
	public void update(@RequestBody XlglPhysical xlglPhysical){
		xlglPhysicalService.update(xlglPhysical);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public void delete(String[] id){
		xlglPhysicalService.deleteBatch(id);
		
		Response.ok();
	}
	
}
