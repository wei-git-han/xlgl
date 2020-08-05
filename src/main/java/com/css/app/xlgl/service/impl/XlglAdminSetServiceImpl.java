package com.css.app.xlgl.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.css.app.xlgl.dao.XlglAdminSetDao;
import com.css.app.xlgl.entity.XlglAdminSet;
import com.css.app.xlgl.service.XlglAdminSetService;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.StringUtils;



@Service("xlglAdminSetService")
public class XlglAdminSetServiceImpl implements XlglAdminSetService {
	@Autowired
	private XlglAdminSetDao adminSetDao;
	
	@Value("${csse.dccb.appId}")
	private  String appId;
	
	@Value("${csse.dccb.appSecret}")
	private  String clientSecret;
	
	@Override
	public XlglAdminSet queryObject(String id){
		return adminSetDao.queryObject(id);
	}
	
	@Override
	public List<XlglAdminSet> queryList(Map<String, Object> map){
		return adminSetDao.queryList(map);
	}
	
	@Override
	public void save(XlglAdminSet dbAdminSet){
		adminSetDao.save(dbAdminSet);
	}
	
	@Override
	public void update(XlglAdminSet dbAdminSet){
		adminSetDao.update(dbAdminSet);
	}
	
	@Override
	public void delete(String id){
		adminSetDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		adminSetDao.deleteBatch(ids);
	}

	@Override
	public List<XlglAdminSet> queryJuAdminList(String userId) {
		return adminSetDao.queryJuAdminList(userId);
	}

	@Override
	public List<String> queryUserIdByOrgId(String orgId) {
		return adminSetDao.queryUserIdByOrgId(orgId);
	}

	@Override
	public String getAdminTypeByUserId(String userId) {
		//管理员类型（0:超级管理员 ;1：部管理员；2：局管理员；3：即是部管理员又是局管理员;4:处管理员）
		String adminFlag = "";
		boolean admin = CurrentUser.getIsManager(appId, clientSecret);
		if(admin) {
			adminFlag="0";
		}else {
			//当前登录人的管理员类型
			Map<String, Object> adminMap = new HashMap<>();
			adminMap.put("userId",userId);
			List<XlglAdminSet> adminList = adminSetDao.queryList(adminMap);
			if(adminList != null && adminList.size()>0) {
				if(adminList.size()==1) {
					String adminType = adminList.get(0).getAdminType();
					adminFlag=adminType;
				}if(adminList.size()>1) {
					List<String> adminTypes=new ArrayList<String>();
					for(XlglAdminSet item:adminList){
						String adminType = item.getAdminType();
						adminTypes.add(adminType);
					}
					if(adminTypes.contains("1")){
						adminFlag="3";
					}else if(adminTypes.contains("2")&& !adminTypes.contains("1")){
						adminFlag="2";
					}
				}
			}
		}
		return adminFlag;
	}

	@Override
	public String getAgentLeagerId(String userId) {
		String agentLeaderId="";
		Map<String, Object> map = new HashMap<>();
		map.put("userId", userId);
		map.put("adminType", "1");
		List<XlglAdminSet> adminSets = adminSetDao.queryList(map);
		if (adminSets != null && adminSets.size() > 0) {
			XlglAdminSet adminSet = adminSets.get(0);
			if (StringUtils.isNotBlank(adminSet.getSeniorOfficial())) {
				agentLeaderId=adminSet.getSeniorOfficialId();				
			}
		}
		return agentLeaderId;
	}

	@Override
	public List<XlglAdminSet> queryChuAdminList(String userId) {
		// TODO Auto-generated method stub
		return adminSetDao.queryChuAdminList(userId);
	}
	
}
