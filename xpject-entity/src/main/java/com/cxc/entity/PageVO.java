package com.cxc.entity;

public class PageVO {

	/**
	 * 起始
	 */
	private int start;

	/**
	 *  当前页
	 */
	private int curPage;
	
	/**
	 * 每页显示记录数
	 */
	private int limit;

	public PageVO () {
		//默认为每页10条
		this(10);
	}
	
	public PageVO (int limit) {
		setLimit(limit);
	}

	public int getStart() {
		if (0 == curPage) {
			return start;
		} else {
			return (curPage <= 1) ? 0 : ((curPage - 1) * limit);
		}
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getCurPage() {
		return (0 == curPage) ? 1 : curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}
}
