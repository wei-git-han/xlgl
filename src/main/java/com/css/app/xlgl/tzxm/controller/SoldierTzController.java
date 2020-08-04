package com.css.app.xlgl.tzxm.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.css.app.xlgl.tzxm.entity.SoldierTz;
import com.css.app.xlgl.tzxm.service.SomatoTzService;
import com.css.base.utils.Response;

@RestController
@RequestMapping("/soldiertz")
public class SoldierTzController {
	
	@Autowired
	private SomatoTzService somatoTzService;

	@RequestMapping("/somatotype")
	public void somatotype(String sex,String birthday,int age,String type,Float height,Float weight) {
		JSONObject json = new JSONObject();
		float BMI = weight/(height/100*height/100);
		BMI = (float)(Math.round(BMI*10))/10;
		if((height/100 < 1.60 && "男".equals(sex)) || (height/100 < 1.58 && "女".equals(sex)) || 
				(height/100 > 2.00 && "男".equals(sex)) || (height/100 > 1.90 && "女".equals(sex)) || 
				(weight < 47.4 && "男".equals(sex)) || (weight < 46.2 && "女".equals(sex)) ||
				(weight > 119.6 && "男".equals(sex)) || (weight > 100.7 && "女".equals(sex)) ||
				age < 0 || age > 1000) {
			json.put("sex", sex);
			json.put("birthday", birthday);
			json.put("age", age);
			json.put("type", type);
			json.put("BMI", String.valueOf(BMI));
			json.put("isFlag", "不合格");
		}else {
			String isFlag = "不合格";
			SoldierTz soldier = somatoTzService.selectBMI(height/100,weight,sex,age);
			if(soldier != null) {
				Float max_BMI = soldier.getMAX_BMI();
				Float min_BMI = soldier.getMIN_BMI();
				if(BMI >= min_BMI && BMI <= max_BMI) {
					isFlag = "合格";
				}
			}
			json.put("sex", sex);
			json.put("birthday", birthday);
			json.put("age", age);
			json.put("type", type);
			json.put("BMI", String.valueOf(BMI));
			json.put("isFlag", isFlag);
		}
		Response.json(json);
	}
	
	/**
	 * 根据4科成绩查询份数及总分数
	 * */
	@RequestMapping("/selgrade")
	public void selGrade(String sex,String age,String type,String ytxscount,String ywqzcount,String sruncount,String tsruncount) {
		
		
	}
	
	/**
	 * 查看体型标准
	 * */
	@RequestMapping("/selBodyStandard")
	public void selBodyStandard(){
		JSONObject result = new JSONObject();
		JSONArray jsonArr = new JSONArray();
		JSONObject json1 = new JSONObject();
		json1.put("age", "24岁以下");
		json1.put("man", "18.5~25.9");
		json1.put("woman", "18.5~23.9");
		jsonArr.add(json1);
		
		JSONObject json2 = new JSONObject();
		json2.put("age", "25~29岁");
		json2.put("man", "18.5~26.9");
		json2.put("woman", "18.5~24.9");
		jsonArr.add(json2);
		
		JSONObject json3 = new JSONObject();
		json3.put("age", "30~39岁");
		json3.put("man", "18.5~27.9");
		json3.put("woman", "18.5~25.9");
		jsonArr.add(json3);
		
		JSONObject json4 = new JSONObject();
		json4.put("age", "40~49岁");
		json4.put("man", "18.5~28.9");
		json4.put("woman", "18.5~26.9");
		jsonArr.add(json4);
		
		JSONObject json5 = new JSONObject();
		json5.put("age", "50~59岁");
		json5.put("man", "18.5~29.4");
		json5.put("woman", "18.5~27.4");
		jsonArr.add(json5);
		
		JSONObject json6 = new JSONObject();
		json6.put("age", "60岁以上");
		json6.put("man", "18.5~29.9");
		json6.put("woman", "18.5~27.9");
		jsonArr.add(json6);
		
		result.put("result", jsonArr);
		Response.json(result);
	}

