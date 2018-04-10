package com.xp.sys.entity;

/**
 * @author xp
 */
public class BaseEntity {
	
	private transient String orderByClause;	//排序
	private transient Integer offset = 1;			//默认页码
	private transient Integer limit = 10;			//默认记录数
	
	//针对插件用
	private transient Integer page;
	private transient Integer rows;
	
	public String getOrderByClause() {
		return orderByClause;
	}
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}
	public Integer getOffset() {
		return offset;
	}
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		if(null != page && null != rows){
			offset = (page - 1) * rows;
			limit = rows;
		}
		this.rows = rows;
	}		
}