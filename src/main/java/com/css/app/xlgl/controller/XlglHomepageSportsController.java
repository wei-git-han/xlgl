package com.css.app.xlgl.controller;

import java.text.SimpleDateFormat;
import java.util.*;

import com.css.app.xlgl.entity.XlglHomepageSportsRead;
import com.css.app.xlgl.service.XlglHomepageSportsReadService;
import com.css.base.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.css.addbase.apporgan.entity.BaseAppUser;
import com.css.addbase.apporgan.service.BaseAppUserService;
import com.css.app.xlgl.entity.XlglHomepageSports;
import com.css.app.xlgl.entity.XlglHomepageSportsPerson;
import com.css.app.xlgl.service.XlglHomepageSportsPersonService;
import com.css.app.xlgl.service.XlglHomepageSportsService;
import com.css.base.entity.SSOUser;
import com.github.pagehelper.PageHelper;


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
	@Autowired
	private XlglHomepageSportsReadService xlglHomepageSportsReadService;
	@Autowired
	private BaseAppUserService baseAppUserService;
	
	/**
	 * 列表
	 * type:0:全部，1.报名中；2.已报名；3.组局成功
	 */
	@ResponseBody
	@RequestMapping("/list")
	public void list(Integer page, Integer limit,String type,String updateDate,String sportsName) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String userId = CurrentUser.getUserId();
		Map<String, Object> map = new HashMap<>();
		if (StringUtils.isNotBlank(type) && "3".equals(type)) {
			map.put("zjcg", type);//组局成功
		}
		if (StringUtils.isNotBlank(type) && "1".equals(type)) {
			map.put("bmz", type);//报名中
		}
		if (StringUtils.isNotBlank(type) && "2".equals(type)) {
			map.put("ybm", type);
		}
		if (StringUtils.isNotBlank(updateDate)) {
			map.put("time", updateDate);
		}else {
			map.put("time",simpleDateFormat.format(new Date()));
		}
		if (StringUtils.isNotBlank(sportsName)) {
			map.put("projectName", sportsName);
		}
		map.put("userId",userId);
		PageHelper.startPage(page, limit);
		//查询列表数据
		List<XlglHomepageSports> xlglHomepageSportsList = xlglHomepageSportsService.queryList(map);
		if ("3".equals(type) || "2".equals(type)) {//组局成功是从所有组局成功中，删除不是当前登录人的数据；已报名也是从所有数据中，删除不是当前登录人的
			if (xlglHomepageSportsList != null && xlglHomepageSportsList.size() > 0) {
				for (int i = 0; i < xlglHomepageSportsList.size(); i++) {
					String sportId = xlglHomepageSportsList.get(i).getId();
					int needNumber = xlglHomepageSportsList.get(i).getNeedNumber();
					int haveNumber = 0;
					if(xlglHomepageSportsList.get(i).getHaveNumber() == null){
						haveNumber = 0;
					}else {
						haveNumber = xlglHomepageSportsList.get(i).getHaveNumber();
					}
					if (needNumber == haveNumber) {
						xlglHomepageSportsList.get(i).setStatus("1");
					} else {
						xlglHomepageSportsList.get(i).setStatus("0");
					}

					XlglHomepageSportsPerson xlglHomepageSportsPerson = xlglHomepageSportsPersonService.queryByUserAndSportId(sportId, userId);
					if (xlglHomepageSportsPerson == null) {
						xlglHomepageSportsList.remove(i);
						i--;
					} else {
						xlglHomepageSportsList.get(i).setType(true);
					}
				}
			}
		}

		for (XlglHomepageSports xlglHomepageSports : xlglHomepageSportsList) {
			String sportId = xlglHomepageSports.getId();
			XlglHomepageSportsPerson xlglHomepageSportsPerson = xlglHomepageSportsPersonService.queryByUserAndSportId(sportId, userId);
			if (xlglHomepageSportsPerson != null) {
				xlglHomepageSports.setType(true);
			}
			String creator = xlglHomepageSports.getUpdateUser();
			if (userId.equals(creator)) {
				xlglHomepageSports.setIsOpen(true);
			} else {
				xlglHomepageSports.setIsOpen(false);
			}
			List list = new ArrayList();
			String people = xlglHomepageSports.getPeoples();
			if (StringUtils.isNotBlank(people)) {
				String[] peoples = people.split(",");
				if (peoples != null && peoples.length > 0) {
					for (int i = 0; i < peoples.length; i++) {
						if(StringUtils.isNotBlank(peoples[i])){
							list.add(peoples[i]);
						}

					}
				}
			}
			xlglHomepageSports.setAllPeople(list);
		}

		for(XlglHomepageSports xlglHomepageSports : xlglHomepageSportsList){
			String sportId = xlglHomepageSports.getId();
			XlglHomepageSportsRead xlglHomepageSportsRead = xlglHomepageSportsReadService.queryBySportAndUserId(sportId,userId);
			if(xlglHomepageSportsRead != null){
				xlglHomepageSports.setRead("1");
			}else{
				xlglHomepageSports.setRead("0");
			}
			BaseAppUser queryObject = baseAppUserService.queryObject(xlglHomepageSports.getCreateUser());
			if(queryObject != null) {
				xlglHomepageSports.setCreateUser(queryObject.getTruename());
			}
		}
			PageUtils pageUtil = new PageUtils(xlglHomepageSportsList);
			Response.json("page", pageUtil);

	}

	/**
	 * 首页是否显示红点
	 * 0是都已读了，1是有未读的数据
	 */
	@ResponseBody
	@RequestMapping("/isRead")
	public void getIsRead(){
		String flag = "0";
		String userId = CurrentUser.getUserId();
		Map<String, Object> map = new HashMap<>();
		List<XlglHomepageSports> xlglHomepageSportsList = xlglHomepageSportsService.queryList(map);
		if(xlglHomepageSportsList != null && xlglHomepageSportsList.size() > 0){
			for(XlglHomepageSports xlglHomepageSports : xlglHomepageSportsList){
				String sportId = xlglHomepageSports.getId();
				XlglHomepageSportsRead xlglHomepageSportsRead = xlglHomepageSportsReadService.queryBySportAndUserId(sportId,userId);
				if(xlglHomepageSportsRead == null){
					flag = "1";
					break;
				}
			}
		}
		Response.json("flag",flag);
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
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String curDay = format.format(new Date());
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
			//xlglHomepageSports.setUpdateDate(curDay);
			xlglHomepageSports.setCreateUser(ssoUser.getUserId());
			xlglHomepageSportsService.update(xlglHomepageSports);
			//每次更新后，删除已读表的该体育活动的人员已读信息
			xlglHomepageSportsReadService.deleteBySportId(id);

		}else {
			String sportId = UUIDUtils.random();
			xlglHomepageSports.setId(sportId);
			xlglHomepageSports.setCreateUser(CurrentUser.getUserId());
			xlglHomepageSports.setCreateDate(curDay);
			xlglHomepageSports.setUpdateUser(CurrentUser.getUserId());
			//xlglHomepageSports.setUpdateDate(curDay);
			xlglHomepageSports.setStatus("0");
			xlglHomepageSports.setType(false);
			xlglHomepageSports.setOrgName(CurrentUser.getOrgName());
			xlglHomepageSportsService.save(xlglHomepageSports);
			//创建人创建后，自动报名
			xlglHomepageSportsService.baoming(sportId);
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
	public void cacle(String sportId){
		xlglHomepageSportsService.cacle(sportId);
		XlglHomepageSports xlglHomepageSports = xlglHomepageSportsService.queryObject(sportId);
		if(xlglHomepageSports != null){
			xlglHomepageSports.setStatus("2");
		}
		xlglHomepageSportsService.update(xlglHomepageSports);
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
