package com.css.base.utils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;

/**
 * 分页工具类
 * 
 * @author 中软信息系统工程有限公司
 * @email  
 * @date 2016年11月4日 下午12:59:00
 */
public class ZxPageUtils implements Serializable {
	private static final long serialVersionUID = 1L;
	//总记录数
	private int records;
	//每页记录数
//	private int pageSize;
	//总页数
	private int total;
	//当前页数
	private int page;
	//列表数据
	private List<?> rows;
	
	/**
	 * 分页
	 * @param list        列表数据
	 * @param totalCount  总记录数
	 * @param pageSize    每页记录数
	 * @param currPage    当前页数
	 */
	public ZxPageUtils(List<?> list, int totalCount, int pageSize, int currPage) {
		this.rows = list;
		this.records = totalCount;
//		this.pageSize = pageSize;
		this.page = currPage;
		this.total = (int)Math.ceil((double)totalCount/pageSize);
	}
	public ZxPageUtils(List<?> list){
		if (list instanceof Page) {
			Page<?> page=(Page<?>) list;
			this.rows = page.getResult();
			this.records = (int) page.getTotal();
//		this.pageSize = page.getPageSize();
			this.page = page.getPageNum();
			this.total = (int)Math.ceil((double)records/page.getPageSize());
		}else {
			this.rows = list;
			this.records = list.size();
			this.total = 1;
		}
	}


	
	public int getRecords() {
		return records;
	}
	public void setRecords(int records) {
		this.records = records;
	}
//	public int getPageSize() {
//		return pageSize;
//	}
//	public void setPageSize(int pageSize) {
//		this.pageSize = pageSize;
//	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
}
