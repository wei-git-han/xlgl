package com.css.app.xlgl.service;


import com.css.app.xlgl.entity.VideoPlayRecord;

import java.util.List;
import java.util.Map;

/**
 * 视频播放记录表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-09-22 15:00:50
 */
public interface VideoPlayRecordService {
	
	VideoPlayRecord queryObject(String id);
	
	List<VideoPlayRecord> queryList(Map<String, Object> map);
	
	void save(VideoPlayRecord videoPlayRecord);
	
	void update(VideoPlayRecord videoPlayRecord);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);

	VideoPlayRecord queryInfo(String fileId,String videoId,String userId);
}
