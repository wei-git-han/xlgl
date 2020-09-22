package com.css.app.xlgl.dao;


import com.css.app.xlgl.entity.VideoPlayRecord;
import org.apache.ibatis.annotations.Mapper;

import com.css.base.dao.BaseDao;
import org.apache.ibatis.annotations.Select;

/**
 * 视频播放记录表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-09-22 15:00:50
 */
@Mapper
public interface VideoPlayRecordDao extends BaseDao<VideoPlayRecord> {

    @Select("select * from VIDEO_PLAY_RECORD where FILE_ID = #{0} and VIDEO_ID = #{1} and USER_ID = #{2}")
    VideoPlayRecord queryInfo(String fileId,String videoId,String userId);
}
