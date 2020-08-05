package com.css.app.xlgl.service;

import java.util.List;
import java.util.Map;

import com.css.app.xlgl.entity.TGroupActivePublish;
import com.css.app.xlgl.entity.TGroupApplyRecord;
import com.css.app.xlgl.entity.User;

public interface SportsTrainService {

	void save(Map map);

	void update(Map map);

//	void delete(String act_id);

	List<TGroupActivePublish> sel(int iPage, int iRows);

	List getActivePublishList();

	List<TGroupActivePublish> getPageActivePublishList(String curdate);

	List<TGroupApplyRecord> getPageApplyStatus(String str, String userId);

	List<TGroupApplyRecord> getapplyUserNumList(String str);

	List<TGroupActivePublish> getActiveListByDate(String active_from_day);

	List<TGroupActivePublish> getdayList();

	TGroupApplyRecord getActiveContentData(String actid);

	TGroupApplyRecord getApplyUserNumber(String actid);

	int getUserApplyYN(String userId);

	List<TGroupApplyRecord> getUserApplyList(String actid);

	List<User> selUser(String userid);

	String getOrgName(String orgid);

}
