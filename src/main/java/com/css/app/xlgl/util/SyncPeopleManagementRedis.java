package com.css.app.xlgl.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.css.addbase.apporgan.service.BaseAppOrganService;
import com.css.addbase.apporgan.service.BaseAppUserService;

import com.css.addbase.apporgmapped.service.BaseAppOrgMappedService;

import com.css.addbase.orgservice.OrgService;

import com.css.app.xlgl.service.PeopleManagementService;

import com.css.base.utils.Response;

/**
 * 组织机构导入接口
 * @author gengds
 */
@Component
@RequestMapping("/app/xlgl/syncPeople")
public class SyncPeopleManagementRedis {
	
	@Autowired
	private BaseAppOrganService baseAppOrganService;
	
	@Autowired
	private BaseAppUserService baseAppUserService;
	@Autowired
	private BaseAppOrgMappedService baseAppOrgMappedService;
	@Autowired
	private PeopleManagementService peopleManagementService;
	
	@Autowired
	private OrgService orgService;
	
	//自动同步时间
	private static Long starttime;
	//java 定时器
	private Timer timer = null;
	//定时器任务
	private static TimerTask timerTask = null;
	//定时器状态：true：定时器开启；false：定时器关闭
	private static boolean status = true;
	
	/**
	 * 启动程序时默认启动定时同步
	 *
	 */
	public void SyncOrganUtil() {
		if (timer == null) {
			 timer = new Timer();
		}
		timer.scheduleAtFixedRate(getInstance(), 12000,600000);
	}
	
	
	/**
	 * 获取定时任务
	 * @return
	 */
	public  TimerTask getInstance() {
		if (timerTask == null || !status) {
			status = true;
			timerTask = new TimerTask(){
				@Override
				public void run() {
					SyncTxlUserDto();
				}
			};
		}
		return timerTask;
	}
	
	/**
	 * 启动定时器
	 */
	@ResponseBody
	@RequestMapping("/start.htm")
	public void start() {
		if (!status) {
			timer.purge();
			timer = new Timer();
			timer.scheduleAtFixedRate(getInstance(), 120000,120000);
		}
	}
	
	/**
	 * 停止定时器
	 */
	@ResponseBody
	@RequestMapping("/cancel.htm")
	public void calcel() {
		timer.cancel();
		status = false;
	}
	
	/**
	 * 获取定时器状态
	 */
	@ResponseBody
	@RequestMapping("/status.htm")
	public void status() {
		if (status) {
			//定时器开启
			Response.json("status", true);
		} else {
			//定时器关闭
			Response.json("status",false);
		}
	}
	/**
	 * 刷新
	 */
	@ResponseBody
	@RequestMapping("/shuaxin")
	public void SyncRedis() {
		peopleManagementService.setTxlRedis();
		peopleManagementService.setQxjRedis();
		
	}
	/**
	 * 实现增量同步接口
	 */
	public void SyncTxlUserDto() {
		peopleManagementService.setTxlRedis();
		peopleManagementService.setQxjRedis();
		
	}
}
