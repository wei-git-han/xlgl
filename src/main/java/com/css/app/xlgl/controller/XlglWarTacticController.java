package com.css.app.xlgl.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.css.addbase.AppConfig;
import com.css.addbase.FileBaseUtil;
import com.css.addbase.suwell.OfdTransferUtil;
import com.css.app.xlgl.entity.*;
import com.css.app.xlgl.service.*;
import net.sf.json.JSONObject;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.css.app.xlgl.dto.AccessoryFileDto;
import com.css.base.entity.SSOUser;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.PageUtils;
import com.css.base.utils.Response;
import com.css.base.utils.StringUtils;
import com.css.base.utils.UUIDUtils;
import com.github.pagehelper.PageHelper;

import cn.com.css.filestore.impl.HTTPFile;
import org.springframework.web.multipart.MultipartFile;

/**
 * 军事训练-战略训练
 * 
 * @author 中软信息系统工程有限公司
 * @email
 * @date 2020-08-14 16:50:25
 */
@Controller
@RequestMapping("app/xlgl/xlglwartactic")
public class XlglWarTacticController {
	@Autowired
	private XlglWarTacticService xlglWarTacticService;
	@Autowired
	private XlglPictureService xlglPictureService;
	@Autowired
	private XlglWarTacticReadService xlglWarTacticReadService;
	@Autowired
	private XlglWarSpecialtyService xlglWarSpecialtyService;
	@Autowired
	private XlglWarCommonQueueService xlglWarCommonQueueService;
	@Autowired
	private XlglExamExamineService xlglExamExamineService;
	@Autowired
	private XlglXlzzInfoService xlglXlzzInfoService;
	@Autowired
	private static AppConfig appConfig;

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
		List<XlglWarTactic> xlglWarTacticList = xlglWarTacticService.queryList(map);
		PageUtils pageUtil = new PageUtils(xlglWarTacticList);
		Map<String, Object> fileMap = new HashMap<>();
		Map<String, Object> hashMap = new HashMap<>();
		hashMap.put("readUserId", CurrentUser.getUserId());
		for (XlglWarTactic xlglWarTactic : xlglWarTacticList) {
			hashMap.put("tacticId", xlglWarTactic.getId());
			List<XlglWarTacticRead> readList = xlglWarTacticReadService.queryList(hashMap);
			if (readList.size() > 0) {
				xlglWarTactic.setReadStatus("1");
			} else {
				xlglWarTactic.setReadStatus("0");
			}
			fileMap.put("id", xlglWarTactic.getId());
			List<XlglPicture> queryList = xlglPictureService.queryList(fileMap);

			List<AccessoryFileDto> list = new LinkedList<AccessoryFileDto>();
			for (XlglPicture xlglPicture : queryList) { // 1:图片，2：视频，3：附件，4：封面
				if (xlglPicture.getPictureType().equals("2")) {
					xlglWarTactic.setVideoFile(xlglPicture.getPictureId());
					xlglWarTactic.setVideoFileName(xlglPicture.getPictureName());
				} else if (xlglPicture.getPictureType().equals("3")) {
					AccessoryFileDto accessoryFileDto = new AccessoryFileDto();
					accessoryFileDto.setFileId(xlglPicture.getPictureId());
					accessoryFileDto.setFileName(xlglPicture.getPictureName());
					list.add(accessoryFileDto);
				} else if (xlglPicture.getPictureType().equals("4")) {
					xlglWarTactic.setCoverFile(xlglPicture.getPictureId());
					xlglWarTactic.setCoverFileName(xlglPicture.getPictureName());
				}
			}
			xlglWarTactic.setAccessoryFileArray(list);

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
		map.put("tacticId", id);
		map.put("readUserId", ssoUser.getUserId());
		XlglWarTactic xlglWarTactic = xlglWarTacticService.queryObject(id);
		// 获取图片、视频、或封面
		Map<String, Object> fileMap = new HashMap<>();
		fileMap.put("id", xlglWarTactic.getId());

		List<XlglPicture> pictureList = xlglPictureService.queryList(fileMap);

		List<AccessoryFileDto> list = new LinkedList<AccessoryFileDto>();
		for (XlglPicture xlglPicture : pictureList) { // 1:图片，2：视频，3：附件，4：封面
			if (xlglPicture.getPictureType().equals("2")) {
				xlglWarTactic.setVideoFile(xlglPicture.getPictureId());
				xlglWarTactic.setVideoFileName(xlglPicture.getPictureName());
			} else if (xlglPicture.getPictureType().equals("3")) {
				AccessoryFileDto accessoryFileDto = new AccessoryFileDto();
				accessoryFileDto.setFileId(xlglPicture.getPictureId());
				accessoryFileDto.setFileName(xlglPicture.getPictureName());
				list.add(accessoryFileDto);
			} else if (xlglPicture.getPictureType().equals("4")) {
				xlglWarTactic.setCoverFile(xlglPicture.getPictureId());
				xlglWarTactic.setCoverFileName(xlglPicture.getPictureName());
			}
		}
		xlglWarTactic.setAccessoryFileArray(list);
		// 修改浏览次数,只能是详情才会浏览量加1
		if (xlglWarTactic.getViewNumber() != null && "0".equals(type)) {
			xlglWarTactic.setViewNumber(xlglWarTactic.getViewNumber() + 1);
		}else if (xlglWarTactic.getViewNumber() != null && "1".equals(type)) {
			xlglWarTactic.setViewNumber(xlglWarTactic.getViewNumber());
		} else {
			xlglWarTactic.setViewNumber(1);
		}
		xlglWarTacticService.update(xlglWarTactic);
		Response.json("xlglWarTactic", xlglWarTactic);
	}

