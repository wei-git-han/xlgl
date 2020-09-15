package com.css.app.xlgl.meeting.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.css.app.xlgl.meeting.entity.XlglHuijian;
import com.css.app.xlgl.meeting.service.XlglHuijianService;
import com.css.base.filter.SSOAuthFilter;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.Response;
import com.css.base.utils.StringUtils;
import com.css.base.utils.UUIDUtils;

/**
 * 训练管理会议功能调用 第三方接口
 * 
 */

@Controller
@RequestMapping("app/xlgl/xlglMeeting")
public class XlglMeetingController {
	@Autowired
	private XlglHuijianService xlglHuijianService;
	//废弃
	private  final static String Login = "/api/v3/user/login";
	
	
	@Value("${csse.meeting.huijian.url}")
	private  String URL ;
	@Value("${csse.meeting.huijian.url.create}")
	private  String Create ;
	/*@Value("${csse.meeting.huijian}")
	private  String HuiYiApp ;*/
	@Value("${HuiYiappId}")
	private String appId;
	
	

	// 创建会议
	@ResponseBody
	@RequestMapping("/createHuiYi")
	public void createHuiYi(String startTime, String endTime, String confName) {
		String url = URL + Create;
		String token = SSOAuthFilter.getToken();
		JSONObject jsonData = xlglHuijianService.createHuiYi(url, appId, token, startTime, endTime, confName);
		if(jsonData !=null) {
			JSONObject jsonObject = jsonData.getJSONObject("data");
			System.out.println("会见返回信息："+jsonObject);
			Boolean boolean1 = jsonData.getBoolean("isSuccess");
			String confId = jsonObject.getString("confId");
			System.out.println("会见返回信息会议号："+confId);
			if (boolean1) {
				Response.ok();
			} else {
				System.out.println("创建会议错误信息：" + jsonData.getString("errorCode"));
				Response.error();
			}
		}
	
	}
	
	// 创建会议
	private String create(String startTime, String endTime, String confName) {
		String url = URL + Create;
		String token = SSOAuthFilter.getToken();
		JSONObject jsonData = xlglHuijianService.createHuiYi(url, appId, token, startTime, endTime, confName);
		String confId = "";
		if(jsonData !=null) {
			Boolean boolean1 = jsonData.getBoolean("isSuccess");
			if (boolean1) {
				JSONObject jsonObject = jsonData.getJSONObject("data");
				confId = jsonObject.getString("confId");
			} else {
				System.out.println("创建会议错误信息：" + jsonData.getString("errorCode"));
			}
		}
		return confId;
	}

	/**
	 * 跨域post请求
	 * 
	 * @param url
	 *            请求地址
	 * @param map
	 *            请求参数集合
	 * @return 返回JSON数据
	 */
	public static JSONObject getJsonData(String url, LinkedMultiValueMap<String, Object> map) {
		// 设置消息头
		HttpHeaders headers = new HttpHeaders();
		MediaType mediaType = MediaType.parseMediaType("application/x-www-form-urlencoded;charset=UTF-8");
		headers.setContentType(mediaType);
		// 设置请求参数
		HttpEntity<LinkedMultiValueMap<String, Object>> formEntity = new HttpEntity<LinkedMultiValueMap<String, Object>>(
				map, headers);
		// 创建RestTemplate对象
		RestTemplate restTemplate = new RestTemplate();
		url+="?access_token=" + SSOAuthFilter.getToken();
		try {
			// 发送post请求
			ResponseEntity<JSONObject> data = restTemplate.postForEntity(url, formEntity, JSONObject.class);
			// 返回请求数据
			return data.getBody();
		} catch (Exception e) {
			System.out.println("【报错信息】" + e.getMessage() + "，url=" + url);
		}
		return null;
	}
	
	
	
	
	/**
	 * 页面调起客户端 废弃
	 * */ 
	/*@ResponseBody
	@RequestMapping("/huiyiApp")
	public void HuiYiApp(String startTime, String endTime, String confName) {
		String url = HuiYiApp;
		LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
		map.add("appId", appId);
		map.add("secretKey", appId);
		Map<String, String> loginToken = this.loginToken();
		map.add("token", loginToken.get("token"));
		map.add("suid", loginToken.get("suid"));
		map.add("nickName", loginToken.get("nickName"));
		String confId = create(null,null,null);//会议号id
		map.add("id", confId);
		JSONObject jsonData = getJsonData(url, map);
		Boolean boolean1 = jsonData.getBoolean("isSuccess");
		if (boolean1) {
			Response.ok();
		} else {
			System.out.println("创建会议错误信息：" + jsonData.getString("errorCode"));
			Response.error();
		}
	}*/
	
	/**会见登录  废弃
	 * */
	private Map<String,String> loginToken() {
		Map<String, String> hashmap = new HashMap<String, String>();
		LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
		map.add("appId", appId);
		map.add("secretKey", appId);
		map.add("cerType", "1");
		map.add("signId", CurrentUser.getUserId());
		String url = URL + Login;
		JSONObject jsonData = getJsonData(url, map);
		if (jsonData != null) {
			Boolean boolean1 = jsonData.getBoolean("isSuccess");
			if (boolean1) {
				JSONObject jsonObject = jsonData.getJSONObject("data");
				String token = jsonObject.getString("token");
				hashmap.put("token", token);
				String suid = jsonObject.getString("suid");
				hashmap.put("suid", suid);
				String nickName = jsonObject.getString("nickName");
				hashmap.put("nickName", nickName);
			} else {
				System.out.println("登录会议获取token错误信息：" + jsonData.getString("errorCode"));
			}
		}
		return hashmap;
	}

}
