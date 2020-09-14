package com.css.app.xlgl.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;
import com.css.app.xlgl.dto.AccessoryFileDto;
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

import cn.com.css.filestore.impl.HTTPFile;

/**
 * 军事训练-共同训练-队列训练
 * 
 * @author 中软信息系统工程有限公司
 * @email
 * @date 2020-08-14 16:52:03
 */
@Controller
@RequestMapping("app/xlgl/xlglwarcommonqueue")
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
	public void list(Integer page, Integer limit, String title) {
		Map<String, Object> map = new HashMap<>();
		map.put("title", title);
		PageHelper.startPage(page, limit);
		// 查询列表数据
		List<XlglWarCommonQueue> xlglWarCommonQueueList = xlglWarCommonQueueService.queryList(map);
		PageUtils pageUtil = new PageUtils(xlglWarCommonQueueList);
		Map<String, Object> fileMap = new HashMap<>();
		Map<String, Object> hashMap = new HashMap<>();
		hashMap.put("readUserId", CurrentUser.getUserId());
		for (XlglWarCommonQueue xlglWarCommonQueue : xlglWarCommonQueueList) {
			hashMap.put("queueId", xlglWarCommonQueue.getId());
			List<XlglWarCommonQueueRead> readList = xlglWarCommonQueueReadService.queryList(hashMap);
			if (readList.size() > 0) {
				xlglWarCommonQueue.setReadStatus("1");
			} else {
				xlglWarCommonQueue.setReadStatus("0");
			}
			fileMap.put("id", xlglWarCommonQueue.getId());
			List<XlglPicture> queryList = xlglPictureService.queryList(fileMap);

			List<AccessoryFileDto> list = new LinkedList<AccessoryFileDto>();
			for (XlglPicture xlglPicture : queryList) { // 1:图片，2：视频，3：附件，4：封面
				if (xlglPicture.getPictureType().equals("2")) {
					xlglWarCommonQueue.setVideoFile(xlglPicture.getPictureId());
					xlglWarCommonQueue.setVideoFileName(xlglPicture.getPictureName());
				} else if (xlglPicture.getPictureType().equals("3")) {
					AccessoryFileDto accessoryFileDto = new AccessoryFileDto();
					accessoryFileDto.setFileId(xlglPicture.getPictureId());
					accessoryFileDto.setFileName(xlglPicture.getPictureName());
					list.add(accessoryFileDto);
				} else if (xlglPicture.getPictureType().equals("4")) {
					xlglWarCommonQueue.setCoverFile(xlglPicture.getPictureId());
					xlglWarCommonQueue.setCoverFileName(xlglPicture.getPictureName());
				}
			}
			xlglWarCommonQueue.setAccessoryFileArray(list);

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
		map.put("queueId", id);
		map.put("readUserId", ssoUser.getUserId());
		XlglWarCommonQueue xlglWarCommonQueue = xlglWarCommonQueueService.queryObject(id);
		// 获取图片、视频、或封面
		Map<String, Object> fileMap = new HashMap<>();
		fileMap.put("id", xlglWarCommonQueue.getId());

		List<XlglPicture> pictureList = xlglPictureService.queryList(fileMap);

		List<AccessoryFileDto> list = new LinkedList<AccessoryFileDto>();
		for (XlglPicture xlglPicture : pictureList) { // 1:图片，2：视频，3：附件，4：封面
			if (xlglPicture.getPictureType().equals("2")) {
				xlglWarCommonQueue.setVideoFile(xlglPicture.getPictureId());
				xlglWarCommonQueue.setVideoFileName(xlglPicture.getPictureName());
			} else if (xlglPicture.getPictureType().equals("3")) {
				AccessoryFileDto accessoryFileDto = new AccessoryFileDto();
				accessoryFileDto.setFileId(xlglPicture.getPictureId());
				accessoryFileDto.setFileName(xlglPicture.getPictureName());
				list.add(accessoryFileDto);
			} else if (xlglPicture.getPictureType().equals("4")) {
				xlglWarCommonQueue.setCoverFile(xlglPicture.getPictureId());
				xlglWarCommonQueue.setCoverFileName(xlglPicture.getPictureName());
			}
		}
		xlglWarCommonQueue.setAccessoryFileArray(list);

		// 修改浏览次数
		if (xlglWarCommonQueue.getViewNumber() != null) {

			xlglWarCommonQueue.setViewNumber(xlglWarCommonQueue.getViewNumber() + 1);
		} else {
			xlglWarCommonQueue.setViewNumber(1);
		}
		xlglWarCommonQueueService.update(xlglWarCommonQueue);

		Response.json("xlglWarCommonQueue", xlglWarCommonQueue);
	}

	/**
	 * 修改已学未学习状态
	 */
	@ResponseBody
	@RequestMapping("/updateRead")
	public void updateRead(String id) {
		SSOUser ssoUser = CurrentUser.getSSOUser();
		Map<String, Object> map = new HashMap<>();
		map.put("queueId", id);
		map.put("readUserId", ssoUser.getUserId());
		// 已读记录表
		List<XlglWarCommonQueueRead> queryList = xlglWarCommonQueueReadService.queryList(map);
		if (queryList.size() > 0) {
			XlglWarCommonQueueRead xlglWarCommonQueueRead = queryList.get(0);
			xlglWarCommonQueueRead.setReadDate(new Date());
			xlglWarCommonQueueReadService.update(xlglWarCommonQueueRead);
		} else {
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
	public void save(XlglWarCommonQueue xlglWarCommonQueue, String coverFile, String videoFile,
			String[] accessoryArray) {
		SSOUser ssoUser = CurrentUser.getSSOUser();
		Date date = new Date();
		String random = UUIDUtils.random();
		xlglWarCommonQueue.setId(random);
		xlglWarCommonQueue.setCreateOrganId(ssoUser.getOrganId());
		xlglWarCommonQueue.setCreateOrganName(ssoUser.getOrgName());
		xlglWarCommonQueue.setCreateDate(date);
		//String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		xlglWarCommonQueue.setUpdateDate(date);
		xlglWarCommonQueue.setUpdateUser(ssoUser.getUserId());
		xlglWarCommonQueue.setCreateUser(ssoUser.getUserId());
		xlglWarCommonQueue.setPublishDate(date);
		xlglWarCommonQueueService.save(xlglWarCommonQueue);
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
	public void update(XlglWarCommonQueue xlglWarCommonQueue) {
		xlglWarCommonQueue.setUpdateDate(new Date());
		xlglWarCommonQueue.setUpdateUser(CurrentUser.getUserId());
		xlglWarCommonQueueService.update(xlglWarCommonQueue);
		Map<String, Object> map = new HashMap<>();
		map.put("id", xlglWarCommonQueue.getId());
		List<XlglPicture> queryList = xlglPictureService.queryList(map);
		if (queryList.size() > 0) {
			for (XlglPicture xlglPicture : queryList) {
				xlglPictureService.delete(xlglPicture.getId());
			}
		}
		if (StringUtils.isNotBlank(xlglWarCommonQueue.getCoverFile())) {
			xlglPictureService.savePicture(xlglWarCommonQueue.getId(), xlglWarCommonQueue.getCoverFile(), "4");
		}
		if (StringUtils.isNotBlank(xlglWarCommonQueue.getVideoFile())) {
			xlglPictureService.savePicture(xlglWarCommonQueue.getId(), xlglWarCommonQueue.getVideoFile(), "2");
		}
		if (StringUtils.isNotBlank(xlglWarCommonQueue.getAccessoryFile())) {
			if (xlglWarCommonQueue.getAccessoryFile().contains(",")) {
				String[] split = xlglWarCommonQueue.getAccessoryFile().split(",");
				for (String string : split) {
					xlglPictureService.savePicture(xlglWarCommonQueue.getId(), string, "3");
				}
			} else {
				xlglPictureService.savePicture(xlglWarCommonQueue.getId(), xlglWarCommonQueue.getAccessoryFile(), "3");
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
		xlglWarCommonQueueService.deleteBatch(ids);
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
