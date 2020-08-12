package com.css.app.xlgl.dao;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;


import com.css.app.xlgl.entity.XlglNotice;
import com.css.base.dao.BaseDao;

/**
 * 训练管理-通知公告表
 * 
 * @author 中软信息系统工程有限公司
 * @email 
 * @date 2020-08-04 13:44:55
 */
@Mapper
public interface XlglNoticeDao extends BaseDao<XlglNotice> {
	List<XlglNotice> queryDrafts(HashMap<String, Object> map);
	/**
	 * 查询本年度发布新闻数
	 * @return
	 */
	int queryTotalYear();
	
	/**
	 * 查询本月发布新闻数
	 * @return
	 */
	int queryTotalMonth();
	
	/**
	 * 查询本周发布新闻数
	 * @return
	 */
	int queryTotalWeek();
	
	/**
	 * 根据局查询本年度发布新闻数
	 * @return
	 */
	List<LinkedHashMap<String, Integer>> queryTotalYearByOrgan();
	
	/**
	 * 根据局查询本月发布新闻数
	 * @return
	 */
	List<LinkedHashMap<String, Integer>> queryTotalMonthByOrgan();
	
	/**
	 * 根据局查询本周发布新闻数
	 * @return
	 */
	List<LinkedHashMap<String, Integer>> queryTotalWeekByOrgan();
	
	/**
	 * 查询目前置顶新闻
	 * @return
	 */
	XlglNotice queryNowTop();
}
