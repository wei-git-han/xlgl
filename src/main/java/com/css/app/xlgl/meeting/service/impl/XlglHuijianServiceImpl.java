package com.css.app.xlgl.meeting.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	@Autowired
	private XlglHuijianDao xlglHuijianDao;

	@Value("${csse.meeting.huijian.redirect}")
	private String redirectHuiJianUrl;

	@Value("${csse.meeting.huijian.url}")
	private String URL;
	@Value("${csse.meeting.huijian.url.create}")
	private String Create;
	@Value("${csse.meeting.huiyi.HuiYiappId}")
	private String appId;
	@Value("${csse.meeting.huiyi.url.login}")
	private String Login;
	private final Logger logger = LoggerFactory.getLogger(XlglHuijianServiceImpl.class);
	
	
	@Override
	public XlglHuijian queryObject(String id) {
		return xlglHuijianDao.queryObject(id);
	}

	@Override
	public List<XlglHuijian> queryList(Map<String, Object> map) {
		return xlglHuijianDao.queryList(map);
	}

	@Override
	public void save(XlglHuijian xlglHuijian) {
		xlglHuijianDao.save(xlglHuijian);
	}

	@Override
	public void update(XlglHuijian xlglHuijian) {
		xlglHuijianDao.update(xlglHuijian);
	}

	@Override
	public void delete(String id) {
		xlglHuijianDao.delete(id);
	}

	@Override
	public void deleteBatch(String[] ids) {
		xlglHuijianDao.deleteBatch(ids);
	}

	/**
	 * url 会见创建路径 appid 会见给的在配置文件中 token 获取当前用户的token
	 * 
	 */
	@Override
	public JSONObject createHuiYi(String url, String appId, String token, String startTime, String endTime,
			String confName) {
		LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
		map.add("appId", appId);
		map.add("secretKey", appId);
		map.add("starTime", startTime);
		map.add("endTime", endTime);
		if (StringUtils.isNotBlank(confName)) {
			map.add("confName", confName);
		}
		Map<String, String> loginToken = this.loginToken();
		if (loginToken != null) {
			String huijiantoken = loginToken.get("token");
			map.add("token", huijiantoken);
			logger.info("创建会见请求参数：appId=" + appId+";secretKey="+appId+";token="+huijiantoken);
		}
		JSONObject jsonData = XlglMeetingController.getJsonData(url, map);
		logger.info("创建会见请求路径：url=" + url);
		if (jsonData != null) {
			JSONObject jsonObject = jsonData.getJSONObject("data");
			Boolean boolean1 = jsonData.getBoolean("isSuccess");
			logger.info("创建会见返回值：" + jsonData);
			if (boolean1) {
				return jsonObject;
			} else {
				logger.info("会见返回失败：isSuccess="+boolean1);
				return null;
			}
		} else {
			logger.info("创建会议失败：会见返回值为null，方法名为：createHuiYi()");
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
	 */
	@Override
	public String getMsgRedirect(String huiJianId) {
		String url = huiJianId;

		return url;
	}

	@Override
	public XlglHuijian queryObjectByxlglId(String id) {
		// TODO Auto-generated method stub
		return xlglHuijianDao.queryObjectByxlglId(id);
	}

	@Override
	public Map<String, String> loginToken() {
		Map<String, String> hashmap = new HashMap<String, String>();
		LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
		map.add("appId", appId);
		map.add("secretKey", appId);
		map.add("certType", "1");
		map.add("signId", CurrentUser.getUserId());
		String url = URL + Login;
		System.out.println();
		JSONObject jsonData = XlglMeetingController.getJsonData(url, map);
		logger.info("登录会见请求参数：appId=" + appId + ",secretKey=" + appId + ",certType=1," + "signId="
				+ CurrentUser.getUserId());
		logger.info("登录会见请求路径：url=" + URL + Login);
		logger.info("登录会见返回信息：" + jsonData);
		if (jsonData != null) {
			Boolean boolean1 = jsonData.getBoolean("isSuccess");
			if (boolean1) {
				JSONObject jsonObject = jsonData.getJSONObject("data");
				String token = jsonObject.getString("token");
				hashmap.put("token", token);
				String suid = jsonObject.getString("suid");
				hashmap.put("suid", suid);
				String nickName = jsonObject.getString("nickname");
				hashmap.put("nickName", nickName);
			} else {
				logger.info("登录会议获取错误信息：" + jsonData.getString("errorCode"));
			}
		}else {
			logger.info("登录会见返回值为null,方法名称为：loginToken()");
		}
		return hashmap;
	}

}
