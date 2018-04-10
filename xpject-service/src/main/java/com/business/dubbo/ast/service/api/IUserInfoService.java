package com.business.dubbo.ast.service.api;

import com.cxc.entity.user.UArchives;

public interface IUserInfoService {

	/**
	 * 新增/查询接口
	 * @param userid 档案ID
	 * @return star:太阳星座，moon:月亮星座
	 */
	public String queryAddAstInfo(UArchives v);
	
	/**
	 * 修改接口
	 * @param userid 档案ID
	 * @return star:太阳星座，moon:月亮星座
	 */
	public String queryUpdaAstInfo(UArchives v);
	
	public Integer selectByCount(Integer uid,String star,String moon);
	
	public void test();
}
