package com.css.app.xlgl.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.css.base.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.css.app.xlgl.entity.XlglHomepageSports;
import com.css.app.xlgl.entity.XlglHomepageSportsPerson;
import com.css.app.xlgl.service.XlglHomepageSportsPersonService;
import com.css.app.xlgl.service.XlglHomepageSportsService;
import com.css.base.entity.SSOUser;
import com.github.pagehelper.PageHelper;
import org.thymeleaf.processor.ITextNodeProcessorMatcher;


/**
 * 首页-体育活动
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-10-16 10:45:44
 */
@Controller
@RequestMapping("/app/xlgl/xlglhomepagesports")
public class XlglHomepageSportsController {
	@Autowired
	private XlglHomepageSportsService xlglHomepageSportsService;
	@Autowired
	private XlglHomepageSportsPersonService xlglHomepageSportsPersonService;
	
	/**
	 * 列表
	 * type:0:全部，1.报名中；2.已报名；3.组局成功
	 */
	@ResponseBody
	@RequestMapping("/list")
	public void list(Integer page, Integer limit,String type){
		String userId = CurrentUser.getUserId();
		Map<String, Object> map = new HashMap<>();
		if(StringUtils.isNotBlank(type) && "3".equals(type)){
			map.put("zjcg",type);//组局成功
		}
		if(StringUtils.isNotBlank(type) && "1".equals(type)){
			map.put("bmz",type);//报名中
		}
		if(StringUtils.isNotBlank(type) && "2".equals(type)){
			map.put("ybm",type);
		}
		PageHelper.startPage(page, limit);
		//查询列表数据
		List<XlglHomepageSports> xlglHomepageSportsList = xlglHomepageSportsService.queryList(map);
		if("3".equals(type) || "2".equals(type)){//组局成功是从所有组局成功中，删除不是当前登录人的数据；已报名也是从所有数据中，删除不是当前登录人的
		if(xlglHomepageSportsList != null && xlglHomepageSportsList.size() > 0){
			for(int i=0;i<xlglHomepageSportsList.size();i++){
				String sportId = xlglHomepageSportsList.get(i).getId();
				int needNumber = xlglHomepageSportsList.get(i).getNeedNumber();
				int haveNumber = xlglHomepageSportsList.get(i).getHaveNumber();
				if(needNumber == haveNumber){

				}
				XlglHomepageSportsPerson xlglHomepageSportsPerson = xlglHomepageSportsPersonService.queryByUserAndSportId(sportId,userId);
				if(xlglHomepageSportsPerson == null){
					xlglHomepageSportsList.remove(i);
				}else {
					xlglHomepageSportsList.get(i).setType(true);
				}
			}
		}
		}
		PageUtils pageUtil = new PageUtils(xlglHomepageSportsList);
		Response.json("page",pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	public void info(String id){
		JSONObject jsonObject = new JSONObject();
		XlglHomepageSports xlglHomepageSports = xlglHomepageSportsService.queryObject(id);
		Map<String, Object> map = new HashMap<>();
		map.put("sportsId",id);
		//查询列表数据
		List<XlglHomepageSportsPerson> xlglHomepageSportsPersonList = xlglHomepageSportsPersonService.queryList(map);
		jsonObject.put("xlglHomepageSports", xlglHomepageSports);
		jsonObject.put("sportPersonList", xlglHomepageSportsPersonList);
		Response.json(jsonObject);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/saveOrUpdate")
	public void saveOrUpdate(XlglHomepageSports xlglHomepageSports){
		JSONObject jsonObject = new JSONObject();
		SSOUser ssoUser = CurrentUser.getSSOUser();
		Date date = new Date();
		String id = xlglHomepageSports.getId();
		if(StringUtils.isNotBlank(id)){
			String creator = xlglHomepageSports.getCreateUser();
			if(creator.equals(ssoUser.getUserId())){
				jsonObject.put("isOpen",true);
			}else {
				jsonObject.put("isOpen",false);
			}
			xlglHomepageSportsService.update(xlglHomepageSports);
		}else {
			xlglHomepageSports.setId(UUIDUtils.random());
			xlglHomepageSports.setCreateUser(ssoUser.getUserId());
			xlglHomepageSports.setCreateDate(date);
			xlglHomepageSports.setUpdateUser(ssoUser.getUserId());
			xlglHomepageSports.setUpdateDate(date);
			xlglHomepageSports.setCreateUser(ssoUser.getUserId());
			xlglHomepageSports.setStatus("0");
			xlglHomepageSportsService.save(xlglHomepageSports);
		}
		jsonObject.put("result","success");
		jsonObject.put("xlglHomepageSports",xlglHomepageSports);
		Response.json(jsonObject);

	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public void update(XlglHomepageSports xlglHomepageSports){
		xlglHomepageSportsService.update(xlglHomepageSports);
		Response.ok();
	}
	
	/**
	 * 删除
	 *
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public void delete(String id){
		String[] ids = id.split(",");
		xlglHomepageSportsService.deleteBatch(ids);	
		Response.json("result","success");
	}

	/**
	 * 活动取消
	 *
	 */
	@ResponseBody
	@RequestMapping("/cacle")
	public void cacle(String id){
		xlglHomepageSportsService.cacle(id);
		Response.json("result","success");
	}


	
	/**
	 * 判断需要的人员是否已满
	 * */
	@ResponseBody
	@RequestMapping("/getNeedPerson")
	public void getNeedPerson(String id) {
		String status = "0";//人员已经满
		XlglHomepageSports xlglHomepageSports = xlglHomepageSportsService.queryObject(id);
		Map<String, Object> map = new HashMap<>();
		map.put("sportsId",id);
		//查询列表数据
		List<XlglHomepageSportsPerson> xlglHomepageSportsPersonList = xlglHomepageSportsPersonService.queryList(map);
		Integer number = 0;
		if(xlglHomepageSportsPersonList.size() >0) {
			number = xlglHomepageSportsPersonList.size();
		}
		if(xlglHomepageSports.getNeedNumber() >number) {
			status = "1";//人员未满
		}
		Response.json("status");
	}
	
}
