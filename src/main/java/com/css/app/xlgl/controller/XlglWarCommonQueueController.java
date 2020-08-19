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
import com.css.app.xlgl.entity.XlglWarCommonQueueRead;
import com.css.app.xlgl.service.XlglPictureService;
import com.css.app.xlgl.service.XlglWarCommonQueueReadService;
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
	@Autowired
	private XlglWarCommonQueueReadService xlglWarCommonQueueReadService;
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
		PageUtils pageUtil = new PageUtils(xlglWarCommonQueueList);
		Map<String, Object> fileMap = new HashMap<>();
		Map<String, Object> hashMap = new HashMap<>();
		hashMap.put("readUserId", CurrentUser.getUserId());
		for (XlglWarCommonQueue xlglWarCommonQueue : xlglWarCommonQueueList) {
			hashMap.put("queueId", xlglWarCommonQueue.getId());
			List<XlglWarCommonQueueRead> readList = xlglWarCommonQueueReadService.queryList(hashMap);
			if(readList.size() >0) {
				xlglWarCommonQueue.setReadStatus("1");
			}else {
				xlglWarCommonQueue.setReadStatus("0");
			}
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
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info")
	public void info(String id){
		SSOUser ssoUser = CurrentUser.getSSOUser();
		Map<String, Object> map = new HashMap<>();
		map.put("queueId", id);
		map.put("readUserId", ssoUser.getUserId());
		XlglWarCommonQueue xlglWarCommonQueue = xlglWarCommonQueueService.queryObject(id);
		xlglWarCommonQueue.setViewNumber(xlglWarCommonQueue.getViewNumber()+1);
		xlglWarCommonQueueService.update(xlglWarCommonQueue);
		//已读记录表
		List<XlglWarCommonQueueRead> queryList = xlglWarCommonQueueReadService.queryList(map);
		if(queryList.size()>0) {
			XlglWarCommonQueueRead xlglWarCommonQueueRead = queryList.get(0);
			xlglWarCommonQueueRead.setReadDate(new Date());
			xlglWarCommonQueueReadService.update(xlglWarCommonQueueRead);
		}else {
			XlglWarCommonQueueRead xlglWarCommonQueueRead = new XlglWarCommonQueueRead();
			xlglWarCommonQueueRead.setId(UUIDUtils.random());
			xlglWarCommonQueueRead.setQueueId(id);
			xlglWarCommonQueueRead.setReadOrgName(ssoUser.getOrgName());
			xlglWarCommonQueueRead.setReadOrgId(ssoUser.getOrganId());
			xlglWarCommonQueueRead.setReadUserId(ssoUser.getUserId());
			xlglWarCommonQueueRead.setReadUserName(ssoUser.getFullname());
			xlglWarCommonQueueRead.setReadDate(new Date());
			xlglWarCommonQueueReadService.save(xlglWarCommonQueueRead);
		}
		
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
