package com.css.app.xlgl.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.css.app.xlgl.entity.VideoPlayRecord;
import com.css.app.xlgl.service.VideoPlayRecordService;
import com.css.base.utils.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

import com.github.pagehelper.PageHelper;


/**
 * 视频播放记录表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-09-22 15:00:50
 */
@Controller
@RequestMapping("/app/xlgl/videoplayrecord")
public class VideoPlayRecordController {
	@Autowired
	private VideoPlayRecordService videoPlayRecordService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("videoplayrecord:list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<VideoPlayRecord> videoPlayRecordList = videoPlayRecordService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(videoPlayRecordList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info")
	public void info(String fileId,String videoId){
		String userId = CurrentUser.getUserId();
		VideoPlayRecord videoPlayRecord = videoPlayRecordService.queryInfo(fileId,videoId,userId);
		Response.json("videoPlayRecord", videoPlayRecord);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/saveOrUpdate")
	public void saveOrUpdate(VideoPlayRecord videoPlayRecord) {
		if (StringUtils.isNotBlank(videoPlayRecord.getId())) {
			videoPlayRecordService.update(videoPlayRecord);
		} else {
			String id = UUIDUtils.random();
			videoPlayRecord.setId(id);
			videoPlayRecord.setUserId(CurrentUser.getUserId());
			videoPlayRecord.setCreateTime(new Date());
			videoPlayRecordService.save(videoPlayRecord);
		}
		Response.json("result", "success");

	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("videoplayrecord:update")
	public void update(@RequestBody VideoPlayRecord videoPlayRecord){
		videoPlayRecordService.update(videoPlayRecord);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("videoplayrecord:delete")
	public void delete(@RequestBody String[] ids){
		videoPlayRecordService.deleteBatch(ids);
		
		Response.ok();
	}
	
}
