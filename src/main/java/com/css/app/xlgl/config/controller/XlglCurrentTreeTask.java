package com.css.app.xlgl.config.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.css.addbase.apporgan.entity.BaseAppOrgan;
import com.css.addbase.apporgan.service.BaseAppOrganService;
import com.css.addbase.apporgan.util.RedisUtil;
import com.css.addbase.msg.MsgTipUtil;
import com.css.addbase.orgservice.OrgService;
import com.css.addbase.orgservice.Organ;
import com.css.app.xlgl.entity.TaskMenu;
import com.css.app.xlgl.service.TaskMenuService;
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
public class XlglCurrentTreeTask {
	// java 定时器
	private Timer timer = null;
	// 定时器任务
	private static TimerTask timerTask = null;
	// 定时器状态：true：定时器开启；false：定时器关闭
	private static boolean status = true;
	@Autowired
	private MsgTipUtil msgUtil;
	private final Logger logger = LoggerFactory.getLogger(XlglCurrentTreeTask.class);

	@Autowired
	private TaskMenuService taskMenuService;

	@Autowired
	private RedisUtil redisUtil;

	@Autowired
	private OrgService orgService;


	@Value("${csse.xlgl.appId}")
	private String appId;
	@Value("${csse.xlgl.appSecret}")
	private String clientSecret;

	@Autowired
	private BaseAppOrganService baseAppOrganService;


	/**
	 * 启动程序时默认启动定时同步 120000代表项目启动2分钟后开始启动定时程序 600000代表每隔5分钟定时程序扫描一次数据
	 */
	public XlglCurrentTreeTask() {
		if (timer == null) {
			timer = new Timer();
		}
		timer.scheduleAtFixedRate(getInstance(), 120000 , 300000);
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
		JSONArray arrayList = new JSONArray();
		List<BaseAppOrgan> organIdList = baseAppOrganService.queryAllDept("root");
		if(organIdList != null && organIdList.size() > 0){
			for(int i = 0;i<organIdList.size();i++){
				JSONObject list = new JSONObject();
				BaseAppOrgan baseAppOrgan = organIdList.get(i);
				String orgId = baseAppOrgan.getId();
				list = getOrganTree(orgId);
				JSONObject json = new JSONObject();
				json.put("opened", true);
				list.put("state", json);
				list.put("currentOrgId", "root");
				arrayList.add(list);
			}
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject = getOrganTree("root");
		arrayList.add(jsonObject);
		redisUtil.setString("xlglCurrentTreeTask",arrayList.toJSONString());
		long endTime = System.currentTimeMillis();
		System.out.println("app/xlgl/sysorgan/currenttree接口执行时间："+(endTime-starTime)+"毫秒!!!!!!!!!");
	}

	public JSONObject getOrganTree(String id){
		JSONObject result = new JSONObject();
		JSONArray jsons = new JSONArray();
		Organ organ = orgService.getOrgan(id);
		result.put("id", organ.getOrganId());
		result.put("text", organ.getOrganName());
		Organ[] organs = orgService.getSubOrg(id, true, true);
		for (Organ sysOrgan:organs) {
			JSONObject json = new JSONObject();
			json.put("id", sysOrgan.getOrganId());
			json.put("text", sysOrgan.getOrganName());
			jsons.add(getOrganTree(sysOrgan.getOrganId()));
		}
		if (jsons.size()>0) {
			result.put("children", jsons);
		}
		return result;
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
