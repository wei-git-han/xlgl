package com.css.app.xlgl.meeting.controller;

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
import com.css.addbase.msg.MsgTipUtil;
import com.css.app.xlgl.meeting.entity.XlglHuijian;
import com.css.app.xlgl.meeting.service.XlglHuijianService;
import com.css.base.filter.SSOAuthFilter;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.Response;
import com.css.base.utils.StringUtils;

/**
 * 训练管理会议功能调用 第三方接口
 * 
 */

@Controller
@RequestMapping("app/xlgl/xlglMeeting")
public class XlglMeetingController {
	@Autowired
	private XlglHuijianService xlglHuijianService;

	@Autowired
	private MsgTipUtil msgUtil;

	@Value("${csse.meeting.huijian.url}")
	private String URL;
	@Value("${csse.meeting.huijian.url.create}")
	private String Create;
	@Value("${csse.meeting.huiyi.HuiYiappId}")
	private String appId;
	@Value("${csse.meeting.huiyi.url.login}")
	private String Login;

	@Value("${csse.meeting.appid}")
	private String huiJianAppId;
	@Value("${csse.meeting.appSecret}")
	private String clientSecret;
	//private final static String Login = "/api/v3/user/login";

	//private final static String Create = "/api/v3/conference/create";

	private final static String HuiYiApp = "SRhuijian://SRhuijian.com/jm";


	/**
	 * 会见发消息，调用会见
	 */
	@ResponseBody
	@RequestMapping("/msg")
	public void ceshi(String xlglId) {
		String url = URL + Create;
		JSONObject jsonDate = xlglHuijianService.createHuiYi(url, appId, SSOAuthFilter.getToken(), null, null, null);
		String thirdConfId = "";
		XlglHuijian xlglHuijian = new XlglHuijian();
		xlglHuijian = xlglHuijianService.queryObjectByxlglId(xlglId);
		if (xlglHuijian == null && jsonDate != null) {
			thirdConfId = jsonDate.getString("thirdConfId");
			xlglHuijianService.saveXlglHuiJian(xlglId, thirdConfId);
		}
		xlglHuijian = xlglHuijianService.queryObjectByxlglId(xlglId);
		if (xlglHuijian != null) {
			msgUtil.sendMsg("会见系统", "您有一条新的会议链接", xlglHuijian.getConfId(), CurrentUser.getUserId(), huiJianAppId,
					clientSecret, "训练管理", xlglHuijian.getConfId(), "", "true");
			Response.ok();
		} else {
			JSONObject json = new JSONObject();
			json.put("code", 999);
			json.put("msg", "无法连接到会见服务");
			Response.json(json);
		}
	}

	/**
	 * 会见登录
	 */
	@ResponseBody
	@RequestMapping("/login")
	public void login() {
		Map<String, String> loginToken = xlglHuijianService.loginToken();
		Response.json(loginToken);
	}

	/**
	 * 创建会议
	 */
	@ResponseBody
	@RequestMapping("/createHuiYi")
	public void createHuiYi(String startTime, String endTime, String confName) {
		LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
		String url = URL + Create;
		String token = SSOAuthFilter.getToken();
		JSONObject jsonData = xlglHuijianService.createHuiYi(url, appId, token, startTime, endTime, confName);
		if (jsonData != null) {
			String confId = jsonData.getString("confId");
			System.out.println("会见返回的会议号：" + confId);
			Response.ok();
		} else {
			System.out.println("创建会议错误信息：" + jsonData.getString("errorCode"));
			Response.error();

		}
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
		// url+="?access_token=" + SSOAuthFilter.getToken();
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
//---------------------------------------------------------------------------------------------------------------------------------
	/**
	 * 页面调起客户端 废弃
	 */

	@ResponseBody
	@RequestMapping("/huiyiApp")
	public void HuiYiApp(String startTime, String endTime, String confName) {
		String url = "";
		LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
		map.add("appId", appId);
		map.add("secretKey", appId);
		Map<String, String> loginToken = this.loginToken();
		map.add("token", loginToken.get("token"));
		map.add("suid", loginToken.get("suid"));
		map.add("nickName", loginToken.get("nickName"));
		//String confId = create(null, null, null);// 会议号id map.add("id", confId); JSONObject jsonData =
		JSONObject jsonData = getJsonData(url, map);
		Boolean boolean1 = jsonData.getBoolean("isSuccess");
		if (boolean1) {
			Response.ok();
		} else {
			System.out.println("创建会议错误信息：" + jsonData.getString("errorCode"));
			Response.error();
		}
	}

	/**
	 * 会见登录 废弃
	 */

	private Map<String, String> loginToken() {
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
	
	/**
	  打开浏览器输入网址 废弃
	 */
	private void openURL(String url) {
		String os = System.getProperty("os.name");
		if(os.indexOf("Linux") != -1) {
			try {
				String [] browsers = {"firefox","opera","konqueror","epiphany","mozilla","netscape"};
				String browser = null;
				for(int i =0;i<browsers.length && browser ==null;i++) {
					if(Runtime.getRuntime().exec(new String[] {"which",browsers[i]}).waitFor()==0) {
						browser = browsers[i];
					}
				}
				if(browser !=null) {
					Runtime.getRuntime().exec(new String[] {browser,url});
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			String cmd ="rundll32 url.dll,FileProtocolHandler http://"+url;
			try {
				Runtime.getRuntime().exec(cmd);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 调用浏览器 废弃
	 * */
	@ResponseBody
	@RequestMapping("/openURLs")
	public void openURLs(String url) {
		JSONObject jsonData  = new JSONObject();
		try {
			if(StringUtils.isNotBlank(url)) {
				openURL(url);
			}else {
				Map<String, String> loginToken = this.loginToken();
				String token = loginToken.get("token");
				String suid = loginToken.get("suid");
				String nickName = loginToken.get("nickName");
				String urls =HuiYiApp+"/jm?access_token="+token+"&nickName="+nickName+"&suid="+suid+"&domain="+URL;
				openURL(urls);
				System.out.println("调用会见的全路径:"+urls);
				System.out.println("调用会见的access_token:"+token);
				System.out.println("调用会见的nickName:"+nickName);
				System.out.println("调用会见的suid:"+suid);
				System.out.println("调用会见的domain:+"+URL);
			}
			jsonData.put("code", "0");
			Response.json(jsonData);;
		}catch(Exception e){
			e.printStackTrace();
			Response.error();
		}
		
		
	}

}
