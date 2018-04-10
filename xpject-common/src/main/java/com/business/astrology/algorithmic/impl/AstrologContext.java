package com.business.astrology.algorithmic.impl;

import com.business.astrology.algorithmic.bean.CI;
import com.business.astrology.algorithmic.bean.CP;
import com.business.astrology.algorithmic.bean.Flag;
import com.business.astrology.algorithmic.bean.IS;
import com.business.astrology.algorithmic.bean.Profile;
import com.business.astrology.algorithmic.bean.US;
import com.business.astrology.algorithmic.utils.AstrologyProcedures;
import com.business.astrology.algorithmic.utils.Constants;
import com.business.astrology.algorithmic.utils.MatrixEphemeris;

public class AstrologContext {
	public static final IS is = new IS(Flag.FALSE, Flag.FALSE, Flag.FALSE, Flag.FALSE, Flag.FALSE, Flag.FALSE,
			Flag.FALSE, Flag.FALSE, Flag.FALSE, null, null, null, 0, 0, 0, 0.0, 2441275.0000000000, 0.0, null, 0.71883072890630, 223.52375427890630, 282.48140885337227, 3.8583556965076133,
			0.40915649310245850);
	public static final double[] rObjYear = new double[] { 1.0, 0.0, 27.32166 / Constants.rDayInYear,
			87.969 / Constants.rDayInYear, 224.701 / Constants.rDayInYear, 686.98 / Constants.rDayInYear, 11.8623,
			29.458, 84.01, 164.79, 248.54, 51.0, 4.60, 4.61, 4.36, 3.63, 6792.45 / Constants.rDayInYear,
			6792.45 / Constants.rDayInYear, 699.65 / Constants.rDayInYear, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
			0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 18.58 / Constants.rDayInYear, 94923.63 / Constants.rDayInYear,
			129906.79 / Constants.rDayInYear, 163537.13 / Constants.rDayInYear, 186804.87 / Constants.rDayInYear,
			210470.60 / Constants.rDayInYear, 225232.03 / Constants.rDayInYear, 241643.79 / Constants.rDayInYear,
			271464.37 / Constants.rDayInYear };
	

	/* Restriction status of each object, as specified with -R switch. */
	public static final byte[] ignore = new byte[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, /* Planets */
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, /* Minors */
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, /* Cusps */
			0, 0, 0, 0, 0, 0, 0, 0, /* Uranians */
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, /* Stars */
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

	/* Restriction status of each object, as specified with -R switch. */
	public static final byte[] ignoreACG = new byte[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, /* Planets */
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, /* Minors */
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, /* Cusps */
			0, 0, 0, 0, 0, 0, 0, 0, 0, /* Uranians */
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, /* Stars */
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };


	public Profile profile;
	public Flag fDate;
	public CI ciCore;
	public CI ciMain = new CI(-1, 0, 0, 0.0, 0.0, 0.0, 0.0, 0.0, "", "");
	public US us;
	public CP cp0 = new CP();
	public CP cp1 = new CP();
	public CP cp2 = new CP();
	public CP cp3 = new CP();
	public CP cp4 = new CP();
	
	public double[] spacex = new double[Constants.oNorm + 1];
	public double[] spacey = new double[Constants.oNorm + 1];
	public double[] spacez = new double[Constants.oNorm + 1];
	public double[] force = new double[Constants.objMax];
	public int[] starname = new int[Constants.cStar + 1];
	public int[] kObjA = new int[Constants.objMax];
	public double[] planet = cp0.obj;
	public double[] planetalt = cp0.alt;
	public double[] ret = cp0.dir;
	public double[] chouse = cp0.cusp;
	public int[] inhouse = cp0.house;
	public MatrixEphemeris matrix = null;
	public AstrologyProcedures ap = null;
}
