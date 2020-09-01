package com.css.app.xlgl.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

import com.css.base.entity.SSOUser;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.PageUtils;
import com.css.base.utils.UUIDUtils;
import com.github.pagehelper.PageHelper;

import cn.com.css.filestore.impl.HTTPFile;

import com.css.base.utils.Response;
import com.css.base.utils.StringUtils;
import com.css.app.xlgl.dto.AccessoryFileDto;
import com.css.app.xlgl.entity.XlglPicture;
import com.css.app.xlgl.entity.XlglWarCommonQueue;
import com.css.app.xlgl.entity.XlglWarCommonQueueRead;
import com.css.app.xlgl.entity.XlglWarCommonWarbasis;
import com.css.app.xlgl.entity.XlglWarCommonWarbasisRead;
import com.css.app.xlgl.service.XlglPictureService;
import com.css.app.xlgl.service.XlglWarCommonWarbasisReadService;
import com.css.app.xlgl.service.XlglWarCommonWarbasisService;


/**
 * 军事训练-共同训练-战备基础
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-19 10:14:39
 */
@Controller
@RequestMapping("app/xlgl/xlglwarcommonwarbasis")
public class XlglWarCommonWarbasisController {
	@Autowired
	private XlglWarCommonWarbasisService xlglWarCommonWarbasisService;
	@Autowired
	private XlglPictureService xlglPictureService;
	@Autowired
	private XlglWarCommonWarbasisReadService xlglWarCommonWarbasisReadService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	public void list(Integer page, Integer limit,String title){
		Map<String, Object> map = new HashMap<>();
		map.put("title", title);
		PageHelper.startPage(page, limit);
		//查询列表数据
		List<XlglWarCommonWarbasis> xlglWarCommonWarbasisList = xlglWarCommonWarbasisService.queryList(map);
		PageUtils pageUtil = new PageUtils(xlglWarCommonWarbasisList);
		Map<String, Object> fileMap = new HashMap<>();
		Map<String, Object> hashMap = new HashMap<>();
		hashMap.put("readUserId", CurrentUser.getUserId());
		for (XlglWarCommonWarbasis xlglWarCommonWarbasis : xlglWarCommonWarbasisList) {
			hashMap.put("queueId", xlglWarCommonWarbasis.getId());
			List<XlglWarCommonWarbasisRead> readList = xlglWarCommonWarbasisReadService.queryList(hashMap);
			if(readList.size() >0) {
				xlglWarCommonWarbasis.setReadStatus("1");
			}else {
				xlglWarCommonWarbasis.setReadStatus("0");
			}
			fileMap.put("id", xlglWarCommonWarbasis.getId());
			List<XlglPicture> queryList = xlglPictureService.queryList(fileMap);
			
			List<AccessoryFileDto> list = new LinkedList<AccessoryFileDto>();
			for (XlglPicture xlglPicture : queryList) { //1:图片，2：视频，3：附件，4：封面
				if(xlglPicture.getPictureType().equals("2")) {
					xlglWarCommonWarbasis.setVideoFile(xlglPicture.getPictureId());
					xlglWarCommonWarbasis.setVideoFileName(xlglPicture.getPictureName());
				}else if(xlglPicture.getPictureType().equals("3")) {
					AccessoryFileDto accessoryFileDto = new AccessoryFileDto();
					accessoryFileDto.setFileId(xlglPicture.getPictureId());
					accessoryFileDto.setFileName(xlglPicture.getPictureName());
					list.add(accessoryFileDto);
				}else if(xlglPicture.getPictureType().equals("4")) {
					xlglWarCommonWarbasis.setCoverFile(xlglPicture.getPictureId());
					xlglWarCommonWarbasis.setCoverFileName(xlglPicture.getPictureName());
				}
			}
			xlglWarCommonWarbasis.setAccessoryFileArray(list);

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
		map.put("warbasisId", id);
		map.put("readUserId", ssoUser.getUserId());
		XlglWarCommonWarbasis xlglWarCommonWarbasis = xlglWarCommonWarbasisService.queryObject(id);
		//获取图片、视频、或封面
		Map<String, Object> fileMap = new HashMap<>();
		fileMap.put("id", xlglWarCommonWarbasis.getId());
		
		List<XlglPicture> pictureList = xlglPictureService.queryList(fileMap);
		
		List<AccessoryFileDto> list = new LinkedList<AccessoryFileDto>();
		for (XlglPicture xlglPicture : pictureList) { //1:图片，2：视频，3：附件，4：封面
			if(xlglPicture.getPictureType().equals("2")) {
				xlglWarCommonWarbasis.setVideoFile(xlglPicture.getPictureId());
				xlglWarCommonWarbasis.setVideoFileName(xlglPicture.getPictureName());
			}else if(xlglPicture.getPictureType().equals("3")) {
				AccessoryFileDto accessoryFileDto = new AccessoryFileDto();
				accessoryFileDto.setFileId(xlglPicture.getPictureId());
				accessoryFileDto.setFileName(xlglPicture.getPictureName());
				list.add(accessoryFileDto);
			}else if(xlglPicture.getPictureType().equals("4")) {
				xlglWarCommonWarbasis.setCoverFile(xlglPicture.getPictureId());
				xlglWarCommonWarbasis.setCoverFileName(xlglPicture.getPictureName());
			}
		}
		xlglWarCommonWarbasis.setAccessoryFileArray(list);

		
		//修改浏览次数
		if(xlglWarCommonWarbasis.getViewNumber() !=null) {
			xlglWarCommonWarbasis.setViewNumber(xlglWarCommonWarbasis.getViewNumber()+1);
		}else {	
			xlglWarCommonWarbasis.setViewNumber(1);
		}
		xlglWarCommonWarbasisService.update(xlglWarCommonWarbasis);
		//已读记录表
		List<XlglWarCommonWarbasisRead> queryList = xlglWarCommonWarbasisReadService.queryList(map);
		if(queryList.size()>0) {
			XlglWarCommonWarbasisRead xlglWarCommonWarbasisRead = queryList.get(0);
			xlglWarCommonWarbasisRead.setReadDate(new Date());
			xlglWarCommonWarbasisReadService.update(xlglWarCommonWarbasisRead);
		}else {
			XlglWarCommonWarbasisRead xlglWarCommonWarbasisRead = new XlglWarCommonWarbasisRead();
			xlglWarCommonWarbasisRead.setId(UUIDUtils.random());
			xlglWarCommonWarbasisRead.setWarbasisId(id);
			xlglWarCommonWarbasisRead.setReadOrgName(ssoUser.getOrgName());
			xlglWarCommonWarbasisRead.setReadOrgId(ssoUser.getOrganId());
			xlglWarCommonWarbasisRead.setReadUserId(ssoUser.getUserId());
			xlglWarCommonWarbasisRead.setReadUserName(ssoUser.getFullname());
			xlglWarCommonWarbasisRead.setReadDate(new Date());
			xlglWarCommonWarbasisReadService.save(xlglWarCommonWarbasisRead);
		}
		Response.json("xlglWarCommonWarbasis", xlglWarCommonWarbasis);
	}
	
	/**
	 * 保存
	 * @param coverFile 封面上传id
	 * @param videoFile 视频上传id
	 * @param accessoryFile 多个附件上传id 
	 */
	@ResponseBody
	@RequestMapping("/save")
	public void save(XlglWarCommonWarbasis xlglWarCommonWarbasis,String coverFile,String videoFile,String[] accessoryArray){
		SSOUser ssoUser = CurrentUser.getSSOUser();
		Date date = new Date();
		String random = UUIDUtils.random();
		xlglWarCommonWarbasis.setId(random);
		xlglWarCommonWarbasis.setCreateOrganId(ssoUser.getOrganId());
		xlglWarCommonWarbasis.setCreateOrganName(ssoUser.getOrgName());
		xlglWarCommonWarbasis.setCreateDate(date);
		xlglWarCommonWarbasis.setCreateUser(ssoUser.getUserId());
		xlglWarCommonWarbasis.setPublishDate(date);
		xlglWarCommonWarbasisService.save(xlglWarCommonWarbasis);
		if(StringUtils.isNotBlank(coverFile)) {
			xlglPictureService.savePicture(random,coverFile,"4");
		}
		if(StringUtils.isNotBlank(videoFile)) {
			xlglPictureService.savePicture(random,videoFile,"2");
		}
		if(accessoryArray !=null) {
			for (String string : accessoryArray) {
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
	public void update(XlglWarCommonWarbasis xlglWarCommonWarbasis){
		String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		xlglWarCommonWarbasis.setUpdateUser(CurrentUser.getUserId());
		xlglWarCommonWarbasis.setUpdateDate(format);
		xlglWarCommonWarbasisService.update(xlglWarCommonWarbasis);
		Map<String, Object> map = new HashMap<>();
		map.put("id", xlglWarCommonWarbasis.getId());
		List<XlglPicture> queryList = xlglPictureService.queryList(map);
		if(queryList.size()>0) {
			for (XlglPicture xlglPicture : queryList) {
				xlglPictureService.delete(xlglPicture.getId());
			}
		}
		if(StringUtils.isNotBlank(xlglWarCommonWarbasis.getCoverFile())) {
			xlglPictureService.savePicture(xlglWarCommonWarbasis.getId(),xlglWarCommonWarbasis.getCoverFile(),"4");
		}
		if(StringUtils.isNotBlank(xlglWarCommonWarbasis.getVideoFile())) {
			xlglPictureService.savePicture(xlglWarCommonWarbasis.getId(),xlglWarCommonWarbasis.getVideoFile(),"2");
		}
		if(StringUtils.isNotBlank(xlglWarCommonWarbasis.getAccessoryFile())) {
			if(xlglWarCommonWarbasis.getAccessoryFile().contains(",")) {
				String[] split = xlglWarCommonWarbasis.getAccessoryFile().split(",");
				for (String string : split) {
					xlglPictureService.savePicture(xlglWarCommonWarbasis.getId(),string,"3");
				}
			}else {
				xlglPictureService.savePicture(xlglWarCommonWarbasis.getId(),xlglWarCommonWarbasis.getAccessoryFile(),"3");
			}
		}
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public void delete(String[] ids){
		xlglWarCommonWarbasisService.deleteBatch(ids);
		for (String string : ids) {
			//获取图片、视频、或封面
			Map<String, Object> fileMap = new HashMap<>();
			fileMap.put("id", string);
			List<XlglPicture> pictureList = xlglPictureService.queryList(fileMap);
			for (XlglPicture xlglPicture : pictureList) {
				//删除文件服务器上文件
				HTTPFile httpFile = new HTTPFile(xlglPicture.getPictureId());
				boolean delete = httpFile.delete();
				if(delete) {
					//删除文件表中记录
					xlglPictureService.delete(xlglPicture.getId());
				}
			}
		}
		Response.ok();
	}
	
}
