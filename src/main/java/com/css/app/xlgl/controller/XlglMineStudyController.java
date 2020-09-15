package com.css.app.xlgl.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.css.filestore.impl.HTTPFile;
import com.alibaba.fastjson.JSONObject;
import com.css.addbase.FileBaseUtil;
import com.css.addbase.apporgan.entity.BaseAppUser;
import com.css.addbase.apporgan.service.BaseAppUserService;
import com.css.app.xlgl.entity.XlglMineStudy;
import com.css.app.xlgl.entity.XlglPhysical;
import com.css.app.xlgl.entity.XlglPhysicalRecord;
import com.css.app.xlgl.entity.XlglStudyRecord;
import com.css.app.xlgl.service.XlglMineStudyService;
import com.css.app.xlgl.service.XlglPhysicalService;
import com.css.app.xlgl.service.XlglStudyRecordService;
import com.css.base.utils.CurrentUser;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import com.css.base.utils.PageUtils;
import com.css.base.utils.UUIDUtils;
import com.github.pagehelper.PageHelper;
import com.css.base.utils.Response;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;


/**
 * 训练管理自学表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-21 14:37:00
 */
@Controller
@RequestMapping("/app/xlgl/xlglminestudy")
public class XlglMineStudyController {
	@Autowired
	private XlglMineStudyService xlglMineStudyService;
	@Autowired
	private XlglPhysicalService xlglPhysicalService;

	@Value("${filePath}")
	private String filePath;
	@Autowired
	private BaseAppUserService baseAppUserService;
	@Autowired
	private XlglStudyRecordService xlglStudyRecordService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		//查询列表数据
		List<XlglMineStudy> xlglMineStudyList = xlglMineStudyService.queryList(map);
		PageUtils pageUtil = new PageUtils(xlglMineStudyList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	@RequiresPermissions("xlglminestudy:info")
	public void info(@PathVariable("id") String id){
		XlglMineStudy xlglMineStudy = xlglMineStudyService.queryObject(id);
		Response.json("xlglMineStudy", xlglMineStudy);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	@RequiresPermissions("xlglminestudy:save")
	public void save(@RequestBody XlglMineStudy xlglMineStudy){
		xlglMineStudy.setId(UUIDUtils.random());
		xlglMineStudyService.save(xlglMineStudy);
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("xlglminestudy:update")
	public void update(@RequestBody XlglMineStudy xlglMineStudy){
		xlglMineStudyService.update(xlglMineStudy);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public void delete(String id){
		String[] ids = id.split(",");
		xlglMineStudyService.deleteBatch(ids);
		Response.json("result","success");
	}

	/**
	 * 军事体育成绩先导出
	 */
	@ResponseBody
	@RequestMapping("/exportList")
	public void exportList(String deptId,HttpServletResponse response){
		String orgId = baseAppUserService.getBareauByUserId(CurrentUser.getUserId());
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("orgId",deptId);
		List<BaseAppUser> infoList = baseAppUserService.queryAllExcelList(map);
		File tempFile = new File(filePath, "自学成绩清单.xls");
		if (tempFile.exists()) {
			tempFile.delete();
		} else {
			tempFile.getParentFile().mkdirs();
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		InputStream is;
		try {
			is = xlglMineStudyService.createExcelInfoFile(infoList, tempFile.getAbsolutePath());
			OutputStream os = null;
			byte[] buff = new byte[1024];
			response.reset();
			response.setContentType("application/octet-stream");
			response.setCharacterEncoding("UTF-8");
			response.addHeader("Content-Disposition", "attachment;filename="
					+ new String(tempFile.getName().getBytes(),"ISO-8859-1"));
			os = response.getOutputStream();
			BufferedInputStream bis = new BufferedInputStream(is);
			int i = 0;
			try {
				while ((i = bis.read(buff)) != -1) {
					os.write(buff, 0, i);
					os.flush();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				bis.close();
			}
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
	public void importExcel(@RequestParam(required = false) MultipartFile file) {
		JSONObject jsonObject = new JSONObject();
		try {
			//文件上传记录
			XlglStudyRecord xlglStudyRecord = new XlglStudyRecord();
			String id = UUIDUtils.random();
			xlglStudyRecord.setId(id);
			xlglStudyRecord.setUserId(CurrentUser.getUserId());
			xlglStudyRecord.setDeptName(CurrentUser.getOrgName());
			xlglStudyRecord.setUserName(CurrentUser.getUsername());
			String fileId = FileBaseUtil.fileServiceUpload(file);
			HTTPFile httpFile = new HTTPFile(fileId);
			InputStream inputStream = httpFile.getInputSteam();
			List<XlglMineStudy> list = xlglMineStudyService.importExcle(inputStream,id);
			if (list != null && list.size() > 0) {
				for (XlglMineStudy xlglMineStudy : list) {
					xlglMineStudy.setCreatedTime(new Date());
					xlglMineStudyService.save(xlglMineStudy);
				}
			}

			xlglStudyRecord.setCreatedTime(new Date());
			xlglStudyRecordService.save(xlglStudyRecord);
			Response.json("fileId",fileId);
		} catch (Exception e) {
			e.printStackTrace();
		}


	}
	
}
