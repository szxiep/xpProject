package com.xp.common.result;

import java.util.Collections;

import org.apache.commons.lang3.StringUtils;

/**
 * 返回的数据模型
 * 
 * @author Administrator
 *
 */
public class ResultValue {
	/**
	 * 返回数据
	 */
	private Object data;

	/**
	 * 操作状态 0 失败 1 成功
	 */
	private int status;

	/**
	 * 返回消息
	 */
	private String msg;
	
	/**
	 * 总记录条数
	 */
	private Long total;


	public Object getData() {
		return (null == data) ? Collections.EMPTY_MAP : data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMsg() {
		return (null == msg) ? StringUtils.EMPTY : msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}
}