	/**
	 * 修改已学未学习状态
	 */
	@ResponseBody
	@RequestMapping("/updateRead")
	public void updateRead(String id) {
		SSOUser ssoUser = CurrentUser.getSSOUser();
		Map<String, Object> map = new HashMap<>();
		map.put("tacticId", id);
		map.put("readUserId", ssoUser.getUserId());
		// 已读记录表
		List<XlglWarTacticRead> queryList = xlglWarTacticReadService.queryList(map);
		if (queryList.size() > 0) {
			XlglWarTacticRead xlglWarTacticRead = queryList.get(0);
			xlglWarTacticRead.setReadDate(new Date());
			xlglWarTacticReadService.update(xlglWarTacticRead);
		} else {
			XlglWarTacticRead xlglWarTacticRead = new XlglWarTacticRead();
			xlglWarTacticRead.setId(UUIDUtils.random());
			xlglWarTacticRead.setTacticId(id);
			xlglWarTacticRead.setReadOrgName(ssoUser.getOrgName());
			xlglWarTacticRead.setReadOrgId(ssoUser.getOrganId());
			xlglWarTacticRead.setReadUserId(ssoUser.getUserId());
			xlglWarTacticRead.setReadUserName(ssoUser.getFullname());
			xlglWarTacticRead.setReadDate(new Date());
			xlglWarTacticReadService.save(xlglWarTacticRead);
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
	 * @param accessoryArray
	 *            多个附件上传id
	 */
	@ResponseBody
	@RequestMapping("/save")
	public void save(XlglWarTactic xlglWarTactic, String coverFile, String videoFile, String[] accessoryArray) {
		SSOUser ssoUser = CurrentUser.getSSOUser();
		Date date = new Date();
		String random = UUIDUtils.random();
		xlglWarTactic.setId(random);
		xlglWarTactic.setCreateOrganId(ssoUser.getOrganId());
		xlglWarTactic.setCreateOrganName(ssoUser.getOrgName());
		xlglWarTactic.setCreateDate(date);
		xlglWarTactic.setUpdateDate(date);
		xlglWarTactic.setCreateUser(ssoUser.getUserId());
		xlglWarTactic.setPublishDate(date);
		xlglWarTacticService.save(xlglWarTactic);
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
	public void update(XlglWarTactic xlglWarTactic) {
		xlglWarTactic.setUpdateUser(CurrentUser.getUserId());
		xlglWarTactic.setUpdateDate(new Date());
		xlglWarTacticService.update(xlglWarTactic);
		Map<String, Object> map = new HashMap<>();
		map.put("id", xlglWarTactic.getId());
		List<XlglPicture> queryList = xlglPictureService.queryList(map);
		if (queryList.size() > 0) {
			for (XlglPicture xlglPicture : queryList) {
				xlglPictureService.delete(xlglPicture.getId());
			}
		}
		if (StringUtils.isNotBlank(xlglWarTactic.getCoverFile())) {
			xlglPictureService.savePicture(xlglWarTactic.getId(), xlglWarTactic.getCoverFile(), "4");
		}
		if (StringUtils.isNotBlank(xlglWarTactic.getVideoFile())) {
			xlglPictureService.savePicture(xlglWarTactic.getId(), xlglWarTactic.getVideoFile(), "2");
		}
		if (StringUtils.isNotBlank(xlglWarTactic.getAccessoryFile())) {
			if (xlglWarTactic.getAccessoryFile().contains(",")) {
				String[] split = xlglWarTactic.getAccessoryFile().split(",");
				for (String string : split) {
					xlglPictureService.savePicture(xlglWarTactic.getId(), string, "3");
				}
			} else {
				xlglPictureService.savePicture(xlglWarTactic.getId(), xlglWarTactic.getAccessoryFile(), "3");
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
		xlglWarTacticService.deleteBatch(ids);
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
	 * 为首页提供最近一条数据名称 战略训练，训练考核，专业训练，共同训练
	 */
	@ResponseBody
	@RequestMapping("/getIndexName")
	public void getIndexName() {
		Map<String, Object> map = new HashMap<>();
		JSONObject jsonObject = new JSONObject();
		// 战略训练
		List<XlglWarTactic> warTacticList = xlglWarTacticService.queryList(null);
		if (warTacticList.size() > 0) {
			XlglWarTactic xlglWarTactic = warTacticList.get(0);
			jsonObject.put("XlglWarTactic", xlglWarTactic.getTacticTitle());
		}
		map.put("status", "0");
		map.put("issueStatus", "1");
		// 训练考核
		List<XlglExamExamine> examineList = xlglExamExamineService.queryList(map);
		if (examineList.size() > 0) {
			XlglExamExamine xlglExamExamine = examineList.get(0);
			jsonObject.put("xlglExamExamine", xlglExamExamine.getExamineName());
		}
		// 专业训练
		List<XlglWarSpecialty> warSpecialtyList = xlglWarSpecialtyService.queryList(null);
		if (warSpecialtyList.size() > 0) {
			XlglWarSpecialty xlglWarSpecialty = warSpecialtyList.get(0);
			jsonObject.put("xlglWarSpecialty", xlglWarSpecialty.getTacticTitle());
		}
		// 共同训练
		List<XlglWarCommonQueue> queryList = xlglWarCommonQueueService.queryList(null);
		if (queryList.size() > 0) {
			XlglWarCommonQueue xlglWarCommonQueue = queryList.get(0);
			jsonObject.put("xlglWarCommonQueue", xlglWarCommonQueue.getTacticTitle());
		}
		// 训练组织
		List<XlglXlzzInfo> xlglXlzzInfoList = xlglXlzzInfoService.queryTopOne();
		if (xlglXlzzInfoList != null && xlglXlzzInfoList.size() > 0) {
			XlglXlzzInfo xlglXlzzInfo = xlglXlzzInfoList.get(0);
			jsonObject.put("xlzz", xlglXlzzInfo.getTitle());
		}
		// 强装兴装大讲堂
		List<XlglPicture> xlglPictureList = xlglPictureService.queryTopOne();
		if (xlglPictureList != null && xlglPictureList.size() > 0) {
			XlglPicture xlglPicture = xlglPictureList.get(0);
			jsonObject.put("djt", xlglPicture.getPictureName());
		}

		// 训练档案
		Response.json(jsonObject);
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
			com.alibaba.fastjson.JSONObject file = this.getFile(pdf);
			jsonObject = file;
			XlglWarTactic xlglWarTactic = new XlglWarTactic();
			xlglWarTactic.setId(UUIDUtils.random());
			xlglWarTactic.setCreateDate(new Date());
			xlglWarTactic.setPreViewName(file.get("fileName").toString());
			xlglWarTactic.setPreViewId(file.get("fileId").toString());
			xlglWarTacticService.save(xlglWarTactic);
		}
		jsonObject.put("result","success");
		Response.json(jsonObject);
	}

	/**
	 * 战略训练-专业训练通用
	 * 上传预览文件
	 * @param pdf
	 * return
	 */
	public static com.alibaba.fastjson.JSONObject getFile(@RequestParam(required = false) MultipartFile[] pdf) {
		String formatDownPath = "";// 版式文件下载路径
		String retFormatId = null;// 返回的版式文件id
		String streamId = null;// 流式文件id
		String formatId = null;// 版式文件id
		com.alibaba.fastjson.JSONObject json = new com.alibaba.fastjson.JSONObject();
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
				}
				json.put("fileName",fileName);
			}
			json.put("smjId", retFormatId);
			json.put("smjFilePath", formatDownPath);
			json.put("fileId",retFormatId);
		}
		return json;
	}
}
