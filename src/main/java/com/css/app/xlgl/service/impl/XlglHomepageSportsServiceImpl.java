package com.css.app.xlgl.service.impl;

import com.css.app.xlgl.entity.XlglHomepageSportsPerson;
import com.css.app.xlgl.service.XlglHomepageSportsPersonService;
import com.css.base.entity.SSOUser;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.StringUtils;
import com.css.base.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.css.app.xlgl.dao.XlglHomepageSportsDao;
import com.css.app.xlgl.entity.XlglHomepageSports;
import com.css.app.xlgl.service.XlglHomepageSportsService;



@Service("xlglHomepageSportsService")
public class XlglHomepageSportsServiceImpl implements XlglHomepageSportsService {
	@Autowired
	private XlglHomepageSportsDao xlglHomepageSportsDao;

	@Autowired
	private XlglHomepageSportsPersonService xlglHomepageSportsPersonService;
	
	@Override
	public XlglHomepageSports queryObject(String id){
		return xlglHomepageSportsDao.queryObject(id);
	}
	
	@Override
	public List<XlglHomepageSports> queryList(Map<String, Object> map){
		return xlglHomepageSportsDao.queryList(map);
	}
	
	@Override
	public void save(XlglHomepageSports xlglHomepageSports){
		xlglHomepageSportsDao.save(xlglHomepageSports);
	}
	
	@Override
	public void update(XlglHomepageSports xlglHomepageSports){
		xlglHomepageSportsDao.update(xlglHomepageSports);
	}
	
	@Override
	public void delete(String id){
		xlglHomepageSportsDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		xlglHomepageSportsDao.deleteBatch(ids);
	}

	@Override
	public void cacle(String id){
		xlglHomepageSportsDao.cacle(id);
	}

	@Override
	public void baoming(String sportId){
		XlglHomepageSportsPerson xlglHomepageSportsPerson = new XlglHomepageSportsPerson();
		String name = "";
		//保存接口
		SSOUser ssoUser = CurrentUser.getSSOUser();
		Date date = new Date();
		xlglHomepageSportsPerson.setId(UUIDUtils.random());
		xlglHomepageSportsPerson.setUserId(ssoUser.getUserId());
		xlglHomepageSportsPerson.setUserName(ssoUser.getFullname());
		xlglHomepageSportsPerson.setOrganId(ssoUser.getOrganId());
		xlglHomepageSportsPerson.setOrganName(ssoUser.getOrgName());
		xlglHomepageSportsPerson.setCreateDate(date);
		xlglHomepageSportsPerson.setCreateUser(ssoUser.getUserId());
		xlglHomepageSportsPerson.setSportsId(sportId);
		xlglHomepageSportsPersonService.save(xlglHomepageSportsPerson);

		XlglHomepageSports queryObject = xlglHomepageSportsDao.queryObject(xlglHomepageSportsPerson.getSportsId());
		Map<String, Object> map = new HashMap<>();
		map.put("sportsId",queryObject.getId());
		//查询列表数据
		List<XlglHomepageSportsPerson> xlglHomepageSportsPersonList = xlglHomepageSportsPersonService.queryList(map);
		Integer number = 0;
		if(xlglHomepageSportsPersonList.size() >0) {
			number = xlglHomepageSportsPersonList.size();
		}
		queryObject.setHaveNumber(number);
		if(queryObject.getNeedNumber().equals(number)){
			queryObject.setStatus("1");
		}else {
			queryObject.setStatus("0");
		}
		String currentName = queryObject.getPeoples();
		if(StringUtils.isNotBlank(currentName)){
			name = currentName+","+CurrentUser.getUsername();
		}else {
			name = CurrentUser.getUsername();
		}
		queryObject.setPeoples(name);
		xlglHomepageSportsDao.update(queryObject);
	}


	
}
