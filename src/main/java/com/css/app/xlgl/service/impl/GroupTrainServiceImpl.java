package com.css.app.xlgl.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.css.app.db.business.dao.DocumentZbjlDao;
import com.css.app.xlgl.dao.GroupTrainDao;
import com.css.app.xlgl.entity.GroupTrain;
import com.css.app.xlgl.service.GroupTrainService;
import org.apache.commons.lang.StringUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.css.base.utils.ZxPageUtils;

/** 
 * 
 * 
 */ 
@Service
public class GroupTrainServiceImpl implements  GroupTrainService{
	@Autowired
	private GroupTrainDao groupTrainDao;
	
	@Override
	public ZxPageUtils getByPage(HttpServletRequest request) {
		String title = request.getParameter("title");
		int pageSize = Integer.parseInt(request.getParameter("rows"));
		int currPage = Integer.parseInt(request.getParameter("page"));
		Map<String, Object> map = new HashMap<String, Object>();
//		if(StrKit.isBlank(strOrgID)){
//			logger.info("机构编号OrgID为空");
//			return map;
//		}
		if (StringUtils.isNotBlank(title)) {
			map.put("title", title);
		}
//		if (StrKit.notBlank(strSidx)) {
//			strOrderby = " order by " + strSidx + " " + strSord;
//		}else{
//			strOrderby = " ORDER BY  SortID";
//		}
		List<GroupTrain> list = groupTrainDao.queryList(map);
		int total = groupTrainDao.queryTotal(map);
		ZxPageUtils pageUtil = new ZxPageUtils(list, total, pageSize, currPage);
		
		return pageUtil;
	}
	
	@Override
	public GroupTrain queryObject(String id){
		return groupTrainDao.queryObject(id);
	}
	
	@Override
	public void save(GroupTrain tGroupTrain){
		groupTrainDao.save(tGroupTrain);
	}
	
	@Override
	public void update(GroupTrain tGroupTrain){
		groupTrainDao.update(tGroupTrain);
	}
	
	@Override
	public void delete(String id){
		groupTrainDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		groupTrainDao.deleteBatch(ids);
	}

	@Override
	public String fabu(HttpServletRequest request) {
		JSONObject json = new JSONObject();
	    json.put("flag", false);
	    json.put("message", "发布失败");
    	String idstr = request.getParameter("id");
    	if(StringUtils.isNotEmpty(idstr)) {
			String[] ids = idstr.split(",");
			for (String id : ids) {
				groupTrainDao.fabu(id);
			}
			json.put("flag", true);
			json.put("message", "发布成功");
		}
		return json.toString();
	}

}
