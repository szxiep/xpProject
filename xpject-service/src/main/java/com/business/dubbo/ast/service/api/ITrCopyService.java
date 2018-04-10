package com.business.dubbo.ast.service.api;

import java.util.Date;

import com.alibaba.fastjson.JSONObject;

/**
 * TR文案
 * @author xp
 */
public interface ITrCopyService {

	/**
	 * 根据档案ID删除tr日月年运势文案
	 */
	public void deleByUserid(Integer userid);
	
	/**
	 * 日运
	 * (如果档案ID的信息存在，则只需要传一个档案ID就行了)
	 * @param userid	档案ID	
	 * @param titmeint	年月日
	 * @param naAddress	出生地点
	 * @param naTime	出生时间
	 * @param trAddress	推运地点
	 * @param sex		性别
	 * @return
	 */
	public JSONObject getRiCopy(Integer userid,Integer time ,String naAddress,String naTime,String trAddress,int sex);
	
	/**
	 * 月运
	 * (如果档案ID的信息存在，则只需要传一个档案ID就行了)
	 * @param userid	档案ID	
	 * @param titmeint	年月
	 * @param naAddress	出生地点
	 * @param naTime	出生时间
	 * @param trAddress	推运地点
	 * @param sex		性别
	 * @return
	 */
	public JSONObject getMonyCopy(Integer userid,Date time ,String naAddress,String naTime,String trAddress,int sex);
	
	/**
	 * 年运
	 * (如果档案ID的信息存在，则只需要传一个档案ID就行了)
	 * @param userid	档案ID	
	 * @param year		年份
	 * @param naAddress	出生地点
	 * @param naTime	出生时间
	 * @param trAddress	推运地点
	 * @param sex		性别
	 * @return
	 */
	public JSONObject getYearCopy(Integer userid,Integer time,String naAddress,String naTime,String trAddress,int sex);
	
	/**
	 * 获取上，本，下月新满月，星座等信息
	 * @return
	 */
	public JSONObject getMoyInfo();
	
	/**
	 * 定时更新上本下月信息
	 */
	public void timingMoon();
	
	/**
	 * 缓存规则，文案
	 * 规则id,文案id,文案对象
	 */
	public void cacheMapAll();
	
	/**
	 * 删除所有TR缓存
	 */
	public void deleCache();
	
}
