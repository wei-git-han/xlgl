package com.css.app.xlgl.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.css.app.xlgl.entity.XlglExamExaminetopic;
import com.css.app.xlgl.service.XlglExamExaminetopicService;
import com.css.app.xlgl.service.XlglExamTopicService;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.PageUtils;
import com.css.base.utils.Response;
import com.css.base.utils.UUIDUtils;
import com.github.pagehelper.PageHelper;


/**
 * 训练考核-考核组织-考试副表题目表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-07-30 10:56:43
 */
@Controller
@RequestMapping("app/xlgl/xlglexamexaminetopic")
public class XlglExamExaminetopicController {
	private final Logger logger = LoggerFactory.getLogger(XlglNewsController.class);
	
	@Autowired
	private XlglExamExaminetopicService xlglExamExaminetopicService;
	@Autowired
	private XlglExamTopicService xlglExamTopicService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	public void list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(page, limit);
		
		//查询列表数据
		List<XlglExamExaminetopic> xlglExamExaminetopicList = xlglExamExaminetopicService.queryList(map);
		
		PageUtils pageUtil = new PageUtils(xlglExamExaminetopicList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info")
	public void info(String id){
	
		XlglExamExaminetopic xlglExamExaminetopic = xlglExamExaminetopicService.queryObject(id);
		Response.json("xlglExamExaminetopic", xlglExamExaminetopic);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	public void save(XlglExamExaminetopic xlglExamExaminetopic){
		xlglExamExaminetopic.setId(UUIDUtils.random());
		xlglExamExaminetopicService.save(xlglExamExaminetopic);
		
		Response.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public void update(XlglExamExaminetopic xlglExamExaminetopic){
		xlglExamExaminetopicService.update(xlglExamExaminetopic);
		
		Response.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public void delete(String[] ids){
		xlglExamExaminetopicService.deleteBatch(ids);
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		logger.info("当前删除操作人："+CurrentUser.getUsername()+"---id:"+CurrentUser.getUserId()+"--时间是："+date);
		Response.ok();
	}
	
	/**
	 * 随机抽取功能
	 * @param subjectId 科目id
	 * @param topicType 题目类型
	 * @param topicNumber 题目数量
	 * @param fractionalNumber 题目分数
	 * @param surplusNumber 剩余的总分数
	 * */
	/*@ResponseBody
	@RequestMapping("/randomExtract")
	public void randomExtract(String subjectId,String topicType,Integer topicNumber,Integer fractionalNumber,
			Integer surplusNumber) {
		JSONObject jsonObject = new JSONObject();
		Map<String, Object> map = new HashMap<>();
		map.put("subjectId", subjectId);
		map.put("topicType", topicType);
		List<XlglExamTopic> queryList = xlglExamTopicService.queryList(map);
		jsonObject.put("topicType", topicType) ;
		jsonObject.put("topicNumber", topicNumber) ;
		jsonObject.put("fractionalNumber", fractionalNumber) ;
		jsonObject.put("allNumber", topicNumber*fractionalNumber) ;
		if(queryList.size()<=topicNumber) {
			StringBuffer str =new StringBuffer();
			for (int i = 0; i < queryList.size(); i++) {
				if(i == queryList.size()-1) {
					str.append(queryList.get(i).getId());
					break;
				}else {
					str.append(queryList.get(i).getId()+",");
				}
			}
			Integer number = surplusNumber-(queryList.size()*fractionalNumber);
			jsonObject.put("surplusNumber", number) ;
			jsonObject.put("topicIds", str.toString()) ;
			jsonObject.put("topicNumber", queryList.size()) ;
			jsonObject.put("allNumber", queryList.size()*fractionalNumber) ;
			jsonObject.put("msg", "该题库中题目数量为："+queryList.size());
		}else {
			StringBuffer str =new StringBuffer();
			Map<Integer, Object> hashMap = new HashMap<>();
			int i =0;
			while(hashMap.size()<topicNumber) {
				int random = (int)(Math.random() * queryList.size());
				if(!hashMap.containsKey(random)) {
					hashMap.put(random, "");
					i++;
					if(i == topicNumber) {
						str.append(queryList.get(random).getId());
						break;
					}else {
						str.append(queryList.get(random).getId()+",");
					}
				}
			}
			Integer number = surplusNumber-(topicNumber*fractionalNumber);
			jsonObject.put("surplusNumber", number) ;
			jsonObject.put("topicIds", str.toString()) ;
		}
		Response.json(jsonObject);
	}*/
	
}
