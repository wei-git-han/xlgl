package com.css.app.xlgl.meeting.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;

import com.alibaba.fastjson.JSONObject;
import com.css.app.xlgl.meeting.controller.XlglMeetingController;
import com.css.app.xlgl.meeting.dao.XlglHuijianDao;
import com.css.app.xlgl.meeting.entity.XlglHuijian;
import com.css.app.xlgl.meeting.service.XlglHuijianService;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.StringUtils;
import com.css.base.utils.UUIDUtils;



@Service("xlglHuijianService")
public class XlglHuijianServiceImpl implements XlglHuijianService {
	@Value("${csse.meeting.huijian.redirect}")
	private  String HuiYiApp ;
	@Autowired
	private XlglHuijianDao xlglHuijianDao;
	
	@Override
	public XlglHuijian queryObject(String id){
		return xlglHuijianDao.queryObject(id);
	}
	
	@Override
	public List<XlglHuijian> queryList(Map<String, Object> map){
		return xlglHuijianDao.queryList(map);
	}
	
	@Override
	public void save(XlglHuijian xlglHuijian){
		xlglHuijianDao.save(xlglHuijian);
	}
	
	@Override
	public void update(XlglHuijian xlglHuijian){
		xlglHuijianDao.update(xlglHuijian);
	}
	
	@Override
	public void delete(String id){
		xlglHuijianDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		xlglHuijianDao.deleteBatch(ids);
	}
	/**
	 * url 会见创建路径
	 * appid 会见给的在配置文件中
	 * token 获取当前用户的token
	 * 
	 * */
	@Override
	public JSONObject createHuiYi(String url, String appId, String token,
			String startTime, String endTime, String confName) {
		LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
		map.add("appId", appId);
		map.add("secretKey", appId);
		map.add("token", token);
		map.add("startTime", startTime);
		map.add("endTime", endTime);
		if (StringUtils.isNotBlank(confName)) {
			map.add("confName", confName);
		}
		JSONObject jsonData = XlglMeetingController.getJsonData(url, map);
		JSONObject jsonObject = jsonData.getJSONObject("data");
		Boolean boolean1 = jsonData.getBoolean("isSuccess");
		String confId = jsonObject.getString("confId");
		if (boolean1) {
			return jsonObject;
			}
		return null;
	}

	@Override
	public void saveXlglHuiJian(String xlglId, String huiJianId) {
		XlglHuijian xlglHuijian = new XlglHuijian();
		xlglHuijian.setId(UUIDUtils.random());
		xlglHuijian.setConfId(huiJianId);
		xlglHuijian.setCreateUser(CurrentUser.getUserId());
		xlglHuijian.setCreateDate(new Date());
		xlglHuijian.setXlglId(xlglId);
		xlglHuijian.setIsDelete("0");
		this.save(xlglHuijian);
		
	}
	/**
	 * 返回进入会见的链接
	 * */
	@Override
	public String getMsgRedirect(String huiJianId) {
		String url = HuiYiApp+"={"+huiJianId+"}";
		return url;
	}

	@Override
	public XlglHuijian queryObjectByxlglId(String id) {
		// TODO Auto-generated method stub
		return xlglHuijianDao.queryObjectByxlglId(id);
	}
	
}
