package com.business.astrology.algorithmic.api;

import com.business.astrology.algorithmic.bean.WGS84PointF;

/**
 * 星体投影轨迹(Astro Carto Graphy)
 * 
 * @author LQW
 *
 */
public interface IACG {

	/** 获取各星体的天顶坐标 */
	WGS84PointF[] getZeniths();

	/** 获取各星体的天底坐标 */
	WGS84PointF[] getNadirs();

	/** 获取各星体的上升点坐标 */
	WGS84PointF[] getAscs();

	/** 获取各星体的下降点坐标 */
	WGS84PointF[] getDscs();

	/**
	 * 获取各星体的上升曲线点集
	 */
	WGS84PointF[][] getAscSets();

	/**
	 * 获取各星体的下降曲线点集
	 */
	WGS84PointF[][] getDscSets();
}

