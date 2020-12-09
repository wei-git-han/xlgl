package com.css.app.xlgl.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.css.addbase.appconfig.entity.BaseAppConfig;
import com.css.addbase.appconfig.service.BaseAppConfigService;
import com.css.addbase.constant.AppConstant;
import com.css.app.xlgl.entity.XlglExamSubject;
import com.css.app.xlgl.entity.XlglExamTopic;
import com.css.app.xlgl.service.XlglExamSubjectService;
import com.css.app.xlgl.service.XlglExamTopicService;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.PageUtils;
import com.css.base.utils.Response;
import com.css.base.utils.StringUtils;
import com.css.base.utils.UUIDUtils;
import com.github.pagehelper.PageHelper;


/**
 * 训练管理-考核-题目维护-科目表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-07-28 16:17:20
 */
@Controller
@RequestMapping("app/xlgl/xlglexamsubject")
public class XlglExamSubjectController {
	private final Logger logger = LoggerFactory.getLogger(XlglNewsController.class);
	
	@Autowired
	private XlglExamSubjectService xlglExamSubjectService;
	@Autowired
	private XlglExamTopicService xlglExamTopicService;
	@Autowired
	private BaseAppConfigService baseAppConfigService;
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<XlglExamSubject> xlglExamSubjectList = xlglExamSubjectService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(xlglExamSubjectList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info")
	public void info(String id){
		XlglExamSubject xlglExamSubject = xlglExamSubjectService.queryObject(id);
		Response.json("xlglExamSubject", xlglExamSubject);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	public void save(XlglExamSubject xlglExamSubject){
		xlglExamSubject.setId(UUIDUtils.random());
		String userId = CurrentUser.getUserId();
		Date date = new Date();
		xlglExamSubject.setCreateDate(date);
		xlglExamSubject.setUpdateDate(date);
		xlglExamSubject.setCreateUser(userId);
		xlglExamSubject.setUpdateUser(userId);
		xlglExamSubjectService.save(xlglExamSubject);
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public void update(XlglExamSubject xlglExamSubject,String delType){
		Date date = new Date();
		xlglExamSubject.setUpdateDate(date);
		xlglExamSubject.setCreateUser(CurrentUser.getUserId());
		xlglExamSubjectService.update(xlglExamSubject);
		if(StringUtils.isNotBlank(delType)) {
			Map<String, Object> map = new HashMap<>();
			map.put("subjectId", xlglExamSubject.getId());
			map.put("topicType", delType);
			xlglExamTopicService.deleteByType(map);
		}
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public void delete(String[] ids){
		xlglExamSubjectService.deleteBatch(ids);
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		logger.info("当前删除操作人："+CurrentUser.getUsername()+"---id:"+CurrentUser.getUserId()+"--时间是："+date);
		Response.ok();
	}
	/**
	 * 题库列表
	 * */
	@ResponseBody
	@RequestMapping("/subject")
	public void subjectList() {
		List<XlglExamSubject> findList = xlglExamSubjectService.findList();
		JSONArray jsons = new JSONArray();
		for (XlglExamSubject xlglExamSubject : findList) {
			JSONObject json = new JSONObject();
			json.put("id",xlglExamSubject.getId());
			json.put("label", xlglExamSubject.getSubjectName());
			String[] split =new String[xlglExamSubject.getSubjectType().length()];
			if(xlglExamSubject.getSubjectType() !=null && xlglExamSubject.getSubjectType().contains(",")) {
				split = xlglExamSubject.getSubjectType().split(",");	
			}else if(StringUtils.isNotBlank(xlglExamSubject.getSubjectType())) {
				split[0]=xlglExamSubject.getSubjectType();
				xlglExamSubject.setSubjectTypeAll(split);
			}
			jsons.add(json);
			if(split.length>0) {
				JSONArray jsonTypeArray = new JSONArray();
				for (String string : split) {
					JSONObject jsontype = new JSONObject();
					jsontype.put("id",UUIDUtils.random());
					jsontype.put("type",string);
					switch (string) {
					case "1":
						jsontype.put("label", "单选题");
						break;
					case "2":
						jsontype.put("label", "多选题");
						break;
					case "3":
						jsontype.put("label", "判断题");
						break;
					case "4":
						jsontype.put("label", "填空题");
						break;

					case "5":
						jsontype.put("label", "简答题");
						break;
					default:
						break;
					}
					jsonTypeArray.add(jsontype);
					json.put("children", jsonTypeArray);
				}
			}
		}
		Response.json(jsons);
	}
	/**
	 * 考试科目选择 下拉框
	 * */
	@ResponseBody
	@RequestMapping("/subjectListAll")
	public void subjectListAll(){
		List<XlglExamSubject> findList = xlglExamSubjectService.findList();
		
		Response.json("findList", findList);
	}
	
	/**
	 * 选择科目返回题目类型
	 * */
	@ResponseBody
	@RequestMapping("/findTopicBySubId")
	public void findTopicBySubId(String subjectId){
		JSONObject jsonbject = this.getTopicTypeNumber(subjectId);
		XlglExamSubject queryObject = xlglExamSubjectService.queryObject(subjectId);
		Map<String ,Object> map =new HashMap<String ,Object>();
		if(queryObject.getSubjectType()!=null && queryObject.getSubjectType().contains(",")) {
			ArrayList<String> arrayList = new ArrayList<String>();
			String[] split = queryObject.getSubjectType().split(",");
			for (int i = 0; i < split.length; i++) {
				String string = jsonbject.getString(split[i]);
				if(Integer.valueOf(string)>0) {
					arrayList.add(split[i]);
				}
			}
			map.put("type", arrayList);
		}else if(StringUtils.isNotBlank(queryObject.getSubjectType())) {
			String[] split = new String[queryObject.getSubjectType().length()];
			split[0]=queryObject.getSubjectType();
			String string = jsonbject.getString(split[0]);
			ArrayList<String> arrayList = new ArrayList<String>();
			if(Integer.valueOf(string)>0) {
				arrayList.add(split[0]);
			}
			map.put("type", arrayList);
		}
		
		Response.json("findList", map);
	}

	/**
	 * 获得科目说明
	 * */
	@ResponseBody
	@RequestMapping("/getSubjectState")
	public void getSubjectState(String id){
		JSONObject jsonbject = new JSONObject();
		XlglExamSubject queryObject = xlglExamSubjectService.queryObject(id);
		if(queryObject != null) {
			jsonbject.put("id", queryObject.getId());
			jsonbject.put("state", queryObject.getState());
		}
		Response.json(jsonbject);
	}
	
	
	/**
	 * 获得科目下每道题型下在题库中的数量
	 * */
	@ResponseBody
	@RequestMapping("/getTopicNumber")
	public void getTopicNumber(String id){
		JSONObject jsonbject = this.getTopicTypeNumber(id);
		Response.json(jsonbject);
	}
	
	private JSONObject getTopicTypeNumber(String id) {
		Map<String ,Object> map =new HashMap<String ,Object>();
		JSONObject jsonbject = new JSONObject();
		XlglExamSubject queryObject = xlglExamSubjectService.queryObject(id);
		map.put("subjectId", queryObject.getId());
		List<XlglExamTopic> queryList = xlglExamTopicService.queryList(map);
		String subjectType = queryObject.getSubjectType();
		int type1=0;
		int type2=0;
		int type3=0;
		int type4=0;
		if(subjectType.contains(",")) {
			String[] split = subjectType.split(",");
			for (String string : split) {
				for (XlglExamTopic xlglExamTopic : queryList) {
					if(string.equals(xlglExamTopic.getTopicType()) && string.equals("1")) {
						type1 ++;
					}
					if(string.equals(xlglExamTopic.getTopicType()) && string.equals("2")) {
						type2 ++;
					}
					if(string.equals(xlglExamTopic.getTopicType()) && string.equals("3")) {
						type3 ++;
					}
					if(string.equals(xlglExamTopic.getTopicType()) && string.equals("4")) {
						type4 ++;
					}
				}
			}
		}else {
			for (XlglExamTopic xlglExamTopic : queryList) {
				if(subjectType.equals(xlglExamTopic.getTopicType()) && subjectType.equals("1")) {
					type1 ++;
				}
				if(subjectType.equals(xlglExamTopic.getTopicType()) && subjectType.equals("2")) {
					type2 ++;
				}
				if(subjectType.equals(xlglExamTopic.getTopicType()) && subjectType.equals("3")) {
					type3 ++;
				}
				if(subjectType.equals(xlglExamTopic.getTopicType()) && subjectType.equals("4")) {
					type4 ++;
				}
			}
			
		}
		jsonbject.put("1", type1);
		jsonbject.put("2", type2);
		jsonbject.put("3", type3);
		jsonbject.put("4", type4);
		return jsonbject;
	}
	/**
	 * 限制上传模板权限
	 * */
	@ResponseBody
	@RequestMapping("/getUpLoad")
	public void getupLoad() {
		boolean state = false;
		List<BaseAppConfig> typeList = baseAppConfigService.typeList(AppConstant.EXAM_TOPIC);
		for (BaseAppConfig baseAppConfig : typeList) {
			if(baseAppConfig.getValue().equals(CurrentUser.getUserId())) {
				state =true;
			}
		}
		Response.json("state",state);
	}
}
