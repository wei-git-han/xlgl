package com.css.app.xlgl.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.css.app.xlgl.entity.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
import com.css.app.xlgl.service.XlglPictureService;
import com.css.app.xlgl.service.XlglWarSpecialtyReadService;
import com.css.app.xlgl.service.XlglWarSpecialtyService;
import org.springframework.web.multipart.MultipartFile;

/**
 * 军事训练-专业训练
 * 
 * @author 中软信息系统工程有限公司
 * @email
 * @date 2020-08-14 16:50:25
 */
@Controller
@RequestMapping("app/xlgl/xlglwarspecialty")
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
	public void list(Integer page, Integer limit, String title) {
		Map<String, Object> map = new HashMap<>();
		map.put("title", title);
		PageHelper.startPage(page, limit);

		// 查询列表数据
		List<XlglWarSpecialty> xlglWarSpecialtyList = xlglWarSpecialtyService.queryList(map);
		PageUtils pageUtil = new PageUtils(xlglWarSpecialtyList);
		Map<String, Object> fileMap = new HashMap<>();
		Map<String, Object> hashMap = new HashMap<>();
		for (XlglWarSpecialty xlglWarSpecialty : xlglWarSpecialtyList) {
			hashMap.put("specialtyId", xlglWarSpecialty.getId());
			List<XlglWarSpecialtyRead> readList = xlglWarSpecialtyReadService.queryList(hashMap);
			if (readList.size() > 0) {
				xlglWarSpecialty.setReadStatus("1");
			} else {
				xlglWarSpecialty.setReadStatus("0");
			}
			fileMap.put("id", xlglWarSpecialty.getId());
			List<XlglPicture> queryList = xlglPictureService.queryList(fileMap);

			List<AccessoryFileDto> list = new LinkedList<AccessoryFileDto>();
			for (XlglPicture xlglPicture : queryList) { // 1:图片，2：视频，3：附件，4：封面
				if (xlglPicture.getPictureType().equals("2")) {
					xlglWarSpecialty.setVideoFile(xlglPicture.getPictureId());
					xlglWarSpecialty.setVideoFileName(xlglPicture.getPictureName());
				} else if (xlglPicture.getPictureType().equals("3")) {
					AccessoryFileDto accessoryFileDto = new AccessoryFileDto();
					accessoryFileDto.setFileId(xlglPicture.getPictureId());
					accessoryFileDto.setFileName(xlglPicture.getPictureName());
					list.add(accessoryFileDto);
				} else if (xlglPicture.getPictureType().equals("4")) {
					xlglWarSpecialty.setCoverFile(xlglPicture.getPictureId());
					xlglWarSpecialty.setCoverFileName(xlglPicture.getPictureName());
				}
			}
			xlglWarSpecialty.setAccessoryFileArray(list);
		}

		Response.json("page", pageUtil);
	}

	/**
	 * 信息
	 * type 0是详情 1是编辑
	 */
	@ResponseBody
	@RequestMapping("/info")
	public void info(String id,String type) {
		SSOUser ssoUser = CurrentUser.getSSOUser();
		Map<String, Object> map = new HashMap<>();
		map.put("specialtyId", id);
		map.put("readUserId", ssoUser.getUserId());
		XlglWarSpecialty xlglWarSpecialty = xlglWarSpecialtyService.queryObject(id);
		// 获取图片、视频、或封面
		Map<String, Object> fileMap = new HashMap<>();
		fileMap.put("id", xlglWarSpecialty.getId());

		List<XlglPicture> pictureList = xlglPictureService.queryList(fileMap);

		List<AccessoryFileDto> list = new LinkedList<AccessoryFileDto>();
		for (XlglPicture xlglPicture : pictureList) { // 1:图片，2：视频，3：附件，4：封面
			if (xlglPicture.getPictureType().equals("2")) {
				xlglWarSpecialty.setVideoFile(xlglPicture.getPictureId());
				xlglWarSpecialty.setVideoFileName(xlglPicture.getPictureName());
			} else if (xlglPicture.getPictureType().equals("3")) {
				AccessoryFileDto accessoryFileDto = new AccessoryFileDto();
				accessoryFileDto.setFileId(xlglPicture.getPictureId());
				accessoryFileDto.setFileName(xlglPicture.getPictureName());
				list.add(accessoryFileDto);
			} else if (xlglPicture.getPictureType().equals("4")) {
				xlglWarSpecialty.setCoverFile(xlglPicture.getPictureId());
				xlglWarSpecialty.setCoverFileName(xlglPicture.getPictureName());
			}
		}
		xlglWarSpecialty.setAccessoryFileArray(list);

		// 修改浏览次数,只能是详情模式才能
		if (xlglWarSpecialty.getViewNumber() != null && "0".equals(type)) {
			xlglWarSpecialty.setViewNumber(xlglWarSpecialty.getViewNumber() + 1);
		} else if(xlglWarSpecialty.getViewNumber() != null && "1".equals(type)){
			xlglWarSpecialty.setViewNumber(xlglWarSpecialty.getViewNumber());
		}else {
			xlglWarSpecialty.setViewNumber(1);
		}
		//xlglWarSpecialty.setViewNumber(1);
			xlglWarSpecialtyService.update(xlglWarSpecialty);

		Response.json("xlglWarSpecialty", xlglWarSpecialty);
	}

	/**
	 * 修改已学未学习状态
	 */
	@ResponseBody
	@RequestMapping("/updateRead")
	public void updateRead(String id) {
		SSOUser ssoUser = CurrentUser.getSSOUser();
		Map<String, Object> map = new HashMap<>();
		map.put("specialtyId", id);
		map.put("readUserId", ssoUser.getUserId());
		// 已读记录表
		List<XlglWarSpecialtyRead> queryList = xlglWarSpecialtyReadService.queryList(map);
		if (queryList.size() > 0) {
			XlglWarSpecialtyRead xlglWarSpecialtyRead = queryList.get(0);
			xlglWarSpecialtyRead.setReadDate(new Date());
			xlglWarSpecialtyReadService.update(xlglWarSpecialtyRead);
		} else {
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
		Response.ok();
	}

	/**
	 * 保存
	 * 
	 * @param coverFile
	 *            封面上传id
	 * @param videoFile
	 *            视频上传id
	 * @param accessoryFile
	 *            多个附件上传id
	 */
	@ResponseBody
	@RequestMapping("/save")
	public void save(XlglWarSpecialty xlglWarSpecialty, String coverFile, String videoFile, String[] accessoryArray) {
		SSOUser ssoUser = CurrentUser.getSSOUser();
		Date date = new Date();
		String random = UUIDUtils.random();
		xlglWarSpecialty.setId(random);
		xlglWarSpecialty.setCreateOrganId(ssoUser.getOrganId());
		xlglWarSpecialty.setCreateOrganName(ssoUser.getOrgName());
		xlglWarSpecialty.setCreateDate(date);
		xlglWarSpecialty.setUpdateDate(date);
		xlglWarSpecialty.setCreateUser(ssoUser.getUserId());
		xlglWarSpecialty.setPublishDate(date);
		xlglWarSpecialtyService.save(xlglWarSpecialty);
		if (StringUtils.isNotBlank(coverFile)) {
			xlglPictureService.savePicture(random, coverFile, "4");
		}
		if (StringUtils.isNotBlank(videoFile)) {
			xlglPictureService.savePicture(random, videoFile, "2");
		}
		if (accessoryArray != null) {
			for (String string : accessoryArray) {
				xlglPictureService.savePicture(random, string, "3");
			}
		}
		Response.ok();
	}

	/**
	 * 修改
	 * 
	 * @param deleAccessoryId
	 *            删除附件id
	 * @param accessoryFile
	 *            新增附件id
	 */
	@ResponseBody
	@RequestMapping("/update")
	public void update(XlglWarSpecialty xlglWarSpecialty) {
		xlglWarSpecialty.setUpdateUser(CurrentUser.getUserId());
		xlglWarSpecialty.setUpdateDate(new Date());
		xlglWarSpecialtyService.update(xlglWarSpecialty);

		Map<String, Object> map = new HashMap<>();
		map.put("id", xlglWarSpecialty.getId());
		List<XlglPicture> queryList = xlglPictureService.queryList(map);
		if (queryList.size() > 0) {
			for (XlglPicture xlglPicture : queryList) {
				xlglPictureService.delete(xlglPicture.getId());
			}
		}
		if (StringUtils.isNotBlank(xlglWarSpecialty.getCoverFile())) {
			xlglPictureService.savePicture(xlglWarSpecialty.getId(), xlglWarSpecialty.getCoverFile(), "4");
		}
		if (StringUtils.isNotBlank(xlglWarSpecialty.getVideoFile())) {
			xlglPictureService.savePicture(xlglWarSpecialty.getId(), xlglWarSpecialty.getVideoFile(), "2");
		}
		if (StringUtils.isNotBlank(xlglWarSpecialty.getAccessoryFile())) {
			if (xlglWarSpecialty.getAccessoryFile().contains(",")) {
				String[] split = xlglWarSpecialty.getAccessoryFile().split(",");
				for (String string : split) {
					xlglPictureService.savePicture(xlglWarSpecialty.getId(), string, "3");
				}
			} else {
				xlglPictureService.savePicture(xlglWarSpecialty.getId(), xlglWarSpecialty.getAccessoryFile(), "3");
			}
		}

		Response.ok();
	}

	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public void delete(String[] ids) {
		xlglWarSpecialtyService.deleteBatch(ids);
		for (String string : ids) {
			// 获取图片、视频、或封面
			Map<String, Object> fileMap = new HashMap<>();
			fileMap.put("id", string);
			List<XlglPicture> pictureList = xlglPictureService.queryList(fileMap);
			for (XlglPicture xlglPicture : pictureList) {
				// 删除文件服务器上文件
				HTTPFile httpFile = new HTTPFile(xlglPicture.getPictureId());
				boolean delete = httpFile.delete();
				if (delete) {
					// 删除文件表中记录
					xlglPictureService.delete(xlglPicture.getId());
				}
			}
		}
		Response.ok();
	}

	/**
	 * 上传预览文件
	 * @param pdf
	 */
	@ResponseBody
	@RequestMapping(value = "/insertPreView")
	public void insertPreView(@RequestParam(required = false) MultipartFile[] pdf){
		com.alibaba.fastjson.JSONObject jsonObject = new com.alibaba.fastjson.JSONObject();
		if(pdf.length >0) {
			com.alibaba.fastjson.JSONObject file = XlglWarTacticController.getFile(pdf);
			jsonObject = file;
			XlglWarSpecialty xlglWarSpecialty = new XlglWarSpecialty();
			xlglWarSpecialty.setId(UUIDUtils.random());
			xlglWarSpecialty.setCreateDate(new Date());
			xlglWarSpecialty.setPreViewName(file.get("fileName").toString());
			xlglWarSpecialty.setPreViewId(file.get("fileId").toString());
			xlglWarSpecialtyService.save(xlglWarSpecialty);
		}
		jsonObject.put("result","success");
		Response.json(jsonObject);
	}
}
