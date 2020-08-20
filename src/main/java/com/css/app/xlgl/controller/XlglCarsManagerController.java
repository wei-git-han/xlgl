package com.css.app.xlgl.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.css.filestore.impl.HTTPFile;
import com.alibaba.fastjson.JSONObject;
import com.css.addbase.AppConfig;
import com.css.addbase.FileBaseUtil;
import com.css.addbase.suwell.OfdTransferUtil;
import com.css.app.db.business.entity.DocumentFile;
import com.css.app.xlgl.entity.XlglCarsManager;
import com.css.app.xlgl.entity.XlglPicture;
import com.css.app.xlgl.service.XlglCarsManagerService;
import com.css.app.xlgl.service.XlglPictureService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import com.css.base.utils.PageUtils;
import com.css.base.utils.UUIDUtils;
import com.github.pagehelper.PageHelper;
import com.css.base.utils.Response;
import org.springframework.web.multipart.MultipartFile;


/**
 * 训练管理车辆管理表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-17 14:15:57
 */
@Controller
@RequestMapping("/app/xlgl/xlglcarsmanager")
public class XlglCarsManagerController {
	@Autowired
	private XlglCarsManagerService xlglCarsManagerService;
	@Autowired
	private XlglPictureService xlglPictureService;
	@Autowired
	private AppConfig appConfig;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("xlglcarsmanager:list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<XlglCarsManager> xlglCarsManagerList = xlglCarsManagerService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(xlglCarsManagerList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	@RequiresPermissions("xlglcarsmanager:info")
	public void info(@PathVariable("id") String id){
		XlglCarsManager xlglCarsManager = xlglCarsManagerService.queryObject(id);
		Response.json("xlglCarsManager", xlglCarsManager);
	}
	
	/**
	 * 保存
     * 点击新增的时候，调用这个接口，创建一个表数据
	 */
	@ResponseBody
	@RequestMapping("/save")
	public void save(XlglCarsManager xlglCarsManager){
		xlglCarsManager.setId(UUIDUtils.random());
		xlglCarsManager.setCreaetdTime(new Date());
		xlglCarsManagerService.save(xlglCarsManager);
		Response.json("xlglCarsManager",xlglCarsManager);
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("xlglcarsmanager:update")
	public void update(@RequestBody XlglCarsManager xlglCarsManager){
		xlglCarsManagerService.update(xlglCarsManager);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("xlglcarsmanager:delete")
	public void delete(@RequestBody String[] ids){
		xlglCarsManagerService.deleteBatch(ids);
		
		Response.ok();
	}

	/**
	 * 文件上传保存
	 *
	 * @param fileId
	 *            主记录id(documentInfo的id)
	 * @param pdf
	 *            文件
	 */
	@ResponseBody
	@RequestMapping("/uploadFile")
	public void savePDF(String fileId, @RequestParam(required = false) MultipartFile[] pdf) {
		String formatDownPath = "";// 版式文件下载路径
		String retFormatId = null;// 返回的版式文件id
		String streamId = null;// 流式文件id
		String formatId = null;// 版式文件id
		JSONObject json = new JSONObject();
		if (StringUtils.isNotBlank(fileId)) {
			if (pdf != null && pdf.length > 0) {
				for (int i = 0; i < pdf.length; i++) {
					String fileName = pdf[i].getOriginalFilename();
					// 获取文件后缀
					String fileType = fileName.substring(fileName.lastIndexOf(".") + 1);
					// 如果文件是流式则流式转换为版式
					if (!StringUtils.equals("ofd", fileType)) {
						streamId = FileBaseUtil.fileServiceUpload(pdf[i]);
						HTTPFile hf = new HTTPFile(streamId);
						try {
							String path = appConfig.getLocalFilePath() + UUIDUtils.random() + "." + hf.getSuffix();
							try {
								FileUtils.moveFile(new File(hf.getFilePath()), new File(path));
							} catch (IOException e) {
								e.printStackTrace();
							}
							if (StringUtils.isNotBlank(path)) {
								formatId = OfdTransferUtil.convertLocalFileToOFD(path);
							}
							// 删除本地的临时流式文件
							if (new File(path).exists()) {
								new File(path).delete();
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					} else {
						formatId = FileBaseUtil.fileServiceUpload(pdf[i]);
					}
					if (StringUtils.isNotBlank(formatId)) {
						if (i == 0) {
							retFormatId = formatId;
							// 获取版式文件的下载路径
							HTTPFile httpFiles = new HTTPFile(formatId);
							if (httpFiles != null) {
								formatDownPath = httpFiles.getAssginDownloadURL(true);
							}
						}
						// 保存文件相关数据
						XlglCarsManager file = new XlglCarsManager();
						file.setId(fileId);
						file.setInfoId(fileId);
						file.setFileName(fileName);
						file.setFileServerFormatId(formatId);
						xlglCarsManagerService.save(file);
					}
				}
				json.put("smjId", retFormatId);
				json.put("smjFilePath", formatDownPath);
				json.put("result", "success");
			}
		} else {
			json.put("result", "fail");
		}
		Response.json(json);
	}
	
}
