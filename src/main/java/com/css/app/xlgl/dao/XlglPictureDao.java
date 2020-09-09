package com.css.app.xlgl.dao;


import com.css.app.xlgl.entity.XlglPicture;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import com.css.base.dao.BaseDao;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * 训练管理存图片表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-10 15:13:49
 */
@Mapper
public interface XlglPictureDao extends BaseDao<XlglPicture> {

    List<XlglPicture> queryAllInfoByInfoId(Map<String,Object> map);
    
    int deleteByPictureId(Object id);

    @Select("select * from XLGL_PICTURE where PICTURE_ID = #{0}")
    XlglPicture queryVedio(String id);

    @Select("select top 1 * from XLGL_PICTURE where PICTURE_TYPE = '0' order by CREATE_TIME desc")
    List<XlglPicture> queryTopOne();

    XlglPicture queryByInfo(Map<String,Object> map);

    @Delete("delete from XLGL_PICTURE where FILE_ID = #{0}")
    void deleteByInfoId(String infoId);

    List<XlglPicture> queryAllVedioByInfoId(Map<String,Object> map);

    @Delete("delete from XLGL_PICTURE where FILE_ID = #{0} and PICTURE_ID = #{1}")
    void deleteVedioOrFileOrPicture(String infoId,String id);

}
