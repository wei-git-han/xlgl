package com.css.app.xlgl.meeting.service;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.css.app.xlgl.meeting.entity.XlglHuijian;

/**
 * 保存会见返回的会议号id
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-09-14 14:41:44
 */
public interface XlglHuijianService {
	
	XlglHuijian queryObject(String id);
	
	List<XlglHuijian> queryList(Map<String, Object> map);
	
	void save(XlglHuijian xlglHuijian);
	
	void update(XlglHuijian xlglHuijian);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
	JSONObject createHuiYi(String url,String appId,String token,String startTime, String endTime, String confName);
	void saveXlglHuiJian(String xlglId,String huiJianId);
	
	String getMsgRedirect(String huiJianId);
	
	XlglHuijian queryObjectByxlglId(String id);
	
	Map<String, String> loginToken() ;
}
