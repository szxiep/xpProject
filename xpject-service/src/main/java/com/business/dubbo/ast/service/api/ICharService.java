package com.business.dubbo.ast.service.api;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public interface ICharService {

	// 获取真太阳时，经度纬度
	public JSONObject getInfo(String address, String time);

	/**
	 * 获取经纬度时区
	 * 
	 * @return
	 */
	public JSONObject getlnglat(String address);

	/**
	 * 太阳弧 获取经纬度时区
	 * 
	 * @return
	 */
	public JSONObject getlnglat1(String address, String time);

	/***
	 * 根据时间和经度获取真太阳时
	 * 
	 * @param lng
	 *            经度
	 * @param datetime
	 *            公历时间
	 * @return
	 */
	public JSONObject getsunPing(String lng, String time);

	/**
	 * 星盘数据
	 * 
	 * @return
	 * @throws ParseException
	 */
	public JSONObject getChartData(String time, String zontime, String lng,
			String lat, int sidereal, int gongid, int type);

	/**
	 * acg世界地图
	 * 
	 * @param sidereal
	 *            坐标系统 false-黄道坐标 true-赤道坐标
	 * @param gongid
	 *            宫制 0-Placidus 1-koch 2-house Asc // Sign 3-...
	 * @param zontime
	 *            时区
	 * @param lng
	 *            经度
	 * @param lat
	 *            纬度
	 * @param time
	 *            时间
	 * @return
	 */
	public JSONObject getAcg(int sidereal, int gongid, String zontime,
			String lng, String lat, String time);

	/**
	 * 只排星盘数据
	 * 
	 * @return
	 */
	public Map<String, Object> chartContentData(Calendar cal, String zontime,
			String lng, String lat, int sidereal, int gongid);

	/**
	 * 日返盘
	 * 
	 * @param lngTen
	 *            经度
	 * @param cal
	 *            大约多久
	 * @param zone
	 *            时区
	 * @param lng
	 *            经度
	 * @param lat
	 *            纬度
	 * @param gongid
	 * @param sidereal
	 * @param NAa
	 *            本命太阳度数
	 * @return
	 * @throws ParseException
	 */
	public Map<String, Object> getSunGong(Double lngTen, Calendar cal,
			String zone, String lng, String lat, Integer gongid,
			Integer sidereal, double NAa) throws ParseException;

	/**
	 * 月返盘
	 * 
	 * @param lngTen
	 *            经度
	 * @param cal
	 *            大约多久
	 * @param zone
	 *            时区
	 * @param lng
	 *            经度
	 * @param lat
	 *            纬度
	 * @param gongid
	 * @param sidereal
	 * @param NAb
	 *            本命月亮度数
	 * @return
	 * @throws ParseException
	 */
	public Map<String, Object> MoonGong(Double lngTen, Calendar cal,
			String zone, String lng, String lat, Integer gongid,
			Integer sidereal, double NAb) throws ParseException;
}