	/**
	 * 评定标准
	 * */
	@RequestMapping("/selAssessStandard")
	public void selAssessStandard() {
		JSONObject result = new JSONObject();
		JSONArray jsonArr = new JSONArray();
		JSONObject json1 = new JSONObject();
		json1.put("pd", "单项及格");
		json1.put("oneType", "65");
		json1.put("twoType", "60");
		json1.put("threeType", "55");
		jsonArr.add(json1);
		
		JSONObject json2 = new JSONObject();
		json2.put("pd", "不及格");
		json2.put("oneType", "<260");
		json2.put("twoType", "<240");
		json2.put("threeType", "220");
		jsonArr.add(json2);

		JSONObject json3 = new JSONObject();
		json3.put("pd", "及格");
		json3.put("oneType", "260");
		json3.put("twoType", "240");
		json3.put("threeType", "220");
		jsonArr.add(json3);
		
		JSONObject json4 = new JSONObject();
		json4.put("pd", "良好");
		json4.put("oneType", "340");
		json4.put("twoType", "320");
		json4.put("threeType", "300");
		jsonArr.add(json4);
		
		JSONObject json5 = new JSONObject();
		json5.put("pd", "优秀");
		json5.put("oneType", "380");
		json5.put("twoType", "360");
		json5.put("threeType", "340");
		jsonArr.add(json5);
		
		JSONObject json6 = new JSONObject();
		json6.put("pd", "特3级");
		json6.put("oneType", "440");
		json6.put("twoType", "440");
		json6.put("threeType", "440");
		jsonArr.add(json6);
		
		JSONObject json7 = new JSONObject();
		json7.put("pd", "特2级");
		json7.put("oneType", "480");
		json7.put("twoType", "480");
		json7.put("threeType", "480");
		jsonArr.add(json7);
		
		JSONObject json8 = new JSONObject();
		json8.put("pd", "特1级");
		json8.put("oneType", "500");
		json8.put("twoType", "500");
		json8.put("threeType", "500");
		jsonArr.add(json8);
		
		result.put("result", jsonArr);
		Response.json(result);
	}

	/**
	 * 引体向上(男)及格标准
	 * */
	@RequestMapping("/selChinning")
	public void selChinning(){
		JSONObject result = new JSONObject();
		JSONArray jsonArr = new JSONArray();
		JSONObject json1 = new JSONObject();
		json1.put("age", "24岁以下");
		json1.put("man", "11次");
		jsonArr.add(json1);
		
		JSONObject json2 = new JSONObject();
		json2.put("age", "25~27岁");
		json2.put("man", "10次");
		jsonArr.add(json2);
		
		JSONObject json3 = new JSONObject();
		json3.put("age", "28~30岁");
		json3.put("man", "9次");
		jsonArr.add(json3);
		
		JSONObject json4 = new JSONObject();
		json4.put("age", "31~33岁");
		json4.put("man", "8次");
		jsonArr.add(json4);
		
		JSONObject json5 = new JSONObject();
		json5.put("age", "34~36岁");
		json5.put("man", "7次");
		jsonArr.add(json5);
		
		JSONObject json6 = new JSONObject();
		json6.put("age", "37~39岁");
		json6.put("man", "6次");
		jsonArr.add(json6);
		
		result.put("result", jsonArr);
		Response.json(result);
	}
	
	/**
	 * 单杠屈臂悬垂(女)及格标准
	 * */
	@RequestMapping("/selQBXC")
	public void selQBXC(){
		JSONObject result = new JSONObject();
		JSONArray jsonArr = new JSONArray();
		JSONObject json1 = new JSONObject();
		json1.put("age", "24岁以下");
		json1.put("woman", "36\"");
		jsonArr.add(json1);
		
		JSONObject json2 = new JSONObject();
		json2.put("age", "25~27岁");
		json2.put("woman", "35\"");
		jsonArr.add(json2);
		
		JSONObject json3 = new JSONObject();
		json3.put("age", "28~30岁");
		json3.put("woman", "33\"");
		jsonArr.add(json3);
		
		JSONObject json4 = new JSONObject();
		json4.put("age", "31~33岁");
		json4.put("woman", "30\"");
		jsonArr.add(json4);
		
		JSONObject json5 = new JSONObject();
		json5.put("age", "34~36岁");
		json5.put("woman", "27\"");
		jsonArr.add(json5);
		
		JSONObject json6 = new JSONObject();
		json6.put("age", "37~39岁");
		json6.put("woman", "24\"");
		jsonArr.add(json6);
		
		result.put("result", jsonArr);
		Response.json(result);
	}
	
	/**
	 * 俯卧撑(40岁以上)及格标准
	 * */
	@RequestMapping("/selPushUp")
	public void selPushUp(){
		JSONObject result = new JSONObject();
		JSONArray jsonArr = new JSONArray();
		JSONObject json1 = new JSONObject();
		json1.put("age", "40~42岁");
		json1.put("man", "28次");
		json1.put("woman", "14次");
		jsonArr.add(json1);
		
		JSONObject json2 = new JSONObject();
		json2.put("age", "43~45岁");
		json2.put("man", "27次");
		json2.put("woman", "12次");
		jsonArr.add(json2);
		
		JSONObject json3 = new JSONObject();
		json3.put("age", "46~48岁");
		json3.put("man", "24次");
		json3.put("woman", "12次");
		jsonArr.add(json3);
		
		JSONObject json4 = new JSONObject();
		json4.put("age", "49~51岁");
		json4.put("man", "22次");
		json4.put("woman", "10次");
		jsonArr.add(json4);
		
		JSONObject json5 = new JSONObject();
		json5.put("age", "52~54岁");
		json5.put("man", "19次");
		json5.put("woman", "9次");
		jsonArr.add(json5);
		
		JSONObject json6 = new JSONObject();
		json6.put("age", "55~57岁");
		json6.put("man", "17次");
		json6.put("woman", "8次");
		jsonArr.add(json6);
		
		JSONObject json7 = new JSONObject();
		json7.put("age", "58~60岁");
		json7.put("man", "11次");
		json7.put("woman", "4次");
		jsonArr.add(json7);
		
		result.put("result", jsonArr);
		Response.json(result);
	}
	
