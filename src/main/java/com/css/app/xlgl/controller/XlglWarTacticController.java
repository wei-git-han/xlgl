package com.css.app.xlgl.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.css.app.xlgl.dto.AccessoryFileDto;
import com.css.app.xlgl.entity.XlglPicture;
import com.css.app.xlgl.entity.XlglWarTactic;
import com.css.app.xlgl.entity.XlglWarTacticRead;
import com.css.app.xlgl.service.XlglPictureService;
import com.css.app.xlgl.service.XlglWarTacticReadService;
import com.css.app.xlgl.service.XlglWarTacticService;
import com.css.base.entity.SSOUser;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.PageUtils;
import com.css.base.utils.Response;
import com.css.base.utils.StringUtils;
import com.css.base.utils.UUIDUtils;
import com.github.pagehelper.PageHelper;

import cn.com.css.filestore.impl.HTTPFile;


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
		List<XlglWarTactic> xlglWarTacticList = xlglWarTacticService.queryList(map);
		PageUtils pageUtil = new PageUtils(xlglWarTacticList);
		Map<String, Object> fileMap = new HashMap<>();
		Map<String, Object> hashMap = new HashMap<>();
		hashMap.put("readUserId", CurrentUser.getUserId());
		for (XlglWarTactic xlglWarTactic : xlglWarTacticList) {
			hashMap.put("tacticId", xlglWarTactic.getId());
			List<XlglWarTacticRead> readList = xlglWarTacticReadService.queryList(hashMap);
			if(readList.size() >0) {
				xlglWarTactic.setReadStatus("1");
			}else {
				xlglWarTactic.setReadStatus("0");
			}
			fileMap.put("id", xlglWarTactic.getId());
			List<XlglPicture> queryList = xlglPictureService.queryList(fileMap);
			
			List<AccessoryFileDto> list = new LinkedList<AccessoryFileDto>();
			for (XlglPicture xlglPicture : queryList) { //1:图片，2：视频，3：附件，4：封面
				if(xlglPicture.getPictureType().equals("2")) {
					xlglWarTactic.setVideoFile(xlglPicture.getPictureId());
					xlglWarTactic.setVideoFileName(xlglPicture.getPictureName());
				}else if(xlglPicture.getPictureType().equals("3")) {
					AccessoryFileDto accessoryFileDto = new AccessoryFileDto();
					accessoryFileDto.setFileId(xlglPicture.getPictureId());
					accessoryFileDto.setFileName(xlglPicture.getPictureName());
					list.add(accessoryFileDto);
				}else if(xlglPicture.getPictureType().equals("4")) {
					xlglWarTactic.setCoverFile(xlglPicture.getPictureId());
					xlglWarTactic.setCoverFileName(xlglPicture.getPictureName());
				}
			}
			xlglWarTactic.setAccessoryFileArray(list);

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
		map.put("tacticId", id);
		map.put("readUserId", ssoUser.getUserId());
		XlglWarTactic xlglWarTactic = xlglWarTacticService.queryObject(id);
		//获取图片、视频、或封面
		Map<String, Object> fileMap = new HashMap<>();
		fileMap.put("id", xlglWarTactic.getId());
		
		List<XlglPicture> pictureList = xlglPictureService.queryList(fileMap);
		
		List<AccessoryFileDto> list = new LinkedList<AccessoryFileDto>();
		for (XlglPicture xlglPicture : pictureList) { //1:图片，2：视频，3：附件，4：封面
			if(xlglPicture.getPictureType().equals("2")) {
				xlglWarTactic.setVideoFile(xlglPicture.getPictureId());
				xlglWarTactic.setVideoFileName(xlglPicture.getPictureName());
			}else if(xlglPicture.getPictureType().equals("3")) {
				AccessoryFileDto accessoryFileDto = new AccessoryFileDto();
				accessoryFileDto.setFileId(xlglPicture.getPictureId());
				accessoryFileDto.setFileName(xlglPicture.getPictureName());
				list.add(accessoryFileDto);
			}else if(xlglPicture.getPictureType().equals("4")) {
				xlglWarTactic.setCoverFile(xlglPicture.getPictureId());
				xlglWarTactic.setCoverFileName(xlglPicture.getPictureName());
			}
		}
		xlglWarTactic.setAccessoryFileArray(list);
		//修改浏览次数
		if(xlglWarTactic.getViewNumber() !=null) {
			xlglWarTactic.setViewNumber(xlglWarTactic.getViewNumber()+1);
		}else {
			xlglWarTactic.setViewNumber(1);
		}
		xlglWarTacticService.update(xlglWarTactic);
		//已读记录表
		List<XlglWarTacticRead> queryList = xlglWarTacticReadService.queryList(map);
		if(queryList.size()>0) {
			XlglWarTacticRead xlglWarTacticRead = queryList.get(0);
			xlglWarTacticRead.setReadDate(new Date());
			xlglWarTacticReadService.update(xlglWarTacticRead);
		}else {
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
		Response.json("xlglWarTactic", xlglWarTactic);
	}
	
	/**
	 * 保存
	 * @param coverFile 封面上传id
	 * @param videoFile 视频上传id
	 * @param accessoryFile 多个附件上传id 
	 */
	@ResponseBody
	@RequestMapping("/save")
	public void save(XlglWarTactic xlglWarTactic,String coverFile,String videoFile,String[] accessoryArray){
		SSOUser ssoUser = CurrentUser.getSSOUser();
		Date date = new Date();
		String random = UUIDUtils.random();
		xlglWarTactic.setId(random);
		xlglWarTactic.setCreateOrganId(ssoUser.getOrganId());
		xlglWarTactic.setCreateOrganName(ssoUser.getOrgName());
		xlglWarTactic.setCreateDate(date);
		xlglWarTactic.setCreateUser(ssoUser.getUserId());
		xlglWarTactic.setPublishDate(date);
		xlglWarTacticService.save(xlglWarTactic);
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
	 * @param deleAccessoryId 删除附件id
	 * @param accessoryFile 新增附件id
	 */
	@ResponseBody
	@RequestMapping("/update")
	public void update(XlglWarTactic xlglWarTactic,String[] deleAccessoryId,String[] accessoryFileId ){
		String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		xlglWarTactic.setUpdateUser(CurrentUser.getUserId());
		xlglWarTactic.setUpdateDate(format);
		xlglWarTacticService.update(xlglWarTactic);
		if(deleAccessoryId.length >0) {
			for (String string : deleAccessoryId) {
				xlglPictureService.deleteByPictureId(string);
			}
		}
		if(accessoryFileId.length>0) {
			for (String string : accessoryFileId) {
				xlglPictureService.savePicture(xlglWarTactic.getId(), string, "3");
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
		xlglWarTacticService.deleteBatch(ids);
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
