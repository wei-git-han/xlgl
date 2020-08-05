package com.css.app.xlgl.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.css.app.xlgl.dao.XlglExamExaminetopicDao;
import com.css.app.xlgl.dto.XlglExamExaminetopicDto;
import com.css.app.xlgl.entity.XlglExamExaminetopic;
import com.css.app.xlgl.entity.XlglExamTopic;
import com.css.app.xlgl.service.XlglExamExaminetopicService;
import com.css.app.xlgl.service.XlglExamTopicService;
import com.css.base.utils.CurrentUser;
import com.css.base.utils.UUIDUtils;



@Service("xlglExamExaminetopicService")
public class XlglExamExaminetopicServiceImpl implements XlglExamExaminetopicService {
	@Autowired
	private XlglExamExaminetopicDao xlglExamExaminetopicDao;
	@Autowired
	private XlglExamTopicService xlglExamTopicService;
	
	@Override
	public XlglExamExaminetopic queryObject(String id){
		return xlglExamExaminetopicDao.queryObject(id);
	}
	
	@Override
	public List<XlglExamExaminetopic> queryList(Map<String, Object> map){
		return xlglExamExaminetopicDao.queryList(map);
	}
	
	@Override
	public void save(XlglExamExaminetopic xlglExamExaminetopic){
		xlglExamExaminetopicDao.save(xlglExamExaminetopic);
	}
	
	@Override
	public void update(XlglExamExaminetopic xlglExamExaminetopic){
		xlglExamExaminetopicDao.update(xlglExamExaminetopic);
	}
	
	@Override
	public void delete(String id){
		xlglExamExaminetopicDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		xlglExamExaminetopicDao.deleteBatch(ids);
	}

	@Override
	public void saveBatch(List<XlglExamExaminetopic> list) {
		xlglExamExaminetopicDao.saveBatch(list);
	}

	@Override
	public List<XlglExamExaminetopicDto> findCountBySubjectId(Map<String, Object> map) {
		
		return xlglExamExaminetopicDao.findCountBySubjectId(map);
	}

	@Override
	public List<XlglExamExaminetopic> findListBySubjectId(Map<String, Object> map) {
		return xlglExamExaminetopicDao.findListBySubjectId(map);
	}
	/**
	 * 随机抽取功能
	 * @param subjectId 科目id
	 * @param topicType 题目类型
	 * @param topicNumber 题目数量
	 * @param fractionalNumber 题目分数
	 * 
	 * */
	@Override
	public List<XlglExamExaminetopic> randomExtract(Map<String, Object> map,String examineId) {
		List<XlglExamExaminetopic> list = new ArrayList<XlglExamExaminetopic>();
		List<XlglExamTopic> queryList = xlglExamTopicService.queryList(map);
		Date date = new Date();
		String userId = CurrentUser.getUserId();
		if(queryList.size()<=(int)map.get("topicNumber")) {
			for (XlglExamTopic xlglExamTopic : queryList) {
				XlglExamExaminetopic examineTopic = new XlglExamExaminetopic();
				examineTopic.setId(UUIDUtils.random());
				examineTopic.setExamineId(examineId);
				examineTopic.setSubjectId(xlglExamTopic.getSubjectId());
				examineTopic.setTopicId(xlglExamTopic.getId());
				examineTopic.setTopicType(xlglExamTopic.getTopicType());
				examineTopic.setTopicColumn(xlglExamTopic.getTopicColumn());
				examineTopic.setTopicOption(xlglExamTopic.getTopicOption());
				examineTopic.setTopicResult(xlglExamTopic.getTopicResult());
				examineTopic.setFractionalNumber((int)map.get("fractionalNumber"));
				examineTopic.setCreateDate(date);
				examineTopic.setCreateUser(userId);
				examineTopic.setUpdateDate(date);
				examineTopic.setUpdateUser(userId);
				list.add(examineTopic);
			}
		}else {
			Map<Integer, Object> hashMap = new HashMap<>();
			for (XlglExamTopic xlglExamTopic : queryList) {
				int random = (int)(Math.random() * queryList.size());
				if(hashMap.size()<(int)map.get("topicNumber")) {
					if(!hashMap.containsKey(random)) {
						hashMap.put(random, "");
						XlglExamExaminetopic examineTopic = new XlglExamExaminetopic();
						examineTopic.setId(UUIDUtils.random());
						examineTopic.setExamineId(examineId);
						examineTopic.setSubjectId(xlglExamTopic.getSubjectId());
						examineTopic.setTopicId(xlglExamTopic.getId());
						examineTopic.setTopicType(xlglExamTopic.getTopicType());
						examineTopic.setTopicColumn(xlglExamTopic.getTopicColumn());
						examineTopic.setTopicOption(xlglExamTopic.getTopicOption());
						examineTopic.setTopicResult(xlglExamTopic.getTopicResult());
						examineTopic.setFractionalNumber((int)map.get("fractionalNumber"));
						examineTopic.setCreateDate(date);
						examineTopic.setCreateUser(userId);
						examineTopic.setUpdateDate(date);
						examineTopic.setUpdateUser(userId);
						list.add(examineTopic);
					}
				}else {
					break;
				}
			}
		}
		
		
		return list;
	}

	@Override
	public void deleteByExamineId(String examineId) {
		xlglExamExaminetopicDao.deleteByExamineId(examineId);
		
	}
	
}
