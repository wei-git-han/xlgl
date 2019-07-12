package com.css.app.db.business.service;

import com.css.app.db.business.entity.DocXbInfo;

import java.util.List;
import java.util.Map;

/**
 * 协办人反馈意见表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-07-05 14:56:19
 */
public interface DocXbInfoService {
	
	DocXbInfo queryObject(String id);
	
	List<DocXbInfo> queryList(Map<String, Object> map);
	
	void save(DocXbInfo dbDocXbInfo);
	
	void update(DocXbInfo dbDocXbInfo);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);

	List<DocXbInfo> queryXbRecord(String infoId, String subId, String undertakerId);

	void deleteBySubIdAndReceiverId(String subId, String userId, String ideaGroupId);

	void deleteAllXBRecord(String subId,String ideaGroupId);


}