	/**
	 * 俯卧撑(40岁以上)及格标准
	 * */
	@RequestMapping("/selSitUp")
	public void selSitUp(){
		JSONObject result = new JSONObject();
		JSONArray jsonArr = new JSONArray();
		JSONObject json1 = new JSONObject();
		json1.put("age", "24岁以下");
		json1.put("man", "50次");
		json1.put("woman", "42次");
		jsonArr.add(json1);
		
		JSONObject json2 = new JSONObject();
		json2.put("age", "25~27岁");
		json2.put("man", "47次");
		json2.put("woman", "39次");
		jsonArr.add(json2);
		
		JSONObject json3 = new JSONObject();
		json3.put("age", "28~30岁");
		json3.put("man", "45次");
		json3.put("woman", "37次");
		jsonArr.add(json3);
		
		JSONObject json4 = new JSONObject();
		json4.put("age", "31~33岁");
		json4.put("man", "43次");
		json4.put("woman", "35次");
		jsonArr.add(json4);
		
		JSONObject json5 = new JSONObject();
		json5.put("age", "34~36岁");
		json5.put("man", "39次");
		json5.put("woman", "33次");
		jsonArr.add(json5);
		
		JSONObject json6 = new JSONObject();
		json6.put("age", "37~39岁");
		json6.put("man", "35次");
		json6.put("woman", "31次");
		jsonArr.add(json6);
		
		JSONObject json7 = new JSONObject();
		json7.put("age", "40~42岁");
		json7.put("man", "33次");
		json7.put("woman", "29次");
		jsonArr.add(json7);
		
		JSONObject json8 = new JSONObject();
		json8.put("age", "43~45岁");
		json8.put("man", "30次");
		json8.put("woman", "27次");
		jsonArr.add(json8);
		
		JSONObject json9 = new JSONObject();
		json9.put("age", "46~48岁");
		json9.put("man", "28次");
		json9.put("woman", "25次");
		jsonArr.add(json9);
		
		JSONObject json10 = new JSONObject();
		json10.put("age", "49~51岁");
		json10.put("man", "26次");
		json10.put("woman", "23次");
		jsonArr.add(json10);
		
		JSONObject json11 = new JSONObject();
		json11.put("age", "52~54岁");
		json11.put("man", "24次");
		json11.put("woman", "21次");
		jsonArr.add(json11);
		
		JSONObject json12 = new JSONObject();
		json12.put("age", "55~57岁");
		json12.put("man", "22次");
		json12.put("woman", "19次");
		jsonArr.add(json12);
		
		JSONObject json13 = new JSONObject();
		json13.put("age", "58~60岁");
		json13.put("man", "17次");
		json13.put("woman", "17次");
		jsonArr.add(json13);
		
		result.put("result", jsonArr);
		Response.json(result);
	}

