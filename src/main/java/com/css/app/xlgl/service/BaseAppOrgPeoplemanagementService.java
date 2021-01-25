package com.css.app.xlgl.service;

import com.css.app.xlgl.entity.BaseAppOrgPeoplemanagement;

import java.util.List;
import java.util.Map;

/**
 * 某局下新增处级单位
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2021-01-25 10:47:51
 */
public interface BaseAppOrgPeoplemanagementService {
	
	BaseAppOrgPeoplemanagement queryObject(Integer answerReignNumber);
	
	List<BaseAppOrgPeoplemanagement> queryList(Map<String, Object> map);
	
	void save(BaseAppOrgPeoplemanagement baseAppOrgPeoplemanagement);
	
	void update(BaseAppOrgPeoplemanagement baseAppOrgPeoplemanagement);
	
	void delete(Integer answerReignNumber);
	
	void deleteBatch(Integer[] answerReignNumbers);
}
