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
import com.css.base.utils.StringUtils;
import com.css.base.utils.UUIDUtils;

@Service("xlglExamExaminetopicService")
public class XlglExamExaminetopicServiceImpl implements XlglExamExaminetopicService {
	@Autowired
	private XlglExamExaminetopicDao xlglExamExaminetopicDao;
	@Autowired
	private XlglExamTopicService xlglExamTopicService;

	@Override
	public XlglExamExaminetopic queryObject(String id) {
		return xlglExamExaminetopicDao.queryObject(id);
	}

	@Override
	public List<XlglExamExaminetopic> queryList(Map<String, Object> map) {
		return xlglExamExaminetopicDao.queryList(map);
	}

	@Override
	public void save(XlglExamExaminetopic xlglExamExaminetopic) {
		xlglExamExaminetopicDao.save(xlglExamExaminetopic);
	}

	@Override
	public void update(XlglExamExaminetopic xlglExamExaminetopic) {
		xlglExamExaminetopicDao.update(xlglExamExaminetopic);
	}

	@Override
	public void delete(String id) {
		xlglExamExaminetopicDao.delete(id);
	}

	@Override
	public void deleteBatch(String[] ids) {
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
	 * 
	 * @param subjectId
	 *            科目id
	 * @param topicType
	 *            题目类型
	 * @param topicNumber
	 *            题目数量
	 * @param fractionalNumber
	 *            题目分数
	 * 
	 */
	@Override
	public List<XlglExamExaminetopic> randomExtract(Map<String, Object> map, String examineId, String makeUpId) {
		List<XlglExamExaminetopic> list = new ArrayList<XlglExamExaminetopic>();
		List<XlglExamTopic> queryList = xlglExamTopicService.queryList(map);
		Date date = new Date();
		String userId = CurrentUser.getUserId();
		Integer object = Integer.parseInt(map.get("topicNumber").toString());
		if (queryList.size() <= object) {
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
				String fractionalNumber = (String) map.get("fractionalNumber");
				examineTopic.setFractionalNumber(Integer.parseInt(fractionalNumber));
				examineTopic.setCreateDate(date);
				examineTopic.setCreateUser(userId);
				examineTopic.setUpdateDate(date);
				examineTopic.setUpdateUser(userId);
				examineTopic.setPictureColumn(xlglExamTopic.getPictureColumn());
				examineTopic.setPictureOption(xlglExamTopic.getPictureOption());
				examineTopic.setPictureStatus(xlglExamTopic.getPictureStatus());
				if (StringUtils.isNotBlank(makeUpId)) {
					examineTopic.setMakeUpId(makeUpId);
					examineTopic.setMakeUpStatus("1");
				} else {
					examineTopic.setMakeUpStatus("0");
				}
				list.add(examineTopic);
			}
		} else {
			Map<Integer, Object> hashMap = new HashMap<>();
			if(object * 2 < queryList.size()) {
				for (int j = 0; j < 1000000; j++) {
					int random = (int) (Math.random() * queryList.size());
					if (hashMap.size() < object) {
						if (!hashMap.containsKey(random) ) {
							hashMap.put(random, "");
							XlglExamExaminetopic examineTopic = new XlglExamExaminetopic();
							examineTopic.setId(UUIDUtils.random());
							examineTopic.setExamineId(examineId);
							examineTopic.setSubjectId(queryList.get(random).getSubjectId());
							examineTopic.setTopicId(queryList.get(random).getId());
							examineTopic.setTopicType(queryList.get(random).getTopicType());
							examineTopic.setTopicColumn(queryList.get(random).getTopicColumn());
							examineTopic.setTopicOption(queryList.get(random).getTopicOption());
							examineTopic.setTopicResult(queryList.get(random).getTopicResult());
							examineTopic.setPictureStatus(queryList.get(random).getPictureStatus());
							String fractionalNumber = (String) map.get("fractionalNumber");
							examineTopic.setFractionalNumber(Integer.parseInt(fractionalNumber));
							examineTopic.setCreateDate(date);
							examineTopic.setCreateUser(userId);
							examineTopic.setUpdateDate(date);
							examineTopic.setUpdateUser(userId);
							if (StringUtils.isNotBlank(makeUpId)) {
								examineTopic.setMakeUpId(makeUpId);
								examineTopic.setMakeUpStatus("1");
							} else {
								examineTopic.setMakeUpStatus("0");
							}
							list.add(examineTopic);
						}
					} else {
						return list;
				}
			}
			}else {
				for (int i = 0; i < queryList.size(); i++) {
					if (hashMap.size() < object) {
						if (!hashMap.containsKey(i)) {
							hashMap.put(i, "");
							XlglExamExaminetopic examineTopic = new XlglExamExaminetopic();
							examineTopic.setId(UUIDUtils.random());
							examineTopic.setExamineId(examineId);
							examineTopic.setSubjectId(queryList.get(i).getSubjectId());
							examineTopic.setTopicId(queryList.get(i).getId());
							examineTopic.setTopicType(queryList.get(i).getTopicType());
							examineTopic.setTopicColumn(queryList.get(i).getTopicColumn());
							examineTopic.setTopicOption(queryList.get(i).getTopicOption());
							examineTopic.setTopicResult(queryList.get(i).getTopicResult());
							examineTopic.setPictureStatus(queryList.get(i).getPictureStatus());
							String fractionalNumber = (String) map.get("fractionalNumber");
							examineTopic.setFractionalNumber(Integer.parseInt(fractionalNumber));
							examineTopic.setCreateDate(date);
							examineTopic.setCreateUser(userId);
							examineTopic.setUpdateDate(date);
							examineTopic.setUpdateUser(userId);
							if (StringUtils.isNotBlank(makeUpId)) {
								examineTopic.setMakeUpId(makeUpId);
								examineTopic.setMakeUpStatus("1");
							} else {
								examineTopic.setMakeUpStatus("0");
							}
							list.add(examineTopic);
						}
					} else {
						return list;
					}
				}
			
			}
	}
		return list;
}

	@Override
	public void deleteByExamineId(Map<String, Object> map) {
		xlglExamExaminetopicDao.deleteByExamineId(map);

	}

}
