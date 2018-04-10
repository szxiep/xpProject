package com.cxc.entity;

import com.cxc.annotation.ReturnParam;


/**
 * 基础VO
 * @author Administrator
 *ReturnParam.java
 */
public class BaseVO {

	//是否有效 0无效 1有效
	
	private Integer enabled;
	
	//创建人
	//@ReturnParam
	private Integer createdBy;
	
	//创建时间
	@ReturnParam
	private String createdDate;
	
	//更新人
	//@ReturnParam
	private Integer updatedBy;
	
	//更新时间
	@ReturnParam
	private String updatedDate;

	//描述
	@ReturnParam
	private String description;
	
	
	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
}
