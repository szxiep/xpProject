package com.cxc.entity;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import com.cxc.annotation.ReturnParam;



/**
 * 分页对象
 * 
 * @author Administrator
 * 
 */
public class PageResult implements Serializable 
{
	private static final long serialVersionUID = 1L;

	/**
	 * 页大小
	 */
	@ReturnParam
	private int pageSize;

	/**
	 * 总记录数
	 */
	@ReturnParam
	private int totalRows;

	/**
	 * 数据
	 */
	@ReturnParam
	private List<?> rows;


	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public List<?> getRows() {
		return (null == rows) ? Collections.EMPTY_LIST : rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

}
