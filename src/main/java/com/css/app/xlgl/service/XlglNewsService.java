package com.css.app.xlgl.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.css.app.xlgl.entity.XlglNews;




public interface XlglNewsService {
	
	XlglNews queryObject(String id);
	
	List<XlglNews> queryList(Map<String, Object> map);
	
	void save(XlglNews xlglNews);
	
	void update(XlglNews xlglNews);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
	
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
	XlglNews queryNowTop();
	
	/**
	 * 查询草稿箱
	 * @param map
	 * @return
	 */
	List<XlglNews> queryDrafts(Map<String, Object> map);
}
