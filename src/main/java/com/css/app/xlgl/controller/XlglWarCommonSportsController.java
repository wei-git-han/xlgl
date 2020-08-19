package com.css.app.xlgl.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
import com.css.base.utils.Response;
import com.css.base.utils.StringUtils;
import com.css.app.xlgl.entity.XlglPicture;
import com.css.app.xlgl.entity.XlglWarCommonQueue;
import com.css.app.xlgl.entity.XlglWarCommonQueueRead;
import com.css.app.xlgl.entity.XlglWarCommonSports;
import com.css.app.xlgl.entity.XlglWarCommonSportsRead;
import com.css.app.xlgl.service.XlglPictureService;
import com.css.app.xlgl.service.XlglWarCommonSportsReadService;
import com.css.app.xlgl.service.XlglWarCommonSportsService;


/**
 * 军事训练-共同训练-军事体育
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-17 09:53:19
 */
@Controller
@RequestMapping("/xlglwarcommonsports")
public class XlglWarCommonSportsController {
	@Autowired
	private XlglWarCommonSportsService xlglWarCommonSportsService;
	@Autowired
	private XlglPictureService xlglPictureService;
	@Autowired
	private XlglWarCommonSportsReadService xlglWarCommonSportsReadService;
	
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		//查询列表数据
		List<XlglWarCommonSports> xlglWarCommonSportsList = xlglWarCommonSportsService.queryList(map);
		PageUtils pageUtil = new PageUtils(xlglWarCommonSportsList);
		Map<String, Object> fileMap = new HashMap<>();
		Map<String, Object> hashMap = new HashMap<>();
		hashMap.put("readUserId", CurrentUser.getUserId());
		for (XlglWarCommonSports xlglWarCommonSports : xlglWarCommonSportsList) {
			hashMap.put("sportsId", xlglWarCommonSports.getId());
			List<XlglWarCommonSportsRead> readList = xlglWarCommonSportsReadService.queryList(hashMap);
			if(readList.size() >0) {
				xlglWarCommonSports.setReadStatus("1");
			}else {
				xlglWarCommonSports.setReadStatus("0");
			}
			fileMap.put("id", xlglWarCommonSports.getId());
			List<XlglPicture> queryList = xlglPictureService.queryList(map);
			List<String> list = new ArrayList<String>();
			for (XlglPicture xlglPicture : queryList) { //1:图片，2：视频，3：附件，4：封面
				if(xlglPicture.getPictureType().equals("2")) {
					xlglWarCommonSports.setVideoFile(xlglPicture.getPictureId());
				}else if(xlglPicture.getPictureType().equals("3")) {
					list.add(xlglPicture.getPictureId());
				}else if(xlglPicture.getPictureType().equals("4")) {
					xlglWarCommonSports.setCoverFile(xlglPicture.getPictureId());
				}
			}
			xlglWarCommonSports.setAccessoryFileArray(list);
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
		map.put("sportsId", id);
		map.put("readUserId", ssoUser.getUserId());
		XlglWarCommonSports xlglWarCommonSports = xlglWarCommonSportsService.queryObject(id);
		xlglWarCommonSports.setViewNumber(xlglWarCommonSports.getViewNumber()+1);
		xlglWarCommonSportsService.update(xlglWarCommonSports);
		//已读记录表
		List<XlglWarCommonSportsRead> queryList = xlglWarCommonSportsReadService.queryList(map);
		if(queryList.size()>0) {
			XlglWarCommonSportsRead xlglWarCommonSportsRead = queryList.get(0);
			xlglWarCommonSportsRead.setReadDate(new Date());
			xlglWarCommonSportsReadService.update(xlglWarCommonSportsRead);
		}else {
			XlglWarCommonSportsRead xlglWarCommonSportsRead = new XlglWarCommonSportsRead();
			xlglWarCommonSportsRead.setId(UUIDUtils.random());
			xlglWarCommonSportsRead.setSportsId(id);
			xlglWarCommonSportsRead.setReadOrgName(ssoUser.getOrgName());
			xlglWarCommonSportsRead.setReadOrgId(ssoUser.getOrganId());
			xlglWarCommonSportsRead.setReadUserId(ssoUser.getUserId());
			xlglWarCommonSportsRead.setReadUserName(ssoUser.getFullname());
			xlglWarCommonSportsRead.setReadDate(new Date());
			xlglWarCommonSportsReadService.save(xlglWarCommonSportsRead);
		}
		
		Response.json("xlglWarCommonSports", xlglWarCommonSports);
	}
	
	/**
	 * 保存
	 * @param coverFile 封面上传id
	 * @param videoFile 视频上传id
	 * @param accessoryFile 多个附件上传id 
	 */
	@ResponseBody
	@RequestMapping("/save")
	public void save(XlglWarCommonSports xlglWarCommonSports,String coverFile,String videoFile,String[] accessoryFile){
		SSOUser ssoUser = CurrentUser.getSSOUser();
		Date date = new Date();
		String random = UUIDUtils.random();
		xlglWarCommonSports.setId(random);
		xlglWarCommonSports.setCreateOrganId(ssoUser.getOrganId());
		xlglWarCommonSports.setCreateOrganName(ssoUser.getOrgName());
		xlglWarCommonSports.setCreateDate(date);
		xlglWarCommonSports.setCreateUser(ssoUser.getUserId());
		xlglWarCommonSports.setPublishDate(date);
		xlglWarCommonSportsService.save(xlglWarCommonSports);
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
	public void update(XlglWarCommonSports xlglWarCommonSports){
		xlglWarCommonSportsService.update(xlglWarCommonSports);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public void delete(String[] ids){
		xlglWarCommonSportsService.deleteBatch(ids);
		
		Response.ok();
	}
	
}
