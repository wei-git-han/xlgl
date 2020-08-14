package com.css.app.xlgl.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.css.app.xlgl.entity.XlglPicture;
import com.css.app.xlgl.entity.XlglWarCommonQueue;
import com.css.app.xlgl.service.XlglPictureService;
import com.css.app.xlgl.service.XlglWarCommonQueueService;
import com.css.base.entity.SSOUser;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.PageUtils;
import com.css.base.utils.Response;
import com.css.base.utils.StringUtils;
import com.css.base.utils.UUIDUtils;
import com.github.pagehelper.PageHelper;


/**
 * 军事训练-共同训练-队列训练
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-14 16:52:03
 */
@Controller
@RequestMapping("/xlglwarcommonqueue")
public class XlglWarCommonQueueController {
	@Autowired
	private XlglWarCommonQueueService xlglWarCommonQueueService;
	@Autowired
	private XlglPictureService xlglPictureService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		//查询列表数据
		List<XlglWarCommonQueue> xlglWarCommonQueueList = xlglWarCommonQueueService.queryList(map);
		Map<String, Object> fileMap = new HashMap<>();
		for (XlglWarCommonQueue xlglWarCommonQueue : xlglWarCommonQueueList) {
			fileMap.put("id", xlglWarCommonQueue.getId());
			List<XlglPicture> queryList = xlglPictureService.queryList(map);
			List<String> list = new ArrayList<String>();
			for (XlglPicture xlglPicture : queryList) { //1:图片，2：视频，3：附件，4：封面
				if(xlglPicture.getPictureType().equals("2")) {
					xlglWarCommonQueue.setVideoFile(xlglPicture.getPictureId());
				}else if(xlglPicture.getPictureType().equals("3")) {
					list.add(xlglPicture.getPictureId());
				}else if(xlglPicture.getPictureType().equals("4")) {
					xlglWarCommonQueue.setCoverFile(xlglPicture.getPictureId());
				}
			}
			xlglWarCommonQueue.setAccessoryFileArray(list);
		}
		
		PageUtils pageUtil = new PageUtils(xlglWarCommonQueueList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info")
	public void info(String id){
		XlglWarCommonQueue xlglWarCommonQueue = xlglWarCommonQueueService.queryObject(id);
		Response.json("xlglWarCommonQueue", xlglWarCommonQueue);
	}
	
	/**
	 * 保存
	 * @param coverFile 封面上传id
	 * @param videoFile 视频上传id
	 * @param accessoryFile 多个附件上传id 
	 */
	@ResponseBody
	@RequestMapping("/save")
	public void save(XlglWarCommonQueue xlglWarCommonQueue,String coverFile,String videoFile,String[] accessoryFile){
		SSOUser ssoUser = CurrentUser.getSSOUser();
		Date date = new Date();
		String random = UUIDUtils.random();
		xlglWarCommonQueue.setId(random);
		xlglWarCommonQueue.setCreateOrganId(ssoUser.getOrganId());
		xlglWarCommonQueue.setCreateOrganName(ssoUser.getOrgName());
		xlglWarCommonQueue.setCreateDate(date);
		xlglWarCommonQueue.setCreateUser(ssoUser.getUserId());
		xlglWarCommonQueue.setPublishDate(date);
		xlglWarCommonQueueService.save(xlglWarCommonQueue);
		if(StringUtils.isNotBlank(coverFile)) {
			xlglPictureService.savePicture(random,coverFile,"4");
		}
		if(StringUtils.isNotBlank(videoFile)) {
			xlglPictureService.savePicture(random,videoFile,"2");
		}
		if(accessoryFile !=null) {
			for (String string : accessoryFile) {
				xlglPictureService.savePicture(random,string,"3");
			}
		}
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public void update(XlglWarCommonQueue xlglWarCommonQueue){
		xlglWarCommonQueueService.update(xlglWarCommonQueue);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public void delete(String[] ids){
		xlglWarCommonQueueService.deleteBatch(ids);
		
		Response.ok();
	}
	

}
