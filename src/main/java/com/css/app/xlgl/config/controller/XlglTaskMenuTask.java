package com.css.app.xlgl.config.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.css.addbase.apporgan.util.RedisUtil;
import com.css.addbase.msg.MsgTipUtil;
import com.css.app.xlgl.config.entity.XlglMsgRemind;
import com.css.app.xlgl.config.service.XlglMsgRemindService;
import com.css.app.xlgl.entity.TaskMenu;
import com.css.app.xlgl.entity.XlglSubDocTracking;
import com.css.app.xlgl.service.TaskMenuService;
import com.css.app.xlgl.service.XlglSubDocTrackingService;
import com.css.base.utils.Response;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 提醒消息定时任务
 */
@Component
public class XlglTaskMenuTask {
	// java 定时器
	private Timer timer = null;
	// 定时器任务
	private static TimerTask timerTask = null;
	// 定时器状态：true：定时器开启；false：定时器关闭
	private static boolean status = true;
	@Autowired
	private MsgTipUtil msgUtil;
	private final Logger logger = LoggerFactory.getLogger(XlglTaskMenuTask.class);

	@Autowired
	private TaskMenuService taskMenuService;

	@Autowired
	private RedisUtil redisUtil;


	@Value("${csse.xlgl.appId}")
	private String appId;
	@Value("${csse.xlgl.appSecret}")
	private String clientSecret;


	/**
	 * 启动程序时默认启动定时同步 120000代表项目启动2分钟后开始启动定时程序 600000代表每隔10分钟定时程序扫描一次数据
	 */
	public XlglTaskMenuTask() {
		if (timer == null) {
			timer = new Timer();
		}
		timer.scheduleAtFixedRate(getInstance(), 120000 , 600000);
	}

	/**
	 * 启动定时器
	 */
	public void start() {
		if (!status) {
			timer.purge();
			timer = new Timer();
			timer.scheduleAtFixedRate(getInstance(), 3600000, 3600000);
		}
	}

	/**
	 * 获取定时器状态
	 */
	public void status() {
		if (status) {
			// 定时器开启
			Response.json("status", true);
		} else {
			// 定时器关闭
			Response.json("status", false);
		}
	}

	/**
	 * 停止定时器
	 */
	public void calcel() {
		timer.cancel();
		status = false;
	}

	/**
	 * 获取定时任务
	 * 
	 * @return
	 */
	public TimerTask getInstance() {
		if (timerTask == null || !status) {
			status = true;
			timerTask = new TimerTask() {
				@Override
				public void run() {
					timingTask();
				}
			};
		}
		return timerTask;
	}

	/**
	 * 提醒消息业务代码
	 */
	public void timingTask() {
			long starTime = System.currentTimeMillis();
			JSONArray list = getOrganTree("root");
			long endTime = System.currentTimeMillis();
			System.out.println("app/xlgl/taskmenu/menutree4role接口执行时间："+(endTime-starTime)+"毫秒!!!!!!!!!");
			redisUtil.setString("xlgl-taskMenu",list.toJSONString());
	}

	public JSONArray getOrganTree(String id) {
		JSONArray jsons = new JSONArray();
		List<TaskMenu> menus = taskMenuService.findByParentId(id);
		for (TaskMenu menu : menus) {
			JSONObject json = new JSONObject();
			json.put("id", menu.getMenuId());
			json.put("text", menu.getDisplayName());
			JSONArray children = getOrganTree(menu.getMenuId());
			if (children.size() > 0) {
				json.put("children", children);
			}
			jsons.add(json);
		}
		return jsons;
	}

	private String getNewDate() {
		Date toDay = new Date();
		SimpleDateFormat f = new SimpleDateFormat("HH:mm");
		String format = f.format(toDay);
		return format;
	}

	private boolean  getMinusDate(String remind){
		if(StringUtils.isEmpty(remind)){
			return false;
		}
		int minute = 0;
		SimpleDateFormat format  = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		SimpleDateFormat dayformat  = new SimpleDateFormat("yyyy-MM-dd");
		String curDay = dayformat.format(new Date());
		String remindDate=curDay+" "+remind;
		System.out.println("配置时间："+remindDate);
		String curDate = format.format(new Date());
		System.out.println("当前时间："+curDate);
		try {
			long remindTime = format.parse(remindDate).getTime();
			long curTime = format.parse(curDate).getTime();
			long  minusTime = curTime - remindTime;
			minute = (int) minusTime/(1000*60);
			System.out.println("当前时间减配置时间所差分钟数："+minute);
			if(minute<10 && minute>=0){
				return true;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;

	}
	private void setMsg(String userId, String msgUrl, String content) {
		if (userId != null) {
			msgUtil.sendMsg("训练管理", content, msgUrl, userId, appId, clientSecret, "参训受训", "", "", "true");
		}
	}

	private boolean getMinusTime(String sTime, String eTime) {
		System.out.println("配置开始时间："+sTime+"配置结束时间："+eTime);
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String nowDate = simpleDateFormat.format(date);
		System.out.println("当前时间："+nowDate);
		Date now;
		Date start = null;
		Date end = null;
		try {
			now = simpleDateFormat.parse(nowDate);
			if (!StringUtils.isEmpty(sTime)) {
				start = simpleDateFormat.parse(sTime);
			}
			if (!StringUtils.isEmpty(eTime)) {
				end = simpleDateFormat.parse(eTime);
			}
			long nowTime = now.getTime();
			long startTime = start.getTime();
			long endTime = end.getTime();
			if (nowTime>=startTime && nowTime <= endTime) {
				return true;
			} else {
				return false;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;
	}

}
