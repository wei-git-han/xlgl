package com.css.app.xlgl.service;


import com.css.app.xlgl.dto.XlglConfirmDto;
import com.css.app.xlgl.entity.XlglConfirm;

import java.util.List;
import java.util.Map;

/**
 * 训练管理确认表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-12 17:01:55
 */
public interface XlglConfirmService {
	
	XlglConfirm queryObject(String id);
	
	List<XlglConfirm> queryList(Map<String, Object> map);
	
	void save(XlglConfirm xlglConfirm);
	
	void update(XlglConfirm xlglConfirm);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);

	XlglConfirmDto queryPerDeptInfo(Map<String,Object> map);

	String queryConfromForJu(Map<String,Object> map);
}
