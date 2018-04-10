package com.business.astrology.algorithmic.bean;

import com.business.astrology.algorithmic.utils.Constants;

//排盘数据
public class CP {
	public void clear() {
		// TODO:
	}
	public double[] obj = new double[Constants.objMax]; /* The zodiac positions. */
	public double[] alt = new double[Constants.objMax]; /* Ecliptic declination. */
	public double[] dir = new double[Constants.objMax]; /* Retrogradation velocity. */
	public double[] cusp = new double[Constants.cSign + 1]; /* House cusp positions. */
	public int[] house = new int[Constants.objMax]; /* House each object is in. */
}
