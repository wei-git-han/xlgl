package com.css.app.xlgl.sportstrain.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.css.app.xlgl.sportstrain.entity.TGroupActivePublish;
import com.css.app.xlgl.sportstrain.entity.TGroupApplyRecord;
import com.css.app.xlgl.sportstrain.entity.User;
import com.css.app.xlgl.sportstrain.service.SportsTrainService;
import com.css.app.xlgl.sportstrain.service.TGroupActivePublishService;
import com.css.app.xlgl.sportstrain.service.TGroupApplyRecordService;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.Response;
import com.css.base.utils.UUIDUtils;


@RestController
@RequestMapping("/sportstrain")
public class SportsTrainController {

	@Autowired
	private SportsTrainService SportsTrainService;
	
	@Autowired
	private TGroupApplyRecordService tGroupApplyRecordService;
	
	@Autowired
	private TGroupActivePublishService tGroupActivePublishService;
	
	Logger logger = Logger.getLogger(SportsTrainController.class);
	
	/**
     * 增改删记录
     * HttpServletRequest request
     */
	@RequestMapping("/edit")
    public void edit(String oper,String act_id,String sportsTrain_title,
    		String sportsTrain_active_from_day,String sportsTrain_active_to_day,String sportsTrain_active_from_time
    		,String sportsTrain_active_to_time,String sportsTrain_place,String sportsTrain_active_ending_day
    		,String sportsTrain_people_number,String sportsTrain_content,String sportsTrain_act_id) {
        //oper：add 增、del 删、edit 改
		JSONObject json = new JSONObject();
        if (StringUtils.isEmpty(oper)) Response.json(json);
        json.put("flag", false); 
	    if (StringUtils.equals(oper, "add")) {
	    	Map map = new HashMap();
	    	map.put("act_id", UUIDUtils.random());
	    	map.put("title", sportsTrain_title);//标题
	    	map.put("active_from_day", sportsTrain_active_from_day);//活动开始日期(年月日)
	    	map.put("active_to_day", sportsTrain_active_to_day);//活动结束日期(年月日)
	    	map.put("active_from_time", sportsTrain_active_from_time);//活动开始时间(时分秒)
	    	map.put("active_to_time", sportsTrain_active_to_time);//活动结束时间(时分秒)
	    	map.put("place", sportsTrain_place);//活动地点
	    	if ("".equals(sportsTrain_people_number)||sportsTrain_people_number==null) {
	    		String people_number = "--";
	    		map.put("people_number", people_number);
			}else {
				map.put("people_number", sportsTrain_people_number);//活动最大参加人数
			}
	    	map.put("active_ending_day", sportsTrain_active_ending_day);//活动报名截止时间
	    	map.put("content", sportsTrain_content);//活动开始时间
	    	map.put("active_status", "1");//进行中
	    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    	String t = sdf.format(new Date());
	    	map.put("create_time", t);//活动创建时间
	    	try {
	    		SportsTrainService.save(map);
	    		json.put("flag", true);
	    		json.put("message", "活动发布成功");
	    	}catch(Exception e) {
	    		json.put("message", "活动发布失败，请联系管理员");
	    	}
	    }else if (StringUtils.equals(oper, "edit")) {
	    	Map map = new HashMap();
	    	map.put("act_id", act_id);
	    	if ("".equals(sportsTrain_people_number)||sportsTrain_people_number==null) {
	    		String people_number = "--";
	    		map.put("people_number", people_number);
			}
	    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    	String t = sdf.format(new Date());
	    	map.put("update_time", t);
	    	try {
	    		SportsTrainService.update(map);
	    		json.put("flag", true);
	    		json.put("message", "活动更新成功");
	    	}catch(Exception e) {
	    		json.put("message", "活动更新失败，请联系管理员");
	    	}
	    } else if (StringUtils.equals(oper, "del")) {
	    	try {
	    		tGroupActivePublishService.delete(act_id);
//	    		SportsTrainService.delete(act_id);
	    		json.put("flag", true);
	    		json.put("message", "删除成功");
	    	}catch(Exception e) {
	    		json.put("message", "删除失败，无记录");
	    	}
	    } 
	    Response.json(json);
    }
	
