package com.css.app.db.config.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.css.app.db.config.dao.MenuDao;
import com.css.app.db.config.entity.Menu;
import com.css.app.db.config.service.MenuService;



@Service("menuService")
public class MenuServiceImpl implements MenuService {
	@Autowired
	private MenuDao menuDao;
	
	@Override
	public Menu queryObject(String id){
		return menuDao.queryObject(id);
	}
	
	@Override
	public List<Menu> queryList(Map<String, Object> map){
		return menuDao.queryList(map);
	}
	
	@Override
	public void save(Menu dbMenu){
		menuDao.save(dbMenu);
	}
	
	@Override
	public void update(Menu dbMenu){
		menuDao.update(dbMenu);
	}
	
	@Override
	public void delete(String id){
		menuDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		menuDao.deleteBatch(ids);
	}
	
}
