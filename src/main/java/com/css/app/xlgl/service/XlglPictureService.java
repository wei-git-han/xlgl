package com.css.app.xlgl.service;


import com.css.app.xlgl.entity.XlglPicture;

import java.util.List;
import java.util.Map;

/**
 * 训练管理存图片表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-10 15:13:49
 */
public interface XlglPictureService {
	
	XlglPicture queryObject(String id);
	
	List<XlglPicture> queryList(Map<String, Object> map);
	
	void save(XlglPicture xlglPicture);
	
	void update(XlglPicture xlglPicture);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
	int queryTotal(Map<String,Object> map);
	
	void savePicture(String fileId,String pictureId ,String pictureType);

	List<XlglPicture> queryAllInfoByInfoId(Map<String,Object> map);

	
	  int deleteByPictureId(Object id);


	XlglPicture queryVedio(String id);

	List<XlglPicture> queryTopOne();

	XlglPicture queryByInfo(Map<String,Object> map);

}
