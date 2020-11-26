 package com.css.app.xlgl.util;

import com.css.addbase.AppConfig;
import com.css.addbase.apporgan.dao.BaseAppUserDao;
import com.css.addbase.apporgan.entity.BaseAppUser;
import com.css.addbase.apporgmapped.entity.BaseAppOrgMapped;
import com.css.addbase.apporgmapped.service.BaseAppOrgMappedService;
import com.css.addbase.constant.AppConstant;
import com.css.addbase.msg.MsgTipUtil;
import com.css.app.xlgl.dao.SurveyQuestionCountDao;
import com.css.app.xlgl.dao.SurveyQuestionDao;
import com.css.app.xlgl.entity.SurveyQuestion;
import com.css.base.utils.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

 @Service("timer")
public class MsgTimer implements InitializingBean {

	@Autowired
	private SurveyQuestionCountDao surveyQuestionCountDao;
	@Autowired
	private AppConfig appConfig;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private MsgTipUtil msgUtil;
	@Autowired
	private BaseAppOrgMappedService baseAppOrgMappedService;
	@Autowired
	private SurveyQuestionDao surveyQuestionDao;
	@Value("${time.one}")
	private int timeOne;
	@Value("${time.two}")
	private int timeTwo;

	public MsgTimer() {
		
	}
	
	private void msg() {
		System.out.println(new Date());
		List<SurveyQuestion> surveyQuestions = surveyQuestionDao.queryList(null);
		List<BaseAppUser> baseAppUsersList = surveyQuestionCountDao.queryUnSjUserList();
		String userIds = "";
		if(baseAppUsersList!=null && baseAppUsersList.size()>0){
			for(BaseAppUser user: baseAppUsersList){
				userIds += "," + user.getId();
			}
			String gwclAppId = "";
			String gwclAppSecret = "";
			String url="";
			String id = "";
			if(surveyQuestions!=null && surveyQuestions.size()>0){
				id = surveyQuestions.get(0).getId();
			}
			BaseAppOrgMapped mapped = (BaseAppOrgMapped)baseAppOrgMappedService.orgMappedByOrgId("", "root", "xlgl");
			if (mapped != null) {
				gwclAppId = mapped.getAppId();
				gwclAppSecret = mapped.getAppSecret();
				url = mapped.getUrl() + "/app/index.html#/wjQuestion/index?id=" + id;
			}
			if(StringUtils.isNotBlank(userIds)){
				userIds = userIds.substring(1,userIds.length());
				System.out.println(userIds);
				System.out.println(url);
				msgUtil.sendMsg("您有一份调查问卷未填写，请尽快填写","您有一份调查问卷未填写，请尽快填写", url, userIds, gwclAppId,
						gwclAppSecret, "", "", "","true");
			}
		}
	}
	public Date addDay(Date date,int num){
		Calendar startDT = Calendar.getInstance();
		startDT.setTime(date);
		startDT.add(Calendar.DAY_OF_MONTH,num);
		return startDT.getTime();
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY,timeOne);
		calendar.set(Calendar.MINUTE,0);
		calendar.set(Calendar.SECOND,0);
		Date date = calendar.getTime();
		if(date.before(new Date())){
			date = this.addDay(date,1);
		}
		Timer timer = new Timer();
		timer.schedule(
				new TimerTask() {
					public void run() {
						msg();
					}
				},
				date,
				24*60*60*1000);
		calendar.set(Calendar.HOUR_OF_DAY,timeTwo);
		calendar.set(Calendar.MINUTE,0);
		calendar.set(Calendar.SECOND,0);
		date = calendar.getTime();
		if(date.before(new Date())){
			date = this.addDay(date,1);
		}
		Timer timer1 = new Timer();
		timer1.schedule(
				new TimerTask() {
					public void run() {
						msg();
					}
				},
				date,
				24*60*60*1000);
	}
}
