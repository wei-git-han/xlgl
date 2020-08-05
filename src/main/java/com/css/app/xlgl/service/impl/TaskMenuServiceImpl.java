package com.css.app.xlgl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.css.app.xlgl.dao.TaskMenuDao;
import com.css.app.xlgl.entity.TaskMenu;
import com.css.app.xlgl.service.TaskMenuService;

import java.util.List;
import java.util.Map;




@Service("taskMenuService")
public class TaskMenuServiceImpl implements TaskMenuService {
	@Autowired
	private TaskMenuDao taskMenuDao;
	
	@Override
	public TaskMenu queryObject(String menuId){
		return taskMenuDao.queryObject(menuId);
	}
	
	@Override
	public List<TaskMenu> queryList(Map<String, Object> map){
		return taskMenuDao.queryList(map);
	}
	
	@Override
	public void save(TaskMenu taskMenu){
		taskMenuDao.save(taskMenu);
	}
	
	@Override
	public void update(TaskMenu taskMenu){
		taskMenuDao.update(taskMenu);
	}
	
	@Override
	public void delete(String menuId){
		taskMenuDao.delete(menuId);
	}
	
	@Override
	public void deleteBatch(String[] menuIds){
		taskMenuDao.deleteBatch(menuIds);
	}
	
}
