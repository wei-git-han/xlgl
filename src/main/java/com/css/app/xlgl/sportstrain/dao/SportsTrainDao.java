package com.css.app.xlgl.sportstrain.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.css.app.xlgl.sportstrain.entity.TGroupActivePublish;
import com.css.app.xlgl.sportstrain.entity.TGroupApplyRecord;
import com.css.app.xlgl.sportstrain.entity.User;
import com.css.base.dao.BaseDao;

@Mapper
public interface SportsTrainDao {

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
