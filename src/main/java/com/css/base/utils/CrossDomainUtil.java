package com.css.base.utils;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.css.base.filter.SSOAuthFilter;

/**
 * 跨域请求数据
 * @author mashuwen
 * @date 2017-10-12 21:17:28
 */
public class CrossDomainUtil {

	public static JSONObject getJsonData(String url) {
		return getJsonData(url, null);
	}
	
	
	

	/**
	 * 跨域GETt请求
	 * @param url 请求地址
	 * @param map 请求参数集合
	 * @return 返回JSON数据
	 */
	public static JSONObject getJsonDataGET(String url,LinkedMultiValueMap<String, Object> map){
		//设置消息头
		HttpHeaders headers = new HttpHeaders();
		MediaType mediaType = MediaType.parseMediaType("application/x-www-form-urlencoded;charset=UTF-8");
		headers.setContentType(mediaType);
		//设置请求参数
        HttpEntity<LinkedMultiValueMap<String, Object>> formEntity = new HttpEntity<LinkedMultiValueMap<String, Object>>(map, headers);
        //创建RestTemplate对象
        RestTemplate restTemplate = new RestTemplate();
        url+="?access_token=" + SSOAuthFilter.getToken();
        try{
        	//发送post请求
        	//ResponseEntity<JSONObject> data = restTemplate.	getForEntity(url, formEntity, JSONObject.class);
        	ResponseEntity<JSONObject> forEntity = restTemplate.getForEntity(url, JSONObject.class, formEntity);
        	//返回请求数据
        	return forEntity.getBody();
        }catch(Exception e){
        	System.out.println("【报错信息】"+e.getMessage()+"，url="+url);
        }
        return null;
	}
	
	
	/**
	 * 跨域post请求
	 * @param url 请求地址
	 * @param map 请求参数集合
	 * @return 返回JSON数据
	 */
	public static JSONObject getJsonDataZaiWei(String url,LinkedMultiValueMap<String, Object> map){
		//设置消息头
		HttpHeaders headers = new HttpHeaders();
		MediaType mediaType = MediaType.parseMediaType("application/x-www-form-urlencoded;charset=UTF-8");
		headers.setContentType(mediaType);
		//设置请求参数
        HttpEntity<LinkedMultiValueMap<String, Object>> formEntity = new HttpEntity<LinkedMultiValueMap<String, Object>>(map, headers);
        //创建RestTemplate对象
        RestTemplate restTemplate = new RestTemplate();
        try{
        	//发送post请求
        	ResponseEntity<JSONObject> data = restTemplate.postForEntity(url, formEntity, JSONObject.class);
        	//返回请求数据
        	return data.getBody();
        }catch(Exception e){
        	System.out.println("【报错信息】"+e.getMessage()+"，url="+url);
        }
        return null;
	}
	
	
	/**
	 * 跨域post请求
	 * @param url 请求地址
	 * @param map 请求参数集合
	 * @return 返回JSON数据
	 */
	public static JSONObject getJsonData(String url,LinkedMultiValueMap<String, Object> map){
		//设置消息头
		HttpHeaders headers = new HttpHeaders();
		MediaType mediaType = MediaType.parseMediaType("application/x-www-form-urlencoded;charset=UTF-8");
		headers.setContentType(mediaType);
		//设置请求参数
        HttpEntity<LinkedMultiValueMap<String, Object>> formEntity = new HttpEntity<LinkedMultiValueMap<String, Object>>(map, headers);
        //创建RestTemplate对象
        RestTemplate restTemplate = new RestTemplate();
        url+="?access_token=" + SSOAuthFilter.getToken();
        try{
        	//发送post请求
        	ResponseEntity<JSONObject> data = restTemplate.postForEntity(url, formEntity, JSONObject.class);
        	//返回请求数据
        	return data.getBody();
        }catch(Exception e){
        	System.out.println("【报错信息】"+e.getMessage()+"，url="+url);
        }
        return null;
	}
	
	public static JSONArray getJsonArrayData(String url,LinkedMultiValueMap<String, Object> map){
		//设置消息头
		HttpHeaders headers = new HttpHeaders();
		MediaType mediaType = MediaType.parseMediaType("application/x-www-form-urlencoded;charset=UTF-8");
		headers.setContentType(mediaType);
		//设置请求参数
        HttpEntity<LinkedMultiValueMap<String, Object>> formEntity = new HttpEntity<LinkedMultiValueMap<String, Object>>(map, headers);
        //创建RestTemplate对象
        RestTemplate restTemplate = new RestTemplate();
        url+="?access_token=" + SSOAuthFilter.getToken();
        try{
        	//发送post请求
        	ResponseEntity<JSONArray> data = restTemplate.postForEntity(url, formEntity, JSONArray.class);
        	//返回请求数据
        	return data.getBody();
        }catch(Exception e){
        	System.out.println("【报错信息】"+e.getMessage()+"，url="+url);
        }
        return null;
	}
	
	public static String postJSONString(String url, LinkedMultiValueMap<String, Object> map) {
		// 设置消息头
		HttpHeaders headers = new HttpHeaders();
		MediaType mediaType = MediaType.parseMediaType("application/x-www-form-urlencoded;charset=UTF-8");
		headers.setContentType(mediaType);
		// 设置请求参数
		HttpEntity<LinkedMultiValueMap<String, Object>> formEntity = new HttpEntity<LinkedMultiValueMap<String, Object>>(
				map, headers);
		url +="?access_token=" + SSOAuthFilter.getToken();
		// 创建RestTemplate对象
		// 设置超时时间
		SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
		requestFactory.setConnectTimeout(3000);
		requestFactory.setReadTimeout(3000);
		RestTemplate restTemplate = new RestTemplate(requestFactory);
		ResponseEntity<String> result = restTemplate.postForEntity(url, formEntity, String.class);
		return result.getBody();
	}

}
