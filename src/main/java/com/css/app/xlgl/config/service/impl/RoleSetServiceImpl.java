package com.css.app.xlgl.config.service.impl;

import com.css.app.db.util.DbDefined;
import com.css.app.xlgl.config.dao.RoleSetDao;
import com.css.app.xlgl.config.entity.RoleSet;
import com.css.app.xlgl.config.service.RoleSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("roleSetService")
public class RoleSetServiceImpl implements RoleSetService {
	@Autowired
	private RoleSetDao roleSetDao;
	
	@Override
	public RoleSet queryObject(String id){
		return roleSetDao.queryObject(id);
	}
	
	@Override
	public List<RoleSet> queryList(Map<String, Object> map){
		return roleSetDao.queryList(map);
	}
	
	@Override
	public void save(RoleSet dbRoleSet){
		roleSetDao.save(dbRoleSet);
	}
	
	@Override
	public void update(RoleSet dbRoleSet){
		roleSetDao.update(dbRoleSet);
	}
	
	@Override
	public void delete(String id){
		roleSetDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		roleSetDao.deleteBatch(ids);
	}

	@Override
	public int deleteByUserId(String userId) {
		return roleSetDao.deleteByUserId(userId);
	}

	@Override
	public String getRoleTypeByUserId(String userId) {
		String roleType = DbDefined.ROLE_6;//角色标识（1：首长；2：首长秘书；3：局长；4：局秘书；5：处长；6：参谋;）
		Map<String, Object> roleMap = new HashMap<>();
		roleMap.put("userId", userId);
		List<RoleSet> roleList = roleSetDao.queryList(roleMap);
		if(roleList != null && roleList.size()>0) {
			roleType = roleList.get(0).getRoleFlag();
		}
		return roleType;
	}
	
}
