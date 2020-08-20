package com.css.app.xlgl.service.impl;

import com.css.app.xlgl.dao.XlglRuleDao;
import com.css.app.xlgl.entity.XlglRule;
import com.css.app.xlgl.service.XlglRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;




@Service("xlglRuleService")
public class XlglRuleServiceImpl implements XlglRuleService {
	@Autowired
	private XlglRuleDao xlglRuleDao;
	
	@Override
	public XlglRule queryObject(String id){
		return xlglRuleDao.queryObject(id);
	}
	
	@Override
	public List<XlglRule> queryList(Map<String, Object> map){
		return xlglRuleDao.queryList(map);
	}
	
	@Override
	public void save(XlglRule xlglRule){
		xlglRuleDao.save(xlglRule);
	}
	
	@Override
	public void update(XlglRule xlglRule){
		xlglRuleDao.update(xlglRule);
	}
	
	@Override
	public void delete(String id){
		xlglRuleDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		xlglRuleDao.deleteBatch(ids);
	}
	
}
