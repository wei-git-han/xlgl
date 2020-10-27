package com.css.app.xlgl.service.impl;

import com.css.app.xlgl.entity.XlglHomepageSports;
import com.css.base.entity.SSOUser;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.SpringContextUtils;
import com.css.base.utils.StringUtils;
import com.css.base.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.css.app.xlgl.dao.XlglHomepageSportsPersonDao;
import com.css.app.xlgl.entity.XlglHomepageSportsPerson;
import com.css.app.xlgl.service.XlglHomepageSportsPersonService;



@Service("xlglHomepageSportsPersonService")
public class XlglHomepageSportsPersonServiceImpl implements XlglHomepageSportsPersonService {
	@Autowired
	private XlglHomepageSportsPersonDao xlglHomepageSportsPersonDao;
	
	@Override
	public XlglHomepageSportsPerson queryObject(String id){
		return xlglHomepageSportsPersonDao.queryObject(id);
	}
	
	@Override
	public List<XlglHomepageSportsPerson> queryList(Map<String, Object> map){
		return xlglHomepageSportsPersonDao.queryList(map);
	}
	
	@Override
	public void save(XlglHomepageSportsPerson xlglHomepageSportsPerson){
		xlglHomepageSportsPersonDao.save(xlglHomepageSportsPerson);
	}
	
	@Override
	public void update(XlglHomepageSportsPerson xlglHomepageSportsPerson){
		xlglHomepageSportsPersonDao.update(xlglHomepageSportsPerson);
	}
	
	@Override
	public void delete(String id){
		xlglHomepageSportsPersonDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		xlglHomepageSportsPersonDao.deleteBatch(ids);
	}

	@Override
	public void deleteBySportIdAndUserId(String sportId,String userId){
		xlglHomepageSportsPersonDao.deleteBySportIdAndUserId(sportId,userId);
	}

	@Override
	public XlglHomepageSportsPerson queryByUserAndSportId(String sportId,String userId){
		return xlglHomepageSportsPersonDao.queryByUserAndSportId(sportId,userId);
	}


	
}
