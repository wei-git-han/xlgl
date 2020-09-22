package com.css.app.xlgl.service.impl;

import com.css.app.xlgl.dao.VideoPlayRecordDao;
import com.css.app.xlgl.entity.VideoPlayRecord;
import com.css.app.xlgl.service.VideoPlayRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("videoPlayRecordService")
public class VideoPlayRecordServiceImpl implements VideoPlayRecordService {
	@Autowired
	private VideoPlayRecordDao videoPlayRecordDao;
	
	@Override
	public VideoPlayRecord queryObject(String id){
		return videoPlayRecordDao.queryObject(id);
	}
	
	@Override
	public List<VideoPlayRecord> queryList(Map<String, Object> map){
		return videoPlayRecordDao.queryList(map);
	}
	
	@Override
	public void save(VideoPlayRecord videoPlayRecord){
		videoPlayRecordDao.save(videoPlayRecord);
	}
	
	@Override
	public void update(VideoPlayRecord videoPlayRecord){
		videoPlayRecordDao.update(videoPlayRecord);
	}
	
	@Override
	public void delete(String id){
		videoPlayRecordDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		videoPlayRecordDao.deleteBatch(ids);
	}

	@Override
	public VideoPlayRecord queryInfo(String fileId,String videoId,String userId){
		return videoPlayRecordDao.queryInfo(fileId,videoId,userId);
	}
	
}