	/**
     * 获取分页数据
     */
    public void getPageByType(String _search,String nd,String rows,String page,String sidx,String sord) {
        JSONObject json = new JSONObject();
        int iPage = Integer.parseInt(page);
        int iRows = Integer.parseInt(rows);
        try {
        	List<TGroupActivePublish> list = SportsTrainService.sel(iPage,iRows);
        	int total = list.size() / iRows + (list.size() % iRows == 0 ? 0 : 1);
        	json.put("rows", list);
        	json.put("total", Integer.valueOf(total));
        	json.put("page", Integer.valueOf(iPage));
        	json.put("records", list.size());
        } catch (Exception e) {
            this.logger.error("SportsTrainController分页获取数据错误");
            e.printStackTrace();
        }
        Response.json(json);
    }
    
    /**
     * 控制台活动发布列表
     */
    public void getActivePublishDetail() {
        List<TGroupActivePublish> list = SportsTrainService.getActivePublishList();
        Response.json(list);
    }
    
    /**
     * 首页展示当前日期之后的活动发布列表
     */
    public void getPageActivePublish() {
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	String t = sdf.format(new Date());
    	String curdate = t.substring(0,10);
        List<TGroupActivePublish> activePublishList = SportsTrainService.getPageActivePublishList(curdate);
        List<String> actidList = new ArrayList<String>();
        if (activePublishList != null && !activePublishList.isEmpty()) {
            for (TGroupActivePublish daoTemp : activePublishList) {
            	actidList.add(daoTemp.getActId());
            }
        }        	
        
        String userId = CurrentUser.getUserId();
        List<TGroupApplyRecord> applyStatusList = new ArrayList<TGroupApplyRecord>();
        for (int i = 0; i < actidList.size(); i++) {
        	String str = actidList.get(i);
            List<TGroupApplyRecord> pageApplyStatusList = SportsTrainService.getPageApplyStatus(str,userId);
            TGroupApplyRecord record = new TGroupApplyRecord();
    	        	if (pageApplyStatusList == null || pageApplyStatusList.isEmpty()||pageApplyStatusList.size()==0) {
    	        		record.setApplyStatus("0");
    	        	}else {
    	        		record.setApplyStatus(pageApplyStatusList.get(0).getApplyStatus());
    				}
    	        	applyStatusList.add(record);
    	        }
        String list = "";
		for (int i = 0; i < actidList.size(); i++) {
			if (i != (actidList.size() - 1)) {
				list += "'" + actidList.get(i) + "',";
			} else {
				list += "'" + actidList.get(i) + "'";
			}
		}
		List<TGroupApplyRecord> applyUserNum = new ArrayList<TGroupApplyRecord>();
		for (int i = 0; i < actidList.size(); i++) {
			    	String str = actidList.get(i);
			        List<TGroupApplyRecord> pageActivePublishList = SportsTrainService.getapplyUserNumList(str);
			        TGroupApplyRecord record = new TGroupApplyRecord();
	        		record.setPeopleNumber(pageActivePublishList.get(0).getPeopleNumber());
	        		applyUserNum.add(record);
	        }
        
        JSONObject json = new JSONObject();
        json.put("applyStatusList",applyStatusList);//报名按钮置灰0未报名，1
        json.put("activePublishList",activePublishList);//列表展示
        json.put("applyUserNum",applyUserNum);//报名人数
        Response.json(json);
    }
    
