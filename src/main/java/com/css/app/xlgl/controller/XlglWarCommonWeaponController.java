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
import com.css.app.xlgl.entity.XlglWarCommonWeapon;
import com.css.app.xlgl.entity.XlglWarCommonWeaponRead;
import com.css.app.xlgl.service.XlglPictureService;
import com.css.app.xlgl.service.XlglWarCommonWeaponReadService;
import com.css.app.xlgl.service.XlglWarCommonWeaponService;


/**
 * 军事训练-共同训练-轻武器操作
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-19 10:14:38
 */
@Controller
@RequestMapping("/xlglwarcommonweapon")
public class XlglWarCommonWeaponController {
	@Autowired
	private XlglWarCommonWeaponService xlglWarCommonWeaponService;
	@Autowired
	private XlglPictureService xlglPictureService;
	@Autowired
	private XlglWarCommonWeaponReadService xlglWarCommonWeaponReadService;
	
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<XlglWarCommonWeapon> xlglWarCommonWeaponList = xlglWarCommonWeaponService.queryList(map);
		PageUtils pageUtil = new PageUtils(xlglWarCommonWeaponList);
		Map<String, Object> fileMap = new HashMap<>();
		Map<String, Object> hashMap = new HashMap<>();
		hashMap.put("readUserId", CurrentUser.getUserId());
		for (XlglWarCommonWeapon xlglWarCommonWeapon : xlglWarCommonWeaponList) {
			hashMap.put("weaponId", xlglWarCommonWeapon.getId());
			List<XlglWarCommonWeaponRead> readList = xlglWarCommonWeaponReadService.queryList(hashMap);
			if(readList.size() >0) {
				xlglWarCommonWeapon.setReadStatus("1");
			}else {
				xlglWarCommonWeapon.setReadStatus("0");
			}
			fileMap.put("id", xlglWarCommonWeapon.getId());
			List<XlglPicture> queryList = xlglPictureService.queryList(map);
			List<String> list = new ArrayList<String>();
			for (XlglPicture xlglPicture : queryList) { //1:图片，2：视频，3：附件，4：封面
				if(xlglPicture.getPictureType().equals("2")) {
					xlglWarCommonWeapon.setVideoFile(xlglPicture.getPictureId());
				}else if(xlglPicture.getPictureType().equals("3")) {
					list.add(xlglPicture.getPictureId());
				}else if(xlglPicture.getPictureType().equals("4")) {
					xlglWarCommonWeapon.setCoverFile(xlglPicture.getPictureId());
				}
			}
			xlglWarCommonWeapon.setAccessoryFileArray(list);
		}
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	public void info(String id){
		SSOUser ssoUser = CurrentUser.getSSOUser();
		Map<String, Object> map = new HashMap<>();
		map.put("queueId", id);
		map.put("readUserId", ssoUser.getUserId());
		XlglWarCommonWeapon xlglWarCommonWeapon = xlglWarCommonWeaponService.queryObject(id);
		if(xlglWarCommonWeapon.getViewNumber() !=null) {
			xlglWarCommonWeapon.setViewNumber(xlglWarCommonWeapon.getViewNumber()+1);
		}else {
			xlglWarCommonWeapon.setViewNumber(1);
		}
		xlglWarCommonWeaponService.update(xlglWarCommonWeapon);
		//已读记录表
		List<XlglWarCommonWeaponRead> queryList = xlglWarCommonWeaponReadService.queryList(map);
		if(queryList.size()>0) {
			XlglWarCommonWeaponRead xlglWarCommonWeaponRead = queryList.get(0);
			xlglWarCommonWeaponRead.setReadDate(new Date());
			xlglWarCommonWeaponReadService.update(xlglWarCommonWeaponRead);
		}else {
			XlglWarCommonWeaponRead xlglWarCommonWeaponRead = new XlglWarCommonWeaponRead();
			xlglWarCommonWeaponRead.setId(UUIDUtils.random());
			xlglWarCommonWeaponRead.setWeaponId(id);
			xlglWarCommonWeaponRead.setReadOrgName(ssoUser.getOrgName());
			xlglWarCommonWeaponRead.setReadOrgId(ssoUser.getOrganId());
			xlglWarCommonWeaponRead.setReadUserId(ssoUser.getUserId());
			xlglWarCommonWeaponRead.setReadUserName(ssoUser.getFullname());
			xlglWarCommonWeaponRead.setReadDate(new Date());
			xlglWarCommonWeaponReadService.save(xlglWarCommonWeaponRead);
		}
		
		Response.json("xlglWarCommonWeapon", xlglWarCommonWeapon);
	}
	
	/**
	 * 保存
	 * @param coverFile 封面上传id
	 * @param videoFile 视频上传id
	 * @param accessoryFile 多个附件上传id 
	 */
	@ResponseBody
	@RequestMapping("/save")
	public void save(XlglWarCommonWeapon xlglWarCommonWeapon,String coverFile,String videoFile,String[] accessoryFile){
		SSOUser ssoUser = CurrentUser.getSSOUser();
		Date date = new Date();
		String random = UUIDUtils.random();
		xlglWarCommonWeapon.setId(random);
		xlglWarCommonWeapon.setCreateOrganId(ssoUser.getOrganId());
		xlglWarCommonWeapon.setCreateOrganName(ssoUser.getOrgName());
		xlglWarCommonWeapon.setCreateDate(date);
		xlglWarCommonWeapon.setCreateUser(ssoUser.getUserId());
		xlglWarCommonWeapon.setPublishDate(date);
		xlglWarCommonWeaponService.save(xlglWarCommonWeapon);
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
	public void update(XlglWarCommonWeapon xlglWarCommonWeapon){
		xlglWarCommonWeaponService.update(xlglWarCommonWeapon);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public void delete(String[] ids){
		xlglWarCommonWeaponService.deleteBatch(ids);
		
		Response.ok();
	}
	
}
