package com.css.app.xlgl.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.css.app.xlgl.service.SportsTrainService;
import com.css.app.xlgl.dao.SportsTrainDao;
import com.css.app.xlgl.entity.TGroupActivePublish;
import com.css.app.xlgl.entity.TGroupApplyRecord;
import com.css.app.xlgl.entity.User;

@Service("SportsTrainService")
public class SportsTrainServiceImpl implements SportsTrainService {

	@Autowired
	private SportsTrainDao sportsTrainDao;
	
	@Override
	public void save(Map map) {
		// TODO Auto-generated method stub
		sportsTrainDao.save(map);
	}

	@Override
	public void update(Map map) {
		// TODO Auto-generated method stub
		sportsTrainDao.update(map);
	}

//	@Override
//	public void delete(String act_id) {
//		// TODO Auto-generated method stub
//		sportsTrainDao.delete(act_id);
//	}

	@Override
	public List<TGroupActivePublish> sel(int iPage, int iRows) {
		// TODO Auto-generated method stub
		return sportsTrainDao.sel(iPage,iRows);
	}

	@Override
	public List getActivePublishList() {
		// TODO Auto-generated method stub
		return sportsTrainDao.getActivePublishList();
	}

	@Override
	public List<TGroupActivePublish> getPageActivePublishList(String curdate) {
		// TODO Auto-generated method stub
		return sportsTrainDao.getPageActivePublishList(curdate);
	}

	@Override
	public List<TGroupApplyRecord> getPageApplyStatus(String str, String userId) {
		// TODO Auto-generated method stub
		return sportsTrainDao.getPageApplyStatus(str,userId);
	}

	@Override
	public List<TGroupApplyRecord> getapplyUserNumList(String str) {
		// TODO Auto-generated method stub
		return sportsTrainDao.getapplyUserNumList(str);
	}

	@Override
	public List<TGroupActivePublish> getActiveListByDate(String active_from_day) {
		// TODO Auto-generated method stub
		return sportsTrainDao.getActiveListByDate(active_from_day);
	}

	@Override
	public List<TGroupActivePublish> getdayList() {
		// TODO Auto-generated method stub
		return sportsTrainDao.getdayList();
	}

	@Override
	public TGroupApplyRecord getActiveContentData(String actid) {
		// TODO Auto-generated method stub
		return sportsTrainDao.getActiveContentData(actid);
	}

	@Override
	public TGroupApplyRecord getApplyUserNumber(String actid) {
		// TODO Auto-generated method stub
		return sportsTrainDao.getApplyUserNumber(actid);
	}

	@Override
	public int getUserApplyYN(String userId) {
		// TODO Auto-generated method stub
		return sportsTrainDao.getUserApplyYN(userId);
	}

	@Override
	public List<TGroupApplyRecord> getUserApplyList(String actid) {
		// TODO Auto-generated method stub
		return sportsTrainDao.getUserApplyList(actid);
	}

	@Override
	public List<User> selUser(String userid) {
		// TODO Auto-generated method stub
		return sportsTrainDao.selUser(userid);
	}

	@Override
	public String getOrgName(String orgid) {
		// TODO Auto-generated method stub
		return sportsTrainDao.getOrgName(orgid);
	}

}