	/**
	 * 30米*2蛇形跑及格标准
	 * */
	@RequestMapping("/selSnakeRun")
	public void selSnakeRun(){
		JSONObject result = new JSONObject();
		JSONArray jsonArr = new JSONArray();
		JSONObject json1 = new JSONObject();
		json1.put("age", "24岁以下");
		json1.put("man", "20.4\"");
		json1.put("woman", "22.2\"");
		jsonArr.add(json1);
		
		JSONObject json2 = new JSONObject();
		json2.put("age", "25~27岁");
		json2.put("man", "20.8\"");
		json2.put("woman", "22.5\"");
		jsonArr.add(json2);
		
		JSONObject json3 = new JSONObject();
		json3.put("age", "28~30岁");
		json3.put("man", "21.1\"");
		json3.put("woman", "22.8\"");
		jsonArr.add(json3);
		
		JSONObject json4 = new JSONObject();
		json4.put("age", "31~33岁");
		json4.put("man", "21.3\"");
		json4.put("woman", "23.1\"");
		jsonArr.add(json4);
		
		JSONObject json5 = new JSONObject();
		json5.put("age", "34~36岁");
		json5.put("man", "21.7\"");
		json5.put("woman", "23.4\"");
		jsonArr.add(json5);
		
		JSONObject json6 = new JSONObject();
		json6.put("age", "37~39岁");
		json6.put("man", "21.8\"");
		json6.put("woman", "23.7\"");
		jsonArr.add(json6);
		
		JSONObject json7 = new JSONObject();
		json7.put("age", "40~42岁");
		json7.put("man", "22.3\"");
		json7.put("woman", "24\"");
		jsonArr.add(json7);
		
		JSONObject json8 = new JSONObject();
		json8.put("age", "43~45岁");
		json8.put("man", "22.4\"");
		json8.put("woman", "24.3\"");
		jsonArr.add(json8);
		
		JSONObject json9 = new JSONObject();
		json9.put("age", "46~48岁");
		json9.put("man", "22.6\"");
		json9.put("woman", "24.6\"");
		jsonArr.add(json9);
		
		JSONObject json10 = new JSONObject();
		json10.put("age", "49~51岁");
		json10.put("man", "22.8\"");
		json10.put("woman", "24.9\"");
		jsonArr.add(json10);
		
		JSONObject json11 = new JSONObject();
		json11.put("age", "52~54岁");
		json11.put("man", "23.4\"");
		json11.put("woman", "25.2\"");
		jsonArr.add(json11);
		
		JSONObject json12 = new JSONObject();
		json12.put("age", "55~57岁");
		json12.put("man", "23.8\"");
		json12.put("woman", "25.5\"");
		jsonArr.add(json12);
		
		JSONObject json13 = new JSONObject();
		json13.put("age", "58~60岁");
		json13.put("man", "24.5\"");
		json13.put("woman", "25.8\"");
		jsonArr.add(json13);
		
		result.put("result", jsonArr);
		Response.json(result);
	}
	
	/**
	 * 3000米跑及格标准
	 * */
	@RequestMapping("/selTsRun")
	public void selTsRun(){
		JSONObject result = new JSONObject();
		JSONArray jsonArr = new JSONArray();
		JSONObject json1 = new JSONObject();
		json1.put("age", "24岁以下");
		json1.put("man", "13'35\"");
		json1.put("woman", "16'05\"");
		jsonArr.add(json1);
		
		JSONObject json2 = new JSONObject();
		json2.put("age", "25~27岁");
		json2.put("man", "13'47\"");
		json2.put("woman", "16'18\"");
		jsonArr.add(json2);
		
		JSONObject json3 = new JSONObject();
		json3.put("age", "28~30岁");
		json3.put("man", "14'23\"");
		json3.put("woman", "16'57\"");
		jsonArr.add(json3);
		
		JSONObject json4 = new JSONObject();
		json4.put("age", "31~33岁");
		json4.put("man", "14'55\"");
		json4.put("woman", "17'36\"");
		jsonArr.add(json4);
		
		JSONObject json5 = new JSONObject();
		json5.put("age", "34~36岁");
		json5.put("man", "15'35\"");
		json5.put("woman", "18'15\"");
		jsonArr.add(json5);
		
		JSONObject json6 = new JSONObject();
		json6.put("age", "37~39岁");
		json6.put("man", "15'55\"");
		json6.put("woman", "18'54\"");
		jsonArr.add(json6);
		
		JSONObject json7 = new JSONObject();
		json7.put("age", "40~42岁");
		json7.put("man", "16'53\"");
		json7.put("woman", "19'33\"");
		jsonArr.add(json7);
		
		JSONObject json8 = new JSONObject();
		json8.put("age", "43~45岁");
		json8.put("man", "17'35\"");
		json8.put("woman", "20'12\"");
		jsonArr.add(json8);
		
		JSONObject json9 = new JSONObject();
		json9.put("age", "46~48岁");
		json9.put("man", "18'17\"");
		json9.put("woman", "20'51\"");
		jsonArr.add(json9);
		
		JSONObject json10 = new JSONObject();
		json10.put("age", "49~51岁");
		json10.put("man", "18'59\"");
		json10.put("woman", "21'30\"");
		jsonArr.add(json10);
		
		JSONObject json11 = new JSONObject();
		json11.put("age", "52~54岁");
		json11.put("man", "19'41\"");
		json11.put("woman", "22'09\"");
		jsonArr.add(json11);
		
		JSONObject json12 = new JSONObject();
		json12.put("age", "55~57岁");
		json12.put("man", "20'23\"");
		json12.put("woman", "22'48\"");
		jsonArr.add(json12);
		
		JSONObject json13 = new JSONObject();
		json13.put("age", "58~60岁");
		json13.put("man", "21'05\"");
		json13.put("woman", "23'27\"");
		jsonArr.add(json13);
		
		result.put("result", jsonArr);
		Response.json(result);
	}
	
}
