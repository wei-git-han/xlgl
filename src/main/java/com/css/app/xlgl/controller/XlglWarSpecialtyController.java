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
import com.css.app.xlgl.entity.XlglWarCommonQueueRead;
import com.css.app.xlgl.entity.XlglWarSpecialty;
import com.css.app.xlgl.entity.XlglWarSpecialtyRead;
import com.css.app.xlgl.service.XlglPictureService;
import com.css.app.xlgl.service.XlglWarSpecialtyReadService;
import com.css.app.xlgl.service.XlglWarSpecialtyService;


/**
 * 军事训练-专业训练
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-14 16:50:25
 */
@Controller
@RequestMapping("/xlglwarspecialty")
public class XlglWarSpecialtyController {
	@Autowired
	private XlglWarSpecialtyService xlglWarSpecialtyService;
	@Autowired
	private XlglPictureService xlglPictureService;
	@Autowired
	private XlglWarSpecialtyReadService xlglWarSpecialtyReadService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<XlglWarSpecialty> xlglWarSpecialtyList = xlglWarSpecialtyService.queryList(map);
		Map<String, Object> fileMap = new HashMap<>();
		Map<String, Object> hashMap = new HashMap<>();
		for (XlglWarSpecialty xlglWarSpecialty : xlglWarSpecialtyList) {
			hashMap.put("specialtyId", xlglWarSpecialty.getId());
			List<XlglWarSpecialtyRead> readList = xlglWarSpecialtyReadService.queryList(hashMap);
			if(readList.size() > 0) {
				xlglWarSpecialty.setReadStatus("1");
			}else {
				xlglWarSpecialty.setReadStatus("0");
			}
			fileMap.put("id", xlglWarSpecialty.getId());
			List<XlglPicture> queryList = xlglPictureService.queryList(map);
			List<String> list = new ArrayList<String>();
			for (XlglPicture xlglPicture : queryList) { //1:图片，2：视频，3：附件，4：封面
				if(xlglPicture.getPictureType().equals("2")) {
					xlglWarSpecialty.setVideoFile(xlglPicture.getPictureId());
				}else if(xlglPicture.getPictureType().equals("3")) {
					list.add(xlglPicture.getPictureId());
				}else if(xlglPicture.getPictureType().equals("4")) {
					xlglWarSpecialty.setCoverFile(xlglPicture.getPictureId());
				}
			}
			xlglWarSpecialty.setAccessoryFileArray(list);
		}
		PageUtils pageUtil = new PageUtils(xlglWarSpecialtyList);
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
		map.put("specialtyId", id);
		map.put("readUserId", ssoUser.getUserId());
		XlglWarSpecialty xlglWarSpecialty = xlglWarSpecialtyService.queryObject(id);
		xlglWarSpecialty.setViewNumber(xlglWarSpecialty.getViewNumber()+1);
		xlglWarSpecialtyService.update(xlglWarSpecialty);
		//已读记录表
		List<XlglWarSpecialtyRead> queryList = xlglWarSpecialtyReadService.queryList(map);
		if(queryList.size()>0) {
			XlglWarSpecialtyRead xlglWarSpecialtyRead = queryList.get(0);
			xlglWarSpecialtyRead.setReadDate(new Date());
			xlglWarSpecialtyReadService.update(xlglWarSpecialtyRead);
		}else {
			XlglWarSpecialtyRead xlglWarSpecialtyRead = new XlglWarSpecialtyRead();
			xlglWarSpecialtyRead.setId(UUIDUtils.random());
			xlglWarSpecialtyRead.setSpecialtyId(id);
			xlglWarSpecialtyRead.setReadOrgName(ssoUser.getOrgName());
			xlglWarSpecialtyRead.setReadOrgId(ssoUser.getOrganId());
			xlglWarSpecialtyRead.setReadUserId(ssoUser.getUserId());
			xlglWarSpecialtyRead.setReadUserName(ssoUser.getFullname());
			xlglWarSpecialtyRead.setReadDate(new Date());
			xlglWarSpecialtyReadService.save(xlglWarSpecialtyRead);
		}
		
		Response.json("xlglWarSpecialty", xlglWarSpecialty);
	}
	
	/**
	 * 保存
	 * @param coverFile 封面上传id
	 * @param videoFile 视频上传id
	 * @param accessoryFile 多个附件上传id 
	 */
	@ResponseBody
	@RequestMapping("/save")
	public void save(XlglWarSpecialty xlglWarSpecialty,String coverFile,String videoFile,String[] accessoryFile){
		SSOUser ssoUser = CurrentUser.getSSOUser();
		Date date = new Date();
		String random = UUIDUtils.random();
		xlglWarSpecialty.setId(random);
		xlglWarSpecialty.setCreateOrganId(ssoUser.getOrganId());
		xlglWarSpecialty.setCreateOrganName(ssoUser.getOrgName());
		xlglWarSpecialty.setCreateDate(date);
		xlglWarSpecialty.setCreateUser(ssoUser.getUserId());
		xlglWarSpecialty.setPublishDate(date);
		xlglWarSpecialtyService.save(xlglWarSpecialty);
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
	public void update(XlglWarSpecialty xlglWarSpecialty){
		xlglWarSpecialtyService.update(xlglWarSpecialty);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public void delete(String[] ids){
		xlglWarSpecialtyService.deleteBatch(ids);
		
		Response.ok();
	}
	
}
