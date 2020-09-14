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
@RequestMapping("app/xlgl/xlglwarcommonsports")
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
	public void list(Integer page, Integer limit, String title) {
		Map<String, Object> map = new HashMap<>();
		map.put("title", title);
		PageHelper.startPage(page, limit);
		// 查询列表数据
		List<XlglWarCommonSports> xlglWarCommonSportsList = xlglWarCommonSportsService.queryList(map);
		PageUtils pageUtil = new PageUtils(xlglWarCommonSportsList);
		Map<String, Object> fileMap = new HashMap<>();
		Map<String, Object> hashMap = new HashMap<>();
		hashMap.put("readUserId", CurrentUser.getUserId());
		for (XlglWarCommonSports xlglWarCommonSports : xlglWarCommonSportsList) {
			hashMap.put("sportsId", xlglWarCommonSports.getId());
			List<XlglWarCommonSportsRead> readList = xlglWarCommonSportsReadService.queryList(hashMap);
			if (readList.size() > 0) {
				xlglWarCommonSports.setReadStatus("1");
			} else {
				xlglWarCommonSports.setReadStatus("0");
			}
			fileMap.put("id", xlglWarCommonSports.getId());
			List<XlglPicture> queryList = xlglPictureService.queryList(fileMap);

			List<AccessoryFileDto> list = new LinkedList<AccessoryFileDto>();
			for (XlglPicture xlglPicture : queryList) { // 1:图片，2：视频，3：附件，4：封面
				if (xlglPicture.getPictureType().equals("2")) {
					xlglWarCommonSports.setVideoFile(xlglPicture.getPictureId());
					xlglWarCommonSports.setVideoFileName(xlglPicture.getPictureName());
				} else if (xlglPicture.getPictureType().equals("3")) {
					AccessoryFileDto accessoryFileDto = new AccessoryFileDto();
					accessoryFileDto.setFileId(xlglPicture.getPictureId());
					accessoryFileDto.setFileName(xlglPicture.getPictureName());
					list.add(accessoryFileDto);
				} else if (xlglPicture.getPictureType().equals("4")) {
					xlglWarCommonSports.setCoverFile(xlglPicture.getPictureId());
					xlglWarCommonSports.setCoverFileName(xlglPicture.getPictureName());
				}
			}
			xlglWarCommonSports.setAccessoryFileArray(list);

		}

		Response.json("page", pageUtil);
	}

	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info")
	public void info(String id) {
		SSOUser ssoUser = CurrentUser.getSSOUser();
		Map<String, Object> map = new HashMap<>();
		map.put("sportsId", id);
		map.put("readUserId", ssoUser.getUserId());
		XlglWarCommonSports xlglWarCommonSports = xlglWarCommonSportsService.queryObject(id);
		// 获取图片、视频、或封面
		Map<String, Object> fileMap = new HashMap<>();
		fileMap.put("id", xlglWarCommonSports.getId());

		List<XlglPicture> pictureList = xlglPictureService.queryList(fileMap);

		List<AccessoryFileDto> list = new LinkedList<AccessoryFileDto>();
		for (XlglPicture xlglPicture : pictureList) { // 1:图片，2：视频，3：附件，4：封面
			if (xlglPicture.getPictureType().equals("2")) {
				xlglWarCommonSports.setVideoFile(xlglPicture.getPictureId());
				xlglWarCommonSports.setVideoFileName(xlglPicture.getPictureName());
			} else if (xlglPicture.getPictureType().equals("3")) {
				AccessoryFileDto accessoryFileDto = new AccessoryFileDto();
				accessoryFileDto.setFileId(xlglPicture.getPictureId());
				accessoryFileDto.setFileName(xlglPicture.getPictureName());
				list.add(accessoryFileDto);
			} else if (xlglPicture.getPictureType().equals("4")) {
				xlglWarCommonSports.setCoverFile(xlglPicture.getPictureId());
				xlglWarCommonSports.setCoverFileName(xlglPicture.getPictureName());
			}
		}
		xlglWarCommonSports.setAccessoryFileArray(list);

		// 修改浏览次数
		if (xlglWarCommonSports.getViewNumber() != null) {
			xlglWarCommonSports.setViewNumber(xlglWarCommonSports.getViewNumber() + 1);
		} else {
			xlglWarCommonSports.setViewNumber(1);
		}
		xlglWarCommonSportsService.update(xlglWarCommonSports);

		Response.json("xlglWarCommonSports", xlglWarCommonSports);
	}

	/**
	 * 修改已学未学习状态
	 */
	@ResponseBody
	@RequestMapping("/updateRead")
	public void updateRead(String id) {
		SSOUser ssoUser = CurrentUser.getSSOUser();
		Map<String, Object> map = new HashMap<>();
		map.put("sportsId", id);
		map.put("readUserId", ssoUser.getUserId());
		// 记录已学习与未学习
		List<XlglWarCommonSportsRead> queryList = xlglWarCommonSportsReadService.queryList(map);
		if (queryList.size() > 0) {
			XlglWarCommonSportsRead xlglWarCommonSportsRead = queryList.get(0);
			xlglWarCommonSportsRead.setReadDate(new Date());
			xlglWarCommonSportsReadService.update(xlglWarCommonSportsRead);
		} else {
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
	public void save(XlglWarCommonSports xlglWarCommonSports, String coverFile, String videoFile,
			String[] accessoryArray) {
		SSOUser ssoUser = CurrentUser.getSSOUser();
		Date date = new Date();
		String random = UUIDUtils.random();
		xlglWarCommonSports.setId(random);
		xlglWarCommonSports.setCreateOrganId(ssoUser.getOrganId());
		xlglWarCommonSports.setCreateOrganName(ssoUser.getOrgName());
		xlglWarCommonSports.setCreateDate(date);
		xlglWarCommonSports.setUpdateDate(date);
		xlglWarCommonSports.setCreateUser(ssoUser.getUserId());
		xlglWarCommonSports.setPublishDate(date);
		xlglWarCommonSportsService.save(xlglWarCommonSports);
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
	 */
	@ResponseBody
	@RequestMapping("/update")
	public void update(XlglWarCommonSports xlglWarCommonSports) {
		xlglWarCommonSports.setUpdateUser(CurrentUser.getUserId());
		xlglWarCommonSports.setUpdateDate(new Date());
		xlglWarCommonSportsService.update(xlglWarCommonSports);
		Map<String, Object> map = new HashMap<>();
		map.put("id", xlglWarCommonSports.getId());
		List<XlglPicture> queryList = xlglPictureService.queryList(map);
		if (queryList.size() > 0) {
			for (XlglPicture xlglPicture : queryList) {
				xlglPictureService.delete(xlglPicture.getId());
			}
		}
		if (StringUtils.isNotBlank(xlglWarCommonSports.getCoverFile())) {
			xlglPictureService.savePicture(xlglWarCommonSports.getId(), xlglWarCommonSports.getCoverFile(), "4");
		}
		if (StringUtils.isNotBlank(xlglWarCommonSports.getVideoFile())) {
			xlglPictureService.savePicture(xlglWarCommonSports.getId(), xlglWarCommonSports.getVideoFile(), "2");
		}
		if (StringUtils.isNotBlank(xlglWarCommonSports.getAccessoryFile())) {
			if (xlglWarCommonSports.getAccessoryFile().contains(",")) {
				String[] split = xlglWarCommonSports.getAccessoryFile().split(",");
				for (String string : split) {
					xlglPictureService.savePicture(xlglWarCommonSports.getId(), string, "3");
				}
			} else {
				xlglPictureService.savePicture(xlglWarCommonSports.getId(), xlglWarCommonSports.getAccessoryFile(),
						"3");
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
		xlglWarCommonSportsService.deleteBatch(ids);
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

}
