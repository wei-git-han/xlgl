package com.css.app.db.business.service;

import com.css.app.db.business.entity.ReplyAttac;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

/**
 * 办理反馈附件表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2019-04-25 19:07:17
 */
public interface ReplyAttacService {
	
	ReplyAttac queryObject(String id);
	
	List<ReplyAttac> queryList(Map<String, Object> map);
	
	void save(ReplyAttac dbReplyAttac);
	
	void update(ReplyAttac dbReplyAttac);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
	
	void saveAttacs(MultipartFile[] files,String subId,String teamId);
	
	void deleteBySubId(String subId);
}
