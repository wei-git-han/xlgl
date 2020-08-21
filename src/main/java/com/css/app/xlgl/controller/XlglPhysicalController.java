package com.css.app.xlgl.controller;

import java.io.File;
import java.io.InputStream;
import java.util.*;

import cn.com.css.filestore.impl.HTTPFile;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.css.addbase.FileBaseUtil;
import com.css.addbase.PinYinUtil;
import com.css.addbase.apporgan.entity.BaseAppUser;
import com.css.addbase.apporgan.service.BaseAppUserService;
import com.css.addbase.constant.AppConstant;
import com.css.addbase.constant.AppInterfaceConstant;
import com.css.app.xlgl.entity.XlglPhysical;
import com.css.app.xlgl.service.XlglPhysicalService;
import com.css.base.utils.*;
import org.apache.poi.hssf.eventusermodel.examples.XLS2CSVmra;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import com.github.pagehelper.PageHelper;
import org.springframework.web.multipart.MultipartFile;


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

	@Value("${filePath}")
	private String filePath;
	@Autowired
	private BaseAppUserService baseAppUserService;
	
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

	/**
	 * 军事体育成绩先导出
	 */
	@ResponseBody
	@RequestMapping("/exportList")
	public void exportList(){
		String orgId = baseAppUserService.getBareauByUserId(CurrentUser.getUserId());
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("orgId",orgId);
		List<BaseAppUser> infoList = baseAppUserService.queryAllExcelList(map);
		File tempFile = new File(filePath, "军事体育成绩清单.xls");
		if (tempFile.exists()) {
			tempFile.delete();
		} else {
			tempFile.getParentFile().mkdirs();
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		InputStream is;
		try {
			is = xlglPhysicalService.createExcelInfoFile(infoList, tempFile.getAbsolutePath());
			is.close();
			resultMap.put("fileUrl", tempFile.getAbsoluteFile());
			resultMap.put("fileName", tempFile.getName());
			resultMap.put("result", "success");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Response.json(resultMap);
	}


	/**
	 * 军事体育成绩导入
	 */

	@ResponseBody
	@RequestMapping("/importExcel")
	public void importExcel(@RequestParam(value="file",required = false) MultipartFile file) {
		JSONObject jsonObject = new JSONObject();
		try {
			String fileId = FileBaseUtil.fileServiceUpload(file);
			HTTPFile httpFile = new HTTPFile(fileId);
			InputStream inputStream = httpFile.getInputSteam();
			List<XlglPhysical> list = xlglPhysicalService.importExcle(inputStream);
			if (list != null && list.size() > 0) {
				for (XlglPhysical xlglPhysical : list) {
					xlglPhysicalService.save(xlglPhysical);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}


	}
}