    /**
     * 根据活动开始日期查询对应活动列表
     */
    public void getActiveByDate(String active_from_day) {
        List<TGroupActivePublish> activePublishList = SportsTrainService.getActiveListByDate(active_from_day);
        List<String> actidList = new ArrayList<String>();
        if (activePublishList != null && !activePublishList.isEmpty()) {
            for (TGroupActivePublish daoTemp : activePublishList) {
            	actidList.add(daoTemp.getActId());
            }
        }
		String userId = CurrentUser.getUserId();
		List<TGroupApplyRecord> applyStatusList = new ArrayList<TGroupApplyRecord>();
        for (int i = 0; i < actidList.size(); i++) {
        	String str = actidList.get(i);
            List<TGroupApplyRecord> pageApplyStatusList = SportsTrainService.getPageApplyStatus(str,userId);
            TGroupApplyRecord record = new TGroupApplyRecord();
    	        	if (pageApplyStatusList == null || pageApplyStatusList.isEmpty()||pageApplyStatusList.size()==0) {
    	        		record.setApplyStatus("0");
    	        	}else {
    	        		record.setApplyStatus(pageApplyStatusList.get(0).getApplyStatus());
    				}
    	        	applyStatusList.add(record);
    	        }
        String list = "";
		for (int i = 0; i < actidList.size(); i++) {
			if (i != (actidList.size() - 1)) {
				list += "'" + actidList.get(i) + "',";
			} else {
				list += "'" + actidList.get(i) + "'";
			}
		}
		List<TGroupApplyRecord> applyUserNum = new ArrayList<TGroupApplyRecord>();
		for (int i = 0; i < actidList.size(); i++) {
			    	String str = actidList.get(i);
			        List<TGroupApplyRecord> pageActivePublishList = SportsTrainService.getapplyUserNumList(str);
			        TGroupApplyRecord record = new TGroupApplyRecord();
	        		record.setPeopleNumber(pageActivePublishList.get(0).getPeopleNumber());
	        		applyUserNum.add(record);
	        }
        
		JSONObject json = new JSONObject();
        json.put("applyStatusList",applyStatusList);//报名按钮置灰0未报名，1
        json.put("activePublishList",activePublishList);
        json.put("applyUserNum",applyUserNum);
        Response.json(json);
    }
    
    /**
     * 获取全部日期红点
     */
    public void getDateRedPoints() {
            List<TGroupActivePublish> getdayList = SportsTrainService.getdayList();
            List<String> dayList = new ArrayList<String>();
            if (getdayList != null && !getdayList.isEmpty()) {
                for (TGroupActivePublish daoTemp : getdayList) {
                	dayList.add(daoTemp.getActiveFromDay());
                }
            }
        Response.json(dayList);
    }
    
    /**
     * 根据活动id查询活动内容页
     */
    public void getActiveContent(String actid) {
    	TGroupApplyRecord activeContent = SportsTrainService.getActiveContentData(actid);
        Response.json(activeContent);
    }
    
    /**
     * 根据活动id查询当前活动内容页报名人数
     */
    public void getApplyUserNum(String actid) {
    	TGroupApplyRecord UserNum = SportsTrainService.getApplyUserNumber(actid);
		Response.json(UserNum);  
    }
    
    /**
	 * 根据局id查询当前登录用户是否已报名
	 */
	public void userApplyYN() {
		String userId = CurrentUser.getUserId();
		int yn = SportsTrainService.getUserApplyYN(userId);
		Response.json(yn);
    }
	
	/**
     * 个人用户报名
     */
    public void userApply(String actid) {
		String userid = CurrentUser.getUserId();
		String username = CurrentUser.getUsername();
		Map map = new HashMap();
		JSONObject json = new JSONObject();
	    json.put("flag", false);
	    List<User> userList = SportsTrainService.selUser(userid);
        	User user = userList.get(0);
        	TGroupApplyRecord tGroupApplyRecord = new TGroupApplyRecord();
        	tGroupApplyRecord.setId(UUIDUtils.random());
        	tGroupApplyRecord.setActId(actid);
        	tGroupApplyRecord.setUserId(userid);
        	tGroupApplyRecord.setUserName(username);
        	tGroupApplyRecord.setDeptId(user.getORGID());

			String orgname = SportsTrainService.getOrgName(user.getORGID());
			tGroupApplyRecord.setDept(orgname);
			tGroupApplyRecord.setApplyStatus("1");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    	String t = sdf.format(new Date());
			tGroupApplyRecord.setApplyTime(t);
			try {
				tGroupApplyRecordService.save(tGroupApplyRecord);
				json.put("flag", true);
	    		json.put("message", "个人用户报名成功");
			}catch(Exception e) {
				json.put("message", "个人用户报名失败，请联系管理员");
			}
	    Response.json(json);
    }
    
    /**
     * 报名列表详情
     */
    public void getApplyRecordDetail(String actid) {
        Map<String, Object> map = new HashMap<String, Object>();
            List<TGroupApplyRecord> userApplyList = SportsTrainService.getUserApplyList(actid);
            Response.json(userApplyList);
    }
	
}
