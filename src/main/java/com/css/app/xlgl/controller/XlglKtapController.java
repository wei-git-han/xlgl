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
import com.css.app.xlgl.entity.XlglKtap;
import com.css.app.xlgl.entity.XlglZbgl;
import com.css.app.xlgl.service.XlglKtapService;
import com.css.base.utils.CurrentUser;
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
 * 训练管理课题安排
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-18 18:32:15
 */
@Controller
@RequestMapping("/app/xlgl/xlglktap")
public class XlglKtapController {
	@Autowired
	private XlglKtapService xlglKtapService;
	@Autowired
	private AppConfig appConfig;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<XlglKtap> xlglKtapList = xlglKtapService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(xlglKtapList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	@RequiresPermissions("xlglktap:info")
	public void info(@PathVariable("id") String id){
		XlglKtap xlglKtap = xlglKtapService.queryObject(id);
		Response.json("xlglKtap", xlglKtap);
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	public void save(XlglZbgl xlglZbgl, @RequestParam(required = false) MultipartFile[] pdf){
		String formatDownPath = "";// 版式文件下载路径
		String retFormatId = null;// 返回的版式文件id
		String streamId = null;// 流式文件id
		String formatId = null;// 版式文件id
		JSONObject json = new JSONObject();
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
					XlglKtap xlglKtap = xlglKtapService.queryObject(xlglZbgl.getId());
					if(xlglZbgl == null){
						xlglZbgl.setId(UUIDUtils.random());
						xlglZbgl.setCreatedTime(new Date());
						xlglZbgl.setFileId(formatId);
						xlglZbgl.setFileName(fileName);
						xlglZbgl.setCreator(CurrentUser.getUserId());
						xlglKtapService.save(xlglKtap);
					}else {
						xlglZbgl.setFileId(formatId);
						xlglZbgl.setFileName(fileName);
						xlglZbgl.setCreatedTime(new Date());
						xlglKtapService.update(xlglKtap);
					}

				}
			}
			json.put("smjId", retFormatId);
			json.put("smjFilePath", formatDownPath);
			json.put("result", "success");
		}


		Response.json(json);
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("xlglktap:update")
	public void update(@RequestBody XlglKtap xlglKtap){
		xlglKtapService.update(xlglKtap);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("xlglktap:delete")
	public void delete(@RequestBody String[] ids){
		xlglKtapService.deleteBatch(ids);
		
		Response.ok();
	}
	
}
